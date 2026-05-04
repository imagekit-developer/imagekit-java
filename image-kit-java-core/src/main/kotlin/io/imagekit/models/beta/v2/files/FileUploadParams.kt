// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.beta.v2.files

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import io.imagekit.core.BaseSerializer
import io.imagekit.core.Enum
import io.imagekit.core.ExcludeMissing
import io.imagekit.core.JsonField
import io.imagekit.core.JsonValue
import io.imagekit.core.MultipartField
import io.imagekit.core.Params
import io.imagekit.core.checkKnown
import io.imagekit.core.checkRequired
import io.imagekit.core.getOrThrow
import io.imagekit.core.http.Headers
import io.imagekit.core.http.QueryParams
import io.imagekit.core.jsonMapper
import io.imagekit.core.toImmutable
import io.imagekit.errors.ImageKitInvalidDataException
import io.imagekit.models.ExtensionItem
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
 * **File size limit** \ On the free plan, the maximum upload file sizes are 25MB for images, audio,
 * and raw files, and 100MB for videos. On the Lite paid plan, these limits increase to 40MB for
 * images, audio, and raw files and 300MB for videos, whereas on the Pro paid plan, these limits
 * increase to 50MB for images, audio, and raw files and 2GB for videos. These limits can be further
 * increased with enterprise plans.
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
     * Array of extensions to be applied to the asset. Each extension can be configured with
     * specific parameters based on the extension type.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun extensions(): Optional<List<ExtensionItem>> = body.extensions()

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
    fun transformation(): Optional<UploadTransformation> = body.transformation()

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
    fun _extensions(): MultipartField<List<ExtensionItem>> = body._extensions()

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
    fun _transformation(): MultipartField<UploadTransformation> = body._transformation()

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
        fun file(path: Path) = apply { body.file(path) }

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
         * Array of extensions to be applied to the asset. Each extension can be configured with
         * specific parameters based on the extension type.
         */
        fun extensions(extensions: List<ExtensionItem>) = apply { body.extensions(extensions) }

        /**
         * Sets [Builder.extensions] to an arbitrary multipart value.
         *
         * You should usually call [Builder.extensions] with a well-typed `List<ExtensionItem>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun extensions(extensions: MultipartField<List<ExtensionItem>>) = apply {
            body.extensions(extensions)
        }

        /**
         * Adds a single [ExtensionItem] to [extensions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addExtension(extension: ExtensionItem) = apply { body.addExtension(extension) }

        /** Alias for calling [addExtension] with `ExtensionItem.ofRemoveBg(removeBg)`. */
        fun addExtension(removeBg: ExtensionItem.RemoveBg) = apply { body.addExtension(removeBg) }

        /**
         * Alias for calling [addExtension] with
         * `ExtensionItem.ofAutoTaggingExtension(autoTaggingExtension)`.
         */
        fun addExtension(autoTaggingExtension: ExtensionItem.AutoTaggingExtension) = apply {
            body.addExtension(autoTaggingExtension)
        }

        /** Alias for calling [addExtension] with `ExtensionItem.ofAiAutoDescription()`. */
        fun addExtensionAiAutoDescription() = apply { body.addExtensionAiAutoDescription() }

        /** Alias for calling [addExtension] with `ExtensionItem.ofAiTasks(aiTasks)`. */
        fun addExtension(aiTasks: ExtensionItem.AiTasks) = apply { body.addExtension(aiTasks) }

        /**
         * Alias for calling [addExtension] with the following:
         * ```java
         * ExtensionItem.AiTasks.builder()
         *     .tasks(tasks)
         *     .build()
         * ```
         */
        fun addAiTasksExtension(tasks: List<ExtensionItem.AiTasks.Task>) = apply {
            body.addAiTasksExtension(tasks)
        }

        /**
         * Alias for calling [addExtension] with `ExtensionItem.ofSavedExtension(savedExtension)`.
         */
        fun addExtension(savedExtension: ExtensionItem.SavedExtension) = apply {
            body.addExtension(savedExtension)
        }

        /**
         * Alias for calling [addExtension] with the following:
         * ```java
         * ExtensionItem.SavedExtension.builder()
         *     .id(id)
         *     .build()
         * ```
         */
        fun addSavedExtensionExtension(id: String) = apply { body.addSavedExtensionExtension(id) }

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
        fun transformation(transformation: UploadTransformation) = apply {
            body.transformation(transformation)
        }

        /**
         * Sets [Builder.transformation] to an arbitrary multipart value.
         *
         * You should usually call [Builder.transformation] with a well-typed [UploadTransformation]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun transformation(transformation: MultipartField<UploadTransformation>) = apply {
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
                "customMetadata" to _toJsonString(_customMetadata()),
                "description" to _description(),
                "extensions" to _toJsonString(_extensions()),
                "folder" to _folder(),
                "isPrivateFile" to _isPrivateFile(),
                "isPublished" to _isPublished(),
                "overwriteAITags" to _overwriteAiTags(),
                "overwriteCustomMetadata" to _overwriteCustomMetadata(),
                "overwriteFile" to _overwriteFile(),
                "overwriteTags" to _overwriteTags(),
                "responseFields" to _toCommaSeparated(_responseFields()),
                "tags" to _toCommaSeparated(_tags()),
                "transformation" to _toJsonString(_transformation()),
                "useUniqueFileName" to _useUniqueFileName(),
                "webhookUrl" to _webhookUrl(),
            ) + _additionalBodyProperties().mapValues { (_, value) -> MultipartField.of(value) })
            .toImmutable()

    private fun _toJsonString(field: MultipartField<*>): MultipartField<String> {
        if (field.value.isMissing() || field.value.isNull()) {
            @Suppress("UNCHECKED_CAST")
            return field as MultipartField<String>
        }
        val jsonString = jsonMapper().writeValueAsString(field.value)
        return MultipartField.of(jsonString)
    }

    private fun _toCommaSeparated(field: MultipartField<*>): MultipartField<String> {
        if (field.value.isMissing() || field.value.isNull()) {
            @Suppress("UNCHECKED_CAST")
            return field as MultipartField<String>
        }
        val mapper = jsonMapper()
        val node = mapper.valueToTree<JsonNode>(field.value)
        if (!node.isArray) {
            @Suppress("UNCHECKED_CAST")
            return field as MultipartField<String>
        }
        val csv =
            node
                .elements()
                .asSequence()
                .filter { !it.isNull && !it.isMissingNode }
                .map { it.asText() }
                .joinToString(",")
        return MultipartField.of(csv)
    }

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
        private val extensions: MultipartField<List<ExtensionItem>>,
        private val folder: MultipartField<String>,
        private val isPrivateFile: MultipartField<Boolean>,
        private val isPublished: MultipartField<Boolean>,
        private val overwriteAiTags: MultipartField<Boolean>,
        private val overwriteCustomMetadata: MultipartField<Boolean>,
        private val overwriteFile: MultipartField<Boolean>,
        private val overwriteTags: MultipartField<Boolean>,
        private val responseFields: MultipartField<List<ResponseField>>,
        private val tags: MultipartField<List<String>>,
        private val transformation: MultipartField<UploadTransformation>,
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
         * Array of extensions to be applied to the asset. Each extension can be configured with
         * specific parameters based on the extension type.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun extensions(): Optional<List<ExtensionItem>> = extensions.value.getOptional("extensions")

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
        fun transformation(): Optional<UploadTransformation> =
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
        fun _extensions(): MultipartField<List<ExtensionItem>> = extensions

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
        fun _transformation(): MultipartField<UploadTransformation> = transformation

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
            private var extensions: MultipartField<MutableList<ExtensionItem>>? = null
            private var folder: MultipartField<String> = MultipartField.of(null)
            private var isPrivateFile: MultipartField<Boolean> = MultipartField.of(null)
            private var isPublished: MultipartField<Boolean> = MultipartField.of(null)
            private var overwriteAiTags: MultipartField<Boolean> = MultipartField.of(null)
            private var overwriteCustomMetadata: MultipartField<Boolean> = MultipartField.of(null)
            private var overwriteFile: MultipartField<Boolean> = MultipartField.of(null)
            private var overwriteTags: MultipartField<Boolean> = MultipartField.of(null)
            private var responseFields: MultipartField<MutableList<ResponseField>>? = null
            private var tags: MultipartField<MutableList<String>>? = null
            private var transformation: MultipartField<UploadTransformation> =
                MultipartField.of(null)
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
            fun file(path: Path) =
                file(
                    MultipartField.builder<InputStream>()
                        .value(path.inputStream())
                        .filename(path.name)
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
             * Array of extensions to be applied to the asset. Each extension can be configured with
             * specific parameters based on the extension type.
             */
            fun extensions(extensions: List<ExtensionItem>) =
                extensions(MultipartField.of(extensions))

            /**
             * Sets [Builder.extensions] to an arbitrary multipart value.
             *
             * You should usually call [Builder.extensions] with a well-typed `List<ExtensionItem>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun extensions(extensions: MultipartField<List<ExtensionItem>>) = apply {
                this.extensions = extensions.map { it.toMutableList() }
            }

            /**
             * Adds a single [ExtensionItem] to [extensions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addExtension(extension: ExtensionItem) = apply {
                extensions =
                    (extensions ?: MultipartField.of(mutableListOf())).also {
                        checkKnown("extensions", it).add(extension)
                    }
            }

            /** Alias for calling [addExtension] with `ExtensionItem.ofRemoveBg(removeBg)`. */
            fun addExtension(removeBg: ExtensionItem.RemoveBg) =
                addExtension(ExtensionItem.ofRemoveBg(removeBg))

            /**
             * Alias for calling [addExtension] with
             * `ExtensionItem.ofAutoTaggingExtension(autoTaggingExtension)`.
             */
            fun addExtension(autoTaggingExtension: ExtensionItem.AutoTaggingExtension) =
                addExtension(ExtensionItem.ofAutoTaggingExtension(autoTaggingExtension))

            /** Alias for calling [addExtension] with `ExtensionItem.ofAiAutoDescription()`. */
            fun addExtensionAiAutoDescription() = addExtension(ExtensionItem.ofAiAutoDescription())

            /** Alias for calling [addExtension] with `ExtensionItem.ofAiTasks(aiTasks)`. */
            fun addExtension(aiTasks: ExtensionItem.AiTasks) =
                addExtension(ExtensionItem.ofAiTasks(aiTasks))

            /**
             * Alias for calling [addExtension] with the following:
             * ```java
             * ExtensionItem.AiTasks.builder()
             *     .tasks(tasks)
             *     .build()
             * ```
             */
            fun addAiTasksExtension(tasks: List<ExtensionItem.AiTasks.Task>) =
                addExtension(ExtensionItem.AiTasks.builder().tasks(tasks).build())

            /**
             * Alias for calling [addExtension] with
             * `ExtensionItem.ofSavedExtension(savedExtension)`.
             */
            fun addExtension(savedExtension: ExtensionItem.SavedExtension) =
                addExtension(ExtensionItem.ofSavedExtension(savedExtension))

            /**
             * Alias for calling [addExtension] with the following:
             * ```java
             * ExtensionItem.SavedExtension.builder()
             *     .id(id)
             *     .build()
             * ```
             */
            fun addSavedExtensionExtension(id: String) =
                addExtension(ExtensionItem.SavedExtension.builder().id(id).build())

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
            fun transformation(transformation: UploadTransformation) =
                transformation(MultipartField.of(transformation))

            /**
             * Sets [Builder.transformation] to an arbitrary multipart value.
             *
             * You should usually call [Builder.transformation] with a well-typed
             * [UploadTransformation] value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun transformation(transformation: MultipartField<UploadTransformation>) = apply {
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
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

            @JvmField val SELECTED_FIELDS_SCHEMA = of("selectedFieldsSchema")

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
            SELECTED_FIELDS_SCHEMA,
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
            SELECTED_FIELDS_SCHEMA,
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
                SELECTED_FIELDS_SCHEMA -> Value.SELECTED_FIELDS_SCHEMA
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
                SELECTED_FIELDS_SCHEMA -> Known.SELECTED_FIELDS_SCHEMA
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
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
    class UploadTransformation
    private constructor(
        private val post: MultipartField<List<Post>>,
        private val pre: MultipartField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        /**
         * List of transformations to apply *after* the file is uploaded. Each item must match one
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

            /** Returns a mutable builder for constructing an instance of [UploadTransformation]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UploadTransformation]. */
        class Builder internal constructor() {

            private var post: MultipartField<MutableList<Post>>? = null
            private var pre: MultipartField<String> = MultipartField.of(null)
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(uploadTransformation: UploadTransformation) = apply {
                post = uploadTransformation.post.map { it.toMutableList() }
                pre = uploadTransformation.pre
                additionalProperties = uploadTransformation.additionalProperties.toMutableMap()
            }

            /**
             * List of transformations to apply *after* the file is uploaded. Each item must match
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

            /** Alias for calling [addPost] with `Post.ofTransformation(transformation)`. */
            fun addPost(transformation: Post.Transformation) =
                addPost(Post.ofTransformation(transformation))

            /**
             * Alias for calling [addPost] with the following:
             * ```java
             * Post.Transformation.builder()
             *     .value(value)
             *     .build()
             * ```
             */
            fun addTransformationPost(value: String) =
                addPost(Post.Transformation.builder().value(value).build())

            /** Alias for calling [addPost] with `Post.ofGifToVideo(gifToVideo)`. */
            fun addPost(gifToVideo: Post.GifToVideo) = addPost(Post.ofGifToVideo(gifToVideo))

            /** Alias for calling [addPost] with `Post.ofThumbnail(thumbnail)`. */
            fun addPost(thumbnail: Post.Thumbnail) = addPost(Post.ofThumbnail(thumbnail))

            /** Alias for calling [addPost] with `Post.ofAbs(abs)`. */
            fun addPost(abs: Post.Abs) = addPost(Post.ofAbs(abs))

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
             * Returns an immutable instance of [UploadTransformation].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): UploadTransformation =
                UploadTransformation(
                    (post ?: MultipartField.of(null)).map { it.toImmutable() },
                    pre,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): UploadTransformation = apply {
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

        @JsonSerialize(using = Post.Serializer::class)
        class Post
        private constructor(
            private val transformation: Transformation? = null,
            private val gifToVideo: GifToVideo? = null,
            private val thumbnail: Thumbnail? = null,
            private val abs: Abs? = null,
            private val _json: JsonValue? = null,
        ) {

            fun transformation(): Optional<Transformation> = Optional.ofNullable(transformation)

            fun gifToVideo(): Optional<GifToVideo> = Optional.ofNullable(gifToVideo)

            fun thumbnail(): Optional<Thumbnail> = Optional.ofNullable(thumbnail)

            fun abs(): Optional<Abs> = Optional.ofNullable(abs)

            fun isTransformation(): Boolean = transformation != null

            fun isGifToVideo(): Boolean = gifToVideo != null

            fun isThumbnail(): Boolean = thumbnail != null

            fun isAbs(): Boolean = abs != null

            fun asTransformation(): Transformation = transformation.getOrThrow("transformation")

            fun asGifToVideo(): GifToVideo = gifToVideo.getOrThrow("gifToVideo")

            fun asThumbnail(): Thumbnail = thumbnail.getOrThrow("thumbnail")

            fun asAbs(): Abs = abs.getOrThrow("abs")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * Note that this method is _not_ forwards compatible with new variants from the API,
             * unless [visitor] overrides [Visitor.unknown]. To handle variants not known to this
             * version of the SDK gracefully, consider overriding [Visitor.unknown]:
             * ```java
             * import io.imagekit.core.JsonValue;
             * import java.util.Optional;
             *
             * Optional<String> result = post.accept(new Post.Visitor<Optional<String>>() {
             *     @Override
             *     public Optional<String> visitTransformation(Transformation transformation) {
             *         return Optional.of(transformation.toString());
             *     }
             *
             *     // ...
             *
             *     @Override
             *     public Optional<String> unknown(JsonValue json) {
             *         // Or inspect the `json`.
             *         return Optional.empty();
             *     }
             * });
             * ```
             *
             * @throws ImageKitInvalidDataException if [Visitor.unknown] is not overridden in
             *   [visitor] and the current variant is unknown.
             */
            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    transformation != null -> visitor.visitTransformation(transformation)
                    gifToVideo != null -> visitor.visitGifToVideo(gifToVideo)
                    thumbnail != null -> visitor.visitThumbnail(thumbnail)
                    abs != null -> visitor.visitAbs(abs)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): Post = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitTransformation(transformation: Transformation) {
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

            override fun hashCode(): Int = Objects.hash(transformation, gifToVideo, thumbnail, abs)

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
                fun ofTransformation(transformation: Transformation) =
                    Post(transformation = transformation)

                @JvmStatic fun ofGifToVideo(gifToVideo: GifToVideo) = Post(gifToVideo = gifToVideo)

                @JvmStatic fun ofThumbnail(thumbnail: Thumbnail) = Post(thumbnail = thumbnail)

                @JvmStatic fun ofAbs(abs: Abs) = Post(abs = abs)
            }

            /**
             * An interface that defines how to map each variant of [Post] to a value of type [T].
             */
            interface Visitor<out T> {

                fun visitTransformation(transformation: Transformation): T

                fun visitGifToVideo(gifToVideo: GifToVideo): T

                fun visitThumbnail(thumbnail: Thumbnail): T

                fun visitAbs(abs: Abs): T

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

            internal class Serializer : BaseSerializer<Post>(Post::class) {

                override fun serialize(
                    value: Post,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.transformation != null -> generator.writeObject(value.transformation)
                        value.gifToVideo != null -> generator.writeObject(value.gifToVideo)
                        value.thumbnail != null -> generator.writeObject(value.thumbnail)
                        value.abs != null -> generator.writeObject(value.abs)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Post")
                    }
                }
            }

            class Transformation
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
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

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
                     * Returns a mutable builder for constructing an instance of [Transformation].
                     *
                     * The following fields are required:
                     * ```java
                     * .value()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Transformation]. */
                class Builder internal constructor() {

                    private var type: JsonValue = JsonValue.from("transformation")
                    private var value: MultipartField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(transformation: Transformation) = apply {
                        type = transformation.type
                        value = transformation.value
                        additionalProperties = transformation.additionalProperties.toMutableMap()
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("transformation")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

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
                     * Returns an immutable instance of [Transformation].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .value()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Transformation =
                        Transformation(
                            type,
                            checkRequired("value", value),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws ImageKitInvalidDataException if any value type in this object doesn't
                 *   match its expected type.
                 */
                fun validate(): Transformation = apply {
                    if (validated) {
                        return@apply
                    }

                    _type().let {
                        if (it != JsonValue.from("transformation")) {
                            throw ImageKitInvalidDataException("'type' is invalid, received $it")
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

                    return other is Transformation &&
                        type == other.type &&
                        value == other.value &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(type, value, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Transformation{type=$type, value=$value, additionalProperties=$additionalProperties}"
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
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Optional transformation string to apply to the output video. **Example**: `q-80`
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun value(): Optional<String> = value.value.getOptional("value")

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

                    /** Returns a mutable builder for constructing an instance of [GifToVideo]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [GifToVideo]. */
                class Builder internal constructor() {

                    private var type: JsonValue = JsonValue.from("gif-to-video")
                    private var value: MultipartField<String> = MultipartField.of(null)
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(gifToVideo: GifToVideo) = apply {
                        type = gifToVideo.type
                        value = gifToVideo.value
                        additionalProperties = gifToVideo.additionalProperties.toMutableMap()
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("gif-to-video")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

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
                     * Returns an immutable instance of [GifToVideo].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): GifToVideo =
                        GifToVideo(type, value, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws ImageKitInvalidDataException if any value type in this object doesn't
                 *   match its expected type.
                 */
                fun validate(): GifToVideo = apply {
                    if (validated) {
                        return@apply
                    }

                    _type().let {
                        if (it != JsonValue.from("gif-to-video")) {
                            throw ImageKitInvalidDataException("'type' is invalid, received $it")
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
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Optional transformation string. **Example**: `w-150,h-150`
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun value(): Optional<String> = value.value.getOptional("value")

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

                    /** Returns a mutable builder for constructing an instance of [Thumbnail]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Thumbnail]. */
                class Builder internal constructor() {

                    private var type: JsonValue = JsonValue.from("thumbnail")
                    private var value: MultipartField<String> = MultipartField.of(null)
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(thumbnail: Thumbnail) = apply {
                        type = thumbnail.type
                        value = thumbnail.value
                        additionalProperties = thumbnail.additionalProperties.toMutableMap()
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("thumbnail")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

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
                     * Returns an immutable instance of [Thumbnail].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Thumbnail =
                        Thumbnail(type, value, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws ImageKitInvalidDataException if any value type in this object doesn't
                 *   match its expected type.
                 */
                fun validate(): Thumbnail = apply {
                    if (validated) {
                        return@apply
                    }

                    _type().let {
                        if (it != JsonValue.from("thumbnail")) {
                            throw ImageKitInvalidDataException("'type' is invalid, received $it")
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
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or
                 *   is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
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
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

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
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

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
                     * You should usually call [Builder.protocol] with a well-typed [Protocol] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun protocol(protocol: MultipartField<Protocol>) = apply {
                        this.protocol = protocol
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("abs")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
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
                     * Returns an immutable instance of [Abs].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
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

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws ImageKitInvalidDataException if any value type in this object doesn't
                 *   match its expected type.
                 */
                fun validate(): Abs = apply {
                    if (validated) {
                        return@apply
                    }

                    protocol().validate()
                    _type().let {
                        if (it != JsonValue.from("abs")) {
                            throw ImageKitInvalidDataException("'type' is invalid, received $it")
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

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws ImageKitInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
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

            return other is UploadTransformation &&
                post == other.post &&
                pre == other.pre &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(post, pre, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UploadTransformation{post=$post, pre=$pre, additionalProperties=$additionalProperties}"
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
