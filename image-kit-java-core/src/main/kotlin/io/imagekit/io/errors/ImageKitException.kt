package io.imagekit.io.errors

open class ImageKitException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
