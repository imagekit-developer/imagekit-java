// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.webhooks

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.BaseDeserializer
import com.imagekit.api.core.BaseSerializer
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.allMaxBy
import com.imagekit.api.core.getOrThrow
import com.imagekit.api.errors.ImageKitInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Triggered when a new video transformation request is accepted for processing. This event confirms
 * that ImageKit has received and queued your transformation request. Use this for debugging and
 * tracking transformation lifecycle.
 */
@JsonDeserialize(using = UnwrapWebhookEvent.Deserializer::class)
@JsonSerialize(using = UnwrapWebhookEvent.Serializer::class)
class UnwrapWebhookEvent
private constructor(
    private val videoTransformationAccepted: VideoTransformationAcceptedEvent? = null,
    private val videoTransformationReady: VideoTransformationReadyEvent? = null,
    private val videoTransformationError: VideoTransformationErrorEvent? = null,
    private val uploadPreTransformSuccess: UploadPreTransformSuccessEvent? = null,
    private val uploadPreTransformError: UploadPreTransformErrorEvent? = null,
    private val uploadPostTransformSuccess: UploadPostTransformSuccessEvent? = null,
    private val uploadPostTransformError: UploadPostTransformErrorEvent? = null,
    private val damFileCreate: DamFileCreateEvent? = null,
    private val damFileUpdate: DamFileUpdateEvent? = null,
    private val damFileDelete: DamFileDeleteEvent? = null,
    private val damFileVersionCreate: DamFileVersionCreateEvent? = null,
    private val damFileVersionDelete: DamFileVersionDeleteEvent? = null,
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
    fun damFileCreate(): Optional<DamFileCreateEvent> = Optional.ofNullable(damFileCreate)

    /** Triggered when a file is updated. */
    fun damFileUpdate(): Optional<DamFileUpdateEvent> = Optional.ofNullable(damFileUpdate)

    /** Triggered when a file is deleted. */
    fun damFileDelete(): Optional<DamFileDeleteEvent> = Optional.ofNullable(damFileDelete)

    /** Triggered when a file version is created. */
    fun damFileVersionCreate(): Optional<DamFileVersionCreateEvent> =
        Optional.ofNullable(damFileVersionCreate)

    /** Triggered when a file version is deleted. */
    fun damFileVersionDelete(): Optional<DamFileVersionDeleteEvent> =
        Optional.ofNullable(damFileVersionDelete)

    fun isVideoTransformationAccepted(): Boolean = videoTransformationAccepted != null

    fun isVideoTransformationReady(): Boolean = videoTransformationReady != null

    fun isVideoTransformationError(): Boolean = videoTransformationError != null

    fun isUploadPreTransformSuccess(): Boolean = uploadPreTransformSuccess != null

    fun isUploadPreTransformError(): Boolean = uploadPreTransformError != null

    fun isUploadPostTransformSuccess(): Boolean = uploadPostTransformSuccess != null

    fun isUploadPostTransformError(): Boolean = uploadPostTransformError != null

    fun isDamFileCreate(): Boolean = damFileCreate != null

    fun isDamFileUpdate(): Boolean = damFileUpdate != null

    fun isDamFileDelete(): Boolean = damFileDelete != null

    fun isDamFileVersionCreate(): Boolean = damFileVersionCreate != null

    fun isDamFileVersionDelete(): Boolean = damFileVersionDelete != null

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
    fun asDamFileCreate(): DamFileCreateEvent = damFileCreate.getOrThrow("damFileCreate")

    /** Triggered when a file is updated. */
    fun asDamFileUpdate(): DamFileUpdateEvent = damFileUpdate.getOrThrow("damFileUpdate")

    /** Triggered when a file is deleted. */
    fun asDamFileDelete(): DamFileDeleteEvent = damFileDelete.getOrThrow("damFileDelete")

    /** Triggered when a file version is created. */
    fun asDamFileVersionCreate(): DamFileVersionCreateEvent =
        damFileVersionCreate.getOrThrow("damFileVersionCreate")

    /** Triggered when a file version is deleted. */
    fun asDamFileVersionDelete(): DamFileVersionDeleteEvent =
        damFileVersionDelete.getOrThrow("damFileVersionDelete")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

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
            damFileCreate != null -> visitor.visitDamFileCreate(damFileCreate)
            damFileUpdate != null -> visitor.visitDamFileUpdate(damFileUpdate)
            damFileDelete != null -> visitor.visitDamFileDelete(damFileDelete)
            damFileVersionCreate != null -> visitor.visitDamFileVersionCreate(damFileVersionCreate)
            damFileVersionDelete != null -> visitor.visitDamFileVersionDelete(damFileVersionDelete)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): UnwrapWebhookEvent = apply {
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

                override fun visitDamFileCreate(damFileCreate: DamFileCreateEvent) {
                    damFileCreate.validate()
                }

                override fun visitDamFileUpdate(damFileUpdate: DamFileUpdateEvent) {
                    damFileUpdate.validate()
                }

                override fun visitDamFileDelete(damFileDelete: DamFileDeleteEvent) {
                    damFileDelete.validate()
                }

                override fun visitDamFileVersionCreate(
                    damFileVersionCreate: DamFileVersionCreateEvent
                ) {
                    damFileVersionCreate.validate()
                }

                override fun visitDamFileVersionDelete(
                    damFileVersionDelete: DamFileVersionDeleteEvent
                ) {
                    damFileVersionDelete.validate()
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

                override fun visitDamFileCreate(damFileCreate: DamFileCreateEvent) =
                    damFileCreate.validity()

                override fun visitDamFileUpdate(damFileUpdate: DamFileUpdateEvent) =
                    damFileUpdate.validity()

                override fun visitDamFileDelete(damFileDelete: DamFileDeleteEvent) =
                    damFileDelete.validity()

                override fun visitDamFileVersionCreate(
                    damFileVersionCreate: DamFileVersionCreateEvent
                ) = damFileVersionCreate.validity()

                override fun visitDamFileVersionDelete(
                    damFileVersionDelete: DamFileVersionDeleteEvent
                ) = damFileVersionDelete.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UnwrapWebhookEvent &&
            videoTransformationAccepted == other.videoTransformationAccepted &&
            videoTransformationReady == other.videoTransformationReady &&
            videoTransformationError == other.videoTransformationError &&
            uploadPreTransformSuccess == other.uploadPreTransformSuccess &&
            uploadPreTransformError == other.uploadPreTransformError &&
            uploadPostTransformSuccess == other.uploadPostTransformSuccess &&
            uploadPostTransformError == other.uploadPostTransformError &&
            damFileCreate == other.damFileCreate &&
            damFileUpdate == other.damFileUpdate &&
            damFileDelete == other.damFileDelete &&
            damFileVersionCreate == other.damFileVersionCreate &&
            damFileVersionDelete == other.damFileVersionDelete
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
            damFileCreate,
            damFileUpdate,
            damFileDelete,
            damFileVersionCreate,
            damFileVersionDelete,
        )

    override fun toString(): String =
        when {
            videoTransformationAccepted != null ->
                "UnwrapWebhookEvent{videoTransformationAccepted=$videoTransformationAccepted}"
            videoTransformationReady != null ->
                "UnwrapWebhookEvent{videoTransformationReady=$videoTransformationReady}"
            videoTransformationError != null ->
                "UnwrapWebhookEvent{videoTransformationError=$videoTransformationError}"
            uploadPreTransformSuccess != null ->
                "UnwrapWebhookEvent{uploadPreTransformSuccess=$uploadPreTransformSuccess}"
            uploadPreTransformError != null ->
                "UnwrapWebhookEvent{uploadPreTransformError=$uploadPreTransformError}"
            uploadPostTransformSuccess != null ->
                "UnwrapWebhookEvent{uploadPostTransformSuccess=$uploadPostTransformSuccess}"
            uploadPostTransformError != null ->
                "UnwrapWebhookEvent{uploadPostTransformError=$uploadPostTransformError}"
            damFileCreate != null -> "UnwrapWebhookEvent{damFileCreate=$damFileCreate}"
            damFileUpdate != null -> "UnwrapWebhookEvent{damFileUpdate=$damFileUpdate}"
            damFileDelete != null -> "UnwrapWebhookEvent{damFileDelete=$damFileDelete}"
            damFileVersionCreate != null ->
                "UnwrapWebhookEvent{damFileVersionCreate=$damFileVersionCreate}"
            damFileVersionDelete != null ->
                "UnwrapWebhookEvent{damFileVersionDelete=$damFileVersionDelete}"
            _json != null -> "UnwrapWebhookEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid UnwrapWebhookEvent")
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
        ) = UnwrapWebhookEvent(videoTransformationAccepted = videoTransformationAccepted)

        /**
         * Triggered when video encoding is finished and the transformed resource is ready to be
         * served. This is the key event to listen for - update your database or CMS flags when you
         * receive this so your application can start showing the transformed video to users.
         */
        @JvmStatic
        fun ofVideoTransformationReady(videoTransformationReady: VideoTransformationReadyEvent) =
            UnwrapWebhookEvent(videoTransformationReady = videoTransformationReady)

        /**
         * Triggered when an error occurs during video encoding. Listen to this webhook to log error
         * reasons and debug issues. Check your origin and URL endpoint settings if the reason is
         * related to download failure. For other errors, contact ImageKit support.
         */
        @JvmStatic
        fun ofVideoTransformationError(videoTransformationError: VideoTransformationErrorEvent) =
            UnwrapWebhookEvent(videoTransformationError = videoTransformationError)

        /**
         * Triggered when a pre-transformation completes successfully. The file has been processed
         * with the requested transformation and is now available in the Media Library.
         */
        @JvmStatic
        fun ofUploadPreTransformSuccess(uploadPreTransformSuccess: UploadPreTransformSuccessEvent) =
            UnwrapWebhookEvent(uploadPreTransformSuccess = uploadPreTransformSuccess)

        /**
         * Triggered when a pre-transformation fails. The file upload may have been accepted, but
         * the requested transformation could not be applied.
         */
        @JvmStatic
        fun ofUploadPreTransformError(uploadPreTransformError: UploadPreTransformErrorEvent) =
            UnwrapWebhookEvent(uploadPreTransformError = uploadPreTransformError)

        /**
         * Triggered when a post-transformation completes successfully. The transformed version of
         * the file is now ready and can be accessed via the provided URL. Note that each
         * post-transformation generates a separate webhook event.
         */
        @JvmStatic
        fun ofUploadPostTransformSuccess(
            uploadPostTransformSuccess: UploadPostTransformSuccessEvent
        ) = UnwrapWebhookEvent(uploadPostTransformSuccess = uploadPostTransformSuccess)

        /**
         * Triggered when a post-transformation fails. The original file remains available, but the
         * requested transformation could not be generated.
         */
        @JvmStatic
        fun ofUploadPostTransformError(uploadPostTransformError: UploadPostTransformErrorEvent) =
            UnwrapWebhookEvent(uploadPostTransformError = uploadPostTransformError)

        /** Triggered when a file is created. */
        @JvmStatic
        fun ofDamFileCreate(damFileCreate: DamFileCreateEvent) =
            UnwrapWebhookEvent(damFileCreate = damFileCreate)

        /** Triggered when a file is updated. */
        @JvmStatic
        fun ofDamFileUpdate(damFileUpdate: DamFileUpdateEvent) =
            UnwrapWebhookEvent(damFileUpdate = damFileUpdate)

        /** Triggered when a file is deleted. */
        @JvmStatic
        fun ofDamFileDelete(damFileDelete: DamFileDeleteEvent) =
            UnwrapWebhookEvent(damFileDelete = damFileDelete)

        /** Triggered when a file version is created. */
        @JvmStatic
        fun ofDamFileVersionCreate(damFileVersionCreate: DamFileVersionCreateEvent) =
            UnwrapWebhookEvent(damFileVersionCreate = damFileVersionCreate)

        /** Triggered when a file version is deleted. */
        @JvmStatic
        fun ofDamFileVersionDelete(damFileVersionDelete: DamFileVersionDeleteEvent) =
            UnwrapWebhookEvent(damFileVersionDelete = damFileVersionDelete)
    }

    /**
     * An interface that defines how to map each variant of [UnwrapWebhookEvent] to a value of type
     * [T].
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
        fun visitDamFileCreate(damFileCreate: DamFileCreateEvent): T

        /** Triggered when a file is updated. */
        fun visitDamFileUpdate(damFileUpdate: DamFileUpdateEvent): T

        /** Triggered when a file is deleted. */
        fun visitDamFileDelete(damFileDelete: DamFileDeleteEvent): T

        /** Triggered when a file version is created. */
        fun visitDamFileVersionCreate(damFileVersionCreate: DamFileVersionCreateEvent): T

        /** Triggered when a file version is deleted. */
        fun visitDamFileVersionDelete(damFileVersionDelete: DamFileVersionDeleteEvent): T

        /**
         * Maps an unknown variant of [UnwrapWebhookEvent] to a value of type [T].
         *
         * An instance of [UnwrapWebhookEvent] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws ImageKitInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw ImageKitInvalidDataException("Unknown UnwrapWebhookEvent: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<UnwrapWebhookEvent>(UnwrapWebhookEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): UnwrapWebhookEvent {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {}

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<VideoTransformationAcceptedEvent>())
                            ?.let {
                                UnwrapWebhookEvent(videoTransformationAccepted = it, _json = json)
                            },
                        tryDeserialize(node, jacksonTypeRef<VideoTransformationReadyEvent>())?.let {
                            UnwrapWebhookEvent(videoTransformationReady = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<VideoTransformationErrorEvent>())?.let {
                            UnwrapWebhookEvent(videoTransformationError = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<UploadPreTransformSuccessEvent>())
                            ?.let {
                                UnwrapWebhookEvent(uploadPreTransformSuccess = it, _json = json)
                            },
                        tryDeserialize(node, jacksonTypeRef<UploadPreTransformErrorEvent>())?.let {
                            UnwrapWebhookEvent(uploadPreTransformError = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<UploadPostTransformSuccessEvent>())
                            ?.let {
                                UnwrapWebhookEvent(uploadPostTransformSuccess = it, _json = json)
                            },
                        tryDeserialize(node, jacksonTypeRef<UploadPostTransformErrorEvent>())?.let {
                            UnwrapWebhookEvent(uploadPostTransformError = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<DamFileCreateEvent>())?.let {
                            UnwrapWebhookEvent(damFileCreate = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<DamFileUpdateEvent>())?.let {
                            UnwrapWebhookEvent(damFileUpdate = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<DamFileDeleteEvent>())?.let {
                            UnwrapWebhookEvent(damFileDelete = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<DamFileVersionCreateEvent>())?.let {
                            UnwrapWebhookEvent(damFileVersionCreate = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<DamFileVersionDeleteEvent>())?.let {
                            UnwrapWebhookEvent(damFileVersionDelete = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> UnwrapWebhookEvent(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<UnwrapWebhookEvent>(UnwrapWebhookEvent::class) {

        override fun serialize(
            value: UnwrapWebhookEvent,
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
                value.damFileCreate != null -> generator.writeObject(value.damFileCreate)
                value.damFileUpdate != null -> generator.writeObject(value.damFileUpdate)
                value.damFileDelete != null -> generator.writeObject(value.damFileDelete)
                value.damFileVersionCreate != null ->
                    generator.writeObject(value.damFileVersionCreate)
                value.damFileVersionDelete != null ->
                    generator.writeObject(value.damFileVersionDelete)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid UnwrapWebhookEvent")
            }
        }
    }
}
