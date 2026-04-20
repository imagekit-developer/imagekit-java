@file:JvmName("StringHandler")

package io.imagekit.io.core.handlers

import io.imagekit.io.core.http.HttpResponse
import io.imagekit.io.core.http.HttpResponse.Handler

@JvmSynthetic internal fun stringHandler(): Handler<String> = StringHandlerInternal

private object StringHandlerInternal : Handler<String> {
    override fun handle(response: HttpResponse): String =
        response.body().readBytes().toString(Charsets.UTF_8)
}
