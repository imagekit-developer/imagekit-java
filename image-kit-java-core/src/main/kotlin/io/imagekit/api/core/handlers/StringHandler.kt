@file:JvmName("StringHandler")

package io.imagekit.api.core.handlers

import io.imagekit.api.core.http.HttpResponse
import io.imagekit.api.core.http.HttpResponse.Handler

@JvmSynthetic internal fun stringHandler(): Handler<String> = StringHandlerInternal

private object StringHandlerInternal : Handler<String> {
    override fun handle(response: HttpResponse): String =
        response.body().readBytes().toString(Charsets.UTF_8)
}
