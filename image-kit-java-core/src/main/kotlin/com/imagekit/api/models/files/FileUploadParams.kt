// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.BaseDeserializer
import com.imagekit.api.core.BaseSerializer
import com.imagekit.api.core.Enum
import com.imagekit.api.core.ExcludeMissing
import com.imagekit.api.core.JsonField
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.MultipartField
import com.imagekit.api.core.Params
import com.imagekit.api.core.allMaxBy
import com.imagekit.api.core.checkKnown
import com.imagekit.api.core.checkRequired
import com.imagekit.api.core.getOrThrow
import com.imagekit.api.core.http.Headers
import com.imagekit.api.core.http.QueryParams
import com.imagekit.api.core.toImmutable
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.io.InputStream
import java.nio.file.Path
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.io.path.inputStream
import kotlin.io.path.name
import kotlin.jvm.optionals.getOrNull

/**
 * ImageKit.io allows you to upload files directly from both the server and client sides. For
 * server-side uploads, private API key authentication is used. For client-side uploads, generate a
 * one-time `token`, `signature`, and `expire` from your secure backend using private API.
 * [Learn more](/docs/api-reference/upload-file/upload-file#how-to-implement-client-side-file-upload)
 * about how to implement client-side file upload.
 *
 * The [V2 API](/docs/api-reference/upload-file/upload-file-v2) enhances security by verifying the
 * entire payload using JWT.
 *
 * **File size limit** \ On the free plan, the maximum upload file sizes are 20MB for images, audio,
 * and raw files and 100MB for videos. On the paid plan, these limits increase to 40MB for images,
 * audio, and raw files and 2GB for videos. These limits can be further increased with higher-tier
 * plans.
 *
 * **Version limit** \ A file can have a maximum of 100 versions.
 *
 * **Demo applications**
 * - A full-fledged [upload widget using Uppy](https://github.com/imagekit-samples/uppy-uploader),
 *   supporting file selections from local storage, URL, Dropbox, Google Drive, Instagram, and more.
 * - [Quick start guides](/docs/quick-start-guides) for various frameworks and technologies.
 */
class FileUploadParams
private constructor(
    private val body: MultipartField<Body>,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun body(): Optional<Body> = body.value.getOptional("body")

    /**
     * Returns the raw multipart value of [body].
     *
     * Unlike [body], this method doesn't throw if the multipart field has an unexpected type.
     */
    @JsonProperty("body") @ExcludeMissing fun _body(): MultipartField<Body> = body

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): FileUploadParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [FileUploadParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileUploadParams]. */
    class Builder internal constructor() {

        private var body: MultipartField<Body> = MultipartField.of(null)
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(fileUploadParams: FileUploadParams) = apply {
            body = fileUploadParams.body
            additionalHeaders = fileUploadParams.additionalHeaders.toBuilder()
            additionalQueryParams = fileUploadParams.additionalQueryParams.toBuilder()
        }

        fun body(body: Body) =
            body(
                MultipartField.builder<Body>()
                    .value(body)
                    .contentType("application/octet-stream")
                    .build()
            )

        /**
         * Sets [Builder.body] to an arbitrary multipart value.
         *
         * You should usually call [Builder.body] with a well-typed [Body] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun body(body: MultipartField<Body>) = apply { this.body = body }

        /** Alias for calling [body] with `Body.ofFileUploadV1(fileUploadV1)`. */
        fun body(fileUploadV1: Body.FileUploadV1) = body(Body.ofFileUploadV1(fileUploadV1))

        /** Alias for calling [body] with `Body.ofFileUploadByUrlv1(fileUploadByUrlv1)`. */
        fun body(fileUploadByUrlv1: Body.FileUploadByUrlv1) =
            body(Body.ofFileUploadByUrlv1(fileUploadByUrlv1))

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [FileUploadParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): FileUploadParams =
            FileUploadParams(body, additionalHeaders.build(), additionalQueryParams.build())
    }

    fun _body(): Map<String, MultipartField<*>> =
        (mapOf("body" to _body()) +
                _additionalBodyProperties().mapValues { (_, value) -> MultipartField.of(value) })
            .toImmutable()

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    @JsonDeserialize(using = Body.Deserializer::class)
    @JsonSerialize(using = Body.Serializer::class)
    class Body
    private constructor(
        private val fileUploadV1: FileUploadV1? = null,
        private val fileUploadByUrlv1: FileUploadByUrlv1? = null,
        private val _json: JsonValue? = null,
    ) {

        fun fileUploadV1(): Optional<FileUploadV1> = Optional.ofNullable(fileUploadV1)

        fun fileUploadByUrlv1(): Optional<FileUploadByUrlv1> =
            Optional.ofNullable(fileUploadByUrlv1)

        fun isFileUploadV1(): Boolean = fileUploadV1 != null

        fun isFileUploadByUrlv1(): Boolean = fileUploadByUrlv1 != null

        fun asFileUploadV1(): FileUploadV1 = fileUploadV1.getOrThrow("fileUploadV1")

        fun asFileUploadByUrlv1(): FileUploadByUrlv1 =
            fileUploadByUrlv1.getOrThrow("fileUploadByUrlv1")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                fileUploadV1 != null -> visitor.visitFileUploadV1(fileUploadV1)
                fileUploadByUrlv1 != null -> visitor.visitFileUploadByUrlv1(fileUploadByUrlv1)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitFileUploadV1(fileUploadV1: FileUploadV1) {
                        fileUploadV1.validate()
                    }

                    override fun visitFileUploadByUrlv1(fileUploadByUrlv1: FileUploadByUrlv1) {
                        fileUploadByUrlv1.validate()
                    }
                }
            )
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitFileUploadV1(fileUploadV1: FileUploadV1) =
                        fileUploadV1.validity()

                    override fun visitFileUploadByUrlv1(fileUploadByUrlv1: FileUploadByUrlv1) =
                        fileUploadByUrlv1.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                fileUploadV1 == other.fileUploadV1 &&
                fileUploadByUrlv1 == other.fileUploadByUrlv1
        }

        override fun hashCode(): Int = Objects.hash(fileUploadV1, fileUploadByUrlv1)

        override fun toString(): String =
            when {
                fileUploadV1 != null -> "Body{fileUploadV1=$fileUploadV1}"
                fileUploadByUrlv1 != null -> "Body{fileUploadByUrlv1=$fileUploadByUrlv1}"
                _json != null -> "Body{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Body")
            }

        companion object {

            @JvmStatic
            fun ofFileUploadV1(fileUploadV1: FileUploadV1) = Body(fileUploadV1 = fileUploadV1)

            @JvmStatic
            fun ofFileUploadByUrlv1(fileUploadByUrlv1: FileUploadByUrlv1) =
                Body(fileUploadByUrlv1 = fileUploadByUrlv1)
        }

        /** An interface that defines how to map each variant of [Body] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitFileUploadV1(fileUploadV1: FileUploadV1): T

            fun visitFileUploadByUrlv1(fileUploadByUrlv1: FileUploadByUrlv1): T

            /**
             * Maps an unknown variant of [Body] to a value of type [T].
             *
             * An instance of [Body] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Body: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Body>(Body::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Body {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<FileUploadV1>())?.let {
                                Body(fileUploadV1 = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<FileUploadByUrlv1>())?.let {
                                Body(fileUploadByUrlv1 = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Body(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Body>(Body::class) {

            override fun serialize(
                value: Body,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.fileUploadV1 != null -> generator.writeObject(value.fileUploadV1)
                    value.fileUploadByUrlv1 != null ->
                        generator.writeObject(value.fileUploadByUrlv1)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Body")
                }
            }
        }

        class FileUploadV1
        private constructor(
            private val file: MultipartField<InputStream>,
            private val fileName: MultipartField<String>,
            private val token: MultipartField<String>,
            private val checks: MultipartField<String>,
            private val customCoordinates: MultipartField<String>,
            private val customMetadata: MultipartField<CustomMetadata>,
            private val description: MultipartField<String>,
            private val expire: MultipartField<Long>,
            private val extensions: MultipartField<List<Extension>>,
            private val folder: MultipartField<String>,
            private val isPrivateFile: MultipartField<Boolean>,
            private val isPublished: MultipartField<Boolean>,
            private val overwriteAiTags: MultipartField<Boolean>,
            private val overwriteCustomMetadata: MultipartField<Boolean>,
            private val overwriteFile: MultipartField<Boolean>,
            private val overwriteTags: MultipartField<Boolean>,
            private val publicKey: MultipartField<String>,
            private val responseFields: MultipartField<List<ResponseField>>,
            private val signature: MultipartField<String>,
            private val tags: MultipartField<List<String>>,
            private val transformation: MultipartField<Transformation>,
            private val useUniqueFileName: MultipartField<Boolean>,
            private val webhookUrl: MultipartField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            /**
             * The API accepts any of the following:
             * - **Binary data** – send the raw bytes as `multipart/form-data`.
             * - **HTTP / HTTPS URL** – a publicly reachable URL that ImageKit’s servers can fetch.
             * - **Base64 string** – the file encoded as a Base64 data URI or plain Base64.
             *
             * When supplying a URL, the server must receive the response headers within 8 seconds;
             * otherwise the request fails with 400 Bad Request.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun file(): InputStream = file.value.getRequired("file")

            /**
             * The name with which the file has to be uploaded. The file name can contain:
             * - Alphanumeric Characters: `a-z`, `A-Z`, `0-9`.
             * - Special Characters: `.`, `-`
             *
             * Any other character including space will be replaced by `_`
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun fileName(): String = fileName.value.getRequired("fileName")

            /**
             * A unique value that the ImageKit.io server will use to recognize and prevent
             * subsequent retries for the same request. We suggest using V4 UUIDs, or another random
             * string with enough entropy to avoid collisions. This field is only required for
             * authentication when uploading a file from the client side.
             *
             * **Note**: Sending a value that has been used in the past will result in a validation
             * error. Even if your previous request resulted in an error, you should always send a
             * new value for this field.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun token(): Optional<String> = token.value.getOptional("token")

            /**
             * Server-side checks to run on the asset. Read more about
             * [Upload API checks](/docs/api-reference/upload-file/upload-file#upload-api-checks).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun checks(): Optional<String> = checks.value.getOptional("checks")

            /**
             * Define an important area in the image. This is only relevant for image type files.
             * - To be passed as a string with the x and y coordinates of the top-left corner, and
             *   width and height of the area of interest in the format `x,y,width,height`. For
             *   example - `10,10,100,100`
             * - Can be used with fo-customtransformation.
             * - If this field is not specified and the file is overwritten, then customCoordinates
             *   will be removed.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun customCoordinates(): Optional<String> =
                customCoordinates.value.getOptional("customCoordinates")

            /**
             * JSON key-value pairs to associate with the asset. Create the custom metadata fields
             * before setting these values.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun customMetadata(): Optional<CustomMetadata> =
                customMetadata.value.getOptional("customMetadata")

            /**
             * Optional text to describe the contents of the file.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun description(): Optional<String> = description.value.getOptional("description")

            /**
             * The time until your signature is valid. It must be a
             * [Unix time](https://en.wikipedia.org/wiki/Unix_time) in less than 1 hour into the
             * future. It should be in seconds. This field is only required for authentication when
             * uploading a file from the client side.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun expire(): Optional<Long> = expire.value.getOptional("expire")

            /**
             * Array of extensions to be applied to the image. Each extension can be configured with
             * specific parameters based on the extension type.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun extensions(): Optional<List<Extension>> = extensions.value.getOptional("extensions")

            /**
             * The folder path in which the image has to be uploaded. If the folder(s) didn't exist
             * before, a new folder(s) is created.
             *
             * The folder name can contain:
             * - Alphanumeric Characters: `a-z` , `A-Z` , `0-9`
             * - Special Characters: `/` , `_` , `-`
             *
             * Using multiple `/` creates a nested folder.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun folder(): Optional<String> = folder.value.getOptional("folder")

            /**
             * Whether to mark the file as private or not.
             *
             * If `true`, the file is marked as private and is accessible only using named
             * transformation or signed URL.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun isPrivateFile(): Optional<Boolean> =
                isPrivateFile.value.getOptional("isPrivateFile")

            /**
             * Whether to upload file as published or not.
             *
             * If `false`, the file is marked as unpublished, which restricts access to the file
             * only via the media library. Files in draft or unpublished state can only be publicly
             * accessed after being published.
             *
             * The option to upload in draft state is only available in custom enterprise pricing
             * plans.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun isPublished(): Optional<Boolean> = isPublished.value.getOptional("isPublished")

            /**
             * If set to `true` and a file already exists at the exact location, its AITags will be
             * removed. Set `overwriteAITags` to `false` to preserve AITags.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun overwriteAiTags(): Optional<Boolean> =
                overwriteAiTags.value.getOptional("overwriteAITags")

            /**
             * If the request does not have `customMetadata`, and a file already exists at the exact
             * location, existing customMetadata will be removed.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun overwriteCustomMetadata(): Optional<Boolean> =
                overwriteCustomMetadata.value.getOptional("overwriteCustomMetadata")

            /**
             * If `false` and `useUniqueFileName` is also `false`, and a file already exists at the
             * exact location, upload API will return an error immediately.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun overwriteFile(): Optional<Boolean> =
                overwriteFile.value.getOptional("overwriteFile")

            /**
             * If the request does not have `tags`, and a file already exists at the exact location,
             * existing tags will be removed.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun overwriteTags(): Optional<Boolean> =
                overwriteTags.value.getOptional("overwriteTags")

            /**
             * Your ImageKit.io public key. This field is only required for authentication when
             * uploading a file from the client side.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun publicKey(): Optional<String> = publicKey.value.getOptional("publicKey")

            /**
             * Array of response field keys to include in the API response body.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun responseFields(): Optional<List<ResponseField>> =
                responseFields.value.getOptional("responseFields")

            /**
             * HMAC-SHA1 digest of the token+expire using your ImageKit.io private API key as a key.
             * Learn how to create a signature on the page below. This should be in lowercase.
             *
             * Signature must be calculated on the server-side. This field is only required for
             * authentication when uploading a file from the client side.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun signature(): Optional<String> = signature.value.getOptional("signature")

            /**
             * Set the tags while uploading the file. Provide an array of tag strings (e.g.
             * `["tag1", "tag2", "tag3"]`). The combined length of all tag characters must not
             * exceed 500, and the `%` character is not allowed. If this field is not specified and
             * the file is overwritten, the existing tags will be removed.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun tags(): Optional<List<String>> = tags.value.getOptional("tags")

            /**
             * Configure pre-processing (`pre`) and post-processing (`post`) transformations.
             * - `pre` — applied before the file is uploaded to the Media Library. Useful for
             *   reducing file size or applying basic optimizations upfront (e.g., resize,
             *   compress).
             * - `post` — applied immediately after upload. Ideal for generating transformed
             *   versions (like video encodes or thumbnails) in advance, so they're ready for
             *   delivery without delay.
             *
             * You can mix and match any combination of post-processing types.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun transformation(): Optional<Transformation> =
                transformation.value.getOptional("transformation")

            /**
             * Whether to use a unique filename for this file or not.
             *
             * If `true`, ImageKit.io will add a unique suffix to the filename parameter to get a
             * unique filename.
             *
             * If `false`, then the image is uploaded with the provided filename parameter, and any
             * existing file with the same name is replaced.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun useUniqueFileName(): Optional<Boolean> =
                useUniqueFileName.value.getOptional("useUniqueFileName")

            /**
             * The final status of extensions after they have completed execution will be delivered
             * to this endpoint as a POST request.
             * [Learn more](/docs/api-reference/digital-asset-management-dam/managing-assets/update-file-details#webhook-payload-structure)
             * about the webhook payload structure.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun webhookUrl(): Optional<String> = webhookUrl.value.getOptional("webhookUrl")

            /**
             * Returns the raw multipart value of [file].
             *
             * Unlike [file], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("file") @ExcludeMissing fun _file(): MultipartField<InputStream> = file

            /**
             * Returns the raw multipart value of [fileName].
             *
             * Unlike [fileName], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("fileName")
            @ExcludeMissing
            fun _fileName(): MultipartField<String> = fileName

            /**
             * Returns the raw multipart value of [token].
             *
             * Unlike [token], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("token") @ExcludeMissing fun _token(): MultipartField<String> = token

            /**
             * Returns the raw multipart value of [checks].
             *
             * Unlike [checks], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("checks") @ExcludeMissing fun _checks(): MultipartField<String> = checks

            /**
             * Returns the raw multipart value of [customCoordinates].
             *
             * Unlike [customCoordinates], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("customCoordinates")
            @ExcludeMissing
            fun _customCoordinates(): MultipartField<String> = customCoordinates

            /**
             * Returns the raw multipart value of [customMetadata].
             *
             * Unlike [customMetadata], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("customMetadata")
            @ExcludeMissing
            fun _customMetadata(): MultipartField<CustomMetadata> = customMetadata

            /**
             * Returns the raw multipart value of [description].
             *
             * Unlike [description], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): MultipartField<String> = description

            /**
             * Returns the raw multipart value of [expire].
             *
             * Unlike [expire], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("expire") @ExcludeMissing fun _expire(): MultipartField<Long> = expire

            /**
             * Returns the raw multipart value of [extensions].
             *
             * Unlike [extensions], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("extensions")
            @ExcludeMissing
            fun _extensions(): MultipartField<List<Extension>> = extensions

            /**
             * Returns the raw multipart value of [folder].
             *
             * Unlike [folder], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("folder") @ExcludeMissing fun _folder(): MultipartField<String> = folder

            /**
             * Returns the raw multipart value of [isPrivateFile].
             *
             * Unlike [isPrivateFile], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("isPrivateFile")
            @ExcludeMissing
            fun _isPrivateFile(): MultipartField<Boolean> = isPrivateFile

            /**
             * Returns the raw multipart value of [isPublished].
             *
             * Unlike [isPublished], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("isPublished")
            @ExcludeMissing
            fun _isPublished(): MultipartField<Boolean> = isPublished

            /**
             * Returns the raw multipart value of [overwriteAiTags].
             *
             * Unlike [overwriteAiTags], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("overwriteAITags")
            @ExcludeMissing
            fun _overwriteAiTags(): MultipartField<Boolean> = overwriteAiTags

            /**
             * Returns the raw multipart value of [overwriteCustomMetadata].
             *
             * Unlike [overwriteCustomMetadata], this method doesn't throw if the multipart field
             * has an unexpected type.
             */
            @JsonProperty("overwriteCustomMetadata")
            @ExcludeMissing
            fun _overwriteCustomMetadata(): MultipartField<Boolean> = overwriteCustomMetadata

            /**
             * Returns the raw multipart value of [overwriteFile].
             *
             * Unlike [overwriteFile], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("overwriteFile")
            @ExcludeMissing
            fun _overwriteFile(): MultipartField<Boolean> = overwriteFile

            /**
             * Returns the raw multipart value of [overwriteTags].
             *
             * Unlike [overwriteTags], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("overwriteTags")
            @ExcludeMissing
            fun _overwriteTags(): MultipartField<Boolean> = overwriteTags

            /**
             * Returns the raw multipart value of [publicKey].
             *
             * Unlike [publicKey], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("publicKey")
            @ExcludeMissing
            fun _publicKey(): MultipartField<String> = publicKey

            /**
             * Returns the raw multipart value of [responseFields].
             *
             * Unlike [responseFields], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("responseFields")
            @ExcludeMissing
            fun _responseFields(): MultipartField<List<ResponseField>> = responseFields

            /**
             * Returns the raw multipart value of [signature].
             *
             * Unlike [signature], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("signature")
            @ExcludeMissing
            fun _signature(): MultipartField<String> = signature

            /**
             * Returns the raw multipart value of [tags].
             *
             * Unlike [tags], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("tags") @ExcludeMissing fun _tags(): MultipartField<List<String>> = tags

            /**
             * Returns the raw multipart value of [transformation].
             *
             * Unlike [transformation], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("transformation")
            @ExcludeMissing
            fun _transformation(): MultipartField<Transformation> = transformation

            /**
             * Returns the raw multipart value of [useUniqueFileName].
             *
             * Unlike [useUniqueFileName], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("useUniqueFileName")
            @ExcludeMissing
            fun _useUniqueFileName(): MultipartField<Boolean> = useUniqueFileName

            /**
             * Returns the raw multipart value of [webhookUrl].
             *
             * Unlike [webhookUrl], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("webhookUrl")
            @ExcludeMissing
            fun _webhookUrl(): MultipartField<String> = webhookUrl

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [FileUploadV1].
                 *
                 * The following fields are required:
                 * ```java
                 * .file()
                 * .fileName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [FileUploadV1]. */
            class Builder internal constructor() {

                private var file: MultipartField<InputStream>? = null
                private var fileName: MultipartField<String>? = null
                private var token: MultipartField<String> = MultipartField.of(null)
                private var checks: MultipartField<String> = MultipartField.of(null)
                private var customCoordinates: MultipartField<String> = MultipartField.of(null)
                private var customMetadata: MultipartField<CustomMetadata> = MultipartField.of(null)
                private var description: MultipartField<String> = MultipartField.of(null)
                private var expire: MultipartField<Long> = MultipartField.of(null)
                private var extensions: MultipartField<MutableList<Extension>>? = null
                private var folder: MultipartField<String> = MultipartField.of(null)
                private var isPrivateFile: MultipartField<Boolean> = MultipartField.of(null)
                private var isPublished: MultipartField<Boolean> = MultipartField.of(null)
                private var overwriteAiTags: MultipartField<Boolean> = MultipartField.of(null)
                private var overwriteCustomMetadata: MultipartField<Boolean> =
                    MultipartField.of(null)
                private var overwriteFile: MultipartField<Boolean> = MultipartField.of(null)
                private var overwriteTags: MultipartField<Boolean> = MultipartField.of(null)
                private var publicKey: MultipartField<String> = MultipartField.of(null)
                private var responseFields: MultipartField<MutableList<ResponseField>>? = null
                private var signature: MultipartField<String> = MultipartField.of(null)
                private var tags: MultipartField<MutableList<String>>? = null
                private var transformation: MultipartField<Transformation> = MultipartField.of(null)
                private var useUniqueFileName: MultipartField<Boolean> = MultipartField.of(null)
                private var webhookUrl: MultipartField<String> = MultipartField.of(null)
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(fileUploadV1: FileUploadV1) = apply {
                    file = fileUploadV1.file
                    fileName = fileUploadV1.fileName
                    token = fileUploadV1.token
                    checks = fileUploadV1.checks
                    customCoordinates = fileUploadV1.customCoordinates
                    customMetadata = fileUploadV1.customMetadata
                    description = fileUploadV1.description
                    expire = fileUploadV1.expire
                    extensions = fileUploadV1.extensions.map { it.toMutableList() }
                    folder = fileUploadV1.folder
                    isPrivateFile = fileUploadV1.isPrivateFile
                    isPublished = fileUploadV1.isPublished
                    overwriteAiTags = fileUploadV1.overwriteAiTags
                    overwriteCustomMetadata = fileUploadV1.overwriteCustomMetadata
                    overwriteFile = fileUploadV1.overwriteFile
                    overwriteTags = fileUploadV1.overwriteTags
                    publicKey = fileUploadV1.publicKey
                    responseFields = fileUploadV1.responseFields.map { it.toMutableList() }
                    signature = fileUploadV1.signature
                    tags = fileUploadV1.tags.map { it.toMutableList() }
                    transformation = fileUploadV1.transformation
                    useUniqueFileName = fileUploadV1.useUniqueFileName
                    webhookUrl = fileUploadV1.webhookUrl
                    additionalProperties = fileUploadV1.additionalProperties.toMutableMap()
                }

                /**
                 * The API accepts any of the following:
                 * - **Binary data** – send the raw bytes as `multipart/form-data`.
                 * - **HTTP / HTTPS URL** – a publicly reachable URL that ImageKit’s servers can
                 *   fetch.
                 * - **Base64 string** – the file encoded as a Base64 data URI or plain Base64.
                 *
                 * When supplying a URL, the server must receive the response headers within 8
                 * seconds; otherwise the request fails with 400 Bad Request.
                 */
                fun file(file: InputStream) = file(MultipartField.of(file))

                /**
                 * Sets [Builder.file] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.file] with a well-typed [InputStream] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun file(file: MultipartField<InputStream>) = apply { this.file = file }

                /**
                 * The API accepts any of the following:
                 * - **Binary data** – send the raw bytes as `multipart/form-data`.
                 * - **HTTP / HTTPS URL** – a publicly reachable URL that ImageKit’s servers can
                 *   fetch.
                 * - **Base64 string** – the file encoded as a Base64 data URI or plain Base64.
                 *
                 * When supplying a URL, the server must receive the response headers within 8
                 * seconds; otherwise the request fails with 400 Bad Request.
                 */
                fun file(file: ByteArray) = file(file.inputStream())

                /**
                 * The API accepts any of the following:
                 * - **Binary data** – send the raw bytes as `multipart/form-data`.
                 * - **HTTP / HTTPS URL** – a publicly reachable URL that ImageKit’s servers can
                 *   fetch.
                 * - **Base64 string** – the file encoded as a Base64 data URI or plain Base64.
                 *
                 * When supplying a URL, the server must receive the response headers within 8
                 * seconds; otherwise the request fails with 400 Bad Request.
                 */
                fun file(path: Path) =
                    file(
                        MultipartField.builder<InputStream>()
                            .value(path.inputStream())
                            .filename(path.name)
                            .build()
                    )

                /**
                 * The name with which the file has to be uploaded. The file name can contain:
                 * - Alphanumeric Characters: `a-z`, `A-Z`, `0-9`.
                 * - Special Characters: `.`, `-`
                 *
                 * Any other character including space will be replaced by `_`
                 */
                fun fileName(fileName: String) = fileName(MultipartField.of(fileName))

                /**
                 * Sets [Builder.fileName] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.fileName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileName(fileName: MultipartField<String>) = apply { this.fileName = fileName }

                /**
                 * A unique value that the ImageKit.io server will use to recognize and prevent
                 * subsequent retries for the same request. We suggest using V4 UUIDs, or another
                 * random string with enough entropy to avoid collisions. This field is only
                 * required for authentication when uploading a file from the client side.
                 *
                 * **Note**: Sending a value that has been used in the past will result in a
                 * validation error. Even if your previous request resulted in an error, you should
                 * always send a new value for this field.
                 */
                fun token(token: String) = token(MultipartField.of(token))

                /**
                 * Sets [Builder.token] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.token] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun token(token: MultipartField<String>) = apply { this.token = token }

                /**
                 * Server-side checks to run on the asset. Read more about
                 * [Upload API checks](/docs/api-reference/upload-file/upload-file#upload-api-checks).
                 */
                fun checks(checks: String) = checks(MultipartField.of(checks))

                /**
                 * Sets [Builder.checks] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.checks] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun checks(checks: MultipartField<String>) = apply { this.checks = checks }

                /**
                 * Define an important area in the image. This is only relevant for image type
                 * files.
                 * - To be passed as a string with the x and y coordinates of the top-left corner,
                 *   and width and height of the area of interest in the format `x,y,width,height`.
                 *   For example - `10,10,100,100`
                 * - Can be used with fo-customtransformation.
                 * - If this field is not specified and the file is overwritten, then
                 *   customCoordinates will be removed.
                 */
                fun customCoordinates(customCoordinates: String) =
                    customCoordinates(MultipartField.of(customCoordinates))

                /**
                 * Sets [Builder.customCoordinates] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.customCoordinates] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun customCoordinates(customCoordinates: MultipartField<String>) = apply {
                    this.customCoordinates = customCoordinates
                }

                /**
                 * JSON key-value pairs to associate with the asset. Create the custom metadata
                 * fields before setting these values.
                 */
                fun customMetadata(customMetadata: CustomMetadata) =
                    customMetadata(MultipartField.of(customMetadata))

                /**
                 * Sets [Builder.customMetadata] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.customMetadata] with a well-typed
                 * [CustomMetadata] value instead. This method is primarily for setting the field to
                 * an undocumented or not yet supported value.
                 */
                fun customMetadata(customMetadata: MultipartField<CustomMetadata>) = apply {
                    this.customMetadata = customMetadata
                }

                /** Optional text to describe the contents of the file. */
                fun description(description: String) = description(MultipartField.of(description))

                /**
                 * Sets [Builder.description] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: MultipartField<String>) = apply {
                    this.description = description
                }

                /**
                 * The time until your signature is valid. It must be a
                 * [Unix time](https://en.wikipedia.org/wiki/Unix_time) in less than 1 hour into the
                 * future. It should be in seconds. This field is only required for authentication
                 * when uploading a file from the client side.
                 */
                fun expire(expire: Long) = expire(MultipartField.of(expire))

                /**
                 * Sets [Builder.expire] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.expire] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun expire(expire: MultipartField<Long>) = apply { this.expire = expire }

                /**
                 * Array of extensions to be applied to the image. Each extension can be configured
                 * with specific parameters based on the extension type.
                 */
                fun extensions(extensions: List<Extension>) =
                    extensions(MultipartField.of(extensions))

                /**
                 * Sets [Builder.extensions] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.extensions] with a well-typed `List<Extension>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun extensions(extensions: MultipartField<List<Extension>>) = apply {
                    this.extensions = extensions.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Extension] to [extensions].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addExtension(extension: Extension) = apply {
                    extensions =
                        (extensions ?: MultipartField.of(mutableListOf())).also {
                            checkKnown("extensions", it).add(extension)
                        }
                }

                /** Alias for calling [addExtension] with `Extension.ofRemoveBg(removeBg)`. */
                fun addExtension(removeBg: Extension.RemoveBg) =
                    addExtension(Extension.ofRemoveBg(removeBg))

                /** Alias for calling [addExtension] with `Extension.ofAutoTagging(autoTagging)`. */
                fun addExtension(autoTagging: Extension.AutoTaggingExtension) =
                    addExtension(Extension.ofAutoTagging(autoTagging))

                /** Alias for calling [addExtension] with `Extension.ofAiAutoDescription()`. */
                fun addExtensionAiAutoDescription() = addExtension(Extension.ofAiAutoDescription())

                /**
                 * The folder path in which the image has to be uploaded. If the folder(s) didn't
                 * exist before, a new folder(s) is created.
                 *
                 * The folder name can contain:
                 * - Alphanumeric Characters: `a-z` , `A-Z` , `0-9`
                 * - Special Characters: `/` , `_` , `-`
                 *
                 * Using multiple `/` creates a nested folder.
                 */
                fun folder(folder: String) = folder(MultipartField.of(folder))

                /**
                 * Sets [Builder.folder] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.folder] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun folder(folder: MultipartField<String>) = apply { this.folder = folder }

                /**
                 * Whether to mark the file as private or not.
                 *
                 * If `true`, the file is marked as private and is accessible only using named
                 * transformation or signed URL.
                 */
                fun isPrivateFile(isPrivateFile: Boolean) =
                    isPrivateFile(MultipartField.of(isPrivateFile))

                /**
                 * Sets [Builder.isPrivateFile] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.isPrivateFile] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun isPrivateFile(isPrivateFile: MultipartField<Boolean>) = apply {
                    this.isPrivateFile = isPrivateFile
                }

                /**
                 * Whether to upload file as published or not.
                 *
                 * If `false`, the file is marked as unpublished, which restricts access to the file
                 * only via the media library. Files in draft or unpublished state can only be
                 * publicly accessed after being published.
                 *
                 * The option to upload in draft state is only available in custom enterprise
                 * pricing plans.
                 */
                fun isPublished(isPublished: Boolean) = isPublished(MultipartField.of(isPublished))

                /**
                 * Sets [Builder.isPublished] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.isPublished] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun isPublished(isPublished: MultipartField<Boolean>) = apply {
                    this.isPublished = isPublished
                }

                /**
                 * If set to `true` and a file already exists at the exact location, its AITags will
                 * be removed. Set `overwriteAITags` to `false` to preserve AITags.
                 */
                fun overwriteAiTags(overwriteAiTags: Boolean) =
                    overwriteAiTags(MultipartField.of(overwriteAiTags))

                /**
                 * Sets [Builder.overwriteAiTags] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.overwriteAiTags] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun overwriteAiTags(overwriteAiTags: MultipartField<Boolean>) = apply {
                    this.overwriteAiTags = overwriteAiTags
                }

                /**
                 * If the request does not have `customMetadata`, and a file already exists at the
                 * exact location, existing customMetadata will be removed.
                 */
                fun overwriteCustomMetadata(overwriteCustomMetadata: Boolean) =
                    overwriteCustomMetadata(MultipartField.of(overwriteCustomMetadata))

                /**
                 * Sets [Builder.overwriteCustomMetadata] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.overwriteCustomMetadata] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun overwriteCustomMetadata(overwriteCustomMetadata: MultipartField<Boolean>) =
                    apply {
                        this.overwriteCustomMetadata = overwriteCustomMetadata
                    }

                /**
                 * If `false` and `useUniqueFileName` is also `false`, and a file already exists at
                 * the exact location, upload API will return an error immediately.
                 */
                fun overwriteFile(overwriteFile: Boolean) =
                    overwriteFile(MultipartField.of(overwriteFile))

                /**
                 * Sets [Builder.overwriteFile] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.overwriteFile] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun overwriteFile(overwriteFile: MultipartField<Boolean>) = apply {
                    this.overwriteFile = overwriteFile
                }

                /**
                 * If the request does not have `tags`, and a file already exists at the exact
                 * location, existing tags will be removed.
                 */
                fun overwriteTags(overwriteTags: Boolean) =
                    overwriteTags(MultipartField.of(overwriteTags))

                /**
                 * Sets [Builder.overwriteTags] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.overwriteTags] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun overwriteTags(overwriteTags: MultipartField<Boolean>) = apply {
                    this.overwriteTags = overwriteTags
                }

                /**
                 * Your ImageKit.io public key. This field is only required for authentication when
                 * uploading a file from the client side.
                 */
                fun publicKey(publicKey: String) = publicKey(MultipartField.of(publicKey))

                /**
                 * Sets [Builder.publicKey] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.publicKey] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun publicKey(publicKey: MultipartField<String>) = apply {
                    this.publicKey = publicKey
                }

                /** Array of response field keys to include in the API response body. */
                fun responseFields(responseFields: List<ResponseField>) =
                    responseFields(MultipartField.of(responseFields))

                /**
                 * Sets [Builder.responseFields] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.responseFields] with a well-typed
                 * `List<ResponseField>` value instead. This method is primarily for setting the
                 * field to an undocumented or not yet supported value.
                 */
                fun responseFields(responseFields: MultipartField<List<ResponseField>>) = apply {
                    this.responseFields = responseFields.map { it.toMutableList() }
                }

                /**
                 * Adds a single [ResponseField] to [responseFields].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addResponseField(responseField: ResponseField) = apply {
                    responseFields =
                        (responseFields ?: MultipartField.of(mutableListOf())).also {
                            checkKnown("responseFields", it).add(responseField)
                        }
                }

                /**
                 * HMAC-SHA1 digest of the token+expire using your ImageKit.io private API key as a
                 * key. Learn how to create a signature on the page below. This should be in
                 * lowercase.
                 *
                 * Signature must be calculated on the server-side. This field is only required for
                 * authentication when uploading a file from the client side.
                 */
                fun signature(signature: String) = signature(MultipartField.of(signature))

                /**
                 * Sets [Builder.signature] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.signature] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun signature(signature: MultipartField<String>) = apply {
                    this.signature = signature
                }

                /**
                 * Set the tags while uploading the file. Provide an array of tag strings (e.g.
                 * `["tag1", "tag2", "tag3"]`). The combined length of all tag characters must not
                 * exceed 500, and the `%` character is not allowed. If this field is not specified
                 * and the file is overwritten, the existing tags will be removed.
                 */
                fun tags(tags: List<String>) = tags(MultipartField.of(tags))

                /**
                 * Sets [Builder.tags] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.tags] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun tags(tags: MultipartField<List<String>>) = apply {
                    this.tags = tags.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [tags].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addTag(tag: String) = apply {
                    tags =
                        (tags ?: MultipartField.of(mutableListOf())).also {
                            checkKnown("tags", it).add(tag)
                        }
                }

                /**
                 * Configure pre-processing (`pre`) and post-processing (`post`) transformations.
                 * - `pre` — applied before the file is uploaded to the Media Library. Useful for
                 *   reducing file size or applying basic optimizations upfront (e.g., resize,
                 *   compress).
                 * - `post` — applied immediately after upload. Ideal for generating transformed
                 *   versions (like video encodes or thumbnails) in advance, so they're ready for
                 *   delivery without delay.
                 *
                 * You can mix and match any combination of post-processing types.
                 */
                fun transformation(transformation: Transformation) =
                    transformation(MultipartField.of(transformation))

                /**
                 * Sets [Builder.transformation] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.transformation] with a well-typed
                 * [Transformation] value instead. This method is primarily for setting the field to
                 * an undocumented or not yet supported value.
                 */
                fun transformation(transformation: MultipartField<Transformation>) = apply {
                    this.transformation = transformation
                }

                /**
                 * Whether to use a unique filename for this file or not.
                 *
                 * If `true`, ImageKit.io will add a unique suffix to the filename parameter to get
                 * a unique filename.
                 *
                 * If `false`, then the image is uploaded with the provided filename parameter, and
                 * any existing file with the same name is replaced.
                 */
                fun useUniqueFileName(useUniqueFileName: Boolean) =
                    useUniqueFileName(MultipartField.of(useUniqueFileName))

                /**
                 * Sets [Builder.useUniqueFileName] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.useUniqueFileName] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun useUniqueFileName(useUniqueFileName: MultipartField<Boolean>) = apply {
                    this.useUniqueFileName = useUniqueFileName
                }

                /**
                 * The final status of extensions after they have completed execution will be
                 * delivered to this endpoint as a POST request.
                 * [Learn more](/docs/api-reference/digital-asset-management-dam/managing-assets/update-file-details#webhook-payload-structure)
                 * about the webhook payload structure.
                 */
                fun webhookUrl(webhookUrl: String) = webhookUrl(MultipartField.of(webhookUrl))

                /**
                 * Sets [Builder.webhookUrl] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.webhookUrl] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun webhookUrl(webhookUrl: MultipartField<String>) = apply {
                    this.webhookUrl = webhookUrl
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [FileUploadV1].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .file()
                 * .fileName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): FileUploadV1 =
                    FileUploadV1(
                        checkRequired("file", file),
                        checkRequired("fileName", fileName),
                        token,
                        checks,
                        customCoordinates,
                        customMetadata,
                        description,
                        expire,
                        (extensions ?: MultipartField.of(null)).map { it.toImmutable() },
                        folder,
                        isPrivateFile,
                        isPublished,
                        overwriteAiTags,
                        overwriteCustomMetadata,
                        overwriteFile,
                        overwriteTags,
                        publicKey,
                        (responseFields ?: MultipartField.of(null)).map { it.toImmutable() },
                        signature,
                        (tags ?: MultipartField.of(null)).map { it.toImmutable() },
                        transformation,
                        useUniqueFileName,
                        webhookUrl,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): FileUploadV1 = apply {
                if (validated) {
                    return@apply
                }

                file()
                fileName()
                token()
                checks()
                customCoordinates()
                customMetadata().ifPresent { it.validate() }
                description()
                expire()
                extensions().ifPresent { it.forEach { it.validate() } }
                folder()
                isPrivateFile()
                isPublished()
                overwriteAiTags()
                overwriteCustomMetadata()
                overwriteFile()
                overwriteTags()
                publicKey()
                responseFields().ifPresent { it.forEach { it.validate() } }
                signature()
                tags()
                transformation().ifPresent { it.validate() }
                useUniqueFileName()
                webhookUrl()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * JSON key-value pairs to associate with the asset. Create the custom metadata fields
             * before setting these values.
             */
            class CustomMetadata
            private constructor(
                @com.fasterxml.jackson.annotation.JsonValue
                private val additionalProperties: Map<String, JsonValue>
            ) {

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun toBuilder() = Builder().from(this)

                companion object {

                    /**
                     * Returns a mutable builder for constructing an instance of [CustomMetadata].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [CustomMetadata]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(customMetadata: CustomMetadata) = apply {
                        additionalProperties = customMetadata.additionalProperties.toMutableMap()
                    }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [CustomMetadata].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): CustomMetadata = CustomMetadata(additionalProperties.toImmutable())
                }

                private var validated: Boolean = false

                fun validate(): CustomMetadata = apply {
                    if (validated) {
                        return@apply
                    }

                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: ImageKitInvalidDataException) {
                        false
                    }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is CustomMetadata &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "CustomMetadata{additionalProperties=$additionalProperties}"
            }

            @JsonDeserialize(using = Extension.Deserializer::class)
            @JsonSerialize(using = Extension.Serializer::class)
            class Extension
            private constructor(
                private val removeBg: RemoveBg? = null,
                private val autoTagging: AutoTaggingExtension? = null,
                private val aiAutoDescription: JsonValue? = null,
                private val _json: JsonValue? = null,
            ) {

                fun removeBg(): Optional<RemoveBg> = Optional.ofNullable(removeBg)

                fun autoTagging(): Optional<AutoTaggingExtension> = Optional.ofNullable(autoTagging)

                fun aiAutoDescription(): Optional<JsonValue> =
                    Optional.ofNullable(aiAutoDescription)

                fun isRemoveBg(): Boolean = removeBg != null

                fun isAutoTagging(): Boolean = autoTagging != null

                fun isAiAutoDescription(): Boolean = aiAutoDescription != null

                fun asRemoveBg(): RemoveBg = removeBg.getOrThrow("removeBg")

                fun asAutoTagging(): AutoTaggingExtension = autoTagging.getOrThrow("autoTagging")

                fun asAiAutoDescription(): JsonValue =
                    aiAutoDescription.getOrThrow("aiAutoDescription")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        removeBg != null -> visitor.visitRemoveBg(removeBg)
                        autoTagging != null -> visitor.visitAutoTagging(autoTagging)
                        aiAutoDescription != null ->
                            visitor.visitAiAutoDescription(aiAutoDescription)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                fun validate(): Extension = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitRemoveBg(removeBg: RemoveBg) {
                                removeBg.validate()
                            }

                            override fun visitAutoTagging(autoTagging: AutoTaggingExtension) {
                                autoTagging.validate()
                            }

                            override fun visitAiAutoDescription(aiAutoDescription: JsonValue) {
                                aiAutoDescription.let {
                                    if (
                                        it != JsonValue.from(mapOf("name" to "ai-auto-description"))
                                    ) {
                                        throw ImageKitInvalidDataException(
                                            "'aiAutoDescription' is invalid, received $it"
                                        )
                                    }
                                }
                            }
                        }
                    )
                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: ImageKitInvalidDataException) {
                        false
                    }

                /**
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic
                internal fun validity(): Int =
                    accept(
                        object : Visitor<Int> {
                            override fun visitRemoveBg(removeBg: RemoveBg) = removeBg.validity()

                            override fun visitAutoTagging(autoTagging: AutoTaggingExtension) =
                                autoTagging.validity()

                            override fun visitAiAutoDescription(aiAutoDescription: JsonValue) =
                                aiAutoDescription.let {
                                    if (
                                        it == JsonValue.from(mapOf("name" to "ai-auto-description"))
                                    )
                                        1
                                    else 0
                                }

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Extension &&
                        removeBg == other.removeBg &&
                        autoTagging == other.autoTagging &&
                        aiAutoDescription == other.aiAutoDescription
                }

                override fun hashCode(): Int =
                    Objects.hash(removeBg, autoTagging, aiAutoDescription)

                override fun toString(): String =
                    when {
                        removeBg != null -> "Extension{removeBg=$removeBg}"
                        autoTagging != null -> "Extension{autoTagging=$autoTagging}"
                        aiAutoDescription != null ->
                            "Extension{aiAutoDescription=$aiAutoDescription}"
                        _json != null -> "Extension{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Extension")
                    }

                companion object {

                    @JvmStatic fun ofRemoveBg(removeBg: RemoveBg) = Extension(removeBg = removeBg)

                    @JvmStatic
                    fun ofAutoTagging(autoTagging: AutoTaggingExtension) =
                        Extension(autoTagging = autoTagging)

                    @JvmStatic
                    fun ofAiAutoDescription() =
                        Extension(
                            aiAutoDescription =
                                JsonValue.from(mapOf("name" to "ai-auto-description"))
                        )
                }

                /**
                 * An interface that defines how to map each variant of [Extension] to a value of
                 * type [T].
                 */
                interface Visitor<out T> {

                    fun visitRemoveBg(removeBg: RemoveBg): T

                    fun visitAutoTagging(autoTagging: AutoTaggingExtension): T

                    fun visitAiAutoDescription(aiAutoDescription: JsonValue): T

                    /**
                     * Maps an unknown variant of [Extension] to a value of type [T].
                     *
                     * An instance of [Extension] can contain an unknown variant if it was
                     * deserialized from data that doesn't match any known variant. For example, if
                     * the SDK is on an older version than the API, then the API may respond with
                     * new variants that the SDK is unaware of.
                     *
                     * @throws ImageKitInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw ImageKitInvalidDataException("Unknown Extension: $json")
                    }
                }

                internal class Deserializer : BaseDeserializer<Extension>(Extension::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Extension {
                        val json = JsonValue.fromJsonNode(node)
                        val name = json.asObject().getOrNull()?.get("name")?.asString()?.getOrNull()

                        when (name) {
                            "remove-bg" -> {
                                return tryDeserialize(node, jacksonTypeRef<RemoveBg>())?.let {
                                    Extension(removeBg = it, _json = json)
                                } ?: Extension(_json = json)
                            }
                            "ai-auto-description" -> {
                                return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                    ?.let { Extension(aiAutoDescription = it, _json = json) }
                                    ?.takeIf { it.isValid() } ?: Extension(_json = json)
                            }
                        }

                        return tryDeserialize(node, jacksonTypeRef<AutoTaggingExtension>())?.let {
                            Extension(autoTagging = it, _json = json)
                        } ?: Extension(_json = json)
                    }
                }

                internal class Serializer : BaseSerializer<Extension>(Extension::class) {

                    override fun serialize(
                        value: Extension,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.removeBg != null -> generator.writeObject(value.removeBg)
                            value.autoTagging != null -> generator.writeObject(value.autoTagging)
                            value.aiAutoDescription != null ->
                                generator.writeObject(value.aiAutoDescription)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Extension")
                        }
                    }
                }

                class RemoveBg
                private constructor(
                    private val name: JsonValue,
                    private val options: MultipartField<Options>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    /**
                     * Specifies the background removal extension.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("remove-bg")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("name") @ExcludeMissing fun _name(): JsonValue = name

                    /**
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun options(): Optional<Options> = options.value.getOptional("options")

                    /**
                     * Returns the raw multipart value of [options].
                     *
                     * Unlike [options], this method doesn't throw if the multipart field has an
                     * unexpected type.
                     */
                    @JsonProperty("options")
                    @ExcludeMissing
                    fun _options(): MultipartField<Options> = options

                    @JsonAnySetter
                    private fun putAdditionalProperty(key: String, value: JsonValue) {
                        additionalProperties.put(key, value)
                    }

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /** Returns a mutable builder for constructing an instance of [RemoveBg]. */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [RemoveBg]. */
                    class Builder internal constructor() {

                        private var name: JsonValue = JsonValue.from("remove-bg")
                        private var options: MultipartField<Options> = MultipartField.of(null)
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(removeBg: RemoveBg) = apply {
                            name = removeBg.name
                            options = removeBg.options
                            additionalProperties = removeBg.additionalProperties.toMutableMap()
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("remove-bg")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun name(name: JsonValue) = apply { this.name = name }

                        fun options(options: Options) = options(MultipartField.of(options))

                        /**
                         * Sets [Builder.options] to an arbitrary multipart value.
                         *
                         * You should usually call [Builder.options] with a well-typed [Options]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun options(options: MultipartField<Options>) = apply {
                            this.options = options
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [RemoveBg].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): RemoveBg =
                            RemoveBg(name, options, additionalProperties.toMutableMap())
                    }

                    private var validated: Boolean = false

                    fun validate(): RemoveBg = apply {
                        if (validated) {
                            return@apply
                        }

                        _name().let {
                            if (it != JsonValue.from("remove-bg")) {
                                throw ImageKitInvalidDataException(
                                    "'name' is invalid, received $it"
                                )
                            }
                        }
                        options().ifPresent { it.validate() }
                        validated = true
                    }

                    fun isValid(): Boolean =
                        try {
                            validate()
                            true
                        } catch (e: ImageKitInvalidDataException) {
                            false
                        }

                    class Options
                    private constructor(
                        private val addShadow: MultipartField<Boolean>,
                        private val bgColor: MultipartField<String>,
                        private val bgImageUrl: MultipartField<String>,
                        private val semitransparency: MultipartField<Boolean>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        /**
                         * Whether to add an artificial shadow to the result. Default is false.
                         * Note: Adding shadows is currently only supported for car photos.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun addShadow(): Optional<Boolean> =
                            addShadow.value.getOptional("add_shadow")

                        /**
                         * Specifies a solid color background using hex code (e.g., "81d4fa", "fff")
                         * or color name (e.g., "green"). If this parameter is set, `bg_image_url`
                         * must be empty.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun bgColor(): Optional<String> = bgColor.value.getOptional("bg_color")

                        /**
                         * Sets a background image from a URL. If this parameter is set, `bg_color`
                         * must be empty.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun bgImageUrl(): Optional<String> =
                            bgImageUrl.value.getOptional("bg_image_url")

                        /**
                         * Allows semi-transparent regions in the result. Default is true. Note:
                         * Semitransparency is currently only supported for car windows.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun semitransparency(): Optional<Boolean> =
                            semitransparency.value.getOptional("semitransparency")

                        /**
                         * Returns the raw multipart value of [addShadow].
                         *
                         * Unlike [addShadow], this method doesn't throw if the multipart field has
                         * an unexpected type.
                         */
                        @JsonProperty("add_shadow")
                        @ExcludeMissing
                        fun _addShadow(): MultipartField<Boolean> = addShadow

                        /**
                         * Returns the raw multipart value of [bgColor].
                         *
                         * Unlike [bgColor], this method doesn't throw if the multipart field has an
                         * unexpected type.
                         */
                        @JsonProperty("bg_color")
                        @ExcludeMissing
                        fun _bgColor(): MultipartField<String> = bgColor

                        /**
                         * Returns the raw multipart value of [bgImageUrl].
                         *
                         * Unlike [bgImageUrl], this method doesn't throw if the multipart field has
                         * an unexpected type.
                         */
                        @JsonProperty("bg_image_url")
                        @ExcludeMissing
                        fun _bgImageUrl(): MultipartField<String> = bgImageUrl

                        /**
                         * Returns the raw multipart value of [semitransparency].
                         *
                         * Unlike [semitransparency], this method doesn't throw if the multipart
                         * field has an unexpected type.
                         */
                        @JsonProperty("semitransparency")
                        @ExcludeMissing
                        fun _semitransparency(): MultipartField<Boolean> = semitransparency

                        @JsonAnySetter
                        private fun putAdditionalProperty(key: String, value: JsonValue) {
                            additionalProperties.put(key, value)
                        }

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> =
                            Collections.unmodifiableMap(additionalProperties)

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of [Options].
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Options]. */
                        class Builder internal constructor() {

                            private var addShadow: MultipartField<Boolean> = MultipartField.of(null)
                            private var bgColor: MultipartField<String> = MultipartField.of(null)
                            private var bgImageUrl: MultipartField<String> = MultipartField.of(null)
                            private var semitransparency: MultipartField<Boolean> =
                                MultipartField.of(null)
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(options: Options) = apply {
                                addShadow = options.addShadow
                                bgColor = options.bgColor
                                bgImageUrl = options.bgImageUrl
                                semitransparency = options.semitransparency
                                additionalProperties = options.additionalProperties.toMutableMap()
                            }

                            /**
                             * Whether to add an artificial shadow to the result. Default is false.
                             * Note: Adding shadows is currently only supported for car photos.
                             */
                            fun addShadow(addShadow: Boolean) =
                                addShadow(MultipartField.of(addShadow))

                            /**
                             * Sets [Builder.addShadow] to an arbitrary multipart value.
                             *
                             * You should usually call [Builder.addShadow] with a well-typed
                             * [Boolean] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun addShadow(addShadow: MultipartField<Boolean>) = apply {
                                this.addShadow = addShadow
                            }

                            /**
                             * Specifies a solid color background using hex code (e.g., "81d4fa",
                             * "fff") or color name (e.g., "green"). If this parameter is set,
                             * `bg_image_url` must be empty.
                             */
                            fun bgColor(bgColor: String) = bgColor(MultipartField.of(bgColor))

                            /**
                             * Sets [Builder.bgColor] to an arbitrary multipart value.
                             *
                             * You should usually call [Builder.bgColor] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun bgColor(bgColor: MultipartField<String>) = apply {
                                this.bgColor = bgColor
                            }

                            /**
                             * Sets a background image from a URL. If this parameter is set,
                             * `bg_color` must be empty.
                             */
                            fun bgImageUrl(bgImageUrl: String) =
                                bgImageUrl(MultipartField.of(bgImageUrl))

                            /**
                             * Sets [Builder.bgImageUrl] to an arbitrary multipart value.
                             *
                             * You should usually call [Builder.bgImageUrl] with a well-typed
                             * [String] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun bgImageUrl(bgImageUrl: MultipartField<String>) = apply {
                                this.bgImageUrl = bgImageUrl
                            }

                            /**
                             * Allows semi-transparent regions in the result. Default is true. Note:
                             * Semitransparency is currently only supported for car windows.
                             */
                            fun semitransparency(semitransparency: Boolean) =
                                semitransparency(MultipartField.of(semitransparency))

                            /**
                             * Sets [Builder.semitransparency] to an arbitrary multipart value.
                             *
                             * You should usually call [Builder.semitransparency] with a well-typed
                             * [Boolean] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun semitransparency(semitransparency: MultipartField<Boolean>) =
                                apply {
                                    this.semitransparency = semitransparency
                                }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Options].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): Options =
                                Options(
                                    addShadow,
                                    bgColor,
                                    bgImageUrl,
                                    semitransparency,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): Options = apply {
                            if (validated) {
                                return@apply
                            }

                            addShadow()
                            bgColor()
                            bgImageUrl()
                            semitransparency()
                            validated = true
                        }

                        fun isValid(): Boolean =
                            try {
                                validate()
                                true
                            } catch (e: ImageKitInvalidDataException) {
                                false
                            }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Options &&
                                addShadow == other.addShadow &&
                                bgColor == other.bgColor &&
                                bgImageUrl == other.bgImageUrl &&
                                semitransparency == other.semitransparency &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(
                                addShadow,
                                bgColor,
                                bgImageUrl,
                                semitransparency,
                                additionalProperties,
                            )
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Options{addShadow=$addShadow, bgColor=$bgColor, bgImageUrl=$bgImageUrl, semitransparency=$semitransparency, additionalProperties=$additionalProperties}"
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is RemoveBg &&
                            name == other.name &&
                            options == other.options &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(name, options, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "RemoveBg{name=$name, options=$options, additionalProperties=$additionalProperties}"
                }

                class AutoTaggingExtension
                private constructor(
                    private val maxTags: MultipartField<Long>,
                    private val minConfidence: MultipartField<Long>,
                    private val name: MultipartField<Name>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    /**
                     * Maximum number of tags to attach to the asset.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun maxTags(): Long = maxTags.value.getRequired("maxTags")

                    /**
                     * Minimum confidence level for tags to be considered valid.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun minConfidence(): Long = minConfidence.value.getRequired("minConfidence")

                    /**
                     * Specifies the auto-tagging extension used.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun name(): Name = name.value.getRequired("name")

                    /**
                     * Returns the raw multipart value of [maxTags].
                     *
                     * Unlike [maxTags], this method doesn't throw if the multipart field has an
                     * unexpected type.
                     */
                    @JsonProperty("maxTags")
                    @ExcludeMissing
                    fun _maxTags(): MultipartField<Long> = maxTags

                    /**
                     * Returns the raw multipart value of [minConfidence].
                     *
                     * Unlike [minConfidence], this method doesn't throw if the multipart field has
                     * an unexpected type.
                     */
                    @JsonProperty("minConfidence")
                    @ExcludeMissing
                    fun _minConfidence(): MultipartField<Long> = minConfidence

                    /**
                     * Returns the raw multipart value of [name].
                     *
                     * Unlike [name], this method doesn't throw if the multipart field has an
                     * unexpected type.
                     */
                    @JsonProperty("name") @ExcludeMissing fun _name(): MultipartField<Name> = name

                    @JsonAnySetter
                    private fun putAdditionalProperty(key: String, value: JsonValue) {
                        additionalProperties.put(key, value)
                    }

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of
                         * [AutoTaggingExtension].
                         *
                         * The following fields are required:
                         * ```java
                         * .maxTags()
                         * .minConfidence()
                         * .name()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [AutoTaggingExtension]. */
                    class Builder internal constructor() {

                        private var maxTags: MultipartField<Long>? = null
                        private var minConfidence: MultipartField<Long>? = null
                        private var name: MultipartField<Name>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(autoTaggingExtension: AutoTaggingExtension) = apply {
                            maxTags = autoTaggingExtension.maxTags
                            minConfidence = autoTaggingExtension.minConfidence
                            name = autoTaggingExtension.name
                            additionalProperties =
                                autoTaggingExtension.additionalProperties.toMutableMap()
                        }

                        /** Maximum number of tags to attach to the asset. */
                        fun maxTags(maxTags: Long) = maxTags(MultipartField.of(maxTags))

                        /**
                         * Sets [Builder.maxTags] to an arbitrary multipart value.
                         *
                         * You should usually call [Builder.maxTags] with a well-typed [Long] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun maxTags(maxTags: MultipartField<Long>) = apply {
                            this.maxTags = maxTags
                        }

                        /** Minimum confidence level for tags to be considered valid. */
                        fun minConfidence(minConfidence: Long) =
                            minConfidence(MultipartField.of(minConfidence))

                        /**
                         * Sets [Builder.minConfidence] to an arbitrary multipart value.
                         *
                         * You should usually call [Builder.minConfidence] with a well-typed [Long]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun minConfidence(minConfidence: MultipartField<Long>) = apply {
                            this.minConfidence = minConfidence
                        }

                        /** Specifies the auto-tagging extension used. */
                        fun name(name: Name) = name(MultipartField.of(name))

                        /**
                         * Sets [Builder.name] to an arbitrary multipart value.
                         *
                         * You should usually call [Builder.name] with a well-typed [Name] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun name(name: MultipartField<Name>) = apply { this.name = name }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [AutoTaggingExtension].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .maxTags()
                         * .minConfidence()
                         * .name()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): AutoTaggingExtension =
                            AutoTaggingExtension(
                                checkRequired("maxTags", maxTags),
                                checkRequired("minConfidence", minConfidence),
                                checkRequired("name", name),
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): AutoTaggingExtension = apply {
                        if (validated) {
                            return@apply
                        }

                        maxTags()
                        minConfidence()
                        name().validate()
                        validated = true
                    }

                    fun isValid(): Boolean =
                        try {
                            validate()
                            true
                        } catch (e: ImageKitInvalidDataException) {
                            false
                        }

                    /** Specifies the auto-tagging extension used. */
                    class Name
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /**
                         * Returns this class instance's raw value.
                         *
                         * This is usually only useful if this instance was deserialized from data
                         * that doesn't match any known member, and you want to know that value. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new members that the SDK is unaware of.
                         */
                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val GOOGLE_AUTO_TAGGING = of("google-auto-tagging")

                            @JvmField val AWS_AUTO_TAGGING = of("aws-auto-tagging")

                            @JvmStatic fun of(value: String) = Name(JsonField.of(value))
                        }

                        /** An enum containing [Name]'s known values. */
                        enum class Known {
                            GOOGLE_AUTO_TAGGING,
                            AWS_AUTO_TAGGING,
                        }

                        /**
                         * An enum containing [Name]'s known values, as well as an [_UNKNOWN]
                         * member.
                         *
                         * An instance of [Name] can contain an unknown value in a couple of cases:
                         * - It was deserialized from data that doesn't match any known member. For
                         *   example, if the SDK is on an older version than the API, then the API
                         *   may respond with new members that the SDK is unaware of.
                         * - It was constructed with an arbitrary value using the [of] method.
                         */
                        enum class Value {
                            GOOGLE_AUTO_TAGGING,
                            AWS_AUTO_TAGGING,
                            /**
                             * An enum member indicating that [Name] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                         *
                         * Use the [known] method instead if you're certain the value is always
                         * known or if you want to throw for the unknown case.
                         */
                        fun value(): Value =
                            when (this) {
                                GOOGLE_AUTO_TAGGING -> Value.GOOGLE_AUTO_TAGGING
                                AWS_AUTO_TAGGING -> Value.AWS_AUTO_TAGGING
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * Use the [value] method instead if you're uncertain the value is always
                         * known and don't want to throw for the unknown case.
                         *
                         * @throws ImageKitInvalidDataException if this class instance's value is a
                         *   not a known member.
                         */
                        fun known(): Known =
                            when (this) {
                                GOOGLE_AUTO_TAGGING -> Known.GOOGLE_AUTO_TAGGING
                                AWS_AUTO_TAGGING -> Known.AWS_AUTO_TAGGING
                                else -> throw ImageKitInvalidDataException("Unknown Name: $value")
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * This differs from the [toString] method because that method is primarily
                         * for debugging and generally doesn't throw.
                         *
                         * @throws ImageKitInvalidDataException if this class instance's value does
                         *   not have the expected primitive type.
                         */
                        fun asString(): String =
                            _value().asString().orElseThrow {
                                ImageKitInvalidDataException("Value is not a String")
                            }

                        private var validated: Boolean = false

                        fun validate(): Name = apply {
                            if (validated) {
                                return@apply
                            }

                            known()
                            validated = true
                        }

                        fun isValid(): Boolean =
                            try {
                                validate()
                                true
                            } catch (e: ImageKitInvalidDataException) {
                                false
                            }

                        /**
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Name && value == other.value
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is AutoTaggingExtension &&
                            maxTags == other.maxTags &&
                            minConfidence == other.minConfidence &&
                            name == other.name &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(maxTags, minConfidence, name, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "AutoTaggingExtension{maxTags=$maxTags, minConfidence=$minConfidence, name=$name, additionalProperties=$additionalProperties}"
                }
            }

            class ResponseField
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val TAGS = of("tags")

                    @JvmField val CUSTOM_COORDINATES = of("customCoordinates")

                    @JvmField val IS_PRIVATE_FILE = of("isPrivateFile")

                    @JvmField val EMBEDDED_METADATA = of("embeddedMetadata")

                    @JvmField val IS_PUBLISHED = of("isPublished")

                    @JvmField val CUSTOM_METADATA = of("customMetadata")

                    @JvmField val METADATA = of("metadata")

                    @JvmStatic fun of(value: String) = ResponseField(JsonField.of(value))
                }

                /** An enum containing [ResponseField]'s known values. */
                enum class Known {
                    TAGS,
                    CUSTOM_COORDINATES,
                    IS_PRIVATE_FILE,
                    EMBEDDED_METADATA,
                    IS_PUBLISHED,
                    CUSTOM_METADATA,
                    METADATA,
                }

                /**
                 * An enum containing [ResponseField]'s known values, as well as an [_UNKNOWN]
                 * member.
                 *
                 * An instance of [ResponseField] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    TAGS,
                    CUSTOM_COORDINATES,
                    IS_PRIVATE_FILE,
                    EMBEDDED_METADATA,
                    IS_PUBLISHED,
                    CUSTOM_METADATA,
                    METADATA,
                    /**
                     * An enum member indicating that [ResponseField] was instantiated with an
                     * unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        TAGS -> Value.TAGS
                        CUSTOM_COORDINATES -> Value.CUSTOM_COORDINATES
                        IS_PRIVATE_FILE -> Value.IS_PRIVATE_FILE
                        EMBEDDED_METADATA -> Value.EMBEDDED_METADATA
                        IS_PUBLISHED -> Value.IS_PUBLISHED
                        CUSTOM_METADATA -> Value.CUSTOM_METADATA
                        METADATA -> Value.METADATA
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws ImageKitInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        TAGS -> Known.TAGS
                        CUSTOM_COORDINATES -> Known.CUSTOM_COORDINATES
                        IS_PRIVATE_FILE -> Known.IS_PRIVATE_FILE
                        EMBEDDED_METADATA -> Known.EMBEDDED_METADATA
                        IS_PUBLISHED -> Known.IS_PUBLISHED
                        CUSTOM_METADATA -> Known.CUSTOM_METADATA
                        METADATA -> Known.METADATA
                        else -> throw ImageKitInvalidDataException("Unknown ResponseField: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws ImageKitInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        ImageKitInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                fun validate(): ResponseField = apply {
                    if (validated) {
                        return@apply
                    }

                    known()
                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: ImageKitInvalidDataException) {
                        false
                    }

                /**
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is ResponseField && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            /**
             * Configure pre-processing (`pre`) and post-processing (`post`) transformations.
             * - `pre` — applied before the file is uploaded to the Media Library. Useful for
             *   reducing file size or applying basic optimizations upfront (e.g., resize,
             *   compress).
             * - `post` — applied immediately after upload. Ideal for generating transformed
             *   versions (like video encodes or thumbnails) in advance, so they're ready for
             *   delivery without delay.
             *
             * You can mix and match any combination of post-processing types.
             */
            class Transformation
            private constructor(
                private val post: MultipartField<List<Post>>,
                private val pre: MultipartField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                /**
                 * List of transformations to apply _after_ the file is uploaded. Each item must
                 * match one of the following types: `transformation`, `gif-to-video`, `thumbnail`,
                 * `abs`.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun post(): Optional<List<Post>> = post.value.getOptional("post")

                /**
                 * Transformation string to apply before uploading the file to the Media Library.
                 * Useful for optimizing files at ingestion.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun pre(): Optional<String> = pre.value.getOptional("pre")

                /**
                 * Returns the raw multipart value of [post].
                 *
                 * Unlike [post], this method doesn't throw if the multipart field has an unexpected
                 * type.
                 */
                @JsonProperty("post") @ExcludeMissing fun _post(): MultipartField<List<Post>> = post

                /**
                 * Returns the raw multipart value of [pre].
                 *
                 * Unlike [pre], this method doesn't throw if the multipart field has an unexpected
                 * type.
                 */
                @JsonProperty("pre") @ExcludeMissing fun _pre(): MultipartField<String> = pre

                @JsonAnySetter
                private fun putAdditionalProperty(key: String, value: JsonValue) {
                    additionalProperties.put(key, value)
                }

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> =
                    Collections.unmodifiableMap(additionalProperties)

                fun toBuilder() = Builder().from(this)

                companion object {

                    /**
                     * Returns a mutable builder for constructing an instance of [Transformation].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Transformation]. */
                class Builder internal constructor() {

                    private var post: MultipartField<MutableList<Post>>? = null
                    private var pre: MultipartField<String> = MultipartField.of(null)
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(transformation: Transformation) = apply {
                        post = transformation.post.map { it.toMutableList() }
                        pre = transformation.pre
                        additionalProperties = transformation.additionalProperties.toMutableMap()
                    }

                    /**
                     * List of transformations to apply _after_ the file is uploaded. Each item must
                     * match one of the following types: `transformation`, `gif-to-video`,
                     * `thumbnail`, `abs`.
                     */
                    fun post(post: List<Post>) = post(MultipartField.of(post))

                    /**
                     * Sets [Builder.post] to an arbitrary multipart value.
                     *
                     * You should usually call [Builder.post] with a well-typed `List<Post>` value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun post(post: MultipartField<List<Post>>) = apply {
                        this.post = post.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [Post] to [Builder.post].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addPost(post: Post) = apply {
                        this.post =
                            (this.post ?: MultipartField.of(mutableListOf())).also {
                                checkKnown("post", it).add(post)
                            }
                    }

                    /** Alias for calling [addPost] with `Post.ofTransformation(transformation)`. */
                    fun addPost(transformation: Post.InnerTransformation) =
                        addPost(Post.ofTransformation(transformation))

                    /**
                     * Alias for calling [addPost] with the following:
                     * ```java
                     * Post.InnerTransformation.builder()
                     *     .value(value)
                     *     .build()
                     * ```
                     */
                    fun addTransformationPost(value: String) =
                        addPost(Post.InnerTransformation.builder().value(value).build())

                    /** Alias for calling [addPost] with `Post.ofGifToVideo(gifToVideo)`. */
                    fun addPost(gifToVideo: Post.GifToVideo) =
                        addPost(Post.ofGifToVideo(gifToVideo))

                    /** Alias for calling [addPost] with `Post.ofThumbnail(thumbnail)`. */
                    fun addPost(thumbnail: Post.Thumbnail) = addPost(Post.ofThumbnail(thumbnail))

                    /** Alias for calling [addPost] with `Post.ofAbs(abs)`. */
                    fun addPost(abs: Post.Abs) = addPost(Post.ofAbs(abs))

                    /**
                     * Transformation string to apply before uploading the file to the Media
                     * Library. Useful for optimizing files at ingestion.
                     */
                    fun pre(pre: String) = pre(MultipartField.of(pre))

                    /**
                     * Sets [Builder.pre] to an arbitrary multipart value.
                     *
                     * You should usually call [Builder.pre] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun pre(pre: MultipartField<String>) = apply { this.pre = pre }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [Transformation].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Transformation =
                        Transformation(
                            (post ?: MultipartField.of(null)).map { it.toImmutable() },
                            pre,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Transformation = apply {
                    if (validated) {
                        return@apply
                    }

                    post().ifPresent { it.forEach { it.validate() } }
                    pre()
                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: ImageKitInvalidDataException) {
                        false
                    }

                @JsonDeserialize(using = Post.Deserializer::class)
                @JsonSerialize(using = Post.Serializer::class)
                class Post
                private constructor(
                    private val transformation: InnerTransformation? = null,
                    private val gifToVideo: GifToVideo? = null,
                    private val thumbnail: Thumbnail? = null,
                    private val abs: Abs? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun transformation(): Optional<InnerTransformation> =
                        Optional.ofNullable(transformation)

                    fun gifToVideo(): Optional<GifToVideo> = Optional.ofNullable(gifToVideo)

                    fun thumbnail(): Optional<Thumbnail> = Optional.ofNullable(thumbnail)

                    fun abs(): Optional<Abs> = Optional.ofNullable(abs)

                    fun isTransformation(): Boolean = transformation != null

                    fun isGifToVideo(): Boolean = gifToVideo != null

                    fun isThumbnail(): Boolean = thumbnail != null

                    fun isAbs(): Boolean = abs != null

                    fun asTransformation(): InnerTransformation =
                        transformation.getOrThrow("transformation")

                    fun asGifToVideo(): GifToVideo = gifToVideo.getOrThrow("gifToVideo")

                    fun asThumbnail(): Thumbnail = thumbnail.getOrThrow("thumbnail")

                    fun asAbs(): Abs = abs.getOrThrow("abs")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T =
                        when {
                            transformation != null -> visitor.visitTransformation(transformation)
                            gifToVideo != null -> visitor.visitGifToVideo(gifToVideo)
                            thumbnail != null -> visitor.visitThumbnail(thumbnail)
                            abs != null -> visitor.visitAbs(abs)
                            else -> visitor.unknown(_json)
                        }

                    private var validated: Boolean = false

                    fun validate(): Post = apply {
                        if (validated) {
                            return@apply
                        }

                        accept(
                            object : Visitor<Unit> {
                                override fun visitTransformation(
                                    transformation: InnerTransformation
                                ) {
                                    transformation.validate()
                                }

                                override fun visitGifToVideo(gifToVideo: GifToVideo) {
                                    gifToVideo.validate()
                                }

                                override fun visitThumbnail(thumbnail: Thumbnail) {
                                    thumbnail.validate()
                                }

                                override fun visitAbs(abs: Abs) {
                                    abs.validate()
                                }
                            }
                        )
                        validated = true
                    }

                    fun isValid(): Boolean =
                        try {
                            validate()
                            true
                        } catch (e: ImageKitInvalidDataException) {
                            false
                        }

                    /**
                     * Returns a score indicating how many valid values are contained in this object
                     * recursively.
                     *
                     * Used for best match union deserialization.
                     */
                    @JvmSynthetic
                    internal fun validity(): Int =
                        accept(
                            object : Visitor<Int> {
                                override fun visitTransformation(
                                    transformation: InnerTransformation
                                ) = transformation.validity()

                                override fun visitGifToVideo(gifToVideo: GifToVideo) =
                                    gifToVideo.validity()

                                override fun visitThumbnail(thumbnail: Thumbnail) =
                                    thumbnail.validity()

                                override fun visitAbs(abs: Abs) = abs.validity()

                                override fun unknown(json: JsonValue?) = 0
                            }
                        )

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Post &&
                            transformation == other.transformation &&
                            gifToVideo == other.gifToVideo &&
                            thumbnail == other.thumbnail &&
                            abs == other.abs
                    }

                    override fun hashCode(): Int =
                        Objects.hash(transformation, gifToVideo, thumbnail, abs)

                    override fun toString(): String =
                        when {
                            transformation != null -> "Post{transformation=$transformation}"
                            gifToVideo != null -> "Post{gifToVideo=$gifToVideo}"
                            thumbnail != null -> "Post{thumbnail=$thumbnail}"
                            abs != null -> "Post{abs=$abs}"
                            _json != null -> "Post{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid Post")
                        }

                    companion object {

                        @JvmStatic
                        fun ofTransformation(transformation: InnerTransformation) =
                            Post(transformation = transformation)

                        @JvmStatic
                        fun ofGifToVideo(gifToVideo: GifToVideo) = Post(gifToVideo = gifToVideo)

                        @JvmStatic
                        fun ofThumbnail(thumbnail: Thumbnail) = Post(thumbnail = thumbnail)

                        @JvmStatic fun ofAbs(abs: Abs) = Post(abs = abs)
                    }

                    /**
                     * An interface that defines how to map each variant of [Post] to a value of
                     * type [T].
                     */
                    interface Visitor<out T> {

                        fun visitTransformation(transformation: InnerTransformation): T

                        fun visitGifToVideo(gifToVideo: GifToVideo): T

                        fun visitThumbnail(thumbnail: Thumbnail): T

                        fun visitAbs(abs: Abs): T

                        /**
                         * Maps an unknown variant of [Post] to a value of type [T].
                         *
                         * An instance of [Post] can contain an unknown variant if it was
                         * deserialized from data that doesn't match any known variant. For example,
                         * if the SDK is on an older version than the API, then the API may respond
                         * with new variants that the SDK is unaware of.
                         *
                         * @throws ImageKitInvalidDataException in the default implementation.
                         */
                        fun unknown(json: JsonValue?): T {
                            throw ImageKitInvalidDataException("Unknown Post: $json")
                        }
                    }

                    internal class Deserializer : BaseDeserializer<Post>(Post::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): Post {
                            val json = JsonValue.fromJsonNode(node)
                            val type =
                                json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                            when (type) {
                                "transformation" -> {
                                    return tryDeserialize(
                                            node,
                                            jacksonTypeRef<InnerTransformation>(),
                                        )
                                        ?.let { Post(transformation = it, _json = json) }
                                        ?: Post(_json = json)
                                }
                                "gif-to-video" -> {
                                    return tryDeserialize(node, jacksonTypeRef<GifToVideo>())?.let {
                                        Post(gifToVideo = it, _json = json)
                                    } ?: Post(_json = json)
                                }
                                "thumbnail" -> {
                                    return tryDeserialize(node, jacksonTypeRef<Thumbnail>())?.let {
                                        Post(thumbnail = it, _json = json)
                                    } ?: Post(_json = json)
                                }
                                "abs" -> {
                                    return tryDeserialize(node, jacksonTypeRef<Abs>())?.let {
                                        Post(abs = it, _json = json)
                                    } ?: Post(_json = json)
                                }
                            }

                            return Post(_json = json)
                        }
                    }

                    internal class Serializer : BaseSerializer<Post>(Post::class) {

                        override fun serialize(
                            value: Post,
                            generator: JsonGenerator,
                            provider: SerializerProvider,
                        ) {
                            when {
                                value.transformation != null ->
                                    generator.writeObject(value.transformation)
                                value.gifToVideo != null -> generator.writeObject(value.gifToVideo)
                                value.thumbnail != null -> generator.writeObject(value.thumbnail)
                                value.abs != null -> generator.writeObject(value.abs)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid Post")
                            }
                        }
                    }

                    class InnerTransformation
                    private constructor(
                        private val type: JsonValue,
                        private val value: MultipartField<String>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        /**
                         * Transformation type.
                         *
                         * Expected to always return the following:
                         * ```java
                         * JsonValue.from("transformation")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Transformation string (e.g. `w-200,h-200`). Same syntax as ImageKit
                         * URL-based transformations.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun value(): String = value.value.getRequired("value")

                        /**
                         * Returns the raw multipart value of [value].
                         *
                         * Unlike [value], this method doesn't throw if the multipart field has an
                         * unexpected type.
                         */
                        @JsonProperty("value")
                        @ExcludeMissing
                        fun _value(): MultipartField<String> = value

                        @JsonAnySetter
                        private fun putAdditionalProperty(key: String, value: JsonValue) {
                            additionalProperties.put(key, value)
                        }

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> =
                            Collections.unmodifiableMap(additionalProperties)

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [InnerTransformation].
                             *
                             * The following fields are required:
                             * ```java
                             * .value()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [InnerTransformation]. */
                        class Builder internal constructor() {

                            private var type: JsonValue = JsonValue.from("transformation")
                            private var value: MultipartField<String>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(innerTransformation: InnerTransformation) = apply {
                                type = innerTransformation.type
                                value = innerTransformation.value
                                additionalProperties =
                                    innerTransformation.additionalProperties.toMutableMap()
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```java
                             * JsonValue.from("transformation")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            /**
                             * Transformation string (e.g. `w-200,h-200`). Same syntax as ImageKit
                             * URL-based transformations.
                             */
                            fun value(value: String) = value(MultipartField.of(value))

                            /**
                             * Sets [Builder.value] to an arbitrary multipart value.
                             *
                             * You should usually call [Builder.value] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun value(value: MultipartField<String>) = apply { this.value = value }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [InnerTransformation].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .value()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): InnerTransformation =
                                InnerTransformation(
                                    type,
                                    checkRequired("value", value),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): InnerTransformation = apply {
                            if (validated) {
                                return@apply
                            }

                            _type().let {
                                if (it != JsonValue.from("transformation")) {
                                    throw ImageKitInvalidDataException(
                                        "'type' is invalid, received $it"
                                    )
                                }
                            }
                            value()
                            validated = true
                        }

                        fun isValid(): Boolean =
                            try {
                                validate()
                                true
                            } catch (e: ImageKitInvalidDataException) {
                                false
                            }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is InnerTransformation &&
                                type == other.type &&
                                value == other.value &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(type, value, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "InnerTransformation{type=$type, value=$value, additionalProperties=$additionalProperties}"
                    }

                    class GifToVideo
                    private constructor(
                        private val type: JsonValue,
                        private val value: MultipartField<String>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        /**
                         * Converts an animated GIF into an MP4.
                         *
                         * Expected to always return the following:
                         * ```java
                         * JsonValue.from("gif-to-video")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Optional transformation string to apply to the output video. **Example**:
                         * `q-80`
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun value(): Optional<String> = value.value.getOptional("value")

                        /**
                         * Returns the raw multipart value of [value].
                         *
                         * Unlike [value], this method doesn't throw if the multipart field has an
                         * unexpected type.
                         */
                        @JsonProperty("value")
                        @ExcludeMissing
                        fun _value(): MultipartField<String> = value

                        @JsonAnySetter
                        private fun putAdditionalProperty(key: String, value: JsonValue) {
                            additionalProperties.put(key, value)
                        }

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> =
                            Collections.unmodifiableMap(additionalProperties)

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [GifToVideo].
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [GifToVideo]. */
                        class Builder internal constructor() {

                            private var type: JsonValue = JsonValue.from("gif-to-video")
                            private var value: MultipartField<String> = MultipartField.of(null)
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(gifToVideo: GifToVideo) = apply {
                                type = gifToVideo.type
                                value = gifToVideo.value
                                additionalProperties =
                                    gifToVideo.additionalProperties.toMutableMap()
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```java
                             * JsonValue.from("gif-to-video")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            /**
                             * Optional transformation string to apply to the output video.
                             * **Example**: `q-80`
                             */
                            fun value(value: String) = value(MultipartField.of(value))

                            /**
                             * Sets [Builder.value] to an arbitrary multipart value.
                             *
                             * You should usually call [Builder.value] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun value(value: MultipartField<String>) = apply { this.value = value }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [GifToVideo].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): GifToVideo =
                                GifToVideo(type, value, additionalProperties.toMutableMap())
                        }

                        private var validated: Boolean = false

                        fun validate(): GifToVideo = apply {
                            if (validated) {
                                return@apply
                            }

                            _type().let {
                                if (it != JsonValue.from("gif-to-video")) {
                                    throw ImageKitInvalidDataException(
                                        "'type' is invalid, received $it"
                                    )
                                }
                            }
                            value()
                            validated = true
                        }

                        fun isValid(): Boolean =
                            try {
                                validate()
                                true
                            } catch (e: ImageKitInvalidDataException) {
                                false
                            }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is GifToVideo &&
                                type == other.type &&
                                value == other.value &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(type, value, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "GifToVideo{type=$type, value=$value, additionalProperties=$additionalProperties}"
                    }

                    class Thumbnail
                    private constructor(
                        private val type: JsonValue,
                        private val value: MultipartField<String>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        /**
                         * Generates a thumbnail image.
                         *
                         * Expected to always return the following:
                         * ```java
                         * JsonValue.from("thumbnail")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Optional transformation string. **Example**: `w-150,h-150`
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun value(): Optional<String> = value.value.getOptional("value")

                        /**
                         * Returns the raw multipart value of [value].
                         *
                         * Unlike [value], this method doesn't throw if the multipart field has an
                         * unexpected type.
                         */
                        @JsonProperty("value")
                        @ExcludeMissing
                        fun _value(): MultipartField<String> = value

                        @JsonAnySetter
                        private fun putAdditionalProperty(key: String, value: JsonValue) {
                            additionalProperties.put(key, value)
                        }

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> =
                            Collections.unmodifiableMap(additionalProperties)

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [Thumbnail].
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Thumbnail]. */
                        class Builder internal constructor() {

                            private var type: JsonValue = JsonValue.from("thumbnail")
                            private var value: MultipartField<String> = MultipartField.of(null)
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(thumbnail: Thumbnail) = apply {
                                type = thumbnail.type
                                value = thumbnail.value
                                additionalProperties = thumbnail.additionalProperties.toMutableMap()
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```java
                             * JsonValue.from("thumbnail")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            /** Optional transformation string. **Example**: `w-150,h-150` */
                            fun value(value: String) = value(MultipartField.of(value))

                            /**
                             * Sets [Builder.value] to an arbitrary multipart value.
                             *
                             * You should usually call [Builder.value] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun value(value: MultipartField<String>) = apply { this.value = value }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Thumbnail].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): Thumbnail =
                                Thumbnail(type, value, additionalProperties.toMutableMap())
                        }

                        private var validated: Boolean = false

                        fun validate(): Thumbnail = apply {
                            if (validated) {
                                return@apply
                            }

                            _type().let {
                                if (it != JsonValue.from("thumbnail")) {
                                    throw ImageKitInvalidDataException(
                                        "'type' is invalid, received $it"
                                    )
                                }
                            }
                            value()
                            validated = true
                        }

                        fun isValid(): Boolean =
                            try {
                                validate()
                                true
                            } catch (e: ImageKitInvalidDataException) {
                                false
                            }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Thumbnail &&
                                type == other.type &&
                                value == other.value &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(type, value, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Thumbnail{type=$type, value=$value, additionalProperties=$additionalProperties}"
                    }

                    class Abs
                    private constructor(
                        private val protocol: MultipartField<Protocol>,
                        private val type: JsonValue,
                        private val value: MultipartField<String>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        /**
                         * Streaming protocol to use (`hls` or `dash`).
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun protocol(): Protocol = protocol.value.getRequired("protocol")

                        /**
                         * Adaptive Bitrate Streaming (ABS) setup.
                         *
                         * Expected to always return the following:
                         * ```java
                         * JsonValue.from("abs")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * List of different representations you want to create separated by an
                         * underscore.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun value(): String = value.value.getRequired("value")

                        /**
                         * Returns the raw multipart value of [protocol].
                         *
                         * Unlike [protocol], this method doesn't throw if the multipart field has
                         * an unexpected type.
                         */
                        @JsonProperty("protocol")
                        @ExcludeMissing
                        fun _protocol(): MultipartField<Protocol> = protocol

                        /**
                         * Returns the raw multipart value of [value].
                         *
                         * Unlike [value], this method doesn't throw if the multipart field has an
                         * unexpected type.
                         */
                        @JsonProperty("value")
                        @ExcludeMissing
                        fun _value(): MultipartField<String> = value

                        @JsonAnySetter
                        private fun putAdditionalProperty(key: String, value: JsonValue) {
                            additionalProperties.put(key, value)
                        }

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> =
                            Collections.unmodifiableMap(additionalProperties)

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of [Abs].
                             *
                             * The following fields are required:
                             * ```java
                             * .protocol()
                             * .value()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Abs]. */
                        class Builder internal constructor() {

                            private var protocol: MultipartField<Protocol>? = null
                            private var type: JsonValue = JsonValue.from("abs")
                            private var value: MultipartField<String>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(abs: Abs) = apply {
                                protocol = abs.protocol
                                type = abs.type
                                value = abs.value
                                additionalProperties = abs.additionalProperties.toMutableMap()
                            }

                            /** Streaming protocol to use (`hls` or `dash`). */
                            fun protocol(protocol: Protocol) = protocol(MultipartField.of(protocol))

                            /**
                             * Sets [Builder.protocol] to an arbitrary multipart value.
                             *
                             * You should usually call [Builder.protocol] with a well-typed
                             * [Protocol] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun protocol(protocol: MultipartField<Protocol>) = apply {
                                this.protocol = protocol
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```java
                             * JsonValue.from("abs")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            /**
                             * List of different representations you want to create separated by an
                             * underscore.
                             */
                            fun value(value: String) = value(MultipartField.of(value))

                            /**
                             * Sets [Builder.value] to an arbitrary multipart value.
                             *
                             * You should usually call [Builder.value] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun value(value: MultipartField<String>) = apply { this.value = value }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Abs].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .protocol()
                             * .value()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): Abs =
                                Abs(
                                    checkRequired("protocol", protocol),
                                    type,
                                    checkRequired("value", value),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): Abs = apply {
                            if (validated) {
                                return@apply
                            }

                            protocol().validate()
                            _type().let {
                                if (it != JsonValue.from("abs")) {
                                    throw ImageKitInvalidDataException(
                                        "'type' is invalid, received $it"
                                    )
                                }
                            }
                            value()
                            validated = true
                        }

                        fun isValid(): Boolean =
                            try {
                                validate()
                                true
                            } catch (e: ImageKitInvalidDataException) {
                                false
                            }

                        /** Streaming protocol to use (`hls` or `dash`). */
                        class Protocol
                        @JsonCreator
                        private constructor(private val value: JsonField<String>) : Enum {

                            /**
                             * Returns this class instance's raw value.
                             *
                             * This is usually only useful if this instance was deserialized from
                             * data that doesn't match any known member, and you want to know that
                             * value. For example, if the SDK is on an older version than the API,
                             * then the API may respond with new members that the SDK is unaware of.
                             */
                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            companion object {

                                @JvmField val HLS = of("hls")

                                @JvmField val DASH = of("dash")

                                @JvmStatic fun of(value: String) = Protocol(JsonField.of(value))
                            }

                            /** An enum containing [Protocol]'s known values. */
                            enum class Known {
                                HLS,
                                DASH,
                            }

                            /**
                             * An enum containing [Protocol]'s known values, as well as an
                             * [_UNKNOWN] member.
                             *
                             * An instance of [Protocol] can contain an unknown value in a couple of
                             * cases:
                             * - It was deserialized from data that doesn't match any known member.
                             *   For example, if the SDK is on an older version than the API, then
                             *   the API may respond with new members that the SDK is unaware of.
                             * - It was constructed with an arbitrary value using the [of] method.
                             */
                            enum class Value {
                                HLS,
                                DASH,
                                /**
                                 * An enum member indicating that [Protocol] was instantiated with
                                 * an unknown value.
                                 */
                                _UNKNOWN,
                            }

                            /**
                             * Returns an enum member corresponding to this class instance's value,
                             * or [Value._UNKNOWN] if the class was instantiated with an unknown
                             * value.
                             *
                             * Use the [known] method instead if you're certain the value is always
                             * known or if you want to throw for the unknown case.
                             */
                            fun value(): Value =
                                when (this) {
                                    HLS -> Value.HLS
                                    DASH -> Value.DASH
                                    else -> Value._UNKNOWN
                                }

                            /**
                             * Returns an enum member corresponding to this class instance's value.
                             *
                             * Use the [value] method instead if you're uncertain the value is
                             * always known and don't want to throw for the unknown case.
                             *
                             * @throws ImageKitInvalidDataException if this class instance's value
                             *   is a not a known member.
                             */
                            fun known(): Known =
                                when (this) {
                                    HLS -> Known.HLS
                                    DASH -> Known.DASH
                                    else ->
                                        throw ImageKitInvalidDataException(
                                            "Unknown Protocol: $value"
                                        )
                                }

                            /**
                             * Returns this class instance's primitive wire representation.
                             *
                             * This differs from the [toString] method because that method is
                             * primarily for debugging and generally doesn't throw.
                             *
                             * @throws ImageKitInvalidDataException if this class instance's value
                             *   does not have the expected primitive type.
                             */
                            fun asString(): String =
                                _value().asString().orElseThrow {
                                    ImageKitInvalidDataException("Value is not a String")
                                }

                            private var validated: Boolean = false

                            fun validate(): Protocol = apply {
                                if (validated) {
                                    return@apply
                                }

                                known()
                                validated = true
                            }

                            fun isValid(): Boolean =
                                try {
                                    validate()
                                    true
                                } catch (e: ImageKitInvalidDataException) {
                                    false
                                }

                            /**
                             * Returns a score indicating how many valid values are contained in
                             * this object recursively.
                             *
                             * Used for best match union deserialization.
                             */
                            @JvmSynthetic
                            internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is Protocol && value == other.value
                            }

                            override fun hashCode() = value.hashCode()

                            override fun toString() = value.toString()
                        }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Abs &&
                                protocol == other.protocol &&
                                type == other.type &&
                                value == other.value &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(protocol, type, value, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Abs{protocol=$protocol, type=$type, value=$value, additionalProperties=$additionalProperties}"
                    }
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Transformation &&
                        post == other.post &&
                        pre == other.pre &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(post, pre, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Transformation{post=$post, pre=$pre, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is FileUploadV1 &&
                    file == other.file &&
                    fileName == other.fileName &&
                    token == other.token &&
                    checks == other.checks &&
                    customCoordinates == other.customCoordinates &&
                    customMetadata == other.customMetadata &&
                    description == other.description &&
                    expire == other.expire &&
                    extensions == other.extensions &&
                    folder == other.folder &&
                    isPrivateFile == other.isPrivateFile &&
                    isPublished == other.isPublished &&
                    overwriteAiTags == other.overwriteAiTags &&
                    overwriteCustomMetadata == other.overwriteCustomMetadata &&
                    overwriteFile == other.overwriteFile &&
                    overwriteTags == other.overwriteTags &&
                    publicKey == other.publicKey &&
                    responseFields == other.responseFields &&
                    signature == other.signature &&
                    tags == other.tags &&
                    transformation == other.transformation &&
                    useUniqueFileName == other.useUniqueFileName &&
                    webhookUrl == other.webhookUrl &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    file,
                    fileName,
                    token,
                    checks,
                    customCoordinates,
                    customMetadata,
                    description,
                    expire,
                    extensions,
                    folder,
                    isPrivateFile,
                    isPublished,
                    overwriteAiTags,
                    overwriteCustomMetadata,
                    overwriteFile,
                    overwriteTags,
                    publicKey,
                    responseFields,
                    signature,
                    tags,
                    transformation,
                    useUniqueFileName,
                    webhookUrl,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FileUploadV1{file=$file, fileName=$fileName, token=$token, checks=$checks, customCoordinates=$customCoordinates, customMetadata=$customMetadata, description=$description, expire=$expire, extensions=$extensions, folder=$folder, isPrivateFile=$isPrivateFile, isPublished=$isPublished, overwriteAiTags=$overwriteAiTags, overwriteCustomMetadata=$overwriteCustomMetadata, overwriteFile=$overwriteFile, overwriteTags=$overwriteTags, publicKey=$publicKey, responseFields=$responseFields, signature=$signature, tags=$tags, transformation=$transformation, useUniqueFileName=$useUniqueFileName, webhookUrl=$webhookUrl, additionalProperties=$additionalProperties}"
        }

        class FileUploadByUrlv1
        private constructor(
            private val file: MultipartField<String>,
            private val fileName: MultipartField<String>,
            private val token: MultipartField<String>,
            private val checks: MultipartField<String>,
            private val customCoordinates: MultipartField<String>,
            private val customMetadata: MultipartField<CustomMetadata>,
            private val description: MultipartField<String>,
            private val expire: MultipartField<Long>,
            private val extensions: MultipartField<List<Extension>>,
            private val folder: MultipartField<String>,
            private val isPrivateFile: MultipartField<Boolean>,
            private val isPublished: MultipartField<Boolean>,
            private val overwriteAiTags: MultipartField<Boolean>,
            private val overwriteCustomMetadata: MultipartField<Boolean>,
            private val overwriteFile: MultipartField<Boolean>,
            private val overwriteTags: MultipartField<Boolean>,
            private val publicKey: MultipartField<String>,
            private val responseFields: MultipartField<List<ResponseField>>,
            private val signature: MultipartField<String>,
            private val tags: MultipartField<List<String>>,
            private val transformation: MultipartField<Transformation>,
            private val useUniqueFileName: MultipartField<Boolean>,
            private val webhookUrl: MultipartField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            /**
             * The URL of the file to upload. A publicly reachable URL that ImageKit servers can
             * fetch. The server must receive the response headers within 8 seconds; otherwise the
             * request fails with 400 Bad Request.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun file(): String = file.value.getRequired("file")

            /**
             * The name with which the file has to be uploaded. The file name can contain:
             * - Alphanumeric Characters: `a-z`, `A-Z`, `0-9`.
             * - Special Characters: `.`, `-`
             *
             * Any other character including space will be replaced by `_`
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun fileName(): String = fileName.value.getRequired("fileName")

            /**
             * A unique value that the ImageKit.io server will use to recognize and prevent
             * subsequent retries for the same request. We suggest using V4 UUIDs, or another random
             * string with enough entropy to avoid collisions. This field is only required for
             * authentication when uploading a file from the client side.
             *
             * **Note**: Sending a value that has been used in the past will result in a validation
             * error. Even if your previous request resulted in an error, you should always send a
             * new value for this field.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun token(): Optional<String> = token.value.getOptional("token")

            /**
             * Server-side checks to run on the asset. Read more about
             * [Upload API checks](/docs/api-reference/upload-file/upload-file#upload-api-checks).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun checks(): Optional<String> = checks.value.getOptional("checks")

            /**
             * Define an important area in the image. This is only relevant for image type files.
             * - To be passed as a string with the x and y coordinates of the top-left corner, and
             *   width and height of the area of interest in the format `x,y,width,height`. For
             *   example - `10,10,100,100`
             * - Can be used with fo-customtransformation.
             * - If this field is not specified and the file is overwritten, then customCoordinates
             *   will be removed.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun customCoordinates(): Optional<String> =
                customCoordinates.value.getOptional("customCoordinates")

            /**
             * JSON key-value pairs to associate with the asset. Create the custom metadata fields
             * before setting these values.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun customMetadata(): Optional<CustomMetadata> =
                customMetadata.value.getOptional("customMetadata")

            /**
             * Optional text to describe the contents of the file.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun description(): Optional<String> = description.value.getOptional("description")

            /**
             * The time until your signature is valid. It must be a
             * [Unix time](https://en.wikipedia.org/wiki/Unix_time) in less than 1 hour into the
             * future. It should be in seconds. This field is only required for authentication when
             * uploading a file from the client side.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun expire(): Optional<Long> = expire.value.getOptional("expire")

            /**
             * Array of extensions to be applied to the image. Each extension can be configured with
             * specific parameters based on the extension type.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun extensions(): Optional<List<Extension>> = extensions.value.getOptional("extensions")

            /**
             * The folder path in which the image has to be uploaded. If the folder(s) didn't exist
             * before, a new folder(s) is created.
             *
             * The folder name can contain:
             * - Alphanumeric Characters: `a-z` , `A-Z` , `0-9`
             * - Special Characters: `/` , `_` , `-`
             *
             * Using multiple `/` creates a nested folder.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun folder(): Optional<String> = folder.value.getOptional("folder")

            /**
             * Whether to mark the file as private or not.
             *
             * If `true`, the file is marked as private and is accessible only using named
             * transformation or signed URL.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun isPrivateFile(): Optional<Boolean> =
                isPrivateFile.value.getOptional("isPrivateFile")

            /**
             * Whether to upload file as published or not.
             *
             * If `false`, the file is marked as unpublished, which restricts access to the file
             * only via the media library. Files in draft or unpublished state can only be publicly
             * accessed after being published.
             *
             * The option to upload in draft state is only available in custom enterprise pricing
             * plans.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun isPublished(): Optional<Boolean> = isPublished.value.getOptional("isPublished")

            /**
             * If set to `true` and a file already exists at the exact location, its AITags will be
             * removed. Set `overwriteAITags` to `false` to preserve AITags.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun overwriteAiTags(): Optional<Boolean> =
                overwriteAiTags.value.getOptional("overwriteAITags")

            /**
             * If the request does not have `customMetadata`, and a file already exists at the exact
             * location, existing customMetadata will be removed.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun overwriteCustomMetadata(): Optional<Boolean> =
                overwriteCustomMetadata.value.getOptional("overwriteCustomMetadata")

            /**
             * If `false` and `useUniqueFileName` is also `false`, and a file already exists at the
             * exact location, upload API will return an error immediately.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun overwriteFile(): Optional<Boolean> =
                overwriteFile.value.getOptional("overwriteFile")

            /**
             * If the request does not have `tags`, and a file already exists at the exact location,
             * existing tags will be removed.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun overwriteTags(): Optional<Boolean> =
                overwriteTags.value.getOptional("overwriteTags")

            /**
             * Your ImageKit.io public key. This field is only required for authentication when
             * uploading a file from the client side.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun publicKey(): Optional<String> = publicKey.value.getOptional("publicKey")

            /**
             * Array of response field keys to include in the API response body.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun responseFields(): Optional<List<ResponseField>> =
                responseFields.value.getOptional("responseFields")

            /**
             * HMAC-SHA1 digest of the token+expire using your ImageKit.io private API key as a key.
             * Learn how to create a signature on the page below. This should be in lowercase.
             *
             * Signature must be calculated on the server-side. This field is only required for
             * authentication when uploading a file from the client side.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun signature(): Optional<String> = signature.value.getOptional("signature")

            /**
             * Set the tags while uploading the file. Provide an array of tag strings (e.g.
             * `["tag1", "tag2", "tag3"]`). The combined length of all tag characters must not
             * exceed 500, and the `%` character is not allowed. If this field is not specified and
             * the file is overwritten, the existing tags will be removed.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun tags(): Optional<List<String>> = tags.value.getOptional("tags")

            /**
             * Configure pre-processing (`pre`) and post-processing (`post`) transformations.
             * - `pre` — applied before the file is uploaded to the Media Library. Useful for
             *   reducing file size or applying basic optimizations upfront (e.g., resize,
             *   compress).
             * - `post` — applied immediately after upload. Ideal for generating transformed
             *   versions (like video encodes or thumbnails) in advance, so they're ready for
             *   delivery without delay.
             *
             * You can mix and match any combination of post-processing types.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun transformation(): Optional<Transformation> =
                transformation.value.getOptional("transformation")

            /**
             * Whether to use a unique filename for this file or not.
             *
             * If `true`, ImageKit.io will add a unique suffix to the filename parameter to get a
             * unique filename.
             *
             * If `false`, then the image is uploaded with the provided filename parameter, and any
             * existing file with the same name is replaced.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun useUniqueFileName(): Optional<Boolean> =
                useUniqueFileName.value.getOptional("useUniqueFileName")

            /**
             * The final status of extensions after they have completed execution will be delivered
             * to this endpoint as a POST request.
             * [Learn more](/docs/api-reference/digital-asset-management-dam/managing-assets/update-file-details#webhook-payload-structure)
             * about the webhook payload structure.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun webhookUrl(): Optional<String> = webhookUrl.value.getOptional("webhookUrl")

            /**
             * Returns the raw multipart value of [file].
             *
             * Unlike [file], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("file") @ExcludeMissing fun _file(): MultipartField<String> = file

            /**
             * Returns the raw multipart value of [fileName].
             *
             * Unlike [fileName], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("fileName")
            @ExcludeMissing
            fun _fileName(): MultipartField<String> = fileName

            /**
             * Returns the raw multipart value of [token].
             *
             * Unlike [token], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("token") @ExcludeMissing fun _token(): MultipartField<String> = token

            /**
             * Returns the raw multipart value of [checks].
             *
             * Unlike [checks], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("checks") @ExcludeMissing fun _checks(): MultipartField<String> = checks

            /**
             * Returns the raw multipart value of [customCoordinates].
             *
             * Unlike [customCoordinates], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("customCoordinates")
            @ExcludeMissing
            fun _customCoordinates(): MultipartField<String> = customCoordinates

            /**
             * Returns the raw multipart value of [customMetadata].
             *
             * Unlike [customMetadata], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("customMetadata")
            @ExcludeMissing
            fun _customMetadata(): MultipartField<CustomMetadata> = customMetadata

            /**
             * Returns the raw multipart value of [description].
             *
             * Unlike [description], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): MultipartField<String> = description

            /**
             * Returns the raw multipart value of [expire].
             *
             * Unlike [expire], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("expire") @ExcludeMissing fun _expire(): MultipartField<Long> = expire

            /**
             * Returns the raw multipart value of [extensions].
             *
             * Unlike [extensions], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("extensions")
            @ExcludeMissing
            fun _extensions(): MultipartField<List<Extension>> = extensions

            /**
             * Returns the raw multipart value of [folder].
             *
             * Unlike [folder], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("folder") @ExcludeMissing fun _folder(): MultipartField<String> = folder

            /**
             * Returns the raw multipart value of [isPrivateFile].
             *
             * Unlike [isPrivateFile], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("isPrivateFile")
            @ExcludeMissing
            fun _isPrivateFile(): MultipartField<Boolean> = isPrivateFile

            /**
             * Returns the raw multipart value of [isPublished].
             *
             * Unlike [isPublished], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("isPublished")
            @ExcludeMissing
            fun _isPublished(): MultipartField<Boolean> = isPublished

            /**
             * Returns the raw multipart value of [overwriteAiTags].
             *
             * Unlike [overwriteAiTags], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("overwriteAITags")
            @ExcludeMissing
            fun _overwriteAiTags(): MultipartField<Boolean> = overwriteAiTags

            /**
             * Returns the raw multipart value of [overwriteCustomMetadata].
             *
             * Unlike [overwriteCustomMetadata], this method doesn't throw if the multipart field
             * has an unexpected type.
             */
            @JsonProperty("overwriteCustomMetadata")
            @ExcludeMissing
            fun _overwriteCustomMetadata(): MultipartField<Boolean> = overwriteCustomMetadata

            /**
             * Returns the raw multipart value of [overwriteFile].
             *
             * Unlike [overwriteFile], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("overwriteFile")
            @ExcludeMissing
            fun _overwriteFile(): MultipartField<Boolean> = overwriteFile

            /**
             * Returns the raw multipart value of [overwriteTags].
             *
             * Unlike [overwriteTags], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("overwriteTags")
            @ExcludeMissing
            fun _overwriteTags(): MultipartField<Boolean> = overwriteTags

            /**
             * Returns the raw multipart value of [publicKey].
             *
             * Unlike [publicKey], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("publicKey")
            @ExcludeMissing
            fun _publicKey(): MultipartField<String> = publicKey

            /**
             * Returns the raw multipart value of [responseFields].
             *
             * Unlike [responseFields], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("responseFields")
            @ExcludeMissing
            fun _responseFields(): MultipartField<List<ResponseField>> = responseFields

            /**
             * Returns the raw multipart value of [signature].
             *
             * Unlike [signature], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("signature")
            @ExcludeMissing
            fun _signature(): MultipartField<String> = signature

            /**
             * Returns the raw multipart value of [tags].
             *
             * Unlike [tags], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("tags") @ExcludeMissing fun _tags(): MultipartField<List<String>> = tags

            /**
             * Returns the raw multipart value of [transformation].
             *
             * Unlike [transformation], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("transformation")
            @ExcludeMissing
            fun _transformation(): MultipartField<Transformation> = transformation

            /**
             * Returns the raw multipart value of [useUniqueFileName].
             *
             * Unlike [useUniqueFileName], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("useUniqueFileName")
            @ExcludeMissing
            fun _useUniqueFileName(): MultipartField<Boolean> = useUniqueFileName

            /**
             * Returns the raw multipart value of [webhookUrl].
             *
             * Unlike [webhookUrl], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("webhookUrl")
            @ExcludeMissing
            fun _webhookUrl(): MultipartField<String> = webhookUrl

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [FileUploadByUrlv1].
                 *
                 * The following fields are required:
                 * ```java
                 * .file()
                 * .fileName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [FileUploadByUrlv1]. */
            class Builder internal constructor() {

                private var file: MultipartField<String>? = null
                private var fileName: MultipartField<String>? = null
                private var token: MultipartField<String> = MultipartField.of(null)
                private var checks: MultipartField<String> = MultipartField.of(null)
                private var customCoordinates: MultipartField<String> = MultipartField.of(null)
                private var customMetadata: MultipartField<CustomMetadata> = MultipartField.of(null)
                private var description: MultipartField<String> = MultipartField.of(null)
                private var expire: MultipartField<Long> = MultipartField.of(null)
                private var extensions: MultipartField<MutableList<Extension>>? = null
                private var folder: MultipartField<String> = MultipartField.of(null)
                private var isPrivateFile: MultipartField<Boolean> = MultipartField.of(null)
                private var isPublished: MultipartField<Boolean> = MultipartField.of(null)
                private var overwriteAiTags: MultipartField<Boolean> = MultipartField.of(null)
                private var overwriteCustomMetadata: MultipartField<Boolean> =
                    MultipartField.of(null)
                private var overwriteFile: MultipartField<Boolean> = MultipartField.of(null)
                private var overwriteTags: MultipartField<Boolean> = MultipartField.of(null)
                private var publicKey: MultipartField<String> = MultipartField.of(null)
                private var responseFields: MultipartField<MutableList<ResponseField>>? = null
                private var signature: MultipartField<String> = MultipartField.of(null)
                private var tags: MultipartField<MutableList<String>>? = null
                private var transformation: MultipartField<Transformation> = MultipartField.of(null)
                private var useUniqueFileName: MultipartField<Boolean> = MultipartField.of(null)
                private var webhookUrl: MultipartField<String> = MultipartField.of(null)
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(fileUploadByUrlv1: FileUploadByUrlv1) = apply {
                    file = fileUploadByUrlv1.file
                    fileName = fileUploadByUrlv1.fileName
                    token = fileUploadByUrlv1.token
                    checks = fileUploadByUrlv1.checks
                    customCoordinates = fileUploadByUrlv1.customCoordinates
                    customMetadata = fileUploadByUrlv1.customMetadata
                    description = fileUploadByUrlv1.description
                    expire = fileUploadByUrlv1.expire
                    extensions = fileUploadByUrlv1.extensions.map { it.toMutableList() }
                    folder = fileUploadByUrlv1.folder
                    isPrivateFile = fileUploadByUrlv1.isPrivateFile
                    isPublished = fileUploadByUrlv1.isPublished
                    overwriteAiTags = fileUploadByUrlv1.overwriteAiTags
                    overwriteCustomMetadata = fileUploadByUrlv1.overwriteCustomMetadata
                    overwriteFile = fileUploadByUrlv1.overwriteFile
                    overwriteTags = fileUploadByUrlv1.overwriteTags
                    publicKey = fileUploadByUrlv1.publicKey
                    responseFields = fileUploadByUrlv1.responseFields.map { it.toMutableList() }
                    signature = fileUploadByUrlv1.signature
                    tags = fileUploadByUrlv1.tags.map { it.toMutableList() }
                    transformation = fileUploadByUrlv1.transformation
                    useUniqueFileName = fileUploadByUrlv1.useUniqueFileName
                    webhookUrl = fileUploadByUrlv1.webhookUrl
                    additionalProperties = fileUploadByUrlv1.additionalProperties.toMutableMap()
                }

                /**
                 * The URL of the file to upload. A publicly reachable URL that ImageKit servers can
                 * fetch. The server must receive the response headers within 8 seconds; otherwise
                 * the request fails with 400 Bad Request.
                 */
                fun file(file: String) = file(MultipartField.of(file))

                /**
                 * Sets [Builder.file] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.file] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun file(file: MultipartField<String>) = apply { this.file = file }

                /**
                 * The name with which the file has to be uploaded. The file name can contain:
                 * - Alphanumeric Characters: `a-z`, `A-Z`, `0-9`.
                 * - Special Characters: `.`, `-`
                 *
                 * Any other character including space will be replaced by `_`
                 */
                fun fileName(fileName: String) = fileName(MultipartField.of(fileName))

                /**
                 * Sets [Builder.fileName] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.fileName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileName(fileName: MultipartField<String>) = apply { this.fileName = fileName }

                /**
                 * A unique value that the ImageKit.io server will use to recognize and prevent
                 * subsequent retries for the same request. We suggest using V4 UUIDs, or another
                 * random string with enough entropy to avoid collisions. This field is only
                 * required for authentication when uploading a file from the client side.
                 *
                 * **Note**: Sending a value that has been used in the past will result in a
                 * validation error. Even if your previous request resulted in an error, you should
                 * always send a new value for this field.
                 */
                fun token(token: String) = token(MultipartField.of(token))

                /**
                 * Sets [Builder.token] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.token] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun token(token: MultipartField<String>) = apply { this.token = token }

                /**
                 * Server-side checks to run on the asset. Read more about
                 * [Upload API checks](/docs/api-reference/upload-file/upload-file#upload-api-checks).
                 */
                fun checks(checks: String) = checks(MultipartField.of(checks))

                /**
                 * Sets [Builder.checks] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.checks] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun checks(checks: MultipartField<String>) = apply { this.checks = checks }

                /**
                 * Define an important area in the image. This is only relevant for image type
                 * files.
                 * - To be passed as a string with the x and y coordinates of the top-left corner,
                 *   and width and height of the area of interest in the format `x,y,width,height`.
                 *   For example - `10,10,100,100`
                 * - Can be used with fo-customtransformation.
                 * - If this field is not specified and the file is overwritten, then
                 *   customCoordinates will be removed.
                 */
                fun customCoordinates(customCoordinates: String) =
                    customCoordinates(MultipartField.of(customCoordinates))

                /**
                 * Sets [Builder.customCoordinates] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.customCoordinates] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun customCoordinates(customCoordinates: MultipartField<String>) = apply {
                    this.customCoordinates = customCoordinates
                }

                /**
                 * JSON key-value pairs to associate with the asset. Create the custom metadata
                 * fields before setting these values.
                 */
                fun customMetadata(customMetadata: CustomMetadata) =
                    customMetadata(MultipartField.of(customMetadata))

                /**
                 * Sets [Builder.customMetadata] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.customMetadata] with a well-typed
                 * [CustomMetadata] value instead. This method is primarily for setting the field to
                 * an undocumented or not yet supported value.
                 */
                fun customMetadata(customMetadata: MultipartField<CustomMetadata>) = apply {
                    this.customMetadata = customMetadata
                }

                /** Optional text to describe the contents of the file. */
                fun description(description: String) = description(MultipartField.of(description))

                /**
                 * Sets [Builder.description] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: MultipartField<String>) = apply {
                    this.description = description
                }

                /**
                 * The time until your signature is valid. It must be a
                 * [Unix time](https://en.wikipedia.org/wiki/Unix_time) in less than 1 hour into the
                 * future. It should be in seconds. This field is only required for authentication
                 * when uploading a file from the client side.
                 */
                fun expire(expire: Long) = expire(MultipartField.of(expire))

                /**
                 * Sets [Builder.expire] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.expire] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun expire(expire: MultipartField<Long>) = apply { this.expire = expire }

                /**
                 * Array of extensions to be applied to the image. Each extension can be configured
                 * with specific parameters based on the extension type.
                 */
                fun extensions(extensions: List<Extension>) =
                    extensions(MultipartField.of(extensions))

                /**
                 * Sets [Builder.extensions] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.extensions] with a well-typed `List<Extension>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun extensions(extensions: MultipartField<List<Extension>>) = apply {
                    this.extensions = extensions.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Extension] to [extensions].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addExtension(extension: Extension) = apply {
                    extensions =
                        (extensions ?: MultipartField.of(mutableListOf())).also {
                            checkKnown("extensions", it).add(extension)
                        }
                }

                /** Alias for calling [addExtension] with `Extension.ofRemoveBg(removeBg)`. */
                fun addExtension(removeBg: Extension.RemoveBg) =
                    addExtension(Extension.ofRemoveBg(removeBg))

                /** Alias for calling [addExtension] with `Extension.ofAutoTagging(autoTagging)`. */
                fun addExtension(autoTagging: Extension.AutoTaggingExtension) =
                    addExtension(Extension.ofAutoTagging(autoTagging))

                /** Alias for calling [addExtension] with `Extension.ofAiAutoDescription()`. */
                fun addExtensionAiAutoDescription() = addExtension(Extension.ofAiAutoDescription())

                /**
                 * The folder path in which the image has to be uploaded. If the folder(s) didn't
                 * exist before, a new folder(s) is created.
                 *
                 * The folder name can contain:
                 * - Alphanumeric Characters: `a-z` , `A-Z` , `0-9`
                 * - Special Characters: `/` , `_` , `-`
                 *
                 * Using multiple `/` creates a nested folder.
                 */
                fun folder(folder: String) = folder(MultipartField.of(folder))

                /**
                 * Sets [Builder.folder] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.folder] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun folder(folder: MultipartField<String>) = apply { this.folder = folder }

                /**
                 * Whether to mark the file as private or not.
                 *
                 * If `true`, the file is marked as private and is accessible only using named
                 * transformation or signed URL.
                 */
                fun isPrivateFile(isPrivateFile: Boolean) =
                    isPrivateFile(MultipartField.of(isPrivateFile))

                /**
                 * Sets [Builder.isPrivateFile] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.isPrivateFile] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun isPrivateFile(isPrivateFile: MultipartField<Boolean>) = apply {
                    this.isPrivateFile = isPrivateFile
                }

                /**
                 * Whether to upload file as published or not.
                 *
                 * If `false`, the file is marked as unpublished, which restricts access to the file
                 * only via the media library. Files in draft or unpublished state can only be
                 * publicly accessed after being published.
                 *
                 * The option to upload in draft state is only available in custom enterprise
                 * pricing plans.
                 */
                fun isPublished(isPublished: Boolean) = isPublished(MultipartField.of(isPublished))

                /**
                 * Sets [Builder.isPublished] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.isPublished] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun isPublished(isPublished: MultipartField<Boolean>) = apply {
                    this.isPublished = isPublished
                }

                /**
                 * If set to `true` and a file already exists at the exact location, its AITags will
                 * be removed. Set `overwriteAITags` to `false` to preserve AITags.
                 */
                fun overwriteAiTags(overwriteAiTags: Boolean) =
                    overwriteAiTags(MultipartField.of(overwriteAiTags))

                /**
                 * Sets [Builder.overwriteAiTags] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.overwriteAiTags] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun overwriteAiTags(overwriteAiTags: MultipartField<Boolean>) = apply {
                    this.overwriteAiTags = overwriteAiTags
                }

                /**
                 * If the request does not have `customMetadata`, and a file already exists at the
                 * exact location, existing customMetadata will be removed.
                 */
                fun overwriteCustomMetadata(overwriteCustomMetadata: Boolean) =
                    overwriteCustomMetadata(MultipartField.of(overwriteCustomMetadata))

                /**
                 * Sets [Builder.overwriteCustomMetadata] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.overwriteCustomMetadata] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun overwriteCustomMetadata(overwriteCustomMetadata: MultipartField<Boolean>) =
                    apply {
                        this.overwriteCustomMetadata = overwriteCustomMetadata
                    }

                /**
                 * If `false` and `useUniqueFileName` is also `false`, and a file already exists at
                 * the exact location, upload API will return an error immediately.
                 */
                fun overwriteFile(overwriteFile: Boolean) =
                    overwriteFile(MultipartField.of(overwriteFile))

                /**
                 * Sets [Builder.overwriteFile] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.overwriteFile] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun overwriteFile(overwriteFile: MultipartField<Boolean>) = apply {
                    this.overwriteFile = overwriteFile
                }

                /**
                 * If the request does not have `tags`, and a file already exists at the exact
                 * location, existing tags will be removed.
                 */
                fun overwriteTags(overwriteTags: Boolean) =
                    overwriteTags(MultipartField.of(overwriteTags))

                /**
                 * Sets [Builder.overwriteTags] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.overwriteTags] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun overwriteTags(overwriteTags: MultipartField<Boolean>) = apply {
                    this.overwriteTags = overwriteTags
                }

                /**
                 * Your ImageKit.io public key. This field is only required for authentication when
                 * uploading a file from the client side.
                 */
                fun publicKey(publicKey: String) = publicKey(MultipartField.of(publicKey))

                /**
                 * Sets [Builder.publicKey] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.publicKey] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun publicKey(publicKey: MultipartField<String>) = apply {
                    this.publicKey = publicKey
                }

                /** Array of response field keys to include in the API response body. */
                fun responseFields(responseFields: List<ResponseField>) =
                    responseFields(MultipartField.of(responseFields))

                /**
                 * Sets [Builder.responseFields] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.responseFields] with a well-typed
                 * `List<ResponseField>` value instead. This method is primarily for setting the
                 * field to an undocumented or not yet supported value.
                 */
                fun responseFields(responseFields: MultipartField<List<ResponseField>>) = apply {
                    this.responseFields = responseFields.map { it.toMutableList() }
                }

                /**
                 * Adds a single [ResponseField] to [responseFields].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addResponseField(responseField: ResponseField) = apply {
                    responseFields =
                        (responseFields ?: MultipartField.of(mutableListOf())).also {
                            checkKnown("responseFields", it).add(responseField)
                        }
                }

                /**
                 * HMAC-SHA1 digest of the token+expire using your ImageKit.io private API key as a
                 * key. Learn how to create a signature on the page below. This should be in
                 * lowercase.
                 *
                 * Signature must be calculated on the server-side. This field is only required for
                 * authentication when uploading a file from the client side.
                 */
                fun signature(signature: String) = signature(MultipartField.of(signature))

                /**
                 * Sets [Builder.signature] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.signature] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun signature(signature: MultipartField<String>) = apply {
                    this.signature = signature
                }

                /**
                 * Set the tags while uploading the file. Provide an array of tag strings (e.g.
                 * `["tag1", "tag2", "tag3"]`). The combined length of all tag characters must not
                 * exceed 500, and the `%` character is not allowed. If this field is not specified
                 * and the file is overwritten, the existing tags will be removed.
                 */
                fun tags(tags: List<String>) = tags(MultipartField.of(tags))

                /**
                 * Sets [Builder.tags] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.tags] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun tags(tags: MultipartField<List<String>>) = apply {
                    this.tags = tags.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [tags].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addTag(tag: String) = apply {
                    tags =
                        (tags ?: MultipartField.of(mutableListOf())).also {
                            checkKnown("tags", it).add(tag)
                        }
                }

                /**
                 * Configure pre-processing (`pre`) and post-processing (`post`) transformations.
                 * - `pre` — applied before the file is uploaded to the Media Library. Useful for
                 *   reducing file size or applying basic optimizations upfront (e.g., resize,
                 *   compress).
                 * - `post` — applied immediately after upload. Ideal for generating transformed
                 *   versions (like video encodes or thumbnails) in advance, so they're ready for
                 *   delivery without delay.
                 *
                 * You can mix and match any combination of post-processing types.
                 */
                fun transformation(transformation: Transformation) =
                    transformation(MultipartField.of(transformation))

                /**
                 * Sets [Builder.transformation] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.transformation] with a well-typed
                 * [Transformation] value instead. This method is primarily for setting the field to
                 * an undocumented or not yet supported value.
                 */
                fun transformation(transformation: MultipartField<Transformation>) = apply {
                    this.transformation = transformation
                }

                /**
                 * Whether to use a unique filename for this file or not.
                 *
                 * If `true`, ImageKit.io will add a unique suffix to the filename parameter to get
                 * a unique filename.
                 *
                 * If `false`, then the image is uploaded with the provided filename parameter, and
                 * any existing file with the same name is replaced.
                 */
                fun useUniqueFileName(useUniqueFileName: Boolean) =
                    useUniqueFileName(MultipartField.of(useUniqueFileName))

                /**
                 * Sets [Builder.useUniqueFileName] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.useUniqueFileName] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun useUniqueFileName(useUniqueFileName: MultipartField<Boolean>) = apply {
                    this.useUniqueFileName = useUniqueFileName
                }

                /**
                 * The final status of extensions after they have completed execution will be
                 * delivered to this endpoint as a POST request.
                 * [Learn more](/docs/api-reference/digital-asset-management-dam/managing-assets/update-file-details#webhook-payload-structure)
                 * about the webhook payload structure.
                 */
                fun webhookUrl(webhookUrl: String) = webhookUrl(MultipartField.of(webhookUrl))

                /**
                 * Sets [Builder.webhookUrl] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.webhookUrl] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun webhookUrl(webhookUrl: MultipartField<String>) = apply {
                    this.webhookUrl = webhookUrl
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [FileUploadByUrlv1].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .file()
                 * .fileName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): FileUploadByUrlv1 =
                    FileUploadByUrlv1(
                        checkRequired("file", file),
                        checkRequired("fileName", fileName),
                        token,
                        checks,
                        customCoordinates,
                        customMetadata,
                        description,
                        expire,
                        (extensions ?: MultipartField.of(null)).map { it.toImmutable() },
                        folder,
                        isPrivateFile,
                        isPublished,
                        overwriteAiTags,
                        overwriteCustomMetadata,
                        overwriteFile,
                        overwriteTags,
                        publicKey,
                        (responseFields ?: MultipartField.of(null)).map { it.toImmutable() },
                        signature,
                        (tags ?: MultipartField.of(null)).map { it.toImmutable() },
                        transformation,
                        useUniqueFileName,
                        webhookUrl,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): FileUploadByUrlv1 = apply {
                if (validated) {
                    return@apply
                }

                file()
                fileName()
                token()
                checks()
                customCoordinates()
                customMetadata().ifPresent { it.validate() }
                description()
                expire()
                extensions().ifPresent { it.forEach { it.validate() } }
                folder()
                isPrivateFile()
                isPublished()
                overwriteAiTags()
                overwriteCustomMetadata()
                overwriteFile()
                overwriteTags()
                publicKey()
                responseFields().ifPresent { it.forEach { it.validate() } }
                signature()
                tags()
                transformation().ifPresent { it.validate() }
                useUniqueFileName()
                webhookUrl()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * JSON key-value pairs to associate with the asset. Create the custom metadata fields
             * before setting these values.
             */
            class CustomMetadata
            private constructor(
                @com.fasterxml.jackson.annotation.JsonValue
                private val additionalProperties: Map<String, JsonValue>
            ) {

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun toBuilder() = Builder().from(this)

                companion object {

                    /**
                     * Returns a mutable builder for constructing an instance of [CustomMetadata].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [CustomMetadata]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(customMetadata: CustomMetadata) = apply {
                        additionalProperties = customMetadata.additionalProperties.toMutableMap()
                    }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [CustomMetadata].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): CustomMetadata = CustomMetadata(additionalProperties.toImmutable())
                }

                private var validated: Boolean = false

                fun validate(): CustomMetadata = apply {
                    if (validated) {
                        return@apply
                    }

                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: ImageKitInvalidDataException) {
                        false
                    }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is CustomMetadata &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "CustomMetadata{additionalProperties=$additionalProperties}"
            }

            @JsonDeserialize(using = Extension.Deserializer::class)
            @JsonSerialize(using = Extension.Serializer::class)
            class Extension
            private constructor(
                private val removeBg: RemoveBg? = null,
                private val autoTagging: AutoTaggingExtension? = null,
                private val aiAutoDescription: JsonValue? = null,
                private val _json: JsonValue? = null,
            ) {

                fun removeBg(): Optional<RemoveBg> = Optional.ofNullable(removeBg)

                fun autoTagging(): Optional<AutoTaggingExtension> = Optional.ofNullable(autoTagging)

                fun aiAutoDescription(): Optional<JsonValue> =
                    Optional.ofNullable(aiAutoDescription)

                fun isRemoveBg(): Boolean = removeBg != null

                fun isAutoTagging(): Boolean = autoTagging != null

                fun isAiAutoDescription(): Boolean = aiAutoDescription != null

                fun asRemoveBg(): RemoveBg = removeBg.getOrThrow("removeBg")

                fun asAutoTagging(): AutoTaggingExtension = autoTagging.getOrThrow("autoTagging")

                fun asAiAutoDescription(): JsonValue =
                    aiAutoDescription.getOrThrow("aiAutoDescription")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        removeBg != null -> visitor.visitRemoveBg(removeBg)
                        autoTagging != null -> visitor.visitAutoTagging(autoTagging)
                        aiAutoDescription != null ->
                            visitor.visitAiAutoDescription(aiAutoDescription)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                fun validate(): Extension = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitRemoveBg(removeBg: RemoveBg) {
                                removeBg.validate()
                            }

                            override fun visitAutoTagging(autoTagging: AutoTaggingExtension) {
                                autoTagging.validate()
                            }

                            override fun visitAiAutoDescription(aiAutoDescription: JsonValue) {
                                aiAutoDescription.let {
                                    if (
                                        it != JsonValue.from(mapOf("name" to "ai-auto-description"))
                                    ) {
                                        throw ImageKitInvalidDataException(
                                            "'aiAutoDescription' is invalid, received $it"
                                        )
                                    }
                                }
                            }
                        }
                    )
                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: ImageKitInvalidDataException) {
                        false
                    }

                /**
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic
                internal fun validity(): Int =
                    accept(
                        object : Visitor<Int> {
                            override fun visitRemoveBg(removeBg: RemoveBg) = removeBg.validity()

                            override fun visitAutoTagging(autoTagging: AutoTaggingExtension) =
                                autoTagging.validity()

                            override fun visitAiAutoDescription(aiAutoDescription: JsonValue) =
                                aiAutoDescription.let {
                                    if (
                                        it == JsonValue.from(mapOf("name" to "ai-auto-description"))
                                    )
                                        1
                                    else 0
                                }

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Extension &&
                        removeBg == other.removeBg &&
                        autoTagging == other.autoTagging &&
                        aiAutoDescription == other.aiAutoDescription
                }

                override fun hashCode(): Int =
                    Objects.hash(removeBg, autoTagging, aiAutoDescription)

                override fun toString(): String =
                    when {
                        removeBg != null -> "Extension{removeBg=$removeBg}"
                        autoTagging != null -> "Extension{autoTagging=$autoTagging}"
                        aiAutoDescription != null ->
                            "Extension{aiAutoDescription=$aiAutoDescription}"
                        _json != null -> "Extension{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Extension")
                    }

                companion object {

                    @JvmStatic fun ofRemoveBg(removeBg: RemoveBg) = Extension(removeBg = removeBg)

                    @JvmStatic
                    fun ofAutoTagging(autoTagging: AutoTaggingExtension) =
                        Extension(autoTagging = autoTagging)

                    @JvmStatic
                    fun ofAiAutoDescription() =
                        Extension(
                            aiAutoDescription =
                                JsonValue.from(mapOf("name" to "ai-auto-description"))
                        )
                }

                /**
                 * An interface that defines how to map each variant of [Extension] to a value of
                 * type [T].
                 */
                interface Visitor<out T> {

                    fun visitRemoveBg(removeBg: RemoveBg): T

                    fun visitAutoTagging(autoTagging: AutoTaggingExtension): T

                    fun visitAiAutoDescription(aiAutoDescription: JsonValue): T

                    /**
                     * Maps an unknown variant of [Extension] to a value of type [T].
                     *
                     * An instance of [Extension] can contain an unknown variant if it was
                     * deserialized from data that doesn't match any known variant. For example, if
                     * the SDK is on an older version than the API, then the API may respond with
                     * new variants that the SDK is unaware of.
                     *
                     * @throws ImageKitInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw ImageKitInvalidDataException("Unknown Extension: $json")
                    }
                }

                internal class Deserializer : BaseDeserializer<Extension>(Extension::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Extension {
                        val json = JsonValue.fromJsonNode(node)
                        val name = json.asObject().getOrNull()?.get("name")?.asString()?.getOrNull()

                        when (name) {
                            "remove-bg" -> {
                                return tryDeserialize(node, jacksonTypeRef<RemoveBg>())?.let {
                                    Extension(removeBg = it, _json = json)
                                } ?: Extension(_json = json)
                            }
                            "ai-auto-description" -> {
                                return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                    ?.let { Extension(aiAutoDescription = it, _json = json) }
                                    ?.takeIf { it.isValid() } ?: Extension(_json = json)
                            }
                        }

                        return tryDeserialize(node, jacksonTypeRef<AutoTaggingExtension>())?.let {
                            Extension(autoTagging = it, _json = json)
                        } ?: Extension(_json = json)
                    }
                }

                internal class Serializer : BaseSerializer<Extension>(Extension::class) {

                    override fun serialize(
                        value: Extension,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.removeBg != null -> generator.writeObject(value.removeBg)
                            value.autoTagging != null -> generator.writeObject(value.autoTagging)
                            value.aiAutoDescription != null ->
                                generator.writeObject(value.aiAutoDescription)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Extension")
                        }
                    }
                }

                class RemoveBg
                private constructor(
                    private val name: JsonValue,
                    private val options: MultipartField<Options>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    /**
                     * Specifies the background removal extension.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("remove-bg")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("name") @ExcludeMissing fun _name(): JsonValue = name

                    /**
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun options(): Optional<Options> = options.value.getOptional("options")

                    /**
                     * Returns the raw multipart value of [options].
                     *
                     * Unlike [options], this method doesn't throw if the multipart field has an
                     * unexpected type.
                     */
                    @JsonProperty("options")
                    @ExcludeMissing
                    fun _options(): MultipartField<Options> = options

                    @JsonAnySetter
                    private fun putAdditionalProperty(key: String, value: JsonValue) {
                        additionalProperties.put(key, value)
                    }

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /** Returns a mutable builder for constructing an instance of [RemoveBg]. */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [RemoveBg]. */
                    class Builder internal constructor() {

                        private var name: JsonValue = JsonValue.from("remove-bg")
                        private var options: MultipartField<Options> = MultipartField.of(null)
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(removeBg: RemoveBg) = apply {
                            name = removeBg.name
                            options = removeBg.options
                            additionalProperties = removeBg.additionalProperties.toMutableMap()
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("remove-bg")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun name(name: JsonValue) = apply { this.name = name }

                        fun options(options: Options) = options(MultipartField.of(options))

                        /**
                         * Sets [Builder.options] to an arbitrary multipart value.
                         *
                         * You should usually call [Builder.options] with a well-typed [Options]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun options(options: MultipartField<Options>) = apply {
                            this.options = options
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [RemoveBg].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): RemoveBg =
                            RemoveBg(name, options, additionalProperties.toMutableMap())
                    }

                    private var validated: Boolean = false

                    fun validate(): RemoveBg = apply {
                        if (validated) {
                            return@apply
                        }

                        _name().let {
                            if (it != JsonValue.from("remove-bg")) {
                                throw ImageKitInvalidDataException(
                                    "'name' is invalid, received $it"
                                )
                            }
                        }
                        options().ifPresent { it.validate() }
                        validated = true
                    }

                    fun isValid(): Boolean =
                        try {
                            validate()
                            true
                        } catch (e: ImageKitInvalidDataException) {
                            false
                        }

                    class Options
                    private constructor(
                        private val addShadow: MultipartField<Boolean>,
                        private val bgColor: MultipartField<String>,
                        private val bgImageUrl: MultipartField<String>,
                        private val semitransparency: MultipartField<Boolean>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        /**
                         * Whether to add an artificial shadow to the result. Default is false.
                         * Note: Adding shadows is currently only supported for car photos.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun addShadow(): Optional<Boolean> =
                            addShadow.value.getOptional("add_shadow")

                        /**
                         * Specifies a solid color background using hex code (e.g., "81d4fa", "fff")
                         * or color name (e.g., "green"). If this parameter is set, `bg_image_url`
                         * must be empty.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun bgColor(): Optional<String> = bgColor.value.getOptional("bg_color")

                        /**
                         * Sets a background image from a URL. If this parameter is set, `bg_color`
                         * must be empty.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun bgImageUrl(): Optional<String> =
                            bgImageUrl.value.getOptional("bg_image_url")

                        /**
                         * Allows semi-transparent regions in the result. Default is true. Note:
                         * Semitransparency is currently only supported for car windows.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun semitransparency(): Optional<Boolean> =
                            semitransparency.value.getOptional("semitransparency")

                        /**
                         * Returns the raw multipart value of [addShadow].
                         *
                         * Unlike [addShadow], this method doesn't throw if the multipart field has
                         * an unexpected type.
                         */
                        @JsonProperty("add_shadow")
                        @ExcludeMissing
                        fun _addShadow(): MultipartField<Boolean> = addShadow

                        /**
                         * Returns the raw multipart value of [bgColor].
                         *
                         * Unlike [bgColor], this method doesn't throw if the multipart field has an
                         * unexpected type.
                         */
                        @JsonProperty("bg_color")
                        @ExcludeMissing
                        fun _bgColor(): MultipartField<String> = bgColor

                        /**
                         * Returns the raw multipart value of [bgImageUrl].
                         *
                         * Unlike [bgImageUrl], this method doesn't throw if the multipart field has
                         * an unexpected type.
                         */
                        @JsonProperty("bg_image_url")
                        @ExcludeMissing
                        fun _bgImageUrl(): MultipartField<String> = bgImageUrl

                        /**
                         * Returns the raw multipart value of [semitransparency].
                         *
                         * Unlike [semitransparency], this method doesn't throw if the multipart
                         * field has an unexpected type.
                         */
                        @JsonProperty("semitransparency")
                        @ExcludeMissing
                        fun _semitransparency(): MultipartField<Boolean> = semitransparency

                        @JsonAnySetter
                        private fun putAdditionalProperty(key: String, value: JsonValue) {
                            additionalProperties.put(key, value)
                        }

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> =
                            Collections.unmodifiableMap(additionalProperties)

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of [Options].
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Options]. */
                        class Builder internal constructor() {

                            private var addShadow: MultipartField<Boolean> = MultipartField.of(null)
                            private var bgColor: MultipartField<String> = MultipartField.of(null)
                            private var bgImageUrl: MultipartField<String> = MultipartField.of(null)
                            private var semitransparency: MultipartField<Boolean> =
                                MultipartField.of(null)
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(options: Options) = apply {
                                addShadow = options.addShadow
                                bgColor = options.bgColor
                                bgImageUrl = options.bgImageUrl
                                semitransparency = options.semitransparency
                                additionalProperties = options.additionalProperties.toMutableMap()
                            }

                            /**
                             * Whether to add an artificial shadow to the result. Default is false.
                             * Note: Adding shadows is currently only supported for car photos.
                             */
                            fun addShadow(addShadow: Boolean) =
                                addShadow(MultipartField.of(addShadow))

                            /**
                             * Sets [Builder.addShadow] to an arbitrary multipart value.
                             *
                             * You should usually call [Builder.addShadow] with a well-typed
                             * [Boolean] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun addShadow(addShadow: MultipartField<Boolean>) = apply {
                                this.addShadow = addShadow
                            }

                            /**
                             * Specifies a solid color background using hex code (e.g., "81d4fa",
                             * "fff") or color name (e.g., "green"). If this parameter is set,
                             * `bg_image_url` must be empty.
                             */
                            fun bgColor(bgColor: String) = bgColor(MultipartField.of(bgColor))

                            /**
                             * Sets [Builder.bgColor] to an arbitrary multipart value.
                             *
                             * You should usually call [Builder.bgColor] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun bgColor(bgColor: MultipartField<String>) = apply {
                                this.bgColor = bgColor
                            }

                            /**
                             * Sets a background image from a URL. If this parameter is set,
                             * `bg_color` must be empty.
                             */
                            fun bgImageUrl(bgImageUrl: String) =
                                bgImageUrl(MultipartField.of(bgImageUrl))

                            /**
                             * Sets [Builder.bgImageUrl] to an arbitrary multipart value.
                             *
                             * You should usually call [Builder.bgImageUrl] with a well-typed
                             * [String] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun bgImageUrl(bgImageUrl: MultipartField<String>) = apply {
                                this.bgImageUrl = bgImageUrl
                            }

                            /**
                             * Allows semi-transparent regions in the result. Default is true. Note:
                             * Semitransparency is currently only supported for car windows.
                             */
                            fun semitransparency(semitransparency: Boolean) =
                                semitransparency(MultipartField.of(semitransparency))

                            /**
                             * Sets [Builder.semitransparency] to an arbitrary multipart value.
                             *
                             * You should usually call [Builder.semitransparency] with a well-typed
                             * [Boolean] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun semitransparency(semitransparency: MultipartField<Boolean>) =
                                apply {
                                    this.semitransparency = semitransparency
                                }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Options].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): Options =
                                Options(
                                    addShadow,
                                    bgColor,
                                    bgImageUrl,
                                    semitransparency,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): Options = apply {
                            if (validated) {
                                return@apply
                            }

                            addShadow()
                            bgColor()
                            bgImageUrl()
                            semitransparency()
                            validated = true
                        }

                        fun isValid(): Boolean =
                            try {
                                validate()
                                true
                            } catch (e: ImageKitInvalidDataException) {
                                false
                            }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Options &&
                                addShadow == other.addShadow &&
                                bgColor == other.bgColor &&
                                bgImageUrl == other.bgImageUrl &&
                                semitransparency == other.semitransparency &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(
                                addShadow,
                                bgColor,
                                bgImageUrl,
                                semitransparency,
                                additionalProperties,
                            )
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Options{addShadow=$addShadow, bgColor=$bgColor, bgImageUrl=$bgImageUrl, semitransparency=$semitransparency, additionalProperties=$additionalProperties}"
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is RemoveBg &&
                            name == other.name &&
                            options == other.options &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(name, options, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "RemoveBg{name=$name, options=$options, additionalProperties=$additionalProperties}"
                }

                class AutoTaggingExtension
                private constructor(
                    private val maxTags: MultipartField<Long>,
                    private val minConfidence: MultipartField<Long>,
                    private val name: MultipartField<Name>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    /**
                     * Maximum number of tags to attach to the asset.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun maxTags(): Long = maxTags.value.getRequired("maxTags")

                    /**
                     * Minimum confidence level for tags to be considered valid.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun minConfidence(): Long = minConfidence.value.getRequired("minConfidence")

                    /**
                     * Specifies the auto-tagging extension used.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun name(): Name = name.value.getRequired("name")

                    /**
                     * Returns the raw multipart value of [maxTags].
                     *
                     * Unlike [maxTags], this method doesn't throw if the multipart field has an
                     * unexpected type.
                     */
                    @JsonProperty("maxTags")
                    @ExcludeMissing
                    fun _maxTags(): MultipartField<Long> = maxTags

                    /**
                     * Returns the raw multipart value of [minConfidence].
                     *
                     * Unlike [minConfidence], this method doesn't throw if the multipart field has
                     * an unexpected type.
                     */
                    @JsonProperty("minConfidence")
                    @ExcludeMissing
                    fun _minConfidence(): MultipartField<Long> = minConfidence

                    /**
                     * Returns the raw multipart value of [name].
                     *
                     * Unlike [name], this method doesn't throw if the multipart field has an
                     * unexpected type.
                     */
                    @JsonProperty("name") @ExcludeMissing fun _name(): MultipartField<Name> = name

                    @JsonAnySetter
                    private fun putAdditionalProperty(key: String, value: JsonValue) {
                        additionalProperties.put(key, value)
                    }

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of
                         * [AutoTaggingExtension].
                         *
                         * The following fields are required:
                         * ```java
                         * .maxTags()
                         * .minConfidence()
                         * .name()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [AutoTaggingExtension]. */
                    class Builder internal constructor() {

                        private var maxTags: MultipartField<Long>? = null
                        private var minConfidence: MultipartField<Long>? = null
                        private var name: MultipartField<Name>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(autoTaggingExtension: AutoTaggingExtension) = apply {
                            maxTags = autoTaggingExtension.maxTags
                            minConfidence = autoTaggingExtension.minConfidence
                            name = autoTaggingExtension.name
                            additionalProperties =
                                autoTaggingExtension.additionalProperties.toMutableMap()
                        }

                        /** Maximum number of tags to attach to the asset. */
                        fun maxTags(maxTags: Long) = maxTags(MultipartField.of(maxTags))

                        /**
                         * Sets [Builder.maxTags] to an arbitrary multipart value.
                         *
                         * You should usually call [Builder.maxTags] with a well-typed [Long] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun maxTags(maxTags: MultipartField<Long>) = apply {
                            this.maxTags = maxTags
                        }

                        /** Minimum confidence level for tags to be considered valid. */
                        fun minConfidence(minConfidence: Long) =
                            minConfidence(MultipartField.of(minConfidence))

                        /**
                         * Sets [Builder.minConfidence] to an arbitrary multipart value.
                         *
                         * You should usually call [Builder.minConfidence] with a well-typed [Long]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun minConfidence(minConfidence: MultipartField<Long>) = apply {
                            this.minConfidence = minConfidence
                        }

                        /** Specifies the auto-tagging extension used. */
                        fun name(name: Name) = name(MultipartField.of(name))

                        /**
                         * Sets [Builder.name] to an arbitrary multipart value.
                         *
                         * You should usually call [Builder.name] with a well-typed [Name] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun name(name: MultipartField<Name>) = apply { this.name = name }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [AutoTaggingExtension].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .maxTags()
                         * .minConfidence()
                         * .name()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): AutoTaggingExtension =
                            AutoTaggingExtension(
                                checkRequired("maxTags", maxTags),
                                checkRequired("minConfidence", minConfidence),
                                checkRequired("name", name),
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): AutoTaggingExtension = apply {
                        if (validated) {
                            return@apply
                        }

                        maxTags()
                        minConfidence()
                        name().validate()
                        validated = true
                    }

                    fun isValid(): Boolean =
                        try {
                            validate()
                            true
                        } catch (e: ImageKitInvalidDataException) {
                            false
                        }

                    /** Specifies the auto-tagging extension used. */
                    class Name
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /**
                         * Returns this class instance's raw value.
                         *
                         * This is usually only useful if this instance was deserialized from data
                         * that doesn't match any known member, and you want to know that value. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new members that the SDK is unaware of.
                         */
                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val GOOGLE_AUTO_TAGGING = of("google-auto-tagging")

                            @JvmField val AWS_AUTO_TAGGING = of("aws-auto-tagging")

                            @JvmStatic fun of(value: String) = Name(JsonField.of(value))
                        }

                        /** An enum containing [Name]'s known values. */
                        enum class Known {
                            GOOGLE_AUTO_TAGGING,
                            AWS_AUTO_TAGGING,
                        }

                        /**
                         * An enum containing [Name]'s known values, as well as an [_UNKNOWN]
                         * member.
                         *
                         * An instance of [Name] can contain an unknown value in a couple of cases:
                         * - It was deserialized from data that doesn't match any known member. For
                         *   example, if the SDK is on an older version than the API, then the API
                         *   may respond with new members that the SDK is unaware of.
                         * - It was constructed with an arbitrary value using the [of] method.
                         */
                        enum class Value {
                            GOOGLE_AUTO_TAGGING,
                            AWS_AUTO_TAGGING,
                            /**
                             * An enum member indicating that [Name] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                         *
                         * Use the [known] method instead if you're certain the value is always
                         * known or if you want to throw for the unknown case.
                         */
                        fun value(): Value =
                            when (this) {
                                GOOGLE_AUTO_TAGGING -> Value.GOOGLE_AUTO_TAGGING
                                AWS_AUTO_TAGGING -> Value.AWS_AUTO_TAGGING
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * Use the [value] method instead if you're uncertain the value is always
                         * known and don't want to throw for the unknown case.
                         *
                         * @throws ImageKitInvalidDataException if this class instance's value is a
                         *   not a known member.
                         */
                        fun known(): Known =
                            when (this) {
                                GOOGLE_AUTO_TAGGING -> Known.GOOGLE_AUTO_TAGGING
                                AWS_AUTO_TAGGING -> Known.AWS_AUTO_TAGGING
                                else -> throw ImageKitInvalidDataException("Unknown Name: $value")
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * This differs from the [toString] method because that method is primarily
                         * for debugging and generally doesn't throw.
                         *
                         * @throws ImageKitInvalidDataException if this class instance's value does
                         *   not have the expected primitive type.
                         */
                        fun asString(): String =
                            _value().asString().orElseThrow {
                                ImageKitInvalidDataException("Value is not a String")
                            }

                        private var validated: Boolean = false

                        fun validate(): Name = apply {
                            if (validated) {
                                return@apply
                            }

                            known()
                            validated = true
                        }

                        fun isValid(): Boolean =
                            try {
                                validate()
                                true
                            } catch (e: ImageKitInvalidDataException) {
                                false
                            }

                        /**
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Name && value == other.value
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is AutoTaggingExtension &&
                            maxTags == other.maxTags &&
                            minConfidence == other.minConfidence &&
                            name == other.name &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(maxTags, minConfidence, name, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "AutoTaggingExtension{maxTags=$maxTags, minConfidence=$minConfidence, name=$name, additionalProperties=$additionalProperties}"
                }
            }

            class ResponseField
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val TAGS = of("tags")

                    @JvmField val CUSTOM_COORDINATES = of("customCoordinates")

                    @JvmField val IS_PRIVATE_FILE = of("isPrivateFile")

                    @JvmField val EMBEDDED_METADATA = of("embeddedMetadata")

                    @JvmField val IS_PUBLISHED = of("isPublished")

                    @JvmField val CUSTOM_METADATA = of("customMetadata")

                    @JvmField val METADATA = of("metadata")

                    @JvmStatic fun of(value: String) = ResponseField(JsonField.of(value))
                }

                /** An enum containing [ResponseField]'s known values. */
                enum class Known {
                    TAGS,
                    CUSTOM_COORDINATES,
                    IS_PRIVATE_FILE,
                    EMBEDDED_METADATA,
                    IS_PUBLISHED,
                    CUSTOM_METADATA,
                    METADATA,
                }

                /**
                 * An enum containing [ResponseField]'s known values, as well as an [_UNKNOWN]
                 * member.
                 *
                 * An instance of [ResponseField] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    TAGS,
                    CUSTOM_COORDINATES,
                    IS_PRIVATE_FILE,
                    EMBEDDED_METADATA,
                    IS_PUBLISHED,
                    CUSTOM_METADATA,
                    METADATA,
                    /**
                     * An enum member indicating that [ResponseField] was instantiated with an
                     * unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        TAGS -> Value.TAGS
                        CUSTOM_COORDINATES -> Value.CUSTOM_COORDINATES
                        IS_PRIVATE_FILE -> Value.IS_PRIVATE_FILE
                        EMBEDDED_METADATA -> Value.EMBEDDED_METADATA
                        IS_PUBLISHED -> Value.IS_PUBLISHED
                        CUSTOM_METADATA -> Value.CUSTOM_METADATA
                        METADATA -> Value.METADATA
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws ImageKitInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        TAGS -> Known.TAGS
                        CUSTOM_COORDINATES -> Known.CUSTOM_COORDINATES
                        IS_PRIVATE_FILE -> Known.IS_PRIVATE_FILE
                        EMBEDDED_METADATA -> Known.EMBEDDED_METADATA
                        IS_PUBLISHED -> Known.IS_PUBLISHED
                        CUSTOM_METADATA -> Known.CUSTOM_METADATA
                        METADATA -> Known.METADATA
                        else -> throw ImageKitInvalidDataException("Unknown ResponseField: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws ImageKitInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        ImageKitInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                fun validate(): ResponseField = apply {
                    if (validated) {
                        return@apply
                    }

                    known()
                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: ImageKitInvalidDataException) {
                        false
                    }

                /**
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is ResponseField && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            /**
             * Configure pre-processing (`pre`) and post-processing (`post`) transformations.
             * - `pre` — applied before the file is uploaded to the Media Library. Useful for
             *   reducing file size or applying basic optimizations upfront (e.g., resize,
             *   compress).
             * - `post` — applied immediately after upload. Ideal for generating transformed
             *   versions (like video encodes or thumbnails) in advance, so they're ready for
             *   delivery without delay.
             *
             * You can mix and match any combination of post-processing types.
             */
            class Transformation
            private constructor(
                private val post: MultipartField<List<Post>>,
                private val pre: MultipartField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                /**
                 * List of transformations to apply _after_ the file is uploaded. Each item must
                 * match one of the following types: `transformation`, `gif-to-video`, `thumbnail`,
                 * `abs`.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun post(): Optional<List<Post>> = post.value.getOptional("post")

                /**
                 * Transformation string to apply before uploading the file to the Media Library.
                 * Useful for optimizing files at ingestion.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun pre(): Optional<String> = pre.value.getOptional("pre")

                /**
                 * Returns the raw multipart value of [post].
                 *
                 * Unlike [post], this method doesn't throw if the multipart field has an unexpected
                 * type.
                 */
                @JsonProperty("post") @ExcludeMissing fun _post(): MultipartField<List<Post>> = post

                /**
                 * Returns the raw multipart value of [pre].
                 *
                 * Unlike [pre], this method doesn't throw if the multipart field has an unexpected
                 * type.
                 */
                @JsonProperty("pre") @ExcludeMissing fun _pre(): MultipartField<String> = pre

                @JsonAnySetter
                private fun putAdditionalProperty(key: String, value: JsonValue) {
                    additionalProperties.put(key, value)
                }

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> =
                    Collections.unmodifiableMap(additionalProperties)

                fun toBuilder() = Builder().from(this)

                companion object {

                    /**
                     * Returns a mutable builder for constructing an instance of [Transformation].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Transformation]. */
                class Builder internal constructor() {

                    private var post: MultipartField<MutableList<Post>>? = null
                    private var pre: MultipartField<String> = MultipartField.of(null)
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(transformation: Transformation) = apply {
                        post = transformation.post.map { it.toMutableList() }
                        pre = transformation.pre
                        additionalProperties = transformation.additionalProperties.toMutableMap()
                    }

                    /**
                     * List of transformations to apply _after_ the file is uploaded. Each item must
                     * match one of the following types: `transformation`, `gif-to-video`,
                     * `thumbnail`, `abs`.
                     */
                    fun post(post: List<Post>) = post(MultipartField.of(post))

                    /**
                     * Sets [Builder.post] to an arbitrary multipart value.
                     *
                     * You should usually call [Builder.post] with a well-typed `List<Post>` value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun post(post: MultipartField<List<Post>>) = apply {
                        this.post = post.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [Post] to [Builder.post].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addPost(post: Post) = apply {
                        this.post =
                            (this.post ?: MultipartField.of(mutableListOf())).also {
                                checkKnown("post", it).add(post)
                            }
                    }

                    /** Alias for calling [addPost] with `Post.ofTransformation(transformation)`. */
                    fun addPost(transformation: Post.InnerTransformation) =
                        addPost(Post.ofTransformation(transformation))

                    /**
                     * Alias for calling [addPost] with the following:
                     * ```java
                     * Post.InnerTransformation.builder()
                     *     .value(value)
                     *     .build()
                     * ```
                     */
                    fun addTransformationPost(value: String) =
                        addPost(Post.InnerTransformation.builder().value(value).build())

                    /** Alias for calling [addPost] with `Post.ofGifToVideo(gifToVideo)`. */
                    fun addPost(gifToVideo: Post.GifToVideo) =
                        addPost(Post.ofGifToVideo(gifToVideo))

                    /** Alias for calling [addPost] with `Post.ofThumbnail(thumbnail)`. */
                    fun addPost(thumbnail: Post.Thumbnail) = addPost(Post.ofThumbnail(thumbnail))

                    /** Alias for calling [addPost] with `Post.ofAbs(abs)`. */
                    fun addPost(abs: Post.Abs) = addPost(Post.ofAbs(abs))

                    /**
                     * Transformation string to apply before uploading the file to the Media
                     * Library. Useful for optimizing files at ingestion.
                     */
                    fun pre(pre: String) = pre(MultipartField.of(pre))

                    /**
                     * Sets [Builder.pre] to an arbitrary multipart value.
                     *
                     * You should usually call [Builder.pre] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun pre(pre: MultipartField<String>) = apply { this.pre = pre }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [Transformation].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Transformation =
                        Transformation(
                            (post ?: MultipartField.of(null)).map { it.toImmutable() },
                            pre,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Transformation = apply {
                    if (validated) {
                        return@apply
                    }

                    post().ifPresent { it.forEach { it.validate() } }
                    pre()
                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: ImageKitInvalidDataException) {
                        false
                    }

                @JsonDeserialize(using = Post.Deserializer::class)
                @JsonSerialize(using = Post.Serializer::class)
                class Post
                private constructor(
                    private val transformation: InnerTransformation? = null,
                    private val gifToVideo: GifToVideo? = null,
                    private val thumbnail: Thumbnail? = null,
                    private val abs: Abs? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun transformation(): Optional<InnerTransformation> =
                        Optional.ofNullable(transformation)

                    fun gifToVideo(): Optional<GifToVideo> = Optional.ofNullable(gifToVideo)

                    fun thumbnail(): Optional<Thumbnail> = Optional.ofNullable(thumbnail)

                    fun abs(): Optional<Abs> = Optional.ofNullable(abs)

                    fun isTransformation(): Boolean = transformation != null

                    fun isGifToVideo(): Boolean = gifToVideo != null

                    fun isThumbnail(): Boolean = thumbnail != null

                    fun isAbs(): Boolean = abs != null

                    fun asTransformation(): InnerTransformation =
                        transformation.getOrThrow("transformation")

                    fun asGifToVideo(): GifToVideo = gifToVideo.getOrThrow("gifToVideo")

                    fun asThumbnail(): Thumbnail = thumbnail.getOrThrow("thumbnail")

                    fun asAbs(): Abs = abs.getOrThrow("abs")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T =
                        when {
                            transformation != null -> visitor.visitTransformation(transformation)
                            gifToVideo != null -> visitor.visitGifToVideo(gifToVideo)
                            thumbnail != null -> visitor.visitThumbnail(thumbnail)
                            abs != null -> visitor.visitAbs(abs)
                            else -> visitor.unknown(_json)
                        }

                    private var validated: Boolean = false

                    fun validate(): Post = apply {
                        if (validated) {
                            return@apply
                        }

                        accept(
                            object : Visitor<Unit> {
                                override fun visitTransformation(
                                    transformation: InnerTransformation
                                ) {
                                    transformation.validate()
                                }

                                override fun visitGifToVideo(gifToVideo: GifToVideo) {
                                    gifToVideo.validate()
                                }

                                override fun visitThumbnail(thumbnail: Thumbnail) {
                                    thumbnail.validate()
                                }

                                override fun visitAbs(abs: Abs) {
                                    abs.validate()
                                }
                            }
                        )
                        validated = true
                    }

                    fun isValid(): Boolean =
                        try {
                            validate()
                            true
                        } catch (e: ImageKitInvalidDataException) {
                            false
                        }

                    /**
                     * Returns a score indicating how many valid values are contained in this object
                     * recursively.
                     *
                     * Used for best match union deserialization.
                     */
                    @JvmSynthetic
                    internal fun validity(): Int =
                        accept(
                            object : Visitor<Int> {
                                override fun visitTransformation(
                                    transformation: InnerTransformation
                                ) = transformation.validity()

                                override fun visitGifToVideo(gifToVideo: GifToVideo) =
                                    gifToVideo.validity()

                                override fun visitThumbnail(thumbnail: Thumbnail) =
                                    thumbnail.validity()

                                override fun visitAbs(abs: Abs) = abs.validity()

                                override fun unknown(json: JsonValue?) = 0
                            }
                        )

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Post &&
                            transformation == other.transformation &&
                            gifToVideo == other.gifToVideo &&
                            thumbnail == other.thumbnail &&
                            abs == other.abs
                    }

                    override fun hashCode(): Int =
                        Objects.hash(transformation, gifToVideo, thumbnail, abs)

                    override fun toString(): String =
                        when {
                            transformation != null -> "Post{transformation=$transformation}"
                            gifToVideo != null -> "Post{gifToVideo=$gifToVideo}"
                            thumbnail != null -> "Post{thumbnail=$thumbnail}"
                            abs != null -> "Post{abs=$abs}"
                            _json != null -> "Post{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid Post")
                        }

                    companion object {

                        @JvmStatic
                        fun ofTransformation(transformation: InnerTransformation) =
                            Post(transformation = transformation)

                        @JvmStatic
                        fun ofGifToVideo(gifToVideo: GifToVideo) = Post(gifToVideo = gifToVideo)

                        @JvmStatic
                        fun ofThumbnail(thumbnail: Thumbnail) = Post(thumbnail = thumbnail)

                        @JvmStatic fun ofAbs(abs: Abs) = Post(abs = abs)
                    }

                    /**
                     * An interface that defines how to map each variant of [Post] to a value of
                     * type [T].
                     */
                    interface Visitor<out T> {

                        fun visitTransformation(transformation: InnerTransformation): T

                        fun visitGifToVideo(gifToVideo: GifToVideo): T

                        fun visitThumbnail(thumbnail: Thumbnail): T

                        fun visitAbs(abs: Abs): T

                        /**
                         * Maps an unknown variant of [Post] to a value of type [T].
                         *
                         * An instance of [Post] can contain an unknown variant if it was
                         * deserialized from data that doesn't match any known variant. For example,
                         * if the SDK is on an older version than the API, then the API may respond
                         * with new variants that the SDK is unaware of.
                         *
                         * @throws ImageKitInvalidDataException in the default implementation.
                         */
                        fun unknown(json: JsonValue?): T {
                            throw ImageKitInvalidDataException("Unknown Post: $json")
                        }
                    }

                    internal class Deserializer : BaseDeserializer<Post>(Post::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): Post {
                            val json = JsonValue.fromJsonNode(node)
                            val type =
                                json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                            when (type) {
                                "transformation" -> {
                                    return tryDeserialize(
                                            node,
                                            jacksonTypeRef<InnerTransformation>(),
                                        )
                                        ?.let { Post(transformation = it, _json = json) }
                                        ?: Post(_json = json)
                                }
                                "gif-to-video" -> {
                                    return tryDeserialize(node, jacksonTypeRef<GifToVideo>())?.let {
                                        Post(gifToVideo = it, _json = json)
                                    } ?: Post(_json = json)
                                }
                                "thumbnail" -> {
                                    return tryDeserialize(node, jacksonTypeRef<Thumbnail>())?.let {
                                        Post(thumbnail = it, _json = json)
                                    } ?: Post(_json = json)
                                }
                                "abs" -> {
                                    return tryDeserialize(node, jacksonTypeRef<Abs>())?.let {
                                        Post(abs = it, _json = json)
                                    } ?: Post(_json = json)
                                }
                            }

                            return Post(_json = json)
                        }
                    }

                    internal class Serializer : BaseSerializer<Post>(Post::class) {

                        override fun serialize(
                            value: Post,
                            generator: JsonGenerator,
                            provider: SerializerProvider,
                        ) {
                            when {
                                value.transformation != null ->
                                    generator.writeObject(value.transformation)
                                value.gifToVideo != null -> generator.writeObject(value.gifToVideo)
                                value.thumbnail != null -> generator.writeObject(value.thumbnail)
                                value.abs != null -> generator.writeObject(value.abs)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid Post")
                            }
                        }
                    }

                    class InnerTransformation
                    private constructor(
                        private val type: JsonValue,
                        private val value: MultipartField<String>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        /**
                         * Transformation type.
                         *
                         * Expected to always return the following:
                         * ```java
                         * JsonValue.from("transformation")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Transformation string (e.g. `w-200,h-200`). Same syntax as ImageKit
                         * URL-based transformations.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun value(): String = value.value.getRequired("value")

                        /**
                         * Returns the raw multipart value of [value].
                         *
                         * Unlike [value], this method doesn't throw if the multipart field has an
                         * unexpected type.
                         */
                        @JsonProperty("value")
                        @ExcludeMissing
                        fun _value(): MultipartField<String> = value

                        @JsonAnySetter
                        private fun putAdditionalProperty(key: String, value: JsonValue) {
                            additionalProperties.put(key, value)
                        }

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> =
                            Collections.unmodifiableMap(additionalProperties)

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [InnerTransformation].
                             *
                             * The following fields are required:
                             * ```java
                             * .value()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [InnerTransformation]. */
                        class Builder internal constructor() {

                            private var type: JsonValue = JsonValue.from("transformation")
                            private var value: MultipartField<String>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(innerTransformation: InnerTransformation) = apply {
                                type = innerTransformation.type
                                value = innerTransformation.value
                                additionalProperties =
                                    innerTransformation.additionalProperties.toMutableMap()
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```java
                             * JsonValue.from("transformation")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            /**
                             * Transformation string (e.g. `w-200,h-200`). Same syntax as ImageKit
                             * URL-based transformations.
                             */
                            fun value(value: String) = value(MultipartField.of(value))

                            /**
                             * Sets [Builder.value] to an arbitrary multipart value.
                             *
                             * You should usually call [Builder.value] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun value(value: MultipartField<String>) = apply { this.value = value }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [InnerTransformation].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .value()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): InnerTransformation =
                                InnerTransformation(
                                    type,
                                    checkRequired("value", value),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): InnerTransformation = apply {
                            if (validated) {
                                return@apply
                            }

                            _type().let {
                                if (it != JsonValue.from("transformation")) {
                                    throw ImageKitInvalidDataException(
                                        "'type' is invalid, received $it"
                                    )
                                }
                            }
                            value()
                            validated = true
                        }

                        fun isValid(): Boolean =
                            try {
                                validate()
                                true
                            } catch (e: ImageKitInvalidDataException) {
                                false
                            }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is InnerTransformation &&
                                type == other.type &&
                                value == other.value &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(type, value, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "InnerTransformation{type=$type, value=$value, additionalProperties=$additionalProperties}"
                    }

                    class GifToVideo
                    private constructor(
                        private val type: JsonValue,
                        private val value: MultipartField<String>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        /**
                         * Converts an animated GIF into an MP4.
                         *
                         * Expected to always return the following:
                         * ```java
                         * JsonValue.from("gif-to-video")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Optional transformation string to apply to the output video. **Example**:
                         * `q-80`
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun value(): Optional<String> = value.value.getOptional("value")

                        /**
                         * Returns the raw multipart value of [value].
                         *
                         * Unlike [value], this method doesn't throw if the multipart field has an
                         * unexpected type.
                         */
                        @JsonProperty("value")
                        @ExcludeMissing
                        fun _value(): MultipartField<String> = value

                        @JsonAnySetter
                        private fun putAdditionalProperty(key: String, value: JsonValue) {
                            additionalProperties.put(key, value)
                        }

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> =
                            Collections.unmodifiableMap(additionalProperties)

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [GifToVideo].
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [GifToVideo]. */
                        class Builder internal constructor() {

                            private var type: JsonValue = JsonValue.from("gif-to-video")
                            private var value: MultipartField<String> = MultipartField.of(null)
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(gifToVideo: GifToVideo) = apply {
                                type = gifToVideo.type
                                value = gifToVideo.value
                                additionalProperties =
                                    gifToVideo.additionalProperties.toMutableMap()
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```java
                             * JsonValue.from("gif-to-video")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            /**
                             * Optional transformation string to apply to the output video.
                             * **Example**: `q-80`
                             */
                            fun value(value: String) = value(MultipartField.of(value))

                            /**
                             * Sets [Builder.value] to an arbitrary multipart value.
                             *
                             * You should usually call [Builder.value] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun value(value: MultipartField<String>) = apply { this.value = value }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [GifToVideo].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): GifToVideo =
                                GifToVideo(type, value, additionalProperties.toMutableMap())
                        }

                        private var validated: Boolean = false

                        fun validate(): GifToVideo = apply {
                            if (validated) {
                                return@apply
                            }

                            _type().let {
                                if (it != JsonValue.from("gif-to-video")) {
                                    throw ImageKitInvalidDataException(
                                        "'type' is invalid, received $it"
                                    )
                                }
                            }
                            value()
                            validated = true
                        }

                        fun isValid(): Boolean =
                            try {
                                validate()
                                true
                            } catch (e: ImageKitInvalidDataException) {
                                false
                            }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is GifToVideo &&
                                type == other.type &&
                                value == other.value &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(type, value, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "GifToVideo{type=$type, value=$value, additionalProperties=$additionalProperties}"
                    }

                    class Thumbnail
                    private constructor(
                        private val type: JsonValue,
                        private val value: MultipartField<String>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        /**
                         * Generates a thumbnail image.
                         *
                         * Expected to always return the following:
                         * ```java
                         * JsonValue.from("thumbnail")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Optional transformation string. **Example**: `w-150,h-150`
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun value(): Optional<String> = value.value.getOptional("value")

                        /**
                         * Returns the raw multipart value of [value].
                         *
                         * Unlike [value], this method doesn't throw if the multipart field has an
                         * unexpected type.
                         */
                        @JsonProperty("value")
                        @ExcludeMissing
                        fun _value(): MultipartField<String> = value

                        @JsonAnySetter
                        private fun putAdditionalProperty(key: String, value: JsonValue) {
                            additionalProperties.put(key, value)
                        }

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> =
                            Collections.unmodifiableMap(additionalProperties)

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [Thumbnail].
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Thumbnail]. */
                        class Builder internal constructor() {

                            private var type: JsonValue = JsonValue.from("thumbnail")
                            private var value: MultipartField<String> = MultipartField.of(null)
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(thumbnail: Thumbnail) = apply {
                                type = thumbnail.type
                                value = thumbnail.value
                                additionalProperties = thumbnail.additionalProperties.toMutableMap()
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```java
                             * JsonValue.from("thumbnail")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            /** Optional transformation string. **Example**: `w-150,h-150` */
                            fun value(value: String) = value(MultipartField.of(value))

                            /**
                             * Sets [Builder.value] to an arbitrary multipart value.
                             *
                             * You should usually call [Builder.value] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun value(value: MultipartField<String>) = apply { this.value = value }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Thumbnail].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): Thumbnail =
                                Thumbnail(type, value, additionalProperties.toMutableMap())
                        }

                        private var validated: Boolean = false

                        fun validate(): Thumbnail = apply {
                            if (validated) {
                                return@apply
                            }

                            _type().let {
                                if (it != JsonValue.from("thumbnail")) {
                                    throw ImageKitInvalidDataException(
                                        "'type' is invalid, received $it"
                                    )
                                }
                            }
                            value()
                            validated = true
                        }

                        fun isValid(): Boolean =
                            try {
                                validate()
                                true
                            } catch (e: ImageKitInvalidDataException) {
                                false
                            }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Thumbnail &&
                                type == other.type &&
                                value == other.value &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(type, value, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Thumbnail{type=$type, value=$value, additionalProperties=$additionalProperties}"
                    }

                    class Abs
                    private constructor(
                        private val protocol: MultipartField<Protocol>,
                        private val type: JsonValue,
                        private val value: MultipartField<String>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        /**
                         * Streaming protocol to use (`hls` or `dash`).
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun protocol(): Protocol = protocol.value.getRequired("protocol")

                        /**
                         * Adaptive Bitrate Streaming (ABS) setup.
                         *
                         * Expected to always return the following:
                         * ```java
                         * JsonValue.from("abs")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * List of different representations you want to create separated by an
                         * underscore.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun value(): String = value.value.getRequired("value")

                        /**
                         * Returns the raw multipart value of [protocol].
                         *
                         * Unlike [protocol], this method doesn't throw if the multipart field has
                         * an unexpected type.
                         */
                        @JsonProperty("protocol")
                        @ExcludeMissing
                        fun _protocol(): MultipartField<Protocol> = protocol

                        /**
                         * Returns the raw multipart value of [value].
                         *
                         * Unlike [value], this method doesn't throw if the multipart field has an
                         * unexpected type.
                         */
                        @JsonProperty("value")
                        @ExcludeMissing
                        fun _value(): MultipartField<String> = value

                        @JsonAnySetter
                        private fun putAdditionalProperty(key: String, value: JsonValue) {
                            additionalProperties.put(key, value)
                        }

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> =
                            Collections.unmodifiableMap(additionalProperties)

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of [Abs].
                             *
                             * The following fields are required:
                             * ```java
                             * .protocol()
                             * .value()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Abs]. */
                        class Builder internal constructor() {

                            private var protocol: MultipartField<Protocol>? = null
                            private var type: JsonValue = JsonValue.from("abs")
                            private var value: MultipartField<String>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(abs: Abs) = apply {
                                protocol = abs.protocol
                                type = abs.type
                                value = abs.value
                                additionalProperties = abs.additionalProperties.toMutableMap()
                            }

                            /** Streaming protocol to use (`hls` or `dash`). */
                            fun protocol(protocol: Protocol) = protocol(MultipartField.of(protocol))

                            /**
                             * Sets [Builder.protocol] to an arbitrary multipart value.
                             *
                             * You should usually call [Builder.protocol] with a well-typed
                             * [Protocol] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun protocol(protocol: MultipartField<Protocol>) = apply {
                                this.protocol = protocol
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```java
                             * JsonValue.from("abs")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            /**
                             * List of different representations you want to create separated by an
                             * underscore.
                             */
                            fun value(value: String) = value(MultipartField.of(value))

                            /**
                             * Sets [Builder.value] to an arbitrary multipart value.
                             *
                             * You should usually call [Builder.value] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun value(value: MultipartField<String>) = apply { this.value = value }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Abs].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .protocol()
                             * .value()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): Abs =
                                Abs(
                                    checkRequired("protocol", protocol),
                                    type,
                                    checkRequired("value", value),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): Abs = apply {
                            if (validated) {
                                return@apply
                            }

                            protocol().validate()
                            _type().let {
                                if (it != JsonValue.from("abs")) {
                                    throw ImageKitInvalidDataException(
                                        "'type' is invalid, received $it"
                                    )
                                }
                            }
                            value()
                            validated = true
                        }

                        fun isValid(): Boolean =
                            try {
                                validate()
                                true
                            } catch (e: ImageKitInvalidDataException) {
                                false
                            }

                        /** Streaming protocol to use (`hls` or `dash`). */
                        class Protocol
                        @JsonCreator
                        private constructor(private val value: JsonField<String>) : Enum {

                            /**
                             * Returns this class instance's raw value.
                             *
                             * This is usually only useful if this instance was deserialized from
                             * data that doesn't match any known member, and you want to know that
                             * value. For example, if the SDK is on an older version than the API,
                             * then the API may respond with new members that the SDK is unaware of.
                             */
                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            companion object {

                                @JvmField val HLS = of("hls")

                                @JvmField val DASH = of("dash")

                                @JvmStatic fun of(value: String) = Protocol(JsonField.of(value))
                            }

                            /** An enum containing [Protocol]'s known values. */
                            enum class Known {
                                HLS,
                                DASH,
                            }

                            /**
                             * An enum containing [Protocol]'s known values, as well as an
                             * [_UNKNOWN] member.
                             *
                             * An instance of [Protocol] can contain an unknown value in a couple of
                             * cases:
                             * - It was deserialized from data that doesn't match any known member.
                             *   For example, if the SDK is on an older version than the API, then
                             *   the API may respond with new members that the SDK is unaware of.
                             * - It was constructed with an arbitrary value using the [of] method.
                             */
                            enum class Value {
                                HLS,
                                DASH,
                                /**
                                 * An enum member indicating that [Protocol] was instantiated with
                                 * an unknown value.
                                 */
                                _UNKNOWN,
                            }

                            /**
                             * Returns an enum member corresponding to this class instance's value,
                             * or [Value._UNKNOWN] if the class was instantiated with an unknown
                             * value.
                             *
                             * Use the [known] method instead if you're certain the value is always
                             * known or if you want to throw for the unknown case.
                             */
                            fun value(): Value =
                                when (this) {
                                    HLS -> Value.HLS
                                    DASH -> Value.DASH
                                    else -> Value._UNKNOWN
                                }

                            /**
                             * Returns an enum member corresponding to this class instance's value.
                             *
                             * Use the [value] method instead if you're uncertain the value is
                             * always known and don't want to throw for the unknown case.
                             *
                             * @throws ImageKitInvalidDataException if this class instance's value
                             *   is a not a known member.
                             */
                            fun known(): Known =
                                when (this) {
                                    HLS -> Known.HLS
                                    DASH -> Known.DASH
                                    else ->
                                        throw ImageKitInvalidDataException(
                                            "Unknown Protocol: $value"
                                        )
                                }

                            /**
                             * Returns this class instance's primitive wire representation.
                             *
                             * This differs from the [toString] method because that method is
                             * primarily for debugging and generally doesn't throw.
                             *
                             * @throws ImageKitInvalidDataException if this class instance's value
                             *   does not have the expected primitive type.
                             */
                            fun asString(): String =
                                _value().asString().orElseThrow {
                                    ImageKitInvalidDataException("Value is not a String")
                                }

                            private var validated: Boolean = false

                            fun validate(): Protocol = apply {
                                if (validated) {
                                    return@apply
                                }

                                known()
                                validated = true
                            }

                            fun isValid(): Boolean =
                                try {
                                    validate()
                                    true
                                } catch (e: ImageKitInvalidDataException) {
                                    false
                                }

                            /**
                             * Returns a score indicating how many valid values are contained in
                             * this object recursively.
                             *
                             * Used for best match union deserialization.
                             */
                            @JvmSynthetic
                            internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is Protocol && value == other.value
                            }

                            override fun hashCode() = value.hashCode()

                            override fun toString() = value.toString()
                        }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Abs &&
                                protocol == other.protocol &&
                                type == other.type &&
                                value == other.value &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(protocol, type, value, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Abs{protocol=$protocol, type=$type, value=$value, additionalProperties=$additionalProperties}"
                    }
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Transformation &&
                        post == other.post &&
                        pre == other.pre &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(post, pre, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Transformation{post=$post, pre=$pre, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is FileUploadByUrlv1 &&
                    file == other.file &&
                    fileName == other.fileName &&
                    token == other.token &&
                    checks == other.checks &&
                    customCoordinates == other.customCoordinates &&
                    customMetadata == other.customMetadata &&
                    description == other.description &&
                    expire == other.expire &&
                    extensions == other.extensions &&
                    folder == other.folder &&
                    isPrivateFile == other.isPrivateFile &&
                    isPublished == other.isPublished &&
                    overwriteAiTags == other.overwriteAiTags &&
                    overwriteCustomMetadata == other.overwriteCustomMetadata &&
                    overwriteFile == other.overwriteFile &&
                    overwriteTags == other.overwriteTags &&
                    publicKey == other.publicKey &&
                    responseFields == other.responseFields &&
                    signature == other.signature &&
                    tags == other.tags &&
                    transformation == other.transformation &&
                    useUniqueFileName == other.useUniqueFileName &&
                    webhookUrl == other.webhookUrl &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    file,
                    fileName,
                    token,
                    checks,
                    customCoordinates,
                    customMetadata,
                    description,
                    expire,
                    extensions,
                    folder,
                    isPrivateFile,
                    isPublished,
                    overwriteAiTags,
                    overwriteCustomMetadata,
                    overwriteFile,
                    overwriteTags,
                    publicKey,
                    responseFields,
                    signature,
                    tags,
                    transformation,
                    useUniqueFileName,
                    webhookUrl,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FileUploadByUrlv1{file=$file, fileName=$fileName, token=$token, checks=$checks, customCoordinates=$customCoordinates, customMetadata=$customMetadata, description=$description, expire=$expire, extensions=$extensions, folder=$folder, isPrivateFile=$isPrivateFile, isPublished=$isPublished, overwriteAiTags=$overwriteAiTags, overwriteCustomMetadata=$overwriteCustomMetadata, overwriteFile=$overwriteFile, overwriteTags=$overwriteTags, publicKey=$publicKey, responseFields=$responseFields, signature=$signature, tags=$tags, transformation=$transformation, useUniqueFileName=$useUniqueFileName, webhookUrl=$webhookUrl, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileUploadParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "FileUploadParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
