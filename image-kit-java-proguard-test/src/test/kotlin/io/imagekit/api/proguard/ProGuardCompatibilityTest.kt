// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.api.client.okhttp.ImageKitOkHttpClient
import io.imagekit.api.core.JsonValue
import io.imagekit.api.core.jsonMapper
import io.imagekit.api.models.AiTag
import io.imagekit.api.models.CustomMetadata
import io.imagekit.api.models.EmbeddedMetadata
import io.imagekit.api.models.ExtensionItem
import io.imagekit.api.models.SelectedFieldsSchema
import io.imagekit.api.models.StreamingResolution
import io.imagekit.api.models.VersionInfo
import io.imagekit.api.models.files.File
import io.imagekit.api.models.files.UpdateFileRequest
import java.time.OffsetDateTime
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream("META-INF/proguard/image-kit-java-core.pro")

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client =
            ImageKitOkHttpClient.builder()
                .privateKey("My Private Key")
                .password("My Password")
                .build()

        assertThat(client).isNotNull()
        assertThat(client.customMetadataFields()).isNotNull()
        assertThat(client.files()).isNotNull()
        assertThat(client.savedExtensions()).isNotNull()
        assertThat(client.assets()).isNotNull()
        assertThat(client.cache()).isNotNull()
        assertThat(client.folders()).isNotNull()
        assertThat(client.accounts()).isNotNull()
        assertThat(client.beta()).isNotNull()
        assertThat(client.webhooks()).isNotNull()
    }

    @Test
    fun fileRoundtrip() {
        val jsonMapper = jsonMapper()
        val file =
            File.builder()
                .addAiTag(AiTag.builder().confidence(0.0).name("name").source("source").build())
                .audioCodec("audioCodec")
                .bitRate(0L)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customCoordinates("customCoordinates")
                .customMetadata(
                    CustomMetadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .description("description")
                .duration(0L)
                .embeddedMetadata(
                    EmbeddedMetadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .fileId("fileId")
                .filePath("filePath")
                .fileType("fileType")
                .hasAlpha(true)
                .height(0.0)
                .isPrivateFile(true)
                .isPublished(true)
                .mime("mime")
                .name("name")
                .selectedFieldsSchema(
                    SelectedFieldsSchema.builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(
                                mapOf(
                                    "type" to "Text",
                                    "defaultValue" to listOf(true, 10, "Hello"),
                                    "isValueRequired" to true,
                                    "maxLength" to 0,
                                    "maxValue" to "string",
                                    "minLength" to 0,
                                    "minValue" to "string",
                                    "readOnly" to true,
                                    "selectOptions" to
                                        listOf("small", "medium", "large", 30, 40, true),
                                    "selectOptionsTruncated" to true,
                                )
                            ),
                        )
                        .build()
                )
                .size(0.0)
                .addTag("string")
                .thumbnail("https://example.com")
                .type(File.Type.FILE)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .url("https://example.com")
                .versionInfo(VersionInfo.builder().id("id").name("name").build())
                .videoCodec("videoCodec")
                .width(0.0)
                .build()

        val roundtrippedFile =
            jsonMapper.readValue(jsonMapper.writeValueAsString(file), jacksonTypeRef<File>())

        assertThat(roundtrippedFile).isEqualTo(file)
    }

    @Test
    fun updateFileRequestRoundtrip() {
        val jsonMapper = jsonMapper()
        val updateFileRequest =
            UpdateFileRequest.ofDetails(
                UpdateFileRequest.UpdateFileDetails.builder()
                    .customCoordinates("10,10,100,100")
                    .customMetadata(
                        UpdateFileRequest.UpdateFileDetails.CustomMetadata.builder()
                            .putAdditionalProperty("brand", JsonValue.from("bar"))
                            .putAdditionalProperty("color", JsonValue.from("bar"))
                            .build()
                    )
                    .description("description")
                    .extensions(
                        listOf(
                            ExtensionItem.ofRemoveBg(
                                ExtensionItem.RemoveBg.builder()
                                    .options(
                                        ExtensionItem.RemoveBg.Options.builder()
                                            .addShadow(true)
                                            .bgColor("bg_color")
                                            .bgImageUrl("bg_image_url")
                                            .semitransparency(true)
                                            .build()
                                    )
                                    .build()
                            ),
                            ExtensionItem.ofAutoTaggingExtension(
                                ExtensionItem.AutoTaggingExtension.builder()
                                    .maxTags(10L)
                                    .minConfidence(80L)
                                    .name(
                                        ExtensionItem.AutoTaggingExtension.Name.GOOGLE_AUTO_TAGGING
                                    )
                                    .build()
                            ),
                            ExtensionItem.ofAutoTaggingExtension(
                                ExtensionItem.AutoTaggingExtension.builder()
                                    .maxTags(10L)
                                    .minConfidence(80L)
                                    .name(ExtensionItem.AutoTaggingExtension.Name.AWS_AUTO_TAGGING)
                                    .build()
                            ),
                            ExtensionItem.ofAiAutoDescription(),
                            ExtensionItem.ofAiTasks(
                                ExtensionItem.AiTasks.builder()
                                    .addTask(
                                        ExtensionItem.AiTasks.Task.SelectTags.builder()
                                            .instruction(
                                                "What types of clothing items are visible?"
                                            )
                                            .maxSelections(1L)
                                            .minSelections(0L)
                                            .vocabulary(listOf("shirt", "dress", "jacket"))
                                            .build()
                                    )
                                    .build()
                            ),
                            ExtensionItem.ofSavedExtension(
                                ExtensionItem.SavedExtension.builder().id("ext_abc123").build()
                            ),
                        )
                    )
                    .removeAiTagsOfStrings(listOf("car", "vehicle", "motorsports"))
                    .addTag("tag1")
                    .addTag("tag2")
                    .webhookUrl("https://webhook.site/0d6b6c7a-8e5a-4b3a-8b7c-0d6b6c7a8e5a")
                    .build()
            )

        val roundtrippedUpdateFileRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(updateFileRequest),
                jacksonTypeRef<UpdateFileRequest>(),
            )

        assertThat(roundtrippedUpdateFileRequest).isEqualTo(updateFileRequest)
    }

    @Test
    fun streamingResolutionRoundtrip() {
        val jsonMapper = jsonMapper()
        val streamingResolution = StreamingResolution._240

        val roundtrippedStreamingResolution =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(streamingResolution),
                jacksonTypeRef<StreamingResolution>(),
            )

        assertThat(roundtrippedStreamingResolution).isEqualTo(streamingResolution)
    }
}
