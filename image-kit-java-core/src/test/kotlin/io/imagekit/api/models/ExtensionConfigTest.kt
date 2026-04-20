// File generated from our OpenAPI spec by Stainless.

package io.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.api.core.JsonValue
import io.imagekit.api.core.jsonMapper
import io.imagekit.api.errors.ImageKitInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ExtensionConfigTest {

    @Test
    fun ofRemoveBg() {
        val removeBg =
            ExtensionConfig.RemoveBg.builder()
                .options(
                    ExtensionConfig.RemoveBg.Options.builder()
                        .addShadow(true)
                        .bgColor("bg_color")
                        .bgImageUrl("bg_image_url")
                        .semitransparency(true)
                        .build()
                )
                .build()

        val extensionConfig = ExtensionConfig.ofRemoveBg(removeBg)

        assertThat(extensionConfig.removeBg()).contains(removeBg)
        assertThat(extensionConfig.autoTaggingExtension()).isEmpty
        assertThat(extensionConfig.aiAutoDescription()).isEmpty
        assertThat(extensionConfig.aiTasks()).isEmpty
    }

    @Test
    fun ofRemoveBgRoundtrip() {
        val jsonMapper = jsonMapper()
        val extensionConfig =
            ExtensionConfig.ofRemoveBg(
                ExtensionConfig.RemoveBg.builder()
                    .options(
                        ExtensionConfig.RemoveBg.Options.builder()
                            .addShadow(true)
                            .bgColor("bg_color")
                            .bgImageUrl("bg_image_url")
                            .semitransparency(true)
                            .build()
                    )
                    .build()
            )

        val roundtrippedExtensionConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extensionConfig),
                jacksonTypeRef<ExtensionConfig>(),
            )

        assertThat(roundtrippedExtensionConfig).isEqualTo(extensionConfig)
    }

    @Test
    fun ofAutoTaggingExtension() {
        val autoTaggingExtension =
            ExtensionConfig.AutoTaggingExtension.builder()
                .maxTags(0L)
                .minConfidence(0L)
                .name(ExtensionConfig.AutoTaggingExtension.Name.GOOGLE_AUTO_TAGGING)
                .build()

        val extensionConfig = ExtensionConfig.ofAutoTaggingExtension(autoTaggingExtension)

        assertThat(extensionConfig.removeBg()).isEmpty
        assertThat(extensionConfig.autoTaggingExtension()).contains(autoTaggingExtension)
        assertThat(extensionConfig.aiAutoDescription()).isEmpty
        assertThat(extensionConfig.aiTasks()).isEmpty
    }

    @Test
    fun ofAutoTaggingExtensionRoundtrip() {
        val jsonMapper = jsonMapper()
        val extensionConfig =
            ExtensionConfig.ofAutoTaggingExtension(
                ExtensionConfig.AutoTaggingExtension.builder()
                    .maxTags(0L)
                    .minConfidence(0L)
                    .name(ExtensionConfig.AutoTaggingExtension.Name.GOOGLE_AUTO_TAGGING)
                    .build()
            )

        val roundtrippedExtensionConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extensionConfig),
                jacksonTypeRef<ExtensionConfig>(),
            )

        assertThat(roundtrippedExtensionConfig).isEqualTo(extensionConfig)
    }

    @Test
    fun ofAiAutoDescription() {
        val extensionConfig = ExtensionConfig.ofAiAutoDescription()

        assertThat(extensionConfig.removeBg()).isEmpty
        assertThat(extensionConfig.autoTaggingExtension()).isEmpty
        assertThat(extensionConfig.aiAutoDescription())
            .contains(JsonValue.from(mapOf("name" to "ai-auto-description")))
        assertThat(extensionConfig.aiTasks()).isEmpty
    }

    @Test
    fun ofAiAutoDescriptionRoundtrip() {
        val jsonMapper = jsonMapper()
        val extensionConfig = ExtensionConfig.ofAiAutoDescription()

        val roundtrippedExtensionConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extensionConfig),
                jacksonTypeRef<ExtensionConfig>(),
            )

        assertThat(roundtrippedExtensionConfig).isEqualTo(extensionConfig)
    }

    @Test
    fun ofAiTasks() {
        val aiTasks =
            ExtensionConfig.AiTasks.builder()
                .addTask(
                    ExtensionConfig.AiTasks.Task.SelectTags.builder()
                        .instruction("What types of clothing items are visible in this image?")
                        .maxSelections(1L)
                        .minSelections(0L)
                        .vocabulary(listOf("shirt", "tshirt", "dress", "trousers", "jacket"))
                        .build()
                )
                .build()

        val extensionConfig = ExtensionConfig.ofAiTasks(aiTasks)

        assertThat(extensionConfig.removeBg()).isEmpty
        assertThat(extensionConfig.autoTaggingExtension()).isEmpty
        assertThat(extensionConfig.aiAutoDescription()).isEmpty
        assertThat(extensionConfig.aiTasks()).contains(aiTasks)
    }

    @Test
    fun ofAiTasksRoundtrip() {
        val jsonMapper = jsonMapper()
        val extensionConfig =
            ExtensionConfig.ofAiTasks(
                ExtensionConfig.AiTasks.builder()
                    .addTask(
                        ExtensionConfig.AiTasks.Task.SelectTags.builder()
                            .instruction("What types of clothing items are visible in this image?")
                            .maxSelections(1L)
                            .minSelections(0L)
                            .vocabulary(listOf("shirt", "tshirt", "dress", "trousers", "jacket"))
                            .build()
                    )
                    .build()
            )

        val roundtrippedExtensionConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extensionConfig),
                jacksonTypeRef<ExtensionConfig>(),
            )

        assertThat(roundtrippedExtensionConfig).isEqualTo(extensionConfig)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val extensionConfig =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ExtensionConfig>())

        val e = assertThrows<ImageKitInvalidDataException> { extensionConfig.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
