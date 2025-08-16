// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.imagekit.api.core.Enum
import com.imagekit.api.core.ExcludeMissing
import com.imagekit.api.core.JsonField
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.MultipartField
import com.imagekit.api.core.Params
import com.imagekit.api.core.checkRequired
import com.imagekit.api.core.http.Headers
import com.imagekit.api.core.http.QueryParams
import com.imagekit.api.core.toImmutable
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/**
 * ImageKit.io allows you to upload files directly from both the server and client sides. For
 * server-side uploads, private API key authentication is used. For client-side uploads, generate a
 * one-time `token`, `signature`, and `expiration` from your secure backend using private API.
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
class FileUploadV1Params
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Pass the HTTP URL or base64 string. When passing a URL in the file parameter, please ensure
     * that our servers can access the URL. In case ImageKit is unable to download the file from the
     * specified URL, a `400` error response is returned. This will also result in a `400` error if
     * the file download request is aborted if response headers are not received in 8 seconds.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun file(): String = body.file()

    /**
     * The name with which the file has to be uploaded. The file name can contain:
     * - Alphanumeric Characters: `a-z`, `A-Z`, `0-9`.
     * - Special Characters: `.`, `-`
     *
     * Any other character including space will be replaced by `_`
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun fileName(): String = body.fileName()

    /**
     * A unique value that the ImageKit.io server will use to recognize and prevent subsequent
     * retries for the same request. We suggest using V4 UUIDs, or another random string with enough
     * entropy to avoid collisions. This field is only required for authentication when uploading a
     * file from the client side.
     *
     * **Note**: Sending a value that has been used in the past will result in a validation error.
     * Even if your previous request resulted in an error, you should always send a new value for
     * this field.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun token(): Optional<String> = body.token()

    /**
     * Server-side checks to run on the asset. Read more about
     * [Upload API checks](/docs/api-reference/upload-file/upload-file#upload-api-checks).
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
     * Stringified JSON key-value data to be associated with the asset.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun customMetadata(): Optional<String> = body.customMetadata()

    /**
     * The time until your signature is valid. It must be a
     * [Unix time](https://en.wikipedia.org/wiki/Unix_time) in less than 1 hour into the future. It
     * should be in seconds. This field is only required for authentication when uploading a file
     * from the client side.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun expire(): Optional<String> = body.expire()

    /**
     * Stringified JSON object with an array of extensions to be applied to the image. Refer to
     * extensions schema in
     * [update file API request body](/docs/api-reference/digital-asset-management-dam/managing-assets/update-file-details#request-body).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun extensions(): Optional<String> = body.extensions()

    /**
     * The folder path in which the image has to be uploaded. If the folder(s) didn't exist before,
     * a new folder(s) is created.
     *
     * The folder name can contain:
     * - Alphanumeric Characters: `a-z` , `A-Z` , `0-9`
     * - Special Characters: `/` , `_` , `-`
     *
     * Using multiple `/` creates a nested folder.
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
    fun isPrivateFile(): Optional<IsPrivateFile> = body.isPrivateFile()

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
    fun isPublished(): Optional<IsPublished> = body.isPublished()

    /**
     * If set to `true` and a file already exists at the exact location, its AITags will be removed.
     * Set `overwriteAITags` to `false` to preserve AITags.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun overwriteAiTags(): Optional<OverwriteAiTags> = body.overwriteAiTags()

    /**
     * If the request does not have `customMetadata`, and a file already exists at the exact
     * location, existing customMetadata will be removed.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun overwriteCustomMetadata(): Optional<OverwriteCustomMetadata> =
        body.overwriteCustomMetadata()

    /**
     * If `false` and `useUniqueFileName` is also `false`, and a file already exists at the exact
     * location, upload API will return an error immediately.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun overwriteFile(): Optional<String> = body.overwriteFile()

    /**
     * If the request does not have `tags`, and a file already exists at the exact location,
     * existing tags will be removed.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun overwriteTags(): Optional<OverwriteTags> = body.overwriteTags()

    /**
     * Your ImageKit.io public key. This field is only required for authentication when uploading a
     * file from the client side.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun publicKey(): Optional<String> = body.publicKey()

    /**
     * Comma-separated values of the fields that you want the API to return in the response.
     *
     * For example, set the value of this field to `tags,customCoordinates,isPrivateFile` to get the
     * value of `tags`, `customCoordinates`, and `isPrivateFile` in the response.
     *
     * Accepts combination of `tags`, `customCoordinates`, `isPrivateFile`, `embeddedMetadata`,
     * `isPublished`, `customMetadata`, and `metadata`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun responseFields(): Optional<String> = body.responseFields()

    /**
     * HMAC-SHA1 digest of the token+expire using your ImageKit.io private API key as a key. Learn
     * how to create a signature on the page below. This should be in lowercase.
     *
     * Signature must be calculated on the server-side. This field is only required for
     * authentication when uploading a file from the client side.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun signature(): Optional<String> = body.signature()

    /**
     * Set the tags while uploading the file.
     *
     * Comma-separated value of tags in the format `tag1,tag2,tag3`. The maximum length of all
     * characters should not exceed 500. `%` is not allowed.
     *
     * If this field is not specified and the file is overwritten then the tags will be removed.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tags(): Optional<String> = body.tags()

    /**
     * Stringified JSON object with properties for pre and post transformations:
     *
     * `pre` - Accepts a "string" containing a valid transformation used for requesting a
     * pre-transformation for an image or a video file.
     *
     * `post` - Accepts an array of objects with properties:
     * - `type`: One of `transformation`, `gif-to-video`, `thumbnail`, or `abs` (Adaptive bitrate
     *   streaming).
     * - `value`: A "string" corresponding to the required transformation. Required if `type` is
     *   `transformation` or `abs`. Optional if `type` is `gif-to-video` or `thumbnail`.
     * - `protocol`: Either `hls` or `dash`, applicable only if `type` is `abs`.
     *
     * Read more about [Adaptive bitrate streaming (ABS)](/docs/adaptive-bitrate-streaming).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun transformation(): Optional<String> = body.transformation()

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
    fun useUniqueFileName(): Optional<UseUniqueFileName> = body.useUniqueFileName()

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
    fun _file(): MultipartField<String> = body._file()

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
    fun _customMetadata(): MultipartField<String> = body._customMetadata()

    /**
     * Returns the raw multipart value of [expire].
     *
     * Unlike [expire], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _expire(): MultipartField<String> = body._expire()

    /**
     * Returns the raw multipart value of [extensions].
     *
     * Unlike [extensions], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _extensions(): MultipartField<String> = body._extensions()

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
    fun _isPrivateFile(): MultipartField<IsPrivateFile> = body._isPrivateFile()

    /**
     * Returns the raw multipart value of [isPublished].
     *
     * Unlike [isPublished], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _isPublished(): MultipartField<IsPublished> = body._isPublished()

    /**
     * Returns the raw multipart value of [overwriteAiTags].
     *
     * Unlike [overwriteAiTags], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _overwriteAiTags(): MultipartField<OverwriteAiTags> = body._overwriteAiTags()

    /**
     * Returns the raw multipart value of [overwriteCustomMetadata].
     *
     * Unlike [overwriteCustomMetadata], this method doesn't throw if the multipart field has an
     * unexpected type.
     */
    fun _overwriteCustomMetadata(): MultipartField<OverwriteCustomMetadata> =
        body._overwriteCustomMetadata()

    /**
     * Returns the raw multipart value of [overwriteFile].
     *
     * Unlike [overwriteFile], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _overwriteFile(): MultipartField<String> = body._overwriteFile()

    /**
     * Returns the raw multipart value of [overwriteTags].
     *
     * Unlike [overwriteTags], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _overwriteTags(): MultipartField<OverwriteTags> = body._overwriteTags()

    /**
     * Returns the raw multipart value of [publicKey].
     *
     * Unlike [publicKey], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _publicKey(): MultipartField<String> = body._publicKey()

    /**
     * Returns the raw multipart value of [responseFields].
     *
     * Unlike [responseFields], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _responseFields(): MultipartField<String> = body._responseFields()

    /**
     * Returns the raw multipart value of [signature].
     *
     * Unlike [signature], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _signature(): MultipartField<String> = body._signature()

    /**
     * Returns the raw multipart value of [tags].
     *
     * Unlike [tags], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _tags(): MultipartField<String> = body._tags()

    /**
     * Returns the raw multipart value of [transformation].
     *
     * Unlike [transformation], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _transformation(): MultipartField<String> = body._transformation()

    /**
     * Returns the raw multipart value of [useUniqueFileName].
     *
     * Unlike [useUniqueFileName], this method doesn't throw if the multipart field has an
     * unexpected type.
     */
    fun _useUniqueFileName(): MultipartField<UseUniqueFileName> = body._useUniqueFileName()

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
         * Returns a mutable builder for constructing an instance of [FileUploadV1Params].
         *
         * The following fields are required:
         * ```java
         * .file()
         * .fileName()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileUploadV1Params]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(fileUploadV1Params: FileUploadV1Params) = apply {
            body = fileUploadV1Params.body.toBuilder()
            additionalHeaders = fileUploadV1Params.additionalHeaders.toBuilder()
            additionalQueryParams = fileUploadV1Params.additionalQueryParams.toBuilder()
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
         * Pass the HTTP URL or base64 string. When passing a URL in the file parameter, please
         * ensure that our servers can access the URL. In case ImageKit is unable to download the
         * file from the specified URL, a `400` error response is returned. This will also result in
         * a `400` error if the file download request is aborted if response headers are not
         * received in 8 seconds.
         */
        fun file(file: String) = apply { body.file(file) }

        /**
         * Sets [Builder.file] to an arbitrary multipart value.
         *
         * You should usually call [Builder.file] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun file(file: MultipartField<String>) = apply { body.file(file) }

        /**
         * The name with which the file has to be uploaded. The file name can contain:
         * - Alphanumeric Characters: `a-z`, `A-Z`, `0-9`.
         * - Special Characters: `.`, `-`
         *
         * Any other character including space will be replaced by `_`
         */
        fun fileName(fileName: String) = apply { body.fileName(fileName) }

        /**
         * Sets [Builder.fileName] to an arbitrary multipart value.
         *
         * You should usually call [Builder.fileName] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fileName(fileName: MultipartField<String>) = apply { body.fileName(fileName) }

        /**
         * A unique value that the ImageKit.io server will use to recognize and prevent subsequent
         * retries for the same request. We suggest using V4 UUIDs, or another random string with
         * enough entropy to avoid collisions. This field is only required for authentication when
         * uploading a file from the client side.
         *
         * **Note**: Sending a value that has been used in the past will result in a validation
         * error. Even if your previous request resulted in an error, you should always send a new
         * value for this field.
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
         * [Upload API checks](/docs/api-reference/upload-file/upload-file#upload-api-checks).
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

        /** Stringified JSON key-value data to be associated with the asset. */
        fun customMetadata(customMetadata: String) = apply { body.customMetadata(customMetadata) }

        /**
         * Sets [Builder.customMetadata] to an arbitrary multipart value.
         *
         * You should usually call [Builder.customMetadata] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun customMetadata(customMetadata: MultipartField<String>) = apply {
            body.customMetadata(customMetadata)
        }

        /**
         * The time until your signature is valid. It must be a
         * [Unix time](https://en.wikipedia.org/wiki/Unix_time) in less than 1 hour into the future.
         * It should be in seconds. This field is only required for authentication when uploading a
         * file from the client side.
         */
        fun expire(expire: String) = apply { body.expire(expire) }

        /**
         * Sets [Builder.expire] to an arbitrary multipart value.
         *
         * You should usually call [Builder.expire] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun expire(expire: MultipartField<String>) = apply { body.expire(expire) }

        /**
         * Stringified JSON object with an array of extensions to be applied to the image. Refer to
         * extensions schema in
         * [update file API request body](/docs/api-reference/digital-asset-management-dam/managing-assets/update-file-details#request-body).
         */
        fun extensions(extensions: String) = apply { body.extensions(extensions) }

        /**
         * Sets [Builder.extensions] to an arbitrary multipart value.
         *
         * You should usually call [Builder.extensions] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun extensions(extensions: MultipartField<String>) = apply { body.extensions(extensions) }

        /**
         * The folder path in which the image has to be uploaded. If the folder(s) didn't exist
         * before, a new folder(s) is created.
         *
         * The folder name can contain:
         * - Alphanumeric Characters: `a-z` , `A-Z` , `0-9`
         * - Special Characters: `/` , `_` , `-`
         *
         * Using multiple `/` creates a nested folder.
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
        fun isPrivateFile(isPrivateFile: IsPrivateFile) = apply {
            body.isPrivateFile(isPrivateFile)
        }

        /**
         * Sets [Builder.isPrivateFile] to an arbitrary multipart value.
         *
         * You should usually call [Builder.isPrivateFile] with a well-typed [IsPrivateFile] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun isPrivateFile(isPrivateFile: MultipartField<IsPrivateFile>) = apply {
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
        fun isPublished(isPublished: IsPublished) = apply { body.isPublished(isPublished) }

        /**
         * Sets [Builder.isPublished] to an arbitrary multipart value.
         *
         * You should usually call [Builder.isPublished] with a well-typed [IsPublished] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun isPublished(isPublished: MultipartField<IsPublished>) = apply {
            body.isPublished(isPublished)
        }

        /**
         * If set to `true` and a file already exists at the exact location, its AITags will be
         * removed. Set `overwriteAITags` to `false` to preserve AITags.
         */
        fun overwriteAiTags(overwriteAiTags: OverwriteAiTags) = apply {
            body.overwriteAiTags(overwriteAiTags)
        }

        /**
         * Sets [Builder.overwriteAiTags] to an arbitrary multipart value.
         *
         * You should usually call [Builder.overwriteAiTags] with a well-typed [OverwriteAiTags]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun overwriteAiTags(overwriteAiTags: MultipartField<OverwriteAiTags>) = apply {
            body.overwriteAiTags(overwriteAiTags)
        }

        /**
         * If the request does not have `customMetadata`, and a file already exists at the exact
         * location, existing customMetadata will be removed.
         */
        fun overwriteCustomMetadata(overwriteCustomMetadata: OverwriteCustomMetadata) = apply {
            body.overwriteCustomMetadata(overwriteCustomMetadata)
        }

        /**
         * Sets [Builder.overwriteCustomMetadata] to an arbitrary multipart value.
         *
         * You should usually call [Builder.overwriteCustomMetadata] with a well-typed
         * [OverwriteCustomMetadata] value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun overwriteCustomMetadata(
            overwriteCustomMetadata: MultipartField<OverwriteCustomMetadata>
        ) = apply { body.overwriteCustomMetadata(overwriteCustomMetadata) }

        /**
         * If `false` and `useUniqueFileName` is also `false`, and a file already exists at the
         * exact location, upload API will return an error immediately.
         */
        fun overwriteFile(overwriteFile: String) = apply { body.overwriteFile(overwriteFile) }

        /**
         * Sets [Builder.overwriteFile] to an arbitrary multipart value.
         *
         * You should usually call [Builder.overwriteFile] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun overwriteFile(overwriteFile: MultipartField<String>) = apply {
            body.overwriteFile(overwriteFile)
        }

        /**
         * If the request does not have `tags`, and a file already exists at the exact location,
         * existing tags will be removed.
         */
        fun overwriteTags(overwriteTags: OverwriteTags) = apply {
            body.overwriteTags(overwriteTags)
        }

        /**
         * Sets [Builder.overwriteTags] to an arbitrary multipart value.
         *
         * You should usually call [Builder.overwriteTags] with a well-typed [OverwriteTags] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun overwriteTags(overwriteTags: MultipartField<OverwriteTags>) = apply {
            body.overwriteTags(overwriteTags)
        }

        /**
         * Your ImageKit.io public key. This field is only required for authentication when
         * uploading a file from the client side.
         */
        fun publicKey(publicKey: String) = apply { body.publicKey(publicKey) }

        /**
         * Sets [Builder.publicKey] to an arbitrary multipart value.
         *
         * You should usually call [Builder.publicKey] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun publicKey(publicKey: MultipartField<String>) = apply { body.publicKey(publicKey) }

        /**
         * Comma-separated values of the fields that you want the API to return in the response.
         *
         * For example, set the value of this field to `tags,customCoordinates,isPrivateFile` to get
         * the value of `tags`, `customCoordinates`, and `isPrivateFile` in the response.
         *
         * Accepts combination of `tags`, `customCoordinates`, `isPrivateFile`, `embeddedMetadata`,
         * `isPublished`, `customMetadata`, and `metadata`.
         */
        fun responseFields(responseFields: String) = apply { body.responseFields(responseFields) }

        /**
         * Sets [Builder.responseFields] to an arbitrary multipart value.
         *
         * You should usually call [Builder.responseFields] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun responseFields(responseFields: MultipartField<String>) = apply {
            body.responseFields(responseFields)
        }

        /**
         * HMAC-SHA1 digest of the token+expire using your ImageKit.io private API key as a key.
         * Learn how to create a signature on the page below. This should be in lowercase.
         *
         * Signature must be calculated on the server-side. This field is only required for
         * authentication when uploading a file from the client side.
         */
        fun signature(signature: String) = apply { body.signature(signature) }

        /**
         * Sets [Builder.signature] to an arbitrary multipart value.
         *
         * You should usually call [Builder.signature] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun signature(signature: MultipartField<String>) = apply { body.signature(signature) }

        /**
         * Set the tags while uploading the file.
         *
         * Comma-separated value of tags in the format `tag1,tag2,tag3`. The maximum length of all
         * characters should not exceed 500. `%` is not allowed.
         *
         * If this field is not specified and the file is overwritten then the tags will be removed.
         */
        fun tags(tags: String) = apply { body.tags(tags) }

        /**
         * Sets [Builder.tags] to an arbitrary multipart value.
         *
         * You should usually call [Builder.tags] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tags(tags: MultipartField<String>) = apply { body.tags(tags) }

        /**
         * Stringified JSON object with properties for pre and post transformations:
         *
         * `pre` - Accepts a "string" containing a valid transformation used for requesting a
         * pre-transformation for an image or a video file.
         *
         * `post` - Accepts an array of objects with properties:
         * - `type`: One of `transformation`, `gif-to-video`, `thumbnail`, or `abs` (Adaptive
         *   bitrate streaming).
         * - `value`: A "string" corresponding to the required transformation. Required if `type` is
         *   `transformation` or `abs`. Optional if `type` is `gif-to-video` or `thumbnail`.
         * - `protocol`: Either `hls` or `dash`, applicable only if `type` is `abs`.
         *
         * Read more about [Adaptive bitrate streaming (ABS)](/docs/adaptive-bitrate-streaming).
         */
        fun transformation(transformation: String) = apply { body.transformation(transformation) }

        /**
         * Sets [Builder.transformation] to an arbitrary multipart value.
         *
         * You should usually call [Builder.transformation] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun transformation(transformation: MultipartField<String>) = apply {
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
        fun useUniqueFileName(useUniqueFileName: UseUniqueFileName) = apply {
            body.useUniqueFileName(useUniqueFileName)
        }

        /**
         * Sets [Builder.useUniqueFileName] to an arbitrary multipart value.
         *
         * You should usually call [Builder.useUniqueFileName] with a well-typed [UseUniqueFileName]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun useUniqueFileName(useUniqueFileName: MultipartField<UseUniqueFileName>) = apply {
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
         * Returns an immutable instance of [FileUploadV1Params].
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
        fun build(): FileUploadV1Params =
            FileUploadV1Params(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Map<String, MultipartField<*>> =
        (mapOf(
                "file" to _file(),
                "fileName" to _fileName(),
                "token" to _token(),
                "checks" to _checks(),
                "customCoordinates" to _customCoordinates(),
                "customMetadata" to _customMetadata(),
                "expire" to _expire(),
                "extensions" to _extensions(),
                "folder" to _folder(),
                "isPrivateFile" to _isPrivateFile(),
                "isPublished" to _isPublished(),
                "overwriteAITags" to _overwriteAiTags(),
                "overwriteCustomMetadata" to _overwriteCustomMetadata(),
                "overwriteFile" to _overwriteFile(),
                "overwriteTags" to _overwriteTags(),
                "publicKey" to _publicKey(),
                "responseFields" to _responseFields(),
                "signature" to _signature(),
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
        private val file: MultipartField<String>,
        private val fileName: MultipartField<String>,
        private val token: MultipartField<String>,
        private val checks: MultipartField<String>,
        private val customCoordinates: MultipartField<String>,
        private val customMetadata: MultipartField<String>,
        private val expire: MultipartField<String>,
        private val extensions: MultipartField<String>,
        private val folder: MultipartField<String>,
        private val isPrivateFile: MultipartField<IsPrivateFile>,
        private val isPublished: MultipartField<IsPublished>,
        private val overwriteAiTags: MultipartField<OverwriteAiTags>,
        private val overwriteCustomMetadata: MultipartField<OverwriteCustomMetadata>,
        private val overwriteFile: MultipartField<String>,
        private val overwriteTags: MultipartField<OverwriteTags>,
        private val publicKey: MultipartField<String>,
        private val responseFields: MultipartField<String>,
        private val signature: MultipartField<String>,
        private val tags: MultipartField<String>,
        private val transformation: MultipartField<String>,
        private val useUniqueFileName: MultipartField<UseUniqueFileName>,
        private val webhookUrl: MultipartField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        /**
         * Pass the HTTP URL or base64 string. When passing a URL in the file parameter, please
         * ensure that our servers can access the URL. In case ImageKit is unable to download the
         * file from the specified URL, a `400` error response is returned. This will also result in
         * a `400` error if the file download request is aborted if response headers are not
         * received in 8 seconds.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
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
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun fileName(): String = fileName.value.getRequired("fileName")

        /**
         * A unique value that the ImageKit.io server will use to recognize and prevent subsequent
         * retries for the same request. We suggest using V4 UUIDs, or another random string with
         * enough entropy to avoid collisions. This field is only required for authentication when
         * uploading a file from the client side.
         *
         * **Note**: Sending a value that has been used in the past will result in a validation
         * error. Even if your previous request resulted in an error, you should always send a new
         * value for this field.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun token(): Optional<String> = token.value.getOptional("token")

        /**
         * Server-side checks to run on the asset. Read more about
         * [Upload API checks](/docs/api-reference/upload-file/upload-file#upload-api-checks).
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
         * Stringified JSON key-value data to be associated with the asset.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun customMetadata(): Optional<String> = customMetadata.value.getOptional("customMetadata")

        /**
         * The time until your signature is valid. It must be a
         * [Unix time](https://en.wikipedia.org/wiki/Unix_time) in less than 1 hour into the future.
         * It should be in seconds. This field is only required for authentication when uploading a
         * file from the client side.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun expire(): Optional<String> = expire.value.getOptional("expire")

        /**
         * Stringified JSON object with an array of extensions to be applied to the image. Refer to
         * extensions schema in
         * [update file API request body](/docs/api-reference/digital-asset-management-dam/managing-assets/update-file-details#request-body).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun extensions(): Optional<String> = extensions.value.getOptional("extensions")

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
        fun isPrivateFile(): Optional<IsPrivateFile> =
            isPrivateFile.value.getOptional("isPrivateFile")

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
        fun isPublished(): Optional<IsPublished> = isPublished.value.getOptional("isPublished")

        /**
         * If set to `true` and a file already exists at the exact location, its AITags will be
         * removed. Set `overwriteAITags` to `false` to preserve AITags.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun overwriteAiTags(): Optional<OverwriteAiTags> =
            overwriteAiTags.value.getOptional("overwriteAITags")

        /**
         * If the request does not have `customMetadata`, and a file already exists at the exact
         * location, existing customMetadata will be removed.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun overwriteCustomMetadata(): Optional<OverwriteCustomMetadata> =
            overwriteCustomMetadata.value.getOptional("overwriteCustomMetadata")

        /**
         * If `false` and `useUniqueFileName` is also `false`, and a file already exists at the
         * exact location, upload API will return an error immediately.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun overwriteFile(): Optional<String> = overwriteFile.value.getOptional("overwriteFile")

        /**
         * If the request does not have `tags`, and a file already exists at the exact location,
         * existing tags will be removed.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun overwriteTags(): Optional<OverwriteTags> =
            overwriteTags.value.getOptional("overwriteTags")

        /**
         * Your ImageKit.io public key. This field is only required for authentication when
         * uploading a file from the client side.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun publicKey(): Optional<String> = publicKey.value.getOptional("publicKey")

        /**
         * Comma-separated values of the fields that you want the API to return in the response.
         *
         * For example, set the value of this field to `tags,customCoordinates,isPrivateFile` to get
         * the value of `tags`, `customCoordinates`, and `isPrivateFile` in the response.
         *
         * Accepts combination of `tags`, `customCoordinates`, `isPrivateFile`, `embeddedMetadata`,
         * `isPublished`, `customMetadata`, and `metadata`.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun responseFields(): Optional<String> = responseFields.value.getOptional("responseFields")

        /**
         * HMAC-SHA1 digest of the token+expire using your ImageKit.io private API key as a key.
         * Learn how to create a signature on the page below. This should be in lowercase.
         *
         * Signature must be calculated on the server-side. This field is only required for
         * authentication when uploading a file from the client side.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun signature(): Optional<String> = signature.value.getOptional("signature")

        /**
         * Set the tags while uploading the file.
         *
         * Comma-separated value of tags in the format `tag1,tag2,tag3`. The maximum length of all
         * characters should not exceed 500. `%` is not allowed.
         *
         * If this field is not specified and the file is overwritten then the tags will be removed.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun tags(): Optional<String> = tags.value.getOptional("tags")

        /**
         * Stringified JSON object with properties for pre and post transformations:
         *
         * `pre` - Accepts a "string" containing a valid transformation used for requesting a
         * pre-transformation for an image or a video file.
         *
         * `post` - Accepts an array of objects with properties:
         * - `type`: One of `transformation`, `gif-to-video`, `thumbnail`, or `abs` (Adaptive
         *   bitrate streaming).
         * - `value`: A "string" corresponding to the required transformation. Required if `type` is
         *   `transformation` or `abs`. Optional if `type` is `gif-to-video` or `thumbnail`.
         * - `protocol`: Either `hls` or `dash`, applicable only if `type` is `abs`.
         *
         * Read more about [Adaptive bitrate streaming (ABS)](/docs/adaptive-bitrate-streaming).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun transformation(): Optional<String> = transformation.value.getOptional("transformation")

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
        fun useUniqueFileName(): Optional<UseUniqueFileName> =
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
        @JsonProperty("file") @ExcludeMissing fun _file(): MultipartField<String> = file

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
        fun _customMetadata(): MultipartField<String> = customMetadata

        /**
         * Returns the raw multipart value of [expire].
         *
         * Unlike [expire], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("expire") @ExcludeMissing fun _expire(): MultipartField<String> = expire

        /**
         * Returns the raw multipart value of [extensions].
         *
         * Unlike [extensions], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("extensions")
        @ExcludeMissing
        fun _extensions(): MultipartField<String> = extensions

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
        fun _isPrivateFile(): MultipartField<IsPrivateFile> = isPrivateFile

        /**
         * Returns the raw multipart value of [isPublished].
         *
         * Unlike [isPublished], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("isPublished")
        @ExcludeMissing
        fun _isPublished(): MultipartField<IsPublished> = isPublished

        /**
         * Returns the raw multipart value of [overwriteAiTags].
         *
         * Unlike [overwriteAiTags], this method doesn't throw if the multipart field has an
         * unexpected type.
         */
        @JsonProperty("overwriteAITags")
        @ExcludeMissing
        fun _overwriteAiTags(): MultipartField<OverwriteAiTags> = overwriteAiTags

        /**
         * Returns the raw multipart value of [overwriteCustomMetadata].
         *
         * Unlike [overwriteCustomMetadata], this method doesn't throw if the multipart field has an
         * unexpected type.
         */
        @JsonProperty("overwriteCustomMetadata")
        @ExcludeMissing
        fun _overwriteCustomMetadata(): MultipartField<OverwriteCustomMetadata> =
            overwriteCustomMetadata

        /**
         * Returns the raw multipart value of [overwriteFile].
         *
         * Unlike [overwriteFile], this method doesn't throw if the multipart field has an
         * unexpected type.
         */
        @JsonProperty("overwriteFile")
        @ExcludeMissing
        fun _overwriteFile(): MultipartField<String> = overwriteFile

        /**
         * Returns the raw multipart value of [overwriteTags].
         *
         * Unlike [overwriteTags], this method doesn't throw if the multipart field has an
         * unexpected type.
         */
        @JsonProperty("overwriteTags")
        @ExcludeMissing
        fun _overwriteTags(): MultipartField<OverwriteTags> = overwriteTags

        /**
         * Returns the raw multipart value of [publicKey].
         *
         * Unlike [publicKey], this method doesn't throw if the multipart field has an unexpected
         * type.
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
        fun _responseFields(): MultipartField<String> = responseFields

        /**
         * Returns the raw multipart value of [signature].
         *
         * Unlike [signature], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("signature")
        @ExcludeMissing
        fun _signature(): MultipartField<String> = signature

        /**
         * Returns the raw multipart value of [tags].
         *
         * Unlike [tags], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("tags") @ExcludeMissing fun _tags(): MultipartField<String> = tags

        /**
         * Returns the raw multipart value of [transformation].
         *
         * Unlike [transformation], this method doesn't throw if the multipart field has an
         * unexpected type.
         */
        @JsonProperty("transformation")
        @ExcludeMissing
        fun _transformation(): MultipartField<String> = transformation

        /**
         * Returns the raw multipart value of [useUniqueFileName].
         *
         * Unlike [useUniqueFileName], this method doesn't throw if the multipart field has an
         * unexpected type.
         */
        @JsonProperty("useUniqueFileName")
        @ExcludeMissing
        fun _useUniqueFileName(): MultipartField<UseUniqueFileName> = useUniqueFileName

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

            private var file: MultipartField<String>? = null
            private var fileName: MultipartField<String>? = null
            private var token: MultipartField<String> = MultipartField.of(null)
            private var checks: MultipartField<String> = MultipartField.of(null)
            private var customCoordinates: MultipartField<String> = MultipartField.of(null)
            private var customMetadata: MultipartField<String> = MultipartField.of(null)
            private var expire: MultipartField<String> = MultipartField.of(null)
            private var extensions: MultipartField<String> = MultipartField.of(null)
            private var folder: MultipartField<String> = MultipartField.of(null)
            private var isPrivateFile: MultipartField<IsPrivateFile> = MultipartField.of(null)
            private var isPublished: MultipartField<IsPublished> = MultipartField.of(null)
            private var overwriteAiTags: MultipartField<OverwriteAiTags> = MultipartField.of(null)
            private var overwriteCustomMetadata: MultipartField<OverwriteCustomMetadata> =
                MultipartField.of(null)
            private var overwriteFile: MultipartField<String> = MultipartField.of(null)
            private var overwriteTags: MultipartField<OverwriteTags> = MultipartField.of(null)
            private var publicKey: MultipartField<String> = MultipartField.of(null)
            private var responseFields: MultipartField<String> = MultipartField.of(null)
            private var signature: MultipartField<String> = MultipartField.of(null)
            private var tags: MultipartField<String> = MultipartField.of(null)
            private var transformation: MultipartField<String> = MultipartField.of(null)
            private var useUniqueFileName: MultipartField<UseUniqueFileName> =
                MultipartField.of(null)
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
                expire = body.expire
                extensions = body.extensions
                folder = body.folder
                isPrivateFile = body.isPrivateFile
                isPublished = body.isPublished
                overwriteAiTags = body.overwriteAiTags
                overwriteCustomMetadata = body.overwriteCustomMetadata
                overwriteFile = body.overwriteFile
                overwriteTags = body.overwriteTags
                publicKey = body.publicKey
                responseFields = body.responseFields
                signature = body.signature
                tags = body.tags
                transformation = body.transformation
                useUniqueFileName = body.useUniqueFileName
                webhookUrl = body.webhookUrl
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Pass the HTTP URL or base64 string. When passing a URL in the file parameter, please
             * ensure that our servers can access the URL. In case ImageKit is unable to download
             * the file from the specified URL, a `400` error response is returned. This will also
             * result in a `400` error if the file download request is aborted if response headers
             * are not received in 8 seconds.
             */
            fun file(file: String) = file(MultipartField.of(file))

            /**
             * Sets [Builder.file] to an arbitrary multipart value.
             *
             * You should usually call [Builder.file] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
             * You should usually call [Builder.fileName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fileName(fileName: MultipartField<String>) = apply { this.fileName = fileName }

            /**
             * A unique value that the ImageKit.io server will use to recognize and prevent
             * subsequent retries for the same request. We suggest using V4 UUIDs, or another random
             * string with enough entropy to avoid collisions. This field is only required for
             * authentication when uploading a file from the client side.
             *
             * **Note**: Sending a value that has been used in the past will result in a validation
             * error. Even if your previous request resulted in an error, you should always send a
             * new value for this field.
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

            /** Stringified JSON key-value data to be associated with the asset. */
            fun customMetadata(customMetadata: String) =
                customMetadata(MultipartField.of(customMetadata))

            /**
             * Sets [Builder.customMetadata] to an arbitrary multipart value.
             *
             * You should usually call [Builder.customMetadata] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun customMetadata(customMetadata: MultipartField<String>) = apply {
                this.customMetadata = customMetadata
            }

            /**
             * The time until your signature is valid. It must be a
             * [Unix time](https://en.wikipedia.org/wiki/Unix_time) in less than 1 hour into the
             * future. It should be in seconds. This field is only required for authentication when
             * uploading a file from the client side.
             */
            fun expire(expire: String) = expire(MultipartField.of(expire))

            /**
             * Sets [Builder.expire] to an arbitrary multipart value.
             *
             * You should usually call [Builder.expire] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expire(expire: MultipartField<String>) = apply { this.expire = expire }

            /**
             * Stringified JSON object with an array of extensions to be applied to the image. Refer
             * to extensions schema in
             * [update file API request body](/docs/api-reference/digital-asset-management-dam/managing-assets/update-file-details#request-body).
             */
            fun extensions(extensions: String) = extensions(MultipartField.of(extensions))

            /**
             * Sets [Builder.extensions] to an arbitrary multipart value.
             *
             * You should usually call [Builder.extensions] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun extensions(extensions: MultipartField<String>) = apply {
                this.extensions = extensions
            }

            /**
             * The folder path in which the image has to be uploaded. If the folder(s) didn't exist
             * before, a new folder(s) is created.
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
            fun isPrivateFile(isPrivateFile: IsPrivateFile) =
                isPrivateFile(MultipartField.of(isPrivateFile))

            /**
             * Sets [Builder.isPrivateFile] to an arbitrary multipart value.
             *
             * You should usually call [Builder.isPrivateFile] with a well-typed [IsPrivateFile]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun isPrivateFile(isPrivateFile: MultipartField<IsPrivateFile>) = apply {
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
            fun isPublished(isPublished: IsPublished) = isPublished(MultipartField.of(isPublished))

            /**
             * Sets [Builder.isPublished] to an arbitrary multipart value.
             *
             * You should usually call [Builder.isPublished] with a well-typed [IsPublished] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isPublished(isPublished: MultipartField<IsPublished>) = apply {
                this.isPublished = isPublished
            }

            /**
             * If set to `true` and a file already exists at the exact location, its AITags will be
             * removed. Set `overwriteAITags` to `false` to preserve AITags.
             */
            fun overwriteAiTags(overwriteAiTags: OverwriteAiTags) =
                overwriteAiTags(MultipartField.of(overwriteAiTags))

            /**
             * Sets [Builder.overwriteAiTags] to an arbitrary multipart value.
             *
             * You should usually call [Builder.overwriteAiTags] with a well-typed [OverwriteAiTags]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun overwriteAiTags(overwriteAiTags: MultipartField<OverwriteAiTags>) = apply {
                this.overwriteAiTags = overwriteAiTags
            }

            /**
             * If the request does not have `customMetadata`, and a file already exists at the exact
             * location, existing customMetadata will be removed.
             */
            fun overwriteCustomMetadata(overwriteCustomMetadata: OverwriteCustomMetadata) =
                overwriteCustomMetadata(MultipartField.of(overwriteCustomMetadata))

            /**
             * Sets [Builder.overwriteCustomMetadata] to an arbitrary multipart value.
             *
             * You should usually call [Builder.overwriteCustomMetadata] with a well-typed
             * [OverwriteCustomMetadata] value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun overwriteCustomMetadata(
                overwriteCustomMetadata: MultipartField<OverwriteCustomMetadata>
            ) = apply { this.overwriteCustomMetadata = overwriteCustomMetadata }

            /**
             * If `false` and `useUniqueFileName` is also `false`, and a file already exists at the
             * exact location, upload API will return an error immediately.
             */
            fun overwriteFile(overwriteFile: String) =
                overwriteFile(MultipartField.of(overwriteFile))

            /**
             * Sets [Builder.overwriteFile] to an arbitrary multipart value.
             *
             * You should usually call [Builder.overwriteFile] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun overwriteFile(overwriteFile: MultipartField<String>) = apply {
                this.overwriteFile = overwriteFile
            }

            /**
             * If the request does not have `tags`, and a file already exists at the exact location,
             * existing tags will be removed.
             */
            fun overwriteTags(overwriteTags: OverwriteTags) =
                overwriteTags(MultipartField.of(overwriteTags))

            /**
             * Sets [Builder.overwriteTags] to an arbitrary multipart value.
             *
             * You should usually call [Builder.overwriteTags] with a well-typed [OverwriteTags]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun overwriteTags(overwriteTags: MultipartField<OverwriteTags>) = apply {
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
             * You should usually call [Builder.publicKey] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun publicKey(publicKey: MultipartField<String>) = apply { this.publicKey = publicKey }

            /**
             * Comma-separated values of the fields that you want the API to return in the response.
             *
             * For example, set the value of this field to `tags,customCoordinates,isPrivateFile` to
             * get the value of `tags`, `customCoordinates`, and `isPrivateFile` in the response.
             *
             * Accepts combination of `tags`, `customCoordinates`, `isPrivateFile`,
             * `embeddedMetadata`, `isPublished`, `customMetadata`, and `metadata`.
             */
            fun responseFields(responseFields: String) =
                responseFields(MultipartField.of(responseFields))

            /**
             * Sets [Builder.responseFields] to an arbitrary multipart value.
             *
             * You should usually call [Builder.responseFields] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun responseFields(responseFields: MultipartField<String>) = apply {
                this.responseFields = responseFields
            }

            /**
             * HMAC-SHA1 digest of the token+expire using your ImageKit.io private API key as a key.
             * Learn how to create a signature on the page below. This should be in lowercase.
             *
             * Signature must be calculated on the server-side. This field is only required for
             * authentication when uploading a file from the client side.
             */
            fun signature(signature: String) = signature(MultipartField.of(signature))

            /**
             * Sets [Builder.signature] to an arbitrary multipart value.
             *
             * You should usually call [Builder.signature] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun signature(signature: MultipartField<String>) = apply { this.signature = signature }

            /**
             * Set the tags while uploading the file.
             *
             * Comma-separated value of tags in the format `tag1,tag2,tag3`. The maximum length of
             * all characters should not exceed 500. `%` is not allowed.
             *
             * If this field is not specified and the file is overwritten then the tags will be
             * removed.
             */
            fun tags(tags: String) = tags(MultipartField.of(tags))

            /**
             * Sets [Builder.tags] to an arbitrary multipart value.
             *
             * You should usually call [Builder.tags] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun tags(tags: MultipartField<String>) = apply { this.tags = tags }

            /**
             * Stringified JSON object with properties for pre and post transformations:
             *
             * `pre` - Accepts a "string" containing a valid transformation used for requesting a
             * pre-transformation for an image or a video file.
             *
             * `post` - Accepts an array of objects with properties:
             * - `type`: One of `transformation`, `gif-to-video`, `thumbnail`, or `abs` (Adaptive
             *   bitrate streaming).
             * - `value`: A "string" corresponding to the required transformation. Required if
             *   `type` is `transformation` or `abs`. Optional if `type` is `gif-to-video` or
             *   `thumbnail`.
             * - `protocol`: Either `hls` or `dash`, applicable only if `type` is `abs`.
             *
             * Read more about [Adaptive bitrate streaming (ABS)](/docs/adaptive-bitrate-streaming).
             */
            fun transformation(transformation: String) =
                transformation(MultipartField.of(transformation))

            /**
             * Sets [Builder.transformation] to an arbitrary multipart value.
             *
             * You should usually call [Builder.transformation] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun transformation(transformation: MultipartField<String>) = apply {
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
            fun useUniqueFileName(useUniqueFileName: UseUniqueFileName) =
                useUniqueFileName(MultipartField.of(useUniqueFileName))

            /**
             * Sets [Builder.useUniqueFileName] to an arbitrary multipart value.
             *
             * You should usually call [Builder.useUniqueFileName] with a well-typed
             * [UseUniqueFileName] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun useUniqueFileName(useUniqueFileName: MultipartField<UseUniqueFileName>) = apply {
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
            customMetadata()
            expire()
            extensions()
            folder()
            isPrivateFile().ifPresent { it.validate() }
            isPublished().ifPresent { it.validate() }
            overwriteAiTags().ifPresent { it.validate() }
            overwriteCustomMetadata().ifPresent { it.validate() }
            overwriteFile()
            overwriteTags().ifPresent { it.validate() }
            publicKey()
            responseFields()
            signature()
            tags()
            transformation()
            useUniqueFileName().ifPresent { it.validate() }
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
            "Body{file=$file, fileName=$fileName, token=$token, checks=$checks, customCoordinates=$customCoordinates, customMetadata=$customMetadata, expire=$expire, extensions=$extensions, folder=$folder, isPrivateFile=$isPrivateFile, isPublished=$isPublished, overwriteAiTags=$overwriteAiTags, overwriteCustomMetadata=$overwriteCustomMetadata, overwriteFile=$overwriteFile, overwriteTags=$overwriteTags, publicKey=$publicKey, responseFields=$responseFields, signature=$signature, tags=$tags, transformation=$transformation, useUniqueFileName=$useUniqueFileName, webhookUrl=$webhookUrl, additionalProperties=$additionalProperties}"
    }

    /**
     * Whether to mark the file as private or not.
     *
     * If `true`, the file is marked as private and is accessible only using named transformation or
     * signed URL.
     */
    class IsPrivateFile @JsonCreator private constructor(private val value: JsonField<String>) :
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

            @JvmField val TRUE = of("true")

            @JvmField val FALSE = of("false")

            @JvmStatic fun of(value: String) = IsPrivateFile(JsonField.of(value))
        }

        /** An enum containing [IsPrivateFile]'s known values. */
        enum class Known {
            TRUE,
            FALSE,
        }

        /**
         * An enum containing [IsPrivateFile]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [IsPrivateFile] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TRUE,
            FALSE,
            /**
             * An enum member indicating that [IsPrivateFile] was instantiated with an unknown
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
                FALSE -> Value.FALSE
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
                FALSE -> Known.FALSE
                else -> throw ImageKitInvalidDataException("Unknown IsPrivateFile: $value")
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

        fun validate(): IsPrivateFile = apply {
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

            return other is IsPrivateFile && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Whether to upload file as published or not.
     *
     * If `false`, the file is marked as unpublished, which restricts access to the file only via
     * the media library. Files in draft or unpublished state can only be publicly accessed after
     * being published.
     *
     * The option to upload in draft state is only available in custom enterprise pricing plans.
     */
    class IsPublished @JsonCreator private constructor(private val value: JsonField<String>) :
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

            @JvmField val TRUE = of("true")

            @JvmField val FALSE = of("false")

            @JvmStatic fun of(value: String) = IsPublished(JsonField.of(value))
        }

        /** An enum containing [IsPublished]'s known values. */
        enum class Known {
            TRUE,
            FALSE,
        }

        /**
         * An enum containing [IsPublished]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [IsPublished] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TRUE,
            FALSE,
            /**
             * An enum member indicating that [IsPublished] was instantiated with an unknown value.
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
                FALSE -> Value.FALSE
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
                FALSE -> Known.FALSE
                else -> throw ImageKitInvalidDataException("Unknown IsPublished: $value")
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

        fun validate(): IsPublished = apply {
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

            return other is IsPublished && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * If set to `true` and a file already exists at the exact location, its AITags will be removed.
     * Set `overwriteAITags` to `false` to preserve AITags.
     */
    class OverwriteAiTags @JsonCreator private constructor(private val value: JsonField<String>) :
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

            @JvmField val TRUE = of("true")

            @JvmField val FALSE = of("false")

            @JvmStatic fun of(value: String) = OverwriteAiTags(JsonField.of(value))
        }

        /** An enum containing [OverwriteAiTags]'s known values. */
        enum class Known {
            TRUE,
            FALSE,
        }

        /**
         * An enum containing [OverwriteAiTags]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [OverwriteAiTags] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TRUE,
            FALSE,
            /**
             * An enum member indicating that [OverwriteAiTags] was instantiated with an unknown
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
                FALSE -> Value.FALSE
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
                FALSE -> Known.FALSE
                else -> throw ImageKitInvalidDataException("Unknown OverwriteAiTags: $value")
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

        fun validate(): OverwriteAiTags = apply {
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

            return other is OverwriteAiTags && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * If the request does not have `customMetadata`, and a file already exists at the exact
     * location, existing customMetadata will be removed.
     */
    class OverwriteCustomMetadata
    @JsonCreator
    private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val TRUE = of("true")

            @JvmField val FALSE = of("false")

            @JvmStatic fun of(value: String) = OverwriteCustomMetadata(JsonField.of(value))
        }

        /** An enum containing [OverwriteCustomMetadata]'s known values. */
        enum class Known {
            TRUE,
            FALSE,
        }

        /**
         * An enum containing [OverwriteCustomMetadata]'s known values, as well as an [_UNKNOWN]
         * member.
         *
         * An instance of [OverwriteCustomMetadata] can contain an unknown value in a couple of
         * cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TRUE,
            FALSE,
            /**
             * An enum member indicating that [OverwriteCustomMetadata] was instantiated with an
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
                FALSE -> Value.FALSE
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
                FALSE -> Known.FALSE
                else ->
                    throw ImageKitInvalidDataException("Unknown OverwriteCustomMetadata: $value")
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

        fun validate(): OverwriteCustomMetadata = apply {
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

            return other is OverwriteCustomMetadata && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * If the request does not have `tags`, and a file already exists at the exact location,
     * existing tags will be removed.
     */
    class OverwriteTags @JsonCreator private constructor(private val value: JsonField<String>) :
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

            @JvmField val TRUE = of("true")

            @JvmField val FALSE = of("false")

            @JvmStatic fun of(value: String) = OverwriteTags(JsonField.of(value))
        }

        /** An enum containing [OverwriteTags]'s known values. */
        enum class Known {
            TRUE,
            FALSE,
        }

        /**
         * An enum containing [OverwriteTags]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [OverwriteTags] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TRUE,
            FALSE,
            /**
             * An enum member indicating that [OverwriteTags] was instantiated with an unknown
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
                FALSE -> Value.FALSE
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
                FALSE -> Known.FALSE
                else -> throw ImageKitInvalidDataException("Unknown OverwriteTags: $value")
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

        fun validate(): OverwriteTags = apply {
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

            return other is OverwriteTags && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Whether to use a unique filename for this file or not.
     *
     * If `true`, ImageKit.io will add a unique suffix to the filename parameter to get a unique
     * filename.
     *
     * If `false`, then the image is uploaded with the provided filename parameter, and any existing
     * file with the same name is replaced.
     */
    class UseUniqueFileName @JsonCreator private constructor(private val value: JsonField<String>) :
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

            @JvmField val TRUE = of("true")

            @JvmField val FALSE = of("false")

            @JvmStatic fun of(value: String) = UseUniqueFileName(JsonField.of(value))
        }

        /** An enum containing [UseUniqueFileName]'s known values. */
        enum class Known {
            TRUE,
            FALSE,
        }

        /**
         * An enum containing [UseUniqueFileName]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [UseUniqueFileName] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TRUE,
            FALSE,
            /**
             * An enum member indicating that [UseUniqueFileName] was instantiated with an unknown
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
                FALSE -> Value.FALSE
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
                FALSE -> Known.FALSE
                else -> throw ImageKitInvalidDataException("Unknown UseUniqueFileName: $value")
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

        fun validate(): UseUniqueFileName = apply {
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

            return other is UseUniqueFileName && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileUploadV1Params &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "FileUploadV1Params{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
