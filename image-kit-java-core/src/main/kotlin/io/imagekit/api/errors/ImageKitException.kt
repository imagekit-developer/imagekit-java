package io.imagekit.api.errors

open class ImageKitException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
