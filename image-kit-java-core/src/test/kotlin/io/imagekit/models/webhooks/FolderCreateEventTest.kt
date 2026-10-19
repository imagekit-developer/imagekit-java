// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.imagekit.core.JsonValue
import io.imagekit.core.jsonMapper
import io.imagekit.models.CustomMetadata
import io.imagekit.models.files.Folder
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FolderCreateEventTest {

    @Test
    fun create() {
        val folderCreateEvent =
            FolderCreateEvent.builder()
                .id("id")
                .type("folder.created")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    Folder.builder()
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .createdBy(Folder.CreatedBy.builder().email("email").name("name").build())
                        .customMetadata(
                            CustomMetadata.builder()
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

        assertThat(folderCreateEvent.id()).isEqualTo("id")
        assertThat(folderCreateEvent.type()).isEqualTo("folder.created")
        assertThat(folderCreateEvent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(folderCreateEvent.data())
            .isEqualTo(
                Folder.builder()
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .createdBy(Folder.CreatedBy.builder().email("email").name("name").build())
                    .customMetadata(
                        CustomMetadata.builder()
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
        val folderCreateEvent =
            FolderCreateEvent.builder()
                .id("id")
                .type("folder.created")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    Folder.builder()
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .createdBy(Folder.CreatedBy.builder().email("email").name("name").build())
                        .customMetadata(
                            CustomMetadata.builder()
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

        val roundtrippedFolderCreateEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(folderCreateEvent),
                jacksonTypeRef<FolderCreateEvent>(),
            )

        assertThat(roundtrippedFolderCreateEvent).isEqualTo(folderCreateEvent)
    }
}
