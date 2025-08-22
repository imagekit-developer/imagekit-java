// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.imagekit.api.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileUpdateParamsTest {

    @Test
    fun create() {
        FileUpdateParams.builder()
            .fileId("fileId")
            .body(
                FileUpdateParams.Body.UpdateFileDetails.builder()
                    .customCoordinates("10,10,100,100")
                    .customMetadata(
                        FileUpdateParams.Body.UpdateFileDetails.CustomMetadata.builder()
                            .putAdditionalProperty("brand", JsonValue.from("bar"))
                            .putAdditionalProperty("color", JsonValue.from("bar"))
                            .build()
                    )
                    .description("description")
                    .extensions(
                        listOf(
                            FileUpdateParams.Body.UpdateFileDetails.Extension.ofRemoveBg(
                                FileUpdateParams.Body.UpdateFileDetails.Extension.RemoveBg.builder()
                                    .options(
                                        FileUpdateParams.Body.UpdateFileDetails.Extension.RemoveBg
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
                            FileUpdateParams.Body.UpdateFileDetails.Extension.ofAutoTagging(
                                FileUpdateParams.Body.UpdateFileDetails.Extension
                                    .AutoTaggingExtension
                                    .builder()
                                    .maxTags(10L)
                                    .minConfidence(80L)
                                    .name(
                                        FileUpdateParams.Body.UpdateFileDetails.Extension
                                            .AutoTaggingExtension
                                            .Name
                                            .GOOGLE_AUTO_TAGGING
                                    )
                                    .build()
                            ),
                            FileUpdateParams.Body.UpdateFileDetails.Extension.ofAutoTagging(
                                FileUpdateParams.Body.UpdateFileDetails.Extension
                                    .AutoTaggingExtension
                                    .builder()
                                    .maxTags(10L)
                                    .minConfidence(80L)
                                    .name(
                                        FileUpdateParams.Body.UpdateFileDetails.Extension
                                            .AutoTaggingExtension
                                            .Name
                                            .AWS_AUTO_TAGGING
                                    )
                                    .build()
                            ),
                            FileUpdateParams.Body.UpdateFileDetails.Extension.ofAiAutoDescription(),
                        )
                    )
                    .removeAiTagsOfStrings(listOf("car", "vehicle", "motorsports"))
                    .addTag("tag1")
                    .addTag("tag2")
                    .webhookUrl("https://webhook.site/0d6b6c7a-8e5a-4b3a-8b7c-0d6b6c7a8e5a")
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params = FileUpdateParams.builder().fileId("fileId").build()

        assertThat(params._pathParam(0)).isEqualTo("fileId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            FileUpdateParams.builder()
                .fileId("fileId")
                .body(
                    FileUpdateParams.Body.UpdateFileDetails.builder()
                        .customCoordinates("10,10,100,100")
                        .customMetadata(
                            FileUpdateParams.Body.UpdateFileDetails.CustomMetadata.builder()
                                .putAdditionalProperty("brand", JsonValue.from("bar"))
                                .putAdditionalProperty("color", JsonValue.from("bar"))
                                .build()
                        )
                        .description("description")
                        .extensions(
                            listOf(
                                FileUpdateParams.Body.UpdateFileDetails.Extension.ofRemoveBg(
                                    FileUpdateParams.Body.UpdateFileDetails.Extension.RemoveBg
                                        .builder()
                                        .options(
                                            FileUpdateParams.Body.UpdateFileDetails.Extension
                                                .RemoveBg
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
                                FileUpdateParams.Body.UpdateFileDetails.Extension.ofAutoTagging(
                                    FileUpdateParams.Body.UpdateFileDetails.Extension
                                        .AutoTaggingExtension
                                        .builder()
                                        .maxTags(10L)
                                        .minConfidence(80L)
                                        .name(
                                            FileUpdateParams.Body.UpdateFileDetails.Extension
                                                .AutoTaggingExtension
                                                .Name
                                                .GOOGLE_AUTO_TAGGING
                                        )
                                        .build()
                                ),
                                FileUpdateParams.Body.UpdateFileDetails.Extension.ofAutoTagging(
                                    FileUpdateParams.Body.UpdateFileDetails.Extension
                                        .AutoTaggingExtension
                                        .builder()
                                        .maxTags(10L)
                                        .minConfidence(80L)
                                        .name(
                                            FileUpdateParams.Body.UpdateFileDetails.Extension
                                                .AutoTaggingExtension
                                                .Name
                                                .AWS_AUTO_TAGGING
                                        )
                                        .build()
                                ),
                                FileUpdateParams.Body.UpdateFileDetails.Extension
                                    .ofAiAutoDescription(),
                            )
                        )
                        .removeAiTagsOfStrings(listOf("car", "vehicle", "motorsports"))
                        .addTag("tag1")
                        .addTag("tag2")
                        .webhookUrl("https://webhook.site/0d6b6c7a-8e5a-4b3a-8b7c-0d6b6c7a8e5a")
                        .build()
                )
                .build()

        val body = params._body().getOrNull()

        assertThat(body)
            .isEqualTo(
                FileUpdateParams.Body.ofUpdateFileDetails(
                    FileUpdateParams.Body.UpdateFileDetails.builder()
                        .customCoordinates("10,10,100,100")
                        .customMetadata(
                            FileUpdateParams.Body.UpdateFileDetails.CustomMetadata.builder()
                                .putAdditionalProperty("brand", JsonValue.from("bar"))
                                .putAdditionalProperty("color", JsonValue.from("bar"))
                                .build()
                        )
                        .description("description")
                        .extensions(
                            listOf(
                                FileUpdateParams.Body.UpdateFileDetails.Extension.ofRemoveBg(
                                    FileUpdateParams.Body.UpdateFileDetails.Extension.RemoveBg
                                        .builder()
                                        .options(
                                            FileUpdateParams.Body.UpdateFileDetails.Extension
                                                .RemoveBg
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
                                FileUpdateParams.Body.UpdateFileDetails.Extension.ofAutoTagging(
                                    FileUpdateParams.Body.UpdateFileDetails.Extension
                                        .AutoTaggingExtension
                                        .builder()
                                        .maxTags(10L)
                                        .minConfidence(80L)
                                        .name(
                                            FileUpdateParams.Body.UpdateFileDetails.Extension
                                                .AutoTaggingExtension
                                                .Name
                                                .GOOGLE_AUTO_TAGGING
                                        )
                                        .build()
                                ),
                                FileUpdateParams.Body.UpdateFileDetails.Extension.ofAutoTagging(
                                    FileUpdateParams.Body.UpdateFileDetails.Extension
                                        .AutoTaggingExtension
                                        .builder()
                                        .maxTags(10L)
                                        .minConfidence(80L)
                                        .name(
                                            FileUpdateParams.Body.UpdateFileDetails.Extension
                                                .AutoTaggingExtension
                                                .Name
                                                .AWS_AUTO_TAGGING
                                        )
                                        .build()
                                ),
                                FileUpdateParams.Body.UpdateFileDetails.Extension
                                    .ofAiAutoDescription(),
                            )
                        )
                        .removeAiTagsOfStrings(listOf("car", "vehicle", "motorsports"))
                        .addTag("tag1")
                        .addTag("tag2")
                        .webhookUrl("https://webhook.site/0d6b6c7a-8e5a-4b3a-8b7c-0d6b6c7a8e5a")
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = FileUpdateParams.builder().fileId("fileId").build()

        val body = params._body().getOrNull()
    }
}
