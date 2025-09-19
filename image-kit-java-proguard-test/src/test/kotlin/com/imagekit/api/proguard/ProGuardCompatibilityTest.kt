// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.client.okhttp.ImageKitOkHttpClient
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import com.imagekit.api.models.StreamingResolution
import com.imagekit.api.models.UnnamedSchemaWithArrayParent1
import com.imagekit.api.models.files.File
import com.imagekit.api.models.files.UpdateFileRequest
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
                .privateApiKey("My Private API Key")
                .password("My Password")
                .build()

        assertThat(client).isNotNull()
        assertThat(client.customMetadataFields()).isNotNull()
        assertThat(client.files()).isNotNull()
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
                .addAiTag(
                    File.AiTag.builder().confidence(0.0).name("name").source("source").build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customCoordinates("customCoordinates")
                .customMetadata(
                    File.CustomMetadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .description("description")
                .fileId("fileId")
                .filePath("filePath")
                .fileType("fileType")
                .hasAlpha(true)
                .height(0.0)
                .isPrivateFile(true)
                .isPublished(true)
                .mime("mime")
                .name("name")
                .size(0.0)
                .addTag("string")
                .thumbnail("https://example.com")
                .type(File.Type.FILE)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .url("https://example.com")
                .versionInfo(File.VersionInfo.builder().id("id").name("name").build())
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
                            UnnamedSchemaWithArrayParent1.ofRemoveBg(
                                UnnamedSchemaWithArrayParent1.RemoveBg.builder()
                                    .options(
                                        UnnamedSchemaWithArrayParent1.RemoveBg.Options.builder()
                                            .addShadow(true)
                                            .bgColor("bg_color")
                                            .bgImageUrl("bg_image_url")
                                            .semitransparency(true)
                                            .build()
                                    )
                                    .build()
                            ),
                            UnnamedSchemaWithArrayParent1.ofAutoTaggingExtension(
                                UnnamedSchemaWithArrayParent1.AutoTaggingExtension.builder()
                                    .maxTags(10L)
                                    .minConfidence(80L)
                                    .name(
                                        UnnamedSchemaWithArrayParent1.AutoTaggingExtension.Name
                                            .GOOGLE_AUTO_TAGGING
                                    )
                                    .build()
                            ),
                            UnnamedSchemaWithArrayParent1.ofAutoTaggingExtension(
                                UnnamedSchemaWithArrayParent1.AutoTaggingExtension.builder()
                                    .maxTags(10L)
                                    .minConfidence(80L)
                                    .name(
                                        UnnamedSchemaWithArrayParent1.AutoTaggingExtension.Name
                                            .AWS_AUTO_TAGGING
                                    )
                                    .build()
                            ),
                            UnnamedSchemaWithArrayParent1.ofAiAutoDescription(),
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
