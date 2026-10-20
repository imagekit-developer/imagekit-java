// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.webhooks

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.BaseDeserializer
import io.imagekit.core.BaseSerializer
import io.imagekit.core.JsonValue
import io.imagekit.core.getOrThrow
import io.imagekit.errors.ImageKitInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Triggered when a new video transformation request is accepted for processing. This event confirms
 * that ImageKit has received and queued your transformation request. Use this for debugging and
 * tracking transformation lifecycle.
 */
@JsonDeserialize(using = UnsafeUnwrapWebhookEvent.Deserializer::class)
@JsonSerialize(using = UnsafeUnwrapWebhookEvent.Serializer::class)
class UnsafeUnwrapWebhookEvent
private constructor(
    private val videoTransformationAccepted: VideoTransformationAcceptedEvent? = null,
    private val videoTransformationReady: VideoTransformationReadyEvent? = null,
    private val videoTransformationError: VideoTransformationErrorEvent? = null,
    private val uploadPreTransformSuccess: UploadPreTransformSuccessEvent? = null,
    private val uploadPreTransformError: UploadPreTransformErrorEvent? = null,
    private val uploadPostTransformSuccess: UploadPostTransformSuccessEvent? = null,
    private val uploadPostTransformError: UploadPostTransformErrorEvent? = null,
    private val fileCreated: FileCreateEvent? = null,
    private val fileUpdated: FileUpdateEvent? = null,
    private val fileDeleted: FileDeleteEvent? = null,
    private val fileVersionCreated: FileVersionCreateEvent? = null,
    private val fileVersionDeleted: FileVersionDeleteEvent? = null,
    private val folderCreated: FolderCreateEvent? = null,
    private val folderUpdated: FolderUpdateEvent? = null,
    private val folderDeleted: FolderDeleteEvent? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * Triggered when a new video transformation request is accepted for processing. This event
     * confirms that ImageKit has received and queued your transformation request. Use this for
     * debugging and tracking transformation lifecycle.
     */
    fun videoTransformationAccepted(): Optional<VideoTransformationAcceptedEvent> =
        Optional.ofNullable(videoTransformationAccepted)

    /**
     * Triggered when video encoding is finished and the transformed resource is ready to be served.
     * This is the key event to listen for - update your database or CMS flags when you receive this
     * so your application can start showing the transformed video to users.
     */
    fun videoTransformationReady(): Optional<VideoTransformationReadyEvent> =
        Optional.ofNullable(videoTransformationReady)

    /**
     * Triggered when an error occurs during video encoding. Listen to this webhook to log error
     * reasons and debug issues. Check your origin and URL endpoint settings if the reason is
     * related to download failure. For other errors, contact ImageKit support.
     */
    fun videoTransformationError(): Optional<VideoTransformationErrorEvent> =
        Optional.ofNullable(videoTransformationError)

    /**
     * Triggered when a pre-transformation completes successfully. The file has been processed with
     * the requested transformation and is now available in the Media Library.
     */
    fun uploadPreTransformSuccess(): Optional<UploadPreTransformSuccessEvent> =
        Optional.ofNullable(uploadPreTransformSuccess)

    /**
     * Triggered when a pre-transformation fails. The file upload may have been accepted, but the
     * requested transformation could not be applied.
     */
    fun uploadPreTransformError(): Optional<UploadPreTransformErrorEvent> =
        Optional.ofNullable(uploadPreTransformError)

    /**
     * Triggered when a post-transformation completes successfully. The transformed version of the
     * file is now ready and can be accessed via the provided URL. Note that each
     * post-transformation generates a separate webhook event.
     */
    fun uploadPostTransformSuccess(): Optional<UploadPostTransformSuccessEvent> =
        Optional.ofNullable(uploadPostTransformSuccess)

    /**
     * Triggered when a post-transformation fails. The original file remains available, but the
     * requested transformation could not be generated.
     */
    fun uploadPostTransformError(): Optional<UploadPostTransformErrorEvent> =
        Optional.ofNullable(uploadPostTransformError)

    /** Triggered when a file is created. */
    fun fileCreated(): Optional<FileCreateEvent> = Optional.ofNullable(fileCreated)

    /** Triggered when a file is updated. */
    fun fileUpdated(): Optional<FileUpdateEvent> = Optional.ofNullable(fileUpdated)

    /** Triggered when a file is deleted. */
    fun fileDeleted(): Optional<FileDeleteEvent> = Optional.ofNullable(fileDeleted)

    /** Triggered when a file version is created. */
    fun fileVersionCreated(): Optional<FileVersionCreateEvent> =
        Optional.ofNullable(fileVersionCreated)

    /** Triggered when a file version is deleted. */
    fun fileVersionDeleted(): Optional<FileVersionDeleteEvent> =
        Optional.ofNullable(fileVersionDeleted)

    /**
     * Triggered when a folder is created, whether explicitly, by copying or moving a folder, or
     * implicitly when an upload creates missing parent folders. Copying or moving a folder tree
     * sends one event per folder in the tree.
     */
    fun folderCreated(): Optional<FolderCreateEvent> = Optional.ofNullable(folderCreated)

    /**
     * Triggered when a folder is updated, for example when its custom metadata changes or it is
     * renamed. Renaming a folder sends one event per folder in the tree, each with its new
     * `folderPath`.
     */
    fun folderUpdated(): Optional<FolderUpdateEvent> = Optional.ofNullable(folderUpdated)

    /**
     * Triggered when a folder is deleted. Deleting a folder tree sends one event per folder in the
     * tree; the files inside it send `file.deleted` events and their versions send
     * `file-version.deleted` events. Moving a folder sends this event for the old `folderId` and
     * `folder.created` for the new one.
     */
    fun folderDeleted(): Optional<FolderDeleteEvent> = Optional.ofNullable(folderDeleted)

    fun isVideoTransformationAccepted(): Boolean = videoTransformationAccepted != null

    fun isVideoTransformationReady(): Boolean = videoTransformationReady != null

    fun isVideoTransformationError(): Boolean = videoTransformationError != null

    fun isUploadPreTransformSuccess(): Boolean = uploadPreTransformSuccess != null

    fun isUploadPreTransformError(): Boolean = uploadPreTransformError != null

    fun isUploadPostTransformSuccess(): Boolean = uploadPostTransformSuccess != null

    fun isUploadPostTransformError(): Boolean = uploadPostTransformError != null

    fun isFileCreated(): Boolean = fileCreated != null

    fun isFileUpdated(): Boolean = fileUpdated != null

    fun isFileDeleted(): Boolean = fileDeleted != null

    fun isFileVersionCreated(): Boolean = fileVersionCreated != null

    fun isFileVersionDeleted(): Boolean = fileVersionDeleted != null

    fun isFolderCreated(): Boolean = folderCreated != null

    fun isFolderUpdated(): Boolean = folderUpdated != null

    fun isFolderDeleted(): Boolean = folderDeleted != null

    /**
     * Triggered when a new video transformation request is accepted for processing. This event
     * confirms that ImageKit has received and queued your transformation request. Use this for
     * debugging and tracking transformation lifecycle.
     */
    fun asVideoTransformationAccepted(): VideoTransformationAcceptedEvent =
        videoTransformationAccepted.getOrThrow("videoTransformationAccepted")

    /**
     * Triggered when video encoding is finished and the transformed resource is ready to be served.
     * This is the key event to listen for - update your database or CMS flags when you receive this
     * so your application can start showing the transformed video to users.
     */
    fun asVideoTransformationReady(): VideoTransformationReadyEvent =
        videoTransformationReady.getOrThrow("videoTransformationReady")

    /**
     * Triggered when an error occurs during video encoding. Listen to this webhook to log error
     * reasons and debug issues. Check your origin and URL endpoint settings if the reason is
     * related to download failure. For other errors, contact ImageKit support.
     */
    fun asVideoTransformationError(): VideoTransformationErrorEvent =
        videoTransformationError.getOrThrow("videoTransformationError")

    /**
     * Triggered when a pre-transformation completes successfully. The file has been processed with
     * the requested transformation and is now available in the Media Library.
     */
    fun asUploadPreTransformSuccess(): UploadPreTransformSuccessEvent =
        uploadPreTransformSuccess.getOrThrow("uploadPreTransformSuccess")

    /**
     * Triggered when a pre-transformation fails. The file upload may have been accepted, but the
     * requested transformation could not be applied.
     */
    fun asUploadPreTransformError(): UploadPreTransformErrorEvent =
        uploadPreTransformError.getOrThrow("uploadPreTransformError")

    /**
     * Triggered when a post-transformation completes successfully. The transformed version of the
     * file is now ready and can be accessed via the provided URL. Note that each
     * post-transformation generates a separate webhook event.
     */
    fun asUploadPostTransformSuccess(): UploadPostTransformSuccessEvent =
        uploadPostTransformSuccess.getOrThrow("uploadPostTransformSuccess")

    /**
     * Triggered when a post-transformation fails. The original file remains available, but the
     * requested transformation could not be generated.
     */
    fun asUploadPostTransformError(): UploadPostTransformErrorEvent =
        uploadPostTransformError.getOrThrow("uploadPostTransformError")

    /** Triggered when a file is created. */
    fun asFileCreated(): FileCreateEvent = fileCreated.getOrThrow("fileCreated")

    /** Triggered when a file is updated. */
    fun asFileUpdated(): FileUpdateEvent = fileUpdated.getOrThrow("fileUpdated")

    /** Triggered when a file is deleted. */
    fun asFileDeleted(): FileDeleteEvent = fileDeleted.getOrThrow("fileDeleted")

    /** Triggered when a file version is created. */
    fun asFileVersionCreated(): FileVersionCreateEvent =
        fileVersionCreated.getOrThrow("fileVersionCreated")

    /** Triggered when a file version is deleted. */
    fun asFileVersionDeleted(): FileVersionDeleteEvent =
        fileVersionDeleted.getOrThrow("fileVersionDeleted")

    /**
     * Triggered when a folder is created, whether explicitly, by copying or moving a folder, or
     * implicitly when an upload creates missing parent folders. Copying or moving a folder tree
     * sends one event per folder in the tree.
     */
    fun asFolderCreated(): FolderCreateEvent = folderCreated.getOrThrow("folderCreated")

    /**
     * Triggered when a folder is updated, for example when its custom metadata changes or it is
     * renamed. Renaming a folder sends one event per folder in the tree, each with its new
     * `folderPath`.
     */
    fun asFolderUpdated(): FolderUpdateEvent = folderUpdated.getOrThrow("folderUpdated")

    /**
     * Triggered when a folder is deleted. Deleting a folder tree sends one event per folder in the
     * tree; the files inside it send `file.deleted` events and their versions send
     * `file-version.deleted` events. Moving a folder sends this event for the old `folderId` and
     * `folder.created` for the new one.
     */
    fun asFolderDeleted(): FolderDeleteEvent = folderDeleted.getOrThrow("folderDeleted")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import io.imagekit.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = unsafeUnwrapWebhookEvent.accept(new UnsafeUnwrapWebhookEvent.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitVideoTransformationAccepted(VideoTransformationAcceptedEvent videoTransformationAccepted) {
     *         return Optional.of(videoTransformationAccepted.toString());
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
     * @throws ImageKitInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            videoTransformationAccepted != null ->
                visitor.visitVideoTransformationAccepted(videoTransformationAccepted)
            videoTransformationReady != null ->
                visitor.visitVideoTransformationReady(videoTransformationReady)
            videoTransformationError != null ->
                visitor.visitVideoTransformationError(videoTransformationError)
            uploadPreTransformSuccess != null ->
                visitor.visitUploadPreTransformSuccess(uploadPreTransformSuccess)
            uploadPreTransformError != null ->
                visitor.visitUploadPreTransformError(uploadPreTransformError)
            uploadPostTransformSuccess != null ->
                visitor.visitUploadPostTransformSuccess(uploadPostTransformSuccess)
            uploadPostTransformError != null ->
                visitor.visitUploadPostTransformError(uploadPostTransformError)
            fileCreated != null -> visitor.visitFileCreated(fileCreated)
            fileUpdated != null -> visitor.visitFileUpdated(fileUpdated)
            fileDeleted != null -> visitor.visitFileDeleted(fileDeleted)
            fileVersionCreated != null -> visitor.visitFileVersionCreated(fileVersionCreated)
            fileVersionDeleted != null -> visitor.visitFileVersionDeleted(fileVersionDeleted)
            folderCreated != null -> visitor.visitFolderCreated(folderCreated)
            folderUpdated != null -> visitor.visitFolderUpdated(folderUpdated)
            folderDeleted != null -> visitor.visitFolderDeleted(folderDeleted)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): UnsafeUnwrapWebhookEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitVideoTransformationAccepted(
                    videoTransformationAccepted: VideoTransformationAcceptedEvent
                ) {
                    videoTransformationAccepted.validate()
                }

                override fun visitVideoTransformationReady(
                    videoTransformationReady: VideoTransformationReadyEvent
                ) {
                    videoTransformationReady.validate()
                }

                override fun visitVideoTransformationError(
                    videoTransformationError: VideoTransformationErrorEvent
                ) {
                    videoTransformationError.validate()
                }

                override fun visitUploadPreTransformSuccess(
                    uploadPreTransformSuccess: UploadPreTransformSuccessEvent
                ) {
                    uploadPreTransformSuccess.validate()
                }

                override fun visitUploadPreTransformError(
                    uploadPreTransformError: UploadPreTransformErrorEvent
                ) {
                    uploadPreTransformError.validate()
                }

                override fun visitUploadPostTransformSuccess(
                    uploadPostTransformSuccess: UploadPostTransformSuccessEvent
                ) {
                    uploadPostTransformSuccess.validate()
                }

                override fun visitUploadPostTransformError(
                    uploadPostTransformError: UploadPostTransformErrorEvent
                ) {
                    uploadPostTransformError.validate()
                }

                override fun visitFileCreated(fileCreated: FileCreateEvent) {
                    fileCreated.validate()
                }

                override fun visitFileUpdated(fileUpdated: FileUpdateEvent) {
                    fileUpdated.validate()
                }

                override fun visitFileDeleted(fileDeleted: FileDeleteEvent) {
                    fileDeleted.validate()
                }

                override fun visitFileVersionCreated(fileVersionCreated: FileVersionCreateEvent) {
                    fileVersionCreated.validate()
                }

                override fun visitFileVersionDeleted(fileVersionDeleted: FileVersionDeleteEvent) {
                    fileVersionDeleted.validate()
                }

                override fun visitFolderCreated(folderCreated: FolderCreateEvent) {
                    folderCreated.validate()
                }

                override fun visitFolderUpdated(folderUpdated: FolderUpdateEvent) {
                    folderUpdated.validate()
                }

                override fun visitFolderDeleted(folderDeleted: FolderDeleteEvent) {
                    folderDeleted.validate()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitVideoTransformationAccepted(
                    videoTransformationAccepted: VideoTransformationAcceptedEvent
                ) = videoTransformationAccepted.validity()

                override fun visitVideoTransformationReady(
                    videoTransformationReady: VideoTransformationReadyEvent
                ) = videoTransformationReady.validity()

                override fun visitVideoTransformationError(
                    videoTransformationError: VideoTransformationErrorEvent
                ) = videoTransformationError.validity()

                override fun visitUploadPreTransformSuccess(
                    uploadPreTransformSuccess: UploadPreTransformSuccessEvent
                ) = uploadPreTransformSuccess.validity()

                override fun visitUploadPreTransformError(
                    uploadPreTransformError: UploadPreTransformErrorEvent
                ) = uploadPreTransformError.validity()

                override fun visitUploadPostTransformSuccess(
                    uploadPostTransformSuccess: UploadPostTransformSuccessEvent
                ) = uploadPostTransformSuccess.validity()

                override fun visitUploadPostTransformError(
                    uploadPostTransformError: UploadPostTransformErrorEvent
                ) = uploadPostTransformError.validity()

                override fun visitFileCreated(fileCreated: FileCreateEvent) = fileCreated.validity()

                override fun visitFileUpdated(fileUpdated: FileUpdateEvent) = fileUpdated.validity()

                override fun visitFileDeleted(fileDeleted: FileDeleteEvent) = fileDeleted.validity()

                override fun visitFileVersionCreated(fileVersionCreated: FileVersionCreateEvent) =
                    fileVersionCreated.validity()

                override fun visitFileVersionDeleted(fileVersionDeleted: FileVersionDeleteEvent) =
                    fileVersionDeleted.validity()

                override fun visitFolderCreated(folderCreated: FolderCreateEvent) =
                    folderCreated.validity()

                override fun visitFolderUpdated(folderUpdated: FolderUpdateEvent) =
                    folderUpdated.validity()

                override fun visitFolderDeleted(folderDeleted: FolderDeleteEvent) =
                    folderDeleted.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UnsafeUnwrapWebhookEvent &&
            videoTransformationAccepted == other.videoTransformationAccepted &&
            videoTransformationReady == other.videoTransformationReady &&
            videoTransformationError == other.videoTransformationError &&
            uploadPreTransformSuccess == other.uploadPreTransformSuccess &&
            uploadPreTransformError == other.uploadPreTransformError &&
            uploadPostTransformSuccess == other.uploadPostTransformSuccess &&
            uploadPostTransformError == other.uploadPostTransformError &&
            fileCreated == other.fileCreated &&
            fileUpdated == other.fileUpdated &&
            fileDeleted == other.fileDeleted &&
            fileVersionCreated == other.fileVersionCreated &&
            fileVersionDeleted == other.fileVersionDeleted &&
            folderCreated == other.folderCreated &&
            folderUpdated == other.folderUpdated &&
            folderDeleted == other.folderDeleted
    }

    override fun hashCode(): Int =
        Objects.hash(
            videoTransformationAccepted,
            videoTransformationReady,
            videoTransformationError,
            uploadPreTransformSuccess,
            uploadPreTransformError,
            uploadPostTransformSuccess,
            uploadPostTransformError,
            fileCreated,
            fileUpdated,
            fileDeleted,
            fileVersionCreated,
            fileVersionDeleted,
            folderCreated,
            folderUpdated,
            folderDeleted,
        )

    override fun toString(): String =
        when {
            videoTransformationAccepted != null ->
                "UnsafeUnwrapWebhookEvent{videoTransformationAccepted=$videoTransformationAccepted}"
            videoTransformationReady != null ->
                "UnsafeUnwrapWebhookEvent{videoTransformationReady=$videoTransformationReady}"
            videoTransformationError != null ->
                "UnsafeUnwrapWebhookEvent{videoTransformationError=$videoTransformationError}"
            uploadPreTransformSuccess != null ->
                "UnsafeUnwrapWebhookEvent{uploadPreTransformSuccess=$uploadPreTransformSuccess}"
            uploadPreTransformError != null ->
                "UnsafeUnwrapWebhookEvent{uploadPreTransformError=$uploadPreTransformError}"
            uploadPostTransformSuccess != null ->
                "UnsafeUnwrapWebhookEvent{uploadPostTransformSuccess=$uploadPostTransformSuccess}"
            uploadPostTransformError != null ->
                "UnsafeUnwrapWebhookEvent{uploadPostTransformError=$uploadPostTransformError}"
            fileCreated != null -> "UnsafeUnwrapWebhookEvent{fileCreated=$fileCreated}"
            fileUpdated != null -> "UnsafeUnwrapWebhookEvent{fileUpdated=$fileUpdated}"
            fileDeleted != null -> "UnsafeUnwrapWebhookEvent{fileDeleted=$fileDeleted}"
            fileVersionCreated != null ->
                "UnsafeUnwrapWebhookEvent{fileVersionCreated=$fileVersionCreated}"
            fileVersionDeleted != null ->
                "UnsafeUnwrapWebhookEvent{fileVersionDeleted=$fileVersionDeleted}"
            folderCreated != null -> "UnsafeUnwrapWebhookEvent{folderCreated=$folderCreated}"
            folderUpdated != null -> "UnsafeUnwrapWebhookEvent{folderUpdated=$folderUpdated}"
            folderDeleted != null -> "UnsafeUnwrapWebhookEvent{folderDeleted=$folderDeleted}"
            _json != null -> "UnsafeUnwrapWebhookEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid UnsafeUnwrapWebhookEvent")
        }

    companion object {

        /**
         * Triggered when a new video transformation request is accepted for processing. This event
         * confirms that ImageKit has received and queued your transformation request. Use this for
         * debugging and tracking transformation lifecycle.
         */
        @JvmStatic
        fun ofVideoTransformationAccepted(
            videoTransformationAccepted: VideoTransformationAcceptedEvent
        ) = UnsafeUnwrapWebhookEvent(videoTransformationAccepted = videoTransformationAccepted)

        /**
         * Triggered when video encoding is finished and the transformed resource is ready to be
         * served. This is the key event to listen for - update your database or CMS flags when you
         * receive this so your application can start showing the transformed video to users.
         */
        @JvmStatic
        fun ofVideoTransformationReady(videoTransformationReady: VideoTransformationReadyEvent) =
            UnsafeUnwrapWebhookEvent(videoTransformationReady = videoTransformationReady)

        /**
         * Triggered when an error occurs during video encoding. Listen to this webhook to log error
         * reasons and debug issues. Check your origin and URL endpoint settings if the reason is
         * related to download failure. For other errors, contact ImageKit support.
         */
        @JvmStatic
        fun ofVideoTransformationError(videoTransformationError: VideoTransformationErrorEvent) =
            UnsafeUnwrapWebhookEvent(videoTransformationError = videoTransformationError)

        /**
         * Triggered when a pre-transformation completes successfully. The file has been processed
         * with the requested transformation and is now available in the Media Library.
         */
        @JvmStatic
        fun ofUploadPreTransformSuccess(uploadPreTransformSuccess: UploadPreTransformSuccessEvent) =
            UnsafeUnwrapWebhookEvent(uploadPreTransformSuccess = uploadPreTransformSuccess)

        /**
         * Triggered when a pre-transformation fails. The file upload may have been accepted, but
         * the requested transformation could not be applied.
         */
        @JvmStatic
        fun ofUploadPreTransformError(uploadPreTransformError: UploadPreTransformErrorEvent) =
            UnsafeUnwrapWebhookEvent(uploadPreTransformError = uploadPreTransformError)

        /**
         * Triggered when a post-transformation completes successfully. The transformed version of
         * the file is now ready and can be accessed via the provided URL. Note that each
         * post-transformation generates a separate webhook event.
         */
        @JvmStatic
        fun ofUploadPostTransformSuccess(
            uploadPostTransformSuccess: UploadPostTransformSuccessEvent
        ) = UnsafeUnwrapWebhookEvent(uploadPostTransformSuccess = uploadPostTransformSuccess)

        /**
         * Triggered when a post-transformation fails. The original file remains available, but the
         * requested transformation could not be generated.
         */
        @JvmStatic
        fun ofUploadPostTransformError(uploadPostTransformError: UploadPostTransformErrorEvent) =
            UnsafeUnwrapWebhookEvent(uploadPostTransformError = uploadPostTransformError)

        /** Triggered when a file is created. */
        @JvmStatic
        fun ofFileCreated(fileCreated: FileCreateEvent) =
            UnsafeUnwrapWebhookEvent(fileCreated = fileCreated)

        /** Triggered when a file is updated. */
        @JvmStatic
        fun ofFileUpdated(fileUpdated: FileUpdateEvent) =
            UnsafeUnwrapWebhookEvent(fileUpdated = fileUpdated)

        /** Triggered when a file is deleted. */
        @JvmStatic
        fun ofFileDeleted(fileDeleted: FileDeleteEvent) =
            UnsafeUnwrapWebhookEvent(fileDeleted = fileDeleted)

        /** Triggered when a file version is created. */
        @JvmStatic
        fun ofFileVersionCreated(fileVersionCreated: FileVersionCreateEvent) =
            UnsafeUnwrapWebhookEvent(fileVersionCreated = fileVersionCreated)

        /** Triggered when a file version is deleted. */
        @JvmStatic
        fun ofFileVersionDeleted(fileVersionDeleted: FileVersionDeleteEvent) =
            UnsafeUnwrapWebhookEvent(fileVersionDeleted = fileVersionDeleted)

        /**
         * Triggered when a folder is created, whether explicitly, by copying or moving a folder, or
         * implicitly when an upload creates missing parent folders. Copying or moving a folder tree
         * sends one event per folder in the tree.
         */
        @JvmStatic
        fun ofFolderCreated(folderCreated: FolderCreateEvent) =
            UnsafeUnwrapWebhookEvent(folderCreated = folderCreated)

        /**
         * Triggered when a folder is updated, for example when its custom metadata changes or it is
         * renamed. Renaming a folder sends one event per folder in the tree, each with its new
         * `folderPath`.
         */
        @JvmStatic
        fun ofFolderUpdated(folderUpdated: FolderUpdateEvent) =
            UnsafeUnwrapWebhookEvent(folderUpdated = folderUpdated)

        /**
         * Triggered when a folder is deleted. Deleting a folder tree sends one event per folder in
         * the tree; the files inside it send `file.deleted` events and their versions send
         * `file-version.deleted` events. Moving a folder sends this event for the old `folderId`
         * and `folder.created` for the new one.
         */
        @JvmStatic
        fun ofFolderDeleted(folderDeleted: FolderDeleteEvent) =
            UnsafeUnwrapWebhookEvent(folderDeleted = folderDeleted)
    }

    /**
     * An interface that defines how to map each variant of [UnsafeUnwrapWebhookEvent] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /**
         * Triggered when a new video transformation request is accepted for processing. This event
         * confirms that ImageKit has received and queued your transformation request. Use this for
         * debugging and tracking transformation lifecycle.
         */
        fun visitVideoTransformationAccepted(
            videoTransformationAccepted: VideoTransformationAcceptedEvent
        ): T

        /**
         * Triggered when video encoding is finished and the transformed resource is ready to be
         * served. This is the key event to listen for - update your database or CMS flags when you
         * receive this so your application can start showing the transformed video to users.
         */
        fun visitVideoTransformationReady(
            videoTransformationReady: VideoTransformationReadyEvent
        ): T

        /**
         * Triggered when an error occurs during video encoding. Listen to this webhook to log error
         * reasons and debug issues. Check your origin and URL endpoint settings if the reason is
         * related to download failure. For other errors, contact ImageKit support.
         */
        fun visitVideoTransformationError(
            videoTransformationError: VideoTransformationErrorEvent
        ): T

        /**
         * Triggered when a pre-transformation completes successfully. The file has been processed
         * with the requested transformation and is now available in the Media Library.
         */
        fun visitUploadPreTransformSuccess(
            uploadPreTransformSuccess: UploadPreTransformSuccessEvent
        ): T

        /**
         * Triggered when a pre-transformation fails. The file upload may have been accepted, but
         * the requested transformation could not be applied.
         */
        fun visitUploadPreTransformError(uploadPreTransformError: UploadPreTransformErrorEvent): T

        /**
         * Triggered when a post-transformation completes successfully. The transformed version of
         * the file is now ready and can be accessed via the provided URL. Note that each
         * post-transformation generates a separate webhook event.
         */
        fun visitUploadPostTransformSuccess(
            uploadPostTransformSuccess: UploadPostTransformSuccessEvent
        ): T

        /**
         * Triggered when a post-transformation fails. The original file remains available, but the
         * requested transformation could not be generated.
         */
        fun visitUploadPostTransformError(
            uploadPostTransformError: UploadPostTransformErrorEvent
        ): T

        /** Triggered when a file is created. */
        fun visitFileCreated(fileCreated: FileCreateEvent): T

        /** Triggered when a file is updated. */
        fun visitFileUpdated(fileUpdated: FileUpdateEvent): T

        /** Triggered when a file is deleted. */
        fun visitFileDeleted(fileDeleted: FileDeleteEvent): T

        /** Triggered when a file version is created. */
        fun visitFileVersionCreated(fileVersionCreated: FileVersionCreateEvent): T

        /** Triggered when a file version is deleted. */
        fun visitFileVersionDeleted(fileVersionDeleted: FileVersionDeleteEvent): T

        /**
         * Triggered when a folder is created, whether explicitly, by copying or moving a folder, or
         * implicitly when an upload creates missing parent folders. Copying or moving a folder tree
         * sends one event per folder in the tree.
         */
        fun visitFolderCreated(folderCreated: FolderCreateEvent): T

        /**
         * Triggered when a folder is updated, for example when its custom metadata changes or it is
         * renamed. Renaming a folder sends one event per folder in the tree, each with its new
         * `folderPath`.
         */
        fun visitFolderUpdated(folderUpdated: FolderUpdateEvent): T

        /**
         * Triggered when a folder is deleted. Deleting a folder tree sends one event per folder in
         * the tree; the files inside it send `file.deleted` events and their versions send
         * `file-version.deleted` events. Moving a folder sends this event for the old `folderId`
         * and `folder.created` for the new one.
         */
        fun visitFolderDeleted(folderDeleted: FolderDeleteEvent): T

        /**
         * Maps an unknown variant of [UnsafeUnwrapWebhookEvent] to a value of type [T].
         *
         * An instance of [UnsafeUnwrapWebhookEvent] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws ImageKitInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw ImageKitInvalidDataException("Unknown UnsafeUnwrapWebhookEvent: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<UnsafeUnwrapWebhookEvent>(UnsafeUnwrapWebhookEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): UnsafeUnwrapWebhookEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "video.transformation.accepted" -> {
                    return tryDeserialize(node, jacksonTypeRef<VideoTransformationAcceptedEvent>())
                        ?.let {
                            UnsafeUnwrapWebhookEvent(videoTransformationAccepted = it, _json = json)
                        } ?: UnsafeUnwrapWebhookEvent(_json = json)
                }
                "video.transformation.ready" -> {
                    return tryDeserialize(node, jacksonTypeRef<VideoTransformationReadyEvent>())
                        ?.let {
                            UnsafeUnwrapWebhookEvent(videoTransformationReady = it, _json = json)
                        } ?: UnsafeUnwrapWebhookEvent(_json = json)
                }
                "video.transformation.error" -> {
                    return tryDeserialize(node, jacksonTypeRef<VideoTransformationErrorEvent>())
                        ?.let {
                            UnsafeUnwrapWebhookEvent(videoTransformationError = it, _json = json)
                        } ?: UnsafeUnwrapWebhookEvent(_json = json)
                }
                "upload.pre-transform.success" -> {
                    return tryDeserialize(node, jacksonTypeRef<UploadPreTransformSuccessEvent>())
                        ?.let {
                            UnsafeUnwrapWebhookEvent(uploadPreTransformSuccess = it, _json = json)
                        } ?: UnsafeUnwrapWebhookEvent(_json = json)
                }
                "upload.pre-transform.error" -> {
                    return tryDeserialize(node, jacksonTypeRef<UploadPreTransformErrorEvent>())
                        ?.let {
                            UnsafeUnwrapWebhookEvent(uploadPreTransformError = it, _json = json)
                        } ?: UnsafeUnwrapWebhookEvent(_json = json)
                }
                "upload.post-transform.success" -> {
                    return tryDeserialize(node, jacksonTypeRef<UploadPostTransformSuccessEvent>())
                        ?.let {
                            UnsafeUnwrapWebhookEvent(uploadPostTransformSuccess = it, _json = json)
                        } ?: UnsafeUnwrapWebhookEvent(_json = json)
                }
                "upload.post-transform.error" -> {
                    return tryDeserialize(node, jacksonTypeRef<UploadPostTransformErrorEvent>())
                        ?.let {
                            UnsafeUnwrapWebhookEvent(uploadPostTransformError = it, _json = json)
                        } ?: UnsafeUnwrapWebhookEvent(_json = json)
                }
                "file.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<FileCreateEvent>())?.let {
                        UnsafeUnwrapWebhookEvent(fileCreated = it, _json = json)
                    } ?: UnsafeUnwrapWebhookEvent(_json = json)
                }
                "file.updated" -> {
                    return tryDeserialize(node, jacksonTypeRef<FileUpdateEvent>())?.let {
                        UnsafeUnwrapWebhookEvent(fileUpdated = it, _json = json)
                    } ?: UnsafeUnwrapWebhookEvent(_json = json)
                }
                "file.deleted" -> {
                    return tryDeserialize(node, jacksonTypeRef<FileDeleteEvent>())?.let {
                        UnsafeUnwrapWebhookEvent(fileDeleted = it, _json = json)
                    } ?: UnsafeUnwrapWebhookEvent(_json = json)
                }
                "file-version.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<FileVersionCreateEvent>())?.let {
                        UnsafeUnwrapWebhookEvent(fileVersionCreated = it, _json = json)
                    } ?: UnsafeUnwrapWebhookEvent(_json = json)
                }
                "file-version.deleted" -> {
                    return tryDeserialize(node, jacksonTypeRef<FileVersionDeleteEvent>())?.let {
                        UnsafeUnwrapWebhookEvent(fileVersionDeleted = it, _json = json)
                    } ?: UnsafeUnwrapWebhookEvent(_json = json)
                }
                "folder.created" -> {
                    return tryDeserialize(node, jacksonTypeRef<FolderCreateEvent>())?.let {
                        UnsafeUnwrapWebhookEvent(folderCreated = it, _json = json)
                    } ?: UnsafeUnwrapWebhookEvent(_json = json)
                }
                "folder.updated" -> {
                    return tryDeserialize(node, jacksonTypeRef<FolderUpdateEvent>())?.let {
                        UnsafeUnwrapWebhookEvent(folderUpdated = it, _json = json)
                    } ?: UnsafeUnwrapWebhookEvent(_json = json)
                }
                "folder.deleted" -> {
                    return tryDeserialize(node, jacksonTypeRef<FolderDeleteEvent>())?.let {
                        UnsafeUnwrapWebhookEvent(folderDeleted = it, _json = json)
                    } ?: UnsafeUnwrapWebhookEvent(_json = json)
                }
            }

            return UnsafeUnwrapWebhookEvent(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<UnsafeUnwrapWebhookEvent>(UnsafeUnwrapWebhookEvent::class) {

        override fun serialize(
            value: UnsafeUnwrapWebhookEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.videoTransformationAccepted != null ->
                    generator.writeObject(value.videoTransformationAccepted)
                value.videoTransformationReady != null ->
                    generator.writeObject(value.videoTransformationReady)
                value.videoTransformationError != null ->
                    generator.writeObject(value.videoTransformationError)
                value.uploadPreTransformSuccess != null ->
                    generator.writeObject(value.uploadPreTransformSuccess)
                value.uploadPreTransformError != null ->
                    generator.writeObject(value.uploadPreTransformError)
                value.uploadPostTransformSuccess != null ->
                    generator.writeObject(value.uploadPostTransformSuccess)
                value.uploadPostTransformError != null ->
                    generator.writeObject(value.uploadPostTransformError)
                value.fileCreated != null -> generator.writeObject(value.fileCreated)
                value.fileUpdated != null -> generator.writeObject(value.fileUpdated)
                value.fileDeleted != null -> generator.writeObject(value.fileDeleted)
                value.fileVersionCreated != null -> generator.writeObject(value.fileVersionCreated)
                value.fileVersionDeleted != null -> generator.writeObject(value.fileVersionDeleted)
                value.folderCreated != null -> generator.writeObject(value.folderCreated)
                value.folderUpdated != null -> generator.writeObject(value.folderUpdated)
                value.folderDeleted != null -> generator.writeObject(value.folderDeleted)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid UnsafeUnwrapWebhookEvent")
            }
        }
    }
}
