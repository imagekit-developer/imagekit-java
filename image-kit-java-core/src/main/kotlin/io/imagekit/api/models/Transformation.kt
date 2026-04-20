// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models

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
import io.imagekit.api.core.BaseDeserializer
import io.imagekit.api.core.BaseSerializer
import io.imagekit.api.core.Enum
import io.imagekit.api.core.ExcludeMissing
import io.imagekit.api.core.JsonField
import io.imagekit.api.core.JsonMissing
import io.imagekit.api.core.JsonValue
import io.imagekit.api.core.allMaxBy
import io.imagekit.api.core.checkKnown
import io.imagekit.api.core.getOrThrow
import io.imagekit.api.core.toImmutable
import io.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * The SDK provides easy-to-use names for transformations. These names are converted to the
 * corresponding transformation string before being added to the URL. SDKs are updated regularly to
 * support new transformations. If you want to use a transformation that is not supported by the
 * SDK, You can use the `raw` parameter to pass the transformation string directly. See the
 * [Transformations documentation](https://imagekit.io/docs/transformations).
 */
class Transformation
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val aiChangeBackground: JsonField<String>,
    private val aiDropShadow: JsonField<AiDropShadow>,
    private val aiEdit: JsonField<String>,
    private val aiRemoveBackground: JsonField<AiRemoveBackground>,
    private val aiRemoveBackgroundExternal: JsonField<AiRemoveBackgroundExternal>,
    private val aiRetouch: JsonField<AiRetouch>,
    private val aiUpscale: JsonField<AiUpscale>,
    private val aiVariation: JsonField<AiVariation>,
    private val aspectRatio: JsonField<AspectRatio>,
    private val audioCodec: JsonField<AudioCodec>,
    private val background: JsonField<String>,
    private val blur: JsonField<Double>,
    private val border: JsonField<String>,
    private val colorProfile: JsonField<Boolean>,
    private val colorReplace: JsonField<String>,
    private val contrastStretch: JsonField<ContrastStretch>,
    private val crop: JsonField<Crop>,
    private val cropMode: JsonField<CropMode>,
    private val defaultImage: JsonField<String>,
    private val distort: JsonField<String>,
    private val dpr: JsonField<Double>,
    private val duration: JsonField<Duration>,
    private val endOffset: JsonField<EndOffset>,
    private val flip: JsonField<Flip>,
    private val focus: JsonField<String>,
    private val format: JsonField<Format>,
    private val gradient: JsonField<Gradient>,
    private val grayscale: JsonField<Grayscale>,
    private val height: JsonField<Height>,
    private val lossless: JsonField<Boolean>,
    private val metadata: JsonField<Boolean>,
    private val named: JsonField<String>,
    private val opacity: JsonField<Double>,
    private val original: JsonField<Boolean>,
    private val overlay: JsonField<Overlay>,
    private val page: JsonField<Page>,
    private val progressive: JsonField<Boolean>,
    private val quality: JsonField<Double>,
    private val radius: JsonField<Radius>,
    private val raw: JsonField<String>,
    private val rotation: JsonField<Rotation>,
    private val shadow: JsonField<Shadow>,
    private val sharpen: JsonField<Sharpen>,
    private val startOffset: JsonField<StartOffset>,
    private val streamingResolutions: JsonField<List<StreamingResolution>>,
    private val trim: JsonField<Trim>,
    private val unsharpMask: JsonField<UnsharpMask>,
    private val videoCodec: JsonField<VideoCodec>,
    private val width: JsonField<Width>,
    private val x: JsonField<X>,
    private val xCenter: JsonField<XCenter>,
    private val y: JsonField<Y>,
    private val yCenter: JsonField<YCenter>,
    private val zoom: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("aiChangeBackground")
        @ExcludeMissing
        aiChangeBackground: JsonField<String> = JsonMissing.of(),
        @JsonProperty("aiDropShadow")
        @ExcludeMissing
        aiDropShadow: JsonField<AiDropShadow> = JsonMissing.of(),
        @JsonProperty("aiEdit") @ExcludeMissing aiEdit: JsonField<String> = JsonMissing.of(),
        @JsonProperty("aiRemoveBackground")
        @ExcludeMissing
        aiRemoveBackground: JsonField<AiRemoveBackground> = JsonMissing.of(),
        @JsonProperty("aiRemoveBackgroundExternal")
        @ExcludeMissing
        aiRemoveBackgroundExternal: JsonField<AiRemoveBackgroundExternal> = JsonMissing.of(),
        @JsonProperty("aiRetouch")
        @ExcludeMissing
        aiRetouch: JsonField<AiRetouch> = JsonMissing.of(),
        @JsonProperty("aiUpscale")
        @ExcludeMissing
        aiUpscale: JsonField<AiUpscale> = JsonMissing.of(),
        @JsonProperty("aiVariation")
        @ExcludeMissing
        aiVariation: JsonField<AiVariation> = JsonMissing.of(),
        @JsonProperty("aspectRatio")
        @ExcludeMissing
        aspectRatio: JsonField<AspectRatio> = JsonMissing.of(),
        @JsonProperty("audioCodec")
        @ExcludeMissing
        audioCodec: JsonField<AudioCodec> = JsonMissing.of(),
        @JsonProperty("background")
        @ExcludeMissing
        background: JsonField<String> = JsonMissing.of(),
        @JsonProperty("blur") @ExcludeMissing blur: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("border") @ExcludeMissing border: JsonField<String> = JsonMissing.of(),
        @JsonProperty("colorProfile")
        @ExcludeMissing
        colorProfile: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("colorReplace")
        @ExcludeMissing
        colorReplace: JsonField<String> = JsonMissing.of(),
        @JsonProperty("contrastStretch")
        @ExcludeMissing
        contrastStretch: JsonField<ContrastStretch> = JsonMissing.of(),
        @JsonProperty("crop") @ExcludeMissing crop: JsonField<Crop> = JsonMissing.of(),
        @JsonProperty("cropMode") @ExcludeMissing cropMode: JsonField<CropMode> = JsonMissing.of(),
        @JsonProperty("defaultImage")
        @ExcludeMissing
        defaultImage: JsonField<String> = JsonMissing.of(),
        @JsonProperty("distort") @ExcludeMissing distort: JsonField<String> = JsonMissing.of(),
        @JsonProperty("dpr") @ExcludeMissing dpr: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("duration") @ExcludeMissing duration: JsonField<Duration> = JsonMissing.of(),
        @JsonProperty("endOffset")
        @ExcludeMissing
        endOffset: JsonField<EndOffset> = JsonMissing.of(),
        @JsonProperty("flip") @ExcludeMissing flip: JsonField<Flip> = JsonMissing.of(),
        @JsonProperty("focus") @ExcludeMissing focus: JsonField<String> = JsonMissing.of(),
        @JsonProperty("format") @ExcludeMissing format: JsonField<Format> = JsonMissing.of(),
        @JsonProperty("gradient") @ExcludeMissing gradient: JsonField<Gradient> = JsonMissing.of(),
        @JsonProperty("grayscale")
        @ExcludeMissing
        grayscale: JsonField<Grayscale> = JsonMissing.of(),
        @JsonProperty("height") @ExcludeMissing height: JsonField<Height> = JsonMissing.of(),
        @JsonProperty("lossless") @ExcludeMissing lossless: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("metadata") @ExcludeMissing metadata: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("named") @ExcludeMissing named: JsonField<String> = JsonMissing.of(),
        @JsonProperty("opacity") @ExcludeMissing opacity: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("original") @ExcludeMissing original: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("overlay") @ExcludeMissing overlay: JsonField<Overlay> = JsonMissing.of(),
        @JsonProperty("page") @ExcludeMissing page: JsonField<Page> = JsonMissing.of(),
        @JsonProperty("progressive")
        @ExcludeMissing
        progressive: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("quality") @ExcludeMissing quality: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("radius") @ExcludeMissing radius: JsonField<Radius> = JsonMissing.of(),
        @JsonProperty("raw") @ExcludeMissing raw: JsonField<String> = JsonMissing.of(),
        @JsonProperty("rotation") @ExcludeMissing rotation: JsonField<Rotation> = JsonMissing.of(),
        @JsonProperty("shadow") @ExcludeMissing shadow: JsonField<Shadow> = JsonMissing.of(),
        @JsonProperty("sharpen") @ExcludeMissing sharpen: JsonField<Sharpen> = JsonMissing.of(),
        @JsonProperty("startOffset")
        @ExcludeMissing
        startOffset: JsonField<StartOffset> = JsonMissing.of(),
        @JsonProperty("streamingResolutions")
        @ExcludeMissing
        streamingResolutions: JsonField<List<StreamingResolution>> = JsonMissing.of(),
        @JsonProperty("trim") @ExcludeMissing trim: JsonField<Trim> = JsonMissing.of(),
        @JsonProperty("unsharpMask")
        @ExcludeMissing
        unsharpMask: JsonField<UnsharpMask> = JsonMissing.of(),
        @JsonProperty("videoCodec")
        @ExcludeMissing
        videoCodec: JsonField<VideoCodec> = JsonMissing.of(),
        @JsonProperty("width") @ExcludeMissing width: JsonField<Width> = JsonMissing.of(),
        @JsonProperty("x") @ExcludeMissing x: JsonField<X> = JsonMissing.of(),
        @JsonProperty("xCenter") @ExcludeMissing xCenter: JsonField<XCenter> = JsonMissing.of(),
        @JsonProperty("y") @ExcludeMissing y: JsonField<Y> = JsonMissing.of(),
        @JsonProperty("yCenter") @ExcludeMissing yCenter: JsonField<YCenter> = JsonMissing.of(),
        @JsonProperty("zoom") @ExcludeMissing zoom: JsonField<Double> = JsonMissing.of(),
    ) : this(
        aiChangeBackground,
        aiDropShadow,
        aiEdit,
        aiRemoveBackground,
        aiRemoveBackgroundExternal,
        aiRetouch,
        aiUpscale,
        aiVariation,
        aspectRatio,
        audioCodec,
        background,
        blur,
        border,
        colorProfile,
        colorReplace,
        contrastStretch,
        crop,
        cropMode,
        defaultImage,
        distort,
        dpr,
        duration,
        endOffset,
        flip,
        focus,
        format,
        gradient,
        grayscale,
        height,
        lossless,
        metadata,
        named,
        opacity,
        original,
        overlay,
        page,
        progressive,
        quality,
        radius,
        raw,
        rotation,
        shadow,
        sharpen,
        startOffset,
        streamingResolutions,
        trim,
        unsharpMask,
        videoCodec,
        width,
        x,
        xCenter,
        y,
        yCenter,
        zoom,
        mutableMapOf(),
    )

    /**
     * Uses AI to change the background. Provide a text prompt or a base64-encoded prompt, e.g.,
     * `prompt-snow road` or `prompte-[urlencoded_base64_encoded_text]`. Not supported inside
     * overlay. See
     * [AI Change Background](https://imagekit.io/docs/ai-transformations#change-background-e-changebg).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun aiChangeBackground(): Optional<String> =
        aiChangeBackground.getOptional("aiChangeBackground")

    /**
     * Adds an AI-based drop shadow around a foreground object on a transparent or removed
     * background. Optionally, control the direction, elevation, and saturation of the light source
     * (e.g., `az-45` to change light direction). Pass `true` for the default drop shadow, or
     * provide a string for a custom drop shadow. Supported inside overlay. See
     * [AI Drop Shadow](https://imagekit.io/docs/ai-transformations#ai-drop-shadow-e-dropshadow).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun aiDropShadow(): Optional<AiDropShadow> = aiDropShadow.getOptional("aiDropShadow")

    /**
     * Uses AI to edit images based on a text prompt. Provide a text prompt or a base64-encoded
     * prompt, e.g., `prompt-snow road` or `prompte-[urlencoded_base64_encoded_text]`. Not supported
     * inside overlay. See [AI Edit](https://imagekit.io/docs/ai-transformations#edit-image-e-edit).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun aiEdit(): Optional<String> = aiEdit.getOptional("aiEdit")

    /**
     * Applies ImageKit's in-house background removal. Supported inside overlay. See
     * [AI Background Removal](https://imagekit.io/docs/ai-transformations#imagekit-background-removal-e-bgremove).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun aiRemoveBackground(): Optional<AiRemoveBackground> =
        aiRemoveBackground.getOptional("aiRemoveBackground")

    /**
     * Uses third-party background removal. Note: It is recommended to use aiRemoveBackground,
     * ImageKit's in-house solution, which is more cost-effective. Supported inside overlay. See
     * [External Background Removal](https://imagekit.io/docs/ai-transformations#background-removal-e-removedotbg).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun aiRemoveBackgroundExternal(): Optional<AiRemoveBackgroundExternal> =
        aiRemoveBackgroundExternal.getOptional("aiRemoveBackgroundExternal")

    /**
     * Performs AI-based retouching to improve faces or product shots. Not supported inside overlay.
     * See [AI Retouch](https://imagekit.io/docs/ai-transformations#retouch-e-retouch).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun aiRetouch(): Optional<AiRetouch> = aiRetouch.getOptional("aiRetouch")

    /**
     * Upscales images beyond their original dimensions using AI. Not supported inside overlay. See
     * [AI Upscale](https://imagekit.io/docs/ai-transformations#upscale-e-upscale).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun aiUpscale(): Optional<AiUpscale> = aiUpscale.getOptional("aiUpscale")

    /**
     * Generates a variation of an image using AI. This produces a new image with slight variations
     * from the original, such as changes in color, texture, and other visual elements, while
     * preserving the structure and essence of the original image. Not supported inside overlay. See
     * [AI Generate Variations](https://imagekit.io/docs/ai-transformations#generate-variations-of-an-image-e-genvar).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun aiVariation(): Optional<AiVariation> = aiVariation.getOptional("aiVariation")

    /**
     * Specifies the aspect ratio for the output, e.g., "ar-4-3". Typically used with either width
     * or height (but not both). For example: aspectRatio = `4:3`, `4_3`, or an expression like
     * `iar_div_2`. See
     * [Image resize and crop – Aspect ratio](https://imagekit.io/docs/image-resize-and-crop#aspect-ratio---ar).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun aspectRatio(): Optional<AspectRatio> = aspectRatio.getOptional("aspectRatio")

    /**
     * Specifies the audio codec, e.g., `aac`, `opus`, or `none`. See
     * [Audio codec](https://imagekit.io/docs/video-optimization#audio-codec---ac).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun audioCodec(): Optional<AudioCodec> = audioCodec.getOptional("audioCodec")

    /**
     * Specifies the background to be used in conjunction with certain cropping strategies when
     * resizing an image.
     * - A solid color: e.g., `red`, `F3F3F3`, `AAFF0010`. See
     *   [Solid color background](https://imagekit.io/docs/effects-and-enhancements#solid-color-background).
     * - Dominant color: `dominant` extracts the dominant color from the image. See
     *   [Dominant color background](https://imagekit.io/docs/effects-and-enhancements#dominant-color-background).
     * - Gradient: `gradient_dominant` or `gradient_dominant_2` creates a gradient using the
     *   dominant colors. Optionally specify palette size (2 or 4), e.g., `gradient_dominant_4`. See
     *   [Gradient background](https://imagekit.io/docs/effects-and-enhancements#gradient-background).
     * - A blurred background: e.g., `blurred`, `blurred_25_N15`, etc. See
     *   [Blurred background](https://imagekit.io/docs/effects-and-enhancements#blurred-background).
     * - Expand the image boundaries using generative fill: `genfill`. Not supported inside overlay.
     *   Optionally, control the background scene by passing a text prompt:
     *   `genfill[:-prompt-${text}]` or `genfill[:-prompte-${urlencoded_base64_encoded_text}]`. See
     *   [Generative fill background](https://imagekit.io/docs/ai-transformations#generative-fill-bg-genfill).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun background(): Optional<String> = background.getOptional("background")

    /**
     * Specifies the Gaussian blur level. Accepts an integer value between 1 and 100, or an
     * expression like `bl-10`. See
     * [Blur](https://imagekit.io/docs/effects-and-enhancements#blur---bl).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun blur(): Optional<Double> = blur.getOptional("blur")

    /**
     * Adds a border to the output media. Accepts a string in the format `<border-width>_<hex-code>`
     * (e.g., `5_FFF000` for a 5px yellow border), or an expression like `ih_div_20_FF00FF`. See
     * [Border](https://imagekit.io/docs/effects-and-enhancements#border---b).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun border(): Optional<String> = border.getOptional("border")

    /**
     * Indicates whether the output image should retain the original color profile. See
     * [Color profile](https://imagekit.io/docs/image-optimization#color-profile---cp).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun colorProfile(): Optional<Boolean> = colorProfile.getOptional("colorProfile")

    /**
     * Replaces colors in the image. Supports three formats:
     * - `toColor` - Replace dominant color with the specified color.
     * - `toColor_tolerance` - Replace dominant color with specified tolerance (0-100).
     * - `toColor_tolerance_fromColor` - Replace a specific color with another within tolerance
     *   range. Colors can be hex codes (e.g., `FF0022`) or names (e.g., `red`, `blue`). See
     *   [Color replacement](https://imagekit.io/docs/effects-and-enhancements#color-replace---cr).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun colorReplace(): Optional<String> = colorReplace.getOptional("colorReplace")

    /**
     * Automatically enhances the contrast of an image (contrast stretch). See
     * [Contrast Stretch](https://imagekit.io/docs/effects-and-enhancements#contrast-stretch---e-contrast).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun contrastStretch(): Optional<ContrastStretch> =
        contrastStretch.getOptional("contrastStretch")

    /**
     * Crop modes for image resizing. See
     * [Crop modes & focus](https://imagekit.io/docs/image-resize-and-crop#crop-crop-modes--focus).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun crop(): Optional<Crop> = crop.getOptional("crop")

    /**
     * Additional crop modes for image resizing. See
     * [Crop modes & focus](https://imagekit.io/docs/image-resize-and-crop#crop-crop-modes--focus).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cropMode(): Optional<CropMode> = cropMode.getOptional("cropMode")

    /**
     * Specifies a fallback image if the resource is not found, e.g., a URL or file path. See
     * [Default image](https://imagekit.io/docs/image-transformation#default-image---di).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun defaultImage(): Optional<String> = defaultImage.getOptional("defaultImage")

    /**
     * Distorts the shape of an image. Supports two modes:
     * - Perspective distortion: `p-x1_y1_x2_y2_x3_y3_x4_y4` changes the position of the four
     *   corners starting clockwise from top-left.
     * - Arc distortion: `a-degrees` curves the image upwards (positive values) or downwards
     *   (negative values). See
     *   [Distort effect](https://imagekit.io/docs/effects-and-enhancements#distort---e-distort).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun distort(): Optional<String> = distort.getOptional("distort")

    /**
     * Accepts values between 0.1 and 5, or `auto` for automatic device pixel ratio (DPR)
     * calculation. Also accepts arithmetic expressions.
     * - Learn about
     *   [Arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
     * - See [DPR](https://imagekit.io/docs/image-resize-and-crop#dpr---dpr).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun dpr(): Optional<Double> = dpr.getOptional("dpr")

    /**
     * Specifies the duration (in seconds) for trimming videos, e.g., `5` or `10.5`. Typically used
     * with startOffset to indicate the length from the start offset. Arithmetic expressions are
     * supported. See [Trim videos – Duration](https://imagekit.io/docs/trim-videos#duration---du).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun duration(): Optional<Duration> = duration.getOptional("duration")

    /**
     * Specifies the end offset (in seconds) for trimming videos, e.g., `5` or `10.5`. Typically
     * used with startOffset to define a time window. Arithmetic expressions are supported. See
     * [Trim videos – End offset](https://imagekit.io/docs/trim-videos#end-offset---eo).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun endOffset(): Optional<EndOffset> = endOffset.getOptional("endOffset")

    /**
     * Flips or mirrors an image either horizontally, vertically, or both. Acceptable values: `h`
     * (horizontal), `v` (vertical), `h_v` (horizontal and vertical), or `v_h`. See
     * [Flip](https://imagekit.io/docs/effects-and-enhancements#flip---fl).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun flip(): Optional<Flip> = flip.getOptional("flip")

    /**
     * Refines padding and cropping behavior for pad resize, maintain ratio, and extract crop modes.
     * Supports manual positions and coordinate-based focus. With AI-based cropping, you can
     * automatically keep key subjects in frame—such as faces or detected objects (e.g., `fo-face`,
     * `fo-person`, `fo-car`)— while resizing.
     * - See [Focus](https://imagekit.io/docs/image-resize-and-crop#focus---fo).
     * - [Object aware
     *   cropping](https://imagekit.io/docs/image-resize-and-crop#object-aware-cropping---fo-object-name)
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun focus(): Optional<String> = focus.getOptional("focus")

    /**
     * Specifies the output format for images or videos, e.g., `jpg`, `png`, `webp`, `mp4`, or
     * `auto`. You can also pass `orig` for images to return the original format. ImageKit
     * automatically delivers images and videos in the optimal format based on device support unless
     * overridden by the dashboard settings or the format parameter. See
     * [Image format](https://imagekit.io/docs/image-optimization#format---f) and
     * [Video format](https://imagekit.io/docs/video-optimization#format---f).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun format(): Optional<Format> = format.getOptional("format")

    /**
     * Creates a linear gradient with two colors. Pass `true` for a default gradient, or provide a
     * string for a custom gradient. See
     * [Gradient](https://imagekit.io/docs/effects-and-enhancements#gradient---e-gradient).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun gradient(): Optional<Gradient> = gradient.getOptional("gradient")

    /**
     * Enables a grayscale effect for images. See
     * [Grayscale](https://imagekit.io/docs/effects-and-enhancements#grayscale---e-grayscale).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun grayscale(): Optional<Grayscale> = grayscale.getOptional("grayscale")

    /**
     * Specifies the height of the output. If a value between 0 and 1 is provided, it is treated as
     * a percentage (e.g., `0.5` represents 50% of the original height). You can also supply
     * arithmetic expressions (e.g., `ih_mul_0.5`). Height transformation –
     * [Images](https://imagekit.io/docs/image-resize-and-crop#height---h) ·
     * [Videos](https://imagekit.io/docs/video-resize-and-crop#height---h)
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun height(): Optional<Height> = height.getOptional("height")

    /**
     * Specifies whether the output image (in JPEG or PNG) should be compressed losslessly. See
     * [Lossless compression](https://imagekit.io/docs/image-optimization#lossless-webp-and-png---lo).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun lossless(): Optional<Boolean> = lossless.getOptional("lossless")

    /**
     * By default, ImageKit removes all metadata during automatic image compression. Set this to
     * true to preserve metadata. See
     * [Image metadata](https://imagekit.io/docs/image-optimization#image-metadata---md).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun metadata(): Optional<Boolean> = metadata.getOptional("metadata")

    /**
     * Named transformation reference. See
     * [Named transformations](https://imagekit.io/docs/transformations#named-transformations).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun named(): Optional<String> = named.getOptional("named")

    /**
     * Specifies the opacity level of the output image. See
     * [Opacity](https://imagekit.io/docs/effects-and-enhancements#opacity---o).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun opacity(): Optional<Double> = opacity.getOptional("opacity")

    /**
     * If set to true, serves the original file without applying any transformations. See
     * [Deliver original file as-is](https://imagekit.io/docs/core-delivery-features#deliver-original-file-as-is---orig-true).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun original(): Optional<Boolean> = original.getOptional("original")

    /**
     * Specifies an overlay to be applied on the parent image or video. ImageKit supports overlays
     * including images, text, videos, subtitles, and solid colors. See
     * [Overlay using layers](https://imagekit.io/docs/transformations#overlay-using-layers).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun overlay(): Optional<Overlay> = overlay.getOptional("overlay")

    /**
     * Extracts a specific page or frame from multi-page or layered files (PDF, PSD, AI). For
     * example, specify by number (e.g., `2`), a range (e.g., `3-4` for the 2nd and 3rd layers), or
     * by name (e.g., `name-layer-4` for a PSD layer). See
     * [Thumbnail extraction](https://imagekit.io/docs/vector-and-animated-images#get-thumbnail-from-psd-pdf-ai-eps-and-animated-files).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun page(): Optional<Page> = page.getOptional("page")

    /**
     * Specifies whether the output JPEG image should be rendered progressively. Progressive loading
     * begins with a low-quality, pixelated version of the full image, which gradually improves to
     * provide a faster perceived load time. See
     * [Progressive images](https://imagekit.io/docs/image-optimization#progressive-image---pr).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun progressive(): Optional<Boolean> = progressive.getOptional("progressive")

    /**
     * Specifies the quality of the output image for lossy formats such as JPEG, WebP, and AVIF. A
     * higher quality value results in a larger file size with better quality, while a lower value
     * produces a smaller file size with reduced quality. See
     * [Quality](https://imagekit.io/docs/image-optimization#quality---q).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun quality(): Optional<Double> = quality.getOptional("quality")

    /**
     * Specifies the corner radius for rounded corners.
     * - Single value (positive integer): Applied to all corners (e.g., `20`).
     * - `max`: Creates a circular or oval shape.
     * - Per-corner array: Provide four underscore-separated values representing top-left,
     *   top-right, bottom-right, and bottom-left corners respectively (e.g., `10_20_30_40`). See
     *   [Radius](https://imagekit.io/docs/effects-and-enhancements#radius---r).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun radius(): Optional<Radius> = radius.getOptional("radius")

    /**
     * Pass any transformation not directly supported by the SDK. This transformation string is
     * appended to the URL as provided.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun raw(): Optional<String> = raw.getOptional("raw")

    /**
     * Specifies the rotation angle in degrees. Positive values rotate the image clockwise; you can
     * also use, for example, `N40` for counterclockwise rotation or `auto` to use the orientation
     * specified in the image's EXIF data. For videos, only the following values are supported: 0,
     * 90, 180, 270, or 360. See
     * [Rotate](https://imagekit.io/docs/effects-and-enhancements#rotate---rt).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun rotation(): Optional<Rotation> = rotation.getOptional("rotation")

    /**
     * Adds a shadow beneath solid objects in an image with a transparent background. For AI-based
     * drop shadows, refer to aiDropShadow. Pass `true` for a default shadow, or provide a string
     * for a custom shadow. See
     * [Shadow](https://imagekit.io/docs/effects-and-enhancements#shadow---e-shadow).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun shadow(): Optional<Shadow> = shadow.getOptional("shadow")

    /**
     * Sharpens the input image, highlighting edges and finer details. Pass `true` for default
     * sharpening, or provide a numeric value for custom sharpening. See
     * [Sharpen](https://imagekit.io/docs/effects-and-enhancements#sharpen---e-sharpen).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sharpen(): Optional<Sharpen> = sharpen.getOptional("sharpen")

    /**
     * Specifies the start offset (in seconds) for trimming videos, e.g., `5` or `10.5`. Arithmetic
     * expressions are also supported. See
     * [Trim videos – Start offset](https://imagekit.io/docs/trim-videos#start-offset---so).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun startOffset(): Optional<StartOffset> = startOffset.getOptional("startOffset")

    /**
     * An array of resolutions for adaptive bitrate streaming, e.g.,
     * [`240`, `360`, `480`, `720`, `1080`]. See
     * [Adaptive Bitrate Streaming](https://imagekit.io/docs/adaptive-bitrate-streaming).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun streamingResolutions(): Optional<List<StreamingResolution>> =
        streamingResolutions.getOptional("streamingResolutions")

    /**
     * Useful for images with a solid or nearly solid background and a central object. This
     * parameter trims the background, leaving only the central object in the output image. See
     * [Trim edges](https://imagekit.io/docs/effects-and-enhancements#trim-edges---t).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun trim(): Optional<Trim> = trim.getOptional("trim")

    /**
     * Applies Unsharp Masking (USM), an image sharpening technique. Pass `true` for a default
     * unsharp mask, or provide a string for a custom unsharp mask. See
     * [Unsharp Mask](https://imagekit.io/docs/effects-and-enhancements#unsharp-mask---e-usm).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun unsharpMask(): Optional<UnsharpMask> = unsharpMask.getOptional("unsharpMask")

    /**
     * Specifies the video codec, e.g., `h264`, `vp9`, `av1`, or `none`. See
     * [Video codec](https://imagekit.io/docs/video-optimization#video-codec---vc).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun videoCodec(): Optional<VideoCodec> = videoCodec.getOptional("videoCodec")

    /**
     * Specifies the width of the output. If a value between 0 and 1 is provided, it is treated as a
     * percentage (e.g., `0.4` represents 40% of the original width). You can also supply arithmetic
     * expressions (e.g., `iw_div_2`). Width transformation –
     * [Images](https://imagekit.io/docs/image-resize-and-crop#width---w) ·
     * [Videos](https://imagekit.io/docs/video-resize-and-crop#width---w)
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun width(): Optional<Width> = width.getOptional("width")

    /**
     * Focus using cropped image coordinates - X coordinate. See
     * [Focus using cropped coordinates](https://imagekit.io/docs/image-resize-and-crop#example---focus-using-cropped-image-coordinates).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun x(): Optional<X> = x.getOptional("x")

    /**
     * Focus using cropped image coordinates - X center coordinate. See
     * [Focus using cropped coordinates](https://imagekit.io/docs/image-resize-and-crop#example---focus-using-cropped-image-coordinates).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun xCenter(): Optional<XCenter> = xCenter.getOptional("xCenter")

    /**
     * Focus using cropped image coordinates - Y coordinate. See
     * [Focus using cropped coordinates](https://imagekit.io/docs/image-resize-and-crop#example---focus-using-cropped-image-coordinates).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun y(): Optional<Y> = y.getOptional("y")

    /**
     * Focus using cropped image coordinates - Y center coordinate. See
     * [Focus using cropped coordinates](https://imagekit.io/docs/image-resize-and-crop#example---focus-using-cropped-image-coordinates).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun yCenter(): Optional<YCenter> = yCenter.getOptional("yCenter")

    /**
     * Accepts a numeric value that determines how much to zoom in or out of the cropped area. It
     * should be used in conjunction with fo-face or fo-<object_name>. See
     * [Zoom](https://imagekit.io/docs/image-resize-and-crop#zoom---z).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun zoom(): Optional<Double> = zoom.getOptional("zoom")

    /**
     * Returns the raw JSON value of [aiChangeBackground].
     *
     * Unlike [aiChangeBackground], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("aiChangeBackground")
    @ExcludeMissing
    fun _aiChangeBackground(): JsonField<String> = aiChangeBackground

    /**
     * Returns the raw JSON value of [aiDropShadow].
     *
     * Unlike [aiDropShadow], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("aiDropShadow")
    @ExcludeMissing
    fun _aiDropShadow(): JsonField<AiDropShadow> = aiDropShadow

    /**
     * Returns the raw JSON value of [aiEdit].
     *
     * Unlike [aiEdit], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("aiEdit") @ExcludeMissing fun _aiEdit(): JsonField<String> = aiEdit

    /**
     * Returns the raw JSON value of [aiRemoveBackground].
     *
     * Unlike [aiRemoveBackground], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("aiRemoveBackground")
    @ExcludeMissing
    fun _aiRemoveBackground(): JsonField<AiRemoveBackground> = aiRemoveBackground

    /**
     * Returns the raw JSON value of [aiRemoveBackgroundExternal].
     *
     * Unlike [aiRemoveBackgroundExternal], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("aiRemoveBackgroundExternal")
    @ExcludeMissing
    fun _aiRemoveBackgroundExternal(): JsonField<AiRemoveBackgroundExternal> =
        aiRemoveBackgroundExternal

    /**
     * Returns the raw JSON value of [aiRetouch].
     *
     * Unlike [aiRetouch], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("aiRetouch") @ExcludeMissing fun _aiRetouch(): JsonField<AiRetouch> = aiRetouch

    /**
     * Returns the raw JSON value of [aiUpscale].
     *
     * Unlike [aiUpscale], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("aiUpscale") @ExcludeMissing fun _aiUpscale(): JsonField<AiUpscale> = aiUpscale

    /**
     * Returns the raw JSON value of [aiVariation].
     *
     * Unlike [aiVariation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("aiVariation")
    @ExcludeMissing
    fun _aiVariation(): JsonField<AiVariation> = aiVariation

    /**
     * Returns the raw JSON value of [aspectRatio].
     *
     * Unlike [aspectRatio], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("aspectRatio")
    @ExcludeMissing
    fun _aspectRatio(): JsonField<AspectRatio> = aspectRatio

    /**
     * Returns the raw JSON value of [audioCodec].
     *
     * Unlike [audioCodec], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("audioCodec")
    @ExcludeMissing
    fun _audioCodec(): JsonField<AudioCodec> = audioCodec

    /**
     * Returns the raw JSON value of [background].
     *
     * Unlike [background], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("background") @ExcludeMissing fun _background(): JsonField<String> = background

    /**
     * Returns the raw JSON value of [blur].
     *
     * Unlike [blur], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("blur") @ExcludeMissing fun _blur(): JsonField<Double> = blur

    /**
     * Returns the raw JSON value of [border].
     *
     * Unlike [border], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("border") @ExcludeMissing fun _border(): JsonField<String> = border

    /**
     * Returns the raw JSON value of [colorProfile].
     *
     * Unlike [colorProfile], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("colorProfile")
    @ExcludeMissing
    fun _colorProfile(): JsonField<Boolean> = colorProfile

    /**
     * Returns the raw JSON value of [colorReplace].
     *
     * Unlike [colorReplace], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("colorReplace")
    @ExcludeMissing
    fun _colorReplace(): JsonField<String> = colorReplace

    /**
     * Returns the raw JSON value of [contrastStretch].
     *
     * Unlike [contrastStretch], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("contrastStretch")
    @ExcludeMissing
    fun _contrastStretch(): JsonField<ContrastStretch> = contrastStretch

    /**
     * Returns the raw JSON value of [crop].
     *
     * Unlike [crop], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("crop") @ExcludeMissing fun _crop(): JsonField<Crop> = crop

    /**
     * Returns the raw JSON value of [cropMode].
     *
     * Unlike [cropMode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cropMode") @ExcludeMissing fun _cropMode(): JsonField<CropMode> = cropMode

    /**
     * Returns the raw JSON value of [defaultImage].
     *
     * Unlike [defaultImage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("defaultImage")
    @ExcludeMissing
    fun _defaultImage(): JsonField<String> = defaultImage

    /**
     * Returns the raw JSON value of [distort].
     *
     * Unlike [distort], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("distort") @ExcludeMissing fun _distort(): JsonField<String> = distort

    /**
     * Returns the raw JSON value of [dpr].
     *
     * Unlike [dpr], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("dpr") @ExcludeMissing fun _dpr(): JsonField<Double> = dpr

    /**
     * Returns the raw JSON value of [duration].
     *
     * Unlike [duration], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("duration") @ExcludeMissing fun _duration(): JsonField<Duration> = duration

    /**
     * Returns the raw JSON value of [endOffset].
     *
     * Unlike [endOffset], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("endOffset") @ExcludeMissing fun _endOffset(): JsonField<EndOffset> = endOffset

    /**
     * Returns the raw JSON value of [flip].
     *
     * Unlike [flip], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("flip") @ExcludeMissing fun _flip(): JsonField<Flip> = flip

    /**
     * Returns the raw JSON value of [focus].
     *
     * Unlike [focus], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("focus") @ExcludeMissing fun _focus(): JsonField<String> = focus

    /**
     * Returns the raw JSON value of [format].
     *
     * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<Format> = format

    /**
     * Returns the raw JSON value of [gradient].
     *
     * Unlike [gradient], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("gradient") @ExcludeMissing fun _gradient(): JsonField<Gradient> = gradient

    /**
     * Returns the raw JSON value of [grayscale].
     *
     * Unlike [grayscale], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("grayscale") @ExcludeMissing fun _grayscale(): JsonField<Grayscale> = grayscale

    /**
     * Returns the raw JSON value of [height].
     *
     * Unlike [height], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("height") @ExcludeMissing fun _height(): JsonField<Height> = height

    /**
     * Returns the raw JSON value of [lossless].
     *
     * Unlike [lossless], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("lossless") @ExcludeMissing fun _lossless(): JsonField<Boolean> = lossless

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Boolean> = metadata

    /**
     * Returns the raw JSON value of [named].
     *
     * Unlike [named], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("named") @ExcludeMissing fun _named(): JsonField<String> = named

    /**
     * Returns the raw JSON value of [opacity].
     *
     * Unlike [opacity], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("opacity") @ExcludeMissing fun _opacity(): JsonField<Double> = opacity

    /**
     * Returns the raw JSON value of [original].
     *
     * Unlike [original], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("original") @ExcludeMissing fun _original(): JsonField<Boolean> = original

    /**
     * Returns the raw JSON value of [overlay].
     *
     * Unlike [overlay], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("overlay") @ExcludeMissing fun _overlay(): JsonField<Overlay> = overlay

    /**
     * Returns the raw JSON value of [page].
     *
     * Unlike [page], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("page") @ExcludeMissing fun _page(): JsonField<Page> = page

    /**
     * Returns the raw JSON value of [progressive].
     *
     * Unlike [progressive], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("progressive")
    @ExcludeMissing
    fun _progressive(): JsonField<Boolean> = progressive

    /**
     * Returns the raw JSON value of [quality].
     *
     * Unlike [quality], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("quality") @ExcludeMissing fun _quality(): JsonField<Double> = quality

    /**
     * Returns the raw JSON value of [radius].
     *
     * Unlike [radius], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("radius") @ExcludeMissing fun _radius(): JsonField<Radius> = radius

    /**
     * Returns the raw JSON value of [raw].
     *
     * Unlike [raw], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("raw") @ExcludeMissing fun _raw(): JsonField<String> = raw

    /**
     * Returns the raw JSON value of [rotation].
     *
     * Unlike [rotation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rotation") @ExcludeMissing fun _rotation(): JsonField<Rotation> = rotation

    /**
     * Returns the raw JSON value of [shadow].
     *
     * Unlike [shadow], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("shadow") @ExcludeMissing fun _shadow(): JsonField<Shadow> = shadow

    /**
     * Returns the raw JSON value of [sharpen].
     *
     * Unlike [sharpen], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sharpen") @ExcludeMissing fun _sharpen(): JsonField<Sharpen> = sharpen

    /**
     * Returns the raw JSON value of [startOffset].
     *
     * Unlike [startOffset], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("startOffset")
    @ExcludeMissing
    fun _startOffset(): JsonField<StartOffset> = startOffset

    /**
     * Returns the raw JSON value of [streamingResolutions].
     *
     * Unlike [streamingResolutions], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("streamingResolutions")
    @ExcludeMissing
    fun _streamingResolutions(): JsonField<List<StreamingResolution>> = streamingResolutions

    /**
     * Returns the raw JSON value of [trim].
     *
     * Unlike [trim], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("trim") @ExcludeMissing fun _trim(): JsonField<Trim> = trim

    /**
     * Returns the raw JSON value of [unsharpMask].
     *
     * Unlike [unsharpMask], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("unsharpMask")
    @ExcludeMissing
    fun _unsharpMask(): JsonField<UnsharpMask> = unsharpMask

    /**
     * Returns the raw JSON value of [videoCodec].
     *
     * Unlike [videoCodec], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("videoCodec")
    @ExcludeMissing
    fun _videoCodec(): JsonField<VideoCodec> = videoCodec

    /**
     * Returns the raw JSON value of [width].
     *
     * Unlike [width], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("width") @ExcludeMissing fun _width(): JsonField<Width> = width

    /**
     * Returns the raw JSON value of [x].
     *
     * Unlike [x], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("x") @ExcludeMissing fun _x(): JsonField<X> = x

    /**
     * Returns the raw JSON value of [xCenter].
     *
     * Unlike [xCenter], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("xCenter") @ExcludeMissing fun _xCenter(): JsonField<XCenter> = xCenter

    /**
     * Returns the raw JSON value of [y].
     *
     * Unlike [y], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("y") @ExcludeMissing fun _y(): JsonField<Y> = y

    /**
     * Returns the raw JSON value of [yCenter].
     *
     * Unlike [yCenter], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("yCenter") @ExcludeMissing fun _yCenter(): JsonField<YCenter> = yCenter

    /**
     * Returns the raw JSON value of [zoom].
     *
     * Unlike [zoom], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("zoom") @ExcludeMissing fun _zoom(): JsonField<Double> = zoom

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

        /** Returns a mutable builder for constructing an instance of [Transformation]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Transformation]. */
    class Builder internal constructor() {

        private var aiChangeBackground: JsonField<String> = JsonMissing.of()
        private var aiDropShadow: JsonField<AiDropShadow> = JsonMissing.of()
        private var aiEdit: JsonField<String> = JsonMissing.of()
        private var aiRemoveBackground: JsonField<AiRemoveBackground> = JsonMissing.of()
        private var aiRemoveBackgroundExternal: JsonField<AiRemoveBackgroundExternal> =
            JsonMissing.of()
        private var aiRetouch: JsonField<AiRetouch> = JsonMissing.of()
        private var aiUpscale: JsonField<AiUpscale> = JsonMissing.of()
        private var aiVariation: JsonField<AiVariation> = JsonMissing.of()
        private var aspectRatio: JsonField<AspectRatio> = JsonMissing.of()
        private var audioCodec: JsonField<AudioCodec> = JsonMissing.of()
        private var background: JsonField<String> = JsonMissing.of()
        private var blur: JsonField<Double> = JsonMissing.of()
        private var border: JsonField<String> = JsonMissing.of()
        private var colorProfile: JsonField<Boolean> = JsonMissing.of()
        private var colorReplace: JsonField<String> = JsonMissing.of()
        private var contrastStretch: JsonField<ContrastStretch> = JsonMissing.of()
        private var crop: JsonField<Crop> = JsonMissing.of()
        private var cropMode: JsonField<CropMode> = JsonMissing.of()
        private var defaultImage: JsonField<String> = JsonMissing.of()
        private var distort: JsonField<String> = JsonMissing.of()
        private var dpr: JsonField<Double> = JsonMissing.of()
        private var duration: JsonField<Duration> = JsonMissing.of()
        private var endOffset: JsonField<EndOffset> = JsonMissing.of()
        private var flip: JsonField<Flip> = JsonMissing.of()
        private var focus: JsonField<String> = JsonMissing.of()
        private var format: JsonField<Format> = JsonMissing.of()
        private var gradient: JsonField<Gradient> = JsonMissing.of()
        private var grayscale: JsonField<Grayscale> = JsonMissing.of()
        private var height: JsonField<Height> = JsonMissing.of()
        private var lossless: JsonField<Boolean> = JsonMissing.of()
        private var metadata: JsonField<Boolean> = JsonMissing.of()
        private var named: JsonField<String> = JsonMissing.of()
        private var opacity: JsonField<Double> = JsonMissing.of()
        private var original: JsonField<Boolean> = JsonMissing.of()
        private var overlay: JsonField<Overlay> = JsonMissing.of()
        private var page: JsonField<Page> = JsonMissing.of()
        private var progressive: JsonField<Boolean> = JsonMissing.of()
        private var quality: JsonField<Double> = JsonMissing.of()
        private var radius: JsonField<Radius> = JsonMissing.of()
        private var raw: JsonField<String> = JsonMissing.of()
        private var rotation: JsonField<Rotation> = JsonMissing.of()
        private var shadow: JsonField<Shadow> = JsonMissing.of()
        private var sharpen: JsonField<Sharpen> = JsonMissing.of()
        private var startOffset: JsonField<StartOffset> = JsonMissing.of()
        private var streamingResolutions: JsonField<MutableList<StreamingResolution>>? = null
        private var trim: JsonField<Trim> = JsonMissing.of()
        private var unsharpMask: JsonField<UnsharpMask> = JsonMissing.of()
        private var videoCodec: JsonField<VideoCodec> = JsonMissing.of()
        private var width: JsonField<Width> = JsonMissing.of()
        private var x: JsonField<X> = JsonMissing.of()
        private var xCenter: JsonField<XCenter> = JsonMissing.of()
        private var y: JsonField<Y> = JsonMissing.of()
        private var yCenter: JsonField<YCenter> = JsonMissing.of()
        private var zoom: JsonField<Double> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(transformation: Transformation) = apply {
            aiChangeBackground = transformation.aiChangeBackground
            aiDropShadow = transformation.aiDropShadow
            aiEdit = transformation.aiEdit
            aiRemoveBackground = transformation.aiRemoveBackground
            aiRemoveBackgroundExternal = transformation.aiRemoveBackgroundExternal
            aiRetouch = transformation.aiRetouch
            aiUpscale = transformation.aiUpscale
            aiVariation = transformation.aiVariation
            aspectRatio = transformation.aspectRatio
            audioCodec = transformation.audioCodec
            background = transformation.background
            blur = transformation.blur
            border = transformation.border
            colorProfile = transformation.colorProfile
            colorReplace = transformation.colorReplace
            contrastStretch = transformation.contrastStretch
            crop = transformation.crop
            cropMode = transformation.cropMode
            defaultImage = transformation.defaultImage
            distort = transformation.distort
            dpr = transformation.dpr
            duration = transformation.duration
            endOffset = transformation.endOffset
            flip = transformation.flip
            focus = transformation.focus
            format = transformation.format
            gradient = transformation.gradient
            grayscale = transformation.grayscale
            height = transformation.height
            lossless = transformation.lossless
            metadata = transformation.metadata
            named = transformation.named
            opacity = transformation.opacity
            original = transformation.original
            overlay = transformation.overlay
            page = transformation.page
            progressive = transformation.progressive
            quality = transformation.quality
            radius = transformation.radius
            raw = transformation.raw
            rotation = transformation.rotation
            shadow = transformation.shadow
            sharpen = transformation.sharpen
            startOffset = transformation.startOffset
            streamingResolutions = transformation.streamingResolutions.map { it.toMutableList() }
            trim = transformation.trim
            unsharpMask = transformation.unsharpMask
            videoCodec = transformation.videoCodec
            width = transformation.width
            x = transformation.x
            xCenter = transformation.xCenter
            y = transformation.y
            yCenter = transformation.yCenter
            zoom = transformation.zoom
            additionalProperties = transformation.additionalProperties.toMutableMap()
        }

        /**
         * Uses AI to change the background. Provide a text prompt or a base64-encoded prompt, e.g.,
         * `prompt-snow road` or `prompte-[urlencoded_base64_encoded_text]`. Not supported inside
         * overlay. See
         * [AI Change Background](https://imagekit.io/docs/ai-transformations#change-background-e-changebg).
         */
        fun aiChangeBackground(aiChangeBackground: String) =
            aiChangeBackground(JsonField.of(aiChangeBackground))

        /**
         * Sets [Builder.aiChangeBackground] to an arbitrary JSON value.
         *
         * You should usually call [Builder.aiChangeBackground] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun aiChangeBackground(aiChangeBackground: JsonField<String>) = apply {
            this.aiChangeBackground = aiChangeBackground
        }

        /**
         * Adds an AI-based drop shadow around a foreground object on a transparent or removed
         * background. Optionally, control the direction, elevation, and saturation of the light
         * source (e.g., `az-45` to change light direction). Pass `true` for the default drop
         * shadow, or provide a string for a custom drop shadow. Supported inside overlay. See
         * [AI Drop Shadow](https://imagekit.io/docs/ai-transformations#ai-drop-shadow-e-dropshadow).
         */
        fun aiDropShadow(aiDropShadow: AiDropShadow) = aiDropShadow(JsonField.of(aiDropShadow))

        /**
         * Sets [Builder.aiDropShadow] to an arbitrary JSON value.
         *
         * You should usually call [Builder.aiDropShadow] with a well-typed [AiDropShadow] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun aiDropShadow(aiDropShadow: JsonField<AiDropShadow>) = apply {
            this.aiDropShadow = aiDropShadow
        }

        /** Alias for calling [aiDropShadow] with `AiDropShadow.ofTrue()`. */
        fun aiDropShadowTrue() = aiDropShadow(AiDropShadow.ofTrue())

        /** Alias for calling [aiDropShadow] with `AiDropShadow.ofString(string)`. */
        fun aiDropShadow(string: String) = aiDropShadow(AiDropShadow.ofString(string))

        /**
         * Uses AI to edit images based on a text prompt. Provide a text prompt or a base64-encoded
         * prompt, e.g., `prompt-snow road` or `prompte-[urlencoded_base64_encoded_text]`. Not
         * supported inside overlay. See
         * [AI Edit](https://imagekit.io/docs/ai-transformations#edit-image-e-edit).
         */
        fun aiEdit(aiEdit: String) = aiEdit(JsonField.of(aiEdit))

        /**
         * Sets [Builder.aiEdit] to an arbitrary JSON value.
         *
         * You should usually call [Builder.aiEdit] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun aiEdit(aiEdit: JsonField<String>) = apply { this.aiEdit = aiEdit }

        /**
         * Applies ImageKit's in-house background removal. Supported inside overlay. See
         * [AI Background Removal](https://imagekit.io/docs/ai-transformations#imagekit-background-removal-e-bgremove).
         */
        fun aiRemoveBackground(aiRemoveBackground: AiRemoveBackground) =
            aiRemoveBackground(JsonField.of(aiRemoveBackground))

        /**
         * Sets [Builder.aiRemoveBackground] to an arbitrary JSON value.
         *
         * You should usually call [Builder.aiRemoveBackground] with a well-typed
         * [AiRemoveBackground] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun aiRemoveBackground(aiRemoveBackground: JsonField<AiRemoveBackground>) = apply {
            this.aiRemoveBackground = aiRemoveBackground
        }

        /**
         * Uses third-party background removal. Note: It is recommended to use aiRemoveBackground,
         * ImageKit's in-house solution, which is more cost-effective. Supported inside overlay. See
         * [External Background Removal](https://imagekit.io/docs/ai-transformations#background-removal-e-removedotbg).
         */
        fun aiRemoveBackgroundExternal(aiRemoveBackgroundExternal: AiRemoveBackgroundExternal) =
            aiRemoveBackgroundExternal(JsonField.of(aiRemoveBackgroundExternal))

        /**
         * Sets [Builder.aiRemoveBackgroundExternal] to an arbitrary JSON value.
         *
         * You should usually call [Builder.aiRemoveBackgroundExternal] with a well-typed
         * [AiRemoveBackgroundExternal] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun aiRemoveBackgroundExternal(
            aiRemoveBackgroundExternal: JsonField<AiRemoveBackgroundExternal>
        ) = apply { this.aiRemoveBackgroundExternal = aiRemoveBackgroundExternal }

        /**
         * Performs AI-based retouching to improve faces or product shots. Not supported inside
         * overlay. See [AI Retouch](https://imagekit.io/docs/ai-transformations#retouch-e-retouch).
         */
        fun aiRetouch(aiRetouch: AiRetouch) = aiRetouch(JsonField.of(aiRetouch))

        /**
         * Sets [Builder.aiRetouch] to an arbitrary JSON value.
         *
         * You should usually call [Builder.aiRetouch] with a well-typed [AiRetouch] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun aiRetouch(aiRetouch: JsonField<AiRetouch>) = apply { this.aiRetouch = aiRetouch }

        /**
         * Upscales images beyond their original dimensions using AI. Not supported inside overlay.
         * See [AI Upscale](https://imagekit.io/docs/ai-transformations#upscale-e-upscale).
         */
        fun aiUpscale(aiUpscale: AiUpscale) = aiUpscale(JsonField.of(aiUpscale))

        /**
         * Sets [Builder.aiUpscale] to an arbitrary JSON value.
         *
         * You should usually call [Builder.aiUpscale] with a well-typed [AiUpscale] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun aiUpscale(aiUpscale: JsonField<AiUpscale>) = apply { this.aiUpscale = aiUpscale }

        /**
         * Generates a variation of an image using AI. This produces a new image with slight
         * variations from the original, such as changes in color, texture, and other visual
         * elements, while preserving the structure and essence of the original image. Not supported
         * inside overlay. See
         * [AI Generate Variations](https://imagekit.io/docs/ai-transformations#generate-variations-of-an-image-e-genvar).
         */
        fun aiVariation(aiVariation: AiVariation) = aiVariation(JsonField.of(aiVariation))

        /**
         * Sets [Builder.aiVariation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.aiVariation] with a well-typed [AiVariation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun aiVariation(aiVariation: JsonField<AiVariation>) = apply {
            this.aiVariation = aiVariation
        }

        /**
         * Specifies the aspect ratio for the output, e.g., "ar-4-3". Typically used with either
         * width or height (but not both). For example: aspectRatio = `4:3`, `4_3`, or an expression
         * like `iar_div_2`. See
         * [Image resize and crop – Aspect ratio](https://imagekit.io/docs/image-resize-and-crop#aspect-ratio---ar).
         */
        fun aspectRatio(aspectRatio: AspectRatio) = aspectRatio(JsonField.of(aspectRatio))

        /**
         * Sets [Builder.aspectRatio] to an arbitrary JSON value.
         *
         * You should usually call [Builder.aspectRatio] with a well-typed [AspectRatio] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun aspectRatio(aspectRatio: JsonField<AspectRatio>) = apply {
            this.aspectRatio = aspectRatio
        }

        /** Alias for calling [aspectRatio] with `AspectRatio.ofNumber(number)`. */
        fun aspectRatio(number: Double) = aspectRatio(AspectRatio.ofNumber(number))

        /** Alias for calling [aspectRatio] with `AspectRatio.ofString(string)`. */
        fun aspectRatio(string: String) = aspectRatio(AspectRatio.ofString(string))

        /**
         * Specifies the audio codec, e.g., `aac`, `opus`, or `none`. See
         * [Audio codec](https://imagekit.io/docs/video-optimization#audio-codec---ac).
         */
        fun audioCodec(audioCodec: AudioCodec) = audioCodec(JsonField.of(audioCodec))

        /**
         * Sets [Builder.audioCodec] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audioCodec] with a well-typed [AudioCodec] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun audioCodec(audioCodec: JsonField<AudioCodec>) = apply { this.audioCodec = audioCodec }

        /**
         * Specifies the background to be used in conjunction with certain cropping strategies when
         * resizing an image.
         * - A solid color: e.g., `red`, `F3F3F3`, `AAFF0010`. See
         *   [Solid color background](https://imagekit.io/docs/effects-and-enhancements#solid-color-background).
         * - Dominant color: `dominant` extracts the dominant color from the image. See
         *   [Dominant color background](https://imagekit.io/docs/effects-and-enhancements#dominant-color-background).
         * - Gradient: `gradient_dominant` or `gradient_dominant_2` creates a gradient using the
         *   dominant colors. Optionally specify palette size (2 or 4), e.g., `gradient_dominant_4`.
         *   See
         *   [Gradient background](https://imagekit.io/docs/effects-and-enhancements#gradient-background).
         * - A blurred background: e.g., `blurred`, `blurred_25_N15`, etc. See
         *   [Blurred background](https://imagekit.io/docs/effects-and-enhancements#blurred-background).
         * - Expand the image boundaries using generative fill: `genfill`. Not supported inside
         *   overlay. Optionally, control the background scene by passing a text prompt:
         *   `genfill[:-prompt-${text}]` or `genfill[:-prompte-${urlencoded_base64_encoded_text}]`.
         *   See
         *   [Generative fill background](https://imagekit.io/docs/ai-transformations#generative-fill-bg-genfill).
         */
        fun background(background: String) = background(JsonField.of(background))

        /**
         * Sets [Builder.background] to an arbitrary JSON value.
         *
         * You should usually call [Builder.background] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun background(background: JsonField<String>) = apply { this.background = background }

        /**
         * Specifies the Gaussian blur level. Accepts an integer value between 1 and 100, or an
         * expression like `bl-10`. See
         * [Blur](https://imagekit.io/docs/effects-and-enhancements#blur---bl).
         */
        fun blur(blur: Double) = blur(JsonField.of(blur))

        /**
         * Sets [Builder.blur] to an arbitrary JSON value.
         *
         * You should usually call [Builder.blur] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun blur(blur: JsonField<Double>) = apply { this.blur = blur }

        /**
         * Adds a border to the output media. Accepts a string in the format
         * `<border-width>_<hex-code>` (e.g., `5_FFF000` for a 5px yellow border), or an expression
         * like `ih_div_20_FF00FF`. See
         * [Border](https://imagekit.io/docs/effects-and-enhancements#border---b).
         */
        fun border(border: String) = border(JsonField.of(border))

        /**
         * Sets [Builder.border] to an arbitrary JSON value.
         *
         * You should usually call [Builder.border] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun border(border: JsonField<String>) = apply { this.border = border }

        /**
         * Indicates whether the output image should retain the original color profile. See
         * [Color profile](https://imagekit.io/docs/image-optimization#color-profile---cp).
         */
        fun colorProfile(colorProfile: Boolean) = colorProfile(JsonField.of(colorProfile))

        /**
         * Sets [Builder.colorProfile] to an arbitrary JSON value.
         *
         * You should usually call [Builder.colorProfile] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun colorProfile(colorProfile: JsonField<Boolean>) = apply {
            this.colorProfile = colorProfile
        }

        /**
         * Replaces colors in the image. Supports three formats:
         * - `toColor` - Replace dominant color with the specified color.
         * - `toColor_tolerance` - Replace dominant color with specified tolerance (0-100).
         * - `toColor_tolerance_fromColor` - Replace a specific color with another within tolerance
         *   range. Colors can be hex codes (e.g., `FF0022`) or names (e.g., `red`, `blue`). See
         *   [Color replacement](https://imagekit.io/docs/effects-and-enhancements#color-replace---cr).
         */
        fun colorReplace(colorReplace: String) = colorReplace(JsonField.of(colorReplace))

        /**
         * Sets [Builder.colorReplace] to an arbitrary JSON value.
         *
         * You should usually call [Builder.colorReplace] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun colorReplace(colorReplace: JsonField<String>) = apply {
            this.colorReplace = colorReplace
        }

        /**
         * Automatically enhances the contrast of an image (contrast stretch). See
         * [Contrast Stretch](https://imagekit.io/docs/effects-and-enhancements#contrast-stretch---e-contrast).
         */
        fun contrastStretch(contrastStretch: ContrastStretch) =
            contrastStretch(JsonField.of(contrastStretch))

        /**
         * Sets [Builder.contrastStretch] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contrastStretch] with a well-typed [ContrastStretch]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun contrastStretch(contrastStretch: JsonField<ContrastStretch>) = apply {
            this.contrastStretch = contrastStretch
        }

        /**
         * Crop modes for image resizing. See
         * [Crop modes & focus](https://imagekit.io/docs/image-resize-and-crop#crop-crop-modes--focus).
         */
        fun crop(crop: Crop) = crop(JsonField.of(crop))

        /**
         * Sets [Builder.crop] to an arbitrary JSON value.
         *
         * You should usually call [Builder.crop] with a well-typed [Crop] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun crop(crop: JsonField<Crop>) = apply { this.crop = crop }

        /**
         * Additional crop modes for image resizing. See
         * [Crop modes & focus](https://imagekit.io/docs/image-resize-and-crop#crop-crop-modes--focus).
         */
        fun cropMode(cropMode: CropMode) = cropMode(JsonField.of(cropMode))

        /**
         * Sets [Builder.cropMode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cropMode] with a well-typed [CropMode] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun cropMode(cropMode: JsonField<CropMode>) = apply { this.cropMode = cropMode }

        /**
         * Specifies a fallback image if the resource is not found, e.g., a URL or file path. See
         * [Default image](https://imagekit.io/docs/image-transformation#default-image---di).
         */
        fun defaultImage(defaultImage: String) = defaultImage(JsonField.of(defaultImage))

        /**
         * Sets [Builder.defaultImage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.defaultImage] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun defaultImage(defaultImage: JsonField<String>) = apply {
            this.defaultImage = defaultImage
        }

        /**
         * Distorts the shape of an image. Supports two modes:
         * - Perspective distortion: `p-x1_y1_x2_y2_x3_y3_x4_y4` changes the position of the four
         *   corners starting clockwise from top-left.
         * - Arc distortion: `a-degrees` curves the image upwards (positive values) or downwards
         *   (negative values). See
         *   [Distort effect](https://imagekit.io/docs/effects-and-enhancements#distort---e-distort).
         */
        fun distort(distort: String) = distort(JsonField.of(distort))

        /**
         * Sets [Builder.distort] to an arbitrary JSON value.
         *
         * You should usually call [Builder.distort] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun distort(distort: JsonField<String>) = apply { this.distort = distort }

        /**
         * Accepts values between 0.1 and 5, or `auto` for automatic device pixel ratio (DPR)
         * calculation. Also accepts arithmetic expressions.
         * - Learn about
         *   [Arithmetic expressions](https://imagekit.io/docs/arithmetic-expressions-in-transformations).
         * - See [DPR](https://imagekit.io/docs/image-resize-and-crop#dpr---dpr).
         */
        fun dpr(dpr: Double) = dpr(JsonField.of(dpr))

        /**
         * Sets [Builder.dpr] to an arbitrary JSON value.
         *
         * You should usually call [Builder.dpr] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun dpr(dpr: JsonField<Double>) = apply { this.dpr = dpr }

        /**
         * Specifies the duration (in seconds) for trimming videos, e.g., `5` or `10.5`. Typically
         * used with startOffset to indicate the length from the start offset. Arithmetic
         * expressions are supported. See
         * [Trim videos – Duration](https://imagekit.io/docs/trim-videos#duration---du).
         */
        fun duration(duration: Duration) = duration(JsonField.of(duration))

        /**
         * Sets [Builder.duration] to an arbitrary JSON value.
         *
         * You should usually call [Builder.duration] with a well-typed [Duration] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun duration(duration: JsonField<Duration>) = apply { this.duration = duration }

        /** Alias for calling [duration] with `Duration.ofNumber(number)`. */
        fun duration(number: Double) = duration(Duration.ofNumber(number))

        /** Alias for calling [duration] with `Duration.ofString(string)`. */
        fun duration(string: String) = duration(Duration.ofString(string))

        /**
         * Specifies the end offset (in seconds) for trimming videos, e.g., `5` or `10.5`. Typically
         * used with startOffset to define a time window. Arithmetic expressions are supported. See
         * [Trim videos – End offset](https://imagekit.io/docs/trim-videos#end-offset---eo).
         */
        fun endOffset(endOffset: EndOffset) = endOffset(JsonField.of(endOffset))

        /**
         * Sets [Builder.endOffset] to an arbitrary JSON value.
         *
         * You should usually call [Builder.endOffset] with a well-typed [EndOffset] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun endOffset(endOffset: JsonField<EndOffset>) = apply { this.endOffset = endOffset }

        /** Alias for calling [endOffset] with `EndOffset.ofNumber(number)`. */
        fun endOffset(number: Double) = endOffset(EndOffset.ofNumber(number))

        /** Alias for calling [endOffset] with `EndOffset.ofString(string)`. */
        fun endOffset(string: String) = endOffset(EndOffset.ofString(string))

        /**
         * Flips or mirrors an image either horizontally, vertically, or both. Acceptable values:
         * `h` (horizontal), `v` (vertical), `h_v` (horizontal and vertical), or `v_h`. See
         * [Flip](https://imagekit.io/docs/effects-and-enhancements#flip---fl).
         */
        fun flip(flip: Flip) = flip(JsonField.of(flip))

        /**
         * Sets [Builder.flip] to an arbitrary JSON value.
         *
         * You should usually call [Builder.flip] with a well-typed [Flip] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun flip(flip: JsonField<Flip>) = apply { this.flip = flip }

        /**
         * Refines padding and cropping behavior for pad resize, maintain ratio, and extract crop
         * modes. Supports manual positions and coordinate-based focus. With AI-based cropping, you
         * can automatically keep key subjects in frame—such as faces or detected objects (e.g.,
         * `fo-face`, `fo-person`, `fo-car`)— while resizing.
         * - See [Focus](https://imagekit.io/docs/image-resize-and-crop#focus---fo).
         * - [Object aware
         *   cropping](https://imagekit.io/docs/image-resize-and-crop#object-aware-cropping---fo-object-name)
         */
        fun focus(focus: String) = focus(JsonField.of(focus))

        /**
         * Sets [Builder.focus] to an arbitrary JSON value.
         *
         * You should usually call [Builder.focus] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun focus(focus: JsonField<String>) = apply { this.focus = focus }

        /**
         * Specifies the output format for images or videos, e.g., `jpg`, `png`, `webp`, `mp4`, or
         * `auto`. You can also pass `orig` for images to return the original format. ImageKit
         * automatically delivers images and videos in the optimal format based on device support
         * unless overridden by the dashboard settings or the format parameter. See
         * [Image format](https://imagekit.io/docs/image-optimization#format---f) and
         * [Video format](https://imagekit.io/docs/video-optimization#format---f).
         */
        fun format(format: Format) = format(JsonField.of(format))

        /**
         * Sets [Builder.format] to an arbitrary JSON value.
         *
         * You should usually call [Builder.format] with a well-typed [Format] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun format(format: JsonField<Format>) = apply { this.format = format }

        /**
         * Creates a linear gradient with two colors. Pass `true` for a default gradient, or provide
         * a string for a custom gradient. See
         * [Gradient](https://imagekit.io/docs/effects-and-enhancements#gradient---e-gradient).
         */
        fun gradient(gradient: Gradient) = gradient(JsonField.of(gradient))

        /**
         * Sets [Builder.gradient] to an arbitrary JSON value.
         *
         * You should usually call [Builder.gradient] with a well-typed [Gradient] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun gradient(gradient: JsonField<Gradient>) = apply { this.gradient = gradient }

        /** Alias for calling [gradient] with `Gradient.ofTrue()`. */
        fun gradientTrue() = gradient(Gradient.ofTrue())

        /** Alias for calling [gradient] with `Gradient.ofString(string)`. */
        fun gradient(string: String) = gradient(Gradient.ofString(string))

        /**
         * Enables a grayscale effect for images. See
         * [Grayscale](https://imagekit.io/docs/effects-and-enhancements#grayscale---e-grayscale).
         */
        fun grayscale(grayscale: Grayscale) = grayscale(JsonField.of(grayscale))

        /**
         * Sets [Builder.grayscale] to an arbitrary JSON value.
         *
         * You should usually call [Builder.grayscale] with a well-typed [Grayscale] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun grayscale(grayscale: JsonField<Grayscale>) = apply { this.grayscale = grayscale }

        /**
         * Specifies the height of the output. If a value between 0 and 1 is provided, it is treated
         * as a percentage (e.g., `0.5` represents 50% of the original height). You can also supply
         * arithmetic expressions (e.g., `ih_mul_0.5`). Height transformation –
         * [Images](https://imagekit.io/docs/image-resize-and-crop#height---h) ·
         * [Videos](https://imagekit.io/docs/video-resize-and-crop#height---h)
         */
        fun height(height: Height) = height(JsonField.of(height))

        /**
         * Sets [Builder.height] to an arbitrary JSON value.
         *
         * You should usually call [Builder.height] with a well-typed [Height] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun height(height: JsonField<Height>) = apply { this.height = height }

        /** Alias for calling [height] with `Height.ofNumber(number)`. */
        fun height(number: Double) = height(Height.ofNumber(number))

        /** Alias for calling [height] with `Height.ofString(string)`. */
        fun height(string: String) = height(Height.ofString(string))

        /**
         * Specifies whether the output image (in JPEG or PNG) should be compressed losslessly. See
         * [Lossless compression](https://imagekit.io/docs/image-optimization#lossless-webp-and-png---lo).
         */
        fun lossless(lossless: Boolean) = lossless(JsonField.of(lossless))

        /**
         * Sets [Builder.lossless] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lossless] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun lossless(lossless: JsonField<Boolean>) = apply { this.lossless = lossless }

        /**
         * By default, ImageKit removes all metadata during automatic image compression. Set this to
         * true to preserve metadata. See
         * [Image metadata](https://imagekit.io/docs/image-optimization#image-metadata---md).
         */
        fun metadata(metadata: Boolean) = metadata(JsonField.of(metadata))

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Boolean>) = apply { this.metadata = metadata }

        /**
         * Named transformation reference. See
         * [Named transformations](https://imagekit.io/docs/transformations#named-transformations).
         */
        fun named(named: String) = named(JsonField.of(named))

        /**
         * Sets [Builder.named] to an arbitrary JSON value.
         *
         * You should usually call [Builder.named] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun named(named: JsonField<String>) = apply { this.named = named }

        /**
         * Specifies the opacity level of the output image. See
         * [Opacity](https://imagekit.io/docs/effects-and-enhancements#opacity---o).
         */
        fun opacity(opacity: Double) = opacity(JsonField.of(opacity))

        /**
         * Sets [Builder.opacity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.opacity] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun opacity(opacity: JsonField<Double>) = apply { this.opacity = opacity }

        /**
         * If set to true, serves the original file without applying any transformations. See
         * [Deliver original file as-is](https://imagekit.io/docs/core-delivery-features#deliver-original-file-as-is---orig-true).
         */
        fun original(original: Boolean) = original(JsonField.of(original))

        /**
         * Sets [Builder.original] to an arbitrary JSON value.
         *
         * You should usually call [Builder.original] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun original(original: JsonField<Boolean>) = apply { this.original = original }

        /**
         * Specifies an overlay to be applied on the parent image or video. ImageKit supports
         * overlays including images, text, videos, subtitles, and solid colors. See
         * [Overlay using layers](https://imagekit.io/docs/transformations#overlay-using-layers).
         */
        fun overlay(overlay: Overlay) = overlay(JsonField.of(overlay))

        /**
         * Sets [Builder.overlay] to an arbitrary JSON value.
         *
         * You should usually call [Builder.overlay] with a well-typed [Overlay] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun overlay(overlay: JsonField<Overlay>) = apply { this.overlay = overlay }

        /** Alias for calling [overlay] with `Overlay.ofText(text)`. */
        fun overlay(text: TextOverlay) = overlay(Overlay.ofText(text))

        /**
         * Alias for calling [overlay] with the following:
         * ```java
         * TextOverlay.builder()
         *     .text(text)
         *     .build()
         * ```
         */
        fun textOverlay(text: String) = overlay(TextOverlay.builder().text(text).build())

        /** Alias for calling [overlay] with `Overlay.ofImage(image)`. */
        fun overlay(image: ImageOverlay) = overlay(Overlay.ofImage(image))

        /**
         * Alias for calling [overlay] with the following:
         * ```java
         * ImageOverlay.builder()
         *     .input(input)
         *     .build()
         * ```
         */
        fun imageOverlay(input: String) = overlay(ImageOverlay.builder().input(input).build())

        /** Alias for calling [overlay] with `Overlay.ofVideo(video)`. */
        fun overlay(video: VideoOverlay) = overlay(Overlay.ofVideo(video))

        /**
         * Alias for calling [overlay] with the following:
         * ```java
         * VideoOverlay.builder()
         *     .input(input)
         *     .build()
         * ```
         */
        fun videoOverlay(input: String) = overlay(VideoOverlay.builder().input(input).build())

        /** Alias for calling [overlay] with `Overlay.ofSubtitle(subtitle)`. */
        fun overlay(subtitle: SubtitleOverlay) = overlay(Overlay.ofSubtitle(subtitle))

        /**
         * Alias for calling [overlay] with the following:
         * ```java
         * SubtitleOverlay.builder()
         *     .input(input)
         *     .build()
         * ```
         */
        fun subtitleOverlay(input: String) = overlay(SubtitleOverlay.builder().input(input).build())

        /** Alias for calling [overlay] with `Overlay.ofSolidColor(solidColor)`. */
        fun overlay(solidColor: SolidColorOverlay) = overlay(Overlay.ofSolidColor(solidColor))

        /**
         * Alias for calling [overlay] with the following:
         * ```java
         * SolidColorOverlay.builder()
         *     .color(color)
         *     .build()
         * ```
         */
        fun solidColorOverlay(color: String) =
            overlay(SolidColorOverlay.builder().color(color).build())

        /**
         * Extracts a specific page or frame from multi-page or layered files (PDF, PSD, AI). For
         * example, specify by number (e.g., `2`), a range (e.g., `3-4` for the 2nd and 3rd layers),
         * or by name (e.g., `name-layer-4` for a PSD layer). See
         * [Thumbnail extraction](https://imagekit.io/docs/vector-and-animated-images#get-thumbnail-from-psd-pdf-ai-eps-and-animated-files).
         */
        fun page(page: Page) = page(JsonField.of(page))

        /**
         * Sets [Builder.page] to an arbitrary JSON value.
         *
         * You should usually call [Builder.page] with a well-typed [Page] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun page(page: JsonField<Page>) = apply { this.page = page }

        /** Alias for calling [page] with `Page.ofNumber(number)`. */
        fun page(number: Double) = page(Page.ofNumber(number))

        /** Alias for calling [page] with `Page.ofString(string)`. */
        fun page(string: String) = page(Page.ofString(string))

        /**
         * Specifies whether the output JPEG image should be rendered progressively. Progressive
         * loading begins with a low-quality, pixelated version of the full image, which gradually
         * improves to provide a faster perceived load time. See
         * [Progressive images](https://imagekit.io/docs/image-optimization#progressive-image---pr).
         */
        fun progressive(progressive: Boolean) = progressive(JsonField.of(progressive))

        /**
         * Sets [Builder.progressive] to an arbitrary JSON value.
         *
         * You should usually call [Builder.progressive] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun progressive(progressive: JsonField<Boolean>) = apply { this.progressive = progressive }

        /**
         * Specifies the quality of the output image for lossy formats such as JPEG, WebP, and AVIF.
         * A higher quality value results in a larger file size with better quality, while a lower
         * value produces a smaller file size with reduced quality. See
         * [Quality](https://imagekit.io/docs/image-optimization#quality---q).
         */
        fun quality(quality: Double) = quality(JsonField.of(quality))

        /**
         * Sets [Builder.quality] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quality] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun quality(quality: JsonField<Double>) = apply { this.quality = quality }

        /**
         * Specifies the corner radius for rounded corners.
         * - Single value (positive integer): Applied to all corners (e.g., `20`).
         * - `max`: Creates a circular or oval shape.
         * - Per-corner array: Provide four underscore-separated values representing top-left,
         *   top-right, bottom-right, and bottom-left corners respectively (e.g., `10_20_30_40`).
         *   See [Radius](https://imagekit.io/docs/effects-and-enhancements#radius---r).
         */
        fun radius(radius: Radius) = radius(JsonField.of(radius))

        /**
         * Sets [Builder.radius] to an arbitrary JSON value.
         *
         * You should usually call [Builder.radius] with a well-typed [Radius] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun radius(radius: JsonField<Radius>) = apply { this.radius = radius }

        /** Alias for calling [radius] with `Radius.ofNumber(number)`. */
        fun radius(number: Double) = radius(Radius.ofNumber(number))

        /** Alias for calling [radius] with `Radius.ofMax()`. */
        fun radiusMax() = radius(Radius.ofMax())

        /** Alias for calling [radius] with `Radius.ofString(string)`. */
        fun radius(string: String) = radius(Radius.ofString(string))

        /**
         * Pass any transformation not directly supported by the SDK. This transformation string is
         * appended to the URL as provided.
         */
        fun raw(raw: String) = raw(JsonField.of(raw))

        /**
         * Sets [Builder.raw] to an arbitrary JSON value.
         *
         * You should usually call [Builder.raw] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun raw(raw: JsonField<String>) = apply { this.raw = raw }

        /**
         * Specifies the rotation angle in degrees. Positive values rotate the image clockwise; you
         * can also use, for example, `N40` for counterclockwise rotation or `auto` to use the
         * orientation specified in the image's EXIF data. For videos, only the following values are
         * supported: 0, 90, 180, 270, or 360. See
         * [Rotate](https://imagekit.io/docs/effects-and-enhancements#rotate---rt).
         */
        fun rotation(rotation: Rotation) = rotation(JsonField.of(rotation))

        /**
         * Sets [Builder.rotation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rotation] with a well-typed [Rotation] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun rotation(rotation: JsonField<Rotation>) = apply { this.rotation = rotation }

        /** Alias for calling [rotation] with `Rotation.ofNumber(number)`. */
        fun rotation(number: Double) = rotation(Rotation.ofNumber(number))

        /** Alias for calling [rotation] with `Rotation.ofString(string)`. */
        fun rotation(string: String) = rotation(Rotation.ofString(string))

        /**
         * Adds a shadow beneath solid objects in an image with a transparent background. For
         * AI-based drop shadows, refer to aiDropShadow. Pass `true` for a default shadow, or
         * provide a string for a custom shadow. See
         * [Shadow](https://imagekit.io/docs/effects-and-enhancements#shadow---e-shadow).
         */
        fun shadow(shadow: Shadow) = shadow(JsonField.of(shadow))

        /**
         * Sets [Builder.shadow] to an arbitrary JSON value.
         *
         * You should usually call [Builder.shadow] with a well-typed [Shadow] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun shadow(shadow: JsonField<Shadow>) = apply { this.shadow = shadow }

        /** Alias for calling [shadow] with `Shadow.ofTrue()`. */
        fun shadowTrue() = shadow(Shadow.ofTrue())

        /** Alias for calling [shadow] with `Shadow.ofString(string)`. */
        fun shadow(string: String) = shadow(Shadow.ofString(string))

        /**
         * Sharpens the input image, highlighting edges and finer details. Pass `true` for default
         * sharpening, or provide a numeric value for custom sharpening. See
         * [Sharpen](https://imagekit.io/docs/effects-and-enhancements#sharpen---e-sharpen).
         */
        fun sharpen(sharpen: Sharpen) = sharpen(JsonField.of(sharpen))

        /**
         * Sets [Builder.sharpen] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sharpen] with a well-typed [Sharpen] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sharpen(sharpen: JsonField<Sharpen>) = apply { this.sharpen = sharpen }

        /** Alias for calling [sharpen] with `Sharpen.ofTrue()`. */
        fun sharpenTrue() = sharpen(Sharpen.ofTrue())

        /** Alias for calling [sharpen] with `Sharpen.ofNumber(number)`. */
        fun sharpen(number: Double) = sharpen(Sharpen.ofNumber(number))

        /**
         * Specifies the start offset (in seconds) for trimming videos, e.g., `5` or `10.5`.
         * Arithmetic expressions are also supported. See
         * [Trim videos – Start offset](https://imagekit.io/docs/trim-videos#start-offset---so).
         */
        fun startOffset(startOffset: StartOffset) = startOffset(JsonField.of(startOffset))

        /**
         * Sets [Builder.startOffset] to an arbitrary JSON value.
         *
         * You should usually call [Builder.startOffset] with a well-typed [StartOffset] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun startOffset(startOffset: JsonField<StartOffset>) = apply {
            this.startOffset = startOffset
        }

        /** Alias for calling [startOffset] with `StartOffset.ofNumber(number)`. */
        fun startOffset(number: Double) = startOffset(StartOffset.ofNumber(number))

        /** Alias for calling [startOffset] with `StartOffset.ofString(string)`. */
        fun startOffset(string: String) = startOffset(StartOffset.ofString(string))

        /**
         * An array of resolutions for adaptive bitrate streaming, e.g.,
         * [`240`, `360`, `480`, `720`, `1080`]. See
         * [Adaptive Bitrate Streaming](https://imagekit.io/docs/adaptive-bitrate-streaming).
         */
        fun streamingResolutions(streamingResolutions: List<StreamingResolution>) =
            streamingResolutions(JsonField.of(streamingResolutions))

        /**
         * Sets [Builder.streamingResolutions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.streamingResolutions] with a well-typed
         * `List<StreamingResolution>` value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun streamingResolutions(streamingResolutions: JsonField<List<StreamingResolution>>) =
            apply {
                this.streamingResolutions = streamingResolutions.map { it.toMutableList() }
            }

        /**
         * Adds a single [StreamingResolution] to [streamingResolutions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addStreamingResolution(streamingResolution: StreamingResolution) = apply {
            streamingResolutions =
                (streamingResolutions ?: JsonField.of(mutableListOf())).also {
                    checkKnown("streamingResolutions", it).add(streamingResolution)
                }
        }

        /**
         * Useful for images with a solid or nearly solid background and a central object. This
         * parameter trims the background, leaving only the central object in the output image. See
         * [Trim edges](https://imagekit.io/docs/effects-and-enhancements#trim-edges---t).
         */
        fun trim(trim: Trim) = trim(JsonField.of(trim))

        /**
         * Sets [Builder.trim] to an arbitrary JSON value.
         *
         * You should usually call [Builder.trim] with a well-typed [Trim] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun trim(trim: JsonField<Trim>) = apply { this.trim = trim }

        /** Alias for calling [trim] with `Trim.ofTrue()`. */
        fun trimTrue() = trim(Trim.ofTrue())

        /** Alias for calling [trim] with `Trim.ofNumber(number)`. */
        fun trim(number: Double) = trim(Trim.ofNumber(number))

        /**
         * Applies Unsharp Masking (USM), an image sharpening technique. Pass `true` for a default
         * unsharp mask, or provide a string for a custom unsharp mask. See
         * [Unsharp Mask](https://imagekit.io/docs/effects-and-enhancements#unsharp-mask---e-usm).
         */
        fun unsharpMask(unsharpMask: UnsharpMask) = unsharpMask(JsonField.of(unsharpMask))

        /**
         * Sets [Builder.unsharpMask] to an arbitrary JSON value.
         *
         * You should usually call [Builder.unsharpMask] with a well-typed [UnsharpMask] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun unsharpMask(unsharpMask: JsonField<UnsharpMask>) = apply {
            this.unsharpMask = unsharpMask
        }

        /** Alias for calling [unsharpMask] with `UnsharpMask.ofTrue()`. */
        fun unsharpMaskTrue() = unsharpMask(UnsharpMask.ofTrue())

        /** Alias for calling [unsharpMask] with `UnsharpMask.ofString(string)`. */
        fun unsharpMask(string: String) = unsharpMask(UnsharpMask.ofString(string))

        /**
         * Specifies the video codec, e.g., `h264`, `vp9`, `av1`, or `none`. See
         * [Video codec](https://imagekit.io/docs/video-optimization#video-codec---vc).
         */
        fun videoCodec(videoCodec: VideoCodec) = videoCodec(JsonField.of(videoCodec))

        /**
         * Sets [Builder.videoCodec] to an arbitrary JSON value.
         *
         * You should usually call [Builder.videoCodec] with a well-typed [VideoCodec] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun videoCodec(videoCodec: JsonField<VideoCodec>) = apply { this.videoCodec = videoCodec }

        /**
         * Specifies the width of the output. If a value between 0 and 1 is provided, it is treated
         * as a percentage (e.g., `0.4` represents 40% of the original width). You can also supply
         * arithmetic expressions (e.g., `iw_div_2`). Width transformation –
         * [Images](https://imagekit.io/docs/image-resize-and-crop#width---w) ·
         * [Videos](https://imagekit.io/docs/video-resize-and-crop#width---w)
         */
        fun width(width: Width) = width(JsonField.of(width))

        /**
         * Sets [Builder.width] to an arbitrary JSON value.
         *
         * You should usually call [Builder.width] with a well-typed [Width] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun width(width: JsonField<Width>) = apply { this.width = width }

        /** Alias for calling [width] with `Width.ofNumber(number)`. */
        fun width(number: Double) = width(Width.ofNumber(number))

        /** Alias for calling [width] with `Width.ofString(string)`. */
        fun width(string: String) = width(Width.ofString(string))

        /**
         * Focus using cropped image coordinates - X coordinate. See
         * [Focus using cropped coordinates](https://imagekit.io/docs/image-resize-and-crop#example---focus-using-cropped-image-coordinates).
         */
        fun x(x: X) = x(JsonField.of(x))

        /**
         * Sets [Builder.x] to an arbitrary JSON value.
         *
         * You should usually call [Builder.x] with a well-typed [X] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
         */
        fun x(x: JsonField<X>) = apply { this.x = x }

        /** Alias for calling [x] with `X.ofNumber(number)`. */
        fun x(number: Double) = x(X.ofNumber(number))

        /** Alias for calling [x] with `X.ofString(string)`. */
        fun x(string: String) = x(X.ofString(string))

        /**
         * Focus using cropped image coordinates - X center coordinate. See
         * [Focus using cropped coordinates](https://imagekit.io/docs/image-resize-and-crop#example---focus-using-cropped-image-coordinates).
         */
        fun xCenter(xCenter: XCenter) = xCenter(JsonField.of(xCenter))

        /**
         * Sets [Builder.xCenter] to an arbitrary JSON value.
         *
         * You should usually call [Builder.xCenter] with a well-typed [XCenter] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun xCenter(xCenter: JsonField<XCenter>) = apply { this.xCenter = xCenter }

        /** Alias for calling [xCenter] with `XCenter.ofNumber(number)`. */
        fun xCenter(number: Double) = xCenter(XCenter.ofNumber(number))

        /** Alias for calling [xCenter] with `XCenter.ofString(string)`. */
        fun xCenter(string: String) = xCenter(XCenter.ofString(string))

        /**
         * Focus using cropped image coordinates - Y coordinate. See
         * [Focus using cropped coordinates](https://imagekit.io/docs/image-resize-and-crop#example---focus-using-cropped-image-coordinates).
         */
        fun y(y: Y) = y(JsonField.of(y))

        /**
         * Sets [Builder.y] to an arbitrary JSON value.
         *
         * You should usually call [Builder.y] with a well-typed [Y] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
         */
        fun y(y: JsonField<Y>) = apply { this.y = y }

        /** Alias for calling [y] with `Y.ofNumber(number)`. */
        fun y(number: Double) = y(Y.ofNumber(number))

        /** Alias for calling [y] with `Y.ofString(string)`. */
        fun y(string: String) = y(Y.ofString(string))

        /**
         * Focus using cropped image coordinates - Y center coordinate. See
         * [Focus using cropped coordinates](https://imagekit.io/docs/image-resize-and-crop#example---focus-using-cropped-image-coordinates).
         */
        fun yCenter(yCenter: YCenter) = yCenter(JsonField.of(yCenter))

        /**
         * Sets [Builder.yCenter] to an arbitrary JSON value.
         *
         * You should usually call [Builder.yCenter] with a well-typed [YCenter] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun yCenter(yCenter: JsonField<YCenter>) = apply { this.yCenter = yCenter }

        /** Alias for calling [yCenter] with `YCenter.ofNumber(number)`. */
        fun yCenter(number: Double) = yCenter(YCenter.ofNumber(number))

        /** Alias for calling [yCenter] with `YCenter.ofString(string)`. */
        fun yCenter(string: String) = yCenter(YCenter.ofString(string))

        /**
         * Accepts a numeric value that determines how much to zoom in or out of the cropped area.
         * It should be used in conjunction with fo-face or fo-<object_name>. See
         * [Zoom](https://imagekit.io/docs/image-resize-and-crop#zoom---z).
         */
        fun zoom(zoom: Double) = zoom(JsonField.of(zoom))

        /**
         * Sets [Builder.zoom] to an arbitrary JSON value.
         *
         * You should usually call [Builder.zoom] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun zoom(zoom: JsonField<Double>) = apply { this.zoom = zoom }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

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
                aiChangeBackground,
                aiDropShadow,
                aiEdit,
                aiRemoveBackground,
                aiRemoveBackgroundExternal,
                aiRetouch,
                aiUpscale,
                aiVariation,
                aspectRatio,
                audioCodec,
                background,
                blur,
                border,
                colorProfile,
                colorReplace,
                contrastStretch,
                crop,
                cropMode,
                defaultImage,
                distort,
                dpr,
                duration,
                endOffset,
                flip,
                focus,
                format,
                gradient,
                grayscale,
                height,
                lossless,
                metadata,
                named,
                opacity,
                original,
                overlay,
                page,
                progressive,
                quality,
                radius,
                raw,
                rotation,
                shadow,
                sharpen,
                startOffset,
                (streamingResolutions ?: JsonMissing.of()).map { it.toImmutable() },
                trim,
                unsharpMask,
                videoCodec,
                width,
                x,
                xCenter,
                y,
                yCenter,
                zoom,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Transformation = apply {
        if (validated) {
            return@apply
        }

        aiChangeBackground()
        aiDropShadow().ifPresent { it.validate() }
        aiEdit()
        aiRemoveBackground().ifPresent { it.validate() }
        aiRemoveBackgroundExternal().ifPresent { it.validate() }
        aiRetouch().ifPresent { it.validate() }
        aiUpscale().ifPresent { it.validate() }
        aiVariation().ifPresent { it.validate() }
        aspectRatio().ifPresent { it.validate() }
        audioCodec().ifPresent { it.validate() }
        background()
        blur()
        border()
        colorProfile()
        colorReplace()
        contrastStretch().ifPresent { it.validate() }
        crop().ifPresent { it.validate() }
        cropMode().ifPresent { it.validate() }
        defaultImage()
        distort()
        dpr()
        duration().ifPresent { it.validate() }
        endOffset().ifPresent { it.validate() }
        flip().ifPresent { it.validate() }
        focus()
        format().ifPresent { it.validate() }
        gradient().ifPresent { it.validate() }
        grayscale().ifPresent { it.validate() }
        height().ifPresent { it.validate() }
        lossless()
        metadata()
        named()
        opacity()
        original()
        overlay().ifPresent { it.validate() }
        page().ifPresent { it.validate() }
        progressive()
        quality()
        radius().ifPresent { it.validate() }
        raw()
        rotation().ifPresent { it.validate() }
        shadow().ifPresent { it.validate() }
        sharpen().ifPresent { it.validate() }
        startOffset().ifPresent { it.validate() }
        streamingResolutions().ifPresent { it.forEach { it.validate() } }
        trim().ifPresent { it.validate() }
        unsharpMask().ifPresent { it.validate() }
        videoCodec().ifPresent { it.validate() }
        width().ifPresent { it.validate() }
        x().ifPresent { it.validate() }
        xCenter().ifPresent { it.validate() }
        y().ifPresent { it.validate() }
        yCenter().ifPresent { it.validate() }
        zoom()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (aiChangeBackground.asKnown().isPresent) 1 else 0) +
            (aiDropShadow.asKnown().getOrNull()?.validity() ?: 0) +
            (if (aiEdit.asKnown().isPresent) 1 else 0) +
            (aiRemoveBackground.asKnown().getOrNull()?.validity() ?: 0) +
            (aiRemoveBackgroundExternal.asKnown().getOrNull()?.validity() ?: 0) +
            (aiRetouch.asKnown().getOrNull()?.validity() ?: 0) +
            (aiUpscale.asKnown().getOrNull()?.validity() ?: 0) +
            (aiVariation.asKnown().getOrNull()?.validity() ?: 0) +
            (aspectRatio.asKnown().getOrNull()?.validity() ?: 0) +
            (audioCodec.asKnown().getOrNull()?.validity() ?: 0) +
            (if (background.asKnown().isPresent) 1 else 0) +
            (if (blur.asKnown().isPresent) 1 else 0) +
            (if (border.asKnown().isPresent) 1 else 0) +
            (if (colorProfile.asKnown().isPresent) 1 else 0) +
            (if (colorReplace.asKnown().isPresent) 1 else 0) +
            (contrastStretch.asKnown().getOrNull()?.validity() ?: 0) +
            (crop.asKnown().getOrNull()?.validity() ?: 0) +
            (cropMode.asKnown().getOrNull()?.validity() ?: 0) +
            (if (defaultImage.asKnown().isPresent) 1 else 0) +
            (if (distort.asKnown().isPresent) 1 else 0) +
            (if (dpr.asKnown().isPresent) 1 else 0) +
            (duration.asKnown().getOrNull()?.validity() ?: 0) +
            (endOffset.asKnown().getOrNull()?.validity() ?: 0) +
            (flip.asKnown().getOrNull()?.validity() ?: 0) +
            (if (focus.asKnown().isPresent) 1 else 0) +
            (format.asKnown().getOrNull()?.validity() ?: 0) +
            (gradient.asKnown().getOrNull()?.validity() ?: 0) +
            (grayscale.asKnown().getOrNull()?.validity() ?: 0) +
            (height.asKnown().getOrNull()?.validity() ?: 0) +
            (if (lossless.asKnown().isPresent) 1 else 0) +
            (if (metadata.asKnown().isPresent) 1 else 0) +
            (if (named.asKnown().isPresent) 1 else 0) +
            (if (opacity.asKnown().isPresent) 1 else 0) +
            (if (original.asKnown().isPresent) 1 else 0) +
            (overlay.asKnown().getOrNull()?.validity() ?: 0) +
            (page.asKnown().getOrNull()?.validity() ?: 0) +
            (if (progressive.asKnown().isPresent) 1 else 0) +
            (if (quality.asKnown().isPresent) 1 else 0) +
            (radius.asKnown().getOrNull()?.validity() ?: 0) +
            (if (raw.asKnown().isPresent) 1 else 0) +
            (rotation.asKnown().getOrNull()?.validity() ?: 0) +
            (shadow.asKnown().getOrNull()?.validity() ?: 0) +
            (sharpen.asKnown().getOrNull()?.validity() ?: 0) +
            (startOffset.asKnown().getOrNull()?.validity() ?: 0) +
            (streamingResolutions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (trim.asKnown().getOrNull()?.validity() ?: 0) +
            (unsharpMask.asKnown().getOrNull()?.validity() ?: 0) +
            (videoCodec.asKnown().getOrNull()?.validity() ?: 0) +
            (width.asKnown().getOrNull()?.validity() ?: 0) +
            (x.asKnown().getOrNull()?.validity() ?: 0) +
            (xCenter.asKnown().getOrNull()?.validity() ?: 0) +
            (y.asKnown().getOrNull()?.validity() ?: 0) +
            (yCenter.asKnown().getOrNull()?.validity() ?: 0) +
            (if (zoom.asKnown().isPresent) 1 else 0)

    /**
     * Adds an AI-based drop shadow around a foreground object on a transparent or removed
     * background. Optionally, control the direction, elevation, and saturation of the light source
     * (e.g., `az-45` to change light direction). Pass `true` for the default drop shadow, or
     * provide a string for a custom drop shadow. Supported inside overlay. See
     * [AI Drop Shadow](https://imagekit.io/docs/ai-transformations#ai-drop-shadow-e-dropshadow).
     */
    @JsonDeserialize(using = AiDropShadow.Deserializer::class)
    @JsonSerialize(using = AiDropShadow.Serializer::class)
    class AiDropShadow
    private constructor(
        private val true_: JsonValue? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun true_(): Optional<JsonValue> = Optional.ofNullable(true_)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isTrue(): Boolean = true_ != null

        fun isString(): Boolean = string != null

        fun asTrue(): JsonValue = true_.getOrThrow("true_")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                true_ != null -> visitor.visitTrue(true_)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): AiDropShadow = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitTrue(true_: JsonValue) {
                        true_.let {
                            if (it != JsonValue.from(true)) {
                                throw ImageKitInvalidDataException(
                                    "'true_' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitString(string: String) {}
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
                    override fun visitTrue(true_: JsonValue) =
                        true_.let { if (it == JsonValue.from(true)) 1 else 0 }

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AiDropShadow && true_ == other.true_ && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(true_, string)

        override fun toString(): String =
            when {
                true_ != null -> "AiDropShadow{true_=$true_}"
                string != null -> "AiDropShadow{string=$string}"
                _json != null -> "AiDropShadow{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid AiDropShadow")
            }

        companion object {

            @JvmStatic fun ofTrue() = AiDropShadow(true_ = JsonValue.from(true))

            @JvmStatic fun ofString(string: String) = AiDropShadow(string = string)
        }

        /**
         * An interface that defines how to map each variant of [AiDropShadow] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitTrue(true_: JsonValue): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [AiDropShadow] to a value of type [T].
             *
             * An instance of [AiDropShadow] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown AiDropShadow: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<AiDropShadow>(AiDropShadow::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): AiDropShadow {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { AiDropShadow(true_ = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                AiDropShadow(string = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from integer).
                    0 -> AiDropShadow(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<AiDropShadow>(AiDropShadow::class) {

            override fun serialize(
                value: AiDropShadow,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.true_ != null -> generator.writeObject(value.true_)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid AiDropShadow")
                }
            }
        }
    }

    /**
     * Applies ImageKit's in-house background removal. Supported inside overlay. See
     * [AI Background Removal](https://imagekit.io/docs/ai-transformations#imagekit-background-removal-e-bgremove).
     */
    class AiRemoveBackground
    @JsonCreator
    private constructor(private val value: JsonField<Boolean>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Boolean> = value

        companion object {

            @JvmField val TRUE = of(true)

            @JvmStatic fun of(value: Boolean) = AiRemoveBackground(JsonField.of(value))
        }

        /** An enum containing [AiRemoveBackground]'s known values. */
        enum class Known {
            TRUE
        }

        /**
         * An enum containing [AiRemoveBackground]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [AiRemoveBackground] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TRUE,
            /**
             * An enum member indicating that [AiRemoveBackground] was instantiated with an unknown
             * value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                TRUE -> Value.TRUE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ImageKitInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                TRUE -> Known.TRUE
                else -> throw ImageKitInvalidDataException("Unknown AiRemoveBackground: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws ImageKitInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asBoolean(): Boolean =
            _value().asBoolean().orElseThrow {
                ImageKitInvalidDataException("Value is not a Boolean")
            }

        private var validated: Boolean = false

        fun validate(): AiRemoveBackground = apply {
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

            return other is AiRemoveBackground && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Uses third-party background removal. Note: It is recommended to use aiRemoveBackground,
     * ImageKit's in-house solution, which is more cost-effective. Supported inside overlay. See
     * [External Background Removal](https://imagekit.io/docs/ai-transformations#background-removal-e-removedotbg).
     */
    class AiRemoveBackgroundExternal
    @JsonCreator
    private constructor(private val value: JsonField<Boolean>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Boolean> = value

        companion object {

            @JvmField val TRUE = of(true)

            @JvmStatic fun of(value: Boolean) = AiRemoveBackgroundExternal(JsonField.of(value))
        }

        /** An enum containing [AiRemoveBackgroundExternal]'s known values. */
        enum class Known {
            TRUE
        }

        /**
         * An enum containing [AiRemoveBackgroundExternal]'s known values, as well as an [_UNKNOWN]
         * member.
         *
         * An instance of [AiRemoveBackgroundExternal] can contain an unknown value in a couple of
         * cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TRUE,
            /**
             * An enum member indicating that [AiRemoveBackgroundExternal] was instantiated with an
             * unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                TRUE -> Value.TRUE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ImageKitInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                TRUE -> Known.TRUE
                else ->
                    throw ImageKitInvalidDataException("Unknown AiRemoveBackgroundExternal: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws ImageKitInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asBoolean(): Boolean =
            _value().asBoolean().orElseThrow {
                ImageKitInvalidDataException("Value is not a Boolean")
            }

        private var validated: Boolean = false

        fun validate(): AiRemoveBackgroundExternal = apply {
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

            return other is AiRemoveBackgroundExternal && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Performs AI-based retouching to improve faces or product shots. Not supported inside overlay.
     * See [AI Retouch](https://imagekit.io/docs/ai-transformations#retouch-e-retouch).
     */
    class AiRetouch @JsonCreator private constructor(private val value: JsonField<Boolean>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Boolean> = value

        companion object {

            @JvmField val TRUE = of(true)

            @JvmStatic fun of(value: Boolean) = AiRetouch(JsonField.of(value))
        }

        /** An enum containing [AiRetouch]'s known values. */
        enum class Known {
            TRUE
        }

        /**
         * An enum containing [AiRetouch]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [AiRetouch] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TRUE,
            /**
             * An enum member indicating that [AiRetouch] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                TRUE -> Value.TRUE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ImageKitInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                TRUE -> Known.TRUE
                else -> throw ImageKitInvalidDataException("Unknown AiRetouch: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws ImageKitInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asBoolean(): Boolean =
            _value().asBoolean().orElseThrow {
                ImageKitInvalidDataException("Value is not a Boolean")
            }

        private var validated: Boolean = false

        fun validate(): AiRetouch = apply {
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

            return other is AiRetouch && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Upscales images beyond their original dimensions using AI. Not supported inside overlay. See
     * [AI Upscale](https://imagekit.io/docs/ai-transformations#upscale-e-upscale).
     */
    class AiUpscale @JsonCreator private constructor(private val value: JsonField<Boolean>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Boolean> = value

        companion object {

            @JvmField val TRUE = of(true)

            @JvmStatic fun of(value: Boolean) = AiUpscale(JsonField.of(value))
        }

        /** An enum containing [AiUpscale]'s known values. */
        enum class Known {
            TRUE
        }

        /**
         * An enum containing [AiUpscale]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [AiUpscale] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TRUE,
            /**
             * An enum member indicating that [AiUpscale] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                TRUE -> Value.TRUE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ImageKitInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                TRUE -> Known.TRUE
                else -> throw ImageKitInvalidDataException("Unknown AiUpscale: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws ImageKitInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asBoolean(): Boolean =
            _value().asBoolean().orElseThrow {
                ImageKitInvalidDataException("Value is not a Boolean")
            }

        private var validated: Boolean = false

        fun validate(): AiUpscale = apply {
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

            return other is AiUpscale && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Generates a variation of an image using AI. This produces a new image with slight variations
     * from the original, such as changes in color, texture, and other visual elements, while
     * preserving the structure and essence of the original image. Not supported inside overlay. See
     * [AI Generate Variations](https://imagekit.io/docs/ai-transformations#generate-variations-of-an-image-e-genvar).
     */
    class AiVariation @JsonCreator private constructor(private val value: JsonField<Boolean>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Boolean> = value

        companion object {

            @JvmField val TRUE = of(true)

            @JvmStatic fun of(value: Boolean) = AiVariation(JsonField.of(value))
        }

        /** An enum containing [AiVariation]'s known values. */
        enum class Known {
            TRUE
        }

        /**
         * An enum containing [AiVariation]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [AiVariation] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TRUE,
            /**
             * An enum member indicating that [AiVariation] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                TRUE -> Value.TRUE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ImageKitInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                TRUE -> Known.TRUE
                else -> throw ImageKitInvalidDataException("Unknown AiVariation: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws ImageKitInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asBoolean(): Boolean =
            _value().asBoolean().orElseThrow {
                ImageKitInvalidDataException("Value is not a Boolean")
            }

        private var validated: Boolean = false

        fun validate(): AiVariation = apply {
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

            return other is AiVariation && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Specifies the aspect ratio for the output, e.g., "ar-4-3". Typically used with either width
     * or height (but not both). For example: aspectRatio = `4:3`, `4_3`, or an expression like
     * `iar_div_2`. See
     * [Image resize and crop – Aspect ratio](https://imagekit.io/docs/image-resize-and-crop#aspect-ratio---ar).
     */
    @JsonDeserialize(using = AspectRatio.Deserializer::class)
    @JsonSerialize(using = AspectRatio.Serializer::class)
    class AspectRatio
    private constructor(
        private val number: Double? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): AspectRatio = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitString(string: String) {}
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
                    override fun visitNumber(number: Double) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AspectRatio && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "AspectRatio{number=$number}"
                string != null -> "AspectRatio{string=$string}"
                _json != null -> "AspectRatio{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid AspectRatio")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = AspectRatio(number = number)

            @JvmStatic fun ofString(string: String) = AspectRatio(string = string)
        }

        /**
         * An interface that defines how to map each variant of [AspectRatio] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [AspectRatio] to a value of type [T].
             *
             * An instance of [AspectRatio] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown AspectRatio: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<AspectRatio>(AspectRatio::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): AspectRatio {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                AspectRatio(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                AspectRatio(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> AspectRatio(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<AspectRatio>(AspectRatio::class) {

            override fun serialize(
                value: AspectRatio,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid AspectRatio")
                }
            }
        }
    }

    /**
     * Specifies the audio codec, e.g., `aac`, `opus`, or `none`. See
     * [Audio codec](https://imagekit.io/docs/video-optimization#audio-codec---ac).
     */
    class AudioCodec @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val AAC = of("aac")

            @JvmField val OPUS = of("opus")

            @JvmField val NONE = of("none")

            @JvmStatic fun of(value: String) = AudioCodec(JsonField.of(value))
        }

        /** An enum containing [AudioCodec]'s known values. */
        enum class Known {
            AAC,
            OPUS,
            NONE,
        }

        /**
         * An enum containing [AudioCodec]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [AudioCodec] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            AAC,
            OPUS,
            NONE,
            /**
             * An enum member indicating that [AudioCodec] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                AAC -> Value.AAC
                OPUS -> Value.OPUS
                NONE -> Value.NONE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ImageKitInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                AAC -> Known.AAC
                OPUS -> Known.OPUS
                NONE -> Known.NONE
                else -> throw ImageKitInvalidDataException("Unknown AudioCodec: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws ImageKitInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                ImageKitInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): AudioCodec = apply {
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

            return other is AudioCodec && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Automatically enhances the contrast of an image (contrast stretch). See
     * [Contrast Stretch](https://imagekit.io/docs/effects-and-enhancements#contrast-stretch---e-contrast).
     */
    class ContrastStretch @JsonCreator private constructor(private val value: JsonField<Boolean>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Boolean> = value

        companion object {

            @JvmField val TRUE = of(true)

            @JvmStatic fun of(value: Boolean) = ContrastStretch(JsonField.of(value))
        }

        /** An enum containing [ContrastStretch]'s known values. */
        enum class Known {
            TRUE
        }

        /**
         * An enum containing [ContrastStretch]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [ContrastStretch] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TRUE,
            /**
             * An enum member indicating that [ContrastStretch] was instantiated with an unknown
             * value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                TRUE -> Value.TRUE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ImageKitInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                TRUE -> Known.TRUE
                else -> throw ImageKitInvalidDataException("Unknown ContrastStretch: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws ImageKitInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asBoolean(): Boolean =
            _value().asBoolean().orElseThrow {
                ImageKitInvalidDataException("Value is not a Boolean")
            }

        private var validated: Boolean = false

        fun validate(): ContrastStretch = apply {
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

            return other is ContrastStretch && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Crop modes for image resizing. See
     * [Crop modes & focus](https://imagekit.io/docs/image-resize-and-crop#crop-crop-modes--focus).
     */
    class Crop @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val FORCE = of("force")

            @JvmField val AT_MAX = of("at_max")

            @JvmField val AT_MAX_ENLARGE = of("at_max_enlarge")

            @JvmField val AT_LEAST = of("at_least")

            @JvmField val MAINTAIN_RATIO = of("maintain_ratio")

            @JvmStatic fun of(value: String) = Crop(JsonField.of(value))
        }

        /** An enum containing [Crop]'s known values. */
        enum class Known {
            FORCE,
            AT_MAX,
            AT_MAX_ENLARGE,
            AT_LEAST,
            MAINTAIN_RATIO,
        }

        /**
         * An enum containing [Crop]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Crop] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            FORCE,
            AT_MAX,
            AT_MAX_ENLARGE,
            AT_LEAST,
            MAINTAIN_RATIO,
            /** An enum member indicating that [Crop] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                FORCE -> Value.FORCE
                AT_MAX -> Value.AT_MAX
                AT_MAX_ENLARGE -> Value.AT_MAX_ENLARGE
                AT_LEAST -> Value.AT_LEAST
                MAINTAIN_RATIO -> Value.MAINTAIN_RATIO
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ImageKitInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                FORCE -> Known.FORCE
                AT_MAX -> Known.AT_MAX
                AT_MAX_ENLARGE -> Known.AT_MAX_ENLARGE
                AT_LEAST -> Known.AT_LEAST
                MAINTAIN_RATIO -> Known.MAINTAIN_RATIO
                else -> throw ImageKitInvalidDataException("Unknown Crop: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws ImageKitInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                ImageKitInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): Crop = apply {
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

            return other is Crop && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Additional crop modes for image resizing. See
     * [Crop modes & focus](https://imagekit.io/docs/image-resize-and-crop#crop-crop-modes--focus).
     */
    class CropMode @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val PAD_RESIZE = of("pad_resize")

            @JvmField val EXTRACT = of("extract")

            @JvmField val PAD_EXTRACT = of("pad_extract")

            @JvmStatic fun of(value: String) = CropMode(JsonField.of(value))
        }

        /** An enum containing [CropMode]'s known values. */
        enum class Known {
            PAD_RESIZE,
            EXTRACT,
            PAD_EXTRACT,
        }

        /**
         * An enum containing [CropMode]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [CropMode] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PAD_RESIZE,
            EXTRACT,
            PAD_EXTRACT,
            /** An enum member indicating that [CropMode] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                PAD_RESIZE -> Value.PAD_RESIZE
                EXTRACT -> Value.EXTRACT
                PAD_EXTRACT -> Value.PAD_EXTRACT
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ImageKitInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                PAD_RESIZE -> Known.PAD_RESIZE
                EXTRACT -> Known.EXTRACT
                PAD_EXTRACT -> Known.PAD_EXTRACT
                else -> throw ImageKitInvalidDataException("Unknown CropMode: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws ImageKitInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                ImageKitInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): CropMode = apply {
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

            return other is CropMode && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Specifies the duration (in seconds) for trimming videos, e.g., `5` or `10.5`. Typically used
     * with startOffset to indicate the length from the start offset. Arithmetic expressions are
     * supported. See [Trim videos – Duration](https://imagekit.io/docs/trim-videos#duration---du).
     */
    @JsonDeserialize(using = Duration.Deserializer::class)
    @JsonSerialize(using = Duration.Serializer::class)
    class Duration
    private constructor(
        private val number: Double? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Duration = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitString(string: String) {}
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
                    override fun visitNumber(number: Double) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Duration && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "Duration{number=$number}"
                string != null -> "Duration{string=$string}"
                _json != null -> "Duration{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Duration")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = Duration(number = number)

            @JvmStatic fun ofString(string: String) = Duration(string = string)
        }

        /**
         * An interface that defines how to map each variant of [Duration] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Duration] to a value of type [T].
             *
             * An instance of [Duration] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Duration: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Duration>(Duration::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Duration {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Duration(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Duration(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Duration(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Duration>(Duration::class) {

            override fun serialize(
                value: Duration,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Duration")
                }
            }
        }
    }

    /**
     * Specifies the end offset (in seconds) for trimming videos, e.g., `5` or `10.5`. Typically
     * used with startOffset to define a time window. Arithmetic expressions are supported. See
     * [Trim videos – End offset](https://imagekit.io/docs/trim-videos#end-offset---eo).
     */
    @JsonDeserialize(using = EndOffset.Deserializer::class)
    @JsonSerialize(using = EndOffset.Serializer::class)
    class EndOffset
    private constructor(
        private val number: Double? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): EndOffset = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitString(string: String) {}
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
                    override fun visitNumber(number: Double) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EndOffset && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "EndOffset{number=$number}"
                string != null -> "EndOffset{string=$string}"
                _json != null -> "EndOffset{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid EndOffset")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = EndOffset(number = number)

            @JvmStatic fun ofString(string: String) = EndOffset(string = string)
        }

        /**
         * An interface that defines how to map each variant of [EndOffset] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [EndOffset] to a value of type [T].
             *
             * An instance of [EndOffset] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown EndOffset: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<EndOffset>(EndOffset::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): EndOffset {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                EndOffset(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                EndOffset(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> EndOffset(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<EndOffset>(EndOffset::class) {

            override fun serialize(
                value: EndOffset,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid EndOffset")
                }
            }
        }
    }

    /**
     * Flips or mirrors an image either horizontally, vertically, or both. Acceptable values: `h`
     * (horizontal), `v` (vertical), `h_v` (horizontal and vertical), or `v_h`. See
     * [Flip](https://imagekit.io/docs/effects-and-enhancements#flip---fl).
     */
    class Flip @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val H = of("h")

            @JvmField val V = of("v")

            @JvmField val H_V = of("h_v")

            @JvmField val V_H = of("v_h")

            @JvmStatic fun of(value: String) = Flip(JsonField.of(value))
        }

        /** An enum containing [Flip]'s known values. */
        enum class Known {
            H,
            V,
            H_V,
            V_H,
        }

        /**
         * An enum containing [Flip]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Flip] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            H,
            V,
            H_V,
            V_H,
            /** An enum member indicating that [Flip] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                H -> Value.H
                V -> Value.V
                H_V -> Value.H_V
                V_H -> Value.V_H
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ImageKitInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                H -> Known.H
                V -> Known.V
                H_V -> Known.H_V
                V_H -> Known.V_H
                else -> throw ImageKitInvalidDataException("Unknown Flip: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws ImageKitInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                ImageKitInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): Flip = apply {
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

            return other is Flip && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Specifies the output format for images or videos, e.g., `jpg`, `png`, `webp`, `mp4`, or
     * `auto`. You can also pass `orig` for images to return the original format. ImageKit
     * automatically delivers images and videos in the optimal format based on device support unless
     * overridden by the dashboard settings or the format parameter. See
     * [Image format](https://imagekit.io/docs/image-optimization#format---f) and
     * [Video format](https://imagekit.io/docs/video-optimization#format---f).
     */
    class Format @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val AUTO = of("auto")

            @JvmField val WEBP = of("webp")

            @JvmField val JPG = of("jpg")

            @JvmField val JPEG = of("jpeg")

            @JvmField val PNG = of("png")

            @JvmField val GIF = of("gif")

            @JvmField val SVG = of("svg")

            @JvmField val MP4 = of("mp4")

            @JvmField val WEBM = of("webm")

            @JvmField val AVIF = of("avif")

            @JvmField val ORIG = of("orig")

            @JvmStatic fun of(value: String) = Format(JsonField.of(value))
        }

        /** An enum containing [Format]'s known values. */
        enum class Known {
            AUTO,
            WEBP,
            JPG,
            JPEG,
            PNG,
            GIF,
            SVG,
            MP4,
            WEBM,
            AVIF,
            ORIG,
        }

        /**
         * An enum containing [Format]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Format] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            AUTO,
            WEBP,
            JPG,
            JPEG,
            PNG,
            GIF,
            SVG,
            MP4,
            WEBM,
            AVIF,
            ORIG,
            /** An enum member indicating that [Format] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                AUTO -> Value.AUTO
                WEBP -> Value.WEBP
                JPG -> Value.JPG
                JPEG -> Value.JPEG
                PNG -> Value.PNG
                GIF -> Value.GIF
                SVG -> Value.SVG
                MP4 -> Value.MP4
                WEBM -> Value.WEBM
                AVIF -> Value.AVIF
                ORIG -> Value.ORIG
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ImageKitInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                AUTO -> Known.AUTO
                WEBP -> Known.WEBP
                JPG -> Known.JPG
                JPEG -> Known.JPEG
                PNG -> Known.PNG
                GIF -> Known.GIF
                SVG -> Known.SVG
                MP4 -> Known.MP4
                WEBM -> Known.WEBM
                AVIF -> Known.AVIF
                ORIG -> Known.ORIG
                else -> throw ImageKitInvalidDataException("Unknown Format: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws ImageKitInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                ImageKitInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): Format = apply {
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

            return other is Format && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Creates a linear gradient with two colors. Pass `true` for a default gradient, or provide a
     * string for a custom gradient. See
     * [Gradient](https://imagekit.io/docs/effects-and-enhancements#gradient---e-gradient).
     */
    @JsonDeserialize(using = Gradient.Deserializer::class)
    @JsonSerialize(using = Gradient.Serializer::class)
    class Gradient
    private constructor(
        private val true_: JsonValue? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun true_(): Optional<JsonValue> = Optional.ofNullable(true_)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isTrue(): Boolean = true_ != null

        fun isString(): Boolean = string != null

        fun asTrue(): JsonValue = true_.getOrThrow("true_")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                true_ != null -> visitor.visitTrue(true_)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Gradient = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitTrue(true_: JsonValue) {
                        true_.let {
                            if (it != JsonValue.from(true)) {
                                throw ImageKitInvalidDataException(
                                    "'true_' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitString(string: String) {}
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
                    override fun visitTrue(true_: JsonValue) =
                        true_.let { if (it == JsonValue.from(true)) 1 else 0 }

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Gradient && true_ == other.true_ && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(true_, string)

        override fun toString(): String =
            when {
                true_ != null -> "Gradient{true_=$true_}"
                string != null -> "Gradient{string=$string}"
                _json != null -> "Gradient{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Gradient")
            }

        companion object {

            @JvmStatic fun ofTrue() = Gradient(true_ = JsonValue.from(true))

            @JvmStatic fun ofString(string: String) = Gradient(string = string)
        }

        /**
         * An interface that defines how to map each variant of [Gradient] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitTrue(true_: JsonValue): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Gradient] to a value of type [T].
             *
             * An instance of [Gradient] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Gradient: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Gradient>(Gradient::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Gradient {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { Gradient(true_ = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Gradient(string = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from integer).
                    0 -> Gradient(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Gradient>(Gradient::class) {

            override fun serialize(
                value: Gradient,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.true_ != null -> generator.writeObject(value.true_)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Gradient")
                }
            }
        }
    }

    /**
     * Enables a grayscale effect for images. See
     * [Grayscale](https://imagekit.io/docs/effects-and-enhancements#grayscale---e-grayscale).
     */
    class Grayscale @JsonCreator private constructor(private val value: JsonField<Boolean>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Boolean> = value

        companion object {

            @JvmField val TRUE = of(true)

            @JvmStatic fun of(value: Boolean) = Grayscale(JsonField.of(value))
        }

        /** An enum containing [Grayscale]'s known values. */
        enum class Known {
            TRUE
        }

        /**
         * An enum containing [Grayscale]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Grayscale] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TRUE,
            /**
             * An enum member indicating that [Grayscale] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                TRUE -> Value.TRUE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ImageKitInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                TRUE -> Known.TRUE
                else -> throw ImageKitInvalidDataException("Unknown Grayscale: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws ImageKitInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asBoolean(): Boolean =
            _value().asBoolean().orElseThrow {
                ImageKitInvalidDataException("Value is not a Boolean")
            }

        private var validated: Boolean = false

        fun validate(): Grayscale = apply {
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

            return other is Grayscale && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Specifies the height of the output. If a value between 0 and 1 is provided, it is treated as
     * a percentage (e.g., `0.5` represents 50% of the original height). You can also supply
     * arithmetic expressions (e.g., `ih_mul_0.5`). Height transformation –
     * [Images](https://imagekit.io/docs/image-resize-and-crop#height---h) ·
     * [Videos](https://imagekit.io/docs/video-resize-and-crop#height---h)
     */
    @JsonDeserialize(using = Height.Deserializer::class)
    @JsonSerialize(using = Height.Serializer::class)
    class Height
    private constructor(
        private val number: Double? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Height = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitString(string: String) {}
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
                    override fun visitNumber(number: Double) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Height && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "Height{number=$number}"
                string != null -> "Height{string=$string}"
                _json != null -> "Height{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Height")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = Height(number = number)

            @JvmStatic fun ofString(string: String) = Height(string = string)
        }

        /** An interface that defines how to map each variant of [Height] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Height] to a value of type [T].
             *
             * An instance of [Height] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Height: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Height>(Height::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Height {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Height(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Height(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Height(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Height>(Height::class) {

            override fun serialize(
                value: Height,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Height")
                }
            }
        }
    }

    /**
     * Extracts a specific page or frame from multi-page or layered files (PDF, PSD, AI). For
     * example, specify by number (e.g., `2`), a range (e.g., `3-4` for the 2nd and 3rd layers), or
     * by name (e.g., `name-layer-4` for a PSD layer). See
     * [Thumbnail extraction](https://imagekit.io/docs/vector-and-animated-images#get-thumbnail-from-psd-pdf-ai-eps-and-animated-files).
     */
    @JsonDeserialize(using = Page.Deserializer::class)
    @JsonSerialize(using = Page.Serializer::class)
    class Page
    private constructor(
        private val number: Double? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Page = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitString(string: String) {}
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
                    override fun visitNumber(number: Double) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Page && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "Page{number=$number}"
                string != null -> "Page{string=$string}"
                _json != null -> "Page{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Page")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = Page(number = number)

            @JvmStatic fun ofString(string: String) = Page(string = string)
        }

        /** An interface that defines how to map each variant of [Page] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Page] to a value of type [T].
             *
             * An instance of [Page] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Page: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Page>(Page::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Page {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Page(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Page(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Page(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Page>(Page::class) {

            override fun serialize(
                value: Page,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Page")
                }
            }
        }
    }

    /**
     * Specifies the corner radius for rounded corners.
     * - Single value (positive integer): Applied to all corners (e.g., `20`).
     * - `max`: Creates a circular or oval shape.
     * - Per-corner array: Provide four underscore-separated values representing top-left,
     *   top-right, bottom-right, and bottom-left corners respectively (e.g., `10_20_30_40`). See
     *   [Radius](https://imagekit.io/docs/effects-and-enhancements#radius---r).
     */
    @JsonDeserialize(using = Radius.Deserializer::class)
    @JsonSerialize(using = Radius.Serializer::class)
    class Radius
    private constructor(
        private val number: Double? = null,
        private val max: JsonValue? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun max(): Optional<JsonValue> = Optional.ofNullable(max)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isMax(): Boolean = max != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asMax(): JsonValue = max.getOrThrow("max")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                max != null -> visitor.visitMax(max)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Radius = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitMax(max: JsonValue) {
                        max.let {
                            if (it != JsonValue.from("max")) {
                                throw ImageKitInvalidDataException("'max' is invalid, received $it")
                            }
                        }
                    }

                    override fun visitString(string: String) {}
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
                    override fun visitNumber(number: Double) = 1

                    override fun visitMax(max: JsonValue) =
                        max.let { if (it == JsonValue.from("max")) 1 else 0 }

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Radius &&
                number == other.number &&
                max == other.max &&
                string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, max, string)

        override fun toString(): String =
            when {
                number != null -> "Radius{number=$number}"
                max != null -> "Radius{max=$max}"
                string != null -> "Radius{string=$string}"
                _json != null -> "Radius{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Radius")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = Radius(number = number)

            @JvmStatic fun ofMax() = Radius(max = JsonValue.from("max"))

            @JvmStatic fun ofString(string: String) = Radius(string = string)
        }

        /** An interface that defines how to map each variant of [Radius] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitMax(max: JsonValue): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Radius] to a value of type [T].
             *
             * An instance of [Radius] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Radius: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Radius>(Radius::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Radius {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { Radius(max = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Radius(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Radius(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Radius(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Radius>(Radius::class) {

            override fun serialize(
                value: Radius,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.max != null -> generator.writeObject(value.max)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Radius")
                }
            }
        }
    }

    /**
     * Specifies the rotation angle in degrees. Positive values rotate the image clockwise; you can
     * also use, for example, `N40` for counterclockwise rotation or `auto` to use the orientation
     * specified in the image's EXIF data. For videos, only the following values are supported: 0,
     * 90, 180, 270, or 360. See
     * [Rotate](https://imagekit.io/docs/effects-and-enhancements#rotate---rt).
     */
    @JsonDeserialize(using = Rotation.Deserializer::class)
    @JsonSerialize(using = Rotation.Serializer::class)
    class Rotation
    private constructor(
        private val number: Double? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Rotation = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitString(string: String) {}
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
                    override fun visitNumber(number: Double) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Rotation && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "Rotation{number=$number}"
                string != null -> "Rotation{string=$string}"
                _json != null -> "Rotation{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Rotation")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = Rotation(number = number)

            @JvmStatic fun ofString(string: String) = Rotation(string = string)
        }

        /**
         * An interface that defines how to map each variant of [Rotation] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Rotation] to a value of type [T].
             *
             * An instance of [Rotation] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Rotation: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Rotation>(Rotation::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Rotation {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Rotation(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Rotation(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Rotation(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Rotation>(Rotation::class) {

            override fun serialize(
                value: Rotation,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Rotation")
                }
            }
        }
    }

    /**
     * Adds a shadow beneath solid objects in an image with a transparent background. For AI-based
     * drop shadows, refer to aiDropShadow. Pass `true` for a default shadow, or provide a string
     * for a custom shadow. See
     * [Shadow](https://imagekit.io/docs/effects-and-enhancements#shadow---e-shadow).
     */
    @JsonDeserialize(using = Shadow.Deserializer::class)
    @JsonSerialize(using = Shadow.Serializer::class)
    class Shadow
    private constructor(
        private val true_: JsonValue? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun true_(): Optional<JsonValue> = Optional.ofNullable(true_)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isTrue(): Boolean = true_ != null

        fun isString(): Boolean = string != null

        fun asTrue(): JsonValue = true_.getOrThrow("true_")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                true_ != null -> visitor.visitTrue(true_)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Shadow = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitTrue(true_: JsonValue) {
                        true_.let {
                            if (it != JsonValue.from(true)) {
                                throw ImageKitInvalidDataException(
                                    "'true_' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitString(string: String) {}
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
                    override fun visitTrue(true_: JsonValue) =
                        true_.let { if (it == JsonValue.from(true)) 1 else 0 }

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Shadow && true_ == other.true_ && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(true_, string)

        override fun toString(): String =
            when {
                true_ != null -> "Shadow{true_=$true_}"
                string != null -> "Shadow{string=$string}"
                _json != null -> "Shadow{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Shadow")
            }

        companion object {

            @JvmStatic fun ofTrue() = Shadow(true_ = JsonValue.from(true))

            @JvmStatic fun ofString(string: String) = Shadow(string = string)
        }

        /** An interface that defines how to map each variant of [Shadow] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitTrue(true_: JsonValue): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Shadow] to a value of type [T].
             *
             * An instance of [Shadow] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Shadow: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Shadow>(Shadow::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Shadow {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { Shadow(true_ = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Shadow(string = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from integer).
                    0 -> Shadow(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Shadow>(Shadow::class) {

            override fun serialize(
                value: Shadow,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.true_ != null -> generator.writeObject(value.true_)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Shadow")
                }
            }
        }
    }

    /**
     * Sharpens the input image, highlighting edges and finer details. Pass `true` for default
     * sharpening, or provide a numeric value for custom sharpening. See
     * [Sharpen](https://imagekit.io/docs/effects-and-enhancements#sharpen---e-sharpen).
     */
    @JsonDeserialize(using = Sharpen.Deserializer::class)
    @JsonSerialize(using = Sharpen.Serializer::class)
    class Sharpen
    private constructor(
        private val true_: JsonValue? = null,
        private val number: Double? = null,
        private val _json: JsonValue? = null,
    ) {

        fun true_(): Optional<JsonValue> = Optional.ofNullable(true_)

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun isTrue(): Boolean = true_ != null

        fun isNumber(): Boolean = number != null

        fun asTrue(): JsonValue = true_.getOrThrow("true_")

        fun asNumber(): Double = number.getOrThrow("number")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                true_ != null -> visitor.visitTrue(true_)
                number != null -> visitor.visitNumber(number)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Sharpen = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitTrue(true_: JsonValue) {
                        true_.let {
                            if (it != JsonValue.from(true)) {
                                throw ImageKitInvalidDataException(
                                    "'true_' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitNumber(number: Double) {}
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
                    override fun visitTrue(true_: JsonValue) =
                        true_.let { if (it == JsonValue.from(true)) 1 else 0 }

                    override fun visitNumber(number: Double) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Sharpen && true_ == other.true_ && number == other.number
        }

        override fun hashCode(): Int = Objects.hash(true_, number)

        override fun toString(): String =
            when {
                true_ != null -> "Sharpen{true_=$true_}"
                number != null -> "Sharpen{number=$number}"
                _json != null -> "Sharpen{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Sharpen")
            }

        companion object {

            @JvmStatic fun ofTrue() = Sharpen(true_ = JsonValue.from(true))

            @JvmStatic fun ofNumber(number: Double) = Sharpen(number = number)
        }

        /**
         * An interface that defines how to map each variant of [Sharpen] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitTrue(true_: JsonValue): T

            fun visitNumber(number: Double): T

            /**
             * Maps an unknown variant of [Sharpen] to a value of type [T].
             *
             * An instance of [Sharpen] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Sharpen: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Sharpen>(Sharpen::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Sharpen {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { Sharpen(true_ = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Sharpen(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from string).
                    0 -> Sharpen(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Sharpen>(Sharpen::class) {

            override fun serialize(
                value: Sharpen,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.true_ != null -> generator.writeObject(value.true_)
                    value.number != null -> generator.writeObject(value.number)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Sharpen")
                }
            }
        }
    }

    /**
     * Specifies the start offset (in seconds) for trimming videos, e.g., `5` or `10.5`. Arithmetic
     * expressions are also supported. See
     * [Trim videos – Start offset](https://imagekit.io/docs/trim-videos#start-offset---so).
     */
    @JsonDeserialize(using = StartOffset.Deserializer::class)
    @JsonSerialize(using = StartOffset.Serializer::class)
    class StartOffset
    private constructor(
        private val number: Double? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): StartOffset = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitString(string: String) {}
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
                    override fun visitNumber(number: Double) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is StartOffset && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "StartOffset{number=$number}"
                string != null -> "StartOffset{string=$string}"
                _json != null -> "StartOffset{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid StartOffset")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = StartOffset(number = number)

            @JvmStatic fun ofString(string: String) = StartOffset(string = string)
        }

        /**
         * An interface that defines how to map each variant of [StartOffset] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [StartOffset] to a value of type [T].
             *
             * An instance of [StartOffset] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown StartOffset: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<StartOffset>(StartOffset::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): StartOffset {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                StartOffset(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                StartOffset(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> StartOffset(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<StartOffset>(StartOffset::class) {

            override fun serialize(
                value: StartOffset,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid StartOffset")
                }
            }
        }
    }

    /**
     * Useful for images with a solid or nearly solid background and a central object. This
     * parameter trims the background, leaving only the central object in the output image. See
     * [Trim edges](https://imagekit.io/docs/effects-and-enhancements#trim-edges---t).
     */
    @JsonDeserialize(using = Trim.Deserializer::class)
    @JsonSerialize(using = Trim.Serializer::class)
    class Trim
    private constructor(
        private val true_: JsonValue? = null,
        private val number: Double? = null,
        private val _json: JsonValue? = null,
    ) {

        fun true_(): Optional<JsonValue> = Optional.ofNullable(true_)

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun isTrue(): Boolean = true_ != null

        fun isNumber(): Boolean = number != null

        fun asTrue(): JsonValue = true_.getOrThrow("true_")

        fun asNumber(): Double = number.getOrThrow("number")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                true_ != null -> visitor.visitTrue(true_)
                number != null -> visitor.visitNumber(number)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Trim = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitTrue(true_: JsonValue) {
                        true_.let {
                            if (it != JsonValue.from(true)) {
                                throw ImageKitInvalidDataException(
                                    "'true_' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitNumber(number: Double) {}
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
                    override fun visitTrue(true_: JsonValue) =
                        true_.let { if (it == JsonValue.from(true)) 1 else 0 }

                    override fun visitNumber(number: Double) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Trim && true_ == other.true_ && number == other.number
        }

        override fun hashCode(): Int = Objects.hash(true_, number)

        override fun toString(): String =
            when {
                true_ != null -> "Trim{true_=$true_}"
                number != null -> "Trim{number=$number}"
                _json != null -> "Trim{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Trim")
            }

        companion object {

            @JvmStatic fun ofTrue() = Trim(true_ = JsonValue.from(true))

            @JvmStatic fun ofNumber(number: Double) = Trim(number = number)
        }

        /** An interface that defines how to map each variant of [Trim] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitTrue(true_: JsonValue): T

            fun visitNumber(number: Double): T

            /**
             * Maps an unknown variant of [Trim] to a value of type [T].
             *
             * An instance of [Trim] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Trim: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Trim>(Trim::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Trim {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { Trim(true_ = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Trim(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from string).
                    0 -> Trim(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Trim>(Trim::class) {

            override fun serialize(
                value: Trim,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.true_ != null -> generator.writeObject(value.true_)
                    value.number != null -> generator.writeObject(value.number)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Trim")
                }
            }
        }
    }

    /**
     * Applies Unsharp Masking (USM), an image sharpening technique. Pass `true` for a default
     * unsharp mask, or provide a string for a custom unsharp mask. See
     * [Unsharp Mask](https://imagekit.io/docs/effects-and-enhancements#unsharp-mask---e-usm).
     */
    @JsonDeserialize(using = UnsharpMask.Deserializer::class)
    @JsonSerialize(using = UnsharpMask.Serializer::class)
    class UnsharpMask
    private constructor(
        private val true_: JsonValue? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun true_(): Optional<JsonValue> = Optional.ofNullable(true_)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isTrue(): Boolean = true_ != null

        fun isString(): Boolean = string != null

        fun asTrue(): JsonValue = true_.getOrThrow("true_")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                true_ != null -> visitor.visitTrue(true_)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): UnsharpMask = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitTrue(true_: JsonValue) {
                        true_.let {
                            if (it != JsonValue.from(true)) {
                                throw ImageKitInvalidDataException(
                                    "'true_' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitString(string: String) {}
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
                    override fun visitTrue(true_: JsonValue) =
                        true_.let { if (it == JsonValue.from(true)) 1 else 0 }

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is UnsharpMask && true_ == other.true_ && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(true_, string)

        override fun toString(): String =
            when {
                true_ != null -> "UnsharpMask{true_=$true_}"
                string != null -> "UnsharpMask{string=$string}"
                _json != null -> "UnsharpMask{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid UnsharpMask")
            }

        companion object {

            @JvmStatic fun ofTrue() = UnsharpMask(true_ = JsonValue.from(true))

            @JvmStatic fun ofString(string: String) = UnsharpMask(string = string)
        }

        /**
         * An interface that defines how to map each variant of [UnsharpMask] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitTrue(true_: JsonValue): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [UnsharpMask] to a value of type [T].
             *
             * An instance of [UnsharpMask] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown UnsharpMask: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<UnsharpMask>(UnsharpMask::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): UnsharpMask {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { UnsharpMask(true_ = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                UnsharpMask(string = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from integer).
                    0 -> UnsharpMask(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<UnsharpMask>(UnsharpMask::class) {

            override fun serialize(
                value: UnsharpMask,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.true_ != null -> generator.writeObject(value.true_)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid UnsharpMask")
                }
            }
        }
    }

    /**
     * Specifies the video codec, e.g., `h264`, `vp9`, `av1`, or `none`. See
     * [Video codec](https://imagekit.io/docs/video-optimization#video-codec---vc).
     */
    class VideoCodec @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val H264 = of("h264")

            @JvmField val VP9 = of("vp9")

            @JvmField val AV1 = of("av1")

            @JvmField val NONE = of("none")

            @JvmStatic fun of(value: String) = VideoCodec(JsonField.of(value))
        }

        /** An enum containing [VideoCodec]'s known values. */
        enum class Known {
            H264,
            VP9,
            AV1,
            NONE,
        }

        /**
         * An enum containing [VideoCodec]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [VideoCodec] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            H264,
            VP9,
            AV1,
            NONE,
            /**
             * An enum member indicating that [VideoCodec] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                H264 -> Value.H264
                VP9 -> Value.VP9
                AV1 -> Value.AV1
                NONE -> Value.NONE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ImageKitInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                H264 -> Known.H264
                VP9 -> Known.VP9
                AV1 -> Known.AV1
                NONE -> Known.NONE
                else -> throw ImageKitInvalidDataException("Unknown VideoCodec: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws ImageKitInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                ImageKitInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): VideoCodec = apply {
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

            return other is VideoCodec && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Specifies the width of the output. If a value between 0 and 1 is provided, it is treated as a
     * percentage (e.g., `0.4` represents 40% of the original width). You can also supply arithmetic
     * expressions (e.g., `iw_div_2`). Width transformation –
     * [Images](https://imagekit.io/docs/image-resize-and-crop#width---w) ·
     * [Videos](https://imagekit.io/docs/video-resize-and-crop#width---w)
     */
    @JsonDeserialize(using = Width.Deserializer::class)
    @JsonSerialize(using = Width.Serializer::class)
    class Width
    private constructor(
        private val number: Double? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Width = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitString(string: String) {}
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
                    override fun visitNumber(number: Double) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Width && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "Width{number=$number}"
                string != null -> "Width{string=$string}"
                _json != null -> "Width{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Width")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = Width(number = number)

            @JvmStatic fun ofString(string: String) = Width(string = string)
        }

        /** An interface that defines how to map each variant of [Width] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Width] to a value of type [T].
             *
             * An instance of [Width] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Width: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Width>(Width::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Width {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Width(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Width(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Width(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Width>(Width::class) {

            override fun serialize(
                value: Width,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Width")
                }
            }
        }
    }

    /**
     * Focus using cropped image coordinates - X coordinate. See
     * [Focus using cropped coordinates](https://imagekit.io/docs/image-resize-and-crop#example---focus-using-cropped-image-coordinates).
     */
    @JsonDeserialize(using = X.Deserializer::class)
    @JsonSerialize(using = X.Serializer::class)
    class X
    private constructor(
        private val number: Double? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): X = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitString(string: String) {}
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
                    override fun visitNumber(number: Double) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is X && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "X{number=$number}"
                string != null -> "X{string=$string}"
                _json != null -> "X{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid X")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = X(number = number)

            @JvmStatic fun ofString(string: String) = X(string = string)
        }

        /** An interface that defines how to map each variant of [X] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [X] to a value of type [T].
             *
             * An instance of [X] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown X: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<X>(X::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): X {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                X(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                X(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> X(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<X>(X::class) {

            override fun serialize(
                value: X,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid X")
                }
            }
        }
    }

    /**
     * Focus using cropped image coordinates - X center coordinate. See
     * [Focus using cropped coordinates](https://imagekit.io/docs/image-resize-and-crop#example---focus-using-cropped-image-coordinates).
     */
    @JsonDeserialize(using = XCenter.Deserializer::class)
    @JsonSerialize(using = XCenter.Serializer::class)
    class XCenter
    private constructor(
        private val number: Double? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): XCenter = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitString(string: String) {}
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
                    override fun visitNumber(number: Double) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is XCenter && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "XCenter{number=$number}"
                string != null -> "XCenter{string=$string}"
                _json != null -> "XCenter{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid XCenter")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = XCenter(number = number)

            @JvmStatic fun ofString(string: String) = XCenter(string = string)
        }

        /**
         * An interface that defines how to map each variant of [XCenter] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [XCenter] to a value of type [T].
             *
             * An instance of [XCenter] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown XCenter: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<XCenter>(XCenter::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): XCenter {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                XCenter(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                XCenter(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> XCenter(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<XCenter>(XCenter::class) {

            override fun serialize(
                value: XCenter,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid XCenter")
                }
            }
        }
    }

    /**
     * Focus using cropped image coordinates - Y coordinate. See
     * [Focus using cropped coordinates](https://imagekit.io/docs/image-resize-and-crop#example---focus-using-cropped-image-coordinates).
     */
    @JsonDeserialize(using = Y.Deserializer::class)
    @JsonSerialize(using = Y.Serializer::class)
    class Y
    private constructor(
        private val number: Double? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Y = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitString(string: String) {}
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
                    override fun visitNumber(number: Double) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Y && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "Y{number=$number}"
                string != null -> "Y{string=$string}"
                _json != null -> "Y{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Y")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = Y(number = number)

            @JvmStatic fun ofString(string: String) = Y(string = string)
        }

        /** An interface that defines how to map each variant of [Y] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [Y] to a value of type [T].
             *
             * An instance of [Y] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown Y: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Y>(Y::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Y {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Y(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                Y(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Y(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Y>(Y::class) {

            override fun serialize(
                value: Y,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Y")
                }
            }
        }
    }

    /**
     * Focus using cropped image coordinates - Y center coordinate. See
     * [Focus using cropped coordinates](https://imagekit.io/docs/image-resize-and-crop#example---focus-using-cropped-image-coordinates).
     */
    @JsonDeserialize(using = YCenter.Deserializer::class)
    @JsonSerialize(using = YCenter.Serializer::class)
    class YCenter
    private constructor(
        private val number: Double? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<Double> = Optional.ofNullable(number)

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun isNumber(): Boolean = number != null

        fun isString(): Boolean = string != null

        fun asNumber(): Double = number.getOrThrow("number")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): YCenter = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: Double) {}

                    override fun visitString(string: String) {}
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
                    override fun visitNumber(number: Double) = 1

                    override fun visitString(string: String) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is YCenter && number == other.number && string == other.string
        }

        override fun hashCode(): Int = Objects.hash(number, string)

        override fun toString(): String =
            when {
                number != null -> "YCenter{number=$number}"
                string != null -> "YCenter{string=$string}"
                _json != null -> "YCenter{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid YCenter")
            }

        companion object {

            @JvmStatic fun ofNumber(number: Double) = YCenter(number = number)

            @JvmStatic fun ofString(string: String) = YCenter(string = string)
        }

        /**
         * An interface that defines how to map each variant of [YCenter] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitNumber(number: Double): T

            fun visitString(string: String): T

            /**
             * Maps an unknown variant of [YCenter] to a value of type [T].
             *
             * An instance of [YCenter] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown YCenter: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<YCenter>(YCenter::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): YCenter {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                YCenter(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                YCenter(number = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> YCenter(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<YCenter>(YCenter::class) {

            override fun serialize(
                value: YCenter,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid YCenter")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Transformation &&
            aiChangeBackground == other.aiChangeBackground &&
            aiDropShadow == other.aiDropShadow &&
            aiEdit == other.aiEdit &&
            aiRemoveBackground == other.aiRemoveBackground &&
            aiRemoveBackgroundExternal == other.aiRemoveBackgroundExternal &&
            aiRetouch == other.aiRetouch &&
            aiUpscale == other.aiUpscale &&
            aiVariation == other.aiVariation &&
            aspectRatio == other.aspectRatio &&
            audioCodec == other.audioCodec &&
            background == other.background &&
            blur == other.blur &&
            border == other.border &&
            colorProfile == other.colorProfile &&
            colorReplace == other.colorReplace &&
            contrastStretch == other.contrastStretch &&
            crop == other.crop &&
            cropMode == other.cropMode &&
            defaultImage == other.defaultImage &&
            distort == other.distort &&
            dpr == other.dpr &&
            duration == other.duration &&
            endOffset == other.endOffset &&
            flip == other.flip &&
            focus == other.focus &&
            format == other.format &&
            gradient == other.gradient &&
            grayscale == other.grayscale &&
            height == other.height &&
            lossless == other.lossless &&
            metadata == other.metadata &&
            named == other.named &&
            opacity == other.opacity &&
            original == other.original &&
            overlay == other.overlay &&
            page == other.page &&
            progressive == other.progressive &&
            quality == other.quality &&
            radius == other.radius &&
            raw == other.raw &&
            rotation == other.rotation &&
            shadow == other.shadow &&
            sharpen == other.sharpen &&
            startOffset == other.startOffset &&
            streamingResolutions == other.streamingResolutions &&
            trim == other.trim &&
            unsharpMask == other.unsharpMask &&
            videoCodec == other.videoCodec &&
            width == other.width &&
            x == other.x &&
            xCenter == other.xCenter &&
            y == other.y &&
            yCenter == other.yCenter &&
            zoom == other.zoom &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            aiChangeBackground,
            aiDropShadow,
            aiEdit,
            aiRemoveBackground,
            aiRemoveBackgroundExternal,
            aiRetouch,
            aiUpscale,
            aiVariation,
            aspectRatio,
            audioCodec,
            background,
            blur,
            border,
            colorProfile,
            colorReplace,
            contrastStretch,
            crop,
            cropMode,
            defaultImage,
            distort,
            dpr,
            duration,
            endOffset,
            flip,
            focus,
            format,
            gradient,
            grayscale,
            height,
            lossless,
            metadata,
            named,
            opacity,
            original,
            overlay,
            page,
            progressive,
            quality,
            radius,
            raw,
            rotation,
            shadow,
            sharpen,
            startOffset,
            streamingResolutions,
            trim,
            unsharpMask,
            videoCodec,
            width,
            x,
            xCenter,
            y,
            yCenter,
            zoom,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Transformation{aiChangeBackground=$aiChangeBackground, aiDropShadow=$aiDropShadow, aiEdit=$aiEdit, aiRemoveBackground=$aiRemoveBackground, aiRemoveBackgroundExternal=$aiRemoveBackgroundExternal, aiRetouch=$aiRetouch, aiUpscale=$aiUpscale, aiVariation=$aiVariation, aspectRatio=$aspectRatio, audioCodec=$audioCodec, background=$background, blur=$blur, border=$border, colorProfile=$colorProfile, colorReplace=$colorReplace, contrastStretch=$contrastStretch, crop=$crop, cropMode=$cropMode, defaultImage=$defaultImage, distort=$distort, dpr=$dpr, duration=$duration, endOffset=$endOffset, flip=$flip, focus=$focus, format=$format, gradient=$gradient, grayscale=$grayscale, height=$height, lossless=$lossless, metadata=$metadata, named=$named, opacity=$opacity, original=$original, overlay=$overlay, page=$page, progressive=$progressive, quality=$quality, radius=$radius, raw=$raw, rotation=$rotation, shadow=$shadow, sharpen=$sharpen, startOffset=$startOffset, streamingResolutions=$streamingResolutions, trim=$trim, unsharpMask=$unsharpMask, videoCodec=$videoCodec, width=$width, x=$x, xCenter=$xCenter, y=$y, yCenter=$yCenter, zoom=$zoom, additionalProperties=$additionalProperties}"
}
