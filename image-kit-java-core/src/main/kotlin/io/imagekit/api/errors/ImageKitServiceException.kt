// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.errors

import io.imagekit.api.core.JsonValue
import io.imagekit.api.core.http.Headers

abstract class ImageKitServiceException
protected constructor(message: String, cause: Throwable? = null) :
    ImageKitException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
