// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import com.imagekit.api.errors.ImageKitInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ExtensionItemTest {

    @Test
    fun ofRemoveBg() {
        val removeBg =
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

        val extensionItem = ExtensionItem.ofRemoveBg(removeBg)

        assertThat(extensionItem.removeBg()).contains(removeBg)
        assertThat(extensionItem.autoTaggingExtension()).isEmpty
        assertThat(extensionItem.aiAutoDescription()).isEmpty
        assertThat(extensionItem.aiTasks()).isEmpty
        assertThat(extensionItem.savedExtension()).isEmpty
    }

    @Test
    fun ofRemoveBgRoundtrip() {
        val jsonMapper = jsonMapper()
        val extensionItem =
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
            )

        val roundtrippedExtensionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extensionItem),
                jacksonTypeRef<ExtensionItem>(),
            )

        assertThat(roundtrippedExtensionItem).isEqualTo(extensionItem)
    }

    @Test
    fun ofAutoTaggingExtension() {
        val autoTaggingExtension =
            ExtensionItem.AutoTaggingExtension.builder()
                .maxTags(0L)
                .minConfidence(0L)
                .name(ExtensionItem.AutoTaggingExtension.Name.GOOGLE_AUTO_TAGGING)
                .build()

        val extensionItem = ExtensionItem.ofAutoTaggingExtension(autoTaggingExtension)

        assertThat(extensionItem.removeBg()).isEmpty
        assertThat(extensionItem.autoTaggingExtension()).contains(autoTaggingExtension)
        assertThat(extensionItem.aiAutoDescription()).isEmpty
        assertThat(extensionItem.aiTasks()).isEmpty
        assertThat(extensionItem.savedExtension()).isEmpty
    }

    @Test
    fun ofAutoTaggingExtensionRoundtrip() {
        val jsonMapper = jsonMapper()
        val extensionItem =
            ExtensionItem.ofAutoTaggingExtension(
                ExtensionItem.AutoTaggingExtension.builder()
                    .maxTags(0L)
                    .minConfidence(0L)
                    .name(ExtensionItem.AutoTaggingExtension.Name.GOOGLE_AUTO_TAGGING)
                    .build()
            )

        val roundtrippedExtensionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extensionItem),
                jacksonTypeRef<ExtensionItem>(),
            )

        assertThat(roundtrippedExtensionItem).isEqualTo(extensionItem)
    }

    @Test
    fun ofAiAutoDescription() {
        val extensionItem = ExtensionItem.ofAiAutoDescription()

        assertThat(extensionItem.removeBg()).isEmpty
        assertThat(extensionItem.autoTaggingExtension()).isEmpty
        assertThat(extensionItem.aiAutoDescription())
            .contains(JsonValue.from(mapOf("name" to "ai-auto-description")))
        assertThat(extensionItem.aiTasks()).isEmpty
        assertThat(extensionItem.savedExtension()).isEmpty
    }

    @Test
    fun ofAiAutoDescriptionRoundtrip() {
        val jsonMapper = jsonMapper()
        val extensionItem = ExtensionItem.ofAiAutoDescription()

        val roundtrippedExtensionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extensionItem),
                jacksonTypeRef<ExtensionItem>(),
            )

        assertThat(roundtrippedExtensionItem).isEqualTo(extensionItem)
    }

    @Test
    fun ofAiTasks() {
        val aiTasks =
            ExtensionItem.AiTasks.builder()
                .addTask(
                    ExtensionItem.AiTasks.Task.SelectTags.builder()
                        .instruction("What types of clothing items are visible in this image?")
                        .maxSelections(1L)
                        .minSelections(0L)
                        .vocabulary(listOf("shirt", "tshirt", "dress", "trousers", "jacket"))
                        .build()
                )
                .build()

        val extensionItem = ExtensionItem.ofAiTasks(aiTasks)

        assertThat(extensionItem.removeBg()).isEmpty
        assertThat(extensionItem.autoTaggingExtension()).isEmpty
        assertThat(extensionItem.aiAutoDescription()).isEmpty
        assertThat(extensionItem.aiTasks()).contains(aiTasks)
        assertThat(extensionItem.savedExtension()).isEmpty
    }

    @Test
    fun ofAiTasksRoundtrip() {
        val jsonMapper = jsonMapper()
        val extensionItem =
            ExtensionItem.ofAiTasks(
                ExtensionItem.AiTasks.builder()
                    .addTask(
                        ExtensionItem.AiTasks.Task.SelectTags.builder()
                            .instruction("What types of clothing items are visible in this image?")
                            .maxSelections(1L)
                            .minSelections(0L)
                            .vocabulary(listOf("shirt", "tshirt", "dress", "trousers", "jacket"))
                            .build()
                    )
                    .build()
            )

        val roundtrippedExtensionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extensionItem),
                jacksonTypeRef<ExtensionItem>(),
            )

        assertThat(roundtrippedExtensionItem).isEqualTo(extensionItem)
    }

    @Test
    fun ofSavedExtension() {
        val savedExtension = ExtensionItem.SavedExtension.builder().id("ext_abc123").build()

        val extensionItem = ExtensionItem.ofSavedExtension(savedExtension)

        assertThat(extensionItem.removeBg()).isEmpty
        assertThat(extensionItem.autoTaggingExtension()).isEmpty
        assertThat(extensionItem.aiAutoDescription()).isEmpty
        assertThat(extensionItem.aiTasks()).isEmpty
        assertThat(extensionItem.savedExtension()).contains(savedExtension)
    }

    @Test
    fun ofSavedExtensionRoundtrip() {
        val jsonMapper = jsonMapper()
        val extensionItem =
            ExtensionItem.ofSavedExtension(
                ExtensionItem.SavedExtension.builder().id("ext_abc123").build()
            )

        val roundtrippedExtensionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extensionItem),
                jacksonTypeRef<ExtensionItem>(),
            )

        assertThat(roundtrippedExtensionItem).isEqualTo(extensionItem)
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
        val extensionItem =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ExtensionItem>())

        val e = assertThrows<ImageKitInvalidDataException> { extensionItem.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
