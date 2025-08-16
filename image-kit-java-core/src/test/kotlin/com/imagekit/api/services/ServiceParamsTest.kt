// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.imagekit.api.client.ImageKitClient
import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.core.JsonValue
import com.imagekit.api.models.files.FileUploadV1Params
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ServiceParamsTest {

    private lateinit var client: ImageKitClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            ImageKitOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun uploadV1() {
        val fileService = client.files()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

        fileService.uploadV1(
            FileUploadV1Params.builder()
                .file("https://www.example.com/rest-of-the-image-path.jpg")
                .fileName("fileName")
                .token("token")
                .checks("\"request.folder\" : \"marketing/\"\n")
                .customCoordinates("customCoordinates")
                .customMetadata(
                    "\"\n  {\n    \"brand\": \"Nike\",\n    \"color\":\"red\"\n  }\n\"\n"
                )
                .expire("expire")
                .extensions(
                    "\"\n[\n  {\"name\":\"remove-bg\",\"options\":{\"add_shadow\":true,\"bg_colour\":\"green\"}},\n  {\"name\":\"google-auto-tagging\",\"maxTags\":5,\"minConfidence\":95}\n]\n\"\n"
                )
                .folder("folder")
                .isPrivateFile(FileUploadV1Params.IsPrivateFile.TRUE)
                .isPublished(FileUploadV1Params.IsPublished.TRUE)
                .overwriteAiTags(FileUploadV1Params.OverwriteAiTags.TRUE)
                .overwriteCustomMetadata(FileUploadV1Params.OverwriteCustomMetadata.TRUE)
                .overwriteFile("overwriteFile")
                .overwriteTags(FileUploadV1Params.OverwriteTags.TRUE)
                .publicKey("publicKey")
                .responseFields("responseFields")
                .signature("signature")
                .tags("t-shirt,round-neck,men")
                .transformation(
                    "'{\"pre\":\"width:300,height:300,quality:80\",\"post\":[{\"type\":\"thumbnail\",\"value\":\"width:100,height:100\"}]}'\n"
                )
                .useUniqueFileName(FileUploadV1Params.UseUniqueFileName.TRUE)
                .webhookUrl("webhookUrl")
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withRequestBody(matchingJsonPath("$.secretProperty", equalTo("42")))
        )
    }
}
