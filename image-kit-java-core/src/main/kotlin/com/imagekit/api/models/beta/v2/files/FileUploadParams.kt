// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.beta.v2.files

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.imagekit.api.core.BaseSerializer
import com.imagekit.api.core.Enum
import com.imagekit.api.core.ExcludeMissing
import com.imagekit.api.core.JsonField
import com.imagekit.api.core.JsonMissing
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.MultipartField
import com.imagekit.api.core.Params
import com.imagekit.api.core.checkKnown
import com.imagekit.api.core.checkRequired
import com.imagekit.api.core.getOrThrow
import com.imagekit.api.core.http.Headers
import com.imagekit.api.core.http.QueryParams
import com.imagekit.api.core.toImmutable
import com.imagekit.api.errors.ImageKitInvalidDataException
import com.imagekit.api.models.UnnamedSchemaWithArrayParent4
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
    fun extensions(): Optional<List<UnnamedSchemaWithArrayParent4>> = body.extensions()

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
    fun _extensions(): MultipartField<List<UnnamedSchemaWithArrayParent4>> = body._extensions()

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
        fun extensions(extensions: List<UnnamedSchemaWithArrayParent4>) = apply {
            body.extensions(extensions)
        }

        /**
         * Sets [Builder.extensions] to an arbitrary multipart value.
         *
         * You should usually call [Builder.extensions] with a well-typed
         * `List<UnnamedSchemaWithArrayParent4>` value instead. This method is primarily for setting
         * the field to an undocumented or not yet supported value.
         */
        fun extensions(extensions: MultipartField<List<UnnamedSchemaWithArrayParent4>>) = apply {
            body.extensions(extensions)
        }

        /**
         * Adds a single [UnnamedSchemaWithArrayParent4] to [extensions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addExtension(extension: UnnamedSchemaWithArrayParent4) = apply {
            body.addExtension(extension)
        }

        /**
         * Alias for calling [addExtension] with
         * `UnnamedSchemaWithArrayParent4.ofRemoveBg(removeBg)`.
         */
        fun addExtension(removeBg: UnnamedSchemaWithArrayParent4.RemoveBg) = apply {
            body.addExtension(removeBg)
        }

        /**
         * Alias for calling [addExtension] with
         * `UnnamedSchemaWithArrayParent4.ofAutoTaggingExtension(autoTaggingExtension)`.
         */
        fun addExtension(autoTaggingExtension: UnnamedSchemaWithArrayParent4.AutoTaggingExtension) =
            apply {
                body.addExtension(autoTaggingExtension)
            }

        /**
         * Alias for calling [addExtension] with
         * `UnnamedSchemaWithArrayParent4.ofAiAutoDescription()`.
         */
        fun addExtensionAiAutoDescription() = apply { body.addExtensionAiAutoDescription() }

        /**
         * Alias for calling [addExtension] with `UnnamedSchemaWithArrayParent4.ofAiTasks(aiTasks)`.
         */
        fun addExtension(aiTasks: UnnamedSchemaWithArrayParent4.AiTasks) = apply {
            body.addExtension(aiTasks)
        }

        /**
         * Alias for calling [addExtension] with the following:
         * ```java
         * UnnamedSchemaWithArrayParent4.AiTasks.builder()
         *     .tasks(tasks)
         *     .build()
         * ```
         */
        fun addAiTasksExtension(tasks: List<UnnamedSchemaWithArrayParent4.AiTasks.Task>) = apply {
            body.addAiTasksExtension(tasks)
        }

        /**
         * Alias for calling [addExtension] with
         * `UnnamedSchemaWithArrayParent4.ofSavedExtension(savedExtension)`.
         */
        fun addExtension(savedExtension: UnnamedSchemaWithArrayParent4.SavedExtension) = apply {
            body.addExtension(savedExtension)
        }

        /**
         * Alias for calling [addExtension] with the following:
         * ```java
         * UnnamedSchemaWithArrayParent4.SavedExtension.builder()
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
        private val extensions: MultipartField<List<UnnamedSchemaWithArrayParent4>>,
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
         * Array of extensions to be applied to the asset. Each extension can be configured with
         * specific parameters based on the extension type.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun extensions(): Optional<List<UnnamedSchemaWithArrayParent4>> =
            extensions.value.getOptional("extensions")

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
        fun _extensions(): MultipartField<List<UnnamedSchemaWithArrayParent4>> = extensions

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
            private var extensions: MultipartField<MutableList<UnnamedSchemaWithArrayParent4>>? =
                null
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
            fun extensions(extensions: List<UnnamedSchemaWithArrayParent4>) =
                extensions(MultipartField.of(extensions))

            /**
             * Sets [Builder.extensions] to an arbitrary multipart value.
             *
             * You should usually call [Builder.extensions] with a well-typed
             * `List<UnnamedSchemaWithArrayParent4>` value instead. This method is primarily for
             * setting the field to an undocumented or not yet supported value.
             */
            fun extensions(extensions: MultipartField<List<UnnamedSchemaWithArrayParent4>>) =
                apply {
                    this.extensions = extensions.map { it.toMutableList() }
                }

            /**
             * Adds a single [UnnamedSchemaWithArrayParent4] to [extensions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addExtension(extension: UnnamedSchemaWithArrayParent4) = apply {
                extensions =
                    (extensions ?: MultipartField.of(mutableListOf())).also {
                        checkKnown("extensions", it).add(extension)
                    }
            }

            /**
             * Alias for calling [addExtension] with
             * `UnnamedSchemaWithArrayParent4.ofRemoveBg(removeBg)`.
             */
            fun addExtension(removeBg: UnnamedSchemaWithArrayParent4.RemoveBg) =
                addExtension(UnnamedSchemaWithArrayParent4.ofRemoveBg(removeBg))

            /**
             * Alias for calling [addExtension] with
             * `UnnamedSchemaWithArrayParent4.ofAutoTaggingExtension(autoTaggingExtension)`.
             */
            fun addExtension(
                autoTaggingExtension: UnnamedSchemaWithArrayParent4.AutoTaggingExtension
            ) =
                addExtension(
                    UnnamedSchemaWithArrayParent4.ofAutoTaggingExtension(autoTaggingExtension)
                )

            /**
             * Alias for calling [addExtension] with
             * `UnnamedSchemaWithArrayParent4.ofAiAutoDescription()`.
             */
            fun addExtensionAiAutoDescription() =
                addExtension(UnnamedSchemaWithArrayParent4.ofAiAutoDescription())

            /**
             * Alias for calling [addExtension] with
             * `UnnamedSchemaWithArrayParent4.ofAiTasks(aiTasks)`.
             */
            fun addExtension(aiTasks: UnnamedSchemaWithArrayParent4.AiTasks) =
                addExtension(UnnamedSchemaWithArrayParent4.ofAiTasks(aiTasks))

            /**
             * Alias for calling [addExtension] with the following:
             * ```java
             * UnnamedSchemaWithArrayParent4.AiTasks.builder()
             *     .tasks(tasks)
             *     .build()
             * ```
             */
            fun addAiTasksExtension(tasks: List<UnnamedSchemaWithArrayParent4.AiTasks.Task>) =
                addExtension(UnnamedSchemaWithArrayParent4.AiTasks.builder().tasks(tasks).build())

            /**
             * Alias for calling [addExtension] with
             * `UnnamedSchemaWithArrayParent4.ofSavedExtension(savedExtension)`.
             */
            fun addExtension(savedExtension: UnnamedSchemaWithArrayParent4.SavedExtension) =
                addExtension(UnnamedSchemaWithArrayParent4.ofSavedExtension(savedExtension))

            /**
             * Alias for calling [addExtension] with the following:
             * ```java
             * UnnamedSchemaWithArrayParent4.SavedExtension.builder()
             *     .id(id)
             *     .build()
             * ```
             */
            fun addSavedExtensionExtension(id: String) =
                addExtension(UnnamedSchemaWithArrayParent4.SavedExtension.builder().id(id).build())

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

    @JsonSerialize(using = UnnamedSchemaWithArrayParent4.Serializer::class)
    class UnnamedSchemaWithArrayParent4
    private constructor(
        private val removeBg: RemoveBg? = null,
        private val autoTaggingExtension: AutoTaggingExtension? = null,
        private val aiAutoDescription: JsonValue? = null,
        private val aiTasks: AiTasks? = null,
        private val savedExtension: SavedExtension? = null,
        private val _json: JsonValue? = null,
    ) {

        fun removeBg(): Optional<RemoveBg> = Optional.ofNullable(removeBg)

        fun autoTaggingExtension(): Optional<AutoTaggingExtension> =
            Optional.ofNullable(autoTaggingExtension)

        fun aiAutoDescription(): Optional<JsonValue> = Optional.ofNullable(aiAutoDescription)

        fun aiTasks(): Optional<AiTasks> = Optional.ofNullable(aiTasks)

        fun savedExtension(): Optional<SavedExtension> = Optional.ofNullable(savedExtension)

        fun isRemoveBg(): Boolean = removeBg != null

        fun isAutoTaggingExtension(): Boolean = autoTaggingExtension != null

        fun isAiAutoDescription(): Boolean = aiAutoDescription != null

        fun isAiTasks(): Boolean = aiTasks != null

        fun isSavedExtension(): Boolean = savedExtension != null

        fun asRemoveBg(): RemoveBg = removeBg.getOrThrow("removeBg")

        fun asAutoTaggingExtension(): AutoTaggingExtension =
            autoTaggingExtension.getOrThrow("autoTaggingExtension")

        fun asAiAutoDescription(): JsonValue = aiAutoDescription.getOrThrow("aiAutoDescription")

        fun asAiTasks(): AiTasks = aiTasks.getOrThrow("aiTasks")

        fun asSavedExtension(): SavedExtension = savedExtension.getOrThrow("savedExtension")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                removeBg != null -> visitor.visitRemoveBg(removeBg)
                autoTaggingExtension != null ->
                    visitor.visitAutoTaggingExtension(autoTaggingExtension)
                aiAutoDescription != null -> visitor.visitAiAutoDescription(aiAutoDescription)
                aiTasks != null -> visitor.visitAiTasks(aiTasks)
                savedExtension != null -> visitor.visitSavedExtension(savedExtension)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): UnnamedSchemaWithArrayParent4 = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitRemoveBg(removeBg: RemoveBg) {
                        removeBg.validate()
                    }

                    override fun visitAutoTaggingExtension(
                        autoTaggingExtension: AutoTaggingExtension
                    ) {
                        autoTaggingExtension.validate()
                    }

                    override fun visitAiAutoDescription(aiAutoDescription: JsonValue) {
                        aiAutoDescription.let {
                            if (it != JsonValue.from(mapOf("name" to "ai-auto-description"))) {
                                throw ImageKitInvalidDataException(
                                    "'aiAutoDescription' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitAiTasks(aiTasks: AiTasks) {
                        aiTasks.validate()
                    }

                    override fun visitSavedExtension(savedExtension: SavedExtension) {
                        savedExtension.validate()
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

            return other is UnnamedSchemaWithArrayParent4 &&
                removeBg == other.removeBg &&
                autoTaggingExtension == other.autoTaggingExtension &&
                aiAutoDescription == other.aiAutoDescription &&
                aiTasks == other.aiTasks &&
                savedExtension == other.savedExtension
        }

        override fun hashCode(): Int =
            Objects.hash(removeBg, autoTaggingExtension, aiAutoDescription, aiTasks, savedExtension)

        override fun toString(): String =
            when {
                removeBg != null -> "UnnamedSchemaWithArrayParent4{removeBg=$removeBg}"
                autoTaggingExtension != null ->
                    "UnnamedSchemaWithArrayParent4{autoTaggingExtension=$autoTaggingExtension}"
                aiAutoDescription != null ->
                    "UnnamedSchemaWithArrayParent4{aiAutoDescription=$aiAutoDescription}"
                aiTasks != null -> "UnnamedSchemaWithArrayParent4{aiTasks=$aiTasks}"
                savedExtension != null ->
                    "UnnamedSchemaWithArrayParent4{savedExtension=$savedExtension}"
                _json != null -> "UnnamedSchemaWithArrayParent4{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid UnnamedSchemaWithArrayParent4")
            }

        companion object {

            @JvmStatic
            fun ofRemoveBg(removeBg: RemoveBg) = UnnamedSchemaWithArrayParent4(removeBg = removeBg)

            @JvmStatic
            fun ofAutoTaggingExtension(autoTaggingExtension: AutoTaggingExtension) =
                UnnamedSchemaWithArrayParent4(autoTaggingExtension = autoTaggingExtension)

            @JvmStatic
            fun ofAiAutoDescription() =
                UnnamedSchemaWithArrayParent4(
                    aiAutoDescription = JsonValue.from(mapOf("name" to "ai-auto-description"))
                )

            @JvmStatic
            fun ofAiTasks(aiTasks: AiTasks) = UnnamedSchemaWithArrayParent4(aiTasks = aiTasks)

            @JvmStatic
            fun ofSavedExtension(savedExtension: SavedExtension) =
                UnnamedSchemaWithArrayParent4(savedExtension = savedExtension)
        }

        /**
         * An interface that defines how to map each variant of [UnnamedSchemaWithArrayParent4] to a
         * value of type [T].
         */
        interface Visitor<out T> {

            fun visitRemoveBg(removeBg: RemoveBg): T

            fun visitAutoTaggingExtension(autoTaggingExtension: AutoTaggingExtension): T

            fun visitAiAutoDescription(aiAutoDescription: JsonValue): T

            fun visitAiTasks(aiTasks: AiTasks): T

            fun visitSavedExtension(savedExtension: SavedExtension): T

            /**
             * Maps an unknown variant of [UnnamedSchemaWithArrayParent4] to a value of type [T].
             *
             * An instance of [UnnamedSchemaWithArrayParent4] can contain an unknown variant if it
             * was deserialized from data that doesn't match any known variant. For example, if the
             * SDK is on an older version than the API, then the API may respond with new variants
             * that the SDK is unaware of.
             *
             * @throws ImageKitInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw ImageKitInvalidDataException("Unknown UnnamedSchemaWithArrayParent4: $json")
            }
        }

        internal class Serializer :
            BaseSerializer<UnnamedSchemaWithArrayParent4>(UnnamedSchemaWithArrayParent4::class) {

            override fun serialize(
                value: UnnamedSchemaWithArrayParent4,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.removeBg != null -> generator.writeObject(value.removeBg)
                    value.autoTaggingExtension != null ->
                        generator.writeObject(value.autoTaggingExtension)
                    value.aiAutoDescription != null ->
                        generator.writeObject(value.aiAutoDescription)
                    value.aiTasks != null -> generator.writeObject(value.aiTasks)
                    value.savedExtension != null -> generator.writeObject(value.savedExtension)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid UnnamedSchemaWithArrayParent4")
                }
            }
        }

        class RemoveBg
        private constructor(
            private val name: JsonValue,
            private val options: JsonField<Options>,
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
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonValue = name

            /**
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun options(): Optional<Options> = options.getOptional("options")

            /**
             * Returns the raw JSON value of [options].
             *
             * Unlike [options], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("options") @ExcludeMissing fun _options(): JsonField<Options> = options

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
                private var options: JsonField<Options> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(removeBg: RemoveBg) = apply {
                    name = removeBg.name
                    options = removeBg.options
                    additionalProperties = removeBg.additionalProperties.toMutableMap()
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("remove-bg")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonValue) = apply { this.name = name }

                fun options(options: Options) = options(JsonField.of(options))

                /**
                 * Sets [Builder.options] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.options] with a well-typed [Options] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun options(options: JsonField<Options>) = apply { this.options = options }

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
                 * Returns an immutable instance of [RemoveBg].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): RemoveBg = RemoveBg(name, options, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): RemoveBg = apply {
                if (validated) {
                    return@apply
                }

                _name().let {
                    if (it != JsonValue.from("remove-bg")) {
                        throw ImageKitInvalidDataException("'name' is invalid, received $it")
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
                private val addShadow: JsonField<Boolean>,
                private val bgColor: JsonField<String>,
                private val bgImageUrl: JsonField<String>,
                private val semitransparency: JsonField<Boolean>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                /**
                 * Whether to add an artificial shadow to the result. Default is false. Note: Adding
                 * shadows is currently only supported for car photos.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun addShadow(): Optional<Boolean> = addShadow.getOptional("add_shadow")

                /**
                 * Specifies a solid color background using hex code (e.g., "81d4fa", "fff") or
                 * color name (e.g., "green"). If this parameter is set, `bg_image_url` must be
                 * empty.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun bgColor(): Optional<String> = bgColor.getOptional("bg_color")

                /**
                 * Sets a background image from a URL. If this parameter is set, `bg_color` must be
                 * empty.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun bgImageUrl(): Optional<String> = bgImageUrl.getOptional("bg_image_url")

                /**
                 * Allows semi-transparent regions in the result. Default is true. Note:
                 * Semitransparency is currently only supported for car windows.
                 *
                 * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun semitransparency(): Optional<Boolean> =
                    semitransparency.getOptional("semitransparency")

                /**
                 * Returns the raw JSON value of [addShadow].
                 *
                 * Unlike [addShadow], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("add_shadow")
                @ExcludeMissing
                fun _addShadow(): JsonField<Boolean> = addShadow

                /**
                 * Returns the raw JSON value of [bgColor].
                 *
                 * Unlike [bgColor], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("bg_color")
                @ExcludeMissing
                fun _bgColor(): JsonField<String> = bgColor

                /**
                 * Returns the raw JSON value of [bgImageUrl].
                 *
                 * Unlike [bgImageUrl], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("bg_image_url")
                @ExcludeMissing
                fun _bgImageUrl(): JsonField<String> = bgImageUrl

                /**
                 * Returns the raw JSON value of [semitransparency].
                 *
                 * Unlike [semitransparency], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("semitransparency")
                @ExcludeMissing
                fun _semitransparency(): JsonField<Boolean> = semitransparency

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

                    private var addShadow: JsonField<Boolean> = JsonMissing.of()
                    private var bgColor: JsonField<String> = JsonMissing.of()
                    private var bgImageUrl: JsonField<String> = JsonMissing.of()
                    private var semitransparency: JsonField<Boolean> = JsonMissing.of()
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
                    fun addShadow(addShadow: Boolean) = addShadow(JsonField.of(addShadow))

                    /**
                     * Sets [Builder.addShadow] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.addShadow] with a well-typed [Boolean] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun addShadow(addShadow: JsonField<Boolean>) = apply {
                        this.addShadow = addShadow
                    }

                    /**
                     * Specifies a solid color background using hex code (e.g., "81d4fa", "fff") or
                     * color name (e.g., "green"). If this parameter is set, `bg_image_url` must be
                     * empty.
                     */
                    fun bgColor(bgColor: String) = bgColor(JsonField.of(bgColor))

                    /**
                     * Sets [Builder.bgColor] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.bgColor] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun bgColor(bgColor: JsonField<String>) = apply { this.bgColor = bgColor }

                    /**
                     * Sets a background image from a URL. If this parameter is set, `bg_color` must
                     * be empty.
                     */
                    fun bgImageUrl(bgImageUrl: String) = bgImageUrl(JsonField.of(bgImageUrl))

                    /**
                     * Sets [Builder.bgImageUrl] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.bgImageUrl] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun bgImageUrl(bgImageUrl: JsonField<String>) = apply {
                        this.bgImageUrl = bgImageUrl
                    }

                    /**
                     * Allows semi-transparent regions in the result. Default is true. Note:
                     * Semitransparency is currently only supported for car windows.
                     */
                    fun semitransparency(semitransparency: Boolean) =
                        semitransparency(JsonField.of(semitransparency))

                    /**
                     * Sets [Builder.semitransparency] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.semitransparency] with a well-typed
                     * [Boolean] value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun semitransparency(semitransparency: JsonField<Boolean>) = apply {
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

                return other is RemoveBg &&
                    name == other.name &&
                    options == other.options &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(name, options, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "RemoveBg{name=$name, options=$options, additionalProperties=$additionalProperties}"
        }

        class AutoTaggingExtension
        private constructor(
            private val maxTags: JsonField<Long>,
            private val minConfidence: JsonField<Long>,
            private val name: JsonField<Name>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            /**
             * Maximum number of tags to attach to the asset.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun maxTags(): Long = maxTags.getRequired("maxTags")

            /**
             * Minimum confidence level for tags to be considered valid.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun minConfidence(): Long = minConfidence.getRequired("minConfidence")

            /**
             * Specifies the auto-tagging extension used.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): Name = name.getRequired("name")

            /**
             * Returns the raw JSON value of [maxTags].
             *
             * Unlike [maxTags], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("maxTags") @ExcludeMissing fun _maxTags(): JsonField<Long> = maxTags

            /**
             * Returns the raw JSON value of [minConfidence].
             *
             * Unlike [minConfidence], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("minConfidence")
            @ExcludeMissing
            fun _minConfidence(): JsonField<Long> = minConfidence

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<Name> = name

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

                private var maxTags: JsonField<Long>? = null
                private var minConfidence: JsonField<Long>? = null
                private var name: JsonField<Name>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(autoTaggingExtension: AutoTaggingExtension) = apply {
                    maxTags = autoTaggingExtension.maxTags
                    minConfidence = autoTaggingExtension.minConfidence
                    name = autoTaggingExtension.name
                    additionalProperties = autoTaggingExtension.additionalProperties.toMutableMap()
                }

                /** Maximum number of tags to attach to the asset. */
                fun maxTags(maxTags: Long) = maxTags(JsonField.of(maxTags))

                /**
                 * Sets [Builder.maxTags] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.maxTags] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun maxTags(maxTags: JsonField<Long>) = apply { this.maxTags = maxTags }

                /** Minimum confidence level for tags to be considered valid. */
                fun minConfidence(minConfidence: Long) = minConfidence(JsonField.of(minConfidence))

                /**
                 * Sets [Builder.minConfidence] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.minConfidence] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun minConfidence(minConfidence: JsonField<Long>) = apply {
                    this.minConfidence = minConfidence
                }

                /** Specifies the auto-tagging extension used. */
                fun name(name: Name) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [Name] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<Name>) = apply { this.name = name }

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

        class AiTasks
        private constructor(
            private val name: JsonValue,
            private val tasks: JsonField<List<Task>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            /**
             * Specifies the AI tasks extension for automated image analysis using AI models.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("ai-tasks")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonValue = name

            /**
             * Array of task objects defining AI operations to perform on the asset.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun tasks(): List<Task> = tasks.getRequired("tasks")

            /**
             * Returns the raw JSON value of [tasks].
             *
             * Unlike [tasks], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("tasks") @ExcludeMissing fun _tasks(): JsonField<List<Task>> = tasks

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
                 * Returns a mutable builder for constructing an instance of [AiTasks].
                 *
                 * The following fields are required:
                 * ```java
                 * .tasks()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [AiTasks]. */
            class Builder internal constructor() {

                private var name: JsonValue = JsonValue.from("ai-tasks")
                private var tasks: JsonField<MutableList<Task>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(aiTasks: AiTasks) = apply {
                    name = aiTasks.name
                    tasks = aiTasks.tasks.map { it.toMutableList() }
                    additionalProperties = aiTasks.additionalProperties.toMutableMap()
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("ai-tasks")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonValue) = apply { this.name = name }

                /** Array of task objects defining AI operations to perform on the asset. */
                fun tasks(tasks: List<Task>) = tasks(JsonField.of(tasks))

                /**
                 * Sets [Builder.tasks] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.tasks] with a well-typed `List<Task>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun tasks(tasks: JsonField<List<Task>>) = apply {
                    this.tasks = tasks.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Task] to [tasks].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addTask(task: Task) = apply {
                    tasks =
                        (tasks ?: JsonField.of(mutableListOf())).also {
                            checkKnown("tasks", it).add(task)
                        }
                }

                /** Alias for calling [addTask] with `Task.ofSelectTags(selectTags)`. */
                fun addTask(selectTags: Task.SelectTags) = addTask(Task.ofSelectTags(selectTags))

                /**
                 * Alias for calling [addTask] with the following:
                 * ```java
                 * Task.SelectTags.builder()
                 *     .instruction(instruction)
                 *     .build()
                 * ```
                 */
                fun addSelectTagsTask(instruction: String) =
                    addTask(Task.SelectTags.builder().instruction(instruction).build())

                /** Alias for calling [addTask] with `Task.ofSelectMetadata(selectMetadata)`. */
                fun addTask(selectMetadata: Task.SelectMetadata) =
                    addTask(Task.ofSelectMetadata(selectMetadata))

                /** Alias for calling [addTask] with `Task.ofYesNo(yesNo)`. */
                fun addTask(yesNo: Task.YesNo) = addTask(Task.ofYesNo(yesNo))

                /**
                 * Alias for calling [addTask] with the following:
                 * ```java
                 * Task.YesNo.builder()
                 *     .instruction(instruction)
                 *     .build()
                 * ```
                 */
                fun addYesNoTask(instruction: String) =
                    addTask(Task.YesNo.builder().instruction(instruction).build())

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
                 * Returns an immutable instance of [AiTasks].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .tasks()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): AiTasks =
                    AiTasks(
                        name,
                        checkRequired("tasks", tasks).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): AiTasks = apply {
                if (validated) {
                    return@apply
                }

                _name().let {
                    if (it != JsonValue.from("ai-tasks")) {
                        throw ImageKitInvalidDataException("'name' is invalid, received $it")
                    }
                }
                tasks().forEach { it.validate() }
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            @JsonSerialize(using = Task.Serializer::class)
            class Task
            private constructor(
                private val selectTags: SelectTags? = null,
                private val selectMetadata: SelectMetadata? = null,
                private val yesNo: YesNo? = null,
                private val _json: JsonValue? = null,
            ) {

                fun selectTags(): Optional<SelectTags> = Optional.ofNullable(selectTags)

                fun selectMetadata(): Optional<SelectMetadata> = Optional.ofNullable(selectMetadata)

                fun yesNo(): Optional<YesNo> = Optional.ofNullable(yesNo)

                fun isSelectTags(): Boolean = selectTags != null

                fun isSelectMetadata(): Boolean = selectMetadata != null

                fun isYesNo(): Boolean = yesNo != null

                fun asSelectTags(): SelectTags = selectTags.getOrThrow("selectTags")

                fun asSelectMetadata(): SelectMetadata = selectMetadata.getOrThrow("selectMetadata")

                fun asYesNo(): YesNo = yesNo.getOrThrow("yesNo")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        selectTags != null -> visitor.visitSelectTags(selectTags)
                        selectMetadata != null -> visitor.visitSelectMetadata(selectMetadata)
                        yesNo != null -> visitor.visitYesNo(yesNo)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                fun validate(): Task = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitSelectTags(selectTags: SelectTags) {
                                selectTags.validate()
                            }

                            override fun visitSelectMetadata(selectMetadata: SelectMetadata) {
                                selectMetadata.validate()
                            }

                            override fun visitYesNo(yesNo: YesNo) {
                                yesNo.validate()
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

                    return other is Task &&
                        selectTags == other.selectTags &&
                        selectMetadata == other.selectMetadata &&
                        yesNo == other.yesNo
                }

                override fun hashCode(): Int = Objects.hash(selectTags, selectMetadata, yesNo)

                override fun toString(): String =
                    when {
                        selectTags != null -> "Task{selectTags=$selectTags}"
                        selectMetadata != null -> "Task{selectMetadata=$selectMetadata}"
                        yesNo != null -> "Task{yesNo=$yesNo}"
                        _json != null -> "Task{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Task")
                    }

                companion object {

                    @JvmStatic
                    fun ofSelectTags(selectTags: SelectTags) = Task(selectTags = selectTags)

                    @JvmStatic
                    fun ofSelectMetadata(selectMetadata: SelectMetadata) =
                        Task(selectMetadata = selectMetadata)

                    @JvmStatic fun ofYesNo(yesNo: YesNo) = Task(yesNo = yesNo)
                }

                /**
                 * An interface that defines how to map each variant of [Task] to a value of type
                 * [T].
                 */
                interface Visitor<out T> {

                    fun visitSelectTags(selectTags: SelectTags): T

                    fun visitSelectMetadata(selectMetadata: SelectMetadata): T

                    fun visitYesNo(yesNo: YesNo): T

                    /**
                     * Maps an unknown variant of [Task] to a value of type [T].
                     *
                     * An instance of [Task] can contain an unknown variant if it was deserialized
                     * from data that doesn't match any known variant. For example, if the SDK is on
                     * an older version than the API, then the API may respond with new variants
                     * that the SDK is unaware of.
                     *
                     * @throws ImageKitInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw ImageKitInvalidDataException("Unknown Task: $json")
                    }
                }

                internal class Serializer : BaseSerializer<Task>(Task::class) {

                    override fun serialize(
                        value: Task,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.selectTags != null -> generator.writeObject(value.selectTags)
                            value.selectMetadata != null ->
                                generator.writeObject(value.selectMetadata)
                            value.yesNo != null -> generator.writeObject(value.yesNo)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Task")
                        }
                    }
                }

                class SelectTags
                private constructor(
                    private val instruction: JsonField<String>,
                    private val type: JsonValue,
                    private val maxSelections: JsonField<Long>,
                    private val minSelections: JsonField<Long>,
                    private val vocabulary: JsonField<List<String>>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    /**
                     * The question or instruction for the AI to analyze the image.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun instruction(): String = instruction.getRequired("instruction")

                    /**
                     * Task type that analyzes the image and adds matching tags from a vocabulary.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("select_tags")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * Maximum number of tags to select from the vocabulary.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun maxSelections(): Optional<Long> =
                        maxSelections.getOptional("max_selections")

                    /**
                     * Minimum number of tags to select from the vocabulary.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun minSelections(): Optional<Long> =
                        minSelections.getOptional("min_selections")

                    /**
                     * Array of possible tag values. The combined length of all strings must not
                     * exceed 500 characters, and values cannot include the `%` character. When
                     * providing large vocabularies (more than 30 items), the AI may not follow the
                     * list strictly.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun vocabulary(): Optional<List<String>> = vocabulary.getOptional("vocabulary")

                    /**
                     * Returns the raw JSON value of [instruction].
                     *
                     * Unlike [instruction], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("instruction")
                    @ExcludeMissing
                    fun _instruction(): JsonField<String> = instruction

                    /**
                     * Returns the raw JSON value of [maxSelections].
                     *
                     * Unlike [maxSelections], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("max_selections")
                    @ExcludeMissing
                    fun _maxSelections(): JsonField<Long> = maxSelections

                    /**
                     * Returns the raw JSON value of [minSelections].
                     *
                     * Unlike [minSelections], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("min_selections")
                    @ExcludeMissing
                    fun _minSelections(): JsonField<Long> = minSelections

                    /**
                     * Returns the raw JSON value of [vocabulary].
                     *
                     * Unlike [vocabulary], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("vocabulary")
                    @ExcludeMissing
                    fun _vocabulary(): JsonField<List<String>> = vocabulary

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
                         * Returns a mutable builder for constructing an instance of [SelectTags].
                         *
                         * The following fields are required:
                         * ```java
                         * .instruction()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [SelectTags]. */
                    class Builder internal constructor() {

                        private var instruction: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("select_tags")
                        private var maxSelections: JsonField<Long> = JsonMissing.of()
                        private var minSelections: JsonField<Long> = JsonMissing.of()
                        private var vocabulary: JsonField<MutableList<String>>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(selectTags: SelectTags) = apply {
                            instruction = selectTags.instruction
                            type = selectTags.type
                            maxSelections = selectTags.maxSelections
                            minSelections = selectTags.minSelections
                            vocabulary = selectTags.vocabulary.map { it.toMutableList() }
                            additionalProperties = selectTags.additionalProperties.toMutableMap()
                        }

                        /** The question or instruction for the AI to analyze the image. */
                        fun instruction(instruction: String) =
                            instruction(JsonField.of(instruction))

                        /**
                         * Sets [Builder.instruction] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.instruction] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun instruction(instruction: JsonField<String>) = apply {
                            this.instruction = instruction
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("select_tags")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        /** Maximum number of tags to select from the vocabulary. */
                        fun maxSelections(maxSelections: Long) =
                            maxSelections(JsonField.of(maxSelections))

                        /**
                         * Sets [Builder.maxSelections] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.maxSelections] with a well-typed [Long]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun maxSelections(maxSelections: JsonField<Long>) = apply {
                            this.maxSelections = maxSelections
                        }

                        /** Minimum number of tags to select from the vocabulary. */
                        fun minSelections(minSelections: Long) =
                            minSelections(JsonField.of(minSelections))

                        /**
                         * Sets [Builder.minSelections] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.minSelections] with a well-typed [Long]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun minSelections(minSelections: JsonField<Long>) = apply {
                            this.minSelections = minSelections
                        }

                        /**
                         * Array of possible tag values. The combined length of all strings must not
                         * exceed 500 characters, and values cannot include the `%` character. When
                         * providing large vocabularies (more than 30 items), the AI may not follow
                         * the list strictly.
                         */
                        fun vocabulary(vocabulary: List<String>) =
                            vocabulary(JsonField.of(vocabulary))

                        /**
                         * Sets [Builder.vocabulary] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.vocabulary] with a well-typed
                         * `List<String>` value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun vocabulary(vocabulary: JsonField<List<String>>) = apply {
                            this.vocabulary = vocabulary.map { it.toMutableList() }
                        }

                        /**
                         * Adds a single [String] to [Builder.vocabulary].
                         *
                         * @throws IllegalStateException if the field was previously set to a
                         *   non-list.
                         */
                        fun addVocabulary(vocabulary: String) = apply {
                            this.vocabulary =
                                (this.vocabulary ?: JsonField.of(mutableListOf())).also {
                                    checkKnown("vocabulary", it).add(vocabulary)
                                }
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
                         * Returns an immutable instance of [SelectTags].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .instruction()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): SelectTags =
                            SelectTags(
                                checkRequired("instruction", instruction),
                                type,
                                maxSelections,
                                minSelections,
                                (vocabulary ?: JsonMissing.of()).map { it.toImmutable() },
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): SelectTags = apply {
                        if (validated) {
                            return@apply
                        }

                        instruction()
                        _type().let {
                            if (it != JsonValue.from("select_tags")) {
                                throw ImageKitInvalidDataException(
                                    "'type' is invalid, received $it"
                                )
                            }
                        }
                        maxSelections()
                        minSelections()
                        vocabulary()
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

                        return other is SelectTags &&
                            instruction == other.instruction &&
                            type == other.type &&
                            maxSelections == other.maxSelections &&
                            minSelections == other.minSelections &&
                            vocabulary == other.vocabulary &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(
                            instruction,
                            type,
                            maxSelections,
                            minSelections,
                            vocabulary,
                            additionalProperties,
                        )
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "SelectTags{instruction=$instruction, type=$type, maxSelections=$maxSelections, minSelections=$minSelections, vocabulary=$vocabulary, additionalProperties=$additionalProperties}"
                }

                class SelectMetadata
                private constructor(
                    private val field: JsonField<String>,
                    private val instruction: JsonField<String>,
                    private val type: JsonValue,
                    private val maxSelections: JsonField<Long>,
                    private val minSelections: JsonField<Long>,
                    private val vocabulary: JsonField<List<Vocabulary>>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    /**
                     * Name of the custom metadata field to set. The field must exist in your
                     * account.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun field(): String = field.getRequired("field")

                    /**
                     * The question or instruction for the AI to analyze the image.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun instruction(): String = instruction.getRequired("instruction")

                    /**
                     * Task type that analyzes the image and sets a custom metadata field value from
                     * a vocabulary.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("select_metadata")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * Maximum number of values to select from the vocabulary.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun maxSelections(): Optional<Long> =
                        maxSelections.getOptional("max_selections")

                    /**
                     * Minimum number of values to select from the vocabulary.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun minSelections(): Optional<Long> =
                        minSelections.getOptional("min_selections")

                    /**
                     * An array of possible values matching the custom metadata field type. If not
                     * provided for SingleSelect or MultiSelect field types, all values from the
                     * custom metadata field definition will be used. When providing large
                     * vocabularies (above 30 items), the AI may not strictly adhere to the list.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun vocabulary(): Optional<List<Vocabulary>> =
                        vocabulary.getOptional("vocabulary")

                    /**
                     * Returns the raw JSON value of [field].
                     *
                     * Unlike [field], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("field") @ExcludeMissing fun _field(): JsonField<String> = field

                    /**
                     * Returns the raw JSON value of [instruction].
                     *
                     * Unlike [instruction], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("instruction")
                    @ExcludeMissing
                    fun _instruction(): JsonField<String> = instruction

                    /**
                     * Returns the raw JSON value of [maxSelections].
                     *
                     * Unlike [maxSelections], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("max_selections")
                    @ExcludeMissing
                    fun _maxSelections(): JsonField<Long> = maxSelections

                    /**
                     * Returns the raw JSON value of [minSelections].
                     *
                     * Unlike [minSelections], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("min_selections")
                    @ExcludeMissing
                    fun _minSelections(): JsonField<Long> = minSelections

                    /**
                     * Returns the raw JSON value of [vocabulary].
                     *
                     * Unlike [vocabulary], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("vocabulary")
                    @ExcludeMissing
                    fun _vocabulary(): JsonField<List<Vocabulary>> = vocabulary

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
                         * [SelectMetadata].
                         *
                         * The following fields are required:
                         * ```java
                         * .field()
                         * .instruction()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [SelectMetadata]. */
                    class Builder internal constructor() {

                        private var field: JsonField<String>? = null
                        private var instruction: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("select_metadata")
                        private var maxSelections: JsonField<Long> = JsonMissing.of()
                        private var minSelections: JsonField<Long> = JsonMissing.of()
                        private var vocabulary: JsonField<MutableList<Vocabulary>>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(selectMetadata: SelectMetadata) = apply {
                            field = selectMetadata.field
                            instruction = selectMetadata.instruction
                            type = selectMetadata.type
                            maxSelections = selectMetadata.maxSelections
                            minSelections = selectMetadata.minSelections
                            vocabulary = selectMetadata.vocabulary.map { it.toMutableList() }
                            additionalProperties =
                                selectMetadata.additionalProperties.toMutableMap()
                        }

                        /**
                         * Name of the custom metadata field to set. The field must exist in your
                         * account.
                         */
                        fun field(field: String) = field(JsonField.of(field))

                        /**
                         * Sets [Builder.field] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.field] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun field(field: JsonField<String>) = apply { this.field = field }

                        /** The question or instruction for the AI to analyze the image. */
                        fun instruction(instruction: String) =
                            instruction(JsonField.of(instruction))

                        /**
                         * Sets [Builder.instruction] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.instruction] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun instruction(instruction: JsonField<String>) = apply {
                            this.instruction = instruction
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("select_metadata")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        /** Maximum number of values to select from the vocabulary. */
                        fun maxSelections(maxSelections: Long) =
                            maxSelections(JsonField.of(maxSelections))

                        /**
                         * Sets [Builder.maxSelections] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.maxSelections] with a well-typed [Long]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun maxSelections(maxSelections: JsonField<Long>) = apply {
                            this.maxSelections = maxSelections
                        }

                        /** Minimum number of values to select from the vocabulary. */
                        fun minSelections(minSelections: Long) =
                            minSelections(JsonField.of(minSelections))

                        /**
                         * Sets [Builder.minSelections] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.minSelections] with a well-typed [Long]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun minSelections(minSelections: JsonField<Long>) = apply {
                            this.minSelections = minSelections
                        }

                        /**
                         * An array of possible values matching the custom metadata field type. If
                         * not provided for SingleSelect or MultiSelect field types, all values from
                         * the custom metadata field definition will be used. When providing large
                         * vocabularies (above 30 items), the AI may not strictly adhere to the
                         * list.
                         */
                        fun vocabulary(vocabulary: List<Vocabulary>) =
                            vocabulary(JsonField.of(vocabulary))

                        /**
                         * Sets [Builder.vocabulary] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.vocabulary] with a well-typed
                         * `List<Vocabulary>` value instead. This method is primarily for setting
                         * the field to an undocumented or not yet supported value.
                         */
                        fun vocabulary(vocabulary: JsonField<List<Vocabulary>>) = apply {
                            this.vocabulary = vocabulary.map { it.toMutableList() }
                        }

                        /**
                         * Adds a single [Vocabulary] to [Builder.vocabulary].
                         *
                         * @throws IllegalStateException if the field was previously set to a
                         *   non-list.
                         */
                        fun addVocabulary(vocabulary: Vocabulary) = apply {
                            this.vocabulary =
                                (this.vocabulary ?: JsonField.of(mutableListOf())).also {
                                    checkKnown("vocabulary", it).add(vocabulary)
                                }
                        }

                        /** Alias for calling [addVocabulary] with `Vocabulary.ofString(string)`. */
                        fun addVocabulary(string: String) =
                            addVocabulary(Vocabulary.ofString(string))

                        /** Alias for calling [addVocabulary] with `Vocabulary.ofNumber(number)`. */
                        fun addVocabulary(number: Double) =
                            addVocabulary(Vocabulary.ofNumber(number))

                        /** Alias for calling [addVocabulary] with `Vocabulary.ofBool(bool)`. */
                        fun addVocabulary(bool: Boolean) = addVocabulary(Vocabulary.ofBool(bool))

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
                         * Returns an immutable instance of [SelectMetadata].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .field()
                         * .instruction()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): SelectMetadata =
                            SelectMetadata(
                                checkRequired("field", field),
                                checkRequired("instruction", instruction),
                                type,
                                maxSelections,
                                minSelections,
                                (vocabulary ?: JsonMissing.of()).map { it.toImmutable() },
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): SelectMetadata = apply {
                        if (validated) {
                            return@apply
                        }

                        field()
                        instruction()
                        _type().let {
                            if (it != JsonValue.from("select_metadata")) {
                                throw ImageKitInvalidDataException(
                                    "'type' is invalid, received $it"
                                )
                            }
                        }
                        maxSelections()
                        minSelections()
                        vocabulary().ifPresent { it.forEach { it.validate() } }
                        validated = true
                    }

                    fun isValid(): Boolean =
                        try {
                            validate()
                            true
                        } catch (e: ImageKitInvalidDataException) {
                            false
                        }

                    @JsonSerialize(using = Vocabulary.Serializer::class)
                    class Vocabulary
                    private constructor(
                        private val string: String? = null,
                        private val number: Double? = null,
                        private val bool: Boolean? = null,
                        private val _json: JsonValue? = null,
                    ) {

                        fun string(): Optional<String> = Optional.ofNullable(string)

                        fun number(): Optional<Double> = Optional.ofNullable(number)

                        fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

                        fun isString(): Boolean = string != null

                        fun isNumber(): Boolean = number != null

                        fun isBool(): Boolean = bool != null

                        fun asString(): String = string.getOrThrow("string")

                        fun asNumber(): Double = number.getOrThrow("number")

                        fun asBool(): Boolean = bool.getOrThrow("bool")

                        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                        fun <T> accept(visitor: Visitor<T>): T =
                            when {
                                string != null -> visitor.visitString(string)
                                number != null -> visitor.visitNumber(number)
                                bool != null -> visitor.visitBool(bool)
                                else -> visitor.unknown(_json)
                            }

                        private var validated: Boolean = false

                        fun validate(): Vocabulary = apply {
                            if (validated) {
                                return@apply
                            }

                            accept(
                                object : Visitor<Unit> {
                                    override fun visitString(string: String) {}

                                    override fun visitNumber(number: Double) {}

                                    override fun visitBool(bool: Boolean) {}
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

                            return other is Vocabulary &&
                                string == other.string &&
                                number == other.number &&
                                bool == other.bool
                        }

                        override fun hashCode(): Int = Objects.hash(string, number, bool)

                        override fun toString(): String =
                            when {
                                string != null -> "Vocabulary{string=$string}"
                                number != null -> "Vocabulary{number=$number}"
                                bool != null -> "Vocabulary{bool=$bool}"
                                _json != null -> "Vocabulary{_unknown=$_json}"
                                else -> throw IllegalStateException("Invalid Vocabulary")
                            }

                        companion object {

                            @JvmStatic fun ofString(string: String) = Vocabulary(string = string)

                            @JvmStatic fun ofNumber(number: Double) = Vocabulary(number = number)

                            @JvmStatic fun ofBool(bool: Boolean) = Vocabulary(bool = bool)
                        }

                        /**
                         * An interface that defines how to map each variant of [Vocabulary] to a
                         * value of type [T].
                         */
                        interface Visitor<out T> {

                            fun visitString(string: String): T

                            fun visitNumber(number: Double): T

                            fun visitBool(bool: Boolean): T

                            /**
                             * Maps an unknown variant of [Vocabulary] to a value of type [T].
                             *
                             * An instance of [Vocabulary] can contain an unknown variant if it was
                             * deserialized from data that doesn't match any known variant. For
                             * example, if the SDK is on an older version than the API, then the API
                             * may respond with new variants that the SDK is unaware of.
                             *
                             * @throws ImageKitInvalidDataException in the default implementation.
                             */
                            fun unknown(json: JsonValue?): T {
                                throw ImageKitInvalidDataException("Unknown Vocabulary: $json")
                            }
                        }

                        internal class Serializer : BaseSerializer<Vocabulary>(Vocabulary::class) {

                            override fun serialize(
                                value: Vocabulary,
                                generator: JsonGenerator,
                                provider: SerializerProvider,
                            ) {
                                when {
                                    value.string != null -> generator.writeObject(value.string)
                                    value.number != null -> generator.writeObject(value.number)
                                    value.bool != null -> generator.writeObject(value.bool)
                                    value._json != null -> generator.writeObject(value._json)
                                    else -> throw IllegalStateException("Invalid Vocabulary")
                                }
                            }
                        }
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is SelectMetadata &&
                            field == other.field &&
                            instruction == other.instruction &&
                            type == other.type &&
                            maxSelections == other.maxSelections &&
                            minSelections == other.minSelections &&
                            vocabulary == other.vocabulary &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(
                            field,
                            instruction,
                            type,
                            maxSelections,
                            minSelections,
                            vocabulary,
                            additionalProperties,
                        )
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "SelectMetadata{field=$field, instruction=$instruction, type=$type, maxSelections=$maxSelections, minSelections=$minSelections, vocabulary=$vocabulary, additionalProperties=$additionalProperties}"
                }

                class YesNo
                private constructor(
                    private val instruction: JsonField<String>,
                    private val type: JsonValue,
                    private val onNo: JsonField<OnNo>,
                    private val onUnknown: JsonField<OnUnknown>,
                    private val onYes: JsonField<OnYes>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    /**
                     * The yes/no question for the AI to answer about the image.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun instruction(): String = instruction.getRequired("instruction")

                    /**
                     * Task type that asks a yes/no question and executes actions based on the
                     * answer.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("yes_no")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * Actions to execute if the AI answers no.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun onNo(): Optional<OnNo> = onNo.getOptional("on_no")

                    /**
                     * Actions to execute if the AI cannot determine the answer.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun onUnknown(): Optional<OnUnknown> = onUnknown.getOptional("on_unknown")

                    /**
                     * Actions to execute if the AI answers yes.
                     *
                     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun onYes(): Optional<OnYes> = onYes.getOptional("on_yes")

                    /**
                     * Returns the raw JSON value of [instruction].
                     *
                     * Unlike [instruction], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("instruction")
                    @ExcludeMissing
                    fun _instruction(): JsonField<String> = instruction

                    /**
                     * Returns the raw JSON value of [onNo].
                     *
                     * Unlike [onNo], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("on_no") @ExcludeMissing fun _onNo(): JsonField<OnNo> = onNo

                    /**
                     * Returns the raw JSON value of [onUnknown].
                     *
                     * Unlike [onUnknown], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("on_unknown")
                    @ExcludeMissing
                    fun _onUnknown(): JsonField<OnUnknown> = onUnknown

                    /**
                     * Returns the raw JSON value of [onYes].
                     *
                     * Unlike [onYes], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("on_yes") @ExcludeMissing fun _onYes(): JsonField<OnYes> = onYes

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
                         * Returns a mutable builder for constructing an instance of [YesNo].
                         *
                         * The following fields are required:
                         * ```java
                         * .instruction()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [YesNo]. */
                    class Builder internal constructor() {

                        private var instruction: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("yes_no")
                        private var onNo: JsonField<OnNo> = JsonMissing.of()
                        private var onUnknown: JsonField<OnUnknown> = JsonMissing.of()
                        private var onYes: JsonField<OnYes> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(yesNo: YesNo) = apply {
                            instruction = yesNo.instruction
                            type = yesNo.type
                            onNo = yesNo.onNo
                            onUnknown = yesNo.onUnknown
                            onYes = yesNo.onYes
                            additionalProperties = yesNo.additionalProperties.toMutableMap()
                        }

                        /** The yes/no question for the AI to answer about the image. */
                        fun instruction(instruction: String) =
                            instruction(JsonField.of(instruction))

                        /**
                         * Sets [Builder.instruction] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.instruction] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun instruction(instruction: JsonField<String>) = apply {
                            this.instruction = instruction
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("yes_no")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        /** Actions to execute if the AI answers no. */
                        fun onNo(onNo: OnNo) = onNo(JsonField.of(onNo))

                        /**
                         * Sets [Builder.onNo] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.onNo] with a well-typed [OnNo] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun onNo(onNo: JsonField<OnNo>) = apply { this.onNo = onNo }

                        /** Actions to execute if the AI cannot determine the answer. */
                        fun onUnknown(onUnknown: OnUnknown) = onUnknown(JsonField.of(onUnknown))

                        /**
                         * Sets [Builder.onUnknown] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.onUnknown] with a well-typed [OnUnknown]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun onUnknown(onUnknown: JsonField<OnUnknown>) = apply {
                            this.onUnknown = onUnknown
                        }

                        /** Actions to execute if the AI answers yes. */
                        fun onYes(onYes: OnYes) = onYes(JsonField.of(onYes))

                        /**
                         * Sets [Builder.onYes] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.onYes] with a well-typed [OnYes] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun onYes(onYes: JsonField<OnYes>) = apply { this.onYes = onYes }

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
                         * Returns an immutable instance of [YesNo].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .instruction()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): YesNo =
                            YesNo(
                                checkRequired("instruction", instruction),
                                type,
                                onNo,
                                onUnknown,
                                onYes,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): YesNo = apply {
                        if (validated) {
                            return@apply
                        }

                        instruction()
                        _type().let {
                            if (it != JsonValue.from("yes_no")) {
                                throw ImageKitInvalidDataException(
                                    "'type' is invalid, received $it"
                                )
                            }
                        }
                        onNo().ifPresent { it.validate() }
                        onUnknown().ifPresent { it.validate() }
                        onYes().ifPresent { it.validate() }
                        validated = true
                    }

                    fun isValid(): Boolean =
                        try {
                            validate()
                            true
                        } catch (e: ImageKitInvalidDataException) {
                            false
                        }

                    /** Actions to execute if the AI answers no. */
                    class OnNo
                    private constructor(
                        private val addTags: JsonField<List<String>>,
                        private val removeTags: JsonField<List<String>>,
                        private val setMetadata: JsonField<List<SetMetadata>>,
                        private val unsetMetadata: JsonField<List<UnsetMetadata>>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        /**
                         * Array of tag strings to add to the asset.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun addTags(): Optional<List<String>> = addTags.getOptional("add_tags")

                        /**
                         * Array of tag strings to remove from the asset.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun removeTags(): Optional<List<String>> =
                            removeTags.getOptional("remove_tags")

                        /**
                         * Array of custom metadata field updates.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun setMetadata(): Optional<List<SetMetadata>> =
                            setMetadata.getOptional("set_metadata")

                        /**
                         * Array of custom metadata fields to remove.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun unsetMetadata(): Optional<List<UnsetMetadata>> =
                            unsetMetadata.getOptional("unset_metadata")

                        /**
                         * Returns the raw JSON value of [addTags].
                         *
                         * Unlike [addTags], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("add_tags")
                        @ExcludeMissing
                        fun _addTags(): JsonField<List<String>> = addTags

                        /**
                         * Returns the raw JSON value of [removeTags].
                         *
                         * Unlike [removeTags], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("remove_tags")
                        @ExcludeMissing
                        fun _removeTags(): JsonField<List<String>> = removeTags

                        /**
                         * Returns the raw JSON value of [setMetadata].
                         *
                         * Unlike [setMetadata], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("set_metadata")
                        @ExcludeMissing
                        fun _setMetadata(): JsonField<List<SetMetadata>> = setMetadata

                        /**
                         * Returns the raw JSON value of [unsetMetadata].
                         *
                         * Unlike [unsetMetadata], this method doesn't throw if the JSON field has
                         * an unexpected type.
                         */
                        @JsonProperty("unset_metadata")
                        @ExcludeMissing
                        fun _unsetMetadata(): JsonField<List<UnsetMetadata>> = unsetMetadata

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

                            /** Returns a mutable builder for constructing an instance of [OnNo]. */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [OnNo]. */
                        class Builder internal constructor() {

                            private var addTags: JsonField<MutableList<String>>? = null
                            private var removeTags: JsonField<MutableList<String>>? = null
                            private var setMetadata: JsonField<MutableList<SetMetadata>>? = null
                            private var unsetMetadata: JsonField<MutableList<UnsetMetadata>>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(onNo: OnNo) = apply {
                                addTags = onNo.addTags.map { it.toMutableList() }
                                removeTags = onNo.removeTags.map { it.toMutableList() }
                                setMetadata = onNo.setMetadata.map { it.toMutableList() }
                                unsetMetadata = onNo.unsetMetadata.map { it.toMutableList() }
                                additionalProperties = onNo.additionalProperties.toMutableMap()
                            }

                            /** Array of tag strings to add to the asset. */
                            fun addTags(addTags: List<String>) = addTags(JsonField.of(addTags))

                            /**
                             * Sets [Builder.addTags] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.addTags] with a well-typed
                             * `List<String>` value instead. This method is primarily for setting
                             * the field to an undocumented or not yet supported value.
                             */
                            fun addTags(addTags: JsonField<List<String>>) = apply {
                                this.addTags = addTags.map { it.toMutableList() }
                            }

                            /**
                             * Adds a single [String] to [addTags].
                             *
                             * @throws IllegalStateException if the field was previously set to a
                             *   non-list.
                             */
                            fun addAddTag(addTag: String) = apply {
                                addTags =
                                    (addTags ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("addTags", it).add(addTag)
                                    }
                            }

                            /** Array of tag strings to remove from the asset. */
                            fun removeTags(removeTags: List<String>) =
                                removeTags(JsonField.of(removeTags))

                            /**
                             * Sets [Builder.removeTags] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.removeTags] with a well-typed
                             * `List<String>` value instead. This method is primarily for setting
                             * the field to an undocumented or not yet supported value.
                             */
                            fun removeTags(removeTags: JsonField<List<String>>) = apply {
                                this.removeTags = removeTags.map { it.toMutableList() }
                            }

                            /**
                             * Adds a single [String] to [removeTags].
                             *
                             * @throws IllegalStateException if the field was previously set to a
                             *   non-list.
                             */
                            fun addRemoveTag(removeTag: String) = apply {
                                removeTags =
                                    (removeTags ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("removeTags", it).add(removeTag)
                                    }
                            }

                            /** Array of custom metadata field updates. */
                            fun setMetadata(setMetadata: List<SetMetadata>) =
                                setMetadata(JsonField.of(setMetadata))

                            /**
                             * Sets [Builder.setMetadata] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.setMetadata] with a well-typed
                             * `List<SetMetadata>` value instead. This method is primarily for
                             * setting the field to an undocumented or not yet supported value.
                             */
                            fun setMetadata(setMetadata: JsonField<List<SetMetadata>>) = apply {
                                this.setMetadata = setMetadata.map { it.toMutableList() }
                            }

                            /**
                             * Adds a single [SetMetadata] to [Builder.setMetadata].
                             *
                             * @throws IllegalStateException if the field was previously set to a
                             *   non-list.
                             */
                            fun addSetMetadata(setMetadata: SetMetadata) = apply {
                                this.setMetadata =
                                    (this.setMetadata ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("setMetadata", it).add(setMetadata)
                                    }
                            }

                            /** Array of custom metadata fields to remove. */
                            fun unsetMetadata(unsetMetadata: List<UnsetMetadata>) =
                                unsetMetadata(JsonField.of(unsetMetadata))

                            /**
                             * Sets [Builder.unsetMetadata] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.unsetMetadata] with a well-typed
                             * `List<UnsetMetadata>` value instead. This method is primarily for
                             * setting the field to an undocumented or not yet supported value.
                             */
                            fun unsetMetadata(unsetMetadata: JsonField<List<UnsetMetadata>>) =
                                apply {
                                    this.unsetMetadata = unsetMetadata.map { it.toMutableList() }
                                }

                            /**
                             * Adds a single [UnsetMetadata] to [Builder.unsetMetadata].
                             *
                             * @throws IllegalStateException if the field was previously set to a
                             *   non-list.
                             */
                            fun addUnsetMetadata(unsetMetadata: UnsetMetadata) = apply {
                                this.unsetMetadata =
                                    (this.unsetMetadata ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("unsetMetadata", it).add(unsetMetadata)
                                    }
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
                             * Returns an immutable instance of [OnNo].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): OnNo =
                                OnNo(
                                    (addTags ?: JsonMissing.of()).map { it.toImmutable() },
                                    (removeTags ?: JsonMissing.of()).map { it.toImmutable() },
                                    (setMetadata ?: JsonMissing.of()).map { it.toImmutable() },
                                    (unsetMetadata ?: JsonMissing.of()).map { it.toImmutable() },
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): OnNo = apply {
                            if (validated) {
                                return@apply
                            }

                            addTags()
                            removeTags()
                            setMetadata().ifPresent { it.forEach { it.validate() } }
                            unsetMetadata().ifPresent { it.forEach { it.validate() } }
                            validated = true
                        }

                        fun isValid(): Boolean =
                            try {
                                validate()
                                true
                            } catch (e: ImageKitInvalidDataException) {
                                false
                            }

                        class SetMetadata
                        private constructor(
                            private val field: JsonField<String>,
                            private val value: JsonField<Value>,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            /**
                             * Name of the custom metadata field to set.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun field(): String = field.getRequired("field")

                            /**
                             * Value to set for the custom metadata field. The value type should
                             * match the custom metadata field type.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun value(): Value = value.getRequired("value")

                            /**
                             * Returns the raw JSON value of [field].
                             *
                             * Unlike [field], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("field")
                            @ExcludeMissing
                            fun _field(): JsonField<String> = field

                            /**
                             * Returns the raw JSON value of [value].
                             *
                             * Unlike [value], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("value")
                            @ExcludeMissing
                            fun _value(): JsonField<Value> = value

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
                                 * [SetMetadata].
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .field()
                                 * .value()
                                 * ```
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [SetMetadata]. */
                            class Builder internal constructor() {

                                private var field: JsonField<String>? = null
                                private var value: JsonField<Value>? = null
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(setMetadata: SetMetadata) = apply {
                                    field = setMetadata.field
                                    value = setMetadata.value
                                    additionalProperties =
                                        setMetadata.additionalProperties.toMutableMap()
                                }

                                /** Name of the custom metadata field to set. */
                                fun field(field: String) = field(JsonField.of(field))

                                /**
                                 * Sets [Builder.field] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.field] with a well-typed
                                 * [String] value instead. This method is primarily for setting the
                                 * field to an undocumented or not yet supported value.
                                 */
                                fun field(field: JsonField<String>) = apply { this.field = field }

                                /**
                                 * Value to set for the custom metadata field. The value type should
                                 * match the custom metadata field type.
                                 */
                                fun value(value: Value) = value(JsonField.of(value))

                                /**
                                 * Sets [Builder.value] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.value] with a well-typed [Value]
                                 * value instead. This method is primarily for setting the field to
                                 * an undocumented or not yet supported value.
                                 */
                                fun value(value: JsonField<Value>) = apply { this.value = value }

                                /** Alias for calling [value] with `Value.ofString(string)`. */
                                fun value(string: String) = value(Value.ofString(string))

                                /** Alias for calling [value] with `Value.ofNumber(number)`. */
                                fun value(number: Double) = value(Value.ofNumber(number))

                                /** Alias for calling [value] with `Value.ofBool(bool)`. */
                                fun value(bool: Boolean) = value(Value.ofBool(bool))

                                /** Alias for calling [value] with `Value.ofMixed(mixed)`. */
                                fun valueOfMixed(mixed: List<Value.UnnamedSchemaWithArrayParent5>) =
                                    value(Value.ofMixed(mixed))

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
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
                                 * Returns an immutable instance of [SetMetadata].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .field()
                                 * .value()
                                 * ```
                                 *
                                 * @throws IllegalStateException if any required field is unset.
                                 */
                                fun build(): SetMetadata =
                                    SetMetadata(
                                        checkRequired("field", field),
                                        checkRequired("value", value),
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            fun validate(): SetMetadata = apply {
                                if (validated) {
                                    return@apply
                                }

                                field()
                                value().validate()
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
                             * Value to set for the custom metadata field. The value type should
                             * match the custom metadata field type.
                             */
                            @JsonSerialize(using = Value.Serializer::class)
                            class Value
                            private constructor(
                                private val string: String? = null,
                                private val number: Double? = null,
                                private val bool: Boolean? = null,
                                private val mixed: List<UnnamedSchemaWithArrayParent5>? = null,
                                private val _json: JsonValue? = null,
                            ) {

                                fun string(): Optional<String> = Optional.ofNullable(string)

                                fun number(): Optional<Double> = Optional.ofNullable(number)

                                fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

                                fun mixed(): Optional<List<UnnamedSchemaWithArrayParent5>> =
                                    Optional.ofNullable(mixed)

                                fun isString(): Boolean = string != null

                                fun isNumber(): Boolean = number != null

                                fun isBool(): Boolean = bool != null

                                fun isMixed(): Boolean = mixed != null

                                fun asString(): String = string.getOrThrow("string")

                                fun asNumber(): Double = number.getOrThrow("number")

                                fun asBool(): Boolean = bool.getOrThrow("bool")

                                fun asMixed(): List<UnnamedSchemaWithArrayParent5> =
                                    mixed.getOrThrow("mixed")

                                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                                fun <T> accept(visitor: Visitor<T>): T =
                                    when {
                                        string != null -> visitor.visitString(string)
                                        number != null -> visitor.visitNumber(number)
                                        bool != null -> visitor.visitBool(bool)
                                        mixed != null -> visitor.visitMixed(mixed)
                                        else -> visitor.unknown(_json)
                                    }

                                private var validated: Boolean = false

                                fun validate(): Value = apply {
                                    if (validated) {
                                        return@apply
                                    }

                                    accept(
                                        object : Visitor<Unit> {
                                            override fun visitString(string: String) {}

                                            override fun visitNumber(number: Double) {}

                                            override fun visitBool(bool: Boolean) {}

                                            override fun visitMixed(
                                                mixed: List<UnnamedSchemaWithArrayParent5>
                                            ) {
                                                mixed.forEach { it.validate() }
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

                                    return other is Value &&
                                        string == other.string &&
                                        number == other.number &&
                                        bool == other.bool &&
                                        mixed == other.mixed
                                }

                                override fun hashCode(): Int =
                                    Objects.hash(string, number, bool, mixed)

                                override fun toString(): String =
                                    when {
                                        string != null -> "Value{string=$string}"
                                        number != null -> "Value{number=$number}"
                                        bool != null -> "Value{bool=$bool}"
                                        mixed != null -> "Value{mixed=$mixed}"
                                        _json != null -> "Value{_unknown=$_json}"
                                        else -> throw IllegalStateException("Invalid Value")
                                    }

                                companion object {

                                    @JvmStatic fun ofString(string: String) = Value(string = string)

                                    @JvmStatic fun ofNumber(number: Double) = Value(number = number)

                                    @JvmStatic fun ofBool(bool: Boolean) = Value(bool = bool)

                                    @JvmStatic
                                    fun ofMixed(mixed: List<UnnamedSchemaWithArrayParent5>) =
                                        Value(mixed = mixed.toImmutable())
                                }

                                /**
                                 * An interface that defines how to map each variant of [Value] to a
                                 * value of type [T].
                                 */
                                interface Visitor<out T> {

                                    fun visitString(string: String): T

                                    fun visitNumber(number: Double): T

                                    fun visitBool(bool: Boolean): T

                                    fun visitMixed(mixed: List<UnnamedSchemaWithArrayParent5>): T

                                    /**
                                     * Maps an unknown variant of [Value] to a value of type [T].
                                     *
                                     * An instance of [Value] can contain an unknown variant if it
                                     * was deserialized from data that doesn't match any known
                                     * variant. For example, if the SDK is on an older version than
                                     * the API, then the API may respond with new variants that the
                                     * SDK is unaware of.
                                     *
                                     * @throws ImageKitInvalidDataException in the default
                                     *   implementation.
                                     */
                                    fun unknown(json: JsonValue?): T {
                                        throw ImageKitInvalidDataException("Unknown Value: $json")
                                    }
                                }

                                internal class Serializer : BaseSerializer<Value>(Value::class) {

                                    override fun serialize(
                                        value: Value,
                                        generator: JsonGenerator,
                                        provider: SerializerProvider,
                                    ) {
                                        when {
                                            value.string != null ->
                                                generator.writeObject(value.string)
                                            value.number != null ->
                                                generator.writeObject(value.number)
                                            value.bool != null -> generator.writeObject(value.bool)
                                            value.mixed != null ->
                                                generator.writeObject(value.mixed)
                                            value._json != null ->
                                                generator.writeObject(value._json)
                                            else -> throw IllegalStateException("Invalid Value")
                                        }
                                    }
                                }

                                @JsonSerialize(
                                    using = UnnamedSchemaWithArrayParent5.Serializer::class
                                )
                                class UnnamedSchemaWithArrayParent5
                                private constructor(
                                    private val string: String? = null,
                                    private val number: Double? = null,
                                    private val bool: Boolean? = null,
                                    private val _json: JsonValue? = null,
                                ) {

                                    fun string(): Optional<String> = Optional.ofNullable(string)

                                    fun number(): Optional<Double> = Optional.ofNullable(number)

                                    fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

                                    fun isString(): Boolean = string != null

                                    fun isNumber(): Boolean = number != null

                                    fun isBool(): Boolean = bool != null

                                    fun asString(): String = string.getOrThrow("string")

                                    fun asNumber(): Double = number.getOrThrow("number")

                                    fun asBool(): Boolean = bool.getOrThrow("bool")

                                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                                    fun <T> accept(visitor: Visitor<T>): T =
                                        when {
                                            string != null -> visitor.visitString(string)
                                            number != null -> visitor.visitNumber(number)
                                            bool != null -> visitor.visitBool(bool)
                                            else -> visitor.unknown(_json)
                                        }

                                    private var validated: Boolean = false

                                    fun validate(): UnnamedSchemaWithArrayParent5 = apply {
                                        if (validated) {
                                            return@apply
                                        }

                                        accept(
                                            object : Visitor<Unit> {
                                                override fun visitString(string: String) {}

                                                override fun visitNumber(number: Double) {}

                                                override fun visitBool(bool: Boolean) {}
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

                                        return other is UnnamedSchemaWithArrayParent5 &&
                                            string == other.string &&
                                            number == other.number &&
                                            bool == other.bool
                                    }

                                    override fun hashCode(): Int =
                                        Objects.hash(string, number, bool)

                                    override fun toString(): String =
                                        when {
                                            string != null ->
                                                "UnnamedSchemaWithArrayParent5{string=$string}"
                                            number != null ->
                                                "UnnamedSchemaWithArrayParent5{number=$number}"
                                            bool != null ->
                                                "UnnamedSchemaWithArrayParent5{bool=$bool}"
                                            _json != null ->
                                                "UnnamedSchemaWithArrayParent5{_unknown=$_json}"
                                            else ->
                                                throw IllegalStateException(
                                                    "Invalid UnnamedSchemaWithArrayParent5"
                                                )
                                        }

                                    companion object {

                                        @JvmStatic
                                        fun ofString(string: String) =
                                            UnnamedSchemaWithArrayParent5(string = string)

                                        @JvmStatic
                                        fun ofNumber(number: Double) =
                                            UnnamedSchemaWithArrayParent5(number = number)

                                        @JvmStatic
                                        fun ofBool(bool: Boolean) =
                                            UnnamedSchemaWithArrayParent5(bool = bool)
                                    }

                                    /**
                                     * An interface that defines how to map each variant of
                                     * [UnnamedSchemaWithArrayParent5] to a value of type [T].
                                     */
                                    interface Visitor<out T> {

                                        fun visitString(string: String): T

                                        fun visitNumber(number: Double): T

                                        fun visitBool(bool: Boolean): T

                                        /**
                                         * Maps an unknown variant of
                                         * [UnnamedSchemaWithArrayParent5] to a value of type [T].
                                         *
                                         * An instance of [UnnamedSchemaWithArrayParent5] can
                                         * contain an unknown variant if it was deserialized from
                                         * data that doesn't match any known variant. For example,
                                         * if the SDK is on an older version than the API, then the
                                         * API may respond with new variants that the SDK is unaware
                                         * of.
                                         *
                                         * @throws ImageKitInvalidDataException in the default
                                         *   implementation.
                                         */
                                        fun unknown(json: JsonValue?): T {
                                            throw ImageKitInvalidDataException(
                                                "Unknown UnnamedSchemaWithArrayParent5: $json"
                                            )
                                        }
                                    }

                                    internal class Serializer :
                                        BaseSerializer<UnnamedSchemaWithArrayParent5>(
                                            UnnamedSchemaWithArrayParent5::class
                                        ) {

                                        override fun serialize(
                                            value: UnnamedSchemaWithArrayParent5,
                                            generator: JsonGenerator,
                                            provider: SerializerProvider,
                                        ) {
                                            when {
                                                value.string != null ->
                                                    generator.writeObject(value.string)
                                                value.number != null ->
                                                    generator.writeObject(value.number)
                                                value.bool != null ->
                                                    generator.writeObject(value.bool)
                                                value._json != null ->
                                                    generator.writeObject(value._json)
                                                else ->
                                                    throw IllegalStateException(
                                                        "Invalid UnnamedSchemaWithArrayParent5"
                                                    )
                                            }
                                        }
                                    }
                                }
                            }

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is SetMetadata &&
                                    field == other.field &&
                                    value == other.value &&
                                    additionalProperties == other.additionalProperties
                            }

                            private val hashCode: Int by lazy {
                                Objects.hash(field, value, additionalProperties)
                            }

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "SetMetadata{field=$field, value=$value, additionalProperties=$additionalProperties}"
                        }

                        class UnsetMetadata
                        private constructor(
                            private val field: JsonField<String>,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            /**
                             * Name of the custom metadata field to remove.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun field(): String = field.getRequired("field")

                            /**
                             * Returns the raw JSON value of [field].
                             *
                             * Unlike [field], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("field")
                            @ExcludeMissing
                            fun _field(): JsonField<String> = field

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
                                 * [UnsetMetadata].
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .field()
                                 * ```
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [UnsetMetadata]. */
                            class Builder internal constructor() {

                                private var field: JsonField<String>? = null
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(unsetMetadata: UnsetMetadata) = apply {
                                    field = unsetMetadata.field
                                    additionalProperties =
                                        unsetMetadata.additionalProperties.toMutableMap()
                                }

                                /** Name of the custom metadata field to remove. */
                                fun field(field: String) = field(JsonField.of(field))

                                /**
                                 * Sets [Builder.field] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.field] with a well-typed
                                 * [String] value instead. This method is primarily for setting the
                                 * field to an undocumented or not yet supported value.
                                 */
                                fun field(field: JsonField<String>) = apply { this.field = field }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
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
                                 * Returns an immutable instance of [UnsetMetadata].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .field()
                                 * ```
                                 *
                                 * @throws IllegalStateException if any required field is unset.
                                 */
                                fun build(): UnsetMetadata =
                                    UnsetMetadata(
                                        checkRequired("field", field),
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            fun validate(): UnsetMetadata = apply {
                                if (validated) {
                                    return@apply
                                }

                                field()
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

                                return other is UnsetMetadata &&
                                    field == other.field &&
                                    additionalProperties == other.additionalProperties
                            }

                            private val hashCode: Int by lazy {
                                Objects.hash(field, additionalProperties)
                            }

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "UnsetMetadata{field=$field, additionalProperties=$additionalProperties}"
                        }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is OnNo &&
                                addTags == other.addTags &&
                                removeTags == other.removeTags &&
                                setMetadata == other.setMetadata &&
                                unsetMetadata == other.unsetMetadata &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(
                                addTags,
                                removeTags,
                                setMetadata,
                                unsetMetadata,
                                additionalProperties,
                            )
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "OnNo{addTags=$addTags, removeTags=$removeTags, setMetadata=$setMetadata, unsetMetadata=$unsetMetadata, additionalProperties=$additionalProperties}"
                    }

                    /** Actions to execute if the AI cannot determine the answer. */
                    class OnUnknown
                    private constructor(
                        private val addTags: JsonField<List<String>>,
                        private val removeTags: JsonField<List<String>>,
                        private val setMetadata: JsonField<List<SetMetadata>>,
                        private val unsetMetadata: JsonField<List<UnsetMetadata>>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        /**
                         * Array of tag strings to add to the asset.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun addTags(): Optional<List<String>> = addTags.getOptional("add_tags")

                        /**
                         * Array of tag strings to remove from the asset.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun removeTags(): Optional<List<String>> =
                            removeTags.getOptional("remove_tags")

                        /**
                         * Array of custom metadata field updates.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun setMetadata(): Optional<List<SetMetadata>> =
                            setMetadata.getOptional("set_metadata")

                        /**
                         * Array of custom metadata fields to remove.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun unsetMetadata(): Optional<List<UnsetMetadata>> =
                            unsetMetadata.getOptional("unset_metadata")

                        /**
                         * Returns the raw JSON value of [addTags].
                         *
                         * Unlike [addTags], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("add_tags")
                        @ExcludeMissing
                        fun _addTags(): JsonField<List<String>> = addTags

                        /**
                         * Returns the raw JSON value of [removeTags].
                         *
                         * Unlike [removeTags], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("remove_tags")
                        @ExcludeMissing
                        fun _removeTags(): JsonField<List<String>> = removeTags

                        /**
                         * Returns the raw JSON value of [setMetadata].
                         *
                         * Unlike [setMetadata], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("set_metadata")
                        @ExcludeMissing
                        fun _setMetadata(): JsonField<List<SetMetadata>> = setMetadata

                        /**
                         * Returns the raw JSON value of [unsetMetadata].
                         *
                         * Unlike [unsetMetadata], this method doesn't throw if the JSON field has
                         * an unexpected type.
                         */
                        @JsonProperty("unset_metadata")
                        @ExcludeMissing
                        fun _unsetMetadata(): JsonField<List<UnsetMetadata>> = unsetMetadata

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
                             * [OnUnknown].
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [OnUnknown]. */
                        class Builder internal constructor() {

                            private var addTags: JsonField<MutableList<String>>? = null
                            private var removeTags: JsonField<MutableList<String>>? = null
                            private var setMetadata: JsonField<MutableList<SetMetadata>>? = null
                            private var unsetMetadata: JsonField<MutableList<UnsetMetadata>>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(onUnknown: OnUnknown) = apply {
                                addTags = onUnknown.addTags.map { it.toMutableList() }
                                removeTags = onUnknown.removeTags.map { it.toMutableList() }
                                setMetadata = onUnknown.setMetadata.map { it.toMutableList() }
                                unsetMetadata = onUnknown.unsetMetadata.map { it.toMutableList() }
                                additionalProperties = onUnknown.additionalProperties.toMutableMap()
                            }

                            /** Array of tag strings to add to the asset. */
                            fun addTags(addTags: List<String>) = addTags(JsonField.of(addTags))

                            /**
                             * Sets [Builder.addTags] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.addTags] with a well-typed
                             * `List<String>` value instead. This method is primarily for setting
                             * the field to an undocumented or not yet supported value.
                             */
                            fun addTags(addTags: JsonField<List<String>>) = apply {
                                this.addTags = addTags.map { it.toMutableList() }
                            }

                            /**
                             * Adds a single [String] to [addTags].
                             *
                             * @throws IllegalStateException if the field was previously set to a
                             *   non-list.
                             */
                            fun addAddTag(addTag: String) = apply {
                                addTags =
                                    (addTags ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("addTags", it).add(addTag)
                                    }
                            }

                            /** Array of tag strings to remove from the asset. */
                            fun removeTags(removeTags: List<String>) =
                                removeTags(JsonField.of(removeTags))

                            /**
                             * Sets [Builder.removeTags] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.removeTags] with a well-typed
                             * `List<String>` value instead. This method is primarily for setting
                             * the field to an undocumented or not yet supported value.
                             */
                            fun removeTags(removeTags: JsonField<List<String>>) = apply {
                                this.removeTags = removeTags.map { it.toMutableList() }
                            }

                            /**
                             * Adds a single [String] to [removeTags].
                             *
                             * @throws IllegalStateException if the field was previously set to a
                             *   non-list.
                             */
                            fun addRemoveTag(removeTag: String) = apply {
                                removeTags =
                                    (removeTags ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("removeTags", it).add(removeTag)
                                    }
                            }

                            /** Array of custom metadata field updates. */
                            fun setMetadata(setMetadata: List<SetMetadata>) =
                                setMetadata(JsonField.of(setMetadata))

                            /**
                             * Sets [Builder.setMetadata] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.setMetadata] with a well-typed
                             * `List<SetMetadata>` value instead. This method is primarily for
                             * setting the field to an undocumented or not yet supported value.
                             */
                            fun setMetadata(setMetadata: JsonField<List<SetMetadata>>) = apply {
                                this.setMetadata = setMetadata.map { it.toMutableList() }
                            }

                            /**
                             * Adds a single [SetMetadata] to [Builder.setMetadata].
                             *
                             * @throws IllegalStateException if the field was previously set to a
                             *   non-list.
                             */
                            fun addSetMetadata(setMetadata: SetMetadata) = apply {
                                this.setMetadata =
                                    (this.setMetadata ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("setMetadata", it).add(setMetadata)
                                    }
                            }

                            /** Array of custom metadata fields to remove. */
                            fun unsetMetadata(unsetMetadata: List<UnsetMetadata>) =
                                unsetMetadata(JsonField.of(unsetMetadata))

                            /**
                             * Sets [Builder.unsetMetadata] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.unsetMetadata] with a well-typed
                             * `List<UnsetMetadata>` value instead. This method is primarily for
                             * setting the field to an undocumented or not yet supported value.
                             */
                            fun unsetMetadata(unsetMetadata: JsonField<List<UnsetMetadata>>) =
                                apply {
                                    this.unsetMetadata = unsetMetadata.map { it.toMutableList() }
                                }

                            /**
                             * Adds a single [UnsetMetadata] to [Builder.unsetMetadata].
                             *
                             * @throws IllegalStateException if the field was previously set to a
                             *   non-list.
                             */
                            fun addUnsetMetadata(unsetMetadata: UnsetMetadata) = apply {
                                this.unsetMetadata =
                                    (this.unsetMetadata ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("unsetMetadata", it).add(unsetMetadata)
                                    }
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
                             * Returns an immutable instance of [OnUnknown].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): OnUnknown =
                                OnUnknown(
                                    (addTags ?: JsonMissing.of()).map { it.toImmutable() },
                                    (removeTags ?: JsonMissing.of()).map { it.toImmutable() },
                                    (setMetadata ?: JsonMissing.of()).map { it.toImmutable() },
                                    (unsetMetadata ?: JsonMissing.of()).map { it.toImmutable() },
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): OnUnknown = apply {
                            if (validated) {
                                return@apply
                            }

                            addTags()
                            removeTags()
                            setMetadata().ifPresent { it.forEach { it.validate() } }
                            unsetMetadata().ifPresent { it.forEach { it.validate() } }
                            validated = true
                        }

                        fun isValid(): Boolean =
                            try {
                                validate()
                                true
                            } catch (e: ImageKitInvalidDataException) {
                                false
                            }

                        class SetMetadata
                        private constructor(
                            private val field: JsonField<String>,
                            private val value: JsonField<Value>,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            /**
                             * Name of the custom metadata field to set.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun field(): String = field.getRequired("field")

                            /**
                             * Value to set for the custom metadata field. The value type should
                             * match the custom metadata field type.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun value(): Value = value.getRequired("value")

                            /**
                             * Returns the raw JSON value of [field].
                             *
                             * Unlike [field], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("field")
                            @ExcludeMissing
                            fun _field(): JsonField<String> = field

                            /**
                             * Returns the raw JSON value of [value].
                             *
                             * Unlike [value], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("value")
                            @ExcludeMissing
                            fun _value(): JsonField<Value> = value

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
                                 * [SetMetadata].
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .field()
                                 * .value()
                                 * ```
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [SetMetadata]. */
                            class Builder internal constructor() {

                                private var field: JsonField<String>? = null
                                private var value: JsonField<Value>? = null
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(setMetadata: SetMetadata) = apply {
                                    field = setMetadata.field
                                    value = setMetadata.value
                                    additionalProperties =
                                        setMetadata.additionalProperties.toMutableMap()
                                }

                                /** Name of the custom metadata field to set. */
                                fun field(field: String) = field(JsonField.of(field))

                                /**
                                 * Sets [Builder.field] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.field] with a well-typed
                                 * [String] value instead. This method is primarily for setting the
                                 * field to an undocumented or not yet supported value.
                                 */
                                fun field(field: JsonField<String>) = apply { this.field = field }

                                /**
                                 * Value to set for the custom metadata field. The value type should
                                 * match the custom metadata field type.
                                 */
                                fun value(value: Value) = value(JsonField.of(value))

                                /**
                                 * Sets [Builder.value] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.value] with a well-typed [Value]
                                 * value instead. This method is primarily for setting the field to
                                 * an undocumented or not yet supported value.
                                 */
                                fun value(value: JsonField<Value>) = apply { this.value = value }

                                /** Alias for calling [value] with `Value.ofString(string)`. */
                                fun value(string: String) = value(Value.ofString(string))

                                /** Alias for calling [value] with `Value.ofNumber(number)`. */
                                fun value(number: Double) = value(Value.ofNumber(number))

                                /** Alias for calling [value] with `Value.ofBool(bool)`. */
                                fun value(bool: Boolean) = value(Value.ofBool(bool))

                                /** Alias for calling [value] with `Value.ofMixed(mixed)`. */
                                fun valueOfMixed(mixed: List<Value.UnnamedSchemaWithArrayParent6>) =
                                    value(Value.ofMixed(mixed))

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
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
                                 * Returns an immutable instance of [SetMetadata].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .field()
                                 * .value()
                                 * ```
                                 *
                                 * @throws IllegalStateException if any required field is unset.
                                 */
                                fun build(): SetMetadata =
                                    SetMetadata(
                                        checkRequired("field", field),
                                        checkRequired("value", value),
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            fun validate(): SetMetadata = apply {
                                if (validated) {
                                    return@apply
                                }

                                field()
                                value().validate()
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
                             * Value to set for the custom metadata field. The value type should
                             * match the custom metadata field type.
                             */
                            @JsonSerialize(using = Value.Serializer::class)
                            class Value
                            private constructor(
                                private val string: String? = null,
                                private val number: Double? = null,
                                private val bool: Boolean? = null,
                                private val mixed: List<UnnamedSchemaWithArrayParent6>? = null,
                                private val _json: JsonValue? = null,
                            ) {

                                fun string(): Optional<String> = Optional.ofNullable(string)

                                fun number(): Optional<Double> = Optional.ofNullable(number)

                                fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

                                fun mixed(): Optional<List<UnnamedSchemaWithArrayParent6>> =
                                    Optional.ofNullable(mixed)

                                fun isString(): Boolean = string != null

                                fun isNumber(): Boolean = number != null

                                fun isBool(): Boolean = bool != null

                                fun isMixed(): Boolean = mixed != null

                                fun asString(): String = string.getOrThrow("string")

                                fun asNumber(): Double = number.getOrThrow("number")

                                fun asBool(): Boolean = bool.getOrThrow("bool")

                                fun asMixed(): List<UnnamedSchemaWithArrayParent6> =
                                    mixed.getOrThrow("mixed")

                                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                                fun <T> accept(visitor: Visitor<T>): T =
                                    when {
                                        string != null -> visitor.visitString(string)
                                        number != null -> visitor.visitNumber(number)
                                        bool != null -> visitor.visitBool(bool)
                                        mixed != null -> visitor.visitMixed(mixed)
                                        else -> visitor.unknown(_json)
                                    }

                                private var validated: Boolean = false

                                fun validate(): Value = apply {
                                    if (validated) {
                                        return@apply
                                    }

                                    accept(
                                        object : Visitor<Unit> {
                                            override fun visitString(string: String) {}

                                            override fun visitNumber(number: Double) {}

                                            override fun visitBool(bool: Boolean) {}

                                            override fun visitMixed(
                                                mixed: List<UnnamedSchemaWithArrayParent6>
                                            ) {
                                                mixed.forEach { it.validate() }
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

                                    return other is Value &&
                                        string == other.string &&
                                        number == other.number &&
                                        bool == other.bool &&
                                        mixed == other.mixed
                                }

                                override fun hashCode(): Int =
                                    Objects.hash(string, number, bool, mixed)

                                override fun toString(): String =
                                    when {
                                        string != null -> "Value{string=$string}"
                                        number != null -> "Value{number=$number}"
                                        bool != null -> "Value{bool=$bool}"
                                        mixed != null -> "Value{mixed=$mixed}"
                                        _json != null -> "Value{_unknown=$_json}"
                                        else -> throw IllegalStateException("Invalid Value")
                                    }

                                companion object {

                                    @JvmStatic fun ofString(string: String) = Value(string = string)

                                    @JvmStatic fun ofNumber(number: Double) = Value(number = number)

                                    @JvmStatic fun ofBool(bool: Boolean) = Value(bool = bool)

                                    @JvmStatic
                                    fun ofMixed(mixed: List<UnnamedSchemaWithArrayParent6>) =
                                        Value(mixed = mixed.toImmutable())
                                }

                                /**
                                 * An interface that defines how to map each variant of [Value] to a
                                 * value of type [T].
                                 */
                                interface Visitor<out T> {

                                    fun visitString(string: String): T

                                    fun visitNumber(number: Double): T

                                    fun visitBool(bool: Boolean): T

                                    fun visitMixed(mixed: List<UnnamedSchemaWithArrayParent6>): T

                                    /**
                                     * Maps an unknown variant of [Value] to a value of type [T].
                                     *
                                     * An instance of [Value] can contain an unknown variant if it
                                     * was deserialized from data that doesn't match any known
                                     * variant. For example, if the SDK is on an older version than
                                     * the API, then the API may respond with new variants that the
                                     * SDK is unaware of.
                                     *
                                     * @throws ImageKitInvalidDataException in the default
                                     *   implementation.
                                     */
                                    fun unknown(json: JsonValue?): T {
                                        throw ImageKitInvalidDataException("Unknown Value: $json")
                                    }
                                }

                                internal class Serializer : BaseSerializer<Value>(Value::class) {

                                    override fun serialize(
                                        value: Value,
                                        generator: JsonGenerator,
                                        provider: SerializerProvider,
                                    ) {
                                        when {
                                            value.string != null ->
                                                generator.writeObject(value.string)
                                            value.number != null ->
                                                generator.writeObject(value.number)
                                            value.bool != null -> generator.writeObject(value.bool)
                                            value.mixed != null ->
                                                generator.writeObject(value.mixed)
                                            value._json != null ->
                                                generator.writeObject(value._json)
                                            else -> throw IllegalStateException("Invalid Value")
                                        }
                                    }
                                }

                                @JsonSerialize(
                                    using = UnnamedSchemaWithArrayParent6.Serializer::class
                                )
                                class UnnamedSchemaWithArrayParent6
                                private constructor(
                                    private val string: String? = null,
                                    private val number: Double? = null,
                                    private val bool: Boolean? = null,
                                    private val _json: JsonValue? = null,
                                ) {

                                    fun string(): Optional<String> = Optional.ofNullable(string)

                                    fun number(): Optional<Double> = Optional.ofNullable(number)

                                    fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

                                    fun isString(): Boolean = string != null

                                    fun isNumber(): Boolean = number != null

                                    fun isBool(): Boolean = bool != null

                                    fun asString(): String = string.getOrThrow("string")

                                    fun asNumber(): Double = number.getOrThrow("number")

                                    fun asBool(): Boolean = bool.getOrThrow("bool")

                                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                                    fun <T> accept(visitor: Visitor<T>): T =
                                        when {
                                            string != null -> visitor.visitString(string)
                                            number != null -> visitor.visitNumber(number)
                                            bool != null -> visitor.visitBool(bool)
                                            else -> visitor.unknown(_json)
                                        }

                                    private var validated: Boolean = false

                                    fun validate(): UnnamedSchemaWithArrayParent6 = apply {
                                        if (validated) {
                                            return@apply
                                        }

                                        accept(
                                            object : Visitor<Unit> {
                                                override fun visitString(string: String) {}

                                                override fun visitNumber(number: Double) {}

                                                override fun visitBool(bool: Boolean) {}
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

                                        return other is UnnamedSchemaWithArrayParent6 &&
                                            string == other.string &&
                                            number == other.number &&
                                            bool == other.bool
                                    }

                                    override fun hashCode(): Int =
                                        Objects.hash(string, number, bool)

                                    override fun toString(): String =
                                        when {
                                            string != null ->
                                                "UnnamedSchemaWithArrayParent6{string=$string}"
                                            number != null ->
                                                "UnnamedSchemaWithArrayParent6{number=$number}"
                                            bool != null ->
                                                "UnnamedSchemaWithArrayParent6{bool=$bool}"
                                            _json != null ->
                                                "UnnamedSchemaWithArrayParent6{_unknown=$_json}"
                                            else ->
                                                throw IllegalStateException(
                                                    "Invalid UnnamedSchemaWithArrayParent6"
                                                )
                                        }

                                    companion object {

                                        @JvmStatic
                                        fun ofString(string: String) =
                                            UnnamedSchemaWithArrayParent6(string = string)

                                        @JvmStatic
                                        fun ofNumber(number: Double) =
                                            UnnamedSchemaWithArrayParent6(number = number)

                                        @JvmStatic
                                        fun ofBool(bool: Boolean) =
                                            UnnamedSchemaWithArrayParent6(bool = bool)
                                    }

                                    /**
                                     * An interface that defines how to map each variant of
                                     * [UnnamedSchemaWithArrayParent6] to a value of type [T].
                                     */
                                    interface Visitor<out T> {

                                        fun visitString(string: String): T

                                        fun visitNumber(number: Double): T

                                        fun visitBool(bool: Boolean): T

                                        /**
                                         * Maps an unknown variant of
                                         * [UnnamedSchemaWithArrayParent6] to a value of type [T].
                                         *
                                         * An instance of [UnnamedSchemaWithArrayParent6] can
                                         * contain an unknown variant if it was deserialized from
                                         * data that doesn't match any known variant. For example,
                                         * if the SDK is on an older version than the API, then the
                                         * API may respond with new variants that the SDK is unaware
                                         * of.
                                         *
                                         * @throws ImageKitInvalidDataException in the default
                                         *   implementation.
                                         */
                                        fun unknown(json: JsonValue?): T {
                                            throw ImageKitInvalidDataException(
                                                "Unknown UnnamedSchemaWithArrayParent6: $json"
                                            )
                                        }
                                    }

                                    internal class Serializer :
                                        BaseSerializer<UnnamedSchemaWithArrayParent6>(
                                            UnnamedSchemaWithArrayParent6::class
                                        ) {

                                        override fun serialize(
                                            value: UnnamedSchemaWithArrayParent6,
                                            generator: JsonGenerator,
                                            provider: SerializerProvider,
                                        ) {
                                            when {
                                                value.string != null ->
                                                    generator.writeObject(value.string)
                                                value.number != null ->
                                                    generator.writeObject(value.number)
                                                value.bool != null ->
                                                    generator.writeObject(value.bool)
                                                value._json != null ->
                                                    generator.writeObject(value._json)
                                                else ->
                                                    throw IllegalStateException(
                                                        "Invalid UnnamedSchemaWithArrayParent6"
                                                    )
                                            }
                                        }
                                    }
                                }
                            }

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is SetMetadata &&
                                    field == other.field &&
                                    value == other.value &&
                                    additionalProperties == other.additionalProperties
                            }

                            private val hashCode: Int by lazy {
                                Objects.hash(field, value, additionalProperties)
                            }

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "SetMetadata{field=$field, value=$value, additionalProperties=$additionalProperties}"
                        }

                        class UnsetMetadata
                        private constructor(
                            private val field: JsonField<String>,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            /**
                             * Name of the custom metadata field to remove.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun field(): String = field.getRequired("field")

                            /**
                             * Returns the raw JSON value of [field].
                             *
                             * Unlike [field], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("field")
                            @ExcludeMissing
                            fun _field(): JsonField<String> = field

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
                                 * [UnsetMetadata].
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .field()
                                 * ```
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [UnsetMetadata]. */
                            class Builder internal constructor() {

                                private var field: JsonField<String>? = null
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(unsetMetadata: UnsetMetadata) = apply {
                                    field = unsetMetadata.field
                                    additionalProperties =
                                        unsetMetadata.additionalProperties.toMutableMap()
                                }

                                /** Name of the custom metadata field to remove. */
                                fun field(field: String) = field(JsonField.of(field))

                                /**
                                 * Sets [Builder.field] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.field] with a well-typed
                                 * [String] value instead. This method is primarily for setting the
                                 * field to an undocumented or not yet supported value.
                                 */
                                fun field(field: JsonField<String>) = apply { this.field = field }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
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
                                 * Returns an immutable instance of [UnsetMetadata].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .field()
                                 * ```
                                 *
                                 * @throws IllegalStateException if any required field is unset.
                                 */
                                fun build(): UnsetMetadata =
                                    UnsetMetadata(
                                        checkRequired("field", field),
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            fun validate(): UnsetMetadata = apply {
                                if (validated) {
                                    return@apply
                                }

                                field()
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

                                return other is UnsetMetadata &&
                                    field == other.field &&
                                    additionalProperties == other.additionalProperties
                            }

                            private val hashCode: Int by lazy {
                                Objects.hash(field, additionalProperties)
                            }

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "UnsetMetadata{field=$field, additionalProperties=$additionalProperties}"
                        }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is OnUnknown &&
                                addTags == other.addTags &&
                                removeTags == other.removeTags &&
                                setMetadata == other.setMetadata &&
                                unsetMetadata == other.unsetMetadata &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(
                                addTags,
                                removeTags,
                                setMetadata,
                                unsetMetadata,
                                additionalProperties,
                            )
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "OnUnknown{addTags=$addTags, removeTags=$removeTags, setMetadata=$setMetadata, unsetMetadata=$unsetMetadata, additionalProperties=$additionalProperties}"
                    }

                    /** Actions to execute if the AI answers yes. */
                    class OnYes
                    private constructor(
                        private val addTags: JsonField<List<String>>,
                        private val removeTags: JsonField<List<String>>,
                        private val setMetadata: JsonField<List<SetMetadata>>,
                        private val unsetMetadata: JsonField<List<UnsetMetadata>>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        /**
                         * Array of tag strings to add to the asset.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun addTags(): Optional<List<String>> = addTags.getOptional("add_tags")

                        /**
                         * Array of tag strings to remove from the asset.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun removeTags(): Optional<List<String>> =
                            removeTags.getOptional("remove_tags")

                        /**
                         * Array of custom metadata field updates.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun setMetadata(): Optional<List<SetMetadata>> =
                            setMetadata.getOptional("set_metadata")

                        /**
                         * Array of custom metadata fields to remove.
                         *
                         * @throws ImageKitInvalidDataException if the JSON field has an unexpected
                         *   type (e.g. if the server responded with an unexpected value).
                         */
                        fun unsetMetadata(): Optional<List<UnsetMetadata>> =
                            unsetMetadata.getOptional("unset_metadata")

                        /**
                         * Returns the raw JSON value of [addTags].
                         *
                         * Unlike [addTags], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("add_tags")
                        @ExcludeMissing
                        fun _addTags(): JsonField<List<String>> = addTags

                        /**
                         * Returns the raw JSON value of [removeTags].
                         *
                         * Unlike [removeTags], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("remove_tags")
                        @ExcludeMissing
                        fun _removeTags(): JsonField<List<String>> = removeTags

                        /**
                         * Returns the raw JSON value of [setMetadata].
                         *
                         * Unlike [setMetadata], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("set_metadata")
                        @ExcludeMissing
                        fun _setMetadata(): JsonField<List<SetMetadata>> = setMetadata

                        /**
                         * Returns the raw JSON value of [unsetMetadata].
                         *
                         * Unlike [unsetMetadata], this method doesn't throw if the JSON field has
                         * an unexpected type.
                         */
                        @JsonProperty("unset_metadata")
                        @ExcludeMissing
                        fun _unsetMetadata(): JsonField<List<UnsetMetadata>> = unsetMetadata

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
                             * Returns a mutable builder for constructing an instance of [OnYes].
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [OnYes]. */
                        class Builder internal constructor() {

                            private var addTags: JsonField<MutableList<String>>? = null
                            private var removeTags: JsonField<MutableList<String>>? = null
                            private var setMetadata: JsonField<MutableList<SetMetadata>>? = null
                            private var unsetMetadata: JsonField<MutableList<UnsetMetadata>>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(onYes: OnYes) = apply {
                                addTags = onYes.addTags.map { it.toMutableList() }
                                removeTags = onYes.removeTags.map { it.toMutableList() }
                                setMetadata = onYes.setMetadata.map { it.toMutableList() }
                                unsetMetadata = onYes.unsetMetadata.map { it.toMutableList() }
                                additionalProperties = onYes.additionalProperties.toMutableMap()
                            }

                            /** Array of tag strings to add to the asset. */
                            fun addTags(addTags: List<String>) = addTags(JsonField.of(addTags))

                            /**
                             * Sets [Builder.addTags] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.addTags] with a well-typed
                             * `List<String>` value instead. This method is primarily for setting
                             * the field to an undocumented or not yet supported value.
                             */
                            fun addTags(addTags: JsonField<List<String>>) = apply {
                                this.addTags = addTags.map { it.toMutableList() }
                            }

                            /**
                             * Adds a single [String] to [addTags].
                             *
                             * @throws IllegalStateException if the field was previously set to a
                             *   non-list.
                             */
                            fun addAddTag(addTag: String) = apply {
                                addTags =
                                    (addTags ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("addTags", it).add(addTag)
                                    }
                            }

                            /** Array of tag strings to remove from the asset. */
                            fun removeTags(removeTags: List<String>) =
                                removeTags(JsonField.of(removeTags))

                            /**
                             * Sets [Builder.removeTags] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.removeTags] with a well-typed
                             * `List<String>` value instead. This method is primarily for setting
                             * the field to an undocumented or not yet supported value.
                             */
                            fun removeTags(removeTags: JsonField<List<String>>) = apply {
                                this.removeTags = removeTags.map { it.toMutableList() }
                            }

                            /**
                             * Adds a single [String] to [removeTags].
                             *
                             * @throws IllegalStateException if the field was previously set to a
                             *   non-list.
                             */
                            fun addRemoveTag(removeTag: String) = apply {
                                removeTags =
                                    (removeTags ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("removeTags", it).add(removeTag)
                                    }
                            }

                            /** Array of custom metadata field updates. */
                            fun setMetadata(setMetadata: List<SetMetadata>) =
                                setMetadata(JsonField.of(setMetadata))

                            /**
                             * Sets [Builder.setMetadata] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.setMetadata] with a well-typed
                             * `List<SetMetadata>` value instead. This method is primarily for
                             * setting the field to an undocumented or not yet supported value.
                             */
                            fun setMetadata(setMetadata: JsonField<List<SetMetadata>>) = apply {
                                this.setMetadata = setMetadata.map { it.toMutableList() }
                            }

                            /**
                             * Adds a single [SetMetadata] to [Builder.setMetadata].
                             *
                             * @throws IllegalStateException if the field was previously set to a
                             *   non-list.
                             */
                            fun addSetMetadata(setMetadata: SetMetadata) = apply {
                                this.setMetadata =
                                    (this.setMetadata ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("setMetadata", it).add(setMetadata)
                                    }
                            }

                            /** Array of custom metadata fields to remove. */
                            fun unsetMetadata(unsetMetadata: List<UnsetMetadata>) =
                                unsetMetadata(JsonField.of(unsetMetadata))

                            /**
                             * Sets [Builder.unsetMetadata] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.unsetMetadata] with a well-typed
                             * `List<UnsetMetadata>` value instead. This method is primarily for
                             * setting the field to an undocumented or not yet supported value.
                             */
                            fun unsetMetadata(unsetMetadata: JsonField<List<UnsetMetadata>>) =
                                apply {
                                    this.unsetMetadata = unsetMetadata.map { it.toMutableList() }
                                }

                            /**
                             * Adds a single [UnsetMetadata] to [Builder.unsetMetadata].
                             *
                             * @throws IllegalStateException if the field was previously set to a
                             *   non-list.
                             */
                            fun addUnsetMetadata(unsetMetadata: UnsetMetadata) = apply {
                                this.unsetMetadata =
                                    (this.unsetMetadata ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("unsetMetadata", it).add(unsetMetadata)
                                    }
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
                             * Returns an immutable instance of [OnYes].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             */
                            fun build(): OnYes =
                                OnYes(
                                    (addTags ?: JsonMissing.of()).map { it.toImmutable() },
                                    (removeTags ?: JsonMissing.of()).map { it.toImmutable() },
                                    (setMetadata ?: JsonMissing.of()).map { it.toImmutable() },
                                    (unsetMetadata ?: JsonMissing.of()).map { it.toImmutable() },
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): OnYes = apply {
                            if (validated) {
                                return@apply
                            }

                            addTags()
                            removeTags()
                            setMetadata().ifPresent { it.forEach { it.validate() } }
                            unsetMetadata().ifPresent { it.forEach { it.validate() } }
                            validated = true
                        }

                        fun isValid(): Boolean =
                            try {
                                validate()
                                true
                            } catch (e: ImageKitInvalidDataException) {
                                false
                            }

                        class SetMetadata
                        private constructor(
                            private val field: JsonField<String>,
                            private val value: JsonField<Value>,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            /**
                             * Name of the custom metadata field to set.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun field(): String = field.getRequired("field")

                            /**
                             * Value to set for the custom metadata field. The value type should
                             * match the custom metadata field type.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun value(): Value = value.getRequired("value")

                            /**
                             * Returns the raw JSON value of [field].
                             *
                             * Unlike [field], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("field")
                            @ExcludeMissing
                            fun _field(): JsonField<String> = field

                            /**
                             * Returns the raw JSON value of [value].
                             *
                             * Unlike [value], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("value")
                            @ExcludeMissing
                            fun _value(): JsonField<Value> = value

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
                                 * [SetMetadata].
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .field()
                                 * .value()
                                 * ```
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [SetMetadata]. */
                            class Builder internal constructor() {

                                private var field: JsonField<String>? = null
                                private var value: JsonField<Value>? = null
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(setMetadata: SetMetadata) = apply {
                                    field = setMetadata.field
                                    value = setMetadata.value
                                    additionalProperties =
                                        setMetadata.additionalProperties.toMutableMap()
                                }

                                /** Name of the custom metadata field to set. */
                                fun field(field: String) = field(JsonField.of(field))

                                /**
                                 * Sets [Builder.field] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.field] with a well-typed
                                 * [String] value instead. This method is primarily for setting the
                                 * field to an undocumented or not yet supported value.
                                 */
                                fun field(field: JsonField<String>) = apply { this.field = field }

                                /**
                                 * Value to set for the custom metadata field. The value type should
                                 * match the custom metadata field type.
                                 */
                                fun value(value: Value) = value(JsonField.of(value))

                                /**
                                 * Sets [Builder.value] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.value] with a well-typed [Value]
                                 * value instead. This method is primarily for setting the field to
                                 * an undocumented or not yet supported value.
                                 */
                                fun value(value: JsonField<Value>) = apply { this.value = value }

                                /** Alias for calling [value] with `Value.ofString(string)`. */
                                fun value(string: String) = value(Value.ofString(string))

                                /** Alias for calling [value] with `Value.ofNumber(number)`. */
                                fun value(number: Double) = value(Value.ofNumber(number))

                                /** Alias for calling [value] with `Value.ofBool(bool)`. */
                                fun value(bool: Boolean) = value(Value.ofBool(bool))

                                /** Alias for calling [value] with `Value.ofMixed(mixed)`. */
                                fun valueOfMixed(mixed: List<Value.UnnamedSchemaWithArrayParent7>) =
                                    value(Value.ofMixed(mixed))

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
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
                                 * Returns an immutable instance of [SetMetadata].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .field()
                                 * .value()
                                 * ```
                                 *
                                 * @throws IllegalStateException if any required field is unset.
                                 */
                                fun build(): SetMetadata =
                                    SetMetadata(
                                        checkRequired("field", field),
                                        checkRequired("value", value),
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            fun validate(): SetMetadata = apply {
                                if (validated) {
                                    return@apply
                                }

                                field()
                                value().validate()
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
                             * Value to set for the custom metadata field. The value type should
                             * match the custom metadata field type.
                             */
                            @JsonSerialize(using = Value.Serializer::class)
                            class Value
                            private constructor(
                                private val string: String? = null,
                                private val number: Double? = null,
                                private val bool: Boolean? = null,
                                private val mixed: List<UnnamedSchemaWithArrayParent7>? = null,
                                private val _json: JsonValue? = null,
                            ) {

                                fun string(): Optional<String> = Optional.ofNullable(string)

                                fun number(): Optional<Double> = Optional.ofNullable(number)

                                fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

                                fun mixed(): Optional<List<UnnamedSchemaWithArrayParent7>> =
                                    Optional.ofNullable(mixed)

                                fun isString(): Boolean = string != null

                                fun isNumber(): Boolean = number != null

                                fun isBool(): Boolean = bool != null

                                fun isMixed(): Boolean = mixed != null

                                fun asString(): String = string.getOrThrow("string")

                                fun asNumber(): Double = number.getOrThrow("number")

                                fun asBool(): Boolean = bool.getOrThrow("bool")

                                fun asMixed(): List<UnnamedSchemaWithArrayParent7> =
                                    mixed.getOrThrow("mixed")

                                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                                fun <T> accept(visitor: Visitor<T>): T =
                                    when {
                                        string != null -> visitor.visitString(string)
                                        number != null -> visitor.visitNumber(number)
                                        bool != null -> visitor.visitBool(bool)
                                        mixed != null -> visitor.visitMixed(mixed)
                                        else -> visitor.unknown(_json)
                                    }

                                private var validated: Boolean = false

                                fun validate(): Value = apply {
                                    if (validated) {
                                        return@apply
                                    }

                                    accept(
                                        object : Visitor<Unit> {
                                            override fun visitString(string: String) {}

                                            override fun visitNumber(number: Double) {}

                                            override fun visitBool(bool: Boolean) {}

                                            override fun visitMixed(
                                                mixed: List<UnnamedSchemaWithArrayParent7>
                                            ) {
                                                mixed.forEach { it.validate() }
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

                                    return other is Value &&
                                        string == other.string &&
                                        number == other.number &&
                                        bool == other.bool &&
                                        mixed == other.mixed
                                }

                                override fun hashCode(): Int =
                                    Objects.hash(string, number, bool, mixed)

                                override fun toString(): String =
                                    when {
                                        string != null -> "Value{string=$string}"
                                        number != null -> "Value{number=$number}"
                                        bool != null -> "Value{bool=$bool}"
                                        mixed != null -> "Value{mixed=$mixed}"
                                        _json != null -> "Value{_unknown=$_json}"
                                        else -> throw IllegalStateException("Invalid Value")
                                    }

                                companion object {

                                    @JvmStatic fun ofString(string: String) = Value(string = string)

                                    @JvmStatic fun ofNumber(number: Double) = Value(number = number)

                                    @JvmStatic fun ofBool(bool: Boolean) = Value(bool = bool)

                                    @JvmStatic
                                    fun ofMixed(mixed: List<UnnamedSchemaWithArrayParent7>) =
                                        Value(mixed = mixed.toImmutable())
                                }

                                /**
                                 * An interface that defines how to map each variant of [Value] to a
                                 * value of type [T].
                                 */
                                interface Visitor<out T> {

                                    fun visitString(string: String): T

                                    fun visitNumber(number: Double): T

                                    fun visitBool(bool: Boolean): T

                                    fun visitMixed(mixed: List<UnnamedSchemaWithArrayParent7>): T

                                    /**
                                     * Maps an unknown variant of [Value] to a value of type [T].
                                     *
                                     * An instance of [Value] can contain an unknown variant if it
                                     * was deserialized from data that doesn't match any known
                                     * variant. For example, if the SDK is on an older version than
                                     * the API, then the API may respond with new variants that the
                                     * SDK is unaware of.
                                     *
                                     * @throws ImageKitInvalidDataException in the default
                                     *   implementation.
                                     */
                                    fun unknown(json: JsonValue?): T {
                                        throw ImageKitInvalidDataException("Unknown Value: $json")
                                    }
                                }

                                internal class Serializer : BaseSerializer<Value>(Value::class) {

                                    override fun serialize(
                                        value: Value,
                                        generator: JsonGenerator,
                                        provider: SerializerProvider,
                                    ) {
                                        when {
                                            value.string != null ->
                                                generator.writeObject(value.string)
                                            value.number != null ->
                                                generator.writeObject(value.number)
                                            value.bool != null -> generator.writeObject(value.bool)
                                            value.mixed != null ->
                                                generator.writeObject(value.mixed)
                                            value._json != null ->
                                                generator.writeObject(value._json)
                                            else -> throw IllegalStateException("Invalid Value")
                                        }
                                    }
                                }

                                @JsonSerialize(
                                    using = UnnamedSchemaWithArrayParent7.Serializer::class
                                )
                                class UnnamedSchemaWithArrayParent7
                                private constructor(
                                    private val string: String? = null,
                                    private val number: Double? = null,
                                    private val bool: Boolean? = null,
                                    private val _json: JsonValue? = null,
                                ) {

                                    fun string(): Optional<String> = Optional.ofNullable(string)

                                    fun number(): Optional<Double> = Optional.ofNullable(number)

                                    fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

                                    fun isString(): Boolean = string != null

                                    fun isNumber(): Boolean = number != null

                                    fun isBool(): Boolean = bool != null

                                    fun asString(): String = string.getOrThrow("string")

                                    fun asNumber(): Double = number.getOrThrow("number")

                                    fun asBool(): Boolean = bool.getOrThrow("bool")

                                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                                    fun <T> accept(visitor: Visitor<T>): T =
                                        when {
                                            string != null -> visitor.visitString(string)
                                            number != null -> visitor.visitNumber(number)
                                            bool != null -> visitor.visitBool(bool)
                                            else -> visitor.unknown(_json)
                                        }

                                    private var validated: Boolean = false

                                    fun validate(): UnnamedSchemaWithArrayParent7 = apply {
                                        if (validated) {
                                            return@apply
                                        }

                                        accept(
                                            object : Visitor<Unit> {
                                                override fun visitString(string: String) {}

                                                override fun visitNumber(number: Double) {}

                                                override fun visitBool(bool: Boolean) {}
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

                                        return other is UnnamedSchemaWithArrayParent7 &&
                                            string == other.string &&
                                            number == other.number &&
                                            bool == other.bool
                                    }

                                    override fun hashCode(): Int =
                                        Objects.hash(string, number, bool)

                                    override fun toString(): String =
                                        when {
                                            string != null ->
                                                "UnnamedSchemaWithArrayParent7{string=$string}"
                                            number != null ->
                                                "UnnamedSchemaWithArrayParent7{number=$number}"
                                            bool != null ->
                                                "UnnamedSchemaWithArrayParent7{bool=$bool}"
                                            _json != null ->
                                                "UnnamedSchemaWithArrayParent7{_unknown=$_json}"
                                            else ->
                                                throw IllegalStateException(
                                                    "Invalid UnnamedSchemaWithArrayParent7"
                                                )
                                        }

                                    companion object {

                                        @JvmStatic
                                        fun ofString(string: String) =
                                            UnnamedSchemaWithArrayParent7(string = string)

                                        @JvmStatic
                                        fun ofNumber(number: Double) =
                                            UnnamedSchemaWithArrayParent7(number = number)

                                        @JvmStatic
                                        fun ofBool(bool: Boolean) =
                                            UnnamedSchemaWithArrayParent7(bool = bool)
                                    }

                                    /**
                                     * An interface that defines how to map each variant of
                                     * [UnnamedSchemaWithArrayParent7] to a value of type [T].
                                     */
                                    interface Visitor<out T> {

                                        fun visitString(string: String): T

                                        fun visitNumber(number: Double): T

                                        fun visitBool(bool: Boolean): T

                                        /**
                                         * Maps an unknown variant of
                                         * [UnnamedSchemaWithArrayParent7] to a value of type [T].
                                         *
                                         * An instance of [UnnamedSchemaWithArrayParent7] can
                                         * contain an unknown variant if it was deserialized from
                                         * data that doesn't match any known variant. For example,
                                         * if the SDK is on an older version than the API, then the
                                         * API may respond with new variants that the SDK is unaware
                                         * of.
                                         *
                                         * @throws ImageKitInvalidDataException in the default
                                         *   implementation.
                                         */
                                        fun unknown(json: JsonValue?): T {
                                            throw ImageKitInvalidDataException(
                                                "Unknown UnnamedSchemaWithArrayParent7: $json"
                                            )
                                        }
                                    }

                                    internal class Serializer :
                                        BaseSerializer<UnnamedSchemaWithArrayParent7>(
                                            UnnamedSchemaWithArrayParent7::class
                                        ) {

                                        override fun serialize(
                                            value: UnnamedSchemaWithArrayParent7,
                                            generator: JsonGenerator,
                                            provider: SerializerProvider,
                                        ) {
                                            when {
                                                value.string != null ->
                                                    generator.writeObject(value.string)
                                                value.number != null ->
                                                    generator.writeObject(value.number)
                                                value.bool != null ->
                                                    generator.writeObject(value.bool)
                                                value._json != null ->
                                                    generator.writeObject(value._json)
                                                else ->
                                                    throw IllegalStateException(
                                                        "Invalid UnnamedSchemaWithArrayParent7"
                                                    )
                                            }
                                        }
                                    }
                                }
                            }

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is SetMetadata &&
                                    field == other.field &&
                                    value == other.value &&
                                    additionalProperties == other.additionalProperties
                            }

                            private val hashCode: Int by lazy {
                                Objects.hash(field, value, additionalProperties)
                            }

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "SetMetadata{field=$field, value=$value, additionalProperties=$additionalProperties}"
                        }

                        class UnsetMetadata
                        private constructor(
                            private val field: JsonField<String>,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            /**
                             * Name of the custom metadata field to remove.
                             *
                             * @throws ImageKitInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun field(): String = field.getRequired("field")

                            /**
                             * Returns the raw JSON value of [field].
                             *
                             * Unlike [field], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("field")
                            @ExcludeMissing
                            fun _field(): JsonField<String> = field

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
                                 * [UnsetMetadata].
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .field()
                                 * ```
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [UnsetMetadata]. */
                            class Builder internal constructor() {

                                private var field: JsonField<String>? = null
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(unsetMetadata: UnsetMetadata) = apply {
                                    field = unsetMetadata.field
                                    additionalProperties =
                                        unsetMetadata.additionalProperties.toMutableMap()
                                }

                                /** Name of the custom metadata field to remove. */
                                fun field(field: String) = field(JsonField.of(field))

                                /**
                                 * Sets [Builder.field] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.field] with a well-typed
                                 * [String] value instead. This method is primarily for setting the
                                 * field to an undocumented or not yet supported value.
                                 */
                                fun field(field: JsonField<String>) = apply { this.field = field }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
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
                                 * Returns an immutable instance of [UnsetMetadata].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .field()
                                 * ```
                                 *
                                 * @throws IllegalStateException if any required field is unset.
                                 */
                                fun build(): UnsetMetadata =
                                    UnsetMetadata(
                                        checkRequired("field", field),
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            fun validate(): UnsetMetadata = apply {
                                if (validated) {
                                    return@apply
                                }

                                field()
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

                                return other is UnsetMetadata &&
                                    field == other.field &&
                                    additionalProperties == other.additionalProperties
                            }

                            private val hashCode: Int by lazy {
                                Objects.hash(field, additionalProperties)
                            }

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "UnsetMetadata{field=$field, additionalProperties=$additionalProperties}"
                        }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is OnYes &&
                                addTags == other.addTags &&
                                removeTags == other.removeTags &&
                                setMetadata == other.setMetadata &&
                                unsetMetadata == other.unsetMetadata &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(
                                addTags,
                                removeTags,
                                setMetadata,
                                unsetMetadata,
                                additionalProperties,
                            )
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "OnYes{addTags=$addTags, removeTags=$removeTags, setMetadata=$setMetadata, unsetMetadata=$unsetMetadata, additionalProperties=$additionalProperties}"
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is YesNo &&
                            instruction == other.instruction &&
                            type == other.type &&
                            onNo == other.onNo &&
                            onUnknown == other.onUnknown &&
                            onYes == other.onYes &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(
                            instruction,
                            type,
                            onNo,
                            onUnknown,
                            onYes,
                            additionalProperties,
                        )
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "YesNo{instruction=$instruction, type=$type, onNo=$onNo, onUnknown=$onUnknown, onYes=$onYes, additionalProperties=$additionalProperties}"
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is AiTasks &&
                    name == other.name &&
                    tasks == other.tasks &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(name, tasks, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "AiTasks{name=$name, tasks=$tasks, additionalProperties=$additionalProperties}"
        }

        class SavedExtension
        private constructor(
            private val id: JsonField<String>,
            private val name: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            /**
             * The unique ID of the saved extension to apply.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun id(): String = id.getRequired("id")

            /**
             * Indicates this is a reference to a saved extension.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("saved-extension")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonValue = name

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
                 * Returns a mutable builder for constructing an instance of [SavedExtension].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [SavedExtension]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var name: JsonValue = JsonValue.from("saved-extension")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(savedExtension: SavedExtension) = apply {
                    id = savedExtension.id
                    name = savedExtension.name
                    additionalProperties = savedExtension.additionalProperties.toMutableMap()
                }

                /** The unique ID of the saved extension to apply. */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("saved-extension")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonValue) = apply { this.name = name }

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
                 * Returns an immutable instance of [SavedExtension].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): SavedExtension =
                    SavedExtension(
                        checkRequired("id", id),
                        name,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): SavedExtension = apply {
                if (validated) {
                    return@apply
                }

                id()
                _name().let {
                    if (it != JsonValue.from("saved-extension")) {
                        throw ImageKitInvalidDataException("'name' is invalid, received $it")
                    }
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

                return other is SavedExtension &&
                    id == other.id &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(id, name, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "SavedExtension{id=$id, name=$name, additionalProperties=$additionalProperties}"
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
                        override fun visitTransformation(transformation: InnerTransformation) {
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
                fun ofTransformation(transformation: InnerTransformation) =
                    Post(transformation = transformation)

                @JvmStatic fun ofGifToVideo(gifToVideo: GifToVideo) = Post(gifToVideo = gifToVideo)

                @JvmStatic fun ofThumbnail(thumbnail: Thumbnail) = Post(thumbnail = thumbnail)

                @JvmStatic fun ofAbs(abs: Abs) = Post(abs = abs)
            }

            /**
             * An interface that defines how to map each variant of [Post] to a value of type [T].
             */
            interface Visitor<out T> {

                fun visitTransformation(transformation: InnerTransformation): T

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
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

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
                     * Returns an immutable instance of [InnerTransformation].
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
