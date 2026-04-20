package com.imagekit.api.lib

import com.imagekit.api.models.SrcOptions
import com.imagekit.api.models.Transformation

/**
 * Helper service interface for ImageKit SDK operations like URL building, transformation string
 * generation, and authentication parameter generation.
 *
 * You should not instantiate this service directly, and instead use it via the client:
 * ```java
 * ImageKitClient client = ImageKitOkHttpClient.builder()
 *     .privateKey("private_key_xxx")
 *     .build();
 *
 * String url = client.helper().buildUrl(srcOptions);
 * ```
 */
interface HelperService {

    fun buildUrl(options: SrcOptions): String

    fun buildTransformationString(transformations: List<Transformation>?): String

    fun getAuthenticationParameters(token: String? = null, expire: Long? = null): Map<String, Any>
}
