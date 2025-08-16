// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.services.async.files

import com.imagekit.api.TestServerExtension
import com.imagekit.api.client.okhttp.ImageKitOkHttpClientAsync
import com.imagekit.api.core.JsonValue
import com.imagekit.api.models.files.details.DetailUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class DetailServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val detailServiceAsync = client.files().details()

        val detailFuture = detailServiceAsync.retrieve("fileId")

        val detail = detailFuture.get()
        detail.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun update() {
        val client =
            ImageKitOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()
        val detailServiceAsync = client.files().details()

        val detailFuture =
            detailServiceAsync.update(
                DetailUpdateParams.builder()
                    .fileId("fileId")
                    .body(
                        DetailUpdateParams.Body.UpdateFileDetails.builder()
                            .customCoordinates("10,10,100,100")
                            .customMetadata(
                                JsonValue.from(mapOf("brand" to "Nike", "color" to "red"))
                            )
                            .extensions(
                                listOf(
                                    DetailUpdateParams.Body.UpdateFileDetails.Extension
                                        .ofRemovedotBg(
                                            DetailUpdateParams.Body.UpdateFileDetails.Extension
                                                .RemovedotBgExtension
                                                .builder()
                                                .name(
                                                    DetailUpdateParams.Body.UpdateFileDetails
                                                        .Extension
                                                        .RemovedotBgExtension
                                                        .Name
                                                        .REMOVE_BG
                                                )
                                                .options(
                                                    DetailUpdateParams.Body.UpdateFileDetails
                                                        .Extension
                                                        .RemovedotBgExtension
                                                        .Options
                                                        .builder()
                                                        .addShadow(true)
                                                        .bgColor("bg_color")
                                                        .bgImageUrl("bg_image_url")
                                                        .semitransparency(true)
                                                        .build()
                                                )
                                                .build()
                                        ),
                                    DetailUpdateParams.Body.UpdateFileDetails.Extension
                                        .ofAutoTagging(
                                            DetailUpdateParams.Body.UpdateFileDetails.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(10L)
                                                .minConfidence(80L)
                                                .name(
                                                    DetailUpdateParams.Body.UpdateFileDetails
                                                        .Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .GOOGLE_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                    DetailUpdateParams.Body.UpdateFileDetails.Extension
                                        .ofAutoTagging(
                                            DetailUpdateParams.Body.UpdateFileDetails.Extension
                                                .AutoTaggingExtension
                                                .builder()
                                                .maxTags(10L)
                                                .minConfidence(80L)
                                                .name(
                                                    DetailUpdateParams.Body.UpdateFileDetails
                                                        .Extension
                                                        .AutoTaggingExtension
                                                        .Name
                                                        .AWS_AUTO_TAGGING
                                                )
                                                .build()
                                        ),
                                )
                            )
                            .removeAiTagsOfStrings(listOf("car", "vehicle", "motorsports"))
                            .addTag("tag1")
                            .addTag("tag2")
                            .webhookUrl("https://webhook.site/0d6b6c7a-8e5a-4b3a-8b7c-0d6b6c7a8e5a")
                            .build()
                    )
                    .build()
            )

        val detail = detailFuture.get()
        detail.validate()
    }
}
