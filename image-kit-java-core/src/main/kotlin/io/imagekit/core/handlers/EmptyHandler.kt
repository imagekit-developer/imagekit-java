@file:JvmName("EmptyHandler")

package io.imagekit.core.handlers

import io.imagekit.core.http.HttpResponse
import io.imagekit.core.http.HttpResponse.Handler

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
