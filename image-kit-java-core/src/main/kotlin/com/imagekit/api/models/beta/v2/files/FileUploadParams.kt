// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.beta.v2.files

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

/**
 * The V2 API enhances security by verifying the entire payload using JWT. This API is in beta.
 *
 * ImageKit.io allows you to upload files directly from both the server and client sides. For
 * server-side uploads, private API key authentication is used. For client-side uploads, generate a
 * one-time `token` from your secure backend using private API.
 * [Learn more](/docs/api-reference/upload-file/upload-file-v2#how-to-implement-secure-client-side-file-upload)
 * about how to implement secure client-side file upload.
 *
 * **File size limit** \ On the free plan, the maximum upload file sizes are 20MB for images, audio,
 * and raw files, and 100MB for videos. On the paid plan, these limits increase to 40MB for images,
 * audio, and raw files, and 2GB for videos. These limits can be further increased with higher-tier
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
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

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
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun file(): InputStream = body.file()

    /**
     * The name with which the file has to be uploaded.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun fileName(): String = body.fileName()

    /**
     * This is the client-generated JSON Web Token (JWT). The ImageKit.io server uses it to
     * authenticate and check that the upload request parameters have not been tampered with after
     * the token has been generated. Learn how to create the token on the page below. This field is
     * only required for authentication when uploading a file from the client side.
     *
     * **Note**: Sending a JWT that has been used in the past will result in a validation error.
     * Even if your previous request resulted in an error, you should always send a new token.
     *
     * **⚠️Warning**: JWT must be generated on the server-side because it is generated using your
     * account's private API key. This field is required for authentication when uploading a file
     * from the client-side.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun token(): Optional<String> = body.token()

    /**
     * Server-side checks to run on the asset. Read more about
     * [Upload API checks](/docs/api-reference/upload-file/upload-file-v2#upload-api-checks).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun checks(): Optional<String> = body.checks()

    /**
     * Define an important area in the image. This is only relevant for image type files.
     * - To be passed as a string with the x and y coordinates of the top-left corner, and width and
     *   height of the area of interest in the format `x,y,width,height`. For example -
     *   `10,10,100,100`
     * - Can be used with fo-customtransformation.
     * - If this field is not specified and the file is overwritten, then customCoordinates will be
     *   removed.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun customCoordinates(): Optional<String> = body.customCoordinates()

    /**
     * JSON key-value pairs to associate with the asset. Create the custom metadata fields before
     * setting these values.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun customMetadata(): Optional<CustomMetadata> = body.customMetadata()

    /**
     * Optional text to describe the contents of the file.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = body.description()

    /**
     * Array of extensions to be applied to the image. Each extension can be configured with
     * specific parameters based on the extension type.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun extensions(): Optional<List<Extension>> = body.extensions()

    /**
     * The folder path in which the image has to be uploaded. If the folder(s) didn't exist before,
     * a new folder(s) is created. Using multiple `/` creates a nested folder.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun folder(): Optional<String> = body.folder()

    /**
     * Whether to mark the file as private or not.
     *
     * If `true`, the file is marked as private and is accessible only using named transformation or
     * signed URL.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isPrivateFile(): Optional<Boolean> = body.isPrivateFile()

    /**
     * Whether to upload file as published or not.
     *
     * If `false`, the file is marked as unpublished, which restricts access to the file only via
     * the media library. Files in draft or unpublished state can only be publicly accessed after
     * being published.
     *
     * The option to upload in draft state is only available in custom enterprise pricing plans.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isPublished(): Optional<Boolean> = body.isPublished()

    /**
     * If set to `true` and a file already exists at the exact location, its AITags will be removed.
     * Set `overwriteAITags` to `false` to preserve AITags.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun overwriteAiTags(): Optional<Boolean> = body.overwriteAiTags()

    /**
     * If the request does not have `customMetadata`, and a file already exists at the exact
     * location, existing customMetadata will be removed.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun overwriteCustomMetadata(): Optional<Boolean> = body.overwriteCustomMetadata()

    /**
     * If `false` and `useUniqueFileName` is also `false`, and a file already exists at the exact
     * location, upload API will return an error immediately.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun overwriteFile(): Optional<Boolean> = body.overwriteFile()

    /**
     * If the request does not have `tags`, and a file already exists at the exact location,
     * existing tags will be removed.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun overwriteTags(): Optional<Boolean> = body.overwriteTags()

    /**
     * Array of response field keys to include in the API response body.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun responseFields(): Optional<List<ResponseField>> = body.responseFields()

    /**
     * Set the tags while uploading the file. Provide an array of tag strings (e.g. `["tag1",
     * "tag2", "tag3"]`). The combined length of all tag characters must not exceed 500, and the `%`
     * character is not allowed. If this field is not specified and the file is overwritten, the
     * existing tags will be removed.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tags(): Optional<List<String>> = body.tags()

    /**
     * Configure pre-processing (`pre`) and post-processing (`post`) transformations.
     * - `pre` — applied before the file is uploaded to the Media Library. Useful for reducing file
     *   size or applying basic optimizations upfront (e.g., resize, compress).
     * - `post` — applied immediately after upload. Ideal for generating transformed versions (like
     *   video encodes or thumbnails) in advance, so they're ready for delivery without delay.
     *
     * You can mix and match any combination of post-processing types.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun transformation(): Optional<Transformation> = body.transformation()

    /**
     * Whether to use a unique filename for this file or not.
     *
     * If `true`, ImageKit.io will add a unique suffix to the filename parameter to get a unique
     * filename.
     *
     * If `false`, then the image is uploaded with the provided filename parameter, and any existing
     * file with the same name is replaced.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun useUniqueFileName(): Optional<Boolean> = body.useUniqueFileName()

    /**
     * The final status of extensions after they have completed execution will be delivered to this
     * endpoint as a POST request.
     * [Learn more](/docs/api-reference/digital-asset-management-dam/managing-assets/update-file-details#webhook-payload-structure)
     * about the webhook payload structure.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun webhookUrl(): Optional<String> = body.webhookUrl()

    /**
     * Returns the raw multipart value of [file].
     *
     * Unlike [file], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _file(): MultipartField<InputStream> = body._file()

    /**
     * Returns the raw multipart value of [fileName].
     *
     * Unlike [fileName], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _fileName(): MultipartField<String> = body._fileName()

    /**
     * Returns the raw multipart value of [token].
     *
     * Unlike [token], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _token(): MultipartField<String> = body._token()

    /**
     * Returns the raw multipart value of [checks].
     *
     * Unlike [checks], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _checks(): MultipartField<String> = body._checks()

    /**
     * Returns the raw multipart value of [customCoordinates].
     *
     * Unlike [customCoordinates], this method doesn't throw if the multipart field has an
     * unexpected type.
     */
    fun _customCoordinates(): MultipartField<String> = body._customCoordinates()

    /**
     * Returns the raw multipart value of [customMetadata].
     *
     * Unlike [customMetadata], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _customMetadata(): MultipartField<CustomMetadata> = body._customMetadata()

    /**
     * Returns the raw multipart value of [description].
     *
     * Unlike [description], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _description(): MultipartField<String> = body._description()

    /**
     * Returns the raw multipart value of [extensions].
     *
     * Unlike [extensions], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _extensions(): MultipartField<List<Extension>> = body._extensions()

    /**
     * Returns the raw multipart value of [folder].
     *
     * Unlike [folder], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _folder(): MultipartField<String> = body._folder()

    /**
     * Returns the raw multipart value of [isPrivateFile].
     *
     * Unlike [isPrivateFile], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _isPrivateFile(): MultipartField<Boolean> = body._isPrivateFile()

    /**
     * Returns the raw multipart value of [isPublished].
     *
     * Unlike [isPublished], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _isPublished(): MultipartField<Boolean> = body._isPublished()

    /**
     * Returns the raw multipart value of [overwriteAiTags].
     *
     * Unlike [overwriteAiTags], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _overwriteAiTags(): MultipartField<Boolean> = body._overwriteAiTags()

    /**
     * Returns the raw multipart value of [overwriteCustomMetadata].
     *
     * Unlike [overwriteCustomMetadata], this method doesn't throw if the multipart field has an
     * unexpected type.
     */
    fun _overwriteCustomMetadata(): MultipartField<Boolean> = body._overwriteCustomMetadata()

    /**
     * Returns the raw multipart value of [overwriteFile].
     *
     * Unlike [overwriteFile], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _overwriteFile(): MultipartField<Boolean> = body._overwriteFile()

    /**
     * Returns the raw multipart value of [overwriteTags].
     *
     * Unlike [overwriteTags], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _overwriteTags(): MultipartField<Boolean> = body._overwriteTags()

    /**
     * Returns the raw multipart value of [responseFields].
     *
     * Unlike [responseFields], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _responseFields(): MultipartField<List<ResponseField>> = body._responseFields()

    /**
     * Returns the raw multipart value of [tags].
     *
     * Unlike [tags], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _tags(): MultipartField<List<String>> = body._tags()

    /**
     * Returns the raw multipart value of [transformation].
     *
     * Unlike [transformation], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _transformation(): MultipartField<Transformation> = body._transformation()

    /**
     * Returns the raw multipart value of [useUniqueFileName].
     *
     * Unlike [useUniqueFileName], this method doesn't throw if the multipart field has an
     * unexpected type.
     */
    fun _useUniqueFileName(): MultipartField<Boolean> = body._useUniqueFileName()

    /**
     * Returns the raw multipart value of [webhookUrl].
     *
     * Unlike [webhookUrl], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _webhookUrl(): MultipartField<String> = body._webhookUrl()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileUploadParams].
         *
         * The following fields are required:
         * ```java
         * .file()
         * .fileName()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileUploadParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(fileUploadParams: FileUploadParams) = apply {
            body = fileUploadParams.body.toBuilder()
            additionalHeaders = fileUploadParams.additionalHeaders.toBuilder()
            additionalQueryParams = fileUploadParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [file]
         * - [fileName]
         * - [token]
         * - [checks]
         * - [customCoordinates]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * The API accepts any of the following:
         * - **Binary data** – send the raw bytes as `multipart/form-data`.
         * - **HTTP / HTTPS URL** – a publicly reachable URL that ImageKit’s servers can fetch.
         * - **Base64 string** – the file encoded as a Base64 data URI or plain Base64.
         *
         * When supplying a URL, the server must receive the response headers within 8 seconds;
         * otherwise the request fails with 400 Bad Request.
         */
        fun file(file: InputStream) = apply { body.file(file) }

        /**
         * Sets [Builder.file] to an arbitrary multipart value.
         *
         * You should usually call [Builder.file] with a well-typed [InputStream] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun file(file: MultipartField<InputStream>) = apply { body.file(file) }

        /**
         * The API accepts any of the following:
         * - **Binary data** – send the raw bytes as `multipart/form-data`.
         * - **HTTP / HTTPS URL** – a publicly reachable URL that ImageKit’s servers can fetch.
         * - **Base64 string** – the file encoded as a Base64 data URI or plain Base64.
         *
         * When supplying a URL, the server must receive the response headers within 8 seconds;
         * otherwise the request fails with 400 Bad Request.
         */
        fun file(file: ByteArray) = apply { body.file(file) }

        /**
         * The API accepts any of the following:
         * - **Binary data** – send the raw bytes as `multipart/form-data`.
         * - **HTTP / HTTPS URL** – a publicly reachable URL that ImageKit’s servers can fetch.
         * - **Base64 string** – the file encoded as a Base64 data URI or plain Base64.
         *
         * When supplying a URL, the server must receive the response headers within 8 seconds;
         * otherwise the request fails with 400 Bad Request.
         */
        fun file(file: Path) = apply { body.file(file) }

        /** The name with which the file has to be uploaded. */
        fun fileName(fileName: String) = apply { body.fileName(fileName) }

        /**
         * Sets [Builder.fileName] to an arbitrary multipart value.
         *
         * You should usually call [Builder.fileName] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fileName(fileName: MultipartField<String>) = apply { body.fileName(fileName) }

        /**
         * This is the client-generated JSON Web Token (JWT). The ImageKit.io server uses it to
         * authenticate and check that the upload request parameters have not been tampered with
         * after the token has been generated. Learn how to create the token on the page below. This
         * field is only required for authentication when uploading a file from the client side.
         *
         * **Note**: Sending a JWT that has been used in the past will result in a validation error.
         * Even if your previous request resulted in an error, you should always send a new token.
         *
         * **⚠️Warning**: JWT must be generated on the server-side because it is generated using
         * your account's private API key. This field is required for authentication when uploading
         * a file from the client-side.
         */
        fun token(token: String) = apply { body.token(token) }

        /**
         * Sets [Builder.token] to an arbitrary multipart value.
         *
         * You should usually call [Builder.token] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun token(token: MultipartField<String>) = apply { body.token(token) }

        /**
         * Server-side checks to run on the asset. Read more about
         * [Upload API checks](/docs/api-reference/upload-file/upload-file-v2#upload-api-checks).
         */
        fun checks(checks: String) = apply { body.checks(checks) }

        /**
         * Sets [Builder.checks] to an arbitrary multipart value.
         *
         * You should usually call [Builder.checks] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun checks(checks: MultipartField<String>) = apply { body.checks(checks) }

        /**
         * Define an important area in the image. This is only relevant for image type files.
         * - To be passed as a string with the x and y coordinates of the top-left corner, and width
         *   and height of the area of interest in the format `x,y,width,height`. For example -
         *   `10,10,100,100`
         * - Can be used with fo-customtransformation.
         * - If this field is not specified and the file is overwritten, then customCoordinates will
         *   be removed.
         */
        fun customCoordinates(customCoordinates: String) = apply {
            body.customCoordinates(customCoordinates)
        }

        /**
         * Sets [Builder.customCoordinates] to an arbitrary multipart value.
         *
         * You should usually call [Builder.customCoordinates] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun customCoordinates(customCoordinates: MultipartField<String>) = apply {
            body.customCoordinates(customCoordinates)
        }

        /**
         * JSON key-value pairs to associate with the asset. Create the custom metadata fields
         * before setting these values.
         */
        fun customMetadata(customMetadata: CustomMetadata) = apply {
            body.customMetadata(customMetadata)
        }

        /**
         * Sets [Builder.customMetadata] to an arbitrary multipart value.
         *
         * You should usually call [Builder.customMetadata] with a well-typed [CustomMetadata] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun customMetadata(customMetadata: MultipartField<CustomMetadata>) = apply {
            body.customMetadata(customMetadata)
        }

        /** Optional text to describe the contents of the file. */
        fun description(description: String) = apply { body.description(description) }

        /**
         * Sets [Builder.description] to an arbitrary multipart value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: MultipartField<String>) = apply {
            body.description(description)
        }

        /**
         * Array of extensions to be applied to the image. Each extension can be configured with
         * specific parameters based on the extension type.
         */
        fun extensions(extensions: List<Extension>) = apply { body.extensions(extensions) }

        /**
         * Sets [Builder.extensions] to an arbitrary multipart value.
         *
         * You should usually call [Builder.extensions] with a well-typed `List<Extension>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun extensions(extensions: MultipartField<List<Extension>>) = apply {
            body.extensions(extensions)
        }

        /**
         * Adds a single [Extension] to [extensions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addExtension(extension: Extension) = apply { body.addExtension(extension) }

        /** Alias for calling [addExtension] with `Extension.ofRemovedotBg(removedotBg)`. */
        fun addExtension(removedotBg: Extension.RemovedotBgExtension) = apply {
            body.addExtension(removedotBg)
        }

        /** Alias for calling [addExtension] with `Extension.ofAutoTagging(autoTagging)`. */
        fun addExtension(autoTagging: Extension.AutoTaggingExtension) = apply {
            body.addExtension(autoTagging)
        }

        /** Alias for calling [addExtension] with `Extension.ofAutoDescription(autoDescription)`. */
        fun addExtension(autoDescription: Extension.AutoDescriptionExtension) = apply {
            body.addExtension(autoDescription)
        }

        /**
         * The folder path in which the image has to be uploaded. If the folder(s) didn't exist
         * before, a new folder(s) is created. Using multiple `/` creates a nested folder.
         */
        fun folder(folder: String) = apply { body.folder(folder) }

        /**
         * Sets [Builder.folder] to an arbitrary multipart value.
         *
         * You should usually call [Builder.folder] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun folder(folder: MultipartField<String>) = apply { body.folder(folder) }

        /**
         * Whether to mark the file as private or not.
         *
         * If `true`, the file is marked as private and is accessible only using named
         * transformation or signed URL.
         */
        fun isPrivateFile(isPrivateFile: Boolean) = apply { body.isPrivateFile(isPrivateFile) }

        /**
         * Sets [Builder.isPrivateFile] to an arbitrary multipart value.
         *
         * You should usually call [Builder.isPrivateFile] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun isPrivateFile(isPrivateFile: MultipartField<Boolean>) = apply {
            body.isPrivateFile(isPrivateFile)
        }

        /**
         * Whether to upload file as published or not.
         *
         * If `false`, the file is marked as unpublished, which restricts access to the file only
         * via the media library. Files in draft or unpublished state can only be publicly accessed
         * after being published.
         *
         * The option to upload in draft state is only available in custom enterprise pricing plans.
         */
        fun isPublished(isPublished: Boolean) = apply { body.isPublished(isPublished) }

        /**
         * Sets [Builder.isPublished] to an arbitrary multipart value.
         *
         * You should usually call [Builder.isPublished] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isPublished(isPublished: MultipartField<Boolean>) = apply {
            body.isPublished(isPublished)
        }

        /**
         * If set to `true` and a file already exists at the exact location, its AITags will be
         * removed. Set `overwriteAITags` to `false` to preserve AITags.
         */
        fun overwriteAiTags(overwriteAiTags: Boolean) = apply {
            body.overwriteAiTags(overwriteAiTags)
        }

        /**
         * Sets [Builder.overwriteAiTags] to an arbitrary multipart value.
         *
         * You should usually call [Builder.overwriteAiTags] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun overwriteAiTags(overwriteAiTags: MultipartField<Boolean>) = apply {
            body.overwriteAiTags(overwriteAiTags)
        }

        /**
         * If the request does not have `customMetadata`, and a file already exists at the exact
         * location, existing customMetadata will be removed.
         */
        fun overwriteCustomMetadata(overwriteCustomMetadata: Boolean) = apply {
            body.overwriteCustomMetadata(overwriteCustomMetadata)
        }

        /**
         * Sets [Builder.overwriteCustomMetadata] to an arbitrary multipart value.
         *
         * You should usually call [Builder.overwriteCustomMetadata] with a well-typed [Boolean]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun overwriteCustomMetadata(overwriteCustomMetadata: MultipartField<Boolean>) = apply {
            body.overwriteCustomMetadata(overwriteCustomMetadata)
        }

        /**
         * If `false` and `useUniqueFileName` is also `false`, and a file already exists at the
         * exact location, upload API will return an error immediately.
         */
        fun overwriteFile(overwriteFile: Boolean) = apply { body.overwriteFile(overwriteFile) }

        /**
         * Sets [Builder.overwriteFile] to an arbitrary multipart value.
         *
         * You should usually call [Builder.overwriteFile] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun overwriteFile(overwriteFile: MultipartField<Boolean>) = apply {
            body.overwriteFile(overwriteFile)
        }

        /**
         * If the request does not have `tags`, and a file already exists at the exact location,
         * existing tags will be removed.
         */
        fun overwriteTags(overwriteTags: Boolean) = apply { body.overwriteTags(overwriteTags) }

        /**
         * Sets [Builder.overwriteTags] to an arbitrary multipart value.
         *
         * You should usually call [Builder.overwriteTags] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun overwriteTags(overwriteTags: MultipartField<Boolean>) = apply {
            body.overwriteTags(overwriteTags)
        }

        /** Array of response field keys to include in the API response body. */
        fun responseFields(responseFields: List<ResponseField>) = apply {
            body.responseFields(responseFields)
        }

        /**
         * Sets [Builder.responseFields] to an arbitrary multipart value.
         *
         * You should usually call [Builder.responseFields] with a well-typed `List<ResponseField>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun responseFields(responseFields: MultipartField<List<ResponseField>>) = apply {
            body.responseFields(responseFields)
        }

        /**
         * Adds a single [ResponseField] to [responseFields].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addResponseField(responseField: ResponseField) = apply {
            body.addResponseField(responseField)
        }

        /**
         * Set the tags while uploading the file. Provide an array of tag strings (e.g. `["tag1",
         * "tag2", "tag3"]`). The combined length of all tag characters must not exceed 500, and the
         * `%` character is not allowed. If this field is not specified and the file is overwritten,
         * the existing tags will be removed.
         */
        fun tags(tags: List<String>) = apply { body.tags(tags) }

        /**
         * Sets [Builder.tags] to an arbitrary multipart value.
         *
         * You should usually call [Builder.tags] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tags(tags: MultipartField<List<String>>) = apply { body.tags(tags) }

        /**
         * Adds a single [String] to [tags].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTag(tag: String) = apply { body.addTag(tag) }

        /**
         * Configure pre-processing (`pre`) and post-processing (`post`) transformations.
         * - `pre` — applied before the file is uploaded to the Media Library. Useful for reducing
         *   file size or applying basic optimizations upfront (e.g., resize, compress).
         * - `post` — applied immediately after upload. Ideal for generating transformed versions
         *   (like video encodes or thumbnails) in advance, so they're ready for delivery without
         *   delay.
         *
         * You can mix and match any combination of post-processing types.
         */
        fun transformation(transformation: Transformation) = apply {
            body.transformation(transformation)
        }

        /**
         * Sets [Builder.transformation] to an arbitrary multipart value.
         *
         * You should usually call [Builder.transformation] with a well-typed [Transformation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun transformation(transformation: MultipartField<Transformation>) = apply {
            body.transformation(transformation)
        }

        /**
         * Whether to use a unique filename for this file or not.
         *
         * If `true`, ImageKit.io will add a unique suffix to the filename parameter to get a unique
         * filename.
         *
         * If `false`, then the image is uploaded with the provided filename parameter, and any
         * existing file with the same name is replaced.
         */
        fun useUniqueFileName(useUniqueFileName: Boolean) = apply {
            body.useUniqueFileName(useUniqueFileName)
        }

        /**
         * Sets [Builder.useUniqueFileName] to an arbitrary multipart value.
         *
         * You should usually call [Builder.useUniqueFileName] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun useUniqueFileName(useUniqueFileName: MultipartField<Boolean>) = apply {
            body.useUniqueFileName(useUniqueFileName)
        }

        /**
         * The final status of extensions after they have completed execution will be delivered to
         * this endpoint as a POST request.
         * [Learn more](/docs/api-reference/digital-asset-management-dam/managing-assets/update-file-details#webhook-payload-structure)
         * about the webhook payload structure.
         */
        fun webhookUrl(webhookUrl: String) = apply { body.webhookUrl(webhookUrl) }

        /**
         * Sets [Builder.webhookUrl] to an arbitrary multipart value.
         *
         * You should usually call [Builder.webhookUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun webhookUrl(webhookUrl: MultipartField<String>) = apply { body.webhookUrl(webhookUrl) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

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
         *
         * The following fields are required:
         * ```java
         * .file()
         * .fileName()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FileUploadParams =
            FileUploadParams(body.build(), additionalHeaders.build(), additionalQueryParams.build())
    }

    fun _body(): Map<String, MultipartField<*>> =
        (mapOf(
                "file" to _file(),
                "fileName" to _fileName(),
                "token" to _token(),
                "checks" to _checks(),
                "customCoordinates" to _customCoordinates(),
                "customMetadata" to _customMetadata(),
                "description" to _description(),
                "extensions" to _extensions(),
                "folder" to _folder(),
                "isPrivateFile" to _isPrivateFile(),
                "isPublished" to _isPublished(),
                "overwriteAITags" to _overwriteAiTags(),
                "overwriteCustomMetadata" to _overwriteCustomMetadata(),
                "overwriteFile" to _overwriteFile(),
                "overwriteTags" to _overwriteTags(),
                "responseFields" to _responseFields(),
                "tags" to _tags(),
                "transformation" to _transformation(),
                "useUniqueFileName" to _useUniqueFileName(),
                "webhookUrl" to _webhookUrl(),
            ) + _additionalBodyProperties().mapValues { (_, value) -> MultipartField.of(value) })
            .toImmutable()

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val file: MultipartField<InputStream>,
        private val fileName: MultipartField<String>,
        private val token: MultipartField<String>,
        private val checks: MultipartField<String>,
        private val customCoordinates: MultipartField<String>,
        private val customMetadata: MultipartField<CustomMetadata>,
        private val description: MultipartField<String>,
        private val extensions: MultipartField<List<Extension>>,
        private val folder: MultipartField<String>,
        private val isPrivateFile: MultipartField<Boolean>,
        private val isPublished: MultipartField<Boolean>,
        private val overwriteAiTags: MultipartField<Boolean>,
        private val overwriteCustomMetadata: MultipartField<Boolean>,
        private val overwriteFile: MultipartField<Boolean>,
        private val overwriteTags: MultipartField<Boolean>,
        private val responseFields: MultipartField<List<ResponseField>>,
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
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun file(): InputStream = file.value.getRequired("file")

        /**
         * The name with which the file has to be uploaded.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun fileName(): String = fileName.value.getRequired("fileName")

        /**
         * This is the client-generated JSON Web Token (JWT). The ImageKit.io server uses it to
         * authenticate and check that the upload request parameters have not been tampered with
         * after the token has been generated. Learn how to create the token on the page below. This
         * field is only required for authentication when uploading a file from the client side.
         *
         * **Note**: Sending a JWT that has been used in the past will result in a validation error.
         * Even if your previous request resulted in an error, you should always send a new token.
         *
         * **⚠️Warning**: JWT must be generated on the server-side because it is generated using
         * your account's private API key. This field is required for authentication when uploading
         * a file from the client-side.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun token(): Optional<String> = token.value.getOptional("token")

        /**
         * Server-side checks to run on the asset. Read more about
         * [Upload API checks](/docs/api-reference/upload-file/upload-file-v2#upload-api-checks).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun checks(): Optional<String> = checks.value.getOptional("checks")

        /**
         * Define an important area in the image. This is only relevant for image type files.
         * - To be passed as a string with the x and y coordinates of the top-left corner, and width
         *   and height of the area of interest in the format `x,y,width,height`. For example -
         *   `10,10,100,100`
         * - Can be used with fo-customtransformation.
         * - If this field is not specified and the file is overwritten, then customCoordinates will
         *   be removed.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun customCoordinates(): Optional<String> =
            customCoordinates.value.getOptional("customCoordinates")

        /**
         * JSON key-value pairs to associate with the asset. Create the custom metadata fields
         * before setting these values.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun customMetadata(): Optional<CustomMetadata> =
            customMetadata.value.getOptional("customMetadata")

        /**
         * Optional text to describe the contents of the file.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.value.getOptional("description")

        /**
         * Array of extensions to be applied to the image. Each extension can be configured with
         * specific parameters based on the extension type.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun extensions(): Optional<List<Extension>> = extensions.value.getOptional("extensions")

        /**
         * The folder path in which the image has to be uploaded. If the folder(s) didn't exist
         * before, a new folder(s) is created. Using multiple `/` creates a nested folder.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun folder(): Optional<String> = folder.value.getOptional("folder")

        /**
         * Whether to mark the file as private or not.
         *
         * If `true`, the file is marked as private and is accessible only using named
         * transformation or signed URL.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun isPrivateFile(): Optional<Boolean> = isPrivateFile.value.getOptional("isPrivateFile")

        /**
         * Whether to upload file as published or not.
         *
         * If `false`, the file is marked as unpublished, which restricts access to the file only
         * via the media library. Files in draft or unpublished state can only be publicly accessed
         * after being published.
         *
         * The option to upload in draft state is only available in custom enterprise pricing plans.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun isPublished(): Optional<Boolean> = isPublished.value.getOptional("isPublished")

        /**
         * If set to `true` and a file already exists at the exact location, its AITags will be
         * removed. Set `overwriteAITags` to `false` to preserve AITags.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun overwriteAiTags(): Optional<Boolean> =
            overwriteAiTags.value.getOptional("overwriteAITags")

        /**
         * If the request does not have `customMetadata`, and a file already exists at the exact
         * location, existing customMetadata will be removed.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun overwriteCustomMetadata(): Optional<Boolean> =
            overwriteCustomMetadata.value.getOptional("overwriteCustomMetadata")

        /**
         * If `false` and `useUniqueFileName` is also `false`, and a file already exists at the
         * exact location, upload API will return an error immediately.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun overwriteFile(): Optional<Boolean> = overwriteFile.value.getOptional("overwriteFile")

        /**
         * If the request does not have `tags`, and a file already exists at the exact location,
         * existing tags will be removed.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun overwriteTags(): Optional<Boolean> = overwriteTags.value.getOptional("overwriteTags")

        /**
         * Array of response field keys to include in the API response body.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun responseFields(): Optional<List<ResponseField>> =
            responseFields.value.getOptional("responseFields")

        /**
         * Set the tags while uploading the file. Provide an array of tag strings (e.g. `["tag1",
         * "tag2", "tag3"]`). The combined length of all tag characters must not exceed 500, and the
         * `%` character is not allowed. If this field is not specified and the file is overwritten,
         * the existing tags will be removed.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun tags(): Optional<List<String>> = tags.value.getOptional("tags")

        /**
         * Configure pre-processing (`pre`) and post-processing (`post`) transformations.
         * - `pre` — applied before the file is uploaded to the Media Library. Useful for reducing
         *   file size or applying basic optimizations upfront (e.g., resize, compress).
         * - `post` — applied immediately after upload. Ideal for generating transformed versions
         *   (like video encodes or thumbnails) in advance, so they're ready for delivery without
         *   delay.
         *
         * You can mix and match any combination of post-processing types.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun transformation(): Optional<Transformation> =
            transformation.value.getOptional("transformation")

        /**
         * Whether to use a unique filename for this file or not.
         *
         * If `true`, ImageKit.io will add a unique suffix to the filename parameter to get a unique
         * filename.
         *
         * If `false`, then the image is uploaded with the provided filename parameter, and any
         * existing file with the same name is replaced.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun useUniqueFileName(): Optional<Boolean> =
            useUniqueFileName.value.getOptional("useUniqueFileName")

        /**
         * The final status of extensions after they have completed execution will be delivered to
         * this endpoint as a POST request.
         * [Learn more](/docs/api-reference/digital-asset-management-dam/managing-assets/update-file-details#webhook-payload-structure)
         * about the webhook payload structure.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun webhookUrl(): Optional<String> = webhookUrl.value.getOptional("webhookUrl")

        /**
         * Returns the raw multipart value of [file].
         *
         * Unlike [file], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("file") @ExcludeMissing fun _file(): MultipartField<InputStream> = file

        /**
         * Returns the raw multipart value of [fileName].
         *
         * Unlike [fileName], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("fileName") @ExcludeMissing fun _fileName(): MultipartField<String> = fileName

        /**
         * Returns the raw multipart value of [token].
         *
         * Unlike [token], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("token") @ExcludeMissing fun _token(): MultipartField<String> = token

        /**
         * Returns the raw multipart value of [checks].
         *
         * Unlike [checks], this method doesn't throw if the multipart field has an unexpected type.
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
         * Unlike [description], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): MultipartField<String> = description

        /**
         * Returns the raw multipart value of [extensions].
         *
         * Unlike [extensions], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("extensions")
        @ExcludeMissing
        fun _extensions(): MultipartField<List<Extension>> = extensions

        /**
         * Returns the raw multipart value of [folder].
         *
         * Unlike [folder], this method doesn't throw if the multipart field has an unexpected type.
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
         * Unlike [isPublished], this method doesn't throw if the multipart field has an unexpected
         * type.
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
         * Unlike [overwriteCustomMetadata], this method doesn't throw if the multipart field has an
         * unexpected type.
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
         * Returns the raw multipart value of [responseFields].
         *
         * Unlike [responseFields], this method doesn't throw if the multipart field has an
         * unexpected type.
         */
        @JsonProperty("responseFields")
        @ExcludeMissing
        fun _responseFields(): MultipartField<List<ResponseField>> = responseFields

        /**
         * Returns the raw multipart value of [tags].
         *
         * Unlike [tags], this method doesn't throw if the multipart field has an unexpected type.
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
         * Unlike [webhookUrl], this method doesn't throw if the multipart field has an unexpected
         * type.
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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .file()
             * .fileName()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var file: MultipartField<InputStream>? = null
            private var fileName: MultipartField<String>? = null
            private var token: MultipartField<String> = MultipartField.of(null)
            private var checks: MultipartField<String> = MultipartField.of(null)
            private var customCoordinates: MultipartField<String> = MultipartField.of(null)
            private var customMetadata: MultipartField<CustomMetadata> = MultipartField.of(null)
            private var description: MultipartField<String> = MultipartField.of(null)
            private var extensions: MultipartField<MutableList<Extension>>? = null
            private var folder: MultipartField<String> = MultipartField.of(null)
            private var isPrivateFile: MultipartField<Boolean> = MultipartField.of(null)
            private var isPublished: MultipartField<Boolean> = MultipartField.of(null)
            private var overwriteAiTags: MultipartField<Boolean> = MultipartField.of(null)
            private var overwriteCustomMetadata: MultipartField<Boolean> = MultipartField.of(null)
            private var overwriteFile: MultipartField<Boolean> = MultipartField.of(null)
            private var overwriteTags: MultipartField<Boolean> = MultipartField.of(null)
            private var responseFields: MultipartField<MutableList<ResponseField>>? = null
            private var tags: MultipartField<MutableList<String>>? = null
            private var transformation: MultipartField<Transformation> = MultipartField.of(null)
            private var useUniqueFileName: MultipartField<Boolean> = MultipartField.of(null)
            private var webhookUrl: MultipartField<String> = MultipartField.of(null)
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                file = body.file
                fileName = body.fileName
                token = body.token
                checks = body.checks
                customCoordinates = body.customCoordinates
                customMetadata = body.customMetadata
                description = body.description
                extensions = body.extensions.map { it.toMutableList() }
                folder = body.folder
                isPrivateFile = body.isPrivateFile
                isPublished = body.isPublished
                overwriteAiTags = body.overwriteAiTags
                overwriteCustomMetadata = body.overwriteCustomMetadata
                overwriteFile = body.overwriteFile
                overwriteTags = body.overwriteTags
                responseFields = body.responseFields.map { it.toMutableList() }
                tags = body.tags.map { it.toMutableList() }
                transformation = body.transformation
                useUniqueFileName = body.useUniqueFileName
                webhookUrl = body.webhookUrl
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * The API accepts any of the following:
             * - **Binary data** – send the raw bytes as `multipart/form-data`.
             * - **HTTP / HTTPS URL** – a publicly reachable URL that ImageKit’s servers can fetch.
             * - **Base64 string** – the file encoded as a Base64 data URI or plain Base64.
             *
             * When supplying a URL, the server must receive the response headers within 8 seconds;
             * otherwise the request fails with 400 Bad Request.
             */
            fun file(file: InputStream) = file(MultipartField.of(file))

            /**
             * Sets [Builder.file] to an arbitrary multipart value.
             *
             * You should usually call [Builder.file] with a well-typed [InputStream] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun file(file: MultipartField<InputStream>) = apply { this.file = file }

            /**
             * The API accepts any of the following:
             * - **Binary data** – send the raw bytes as `multipart/form-data`.
             * - **HTTP / HTTPS URL** – a publicly reachable URL that ImageKit’s servers can fetch.
             * - **Base64 string** – the file encoded as a Base64 data URI or plain Base64.
             *
             * When supplying a URL, the server must receive the response headers within 8 seconds;
             * otherwise the request fails with 400 Bad Request.
             */
            fun file(file: ByteArray) = file(file.inputStream())

            /**
             * The API accepts any of the following:
             * - **Binary data** – send the raw bytes as `multipart/form-data`.
             * - **HTTP / HTTPS URL** – a publicly reachable URL that ImageKit’s servers can fetch.
             * - **Base64 string** – the file encoded as a Base64 data URI or plain Base64.
             *
             * When supplying a URL, the server must receive the response headers within 8 seconds;
             * otherwise the request fails with 400 Bad Request.
             */
            fun file(file: Path) =
                file(
                    MultipartField.builder<InputStream>()
                        .value(file.inputStream())
                        .filename(file.name)
                        .build()
                )

            /** The name with which the file has to be uploaded. */
            fun fileName(fileName: String) = fileName(MultipartField.of(fileName))

            /**
             * Sets [Builder.fileName] to an arbitrary multipart value.
             *
             * You should usually call [Builder.fileName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fileName(fileName: MultipartField<String>) = apply { this.fileName = fileName }

            /**
             * This is the client-generated JSON Web Token (JWT). The ImageKit.io server uses it to
             * authenticate and check that the upload request parameters have not been tampered with
             * after the token has been generated. Learn how to create the token on the page below.
             * This field is only required for authentication when uploading a file from the client
             * side.
             *
             * **Note**: Sending a JWT that has been used in the past will result in a validation
             * error. Even if your previous request resulted in an error, you should always send a
             * new token.
             *
             * **⚠️Warning**: JWT must be generated on the server-side because it is generated using
             * your account's private API key. This field is required for authentication when
             * uploading a file from the client-side.
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
             * [Upload API checks](/docs/api-reference/upload-file/upload-file-v2#upload-api-checks).
             */
            fun checks(checks: String) = checks(MultipartField.of(checks))

            /**
             * Sets [Builder.checks] to an arbitrary multipart value.
             *
             * You should usually call [Builder.checks] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun checks(checks: MultipartField<String>) = apply { this.checks = checks }

            /**
             * Define an important area in the image. This is only relevant for image type files.
             * - To be passed as a string with the x and y coordinates of the top-left corner, and
             *   width and height of the area of interest in the format `x,y,width,height`. For
             *   example - `10,10,100,100`
             * - Can be used with fo-customtransformation.
             * - If this field is not specified and the file is overwritten, then customCoordinates
             *   will be removed.
             */
            fun customCoordinates(customCoordinates: String) =
                customCoordinates(MultipartField.of(customCoordinates))

            /**
             * Sets [Builder.customCoordinates] to an arbitrary multipart value.
             *
             * You should usually call [Builder.customCoordinates] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun customCoordinates(customCoordinates: MultipartField<String>) = apply {
                this.customCoordinates = customCoordinates
            }

            /**
             * JSON key-value pairs to associate with the asset. Create the custom metadata fields
             * before setting these values.
             */
            fun customMetadata(customMetadata: CustomMetadata) =
                customMetadata(MultipartField.of(customMetadata))

            /**
             * Sets [Builder.customMetadata] to an arbitrary multipart value.
             *
             * You should usually call [Builder.customMetadata] with a well-typed [CustomMetadata]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: MultipartField<String>) = apply {
                this.description = description
            }

            /**
             * Array of extensions to be applied to the image. Each extension can be configured with
             * specific parameters based on the extension type.
             */
            fun extensions(extensions: List<Extension>) = extensions(MultipartField.of(extensions))

            /**
             * Sets [Builder.extensions] to an arbitrary multipart value.
             *
             * You should usually call [Builder.extensions] with a well-typed `List<Extension>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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

            /** Alias for calling [addExtension] with `Extension.ofRemovedotBg(removedotBg)`. */
            fun addExtension(removedotBg: Extension.RemovedotBgExtension) =
                addExtension(Extension.ofRemovedotBg(removedotBg))

            /** Alias for calling [addExtension] with `Extension.ofAutoTagging(autoTagging)`. */
            fun addExtension(autoTagging: Extension.AutoTaggingExtension) =
                addExtension(Extension.ofAutoTagging(autoTagging))

            /**
             * Alias for calling [addExtension] with `Extension.ofAutoDescription(autoDescription)`.
             */
            fun addExtension(autoDescription: Extension.AutoDescriptionExtension) =
                addExtension(Extension.ofAutoDescription(autoDescription))

            /**
             * The folder path in which the image has to be uploaded. If the folder(s) didn't exist
             * before, a new folder(s) is created. Using multiple `/` creates a nested folder.
             */
            fun folder(folder: String) = folder(MultipartField.of(folder))

            /**
             * Sets [Builder.folder] to an arbitrary multipart value.
             *
             * You should usually call [Builder.folder] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isPrivateFile(isPrivateFile: MultipartField<Boolean>) = apply {
                this.isPrivateFile = isPrivateFile
            }

            /**
             * Whether to upload file as published or not.
             *
             * If `false`, the file is marked as unpublished, which restricts access to the file
             * only via the media library. Files in draft or unpublished state can only be publicly
             * accessed after being published.
             *
             * The option to upload in draft state is only available in custom enterprise pricing
             * plans.
             */
            fun isPublished(isPublished: Boolean) = isPublished(MultipartField.of(isPublished))

            /**
             * Sets [Builder.isPublished] to an arbitrary multipart value.
             *
             * You should usually call [Builder.isPublished] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isPublished(isPublished: MultipartField<Boolean>) = apply {
                this.isPublished = isPublished
            }

            /**
             * If set to `true` and a file already exists at the exact location, its AITags will be
             * removed. Set `overwriteAITags` to `false` to preserve AITags.
             */
            fun overwriteAiTags(overwriteAiTags: Boolean) =
                overwriteAiTags(MultipartField.of(overwriteAiTags))

            /**
             * Sets [Builder.overwriteAiTags] to an arbitrary multipart value.
             *
             * You should usually call [Builder.overwriteAiTags] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun overwriteAiTags(overwriteAiTags: MultipartField<Boolean>) = apply {
                this.overwriteAiTags = overwriteAiTags
            }

            /**
             * If the request does not have `customMetadata`, and a file already exists at the exact
             * location, existing customMetadata will be removed.
             */
            fun overwriteCustomMetadata(overwriteCustomMetadata: Boolean) =
                overwriteCustomMetadata(MultipartField.of(overwriteCustomMetadata))

            /**
             * Sets [Builder.overwriteCustomMetadata] to an arbitrary multipart value.
             *
             * You should usually call [Builder.overwriteCustomMetadata] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun overwriteCustomMetadata(overwriteCustomMetadata: MultipartField<Boolean>) = apply {
                this.overwriteCustomMetadata = overwriteCustomMetadata
            }

            /**
             * If `false` and `useUniqueFileName` is also `false`, and a file already exists at the
             * exact location, upload API will return an error immediately.
             */
            fun overwriteFile(overwriteFile: Boolean) =
                overwriteFile(MultipartField.of(overwriteFile))

            /**
             * Sets [Builder.overwriteFile] to an arbitrary multipart value.
             *
             * You should usually call [Builder.overwriteFile] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun overwriteFile(overwriteFile: MultipartField<Boolean>) = apply {
                this.overwriteFile = overwriteFile
            }

            /**
             * If the request does not have `tags`, and a file already exists at the exact location,
             * existing tags will be removed.
             */
            fun overwriteTags(overwriteTags: Boolean) =
                overwriteTags(MultipartField.of(overwriteTags))

            /**
             * Sets [Builder.overwriteTags] to an arbitrary multipart value.
             *
             * You should usually call [Builder.overwriteTags] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun overwriteTags(overwriteTags: MultipartField<Boolean>) = apply {
                this.overwriteTags = overwriteTags
            }

            /** Array of response field keys to include in the API response body. */
            fun responseFields(responseFields: List<ResponseField>) =
                responseFields(MultipartField.of(responseFields))

            /**
             * Sets [Builder.responseFields] to an arbitrary multipart value.
             *
             * You should usually call [Builder.responseFields] with a well-typed
             * `List<ResponseField>` value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
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
             * Set the tags while uploading the file. Provide an array of tag strings (e.g.
             * `["tag1", "tag2", "tag3"]`). The combined length of all tag characters must not
             * exceed 500, and the `%` character is not allowed. If this field is not specified and
             * the file is overwritten, the existing tags will be removed.
             */
            fun tags(tags: List<String>) = tags(MultipartField.of(tags))

            /**
             * Sets [Builder.tags] to an arbitrary multipart value.
             *
             * You should usually call [Builder.tags] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * You should usually call [Builder.transformation] with a well-typed [Transformation]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun transformation(transformation: MultipartField<Transformation>) = apply {
                this.transformation = transformation
            }

            /**
             * Whether to use a unique filename for this file or not.
             *
             * If `true`, ImageKit.io will add a unique suffix to the filename parameter to get a
             * unique filename.
             *
             * If `false`, then the image is uploaded with the provided filename parameter, and any
             * existing file with the same name is replaced.
             */
            fun useUniqueFileName(useUniqueFileName: Boolean) =
                useUniqueFileName(MultipartField.of(useUniqueFileName))

            /**
             * Sets [Builder.useUniqueFileName] to an arbitrary multipart value.
             *
             * You should usually call [Builder.useUniqueFileName] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun useUniqueFileName(useUniqueFileName: MultipartField<Boolean>) = apply {
                this.useUniqueFileName = useUniqueFileName
            }

            /**
             * The final status of extensions after they have completed execution will be delivered
             * to this endpoint as a POST request.
             * [Learn more](/docs/api-reference/digital-asset-management-dam/managing-assets/update-file-details#webhook-payload-structure)
             * about the webhook payload structure.
             */
            fun webhookUrl(webhookUrl: String) = webhookUrl(MultipartField.of(webhookUrl))

            /**
             * Sets [Builder.webhookUrl] to an arbitrary multipart value.
             *
             * You should usually call [Builder.webhookUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Body].
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
            fun build(): Body =
                Body(
                    checkRequired("file", file),
                    checkRequired("fileName", fileName),
                    token,
                    checks,
                    customCoordinates,
                    customMetadata,
                    description,
                    (extensions ?: MultipartField.of(null)).map { it.toImmutable() },
                    folder,
                    isPrivateFile,
                    isPublished,
                    overwriteAiTags,
                    overwriteCustomMetadata,
                    overwriteFile,
                    overwriteTags,
                    (responseFields ?: MultipartField.of(null)).map { it.toImmutable() },
                    (tags ?: MultipartField.of(null)).map { it.toImmutable() },
                    transformation,
                    useUniqueFileName,
                    webhookUrl,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
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
            extensions().ifPresent { it.forEach { it.validate() } }
            folder()
            isPrivateFile()
            isPublished()
            overwriteAiTags()
            overwriteCustomMetadata()
            overwriteFile()
            overwriteTags()
            responseFields().ifPresent { it.forEach { it.validate() } }
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                file == other.file &&
                fileName == other.fileName &&
                token == other.token &&
                checks == other.checks &&
                customCoordinates == other.customCoordinates &&
                customMetadata == other.customMetadata &&
                description == other.description &&
                extensions == other.extensions &&
                folder == other.folder &&
                isPrivateFile == other.isPrivateFile &&
                isPublished == other.isPublished &&
                overwriteAiTags == other.overwriteAiTags &&
                overwriteCustomMetadata == other.overwriteCustomMetadata &&
                overwriteFile == other.overwriteFile &&
                overwriteTags == other.overwriteTags &&
                responseFields == other.responseFields &&
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
                extensions,
                folder,
                isPrivateFile,
                isPublished,
                overwriteAiTags,
                overwriteCustomMetadata,
                overwriteFile,
                overwriteTags,
                responseFields,
                tags,
                transformation,
                useUniqueFileName,
                webhookUrl,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{file=$file, fileName=$fileName, token=$token, checks=$checks, customCoordinates=$customCoordinates, customMetadata=$customMetadata, description=$description, extensions=$extensions, folder=$folder, isPrivateFile=$isPrivateFile, isPublished=$isPublished, overwriteAiTags=$overwriteAiTags, overwriteCustomMetadata=$overwriteCustomMetadata, overwriteFile=$overwriteFile, overwriteTags=$overwriteTags, responseFields=$responseFields, tags=$tags, transformation=$transformation, useUniqueFileName=$useUniqueFileName, webhookUrl=$webhookUrl, additionalProperties=$additionalProperties}"
    }

    /**
     * JSON key-value pairs to associate with the asset. Create the custom metadata fields before
     * setting these values.
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

            /** Returns a mutable builder for constructing an instance of [CustomMetadata]. */
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

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

            return other is CustomMetadata && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "CustomMetadata{additionalProperties=$additionalProperties}"
    }

    @JsonDeserialize(using = Extension.Deserializer::class)
    @JsonSerialize(using = Extension.Serializer::class)
    class Extension
    private constructor(
        private val removedotBg: RemovedotBgExtension? = null,
        private val autoTagging: AutoTaggingExtension? = null,
        private val autoDescription: AutoDescriptionExtension? = null,
        private val _json: JsonValue? = null,
    ) {

        fun removedotBg(): Optional<RemovedotBgExtension> = Optional.ofNullable(removedotBg)

        fun autoTagging(): Optional<AutoTaggingExtension> = Optional.ofNullable(autoTagging)

        fun autoDescription(): Optional<AutoDescriptionExtension> =
            Optional.ofNullable(autoDescription)

        fun isRemovedotBg(): Boolean = removedotBg != null

        fun isAutoTagging(): Boolean = autoTagging != null

        fun isAutoDescription(): Boolean = autoDescription != null

        fun asRemovedotBg(): RemovedotBgExtension = removedotBg.getOrThrow("removedotBg")

        fun asAutoTagging(): AutoTaggingExtension = autoTagging.getOrThrow("autoTagging")

        fun asAutoDescription(): AutoDescriptionExtension =
            autoDescription.getOrThrow("autoDescription")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                removedotBg != null -> visitor.visitRemovedotBg(removedotBg)
                autoTagging != null -> visitor.visitAutoTagging(autoTagging)
                autoDescription != null -> visitor.visitAutoDescription(autoDescription)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Extension = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitRemovedotBg(removedotBg: RemovedotBgExtension) {
                        removedotBg.validate()
                    }

                    override fun visitAutoTagging(autoTagging: AutoTaggingExtension) {
                        autoTagging.validate()
                    }

                    override fun visitAutoDescription(autoDescription: AutoDescriptionExtension) {
                        autoDescription.validate()
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
                    override fun visitRemovedotBg(removedotBg: RemovedotBgExtension) =
                        removedotBg.validity()

                    override fun visitAutoTagging(autoTagging: AutoTaggingExtension) =
                        autoTagging.validity()

                    override fun visitAutoDescription(autoDescription: AutoDescriptionExtension) =
                        autoDescription.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Extension &&
                removedotBg == other.removedotBg &&
                autoTagging == other.autoTagging &&
                autoDescription == other.autoDescription
        }

        override fun hashCode(): Int = Objects.hash(removedotBg, autoTagging, autoDescription)

        override fun toString(): String =
            when {
                removedotBg != null -> "Extension{removedotBg=$removedotBg}"
                autoTagging != null -> "Extension{autoTagging=$autoTagging}"
                autoDescription != null -> "Extension{autoDescription=$autoDescription}"
                _json != null -> "Extension{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Extension")
            }

        companion object {

            @JvmStatic
            fun ofRemovedotBg(removedotBg: RemovedotBgExtension) =
                Extension(removedotBg = removedotBg)

            @JvmStatic
            fun ofAutoTagging(autoTagging: AutoTaggingExtension) =
                Extension(autoTagging = autoTagging)

            @JvmStatic
            fun ofAutoDescription(autoDescription: AutoDescriptionExtension) =
                Extension(autoDescription = autoDescription)
        }

        /**
         * An interface that defines how to map each variant of [Extension] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitRemovedotBg(removedotBg: RemovedotBgExtension): T

            fun visitAutoTagging(autoTagging: AutoTaggingExtension): T

            fun visitAutoDescription(autoDescription: AutoDescriptionExtension): T

            /**
             * Maps an unknown variant of [Extension] to a value of type [T].
             *
             * An instance of [Extension] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
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

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<RemovedotBgExtension>())?.let {
                                Extension(removedotBg = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<AutoTaggingExtension>())?.let {
                                Extension(autoTagging = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<AutoDescriptionExtension>())?.let {
                                Extension(autoDescription = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Extension(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Extension>(Extension::class) {

            override fun serialize(
                value: Extension,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.removedotBg != null -> generator.writeObject(value.removedotBg)
                    value.autoTagging != null -> generator.writeObject(value.autoTagging)
                    value.autoDescription != null -> generator.writeObject(value.autoDescription)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Extension")
                }
            }
        }

        class RemovedotBgExtension
        private constructor(
            private val name: MultipartField<Name>,
            private val options: MultipartField<Options>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            /**
             * Specifies the background removal extension.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): Name = name.value.getRequired("name")

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun options(): Optional<Options> = options.value.getOptional("options")

            /**
             * Returns the raw multipart value of [name].
             *
             * Unlike [name], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): MultipartField<Name> = name

            /**
             * Returns the raw multipart value of [options].
             *
             * Unlike [options], this method doesn't throw if the multipart field has an unexpected
             * type.
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

                /**
                 * Returns a mutable builder for constructing an instance of [RemovedotBgExtension].
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [RemovedotBgExtension]. */
            class Builder internal constructor() {

                private var name: MultipartField<Name>? = null
                private var options: MultipartField<Options> = MultipartField.of(null)
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(removedotBgExtension: RemovedotBgExtension) = apply {
                    name = removedotBgExtension.name
                    options = removedotBgExtension.options
                    additionalProperties = removedotBgExtension.additionalProperties.toMutableMap()
                }

                /** Specifies the background removal extension. */
                fun name(name: Name) = name(MultipartField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.name] with a well-typed [Name] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: MultipartField<Name>) = apply { this.name = name }

                fun options(options: Options) = options(MultipartField.of(options))

                /**
                 * Sets [Builder.options] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.options] with a well-typed [Options] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun options(options: MultipartField<Options>) = apply { this.options = options }

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
                 * Returns an immutable instance of [RemovedotBgExtension].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): RemovedotBgExtension =
                    RemovedotBgExtension(
                        checkRequired("name", name),
                        options,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): RemovedotBgExtension = apply {
                if (validated) {
                    return@apply
                }

                name().validate()
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

            /** Specifies the background removal extension. */
            class Name @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

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

                    @JvmField val REMOVE_BG = of("remove-bg")

                    @JvmStatic fun of(value: String) = Name(JsonField.of(value))
                }

                /** An enum containing [Name]'s known values. */
                enum class Known {
                    REMOVE_BG
                }

                /**
                 * An enum containing [Name]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Name] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    REMOVE_BG,
                    /**
                     * An enum member indicating that [Name] was instantiated with an unknown value.
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
                        REMOVE_BG -> Value.REMOVE_BG
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
                        REMOVE_BG -> Known.REMOVE_BG
                        else -> throw ImageKitInvalidDataException("Unknown Name: $value")
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

                    return other is Name && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
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
                 * Whether to add an artificial shadow to the result. Default is false. Note: Adding
                 * shadows is currently only supported for car photos.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun addShadow(): Optional<Boolean> = addShadow.value.getOptional("add_shadow")

                /**
                 * Specifies a solid color background using hex code (e.g., "81d4fa", "fff") or
                 * color name (e.g., "green"). If this parameter is set, `bg_image_url` must be
                 * empty.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun bgColor(): Optional<String> = bgColor.value.getOptional("bg_color")

                /**
                 * Sets a background image from a URL. If this parameter is set, `bg_color` must be
                 * empty.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun bgImageUrl(): Optional<String> = bgImageUrl.value.getOptional("bg_image_url")

                /**
                 * Allows semi-transparent regions in the result. Default is true. Note:
                 * Semitransparency is currently only supported for car windows.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun semitransparency(): Optional<Boolean> =
                    semitransparency.value.getOptional("semitransparency")

                /**
                 * Returns the raw multipart value of [addShadow].
                 *
                 * Unlike [addShadow], this method doesn't throw if the multipart field has an
                 * unexpected type.
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
                 * Unlike [bgImageUrl], this method doesn't throw if the multipart field has an
                 * unexpected type.
                 */
                @JsonProperty("bg_image_url")
                @ExcludeMissing
                fun _bgImageUrl(): MultipartField<String> = bgImageUrl

                /**
                 * Returns the raw multipart value of [semitransparency].
                 *
                 * Unlike [semitransparency], this method doesn't throw if the multipart field has
                 * an unexpected type.
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

                    /** Returns a mutable builder for constructing an instance of [Options]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Options]. */
                class Builder internal constructor() {

                    private var addShadow: MultipartField<Boolean> = MultipartField.of(null)
                    private var bgColor: MultipartField<String> = MultipartField.of(null)
                    private var bgImageUrl: MultipartField<String> = MultipartField.of(null)
                    private var semitransparency: MultipartField<Boolean> = MultipartField.of(null)
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(options: Options) = apply {
                        addShadow = options.addShadow
                        bgColor = options.bgColor
                        bgImageUrl = options.bgImageUrl
                        semitransparency = options.semitransparency
                        additionalProperties = options.additionalProperties.toMutableMap()
                    }

                    /**
                     * Whether to add an artificial shadow to the result. Default is false. Note:
                     * Adding shadows is currently only supported for car photos.
                     */
                    fun addShadow(addShadow: Boolean) = addShadow(MultipartField.of(addShadow))

                    /**
                     * Sets [Builder.addShadow] to an arbitrary multipart value.
                     *
                     * You should usually call [Builder.addShadow] with a well-typed [Boolean] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun addShadow(addShadow: MultipartField<Boolean>) = apply {
                        this.addShadow = addShadow
                    }

                    /**
                     * Specifies a solid color background using hex code (e.g., "81d4fa", "fff") or
                     * color name (e.g., "green"). If this parameter is set, `bg_image_url` must be
                     * empty.
                     */
                    fun bgColor(bgColor: String) = bgColor(MultipartField.of(bgColor))

                    /**
                     * Sets [Builder.bgColor] to an arbitrary multipart value.
                     *
                     * You should usually call [Builder.bgColor] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun bgColor(bgColor: MultipartField<String>) = apply { this.bgColor = bgColor }

                    /**
                     * Sets a background image from a URL. If this parameter is set, `bg_color` must
                     * be empty.
                     */
                    fun bgImageUrl(bgImageUrl: String) = bgImageUrl(MultipartField.of(bgImageUrl))

                    /**
                     * Sets [Builder.bgImageUrl] to an arbitrary multipart value.
                     *
                     * You should usually call [Builder.bgImageUrl] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * [Boolean] value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun semitransparency(semitransparency: MultipartField<Boolean>) = apply {
                        this.semitransparency = semitransparency
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
                     * Returns an immutable instance of [Options].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
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

                return other is RemovedotBgExtension &&
                    name == other.name &&
                    options == other.options &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(name, options, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "RemovedotBgExtension{name=$name, options=$options, additionalProperties=$additionalProperties}"
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
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun maxTags(): Long = maxTags.value.getRequired("maxTags")

            /**
             * Minimum confidence level for tags to be considered valid.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun minConfidence(): Long = minConfidence.value.getRequired("minConfidence")

            /**
             * Specifies the auto-tagging extension used.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): Name = name.value.getRequired("name")

            /**
             * Returns the raw multipart value of [maxTags].
             *
             * Unlike [maxTags], this method doesn't throw if the multipart field has an unexpected
             * type.
             */
            @JsonProperty("maxTags") @ExcludeMissing fun _maxTags(): MultipartField<Long> = maxTags

            /**
             * Returns the raw multipart value of [minConfidence].
             *
             * Unlike [minConfidence], this method doesn't throw if the multipart field has an
             * unexpected type.
             */
            @JsonProperty("minConfidence")
            @ExcludeMissing
            fun _minConfidence(): MultipartField<Long> = minConfidence

            /**
             * Returns the raw multipart value of [name].
             *
             * Unlike [name], this method doesn't throw if the multipart field has an unexpected
             * type.
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
                 * Returns a mutable builder for constructing an instance of [AutoTaggingExtension].
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
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(autoTaggingExtension: AutoTaggingExtension) = apply {
                    maxTags = autoTaggingExtension.maxTags
                    minConfidence = autoTaggingExtension.minConfidence
                    name = autoTaggingExtension.name
                    additionalProperties = autoTaggingExtension.additionalProperties.toMutableMap()
                }

                /** Maximum number of tags to attach to the asset. */
                fun maxTags(maxTags: Long) = maxTags(MultipartField.of(maxTags))

                /**
                 * Sets [Builder.maxTags] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.maxTags] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun maxTags(maxTags: MultipartField<Long>) = apply { this.maxTags = maxTags }

                /** Minimum confidence level for tags to be considered valid. */
                fun minConfidence(minConfidence: Long) =
                    minConfidence(MultipartField.of(minConfidence))

                /**
                 * Sets [Builder.minConfidence] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.minConfidence] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun minConfidence(minConfidence: MultipartField<Long>) = apply {
                    this.minConfidence = minConfidence
                }

                /** Specifies the auto-tagging extension used. */
                fun name(name: Name) = name(MultipartField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.name] with a well-typed [Name] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: MultipartField<Name>) = apply { this.name = name }

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
            class Name @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

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
                 * An enum containing [Name]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Name] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    GOOGLE_AUTO_TAGGING,
                    AWS_AUTO_TAGGING,
                    /**
                     * An enum member indicating that [Name] was instantiated with an unknown value.
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
                        GOOGLE_AUTO_TAGGING -> Value.GOOGLE_AUTO_TAGGING
                        AWS_AUTO_TAGGING -> Value.AWS_AUTO_TAGGING
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
                        GOOGLE_AUTO_TAGGING -> Known.GOOGLE_AUTO_TAGGING
                        AWS_AUTO_TAGGING -> Known.AWS_AUTO_TAGGING
                        else -> throw ImageKitInvalidDataException("Unknown Name: $value")
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

        class AutoDescriptionExtension
        private constructor(
            private val name: MultipartField<Name>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            /**
             * Specifies the auto description extension.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): Name = name.value.getRequired("name")

            /**
             * Returns the raw multipart value of [name].
             *
             * Unlike [name], this method doesn't throw if the multipart field has an unexpected
             * type.
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
                 * [AutoDescriptionExtension].
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [AutoDescriptionExtension]. */
            class Builder internal constructor() {

                private var name: MultipartField<Name>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(autoDescriptionExtension: AutoDescriptionExtension) = apply {
                    name = autoDescriptionExtension.name
                    additionalProperties =
                        autoDescriptionExtension.additionalProperties.toMutableMap()
                }

                /** Specifies the auto description extension. */
                fun name(name: Name) = name(MultipartField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary multipart value.
                 *
                 * You should usually call [Builder.name] with a well-typed [Name] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: MultipartField<Name>) = apply { this.name = name }

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
                 * Returns an immutable instance of [AutoDescriptionExtension].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): AutoDescriptionExtension =
                    AutoDescriptionExtension(
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): AutoDescriptionExtension = apply {
                if (validated) {
                    return@apply
                }

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

            /** Specifies the auto description extension. */
            class Name @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

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

                    @JvmField val AI_AUTO_DESCRIPTION = of("ai-auto-description")

                    @JvmStatic fun of(value: String) = Name(JsonField.of(value))
                }

                /** An enum containing [Name]'s known values. */
                enum class Known {
                    AI_AUTO_DESCRIPTION
                }

                /**
                 * An enum containing [Name]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Name] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    AI_AUTO_DESCRIPTION,
                    /**
                     * An enum member indicating that [Name] was instantiated with an unknown value.
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
                        AI_AUTO_DESCRIPTION -> Value.AI_AUTO_DESCRIPTION
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
                        AI_AUTO_DESCRIPTION -> Known.AI_AUTO_DESCRIPTION
                        else -> throw ImageKitInvalidDataException("Unknown Name: $value")
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

                    return other is Name && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is AutoDescriptionExtension &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(name, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "AutoDescriptionExtension{name=$name, additionalProperties=$additionalProperties}"
        }
    }

    class ResponseField @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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
         * An enum containing [ResponseField]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [ResponseField] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
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
             * An enum member indicating that [ResponseField] was instantiated with an unknown
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
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ImageKitInvalidDataException if this class instance's value is a not a known
         *   member.
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
     * - `pre` — applied before the file is uploaded to the Media Library. Useful for reducing file
     *   size or applying basic optimizations upfront (e.g., resize, compress).
     * - `post` — applied immediately after upload. Ideal for generating transformed versions (like
     *   video encodes or thumbnails) in advance, so they're ready for delivery without delay.
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
         * List of transformations to apply _after_ the file is uploaded. Each item must match one
         * of the following types: `transformation`, `gif-to-video`, `thumbnail`, `abs`.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun post(): Optional<List<Post>> = post.value.getOptional("post")

        /**
         * Transformation string to apply before uploading the file to the Media Library. Useful for
         * optimizing files at ingestion.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun pre(): Optional<String> = pre.value.getOptional("pre")

        /**
         * Returns the raw multipart value of [post].
         *
         * Unlike [post], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("post") @ExcludeMissing fun _post(): MultipartField<List<Post>> = post

        /**
         * Returns the raw multipart value of [pre].
         *
         * Unlike [pre], this method doesn't throw if the multipart field has an unexpected type.
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

            /** Returns a mutable builder for constructing an instance of [Transformation]. */
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
             * List of transformations to apply _after_ the file is uploaded. Each item must match
             * one of the following types: `transformation`, `gif-to-video`, `thumbnail`, `abs`.
             */
            fun post(post: List<Post>) = post(MultipartField.of(post))

            /**
             * Sets [Builder.post] to an arbitrary multipart value.
             *
             * You should usually call [Builder.post] with a well-typed `List<Post>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            /**
             * Alias for calling [addPost] with
             * `Post.ofSimplePostTransformation(simplePostTransformation)`.
             */
            fun addPost(simplePostTransformation: Post.SimplePostTransformation) =
                addPost(Post.ofSimplePostTransformation(simplePostTransformation))

            /** Alias for calling [addPost] with `Post.ofConvertGifToVideo(convertGifToVideo)`. */
            fun addPost(convertGifToVideo: Post.ConvertGifToVideo) =
                addPost(Post.ofConvertGifToVideo(convertGifToVideo))

            /** Alias for calling [addPost] with `Post.ofGenerateAThumbnail(generateAThumbnail)`. */
            fun addPost(generateAThumbnail: Post.GenerateAThumbnail) =
                addPost(Post.ofGenerateAThumbnail(generateAThumbnail))

            /**
             * Alias for calling [addPost] with
             * `Post.ofAdaptiveBitrateStreaming(adaptiveBitrateStreaming)`.
             */
            fun addPost(adaptiveBitrateStreaming: Post.AdaptiveBitrateStreaming) =
                addPost(Post.ofAdaptiveBitrateStreaming(adaptiveBitrateStreaming))

            /**
             * Transformation string to apply before uploading the file to the Media Library. Useful
             * for optimizing files at ingestion.
             */
            fun pre(pre: String) = pre(MultipartField.of(pre))

            /**
             * Sets [Builder.pre] to an arbitrary multipart value.
             *
             * You should usually call [Builder.pre] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun pre(pre: MultipartField<String>) = apply { this.pre = pre }

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
            private val simplePostTransformation: SimplePostTransformation? = null,
            private val convertGifToVideo: ConvertGifToVideo? = null,
            private val generateAThumbnail: GenerateAThumbnail? = null,
            private val adaptiveBitrateStreaming: AdaptiveBitrateStreaming? = null,
            private val _json: JsonValue? = null,
        ) {

            fun simplePostTransformation(): Optional<SimplePostTransformation> =
                Optional.ofNullable(simplePostTransformation)

            fun convertGifToVideo(): Optional<ConvertGifToVideo> =
                Optional.ofNullable(convertGifToVideo)

            fun generateAThumbnail(): Optional<GenerateAThumbnail> =
                Optional.ofNullable(generateAThumbnail)

            fun adaptiveBitrateStreaming(): Optional<AdaptiveBitrateStreaming> =
                Optional.ofNullable(adaptiveBitrateStreaming)

            fun isSimplePostTransformation(): Boolean = simplePostTransformation != null

            fun isConvertGifToVideo(): Boolean = convertGifToVideo != null

            fun isGenerateAThumbnail(): Boolean = generateAThumbnail != null

            fun isAdaptiveBitrateStreaming(): Boolean = adaptiveBitrateStreaming != null

            fun asSimplePostTransformation(): SimplePostTransformation =
                simplePostTransformation.getOrThrow("simplePostTransformation")

            fun asConvertGifToVideo(): ConvertGifToVideo =
                convertGifToVideo.getOrThrow("convertGifToVideo")

            fun asGenerateAThumbnail(): GenerateAThumbnail =
                generateAThumbnail.getOrThrow("generateAThumbnail")

            fun asAdaptiveBitrateStreaming(): AdaptiveBitrateStreaming =
                adaptiveBitrateStreaming.getOrThrow("adaptiveBitrateStreaming")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    simplePostTransformation != null ->
                        visitor.visitSimplePostTransformation(simplePostTransformation)
                    convertGifToVideo != null -> visitor.visitConvertGifToVideo(convertGifToVideo)
                    generateAThumbnail != null ->
                        visitor.visitGenerateAThumbnail(generateAThumbnail)
                    adaptiveBitrateStreaming != null ->
                        visitor.visitAdaptiveBitrateStreaming(adaptiveBitrateStreaming)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): Post = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitSimplePostTransformation(
                            simplePostTransformation: SimplePostTransformation
                        ) {
                            simplePostTransformation.validate()
                        }

                        override fun visitConvertGifToVideo(convertGifToVideo: ConvertGifToVideo) {
                            convertGifToVideo.validate()
                        }

                        override fun visitGenerateAThumbnail(
                            generateAThumbnail: GenerateAThumbnail
                        ) {
                            generateAThumbnail.validate()
                        }

                        override fun visitAdaptiveBitrateStreaming(
                            adaptiveBitrateStreaming: AdaptiveBitrateStreaming
                        ) {
                            adaptiveBitrateStreaming.validate()
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
                        override fun visitSimplePostTransformation(
                            simplePostTransformation: SimplePostTransformation
                        ) = simplePostTransformation.validity()

                        override fun visitConvertGifToVideo(convertGifToVideo: ConvertGifToVideo) =
                            convertGifToVideo.validity()

                        override fun visitGenerateAThumbnail(
                            generateAThumbnail: GenerateAThumbnail
                        ) = generateAThumbnail.validity()

                        override fun visitAdaptiveBitrateStreaming(
                            adaptiveBitrateStreaming: AdaptiveBitrateStreaming
                        ) = adaptiveBitrateStreaming.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Post &&
                    simplePostTransformation == other.simplePostTransformation &&
                    convertGifToVideo == other.convertGifToVideo &&
                    generateAThumbnail == other.generateAThumbnail &&
                    adaptiveBitrateStreaming == other.adaptiveBitrateStreaming
            }

            override fun hashCode(): Int =
                Objects.hash(
                    simplePostTransformation,
                    convertGifToVideo,
                    generateAThumbnail,
                    adaptiveBitrateStreaming,
                )

            override fun toString(): String =
                when {
                    simplePostTransformation != null ->
                        "Post{simplePostTransformation=$simplePostTransformation}"
                    convertGifToVideo != null -> "Post{convertGifToVideo=$convertGifToVideo}"
                    generateAThumbnail != null -> "Post{generateAThumbnail=$generateAThumbnail}"
                    adaptiveBitrateStreaming != null ->
                        "Post{adaptiveBitrateStreaming=$adaptiveBitrateStreaming}"
                    _json != null -> "Post{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Post")
                }

            companion object {

                @JvmStatic
                fun ofSimplePostTransformation(simplePostTransformation: SimplePostTransformation) =
                    Post(simplePostTransformation = simplePostTransformation)

                @JvmStatic
                fun ofConvertGifToVideo(convertGifToVideo: ConvertGifToVideo) =
                    Post(convertGifToVideo = convertGifToVideo)

                @JvmStatic
                fun ofGenerateAThumbnail(generateAThumbnail: GenerateAThumbnail) =
                    Post(generateAThumbnail = generateAThumbnail)

                @JvmStatic
                fun ofAdaptiveBitrateStreaming(adaptiveBitrateStreaming: AdaptiveBitrateStreaming) =
                    Post(adaptiveBitrateStreaming = adaptiveBitrateStreaming)
            }

            /**
             * An interface that defines how to map each variant of [Post] to a value of type [T].
             */
            interface Visitor<out T> {

                fun visitSimplePostTransformation(
                    simplePostTransformation: SimplePostTransformation
                ): T

                fun visitConvertGifToVideo(convertGifToVideo: ConvertGifToVideo): T

                fun visitGenerateAThumbnail(generateAThumbnail: GenerateAThumbnail): T

                fun visitAdaptiveBitrateStreaming(
                    adaptiveBitrateStreaming: AdaptiveBitrateStreaming
                ): T

                /**
                 * Maps an unknown variant of [Post] to a value of type [T].
                 *
                 * An instance of [Post] can contain an unknown variant if it was deserialized from
                 * data that doesn't match any known variant. For example, if the SDK is on an older
                 * version than the API, then the API may respond with new variants that the SDK is
                 * unaware of.
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

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<SimplePostTransformation>())
                                    ?.let { Post(simplePostTransformation = it, _json = json) },
                                tryDeserialize(node, jacksonTypeRef<ConvertGifToVideo>())?.let {
                                    Post(convertGifToVideo = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<GenerateAThumbnail>())?.let {
                                    Post(generateAThumbnail = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<AdaptiveBitrateStreaming>())
                                    ?.let { Post(adaptiveBitrateStreaming = it, _json = json) },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> Post(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<Post>(Post::class) {

                override fun serialize(
                    value: Post,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.simplePostTransformation != null ->
                            generator.writeObject(value.simplePostTransformation)
                        value.convertGifToVideo != null ->
                            generator.writeObject(value.convertGifToVideo)
                        value.generateAThumbnail != null ->
                            generator.writeObject(value.generateAThumbnail)
                        value.adaptiveBitrateStreaming != null ->
                            generator.writeObject(value.adaptiveBitrateStreaming)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Post")
                    }
                }
            }

            class SimplePostTransformation
            private constructor(
                private val type: MultipartField<Type>,
                private val value: MultipartField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                /**
                 * Transformation type.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or
                 *   is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun type(): Type = type.value.getRequired("type")

                /**
                 * Transformation string (e.g. `w-200,h-200`). Same syntax as ImageKit URL-based
                 * transformations.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or
                 *   is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun value(): String = value.value.getRequired("value")

                /**
                 * Returns the raw multipart value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the multipart field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): MultipartField<Type> = type

                /**
                 * Returns the raw multipart value of [value].
                 *
                 * Unlike [value], this method doesn't throw if the multipart field has an
                 * unexpected type.
                 */
                @JsonProperty("value") @ExcludeMissing fun _value(): MultipartField<String> = value

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
                     * [SimplePostTransformation].
                     *
                     * The following fields are required:
                     * ```java
                     * .type()
                     * .value()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [SimplePostTransformation]. */
                class Builder internal constructor() {

                    private var type: MultipartField<Type>? = null
                    private var value: MultipartField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(simplePostTransformation: SimplePostTransformation) = apply {
                        type = simplePostTransformation.type
                        value = simplePostTransformation.value
                        additionalProperties =
                            simplePostTransformation.additionalProperties.toMutableMap()
                    }

                    /** Transformation type. */
                    fun type(type: Type) = type(MultipartField.of(type))

                    /**
                     * Sets [Builder.type] to an arbitrary multipart value.
                     *
                     * You should usually call [Builder.type] with a well-typed [Type] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun type(type: MultipartField<Type>) = apply { this.type = type }

                    /**
                     * Transformation string (e.g. `w-200,h-200`). Same syntax as ImageKit URL-based
                     * transformations.
                     */
                    fun value(value: String) = value(MultipartField.of(value))

                    /**
                     * Sets [Builder.value] to an arbitrary multipart value.
                     *
                     * You should usually call [Builder.value] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun value(value: MultipartField<String>) = apply { this.value = value }

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
                     * Returns an immutable instance of [SimplePostTransformation].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .type()
                     * .value()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): SimplePostTransformation =
                        SimplePostTransformation(
                            checkRequired("type", type),
                            checkRequired("value", value),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): SimplePostTransformation = apply {
                    if (validated) {
                        return@apply
                    }

                    type().validate()
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

                /** Transformation type. */
                class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val TRANSFORMATION = of("transformation")

                        @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                    }

                    /** An enum containing [Type]'s known values. */
                    enum class Known {
                        TRANSFORMATION
                    }

                    /**
                     * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Type] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        TRANSFORMATION,
                        /**
                         * An enum member indicating that [Type] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            TRANSFORMATION -> Value.TRANSFORMATION
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value is a not
                     *   a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            TRANSFORMATION -> Known.TRANSFORMATION
                            else -> throw ImageKitInvalidDataException("Unknown Type: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value does not
                     *   have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            ImageKitInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    fun validate(): Type = apply {
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Type && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is SimplePostTransformation &&
                        type == other.type &&
                        value == other.value &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(type, value, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "SimplePostTransformation{type=$type, value=$value, additionalProperties=$additionalProperties}"
            }

            class ConvertGifToVideo
            private constructor(
                private val type: MultipartField<Type>,
                private val value: MultipartField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                /**
                 * Converts an animated GIF into an MP4.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or
                 *   is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun type(): Type = type.value.getRequired("type")

                /**
                 * Optional transformation string to apply to the output video. **Example**: `q-80`
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun value(): Optional<String> = value.value.getOptional("value")

                /**
                 * Returns the raw multipart value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the multipart field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): MultipartField<Type> = type

                /**
                 * Returns the raw multipart value of [value].
                 *
                 * Unlike [value], this method doesn't throw if the multipart field has an
                 * unexpected type.
                 */
                @JsonProperty("value") @ExcludeMissing fun _value(): MultipartField<String> = value

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
                     * [ConvertGifToVideo].
                     *
                     * The following fields are required:
                     * ```java
                     * .type()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [ConvertGifToVideo]. */
                class Builder internal constructor() {

                    private var type: MultipartField<Type>? = null
                    private var value: MultipartField<String> = MultipartField.of(null)
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(convertGifToVideo: ConvertGifToVideo) = apply {
                        type = convertGifToVideo.type
                        value = convertGifToVideo.value
                        additionalProperties = convertGifToVideo.additionalProperties.toMutableMap()
                    }

                    /** Converts an animated GIF into an MP4. */
                    fun type(type: Type) = type(MultipartField.of(type))

                    /**
                     * Sets [Builder.type] to an arbitrary multipart value.
                     *
                     * You should usually call [Builder.type] with a well-typed [Type] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun type(type: MultipartField<Type>) = apply { this.type = type }

                    /**
                     * Optional transformation string to apply to the output video. **Example**:
                     * `q-80`
                     */
                    fun value(value: String) = value(MultipartField.of(value))

                    /**
                     * Sets [Builder.value] to an arbitrary multipart value.
                     *
                     * You should usually call [Builder.value] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun value(value: MultipartField<String>) = apply { this.value = value }

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
                     * Returns an immutable instance of [ConvertGifToVideo].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .type()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): ConvertGifToVideo =
                        ConvertGifToVideo(
                            checkRequired("type", type),
                            value,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): ConvertGifToVideo = apply {
                    if (validated) {
                        return@apply
                    }

                    type().validate()
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

                /** Converts an animated GIF into an MP4. */
                class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val GIF_TO_VIDEO = of("gif-to-video")

                        @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                    }

                    /** An enum containing [Type]'s known values. */
                    enum class Known {
                        GIF_TO_VIDEO
                    }

                    /**
                     * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Type] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        GIF_TO_VIDEO,
                        /**
                         * An enum member indicating that [Type] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            GIF_TO_VIDEO -> Value.GIF_TO_VIDEO
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value is a not
                     *   a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            GIF_TO_VIDEO -> Known.GIF_TO_VIDEO
                            else -> throw ImageKitInvalidDataException("Unknown Type: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value does not
                     *   have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            ImageKitInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    fun validate(): Type = apply {
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Type && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is ConvertGifToVideo &&
                        type == other.type &&
                        value == other.value &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(type, value, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "ConvertGifToVideo{type=$type, value=$value, additionalProperties=$additionalProperties}"
            }

            class GenerateAThumbnail
            private constructor(
                private val type: MultipartField<Type>,
                private val value: MultipartField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                /**
                 * Generates a thumbnail image.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or
                 *   is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun type(): Type = type.value.getRequired("type")

                /**
                 * Optional transformation string. **Example**: `w-150,h-150`
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun value(): Optional<String> = value.value.getOptional("value")

                /**
                 * Returns the raw multipart value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the multipart field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): MultipartField<Type> = type

                /**
                 * Returns the raw multipart value of [value].
                 *
                 * Unlike [value], this method doesn't throw if the multipart field has an
                 * unexpected type.
                 */
                @JsonProperty("value") @ExcludeMissing fun _value(): MultipartField<String> = value

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
                     * [GenerateAThumbnail].
                     *
                     * The following fields are required:
                     * ```java
                     * .type()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [GenerateAThumbnail]. */
                class Builder internal constructor() {

                    private var type: MultipartField<Type>? = null
                    private var value: MultipartField<String> = MultipartField.of(null)
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(generateAThumbnail: GenerateAThumbnail) = apply {
                        type = generateAThumbnail.type
                        value = generateAThumbnail.value
                        additionalProperties =
                            generateAThumbnail.additionalProperties.toMutableMap()
                    }

                    /** Generates a thumbnail image. */
                    fun type(type: Type) = type(MultipartField.of(type))

                    /**
                     * Sets [Builder.type] to an arbitrary multipart value.
                     *
                     * You should usually call [Builder.type] with a well-typed [Type] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun type(type: MultipartField<Type>) = apply { this.type = type }

                    /** Optional transformation string. **Example**: `w-150,h-150` */
                    fun value(value: String) = value(MultipartField.of(value))

                    /**
                     * Sets [Builder.value] to an arbitrary multipart value.
                     *
                     * You should usually call [Builder.value] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun value(value: MultipartField<String>) = apply { this.value = value }

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
                     * Returns an immutable instance of [GenerateAThumbnail].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .type()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): GenerateAThumbnail =
                        GenerateAThumbnail(
                            checkRequired("type", type),
                            value,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): GenerateAThumbnail = apply {
                    if (validated) {
                        return@apply
                    }

                    type().validate()
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

                /** Generates a thumbnail image. */
                class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val THUMBNAIL = of("thumbnail")

                        @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                    }

                    /** An enum containing [Type]'s known values. */
                    enum class Known {
                        THUMBNAIL
                    }

                    /**
                     * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Type] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        THUMBNAIL,
                        /**
                         * An enum member indicating that [Type] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            THUMBNAIL -> Value.THUMBNAIL
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value is a not
                     *   a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            THUMBNAIL -> Known.THUMBNAIL
                            else -> throw ImageKitInvalidDataException("Unknown Type: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value does not
                     *   have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            ImageKitInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    fun validate(): Type = apply {
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Type && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is GenerateAThumbnail &&
                        type == other.type &&
                        value == other.value &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(type, value, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "GenerateAThumbnail{type=$type, value=$value, additionalProperties=$additionalProperties}"
            }

            class AdaptiveBitrateStreaming
            private constructor(
                private val protocol: MultipartField<Protocol>,
                private val type: MultipartField<Type>,
                private val value: MultipartField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                /**
                 * Streaming protocol to use (`hls` or `dash`).
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or
                 *   is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun protocol(): Protocol = protocol.value.getRequired("protocol")

                /**
                 * Adaptive Bitrate Streaming (ABS) setup.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or
                 *   is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun type(): Type = type.value.getRequired("type")

                /**
                 * List of different representations you want to create separated by an underscore.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or
                 *   is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun value(): String = value.value.getRequired("value")

                /**
                 * Returns the raw multipart value of [protocol].
                 *
                 * Unlike [protocol], this method doesn't throw if the multipart field has an
                 * unexpected type.
                 */
                @JsonProperty("protocol")
                @ExcludeMissing
                fun _protocol(): MultipartField<Protocol> = protocol

                /**
                 * Returns the raw multipart value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the multipart field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): MultipartField<Type> = type

                /**
                 * Returns the raw multipart value of [value].
                 *
                 * Unlike [value], this method doesn't throw if the multipart field has an
                 * unexpected type.
                 */
                @JsonProperty("value") @ExcludeMissing fun _value(): MultipartField<String> = value

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
                     * [AdaptiveBitrateStreaming].
                     *
                     * The following fields are required:
                     * ```java
                     * .protocol()
                     * .type()
                     * .value()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [AdaptiveBitrateStreaming]. */
                class Builder internal constructor() {

                    private var protocol: MultipartField<Protocol>? = null
                    private var type: MultipartField<Type>? = null
                    private var value: MultipartField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(adaptiveBitrateStreaming: AdaptiveBitrateStreaming) = apply {
                        protocol = adaptiveBitrateStreaming.protocol
                        type = adaptiveBitrateStreaming.type
                        value = adaptiveBitrateStreaming.value
                        additionalProperties =
                            adaptiveBitrateStreaming.additionalProperties.toMutableMap()
                    }

                    /** Streaming protocol to use (`hls` or `dash`). */
                    fun protocol(protocol: Protocol) = protocol(MultipartField.of(protocol))

                    /**
                     * Sets [Builder.protocol] to an arbitrary multipart value.
                     *
                     * You should usually call [Builder.protocol] with a well-typed [Protocol] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun protocol(protocol: MultipartField<Protocol>) = apply {
                        this.protocol = protocol
                    }

                    /** Adaptive Bitrate Streaming (ABS) setup. */
                    fun type(type: Type) = type(MultipartField.of(type))

                    /**
                     * Sets [Builder.type] to an arbitrary multipart value.
                     *
                     * You should usually call [Builder.type] with a well-typed [Type] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun type(type: MultipartField<Type>) = apply { this.type = type }

                    /**
                     * List of different representations you want to create separated by an
                     * underscore.
                     */
                    fun value(value: String) = value(MultipartField.of(value))

                    /**
                     * Sets [Builder.value] to an arbitrary multipart value.
                     *
                     * You should usually call [Builder.value] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun value(value: MultipartField<String>) = apply { this.value = value }

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
                     * Returns an immutable instance of [AdaptiveBitrateStreaming].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .protocol()
                     * .type()
                     * .value()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): AdaptiveBitrateStreaming =
                        AdaptiveBitrateStreaming(
                            checkRequired("protocol", protocol),
                            checkRequired("type", type),
                            checkRequired("value", value),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): AdaptiveBitrateStreaming = apply {
                    if (validated) {
                        return@apply
                    }

                    protocol().validate()
                    type().validate()
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
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
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
                     * An enum containing [Protocol]'s known values, as well as an [_UNKNOWN]
                     * member.
                     *
                     * An instance of [Protocol] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        HLS,
                        DASH,
                        /**
                         * An enum member indicating that [Protocol] was instantiated with an
                         * unknown value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
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
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value is a not
                     *   a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            HLS -> Known.HLS
                            DASH -> Known.DASH
                            else -> throw ImageKitInvalidDataException("Unknown Protocol: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value does not
                     *   have the expected primitive type.
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
                     * Returns a score indicating how many valid values are contained in this object
                     * recursively.
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

                /** Adaptive Bitrate Streaming (ABS) setup. */
                class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val ABS = of("abs")

                        @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                    }

                    /** An enum containing [Type]'s known values. */
                    enum class Known {
                        ABS
                    }

                    /**
                     * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Type] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        ABS,
                        /**
                         * An enum member indicating that [Type] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            ABS -> Value.ABS
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value is a not
                     *   a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            ABS -> Known.ABS
                            else -> throw ImageKitInvalidDataException("Unknown Type: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws ImageKitInvalidDataException if this class instance's value does not
                     *   have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            ImageKitInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    fun validate(): Type = apply {
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Type && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is AdaptiveBitrateStreaming &&
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
                    "AdaptiveBitrateStreaming{protocol=$protocol, type=$type, value=$value, additionalProperties=$additionalProperties}"
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

        return other is FileUploadParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "FileUploadParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
