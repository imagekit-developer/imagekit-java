// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.JsonValue
import io.imagekit.core.jsonMapper
import io.imagekit.models.files.Folder
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FolderUpdateEventTest {

    @Test
    fun create() {
        val folderUpdateEvent =
            FolderUpdateEvent.builder()
                .id("id")
                .type("folder.updated")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
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
                )
                .build()

        assertThat(folderUpdateEvent.id()).isEqualTo("id")
        assertThat(folderUpdateEvent.type()).isEqualTo("folder.updated")
        assertThat(folderUpdateEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(folderUpdateEvent.data())
            .isEqualTo(
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
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val folderUpdateEvent =
            FolderUpdateEvent.builder()
                .id("id")
                .type("folder.updated")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
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
                )
                .build()

        val roundtrippedFolderUpdateEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(folderUpdateEvent),
                jacksonTypeRef<FolderUpdateEvent>(),
            )

        assertThat(roundtrippedFolderUpdateEvent).isEqualTo(folderUpdateEvent)
    }
}
