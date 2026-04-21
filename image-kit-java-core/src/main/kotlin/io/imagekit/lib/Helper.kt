// Package lib provides helper utilities for ImageKit SDK
// This file contains custom helper functions - not generated

package io.imagekit.lib

import io.imagekit.core.ClientOptions
import io.imagekit.models.SrcOptions
import io.imagekit.models.Transformation
import io.imagekit.models.TransformationPosition
import java.security.SecureRandom
import java.time.Instant
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

/**
 * Helper service containing utility methods for ImageKit SDK operations like URL building,
 * transformation string generation, and authentication parameter generation.
 */
class Helper(private val privateKey: String) : HelperService {

    companion object {
        private const val DEFAULT_TIMESTAMP = 9999999999L

        /**
         * Creates a new Helper instance with the given private key.
         *
         * @param privateKey The private API key from ImageKit dashboard
         * @return A new Helper instance
         */
        @JvmStatic fun create(privateKey: String): Helper = Helper(privateKey)

        /**
         * Creates a new Helper instance from ClientOptions.
         *
         * @param options The client options containing the private key
         * @return A new Helper instance
         */
        @JvmStatic fun create(options: ClientOptions): Helper = Helper(options.privateKey)
    }

    /**
     * Builds a URL with the given options including transformations.
     *
     * @param options The source options for URL generation
     * @return The generated URL string
     */
    override fun buildUrl(options: SrcOptions): String {
        val urlEndpoint = options.urlEndpoint()
        val src = options.src()

        if (src.isEmpty()) {
            return ""
        }

        val transformationPosition =
            options.transformationPosition().orElse(TransformationPosition.QUERY)

        val isAbsoluteURL = src.startsWith("http://") || src.startsWith("https://")

        val urlObj: java.net.URL
        val isSrcParameterUsedForURL: Boolean

        try {
            if (!isAbsoluteURL) {
                urlObj = java.net.URL(urlEndpoint)
                isSrcParameterUsedForURL = false
            } else {
                urlObj = java.net.URL(src)
                isSrcParameterUsedForURL = true
            }
        } catch (e: Exception) {
            return ""
        }

        // Extract existing query parameters from URL if present
        val existingQuery =
            if (isSrcParameterUsedForURL && urlObj.query != null) {
                urlObj.query
            } else {
                ""
            }

        // Build query parameters
        val queryParts = mutableListOf<String>()

        // Add existing query parameters first
        if (existingQuery.isNotEmpty()) {
            queryParts.add(existingQuery)
        }

        // Add new query parameters (sorted alphabetically for consistent signing)
        options.queryParameters().ifPresent { queryParams ->
            val params = queryParams._additionalProperties()
            if (params.isNotEmpty()) {
                val newQuery =
                    params.entries
                        .sortedBy { it.key } // Sort alphabetically by key
                        .joinToString("&") { (key, value) ->
                            val valueStr =
                                value.asString().orElseGet {
                                    value
                                        .asNumber()
                                        .map { it.toString() }
                                        .orElseGet {
                                            value
                                                .asBoolean()
                                                .map { it.toString() }
                                                .orElse(value.toString())
                                        }
                                }
                            "${java.net.URLEncoder.encode(key, "UTF-8")}=${java.net.URLEncoder.encode(valueStr, "UTF-8")}"
                        }
                queryParts.add(newQuery)
            }
        }

        val query = queryParts.joinToString("&")

        // Build transformation string
        val transformationString =
            options.transformation().map { buildTransformationString(it) }.orElse("")

        // Determine if transformation will be in query params
        val addAsQuery =
            transformationPosition == TransformationPosition.QUERY || isSrcParameterUsedForURL

        // Transformation placeholder to avoid URL encoding issues
        val transformationPlaceholder = "PLEASEREPLACEJUSTBEFORESIGN"

        // Build the URL path
        var path = ""
        if (!isAbsoluteURL) {
            // For non-absolute URLs, construct: endpoint_path + transformations + src
            val endpointPath = urlObj.path.ifEmpty { "/" }
            val pathParts = mutableListOf<String>()
            pathParts.add(endpointPath)

            if (transformationString.isNotEmpty() && !addAsQuery) {
                pathParts.add("tr:$transformationPlaceholder")
            }
            pathParts.add(src)

            path = pathParts.joinToString("/") { it.trim('/') }.replace(Regex("/+"), "/")
            if (!path.startsWith("/")) {
                path = "/$path"
            }
        } else {
            path = urlObj.path
        }

        // Build the complete URL using URI to properly encode the path
        val uriString =
            try {
                java.net
                    .URI(
                        urlObj.protocol,
                        null, // user info
                        urlObj.host,
                        if (urlObj.port != -1 && urlObj.port != urlObj.defaultPort) urlObj.port
                        else -1,
                        path,
                        null, // query will be added later
                        null, // fragment
                    )
                    .toASCIIString()
            } catch (e: Exception) {
                // Fallback to manual construction
                "${urlObj.protocol}://${urlObj.host}${if (urlObj.port != -1 && urlObj.port != urlObj.defaultPort) ":${urlObj.port}" else ""}$path"
            }

        var finalURL = uriString

        // Add query parameters
        if (query.isNotEmpty()) {
            finalURL += "?$query"
        }

        // Add transformation parameter to query if needed
        if (transformationString.isNotEmpty() && addAsQuery) {
            val separator = if (query.isEmpty()) "?" else "&"
            finalURL += "${separator}tr=$transformationPlaceholder"
        }

        // Replace the placeholder with actual transformation string
        if (transformationString.isNotEmpty()) {
            finalURL = finalURL.replace(transformationPlaceholder, transformationString)
        }

        // Sign the URL if needed
        val shouldSign = options.signed().orElse(false) || (options.expiresIn().orElse(0.0) > 0)
        if (shouldSign) {
            val expiryTimestamp = getSignatureTimestamp(options.expiresIn().orElse(0.0))
            val urlSignature = getSignature(finalURL, urlEndpoint, expiryTimestamp)

            val hasExistingParams = finalURL.contains("?")
            val separator = if (hasExistingParams) "&" else "?"

            if (expiryTimestamp != DEFAULT_TIMESTAMP) {
                finalURL += "${separator}ik-t=$expiryTimestamp&ik-s=$urlSignature"
            } else {
                finalURL += "${separator}ik-s=$urlSignature"
            }
        }

        return finalURL
    }

    private fun getSignatureTimestamp(expiresIn: Double): Long {
        return if (expiresIn > 0) {
            Instant.now().epochSecond + expiresIn.toLong()
        } else {
            DEFAULT_TIMESTAMP
        }
    }

    private fun getSignature(finalURL: String, urlEndpoint: String, expiryTimestamp: Long): String {
        if (privateKey.isEmpty() || finalURL.isEmpty() || urlEndpoint.isEmpty()) {
            return ""
        }

        // Create the string to sign: relative path + expiry timestamp
        val urlEndpointWithSlash = if (urlEndpoint.endsWith("/")) urlEndpoint else "$urlEndpoint/"
        val stringToSign =
            finalURL.replaceFirst(urlEndpointWithSlash, "") + expiryTimestamp.toString()

        val mac = Mac.getInstance("HmacSHA1")
        val secretKey = SecretKeySpec(privateKey.toByteArray(), "HmacSHA1")
        mac.init(secretKey)
        val hash = mac.doFinal(stringToSign.toByteArray())

        return hash.joinToString("") { "%02x".format(it) }
    }

    /**
     * Builds a transformation string from the given transformations.
     *
     * @param transformations The list of transformations
     * @return The transformation string
     */
    override fun buildTransformationString(transformations: List<Transformation>?): String {
        if (transformations.isNullOrEmpty()) {
            return ""
        }

        val parsedTransforms = mutableListOf<String>()

        for (transform in transformations) {
            val parts = mutableListOf<String>()

            // Basic transformations (in order from Go SDK)

            // Width
            transform.width().ifPresent { w ->
                when {
                    w.isNumber() -> parts.add("w-${formatNumber(w.asNumber())}")
                    w.isString() -> parts.add("w-${w.asString()}")
                }
            }

            // Height
            transform.height().ifPresent { h ->
                when {
                    h.isNumber() -> parts.add("h-${formatNumber(h.asNumber())}")
                    h.isString() -> parts.add("h-${h.asString()}")
                }
            }

            // Quality
            transform.quality().ifPresent { q -> parts.add("q-${formatNumber(q)}") }

            // Aspect Ratio
            transform.aspectRatio().ifPresent { ar ->
                when {
                    ar.isNumber() -> parts.add("ar-${formatNumber(ar.asNumber())}")
                    ar.isString() -> parts.add("ar-${ar.asString()}")
                }
            }

            // Crop
            transform.crop().ifPresent { c -> if (c.toString().isNotEmpty()) parts.add("c-$c") }

            // Crop Mode
            transform.cropMode().ifPresent { cm ->
                if (cm.toString().isNotEmpty()) parts.add("cm-$cm")
            }

            // Focus
            transform.focus().ifPresent { fo -> parts.add("fo-$fo") }

            // Format
            transform.format().ifPresent { f -> if (f.toString().isNotEmpty()) parts.add("f-$f") }

            // Radius
            transform.radius().ifPresent { r ->
                when {
                    r.isMax() -> parts.add("r-max")
                    r.isNumber() -> parts.add("r-${formatNumber(r.asNumber())}")
                    r.isString() -> parts.add("r-${r.asString()}")
                }
            }

            // Background
            transform.background().ifPresent { bg -> parts.add("bg-$bg") }

            // Border
            transform.border().ifPresent { b -> parts.add("b-$b") }

            // Color Replace
            transform.colorReplace().ifPresent { cr -> parts.add("cr-$cr") }

            // Default Image
            transform.defaultImage().ifPresent { di ->
                if (di.isNotEmpty()) {
                    val value = di.removePrefix("/").removeSuffix("/").replace("/", "@@")
                    parts.add("di-$value")
                }
            }

            // DPR
            transform.dpr().ifPresent { dpr -> parts.add("dpr-${formatNumber(dpr)}") }

            // X position
            transform.x().ifPresent { x ->
                when {
                    x.isNumber() -> parts.add("x-${formatNumber(x.asNumber())}")
                    x.isString() -> parts.add("x-${x.asString()}")
                }
            }

            // Y position
            transform.y().ifPresent { y ->
                when {
                    y.isNumber() -> parts.add("y-${formatNumber(y.asNumber())}")
                    y.isString() -> parts.add("y-${y.asString()}")
                }
            }

            // X Center
            transform.xCenter().ifPresent { xc ->
                when {
                    xc.isNumber() -> parts.add("xc-${formatNumber(xc.asNumber())}")
                    xc.isString() -> parts.add("xc-${xc.asString()}")
                }
            }

            // Y Center
            transform.yCenter().ifPresent { yc ->
                when {
                    yc.isNumber() -> parts.add("yc-${formatNumber(yc.asNumber())}")
                    yc.isString() -> parts.add("yc-${yc.asString()}")
                }
            }

            // Opacity
            transform.opacity().ifPresent { o -> parts.add("o-${formatNumber(o)}") }

            // Zoom
            transform.zoom().ifPresent { z -> parts.add("z-${formatNumber(z)}") }

            // Rotation
            transform.rotation().ifPresent { rt ->
                when {
                    rt.isNumber() -> parts.add("rt-${formatNumber(rt.asNumber())}")
                    rt.isString() -> parts.add("rt-${rt.asString()}")
                }
            }

            // Blur
            transform.blur().ifPresent { bl -> parts.add("bl-${formatNumber(bl)}") }

            // Named
            transform.named().ifPresent { n -> parts.add("n-$n") }

            // Progressive
            transform.progressive().ifPresent { pr -> parts.add("pr-$pr") }

            // Lossless
            transform.lossless().ifPresent { lo -> parts.add("lo-$lo") }

            // Flip
            transform.flip().ifPresent { fl -> if (fl.toString().isNotEmpty()) parts.add("fl-$fl") }

            // Trim
            transform.trim().ifPresent { t ->
                when {
                    t.isTrue() -> parts.add("t-true")
                    t.isNumber() -> parts.add("t-${formatNumber(t.asNumber())}")
                }
            }

            // Metadata
            transform.metadata().ifPresent { md -> parts.add("md-$md") }

            // Color Profile
            transform.colorProfile().ifPresent { cp -> parts.add("cp-$cp") }

            // Video Codec
            transform.videoCodec().ifPresent { vc ->
                if (vc.toString().isNotEmpty()) parts.add("vc-$vc")
            }

            // Audio Codec
            transform.audioCodec().ifPresent { ac ->
                if (ac.toString().isNotEmpty()) parts.add("ac-$ac")
            }

            // Start Offset
            transform.startOffset().ifPresent { so ->
                when {
                    so.isNumber() -> parts.add("so-${formatNumber(so.asNumber())}")
                    so.isString() -> parts.add("so-${so.asString()}")
                }
            }

            // End Offset
            transform.endOffset().ifPresent { eo ->
                when {
                    eo.isNumber() -> parts.add("eo-${formatNumber(eo.asNumber())}")
                    eo.isString() -> parts.add("eo-${eo.asString()}")
                }
            }

            // Duration
            transform.duration().ifPresent { du ->
                when {
                    du.isNumber() -> parts.add("du-${formatNumber(du.asNumber())}")
                    du.isString() -> parts.add("du-${du.asString()}")
                }
            }

            // Streaming Resolutions
            transform.streamingResolutions().ifPresent { resolutions ->
                if (resolutions.isNotEmpty()) {
                    val sr = resolutions.joinToString("_")
                    parts.add("sr-$sr")
                }
            }

            // AI transformations (boolean flags)
            transform.grayscale().ifPresent { gs -> if (gs.asBoolean()) parts.add("e-grayscale") }
            transform.aiUpscale().ifPresent { au -> if (au.asBoolean()) parts.add("e-upscale") }
            transform.aiRetouch().ifPresent { ar -> if (ar.asBoolean()) parts.add("e-retouch") }
            transform.aiVariation().ifPresent { av -> if (av.asBoolean()) parts.add("e-genvar") }
            transform.aiRemoveBackground().ifPresent { rb ->
                if (rb.asBoolean()) parts.add("e-bgremove")
            }
            transform.aiRemoveBackgroundExternal().ifPresent { re ->
                if (re.asBoolean()) parts.add("e-removedotbg")
            }
            transform.contrastStretch().ifPresent { cs ->
                if (cs.asBoolean()) parts.add("e-contrast")
            }

            // AI Drop Shadow
            transform.aiDropShadow().ifPresent { ds ->
                when {
                    ds.isTrue() -> parts.add("e-dropshadow")
                    ds.isString() -> parts.add("e-dropshadow-${ds.asString()}")
                }
            }

            // AI Change Background
            transform.aiChangeBackground().ifPresent { bg -> parts.add("e-changebg-$bg") }

            // AI Edit
            transform.aiEdit().ifPresent { edit -> parts.add("e-edit-$edit") }

            // Effects
            transform.shadow().ifPresent { s ->
                when {
                    s.isTrue() -> parts.add("e-shadow")
                    s.isString() -> parts.add("e-shadow-${s.asString()}")
                }
            }

            transform.sharpen().ifPresent { sh ->
                when {
                    sh.isTrue() -> parts.add("e-sharpen")
                    sh.isNumber() -> parts.add("e-sharpen-${formatNumber(sh.asNumber())}")
                }
            }

            transform.unsharpMask().ifPresent { usm ->
                when {
                    usm.isTrue() -> parts.add("e-usm")
                    usm.isString() -> parts.add("e-usm-${usm.asString()}")
                }
            }

            transform.gradient().ifPresent { gr ->
                when {
                    gr.isTrue() -> parts.add("e-gradient")
                    gr.isString() -> parts.add("e-gradient-${gr.asString()}")
                }
            }

            transform.distort().ifPresent { d -> parts.add("e-distort-$d") }

            // Original
            transform.original().ifPresent { orig -> if (orig) parts.add("orig-true") }

            // Page
            transform.page().ifPresent { pg ->
                when {
                    pg.isNumber() -> parts.add("pg-${formatNumber(pg.asNumber())}")
                    pg.isString() -> parts.add("pg-${pg.asString()}")
                }
            }

            // Overlay
            transform.overlay().ifPresent { overlay ->
                val overlayStr = processOverlay(overlay)
                if (overlayStr.isNotEmpty()) {
                    parts.add(overlayStr)
                }
            }

            // Raw parameter (added last)
            transform.raw().ifPresent { raw ->
                if (raw.isNotEmpty()) {
                    parts.add(raw)
                }
            }

            if (parts.isNotEmpty()) {
                parsedTransforms.add(parts.joinToString(","))
            }
        }

        return parsedTransforms.joinToString(":")
    }

    private fun formatNumber(value: Double): String {
        return if (value == value.toLong().toDouble()) {
            value.toLong().toString()
        } else {
            value.toString()
        }
    }

    private val simpleOverlayPathRegex = Regex("^[a-zA-Z0-9\\-._/ ]*$")
    private val simpleOverlayTextRegex = Regex("^[a-zA-Z0-9\\-._  ]*$")

    private fun processOverlay(overlay: io.imagekit.models.Overlay): String {
        val entries = mutableListOf<String>()
        var transformationString = ""

        // Each branch: add layer type + input, extract base overlay fields, build transformation
        // string
        var layerMode: String? = null
        var position: io.imagekit.models.OverlayPosition? = null
        var timing: io.imagekit.models.OverlayTiming? = null

        when {
            overlay.isText() -> {
                val textOverlay = overlay.asText()
                if (textOverlay.text().isEmpty()) return ""

                val encoding =
                    textOverlay.encoding().orElse(null)?.toString()?.lowercase() ?: "auto"
                entries.add("l-text")
                entries.add(processText(textOverlay.text(), encoding))

                textOverlay.layerMode().ifPresent { layerMode = it.toString().lowercase() }
                textOverlay.position().ifPresent { position = it }
                textOverlay.timing().ifPresent { timing = it }

                textOverlay.transformation().ifPresent { transformations ->
                    if (transformations.isNotEmpty()) {
                        transformationString = buildTextOverlayTransformation(transformations)
                    }
                }
            }

            overlay.isImage() -> {
                val imageOverlay = overlay.asImage()
                if (imageOverlay.input().isEmpty()) return ""

                val encoding =
                    imageOverlay.encoding().orElse(null)?.toString()?.lowercase() ?: "auto"
                entries.add("l-image")
                entries.add(processInputPath(imageOverlay.input(), encoding))

                imageOverlay.layerMode().ifPresent { layerMode = it.toString().lowercase() }
                imageOverlay.position().ifPresent { position = it }
                imageOverlay.timing().ifPresent { timing = it }

                imageOverlay.transformation().ifPresent { transformations ->
                    if (transformations.isNotEmpty()) {
                        transformationString = buildTransformationString(transformations)
                    }
                }
            }

            overlay.isVideo() -> {
                val videoOverlay = overlay.asVideo()
                if (videoOverlay.input().isEmpty()) return ""

                val encoding =
                    videoOverlay.encoding().orElse(null)?.toString()?.lowercase() ?: "auto"
                entries.add("l-video")
                entries.add(processInputPath(videoOverlay.input(), encoding))

                videoOverlay.layerMode().ifPresent { layerMode = it.toString().lowercase() }
                videoOverlay.position().ifPresent { position = it }
                videoOverlay.timing().ifPresent { timing = it }

                videoOverlay.transformation().ifPresent { transformations ->
                    if (transformations.isNotEmpty()) {
                        transformationString = buildTransformationString(transformations)
                    }
                }
            }

            overlay.isSubtitle() -> {
                val subtitleOverlay = overlay.asSubtitle()
                if (subtitleOverlay.input().isEmpty()) return ""

                val encoding =
                    subtitleOverlay.encoding().orElse(null)?.toString()?.lowercase() ?: "auto"
                entries.add("l-subtitles")
                entries.add(processInputPath(subtitleOverlay.input(), encoding))

                subtitleOverlay.layerMode().ifPresent { layerMode = it.toString().lowercase() }
                subtitleOverlay.position().ifPresent { position = it }
                subtitleOverlay.timing().ifPresent { timing = it }

                subtitleOverlay.transformation().ifPresent { transformations ->
                    if (transformations.isNotEmpty()) {
                        transformationString = buildSubtitleOverlayTransformation(transformations)
                    }
                }
            }

            overlay.isSolidColor() -> {
                val solidColorOverlay = overlay.asSolidColor()
                if (solidColorOverlay.color().isEmpty()) return ""

                entries.add("l-image")
                entries.add("i-ik_canvas")
                entries.add("bg-${solidColorOverlay.color()}")

                solidColorOverlay.layerMode().ifPresent { layerMode = it.toString().lowercase() }
                solidColorOverlay.position().ifPresent { position = it }
                solidColorOverlay.timing().ifPresent { timing = it }

                solidColorOverlay.transformation().ifPresent { transformations ->
                    if (transformations.isNotEmpty()) {
                        transformationString = buildSolidColorOverlayTransformation(transformations)
                    }
                }
            }
        }

        if (entries.isEmpty()) return ""

        // Shared base overlay processing (matches Go's order)
        // LayerMode
        if (!layerMode.isNullOrEmpty()) {
            entries.add("lm-$layerMode")
        }

        // Position
        if (position != null) {
            processOverlayPosition(position!!, entries)
        }

        // Timing
        if (timing != null) {
            processOverlayTiming(timing!!, entries)
        }

        // Transformation string
        if (transformationString.isNotEmpty()) {
            entries.add(transformationString)
        }

        // Close layer
        entries.add("l-end")
        return entries.joinToString(",")
    }

    private fun processInputPath(str: String, encoding: String): String {
        val cleaned = str.removePrefix("/").removeSuffix("/")

        if (encoding == "plain") {
            return "i-${cleaned.replace("/", "@@")}"
        }

        if (encoding == "base64") {
            val base64 = java.util.Base64.getEncoder().encodeToString(cleaned.toByteArray())
            return "ie-${java.net.URLEncoder.encode(base64, "UTF-8")}"
        }

        // Auto-detect
        if (simpleOverlayPathRegex.matches(cleaned)) {
            return "i-${cleaned.replace("/", "@@")}"
        }

        val base64 = java.util.Base64.getEncoder().encodeToString(cleaned.toByteArray())
        return "ie-${java.net.URLEncoder.encode(base64, "UTF-8")}"
    }

    private fun processText(str: String, encoding: String): String {
        if (encoding == "plain") {
            return "i-${pathEscape(str)}"
        }

        if (encoding == "base64") {
            val base64 = java.util.Base64.getEncoder().encodeToString(str.toByteArray())
            return "ie-${java.net.URLEncoder.encode(base64, "UTF-8")}"
        }

        // Auto-detect
        if (simpleOverlayTextRegex.matches(str)) {
            return "i-${pathEscape(str)}"
        }

        val base64 = java.util.Base64.getEncoder().encodeToString(str.toByteArray())
        return "ie-${java.net.URLEncoder.encode(base64, "UTF-8")}"
    }

    /** Equivalent to Go's url.PathEscape — encodes for use in URL path segments */
    private fun pathEscape(str: String): String {
        return java.net.URI(null, null, "/$str", null).toASCIIString().removePrefix("/")
    }

    private fun buildTextOverlayTransformation(
        transformations: List<io.imagekit.models.TextOverlayTransformation>
    ): String {
        val entries = mutableListOf<String>()
        for (transform in transformations) {
            processTextOverlayTransformation(transform, entries)
        }
        return entries.joinToString(",")
    }

    private fun buildSubtitleOverlayTransformation(
        transformations: List<io.imagekit.models.SubtitleOverlayTransformation>
    ): String {
        val entries = mutableListOf<String>()
        for (transform in transformations) {
            processSubtitleOverlayTransformation(transform, entries)
        }
        return entries.joinToString(",")
    }

    private fun buildSolidColorOverlayTransformation(
        transformations: List<io.imagekit.models.SolidColorOverlayTransformation>
    ): String {
        val entries = mutableListOf<String>()
        for (transform in transformations) {
            processSolidColorOverlayTransformation(transform, entries)
        }
        return entries.joinToString(",")
    }

    private fun processTextOverlayTransformation(
        transform: io.imagekit.models.TextOverlayTransformation,
        parts: MutableList<String>,
    ) {
        transform.width().ifPresent { w ->
            when {
                w.isNumber() -> parts.add("w-${formatNumber(w.asNumber())}")
                w.isString() -> parts.add("w-${w.asString()}")
            }
        }
        transform.fontSize().ifPresent { fs ->
            when {
                fs.isNumber() -> parts.add("fs-${formatNumber(fs.asNumber())}")
                fs.isString() -> parts.add("fs-${fs.asString()}")
            }
        }
        transform.fontFamily().ifPresent { ff ->
            val cleaned = ff.removePrefix("/").removeSuffix("/").replace("/", "@@")
            parts.add("ff-$cleaned")
        }
        transform.fontColor().ifPresent { fc -> parts.add("co-$fc") }
        transform.innerAlignment().ifPresent { ia -> parts.add("ia-${ia.toString().lowercase()}") }
        transform.padding().ifPresent { p ->
            when {
                p.isNumber() -> parts.add("pa-${formatNumber(p.asNumber())}")
                p.isString() -> parts.add("pa-${p.asString()}")
            }
        }
        transform.alpha().ifPresent { a -> parts.add("al-${formatNumber(a)}") }
        transform.typography().ifPresent { t -> parts.add("tg-$t") }
        transform.background().ifPresent { bg -> parts.add("bg-$bg") }
        transform.radius().ifPresent { r ->
            when {
                r.isMax() -> parts.add("r-max")
                r.isNumber() -> parts.add("r-${formatNumber(r.asNumber())}")
                r.isString() -> parts.add("r-${r.asString()}")
            }
        }
        transform.rotation().ifPresent { rt ->
            when {
                rt.isNumber() -> parts.add("rt-${formatNumber(rt.asNumber())}")
                rt.isString() -> parts.add("rt-${rt.asString()}")
            }
        }
        transform.flip().ifPresent { fl -> parts.add("fl-${fl.toString().lowercase()}") }
        transform.lineHeight().ifPresent { lh ->
            when {
                lh.isNumber() -> parts.add("lh-${formatNumber(lh.asNumber())}")
                lh.isString() -> parts.add("lh-${lh.asString()}")
            }
        }
    }

    private fun processSolidColorOverlayTransformation(
        transform: io.imagekit.models.SolidColorOverlayTransformation,
        parts: MutableList<String>,
    ) {
        transform.width().ifPresent { w ->
            when {
                w.isNumber() -> parts.add("w-${formatNumber(w.asNumber())}")
                w.isString() -> parts.add("w-${w.asString()}")
            }
        }
        transform.height().ifPresent { h ->
            when {
                h.isNumber() -> parts.add("h-${formatNumber(h.asNumber())}")
                h.isString() -> parts.add("h-${h.asString()}")
            }
        }
        transform.alpha().ifPresent { a -> parts.add("al-${formatNumber(a)}") }
        transform.background().ifPresent { bg -> parts.add("bg-$bg") }
        transform.gradient().ifPresent { g ->
            when {
                g.isTrue() -> parts.add("e-gradient")
                g.isString() -> parts.add("e-gradient-${g.asString()}")
            }
        }
        transform.radius().ifPresent { r ->
            when {
                r.isMax() -> parts.add("r-max")
                r.isNumber() -> parts.add("r-${formatNumber(r.asNumber())}")
                r.isString() -> parts.add("r-${r.asString()}")
            }
        }
    }

    private fun processSubtitleOverlayTransformation(
        transform: io.imagekit.models.SubtitleOverlayTransformation,
        parts: MutableList<String>,
    ) {
        transform.background().ifPresent { bg -> parts.add("bg-$bg") }
        transform.color().ifPresent { c -> parts.add("co-$c") }
        transform.fontSize().ifPresent { fs -> parts.add("fs-${formatNumber(fs)}") }
        transform.fontFamily().ifPresent { ff -> parts.add("ff-$ff") }
        transform.fontOutline().ifPresent { fo -> parts.add("fol-$fo") }
        transform.fontShadow().ifPresent { fs -> parts.add("fsh-$fs") }
        transform.typography().ifPresent { tg -> parts.add("tg-$tg") }
    }

    private fun processOverlayPosition(
        position: io.imagekit.models.OverlayPosition,
        parts: MutableList<String>,
    ) {
        position.x().ifPresent { x ->
            when {
                x.isNumber() -> parts.add("lx-${formatNumber(x.asNumber())}")
                x.isString() -> parts.add("lx-${x.asString()}")
            }
        }
        position.y().ifPresent { y ->
            when {
                y.isNumber() -> parts.add("ly-${formatNumber(y.asNumber())}")
                y.isString() -> parts.add("ly-${y.asString()}")
            }
        }
        position.xCenter().ifPresent { xc ->
            when {
                xc.isNumber() -> parts.add("lxc-${formatNumber(xc.asNumber())}")
                xc.isString() -> parts.add("lxc-${xc.asString()}")
            }
        }
        position.yCenter().ifPresent { yc ->
            when {
                yc.isNumber() -> parts.add("lyc-${formatNumber(yc.asNumber())}")
                yc.isString() -> parts.add("lyc-${yc.asString()}")
            }
        }
        position.anchorPoint().ifPresent { ap -> parts.add("lap-${ap.toString().lowercase()}") }
        position.focus().ifPresent { f -> parts.add("lfo-${f.toString().lowercase()}") }
    }

    private fun processOverlayTiming(
        timing: io.imagekit.models.OverlayTiming,
        parts: MutableList<String>,
    ) {
        timing.start().ifPresent { s ->
            when {
                s.isNumber() -> parts.add("lso-${formatNumber(s.asNumber())}")
                s.isString() -> parts.add("lso-${s.asString()}")
            }
        }
        timing.end().ifPresent { e ->
            when {
                e.isNumber() -> parts.add("leo-${formatNumber(e.asNumber())}")
                e.isString() -> parts.add("leo-${e.asString()}")
            }
        }
        timing.duration().ifPresent { d ->
            when {
                d.isNumber() -> parts.add("ldu-${formatNumber(d.asNumber())}")
                d.isString() -> parts.add("ldu-${d.asString()}")
            }
        }
    }

    /**
     * Generates authentication parameters for client-side file uploads.
     *
     * @param token Optional custom token. If null or empty, a random token will be generated.
     * @param expire Optional expiration timestamp in seconds. If 0 or null, defaults to 30 minutes
     *   from now.
     * @return Map containing token, expire, and signature
     */
    override fun getAuthenticationParameters(token: String?, expire: Long?): Map<String, Any> {
        if (privateKey.isEmpty()) {
            throw IllegalStateException(
                "private API key is required for authentication parameters generation"
            )
        }

        val defaultExpire = Instant.now().epochSecond + (60 * 30) // 30 minutes
        val finalToken =
            if (token.isNullOrEmpty()) {
                generateToken()
            } else {
                token
            }

        val finalExpire =
            if (expire == null || expire == 0L) {
                defaultExpire
            } else {
                expire
            }

        val signature = getAuthenticationSignature(finalToken, finalExpire, privateKey)

        return mapOf("token" to finalToken, "expire" to finalExpire, "signature" to signature)
    }

    // Private helper methods

    private fun getAuthenticationSignature(
        token: String,
        expire: Long,
        privateKey: String,
    ): String {
        val signatureString = "$token$expire"
        val mac = Mac.getInstance("HmacSHA1")
        val secretKey = SecretKeySpec(privateKey.toByteArray(), "HmacSHA1")
        mac.init(secretKey)
        val hash = mac.doFinal(signatureString.toByteArray())

        return hash.joinToString("") { "%02x".format(it) }
    }

    private fun generateToken(): String {
        val random = SecureRandom()
        val bytes = ByteArray(16)
        random.nextBytes(bytes)
        return bytes.joinToString("") { "%02x".format(it) }
    }
}
