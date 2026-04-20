// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.JsonValue
import io.imagekit.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FolderTest {

    @Test
    fun create() {
        val folder =
            Folder.builder()
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customMetadata(
                    Folder.CustomMetadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .folderId("folderId")
                .folderPath("folderPath")
                .name("name")
                .type(Folder.Type.FOLDER)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(folder.createdAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(folder.customMetadata())
            .contains(
                Folder.CustomMetadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(folder.folderId()).contains("folderId")
        assertThat(folder.folderPath()).contains("folderPath")
        assertThat(folder.name()).contains("name")
        assertThat(folder.type()).contains(Folder.Type.FOLDER)
        assertThat(folder.updatedAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val folder =
            Folder.builder()
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customMetadata(
                    Folder.CustomMetadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .folderId("folderId")
                .folderPath("folderPath")
                .name("name")
                .type(Folder.Type.FOLDER)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedFolder =
            jsonMapper.readValue(jsonMapper.writeValueAsString(folder), jacksonTypeRef<Folder>())

        assertThat(roundtrippedFolder).isEqualTo(folder)
    }
}
