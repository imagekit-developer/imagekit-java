// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.imagekit.api.core.JsonValue
import com.imagekit.api.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileUploadV2ResponseTest {

    @Test
    fun create() {
        val fileUploadV2Response =
            FileUploadV2Response.builder()
                .addAiTag(
                    FileUploadV2Response.AiTag.builder()
                        .confidence(0.0)
                        .name("name")
                        .source("source")
                        .build()
                )
                .audioCodec("audioCodec")
                .bitRate(0L)
                .customCoordinates("customCoordinates")
                .customMetadata(JsonValue.from(mapOf<String, Any>()))
                .duration(0L)
                .embeddedMetadata(
                    FileUploadV2Response.EmbeddedMetadata.builder()
                        .aboutCvTermCvId("http://example.com/cv/about/ref2019.1")
                        .aboutCvTermId("http://example.com/cv/about/ref2019.1/code987")
                        .aboutCvTermName("CV-Term Name 1 (ref2019.1)")
                        .aboutCvTermRefinedAbout(
                            "http://example.com/cv/refinements2/ref2019.1/codeX145"
                        )
                        .additionalModelInformation("Additional Model Info (ref2019.1)")
                        .applicationRecordVersion(4L)
                        .artist("Creator1 (ref2019.1)")
                        .artworkCircaDateCreated("AO Circa Date: between 1550 and 1600 (ref2019.1)")
                        .artworkContentDescription("AO Content Description 1 (ref2019.1)")
                        .artworkContributionDescription("AO Contribution Description 1 (ref2019.1)")
                        .artworkCopyrightNotice("AO Copyright Notice 1 (ref2019.1)")
                        .artworkCopyrightOwnerId("AO Current Copyright Owner ID 1 (ref2019.1)")
                        .artworkCopyrightOwnerName("AO Current Copyright Owner Name 1 (ref2019.1)")
                        .addArtworkCreator("AO Creator Name 1a (ref2019.1)")
                        .addArtworkCreator("AO Creator Name 1b (ref2019.1)")
                        .addArtworkCreatorId("AO Creator Id 1a (ref2019.1)")
                        .addArtworkCreatorId("AO Creator Id 1b (ref2019.1)")
                        .artworkDateCreated(OffsetDateTime.parse("1919-10-16T19:01:00.000Z"))
                        .artworkLicensorId("AO Current Licensor ID 1 (ref2019.1)")
                        .artworkLicensorName("AO Current Licensor Name 1 (ref2019.1)")
                        .artworkPhysicalDescription("AO Physical Description 1 (ref2019.1)")
                        .artworkSource("AO Source 1 (ref2019.1)")
                        .artworkSourceInventoryNo("AO Source Inventory No 1 (ref2019.1)")
                        .artworkSourceInvUrl("AO Source Inventory URL (ref2019.1)")
                        .addArtworkStylePeriod("AO Style Baroque (ref2019.1)")
                        .addArtworkStylePeriod("AO Style Italian Baroque (ref2019.1)")
                        .artworkTitle("AO Title 1 (ref2019.1)")
                        .authorsPosition("Creator's Job Title  (ref2019.1)")
                        .byline("Creator1 (ref2019.1)")
                        .bylineTitle("Creator's Job Title  (ref2019.1)")
                        .caption("The description aka caption (ref2019.1)")
                        .captionAbstract("The description aka caption (ref2019.1)")
                        .captionWriter("Description Writer (ref2019.1)")
                        .city("City (Core) (ref2019.1)")
                        .colorSpace("Uncalibrated")
                        .componentsConfiguration("Y,Cb,Cr,-")
                        .copyright("Copyright (Notice) 2019.1 IPTC - www.iptc.org  (ref2019.1)")
                        .copyrightNotice(
                            "Copyright (Notice) 2019.1 IPTC - www.iptc.org  (ref2019.1)"
                        )
                        .addCopyrightOwnerId("Copyright Owner Id 1 (ref2019.1)")
                        .addCopyrightOwnerId("Copyright Owner Id 2 (ref2019.1)")
                        .addCopyrightOwnerName("Copyright Owner Name 1 (ref2019.1)")
                        .addCopyrightOwnerName("Copyright Owner Name 2 (ref2019.1)")
                        .country("Country (Core) (ref2019.1)")
                        .countryCode("R19")
                        .countryPrimaryLocationCode("R19")
                        .countryPrimaryLocationName("Country (Core) (ref2019.1)")
                        .creator("Creator1 (ref2019.1)")
                        .creatorAddress("Creator's CI: Address, line 1 (ref2019.1)")
                        .creatorCity("Creator's CI: City (ref2019.1)")
                        .creatorCountry("Creator's CI: Country (ref2019.1)")
                        .creatorPostalCode("Creator's CI: Postcode (ref2019.1)")
                        .creatorRegion("Creator's CI: State/Province (ref2019.1)")
                        .creatorWorkEmail("Creator's CI: Email@1, Email@2 (ref2019.1)")
                        .creatorWorkTelephone("Creator's CI: Phone # 1, Phone # 2 (ref2019.1)")
                        .creatorWorkUrl("http://www.Creators.CI/WebAddress/ref2019.1")
                        .credit("Credit Line (ref2019.1)")
                        .dateCreated(OffsetDateTime.parse("2019-10-16T00:00:00.000Z"))
                        .dateTimeCreated(OffsetDateTime.parse("2019-10-16T00:00:00.000Z"))
                        .dateTimeOriginal(OffsetDateTime.parse("2019-10-16T19:01:03.000Z"))
                        .description("The description aka caption (ref2019.1)")
                        .digitalImageGuid("http://example.com/imageGUIDs/TestGUID12345/ref2019.1")
                        .digitalSourceType(
                            "http://cv.iptc.org/newscodes/digitalsourcetype/softwareImage"
                        )
                        .embeddedEncodedRightsExpr("The Encoded Rights Expression (ref2019.1)")
                        .embeddedEncodedRightsExprLangId(
                            "http://example.org/RELids/id4711/ref2019.1"
                        )
                        .embeddedEncodedRightsExprType("IANA Media Type of ERE (ref2019.1)")
                        .event("An Event (ref2019.1)")
                        .exifVersion("0232")
                        .flashpixVersion("0100")
                        .genreCvId("http://example.com/cv/genre/ref2019.1")
                        .genreCvTermId("http://example.com/cv/genre/ref2019.1/code1369")
                        .genreCvTermName("Genre CV-Term Name 1 (ref2019.1)")
                        .genreCvTermRefinedAbout(
                            "http://example.com/cv/genrerefinements2/ref2019.1/codeY864"
                        )
                        .headline("The Headline (ref2019.1)")
                        .imageCreatorId("Image Creator Id 1 (ref2019.1)")
                        .imageCreatorImageId("Image Creator Image ID (ref2019.1)")
                        .imageCreatorName("Image Creator Name 1 (ref2019.1)")
                        .imageDescription("The description aka caption (ref2019.1)")
                        .addImageRegionBoundaryH(0.385)
                        .addImageRegionBoundaryRx(0.068)
                        .imageRegionBoundaryShape(listOf("rectangle", "circle", "polygon"))
                        .imageRegionBoundaryUnit(listOf("relative", "relative", "relative"))
                        .imageRegionBoundaryVerticesX(listOf(0.05, 0.148, 0.375))
                        .imageRegionBoundaryVerticesY(listOf(0.713, 0.041, 0.863))
                        .addImageRegionBoundaryW(0.127)
                        .addImageRegionBoundaryX(0.31)
                        .addImageRegionBoundaryX(0.59)
                        .addImageRegionBoundaryY(0.18)
                        .addImageRegionBoundaryY(0.426)
                        .imageRegionCtypeIdentifier(
                            listOf(
                                "https://example.org/rctype/type2019.1a",
                                "https://example.org/rctype/type2019.1b",
                                "https://example.org/rctype/type2019.1a",
                                "https://example.org/rctype/type2019.1b",
                                "https://example.org/rctype/type2019.1a",
                                "https://example.org/rctype/type2019.1b",
                            )
                        )
                        .imageRegionCtypeName(
                            listOf(
                                "Region Boundary Content Type Name (ref2019.1)",
                                "Region Boundary Content Type Name (ref2019.1)",
                                "Region Boundary Content Type Name (ref2019.1)",
                            )
                        )
                        .imageRegionId(listOf("persltr2", "persltr3", "persltr1"))
                        .imageRegionName(listOf("Listener 1", "Listener 2", "Speaker 1"))
                        .imageRegionOrganisationInImageName(
                            listOf(
                                "Organisation name no 1 in region persltr2 (ref2019.1)",
                                "Organisation name no 1 in region persltr2 (ref2019.1)",
                                "Organisation name no 1 in region persltr3 (ref2019.1)",
                            )
                        )
                        .imageRegionPersonInImage(
                            listOf(
                                "Person name no 1 in region persltr2 (ref2019.1)",
                                "Person name no 1 in region persltr3 (ref2019.1)",
                                "Person name no 1 in region persltr1 (ref2019.1)",
                            )
                        )
                        .imageRegionRoleIdentifier(
                            listOf(
                                "https://example.org/rrole/role2019.1a",
                                "https://example.org/rrole/role2019.1b",
                                "https://example.org/rrole/role2019.1a",
                                "https://example.org/rrole/role2019.1b",
                                "https://example.org/rrole/role2019.1a",
                                "https://example.org/rrole/role2019.1b",
                            )
                        )
                        .imageRegionRoleName(
                            listOf(
                                "Region Boundary Content Role Name (ref2019.1)",
                                "Region Boundary Content Role Name (ref2019.1)",
                                "Region Boundary Content Role Name (ref2019.1)",
                            )
                        )
                        .imageSupplierId("Image Supplier Id (ref2019.1)")
                        .imageSupplierImageId("Image Supplier Image ID (ref2019.1)")
                        .imageSupplierName("Image Supplier Name (ref2019.1)")
                        .instructions("An Instruction (ref2019.1)")
                        .intellectualGenre("A Genre (ref2019.1)")
                        .keywords(
                            listOf("Keyword1ref2019.1", "Keyword2ref2019.1", "Keyword3ref2019.1")
                        )
                        .addLicensorCity("Licensor City 1 (ref2019.1)")
                        .addLicensorCity("Licensor City 2 (ref2019.1)")
                        .addLicensorCountry("Licensor Country 1 (ref2019.1)")
                        .addLicensorCountry("Licensor Country 2 (ref2019.1)")
                        .addLicensorEmail("Licensor Email 1 (ref2019.1)")
                        .addLicensorEmail("Licensor Email 2 (ref2019.1)")
                        .addLicensorExtendedAddress("Licensor Ext Addr 1 (ref2019.1)")
                        .addLicensorExtendedAddress("Licensor Ext Addr 2 (ref2019.1)")
                        .addLicensorId("Licensor ID 1 (ref2019.1)")
                        .addLicensorId("Licensor ID 2 (ref2019.1)")
                        .addLicensorName("Licensor Name 1 (ref2019.1)")
                        .addLicensorName("Licensor Name 2 (ref2019.1)")
                        .addLicensorPostalCode("Licensor Postcode 1 (ref2019.1)")
                        .addLicensorPostalCode("Licensor Postcode 2 (ref2019.1)")
                        .addLicensorRegion("Licensor Region 1 (ref2019.1)")
                        .addLicensorRegion("Licensor Region 2 (ref2019.1)")
                        .addLicensorStreetAddress("Licensor Street Addr 1 (ref2019.1)")
                        .addLicensorStreetAddress("Licensor Street Addr 2 (ref2019.1)")
                        .addLicensorTelephone1("Licensor Phone1 1 (ref2019.1)")
                        .addLicensorTelephone1("Licensor Phone1 2 (ref2019.1)")
                        .addLicensorTelephone2("Licensor Phone2 1 (ref2019.1)")
                        .addLicensorTelephone2("Licensor Phone2 2 (ref2019.1)")
                        .addLicensorUrl("Licensor URL 1 (ref2019.1)")
                        .addLicensorUrl("Licensor URL 2 (ref2019.1)")
                        .linkedEncodedRightsExpr(
                            "http://example.org/linkedrightsexpression/id986/ref2019.1"
                        )
                        .linkedEncodedRightsExprLangId("http://example.org/RELids/id4712/ref2019.1")
                        .linkedEncodedRightsExprType("IANA Media Type of ERE (ref2019.1)")
                        .location("Sublocation (Core) (ref2019.1)")
                        .locationCreatedCity("City (Location created1) (ref2019.1)")
                        .locationCreatedCountryCode("R17")
                        .locationCreatedCountryName("CountryName (Location created1) (ref2019.1)")
                        .locationCreatedGpsAltitude("480 m")
                        .locationCreatedGpsLatitude("48,16.5N")
                        .locationCreatedGpsLongitude("16,20.28E")
                        .locationCreatedLocationId("Location Id (Location created1) (ref2019.1)")
                        .locationCreatedLocationName(
                            "Location Name (Location created1) (ref2019.1)"
                        )
                        .locationCreatedProvinceState(
                            "Province/State (Location created1) (ref2019.1)"
                        )
                        .locationCreatedSublocation("Sublocation (Location created1) (ref2019.1)")
                        .locationCreatedWorldRegion("Worldregion (Location created1) (ref2019.1)")
                        .addLocationShownCity("City (Location shown1) (ref2019.1)")
                        .addLocationShownCity("City (Location shown2) (ref2019.1)")
                        .addLocationShownCountryCode("R17")
                        .addLocationShownCountryCode("R17")
                        .addLocationShownCountryName("CountryName (Location shown1) (ref2019.1)")
                        .addLocationShownCountryName("CountryName (Location shown2) (ref2019.1)")
                        .addLocationShownGpsAltitude("140 m")
                        .addLocationShownGpsAltitude("120 m")
                        .addLocationShownGpsLatitude("48,8.82N")
                        .addLocationShownGpsLatitude("47,57.12N")
                        .addLocationShownGpsLongitude("17,5.88E")
                        .addLocationShownGpsLongitude("16,49.8E")
                        .locationShownLocationId(
                            listOf(
                                "Location Id 1a(Location shown1) (ref2019.1)",
                                "Location Id 1b(Location shown1) (ref2019.1)",
                                "Location Id 2a(Location shown2) (ref2019.1)",
                                "Location Id 2b(Location shown2) (ref2019.1)",
                            )
                        )
                        .addLocationShownLocationName("Location Name (Location shown1) (ref2019.1)")
                        .addLocationShownLocationName("Location Name (Location shown2) (ref2019.1)")
                        .addLocationShownProvinceState(
                            "Province/State (Location shown1) (ref2019.1)"
                        )
                        .addLocationShownProvinceState(
                            "Province/State (Location shown2) (ref2019.1)"
                        )
                        .addLocationShownSublocation("Sublocation (Location shown1) (ref2019.1)")
                        .addLocationShownSublocation("Sublocation (Location shown2) (ref2019.1)")
                        .addLocationShownWorldRegion("Worldregion (Location shown1) (ref2019.1)")
                        .addLocationShownWorldRegion("Worldregion (Location shown2) (ref2019.1)")
                        .maxAvailHeight(20.0)
                        .maxAvailWidth(19.0)
                        .modelAge(listOf(25.0, 27.0, 30.0))
                        .addModelReleaseId("Model Release ID 1 (ref2019.1)")
                        .addModelReleaseId("Model Release ID 2 (ref2019.1)")
                        .objectAttributeReference("A Genre (ref2019.1)")
                        .objectName("The Title (ref2019.1)")
                        .offsetTimeOriginal("+00:00")
                        .organisationInImageCode(
                            listOf(
                                "Organisation Code 1 (ref2019.1)",
                                "Organisation Code 2 (ref2019.1)",
                                "Organisation Code 3 (ref2019.1)",
                            )
                        )
                        .organisationInImageName(
                            listOf(
                                "Organisation Name 1 (ref2019.1)",
                                "Organisation Name 2 (ref2019.1)",
                                "Organisation Name 3 (ref2019.1)",
                            )
                        )
                        .orientation("Horizontal (normal)")
                        .originalTransmissionReference("Job Id (ref2019.1)")
                        .addPersonInImage("Person Shown 1 (ref2019.1)")
                        .addPersonInImage("Person Shown 2 (ref2019.1)")
                        .addPersonInImageCvTermCvId("http://example.com/cv/test99/ref2019.1")
                        .addPersonInImageCvTermId("http://example.com/cv/test99/code987/ref2019.1")
                        .addPersonInImageCvTermName("Person Characteristic Name 1 (ref2019.1)")
                        .addPersonInImageCvTermRefinedAbout(
                            "http://example.com/cv/refinements987/codeY765/ref2019.1"
                        )
                        .addPersonInImageDescription("Person Description 1 (ref2019.1)")
                        .addPersonInImageId("http://wikidata.org/item/Q123456789/ref2019.1")
                        .addPersonInImageId("http://freebase.com/m/987654321/ref2019.1")
                        .addPersonInImageName("Person Name 1 (ref2019.1)")
                        .addProductInImageDescription("Product Description 1 (ref2019.1)")
                        .addProductInImageGtin(123456782019.1)
                        .addProductInImageName("Product Name 1 (ref2019.1)")
                        .addPropertyReleaseId("Property Release ID 1 (ref2019.1)")
                        .addPropertyReleaseId("Property Release ID 2 (ref2019.1)")
                        .provinceState("Province/State(Core)(ref2019.1)")
                        .rating(1L)
                        .addRegistryEntryRole("Registry Entry Role ID 1 (ref2019.1)")
                        .addRegistryEntryRole("Registry Entry Role ID 2 (ref2019.1)")
                        .addRegistryItemId("Registry Image ID 1 (ref2019.1)")
                        .addRegistryItemId("Registry Image ID 2 (ref2019.1)")
                        .addRegistryOrganisationId("Registry Organisation ID 1 (ref2019.1)")
                        .addRegistryOrganisationId("Registry Organisation ID 2 (ref2019.1)")
                        .resolutionUnit("inches")
                        .rights("Copyright (Notice) 2019.1 IPTC - www.iptc.org  (ref2019.1)")
                        .addScene("IPTC-Scene-Code1 (ref2019.1)")
                        .addScene("IPTC-Scene-Code2 (ref2019.1)")
                        .source("Source (ref2019.1)")
                        .specialInstructions("An Instruction (ref2019.1)")
                        .state("Province/State(Core)(ref2019.1)")
                        .subject(
                            listOf("Keyword1ref2019.1", "Keyword2ref2019.1", "Keyword3ref2019.1")
                        )
                        .subjectCode(
                            listOf("IPTC:1ref2019.1", "IPTC:2ref2019.1", "IPTC:3ref2019.1")
                        )
                        .subjectReference(
                            listOf("IPTC:1ref2019.1", "IPTC:2ref2019.1", "IPTC:3ref2019.1")
                        )
                        .sublocation("Sublocation (Core) (ref2019.1)")
                        .timeCreated("19:01:03+00:00")
                        .title("The Title (ref2019.1)")
                        .transmissionReference("Job Id (ref2019.1)")
                        .usageTerms("Rights Usage Terms (ref2019.1)")
                        .webStatement("http://www.WebStatementOfRights.org/2019.1")
                        .writer("Description Writer (ref2019.1)")
                        .writerEditor("Description Writer (ref2019.1)")
                        .xResolution(72.0)
                        .yResolution(72.0)
                        .build()
                )
                .extensionStatus(
                    FileUploadV2Response.ExtensionStatus.builder()
                        .awsAutoTagging(FileUploadV2Response.ExtensionStatus.AwsAutoTagging.SUCCESS)
                        .googleAutoTagging(
                            FileUploadV2Response.ExtensionStatus.GoogleAutoTagging.SUCCESS
                        )
                        .removeBg(FileUploadV2Response.ExtensionStatus.RemoveBg.SUCCESS)
                        .build()
                )
                .fileId("fileId")
                .filePath("filePath")
                .fileType("fileType")
                .height(0.0)
                .isPrivateFile(true)
                .isPublished(true)
                .metadata(
                    FileUploadV2Response.Metadata.builder()
                        .audioCodec("audioCodec")
                        .bitRate(0L)
                        .density(0L)
                        .duration(0L)
                        .exif(
                            FileUploadV2Response.Metadata.Exif.builder()
                                .exif(
                                    ExifDetails.builder()
                                        .apertureValue(0.0)
                                        .colorSpace(0L)
                                        .createDate("CreateDate")
                                        .customRendered(0L)
                                        .dateTimeOriginal("DateTimeOriginal")
                                        .exifImageHeight(0L)
                                        .exifImageWidth(0L)
                                        .exifVersion("ExifVersion")
                                        .exposureCompensation(0.0)
                                        .exposureMode(0L)
                                        .exposureProgram(0L)
                                        .exposureTime(0.0)
                                        .flash(0L)
                                        .flashpixVersion("FlashpixVersion")
                                        .fNumber(0.0)
                                        .focalLength(0L)
                                        .focalPlaneResolutionUnit(0L)
                                        .focalPlaneXResolution(0.0)
                                        .focalPlaneYResolution(0.0)
                                        .interopOffset(0L)
                                        .iso(0L)
                                        .meteringMode(0L)
                                        .sceneCaptureType(0L)
                                        .shutterSpeedValue(0.0)
                                        .subSecTime("SubSecTime")
                                        .whiteBalance(0L)
                                        .build()
                                )
                                .gps(Gps.builder().addGpsVersionId(0L).build())
                                .image(
                                    ExifImage.builder()
                                        .exifOffset(0L)
                                        .gpsInfo(0L)
                                        .make("Make")
                                        .model("Model")
                                        .modifyDate("ModifyDate")
                                        .orientation(0L)
                                        .resolutionUnit(0L)
                                        .software("Software")
                                        .xResolution(0L)
                                        .yCbCrPositioning(0L)
                                        .yResolution(0L)
                                        .build()
                                )
                                .interoperability(
                                    Interoperability.builder()
                                        .interopIndex("InteropIndex")
                                        .interopVersion("InteropVersion")
                                        .build()
                                )
                                .makernote(
                                    FileUploadV2Response.Metadata.Exif.Makernote.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .thumbnail(
                                    Thumbnail.builder()
                                        .compression(0L)
                                        .resolutionUnit(0L)
                                        .thumbnailLength(0L)
                                        .thumbnailOffset(0L)
                                        .xResolution(0L)
                                        .yResolution(0L)
                                        .build()
                                )
                                .build()
                        )
                        .format("format")
                        .hasColorProfile(true)
                        .hasTransparency(true)
                        .height(0L)
                        .pHash("pHash")
                        .quality(0L)
                        .size(0L)
                        .videoCodec("videoCodec")
                        .width(0L)
                        .build()
                )
                .name("name")
                .size(0.0)
                .addTag("string")
                .thumbnailUrl("thumbnailUrl")
                .url("url")
                .versionInfo(
                    FileUploadV2Response.VersionInfo.builder().id("id").name("name").build()
                )
                .videoCodec("videoCodec")
                .width(0.0)
                .build()

        assertThat(fileUploadV2Response.aiTags().getOrNull())
            .containsExactly(
                FileUploadV2Response.AiTag.builder()
                    .confidence(0.0)
                    .name("name")
                    .source("source")
                    .build()
            )
        assertThat(fileUploadV2Response.audioCodec()).contains("audioCodec")
        assertThat(fileUploadV2Response.bitRate()).contains(0L)
        assertThat(fileUploadV2Response.customCoordinates()).contains("customCoordinates")
        assertThat(fileUploadV2Response._customMetadata())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(fileUploadV2Response.duration()).contains(0L)
        assertThat(fileUploadV2Response.embeddedMetadata())
            .contains(
                FileUploadV2Response.EmbeddedMetadata.builder()
                    .aboutCvTermCvId("http://example.com/cv/about/ref2019.1")
                    .aboutCvTermId("http://example.com/cv/about/ref2019.1/code987")
                    .aboutCvTermName("CV-Term Name 1 (ref2019.1)")
                    .aboutCvTermRefinedAbout(
                        "http://example.com/cv/refinements2/ref2019.1/codeX145"
                    )
                    .additionalModelInformation("Additional Model Info (ref2019.1)")
                    .applicationRecordVersion(4L)
                    .artist("Creator1 (ref2019.1)")
                    .artworkCircaDateCreated("AO Circa Date: between 1550 and 1600 (ref2019.1)")
                    .artworkContentDescription("AO Content Description 1 (ref2019.1)")
                    .artworkContributionDescription("AO Contribution Description 1 (ref2019.1)")
                    .artworkCopyrightNotice("AO Copyright Notice 1 (ref2019.1)")
                    .artworkCopyrightOwnerId("AO Current Copyright Owner ID 1 (ref2019.1)")
                    .artworkCopyrightOwnerName("AO Current Copyright Owner Name 1 (ref2019.1)")
                    .addArtworkCreator("AO Creator Name 1a (ref2019.1)")
                    .addArtworkCreator("AO Creator Name 1b (ref2019.1)")
                    .addArtworkCreatorId("AO Creator Id 1a (ref2019.1)")
                    .addArtworkCreatorId("AO Creator Id 1b (ref2019.1)")
                    .artworkDateCreated(OffsetDateTime.parse("1919-10-16T19:01:00.000Z"))
                    .artworkLicensorId("AO Current Licensor ID 1 (ref2019.1)")
                    .artworkLicensorName("AO Current Licensor Name 1 (ref2019.1)")
                    .artworkPhysicalDescription("AO Physical Description 1 (ref2019.1)")
                    .artworkSource("AO Source 1 (ref2019.1)")
                    .artworkSourceInventoryNo("AO Source Inventory No 1 (ref2019.1)")
                    .artworkSourceInvUrl("AO Source Inventory URL (ref2019.1)")
                    .addArtworkStylePeriod("AO Style Baroque (ref2019.1)")
                    .addArtworkStylePeriod("AO Style Italian Baroque (ref2019.1)")
                    .artworkTitle("AO Title 1 (ref2019.1)")
                    .authorsPosition("Creator's Job Title  (ref2019.1)")
                    .byline("Creator1 (ref2019.1)")
                    .bylineTitle("Creator's Job Title  (ref2019.1)")
                    .caption("The description aka caption (ref2019.1)")
                    .captionAbstract("The description aka caption (ref2019.1)")
                    .captionWriter("Description Writer (ref2019.1)")
                    .city("City (Core) (ref2019.1)")
                    .colorSpace("Uncalibrated")
                    .componentsConfiguration("Y,Cb,Cr,-")
                    .copyright("Copyright (Notice) 2019.1 IPTC - www.iptc.org  (ref2019.1)")
                    .copyrightNotice("Copyright (Notice) 2019.1 IPTC - www.iptc.org  (ref2019.1)")
                    .addCopyrightOwnerId("Copyright Owner Id 1 (ref2019.1)")
                    .addCopyrightOwnerId("Copyright Owner Id 2 (ref2019.1)")
                    .addCopyrightOwnerName("Copyright Owner Name 1 (ref2019.1)")
                    .addCopyrightOwnerName("Copyright Owner Name 2 (ref2019.1)")
                    .country("Country (Core) (ref2019.1)")
                    .countryCode("R19")
                    .countryPrimaryLocationCode("R19")
                    .countryPrimaryLocationName("Country (Core) (ref2019.1)")
                    .creator("Creator1 (ref2019.1)")
                    .creatorAddress("Creator's CI: Address, line 1 (ref2019.1)")
                    .creatorCity("Creator's CI: City (ref2019.1)")
                    .creatorCountry("Creator's CI: Country (ref2019.1)")
                    .creatorPostalCode("Creator's CI: Postcode (ref2019.1)")
                    .creatorRegion("Creator's CI: State/Province (ref2019.1)")
                    .creatorWorkEmail("Creator's CI: Email@1, Email@2 (ref2019.1)")
                    .creatorWorkTelephone("Creator's CI: Phone # 1, Phone # 2 (ref2019.1)")
                    .creatorWorkUrl("http://www.Creators.CI/WebAddress/ref2019.1")
                    .credit("Credit Line (ref2019.1)")
                    .dateCreated(OffsetDateTime.parse("2019-10-16T00:00:00.000Z"))
                    .dateTimeCreated(OffsetDateTime.parse("2019-10-16T00:00:00.000Z"))
                    .dateTimeOriginal(OffsetDateTime.parse("2019-10-16T19:01:03.000Z"))
                    .description("The description aka caption (ref2019.1)")
                    .digitalImageGuid("http://example.com/imageGUIDs/TestGUID12345/ref2019.1")
                    .digitalSourceType(
                        "http://cv.iptc.org/newscodes/digitalsourcetype/softwareImage"
                    )
                    .embeddedEncodedRightsExpr("The Encoded Rights Expression (ref2019.1)")
                    .embeddedEncodedRightsExprLangId("http://example.org/RELids/id4711/ref2019.1")
                    .embeddedEncodedRightsExprType("IANA Media Type of ERE (ref2019.1)")
                    .event("An Event (ref2019.1)")
                    .exifVersion("0232")
                    .flashpixVersion("0100")
                    .genreCvId("http://example.com/cv/genre/ref2019.1")
                    .genreCvTermId("http://example.com/cv/genre/ref2019.1/code1369")
                    .genreCvTermName("Genre CV-Term Name 1 (ref2019.1)")
                    .genreCvTermRefinedAbout(
                        "http://example.com/cv/genrerefinements2/ref2019.1/codeY864"
                    )
                    .headline("The Headline (ref2019.1)")
                    .imageCreatorId("Image Creator Id 1 (ref2019.1)")
                    .imageCreatorImageId("Image Creator Image ID (ref2019.1)")
                    .imageCreatorName("Image Creator Name 1 (ref2019.1)")
                    .imageDescription("The description aka caption (ref2019.1)")
                    .addImageRegionBoundaryH(0.385)
                    .addImageRegionBoundaryRx(0.068)
                    .imageRegionBoundaryShape(listOf("rectangle", "circle", "polygon"))
                    .imageRegionBoundaryUnit(listOf("relative", "relative", "relative"))
                    .imageRegionBoundaryVerticesX(listOf(0.05, 0.148, 0.375))
                    .imageRegionBoundaryVerticesY(listOf(0.713, 0.041, 0.863))
                    .addImageRegionBoundaryW(0.127)
                    .addImageRegionBoundaryX(0.31)
                    .addImageRegionBoundaryX(0.59)
                    .addImageRegionBoundaryY(0.18)
                    .addImageRegionBoundaryY(0.426)
                    .imageRegionCtypeIdentifier(
                        listOf(
                            "https://example.org/rctype/type2019.1a",
                            "https://example.org/rctype/type2019.1b",
                            "https://example.org/rctype/type2019.1a",
                            "https://example.org/rctype/type2019.1b",
                            "https://example.org/rctype/type2019.1a",
                            "https://example.org/rctype/type2019.1b",
                        )
                    )
                    .imageRegionCtypeName(
                        listOf(
                            "Region Boundary Content Type Name (ref2019.1)",
                            "Region Boundary Content Type Name (ref2019.1)",
                            "Region Boundary Content Type Name (ref2019.1)",
                        )
                    )
                    .imageRegionId(listOf("persltr2", "persltr3", "persltr1"))
                    .imageRegionName(listOf("Listener 1", "Listener 2", "Speaker 1"))
                    .imageRegionOrganisationInImageName(
                        listOf(
                            "Organisation name no 1 in region persltr2 (ref2019.1)",
                            "Organisation name no 1 in region persltr2 (ref2019.1)",
                            "Organisation name no 1 in region persltr3 (ref2019.1)",
                        )
                    )
                    .imageRegionPersonInImage(
                        listOf(
                            "Person name no 1 in region persltr2 (ref2019.1)",
                            "Person name no 1 in region persltr3 (ref2019.1)",
                            "Person name no 1 in region persltr1 (ref2019.1)",
                        )
                    )
                    .imageRegionRoleIdentifier(
                        listOf(
                            "https://example.org/rrole/role2019.1a",
                            "https://example.org/rrole/role2019.1b",
                            "https://example.org/rrole/role2019.1a",
                            "https://example.org/rrole/role2019.1b",
                            "https://example.org/rrole/role2019.1a",
                            "https://example.org/rrole/role2019.1b",
                        )
                    )
                    .imageRegionRoleName(
                        listOf(
                            "Region Boundary Content Role Name (ref2019.1)",
                            "Region Boundary Content Role Name (ref2019.1)",
                            "Region Boundary Content Role Name (ref2019.1)",
                        )
                    )
                    .imageSupplierId("Image Supplier Id (ref2019.1)")
                    .imageSupplierImageId("Image Supplier Image ID (ref2019.1)")
                    .imageSupplierName("Image Supplier Name (ref2019.1)")
                    .instructions("An Instruction (ref2019.1)")
                    .intellectualGenre("A Genre (ref2019.1)")
                    .keywords(listOf("Keyword1ref2019.1", "Keyword2ref2019.1", "Keyword3ref2019.1"))
                    .addLicensorCity("Licensor City 1 (ref2019.1)")
                    .addLicensorCity("Licensor City 2 (ref2019.1)")
                    .addLicensorCountry("Licensor Country 1 (ref2019.1)")
                    .addLicensorCountry("Licensor Country 2 (ref2019.1)")
                    .addLicensorEmail("Licensor Email 1 (ref2019.1)")
                    .addLicensorEmail("Licensor Email 2 (ref2019.1)")
                    .addLicensorExtendedAddress("Licensor Ext Addr 1 (ref2019.1)")
                    .addLicensorExtendedAddress("Licensor Ext Addr 2 (ref2019.1)")
                    .addLicensorId("Licensor ID 1 (ref2019.1)")
                    .addLicensorId("Licensor ID 2 (ref2019.1)")
                    .addLicensorName("Licensor Name 1 (ref2019.1)")
                    .addLicensorName("Licensor Name 2 (ref2019.1)")
                    .addLicensorPostalCode("Licensor Postcode 1 (ref2019.1)")
                    .addLicensorPostalCode("Licensor Postcode 2 (ref2019.1)")
                    .addLicensorRegion("Licensor Region 1 (ref2019.1)")
                    .addLicensorRegion("Licensor Region 2 (ref2019.1)")
                    .addLicensorStreetAddress("Licensor Street Addr 1 (ref2019.1)")
                    .addLicensorStreetAddress("Licensor Street Addr 2 (ref2019.1)")
                    .addLicensorTelephone1("Licensor Phone1 1 (ref2019.1)")
                    .addLicensorTelephone1("Licensor Phone1 2 (ref2019.1)")
                    .addLicensorTelephone2("Licensor Phone2 1 (ref2019.1)")
                    .addLicensorTelephone2("Licensor Phone2 2 (ref2019.1)")
                    .addLicensorUrl("Licensor URL 1 (ref2019.1)")
                    .addLicensorUrl("Licensor URL 2 (ref2019.1)")
                    .linkedEncodedRightsExpr(
                        "http://example.org/linkedrightsexpression/id986/ref2019.1"
                    )
                    .linkedEncodedRightsExprLangId("http://example.org/RELids/id4712/ref2019.1")
                    .linkedEncodedRightsExprType("IANA Media Type of ERE (ref2019.1)")
                    .location("Sublocation (Core) (ref2019.1)")
                    .locationCreatedCity("City (Location created1) (ref2019.1)")
                    .locationCreatedCountryCode("R17")
                    .locationCreatedCountryName("CountryName (Location created1) (ref2019.1)")
                    .locationCreatedGpsAltitude("480 m")
                    .locationCreatedGpsLatitude("48,16.5N")
                    .locationCreatedGpsLongitude("16,20.28E")
                    .locationCreatedLocationId("Location Id (Location created1) (ref2019.1)")
                    .locationCreatedLocationName("Location Name (Location created1) (ref2019.1)")
                    .locationCreatedProvinceState("Province/State (Location created1) (ref2019.1)")
                    .locationCreatedSublocation("Sublocation (Location created1) (ref2019.1)")
                    .locationCreatedWorldRegion("Worldregion (Location created1) (ref2019.1)")
                    .addLocationShownCity("City (Location shown1) (ref2019.1)")
                    .addLocationShownCity("City (Location shown2) (ref2019.1)")
                    .addLocationShownCountryCode("R17")
                    .addLocationShownCountryCode("R17")
                    .addLocationShownCountryName("CountryName (Location shown1) (ref2019.1)")
                    .addLocationShownCountryName("CountryName (Location shown2) (ref2019.1)")
                    .addLocationShownGpsAltitude("140 m")
                    .addLocationShownGpsAltitude("120 m")
                    .addLocationShownGpsLatitude("48,8.82N")
                    .addLocationShownGpsLatitude("47,57.12N")
                    .addLocationShownGpsLongitude("17,5.88E")
                    .addLocationShownGpsLongitude("16,49.8E")
                    .locationShownLocationId(
                        listOf(
                            "Location Id 1a(Location shown1) (ref2019.1)",
                            "Location Id 1b(Location shown1) (ref2019.1)",
                            "Location Id 2a(Location shown2) (ref2019.1)",
                            "Location Id 2b(Location shown2) (ref2019.1)",
                        )
                    )
                    .addLocationShownLocationName("Location Name (Location shown1) (ref2019.1)")
                    .addLocationShownLocationName("Location Name (Location shown2) (ref2019.1)")
                    .addLocationShownProvinceState("Province/State (Location shown1) (ref2019.1)")
                    .addLocationShownProvinceState("Province/State (Location shown2) (ref2019.1)")
                    .addLocationShownSublocation("Sublocation (Location shown1) (ref2019.1)")
                    .addLocationShownSublocation("Sublocation (Location shown2) (ref2019.1)")
                    .addLocationShownWorldRegion("Worldregion (Location shown1) (ref2019.1)")
                    .addLocationShownWorldRegion("Worldregion (Location shown2) (ref2019.1)")
                    .maxAvailHeight(20.0)
                    .maxAvailWidth(19.0)
                    .modelAge(listOf(25.0, 27.0, 30.0))
                    .addModelReleaseId("Model Release ID 1 (ref2019.1)")
                    .addModelReleaseId("Model Release ID 2 (ref2019.1)")
                    .objectAttributeReference("A Genre (ref2019.1)")
                    .objectName("The Title (ref2019.1)")
                    .offsetTimeOriginal("+00:00")
                    .organisationInImageCode(
                        listOf(
                            "Organisation Code 1 (ref2019.1)",
                            "Organisation Code 2 (ref2019.1)",
                            "Organisation Code 3 (ref2019.1)",
                        )
                    )
                    .organisationInImageName(
                        listOf(
                            "Organisation Name 1 (ref2019.1)",
                            "Organisation Name 2 (ref2019.1)",
                            "Organisation Name 3 (ref2019.1)",
                        )
                    )
                    .orientation("Horizontal (normal)")
                    .originalTransmissionReference("Job Id (ref2019.1)")
                    .addPersonInImage("Person Shown 1 (ref2019.1)")
                    .addPersonInImage("Person Shown 2 (ref2019.1)")
                    .addPersonInImageCvTermCvId("http://example.com/cv/test99/ref2019.1")
                    .addPersonInImageCvTermId("http://example.com/cv/test99/code987/ref2019.1")
                    .addPersonInImageCvTermName("Person Characteristic Name 1 (ref2019.1)")
                    .addPersonInImageCvTermRefinedAbout(
                        "http://example.com/cv/refinements987/codeY765/ref2019.1"
                    )
                    .addPersonInImageDescription("Person Description 1 (ref2019.1)")
                    .addPersonInImageId("http://wikidata.org/item/Q123456789/ref2019.1")
                    .addPersonInImageId("http://freebase.com/m/987654321/ref2019.1")
                    .addPersonInImageName("Person Name 1 (ref2019.1)")
                    .addProductInImageDescription("Product Description 1 (ref2019.1)")
                    .addProductInImageGtin(123456782019.1)
                    .addProductInImageName("Product Name 1 (ref2019.1)")
                    .addPropertyReleaseId("Property Release ID 1 (ref2019.1)")
                    .addPropertyReleaseId("Property Release ID 2 (ref2019.1)")
                    .provinceState("Province/State(Core)(ref2019.1)")
                    .rating(1L)
                    .addRegistryEntryRole("Registry Entry Role ID 1 (ref2019.1)")
                    .addRegistryEntryRole("Registry Entry Role ID 2 (ref2019.1)")
                    .addRegistryItemId("Registry Image ID 1 (ref2019.1)")
                    .addRegistryItemId("Registry Image ID 2 (ref2019.1)")
                    .addRegistryOrganisationId("Registry Organisation ID 1 (ref2019.1)")
                    .addRegistryOrganisationId("Registry Organisation ID 2 (ref2019.1)")
                    .resolutionUnit("inches")
                    .rights("Copyright (Notice) 2019.1 IPTC - www.iptc.org  (ref2019.1)")
                    .addScene("IPTC-Scene-Code1 (ref2019.1)")
                    .addScene("IPTC-Scene-Code2 (ref2019.1)")
                    .source("Source (ref2019.1)")
                    .specialInstructions("An Instruction (ref2019.1)")
                    .state("Province/State(Core)(ref2019.1)")
                    .subject(listOf("Keyword1ref2019.1", "Keyword2ref2019.1", "Keyword3ref2019.1"))
                    .subjectCode(listOf("IPTC:1ref2019.1", "IPTC:2ref2019.1", "IPTC:3ref2019.1"))
                    .subjectReference(
                        listOf("IPTC:1ref2019.1", "IPTC:2ref2019.1", "IPTC:3ref2019.1")
                    )
                    .sublocation("Sublocation (Core) (ref2019.1)")
                    .timeCreated("19:01:03+00:00")
                    .title("The Title (ref2019.1)")
                    .transmissionReference("Job Id (ref2019.1)")
                    .usageTerms("Rights Usage Terms (ref2019.1)")
                    .webStatement("http://www.WebStatementOfRights.org/2019.1")
                    .writer("Description Writer (ref2019.1)")
                    .writerEditor("Description Writer (ref2019.1)")
                    .xResolution(72.0)
                    .yResolution(72.0)
                    .build()
            )
        assertThat(fileUploadV2Response.extensionStatus())
            .contains(
                FileUploadV2Response.ExtensionStatus.builder()
                    .awsAutoTagging(FileUploadV2Response.ExtensionStatus.AwsAutoTagging.SUCCESS)
                    .googleAutoTagging(
                        FileUploadV2Response.ExtensionStatus.GoogleAutoTagging.SUCCESS
                    )
                    .removeBg(FileUploadV2Response.ExtensionStatus.RemoveBg.SUCCESS)
                    .build()
            )
        assertThat(fileUploadV2Response.fileId()).contains("fileId")
        assertThat(fileUploadV2Response.filePath()).contains("filePath")
        assertThat(fileUploadV2Response.fileType()).contains("fileType")
        assertThat(fileUploadV2Response.height()).contains(0.0)
        assertThat(fileUploadV2Response.isPrivateFile()).contains(true)
        assertThat(fileUploadV2Response.isPublished()).contains(true)
        assertThat(fileUploadV2Response.metadata())
            .contains(
                FileUploadV2Response.Metadata.builder()
                    .audioCodec("audioCodec")
                    .bitRate(0L)
                    .density(0L)
                    .duration(0L)
                    .exif(
                        FileUploadV2Response.Metadata.Exif.builder()
                            .exif(
                                ExifDetails.builder()
                                    .apertureValue(0.0)
                                    .colorSpace(0L)
                                    .createDate("CreateDate")
                                    .customRendered(0L)
                                    .dateTimeOriginal("DateTimeOriginal")
                                    .exifImageHeight(0L)
                                    .exifImageWidth(0L)
                                    .exifVersion("ExifVersion")
                                    .exposureCompensation(0.0)
                                    .exposureMode(0L)
                                    .exposureProgram(0L)
                                    .exposureTime(0.0)
                                    .flash(0L)
                                    .flashpixVersion("FlashpixVersion")
                                    .fNumber(0.0)
                                    .focalLength(0L)
                                    .focalPlaneResolutionUnit(0L)
                                    .focalPlaneXResolution(0.0)
                                    .focalPlaneYResolution(0.0)
                                    .interopOffset(0L)
                                    .iso(0L)
                                    .meteringMode(0L)
                                    .sceneCaptureType(0L)
                                    .shutterSpeedValue(0.0)
                                    .subSecTime("SubSecTime")
                                    .whiteBalance(0L)
                                    .build()
                            )
                            .gps(Gps.builder().addGpsVersionId(0L).build())
                            .image(
                                ExifImage.builder()
                                    .exifOffset(0L)
                                    .gpsInfo(0L)
                                    .make("Make")
                                    .model("Model")
                                    .modifyDate("ModifyDate")
                                    .orientation(0L)
                                    .resolutionUnit(0L)
                                    .software("Software")
                                    .xResolution(0L)
                                    .yCbCrPositioning(0L)
                                    .yResolution(0L)
                                    .build()
                            )
                            .interoperability(
                                Interoperability.builder()
                                    .interopIndex("InteropIndex")
                                    .interopVersion("InteropVersion")
                                    .build()
                            )
                            .makernote(
                                FileUploadV2Response.Metadata.Exif.Makernote.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .thumbnail(
                                Thumbnail.builder()
                                    .compression(0L)
                                    .resolutionUnit(0L)
                                    .thumbnailLength(0L)
                                    .thumbnailOffset(0L)
                                    .xResolution(0L)
                                    .yResolution(0L)
                                    .build()
                            )
                            .build()
                    )
                    .format("format")
                    .hasColorProfile(true)
                    .hasTransparency(true)
                    .height(0L)
                    .pHash("pHash")
                    .quality(0L)
                    .size(0L)
                    .videoCodec("videoCodec")
                    .width(0L)
                    .build()
            )
        assertThat(fileUploadV2Response.name()).contains("name")
        assertThat(fileUploadV2Response.size()).contains(0.0)
        assertThat(fileUploadV2Response.tags().getOrNull()).containsExactly("string")
        assertThat(fileUploadV2Response.thumbnailUrl()).contains("thumbnailUrl")
        assertThat(fileUploadV2Response.url()).contains("url")
        assertThat(fileUploadV2Response.versionInfo())
            .contains(FileUploadV2Response.VersionInfo.builder().id("id").name("name").build())
        assertThat(fileUploadV2Response.videoCodec()).contains("videoCodec")
        assertThat(fileUploadV2Response.width()).contains(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileUploadV2Response =
            FileUploadV2Response.builder()
                .addAiTag(
                    FileUploadV2Response.AiTag.builder()
                        .confidence(0.0)
                        .name("name")
                        .source("source")
                        .build()
                )
                .audioCodec("audioCodec")
                .bitRate(0L)
                .customCoordinates("customCoordinates")
                .customMetadata(JsonValue.from(mapOf<String, Any>()))
                .duration(0L)
                .embeddedMetadata(
                    FileUploadV2Response.EmbeddedMetadata.builder()
                        .aboutCvTermCvId("http://example.com/cv/about/ref2019.1")
                        .aboutCvTermId("http://example.com/cv/about/ref2019.1/code987")
                        .aboutCvTermName("CV-Term Name 1 (ref2019.1)")
                        .aboutCvTermRefinedAbout(
                            "http://example.com/cv/refinements2/ref2019.1/codeX145"
                        )
                        .additionalModelInformation("Additional Model Info (ref2019.1)")
                        .applicationRecordVersion(4L)
                        .artist("Creator1 (ref2019.1)")
                        .artworkCircaDateCreated("AO Circa Date: between 1550 and 1600 (ref2019.1)")
                        .artworkContentDescription("AO Content Description 1 (ref2019.1)")
                        .artworkContributionDescription("AO Contribution Description 1 (ref2019.1)")
                        .artworkCopyrightNotice("AO Copyright Notice 1 (ref2019.1)")
                        .artworkCopyrightOwnerId("AO Current Copyright Owner ID 1 (ref2019.1)")
                        .artworkCopyrightOwnerName("AO Current Copyright Owner Name 1 (ref2019.1)")
                        .addArtworkCreator("AO Creator Name 1a (ref2019.1)")
                        .addArtworkCreator("AO Creator Name 1b (ref2019.1)")
                        .addArtworkCreatorId("AO Creator Id 1a (ref2019.1)")
                        .addArtworkCreatorId("AO Creator Id 1b (ref2019.1)")
                        .artworkDateCreated(OffsetDateTime.parse("1919-10-16T19:01:00.000Z"))
                        .artworkLicensorId("AO Current Licensor ID 1 (ref2019.1)")
                        .artworkLicensorName("AO Current Licensor Name 1 (ref2019.1)")
                        .artworkPhysicalDescription("AO Physical Description 1 (ref2019.1)")
                        .artworkSource("AO Source 1 (ref2019.1)")
                        .artworkSourceInventoryNo("AO Source Inventory No 1 (ref2019.1)")
                        .artworkSourceInvUrl("AO Source Inventory URL (ref2019.1)")
                        .addArtworkStylePeriod("AO Style Baroque (ref2019.1)")
                        .addArtworkStylePeriod("AO Style Italian Baroque (ref2019.1)")
                        .artworkTitle("AO Title 1 (ref2019.1)")
                        .authorsPosition("Creator's Job Title  (ref2019.1)")
                        .byline("Creator1 (ref2019.1)")
                        .bylineTitle("Creator's Job Title  (ref2019.1)")
                        .caption("The description aka caption (ref2019.1)")
                        .captionAbstract("The description aka caption (ref2019.1)")
                        .captionWriter("Description Writer (ref2019.1)")
                        .city("City (Core) (ref2019.1)")
                        .colorSpace("Uncalibrated")
                        .componentsConfiguration("Y,Cb,Cr,-")
                        .copyright("Copyright (Notice) 2019.1 IPTC - www.iptc.org  (ref2019.1)")
                        .copyrightNotice(
                            "Copyright (Notice) 2019.1 IPTC - www.iptc.org  (ref2019.1)"
                        )
                        .addCopyrightOwnerId("Copyright Owner Id 1 (ref2019.1)")
                        .addCopyrightOwnerId("Copyright Owner Id 2 (ref2019.1)")
                        .addCopyrightOwnerName("Copyright Owner Name 1 (ref2019.1)")
                        .addCopyrightOwnerName("Copyright Owner Name 2 (ref2019.1)")
                        .country("Country (Core) (ref2019.1)")
                        .countryCode("R19")
                        .countryPrimaryLocationCode("R19")
                        .countryPrimaryLocationName("Country (Core) (ref2019.1)")
                        .creator("Creator1 (ref2019.1)")
                        .creatorAddress("Creator's CI: Address, line 1 (ref2019.1)")
                        .creatorCity("Creator's CI: City (ref2019.1)")
                        .creatorCountry("Creator's CI: Country (ref2019.1)")
                        .creatorPostalCode("Creator's CI: Postcode (ref2019.1)")
                        .creatorRegion("Creator's CI: State/Province (ref2019.1)")
                        .creatorWorkEmail("Creator's CI: Email@1, Email@2 (ref2019.1)")
                        .creatorWorkTelephone("Creator's CI: Phone # 1, Phone # 2 (ref2019.1)")
                        .creatorWorkUrl("http://www.Creators.CI/WebAddress/ref2019.1")
                        .credit("Credit Line (ref2019.1)")
                        .dateCreated(OffsetDateTime.parse("2019-10-16T00:00:00.000Z"))
                        .dateTimeCreated(OffsetDateTime.parse("2019-10-16T00:00:00.000Z"))
                        .dateTimeOriginal(OffsetDateTime.parse("2019-10-16T19:01:03.000Z"))
                        .description("The description aka caption (ref2019.1)")
                        .digitalImageGuid("http://example.com/imageGUIDs/TestGUID12345/ref2019.1")
                        .digitalSourceType(
                            "http://cv.iptc.org/newscodes/digitalsourcetype/softwareImage"
                        )
                        .embeddedEncodedRightsExpr("The Encoded Rights Expression (ref2019.1)")
                        .embeddedEncodedRightsExprLangId(
                            "http://example.org/RELids/id4711/ref2019.1"
                        )
                        .embeddedEncodedRightsExprType("IANA Media Type of ERE (ref2019.1)")
                        .event("An Event (ref2019.1)")
                        .exifVersion("0232")
                        .flashpixVersion("0100")
                        .genreCvId("http://example.com/cv/genre/ref2019.1")
                        .genreCvTermId("http://example.com/cv/genre/ref2019.1/code1369")
                        .genreCvTermName("Genre CV-Term Name 1 (ref2019.1)")
                        .genreCvTermRefinedAbout(
                            "http://example.com/cv/genrerefinements2/ref2019.1/codeY864"
                        )
                        .headline("The Headline (ref2019.1)")
                        .imageCreatorId("Image Creator Id 1 (ref2019.1)")
                        .imageCreatorImageId("Image Creator Image ID (ref2019.1)")
                        .imageCreatorName("Image Creator Name 1 (ref2019.1)")
                        .imageDescription("The description aka caption (ref2019.1)")
                        .addImageRegionBoundaryH(0.385)
                        .addImageRegionBoundaryRx(0.068)
                        .imageRegionBoundaryShape(listOf("rectangle", "circle", "polygon"))
                        .imageRegionBoundaryUnit(listOf("relative", "relative", "relative"))
                        .imageRegionBoundaryVerticesX(listOf(0.05, 0.148, 0.375))
                        .imageRegionBoundaryVerticesY(listOf(0.713, 0.041, 0.863))
                        .addImageRegionBoundaryW(0.127)
                        .addImageRegionBoundaryX(0.31)
                        .addImageRegionBoundaryX(0.59)
                        .addImageRegionBoundaryY(0.18)
                        .addImageRegionBoundaryY(0.426)
                        .imageRegionCtypeIdentifier(
                            listOf(
                                "https://example.org/rctype/type2019.1a",
                                "https://example.org/rctype/type2019.1b",
                                "https://example.org/rctype/type2019.1a",
                                "https://example.org/rctype/type2019.1b",
                                "https://example.org/rctype/type2019.1a",
                                "https://example.org/rctype/type2019.1b",
                            )
                        )
                        .imageRegionCtypeName(
                            listOf(
                                "Region Boundary Content Type Name (ref2019.1)",
                                "Region Boundary Content Type Name (ref2019.1)",
                                "Region Boundary Content Type Name (ref2019.1)",
                            )
                        )
                        .imageRegionId(listOf("persltr2", "persltr3", "persltr1"))
                        .imageRegionName(listOf("Listener 1", "Listener 2", "Speaker 1"))
                        .imageRegionOrganisationInImageName(
                            listOf(
                                "Organisation name no 1 in region persltr2 (ref2019.1)",
                                "Organisation name no 1 in region persltr2 (ref2019.1)",
                                "Organisation name no 1 in region persltr3 (ref2019.1)",
                            )
                        )
                        .imageRegionPersonInImage(
                            listOf(
                                "Person name no 1 in region persltr2 (ref2019.1)",
                                "Person name no 1 in region persltr3 (ref2019.1)",
                                "Person name no 1 in region persltr1 (ref2019.1)",
                            )
                        )
                        .imageRegionRoleIdentifier(
                            listOf(
                                "https://example.org/rrole/role2019.1a",
                                "https://example.org/rrole/role2019.1b",
                                "https://example.org/rrole/role2019.1a",
                                "https://example.org/rrole/role2019.1b",
                                "https://example.org/rrole/role2019.1a",
                                "https://example.org/rrole/role2019.1b",
                            )
                        )
                        .imageRegionRoleName(
                            listOf(
                                "Region Boundary Content Role Name (ref2019.1)",
                                "Region Boundary Content Role Name (ref2019.1)",
                                "Region Boundary Content Role Name (ref2019.1)",
                            )
                        )
                        .imageSupplierId("Image Supplier Id (ref2019.1)")
                        .imageSupplierImageId("Image Supplier Image ID (ref2019.1)")
                        .imageSupplierName("Image Supplier Name (ref2019.1)")
                        .instructions("An Instruction (ref2019.1)")
                        .intellectualGenre("A Genre (ref2019.1)")
                        .keywords(
                            listOf("Keyword1ref2019.1", "Keyword2ref2019.1", "Keyword3ref2019.1")
                        )
                        .addLicensorCity("Licensor City 1 (ref2019.1)")
                        .addLicensorCity("Licensor City 2 (ref2019.1)")
                        .addLicensorCountry("Licensor Country 1 (ref2019.1)")
                        .addLicensorCountry("Licensor Country 2 (ref2019.1)")
                        .addLicensorEmail("Licensor Email 1 (ref2019.1)")
                        .addLicensorEmail("Licensor Email 2 (ref2019.1)")
                        .addLicensorExtendedAddress("Licensor Ext Addr 1 (ref2019.1)")
                        .addLicensorExtendedAddress("Licensor Ext Addr 2 (ref2019.1)")
                        .addLicensorId("Licensor ID 1 (ref2019.1)")
                        .addLicensorId("Licensor ID 2 (ref2019.1)")
                        .addLicensorName("Licensor Name 1 (ref2019.1)")
                        .addLicensorName("Licensor Name 2 (ref2019.1)")
                        .addLicensorPostalCode("Licensor Postcode 1 (ref2019.1)")
                        .addLicensorPostalCode("Licensor Postcode 2 (ref2019.1)")
                        .addLicensorRegion("Licensor Region 1 (ref2019.1)")
                        .addLicensorRegion("Licensor Region 2 (ref2019.1)")
                        .addLicensorStreetAddress("Licensor Street Addr 1 (ref2019.1)")
                        .addLicensorStreetAddress("Licensor Street Addr 2 (ref2019.1)")
                        .addLicensorTelephone1("Licensor Phone1 1 (ref2019.1)")
                        .addLicensorTelephone1("Licensor Phone1 2 (ref2019.1)")
                        .addLicensorTelephone2("Licensor Phone2 1 (ref2019.1)")
                        .addLicensorTelephone2("Licensor Phone2 2 (ref2019.1)")
                        .addLicensorUrl("Licensor URL 1 (ref2019.1)")
                        .addLicensorUrl("Licensor URL 2 (ref2019.1)")
                        .linkedEncodedRightsExpr(
                            "http://example.org/linkedrightsexpression/id986/ref2019.1"
                        )
                        .linkedEncodedRightsExprLangId("http://example.org/RELids/id4712/ref2019.1")
                        .linkedEncodedRightsExprType("IANA Media Type of ERE (ref2019.1)")
                        .location("Sublocation (Core) (ref2019.1)")
                        .locationCreatedCity("City (Location created1) (ref2019.1)")
                        .locationCreatedCountryCode("R17")
                        .locationCreatedCountryName("CountryName (Location created1) (ref2019.1)")
                        .locationCreatedGpsAltitude("480 m")
                        .locationCreatedGpsLatitude("48,16.5N")
                        .locationCreatedGpsLongitude("16,20.28E")
                        .locationCreatedLocationId("Location Id (Location created1) (ref2019.1)")
                        .locationCreatedLocationName(
                            "Location Name (Location created1) (ref2019.1)"
                        )
                        .locationCreatedProvinceState(
                            "Province/State (Location created1) (ref2019.1)"
                        )
                        .locationCreatedSublocation("Sublocation (Location created1) (ref2019.1)")
                        .locationCreatedWorldRegion("Worldregion (Location created1) (ref2019.1)")
                        .addLocationShownCity("City (Location shown1) (ref2019.1)")
                        .addLocationShownCity("City (Location shown2) (ref2019.1)")
                        .addLocationShownCountryCode("R17")
                        .addLocationShownCountryCode("R17")
                        .addLocationShownCountryName("CountryName (Location shown1) (ref2019.1)")
                        .addLocationShownCountryName("CountryName (Location shown2) (ref2019.1)")
                        .addLocationShownGpsAltitude("140 m")
                        .addLocationShownGpsAltitude("120 m")
                        .addLocationShownGpsLatitude("48,8.82N")
                        .addLocationShownGpsLatitude("47,57.12N")
                        .addLocationShownGpsLongitude("17,5.88E")
                        .addLocationShownGpsLongitude("16,49.8E")
                        .locationShownLocationId(
                            listOf(
                                "Location Id 1a(Location shown1) (ref2019.1)",
                                "Location Id 1b(Location shown1) (ref2019.1)",
                                "Location Id 2a(Location shown2) (ref2019.1)",
                                "Location Id 2b(Location shown2) (ref2019.1)",
                            )
                        )
                        .addLocationShownLocationName("Location Name (Location shown1) (ref2019.1)")
                        .addLocationShownLocationName("Location Name (Location shown2) (ref2019.1)")
                        .addLocationShownProvinceState(
                            "Province/State (Location shown1) (ref2019.1)"
                        )
                        .addLocationShownProvinceState(
                            "Province/State (Location shown2) (ref2019.1)"
                        )
                        .addLocationShownSublocation("Sublocation (Location shown1) (ref2019.1)")
                        .addLocationShownSublocation("Sublocation (Location shown2) (ref2019.1)")
                        .addLocationShownWorldRegion("Worldregion (Location shown1) (ref2019.1)")
                        .addLocationShownWorldRegion("Worldregion (Location shown2) (ref2019.1)")
                        .maxAvailHeight(20.0)
                        .maxAvailWidth(19.0)
                        .modelAge(listOf(25.0, 27.0, 30.0))
                        .addModelReleaseId("Model Release ID 1 (ref2019.1)")
                        .addModelReleaseId("Model Release ID 2 (ref2019.1)")
                        .objectAttributeReference("A Genre (ref2019.1)")
                        .objectName("The Title (ref2019.1)")
                        .offsetTimeOriginal("+00:00")
                        .organisationInImageCode(
                            listOf(
                                "Organisation Code 1 (ref2019.1)",
                                "Organisation Code 2 (ref2019.1)",
                                "Organisation Code 3 (ref2019.1)",
                            )
                        )
                        .organisationInImageName(
                            listOf(
                                "Organisation Name 1 (ref2019.1)",
                                "Organisation Name 2 (ref2019.1)",
                                "Organisation Name 3 (ref2019.1)",
                            )
                        )
                        .orientation("Horizontal (normal)")
                        .originalTransmissionReference("Job Id (ref2019.1)")
                        .addPersonInImage("Person Shown 1 (ref2019.1)")
                        .addPersonInImage("Person Shown 2 (ref2019.1)")
                        .addPersonInImageCvTermCvId("http://example.com/cv/test99/ref2019.1")
                        .addPersonInImageCvTermId("http://example.com/cv/test99/code987/ref2019.1")
                        .addPersonInImageCvTermName("Person Characteristic Name 1 (ref2019.1)")
                        .addPersonInImageCvTermRefinedAbout(
                            "http://example.com/cv/refinements987/codeY765/ref2019.1"
                        )
                        .addPersonInImageDescription("Person Description 1 (ref2019.1)")
                        .addPersonInImageId("http://wikidata.org/item/Q123456789/ref2019.1")
                        .addPersonInImageId("http://freebase.com/m/987654321/ref2019.1")
                        .addPersonInImageName("Person Name 1 (ref2019.1)")
                        .addProductInImageDescription("Product Description 1 (ref2019.1)")
                        .addProductInImageGtin(123456782019.1)
                        .addProductInImageName("Product Name 1 (ref2019.1)")
                        .addPropertyReleaseId("Property Release ID 1 (ref2019.1)")
                        .addPropertyReleaseId("Property Release ID 2 (ref2019.1)")
                        .provinceState("Province/State(Core)(ref2019.1)")
                        .rating(1L)
                        .addRegistryEntryRole("Registry Entry Role ID 1 (ref2019.1)")
                        .addRegistryEntryRole("Registry Entry Role ID 2 (ref2019.1)")
                        .addRegistryItemId("Registry Image ID 1 (ref2019.1)")
                        .addRegistryItemId("Registry Image ID 2 (ref2019.1)")
                        .addRegistryOrganisationId("Registry Organisation ID 1 (ref2019.1)")
                        .addRegistryOrganisationId("Registry Organisation ID 2 (ref2019.1)")
                        .resolutionUnit("inches")
                        .rights("Copyright (Notice) 2019.1 IPTC - www.iptc.org  (ref2019.1)")
                        .addScene("IPTC-Scene-Code1 (ref2019.1)")
                        .addScene("IPTC-Scene-Code2 (ref2019.1)")
                        .source("Source (ref2019.1)")
                        .specialInstructions("An Instruction (ref2019.1)")
                        .state("Province/State(Core)(ref2019.1)")
                        .subject(
                            listOf("Keyword1ref2019.1", "Keyword2ref2019.1", "Keyword3ref2019.1")
                        )
                        .subjectCode(
                            listOf("IPTC:1ref2019.1", "IPTC:2ref2019.1", "IPTC:3ref2019.1")
                        )
                        .subjectReference(
                            listOf("IPTC:1ref2019.1", "IPTC:2ref2019.1", "IPTC:3ref2019.1")
                        )
                        .sublocation("Sublocation (Core) (ref2019.1)")
                        .timeCreated("19:01:03+00:00")
                        .title("The Title (ref2019.1)")
                        .transmissionReference("Job Id (ref2019.1)")
                        .usageTerms("Rights Usage Terms (ref2019.1)")
                        .webStatement("http://www.WebStatementOfRights.org/2019.1")
                        .writer("Description Writer (ref2019.1)")
                        .writerEditor("Description Writer (ref2019.1)")
                        .xResolution(72.0)
                        .yResolution(72.0)
                        .build()
                )
                .extensionStatus(
                    FileUploadV2Response.ExtensionStatus.builder()
                        .awsAutoTagging(FileUploadV2Response.ExtensionStatus.AwsAutoTagging.SUCCESS)
                        .googleAutoTagging(
                            FileUploadV2Response.ExtensionStatus.GoogleAutoTagging.SUCCESS
                        )
                        .removeBg(FileUploadV2Response.ExtensionStatus.RemoveBg.SUCCESS)
                        .build()
                )
                .fileId("fileId")
                .filePath("filePath")
                .fileType("fileType")
                .height(0.0)
                .isPrivateFile(true)
                .isPublished(true)
                .metadata(
                    FileUploadV2Response.Metadata.builder()
                        .audioCodec("audioCodec")
                        .bitRate(0L)
                        .density(0L)
                        .duration(0L)
                        .exif(
                            FileUploadV2Response.Metadata.Exif.builder()
                                .exif(
                                    ExifDetails.builder()
                                        .apertureValue(0.0)
                                        .colorSpace(0L)
                                        .createDate("CreateDate")
                                        .customRendered(0L)
                                        .dateTimeOriginal("DateTimeOriginal")
                                        .exifImageHeight(0L)
                                        .exifImageWidth(0L)
                                        .exifVersion("ExifVersion")
                                        .exposureCompensation(0.0)
                                        .exposureMode(0L)
                                        .exposureProgram(0L)
                                        .exposureTime(0.0)
                                        .flash(0L)
                                        .flashpixVersion("FlashpixVersion")
                                        .fNumber(0.0)
                                        .focalLength(0L)
                                        .focalPlaneResolutionUnit(0L)
                                        .focalPlaneXResolution(0.0)
                                        .focalPlaneYResolution(0.0)
                                        .interopOffset(0L)
                                        .iso(0L)
                                        .meteringMode(0L)
                                        .sceneCaptureType(0L)
                                        .shutterSpeedValue(0.0)
                                        .subSecTime("SubSecTime")
                                        .whiteBalance(0L)
                                        .build()
                                )
                                .gps(Gps.builder().addGpsVersionId(0L).build())
                                .image(
                                    ExifImage.builder()
                                        .exifOffset(0L)
                                        .gpsInfo(0L)
                                        .make("Make")
                                        .model("Model")
                                        .modifyDate("ModifyDate")
                                        .orientation(0L)
                                        .resolutionUnit(0L)
                                        .software("Software")
                                        .xResolution(0L)
                                        .yCbCrPositioning(0L)
                                        .yResolution(0L)
                                        .build()
                                )
                                .interoperability(
                                    Interoperability.builder()
                                        .interopIndex("InteropIndex")
                                        .interopVersion("InteropVersion")
                                        .build()
                                )
                                .makernote(
                                    FileUploadV2Response.Metadata.Exif.Makernote.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .thumbnail(
                                    Thumbnail.builder()
                                        .compression(0L)
                                        .resolutionUnit(0L)
                                        .thumbnailLength(0L)
                                        .thumbnailOffset(0L)
                                        .xResolution(0L)
                                        .yResolution(0L)
                                        .build()
                                )
                                .build()
                        )
                        .format("format")
                        .hasColorProfile(true)
                        .hasTransparency(true)
                        .height(0L)
                        .pHash("pHash")
                        .quality(0L)
                        .size(0L)
                        .videoCodec("videoCodec")
                        .width(0L)
                        .build()
                )
                .name("name")
                .size(0.0)
                .addTag("string")
                .thumbnailUrl("thumbnailUrl")
                .url("url")
                .versionInfo(
                    FileUploadV2Response.VersionInfo.builder().id("id").name("name").build()
                )
                .videoCodec("videoCodec")
                .width(0.0)
                .build()

        val roundtrippedFileUploadV2Response =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileUploadV2Response),
                jacksonTypeRef<FileUploadV2Response>(),
            )

        assertThat(roundtrippedFileUploadV2Response).isEqualTo(fileUploadV2Response)
    }
}
