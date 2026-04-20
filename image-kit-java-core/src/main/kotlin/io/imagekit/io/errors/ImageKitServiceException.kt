// File generated from our OpenAPI spec by Stainless.

package io.imagekit.io.errors

import io.imagekit.io.core.JsonValue
import io.imagekit.io.core.http.Headers

abstract class ImageKitServiceException
protected constructor(message: String, cause: Throwable? = null) :
    ImageKitException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
