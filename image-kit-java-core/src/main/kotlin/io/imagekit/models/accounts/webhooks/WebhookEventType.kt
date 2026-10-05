// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.webhooks

import com.fasterxml.jackson.annotation.JsonCreator
import io.imagekit.core.Enum
import io.imagekit.core.JsonField
import io.imagekit.errors.ImageKitInvalidDataException

/**
 * A webhook event type. Learn more about the payload of each
 * [webhook event](https://imagekit.io/docs/webhooks#list-of-events).
 */
class WebhookEventType @JsonCreator private constructor(private val value: JsonField<String>) :
    Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val VIDEO_TRANSFORMATION_ACCEPTED = of("video.transformation.accepted")

        @JvmField val VIDEO_TRANSFORMATION_READY = of("video.transformation.ready")

        @JvmField val VIDEO_TRANSFORMATION_ERROR = of("video.transformation.error")

        @JvmField val UPLOAD_PRE_TRANSFORM_SUCCESS = of("upload.pre-transform.success")

        @JvmField val UPLOAD_PRE_TRANSFORM_ERROR = of("upload.pre-transform.error")

        @JvmField val UPLOAD_POST_TRANSFORM_SUCCESS = of("upload.post-transform.success")

        @JvmField val UPLOAD_POST_TRANSFORM_ERROR = of("upload.post-transform.error")

        @JvmField val FILE_CREATED = of("file.created")

        @JvmField val FILE_UPDATED = of("file.updated")

        @JvmField val FILE_DELETED = of("file.deleted")

        @JvmField val FILE_VERSION_CREATED = of("file-version.created")

        @JvmField val FILE_VERSION_DELETED = of("file-version.deleted")

        @JvmStatic fun of(value: String) = WebhookEventType(JsonField.of(value))
    }

    /** An enum containing [WebhookEventType]'s known values. */
    enum class Known {
        VIDEO_TRANSFORMATION_ACCEPTED,
        VIDEO_TRANSFORMATION_READY,
        VIDEO_TRANSFORMATION_ERROR,
        UPLOAD_PRE_TRANSFORM_SUCCESS,
        UPLOAD_PRE_TRANSFORM_ERROR,
        UPLOAD_POST_TRANSFORM_SUCCESS,
        UPLOAD_POST_TRANSFORM_ERROR,
        FILE_CREATED,
        FILE_UPDATED,
        FILE_DELETED,
        FILE_VERSION_CREATED,
        FILE_VERSION_DELETED,
    }

    /**
     * An enum containing [WebhookEventType]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [WebhookEventType] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        VIDEO_TRANSFORMATION_ACCEPTED,
        VIDEO_TRANSFORMATION_READY,
        VIDEO_TRANSFORMATION_ERROR,
        UPLOAD_PRE_TRANSFORM_SUCCESS,
        UPLOAD_PRE_TRANSFORM_ERROR,
        UPLOAD_POST_TRANSFORM_SUCCESS,
        UPLOAD_POST_TRANSFORM_ERROR,
        FILE_CREATED,
        FILE_UPDATED,
        FILE_DELETED,
        FILE_VERSION_CREATED,
        FILE_VERSION_DELETED,
        /**
         * An enum member indicating that [WebhookEventType] was instantiated with an unknown value.
         */
        _UNKNOWN,
    }

    /**
     * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if
     * the class was instantiated with an unknown value.
     *
     * Use the [known] method instead if you're certain the value is always known or if you want to
     * throw for the unknown case.
     */
    fun value(): Value =
        when (this) {
            VIDEO_TRANSFORMATION_ACCEPTED -> Value.VIDEO_TRANSFORMATION_ACCEPTED
            VIDEO_TRANSFORMATION_READY -> Value.VIDEO_TRANSFORMATION_READY
            VIDEO_TRANSFORMATION_ERROR -> Value.VIDEO_TRANSFORMATION_ERROR
            UPLOAD_PRE_TRANSFORM_SUCCESS -> Value.UPLOAD_PRE_TRANSFORM_SUCCESS
            UPLOAD_PRE_TRANSFORM_ERROR -> Value.UPLOAD_PRE_TRANSFORM_ERROR
            UPLOAD_POST_TRANSFORM_SUCCESS -> Value.UPLOAD_POST_TRANSFORM_SUCCESS
            UPLOAD_POST_TRANSFORM_ERROR -> Value.UPLOAD_POST_TRANSFORM_ERROR
            FILE_CREATED -> Value.FILE_CREATED
            FILE_UPDATED -> Value.FILE_UPDATED
            FILE_DELETED -> Value.FILE_DELETED
            FILE_VERSION_CREATED -> Value.FILE_VERSION_CREATED
            FILE_VERSION_DELETED -> Value.FILE_VERSION_DELETED
            else -> Value._UNKNOWN
        }

    /**
     * Returns an enum member corresponding to this class instance's value.
     *
     * Use the [value] method instead if you're uncertain the value is always known and don't want
     * to throw for the unknown case.
     *
     * @throws ImageKitInvalidDataException if this class instance's value is a not a known member.
     */
    fun known(): Known =
        when (this) {
            VIDEO_TRANSFORMATION_ACCEPTED -> Known.VIDEO_TRANSFORMATION_ACCEPTED
            VIDEO_TRANSFORMATION_READY -> Known.VIDEO_TRANSFORMATION_READY
            VIDEO_TRANSFORMATION_ERROR -> Known.VIDEO_TRANSFORMATION_ERROR
            UPLOAD_PRE_TRANSFORM_SUCCESS -> Known.UPLOAD_PRE_TRANSFORM_SUCCESS
            UPLOAD_PRE_TRANSFORM_ERROR -> Known.UPLOAD_PRE_TRANSFORM_ERROR
            UPLOAD_POST_TRANSFORM_SUCCESS -> Known.UPLOAD_POST_TRANSFORM_SUCCESS
            UPLOAD_POST_TRANSFORM_ERROR -> Known.UPLOAD_POST_TRANSFORM_ERROR
            FILE_CREATED -> Known.FILE_CREATED
            FILE_UPDATED -> Known.FILE_UPDATED
            FILE_DELETED -> Known.FILE_DELETED
            FILE_VERSION_CREATED -> Known.FILE_VERSION_CREATED
            FILE_VERSION_DELETED -> Known.FILE_VERSION_DELETED
            else -> throw ImageKitInvalidDataException("Unknown WebhookEventType: $value")
        }

    /**
     * Returns this class instance's primitive wire representation.
     *
     * This differs from the [toString] method because that method is primarily for debugging and
     * generally doesn't throw.
     *
     * @throws ImageKitInvalidDataException if this class instance's value does not have the
     *   expected primitive type.
     */
    fun asString(): String =
        _value().asString().orElseThrow { ImageKitInvalidDataException("Value is not a String") }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): WebhookEventType = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookEventType && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
