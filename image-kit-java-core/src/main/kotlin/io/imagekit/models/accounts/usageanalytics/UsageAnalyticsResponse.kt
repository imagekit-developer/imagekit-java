// File generated from our OpenAPI spec by Stainless.

package io.imagekit.models.accounts.usageanalytics

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.imagekit.core.ExcludeMissing
import io.imagekit.core.JsonField
import io.imagekit.core.JsonMissing
import io.imagekit.core.JsonValue
import io.imagekit.core.checkKnown
import io.imagekit.core.checkRequired
import io.imagekit.core.toImmutable
import io.imagekit.errors.ImageKitInvalidDataException
import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class UsageAnalyticsResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val bandwidthBytes: JsonField<Double>,
    private val browser: JsonField<Browser>,
    private val cache: JsonField<Cache>,
    private val country: JsonField<Country>,
    private val device: JsonField<Device>,
    private val endDate: JsonField<LocalDate>,
    private val errorReasons: JsonField<List<ErrorReason>>,
    private val extensions: JsonField<List<Extension>>,
    private val format: JsonField<Format>,
    private val generatedAt: JsonField<OffsetDateTime>,
    private val requestCount: JsonField<Double>,
    private val startDate: JsonField<LocalDate>,
    private val statusCodes: JsonField<List<StatusCode>>,
    private val top404Assets: JsonField<List<Top404Asset>>,
    private val topImages: JsonField<TopImages>,
    private val topImageTransforms: JsonField<TopImageTransforms>,
    private val topOtherAssets: JsonField<TopOtherAssets>,
    private val topReferrers: JsonField<TopReferrers>,
    private val topUserAgents: JsonField<TopUserAgents>,
    private val topVideos: JsonField<TopVideos>,
    private val topVideoTransforms: JsonField<TopVideoTransforms>,
    private val urlEndpoints: JsonField<UrlEndpoints>,
    private val videoProcessing: JsonField<List<VideoProcessing>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("bandwidthBytes")
        @ExcludeMissing
        bandwidthBytes: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("browser") @ExcludeMissing browser: JsonField<Browser> = JsonMissing.of(),
        @JsonProperty("cache") @ExcludeMissing cache: JsonField<Cache> = JsonMissing.of(),
        @JsonProperty("country") @ExcludeMissing country: JsonField<Country> = JsonMissing.of(),
        @JsonProperty("device") @ExcludeMissing device: JsonField<Device> = JsonMissing.of(),
        @JsonProperty("endDate") @ExcludeMissing endDate: JsonField<LocalDate> = JsonMissing.of(),
        @JsonProperty("errorReasons")
        @ExcludeMissing
        errorReasons: JsonField<List<ErrorReason>> = JsonMissing.of(),
        @JsonProperty("extensions")
        @ExcludeMissing
        extensions: JsonField<List<Extension>> = JsonMissing.of(),
        @JsonProperty("format") @ExcludeMissing format: JsonField<Format> = JsonMissing.of(),
        @JsonProperty("generatedAt")
        @ExcludeMissing
        generatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("requestCount")
        @ExcludeMissing
        requestCount: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("startDate")
        @ExcludeMissing
        startDate: JsonField<LocalDate> = JsonMissing.of(),
        @JsonProperty("statusCodes")
        @ExcludeMissing
        statusCodes: JsonField<List<StatusCode>> = JsonMissing.of(),
        @JsonProperty("top404Assets")
        @ExcludeMissing
        top404Assets: JsonField<List<Top404Asset>> = JsonMissing.of(),
        @JsonProperty("topImages")
        @ExcludeMissing
        topImages: JsonField<TopImages> = JsonMissing.of(),
        @JsonProperty("topImageTransforms")
        @ExcludeMissing
        topImageTransforms: JsonField<TopImageTransforms> = JsonMissing.of(),
        @JsonProperty("topOtherAssets")
        @ExcludeMissing
        topOtherAssets: JsonField<TopOtherAssets> = JsonMissing.of(),
        @JsonProperty("topReferrers")
        @ExcludeMissing
        topReferrers: JsonField<TopReferrers> = JsonMissing.of(),
        @JsonProperty("topUserAgents")
        @ExcludeMissing
        topUserAgents: JsonField<TopUserAgents> = JsonMissing.of(),
        @JsonProperty("topVideos")
        @ExcludeMissing
        topVideos: JsonField<TopVideos> = JsonMissing.of(),
        @JsonProperty("topVideoTransforms")
        @ExcludeMissing
        topVideoTransforms: JsonField<TopVideoTransforms> = JsonMissing.of(),
        @JsonProperty("urlEndpoints")
        @ExcludeMissing
        urlEndpoints: JsonField<UrlEndpoints> = JsonMissing.of(),
        @JsonProperty("videoProcessing")
        @ExcludeMissing
        videoProcessing: JsonField<List<VideoProcessing>> = JsonMissing.of(),
    ) : this(
        bandwidthBytes,
        browser,
        cache,
        country,
        device,
        endDate,
        errorReasons,
        extensions,
        format,
        generatedAt,
        requestCount,
        startDate,
        statusCodes,
        top404Assets,
        topImages,
        topImageTransforms,
        topOtherAssets,
        topReferrers,
        topUserAgents,
        topVideos,
        topVideoTransforms,
        urlEndpoints,
        videoProcessing,
        mutableMapOf(),
    )

    /**
     * Total bandwidth, in bytes, utilized during the specified date range.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

    /**
     * CDN traffic grouped by browser.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun browser(): Browser = browser.getRequired("browser")

    /**
     * CDN cache hit, miss and error counts for the date range.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun cache(): Cache = cache.getRequired("cache")

    /**
     * CDN traffic grouped by country.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun country(): Country = country.getRequired("country")

    /**
     * CDN traffic grouped by device and operating system (e.g. `Desktop - Apple Mac`, `Smartphone -
     * Apple iPhone`).
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun device(): Device = device.getRequired("device")

    /**
     * End date of the computed analytics data.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun endDate(): LocalDate = endDate.getRequired("endDate")

    /**
     * Request count grouped by origin error reason. This covers failed origin fetches, such as an
     * asset not found at origin or an origin timeout. It is not the HTTP status code returned to
     * the client, see `statusCodes` for that.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun errorReasons(): List<ErrorReason> = errorReasons.getRequired("errorReasons")

    /**
     * Raw per-extension operation counts for the date range. These are raw operation counts, not
     * billable extension units. For billable usage, use the `/v1/accounts/usage` endpoint.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun extensions(): List<Extension> = extensions.getRequired("extensions")

    /**
     * CDN traffic grouped by response `Content-Type`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun format(): Format = format.getRequired("format")

    /**
     * Date and time when the analytics data was computed. Use this to gauge how fresh the returned
     * data is. The date and time is in ISO8601 format.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun generatedAt(): OffsetDateTime = generatedAt.getRequired("generatedAt")

    /**
     * Total number of requests made during the specified date range.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun requestCount(): Double = requestCount.getRequired("requestCount")

    /**
     * Start date of the computed analytics data.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun startDate(): LocalDate = startDate.getRequired("startDate")

    /**
     * Request count grouped by HTTP status code.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun statusCodes(): List<StatusCode> = statusCodes.getRequired("statusCodes")

    /**
     * Top URLs that returned a 404 response.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun top404Assets(): List<Top404Asset> = top404Assets.getRequired("top404Assets")

    /**
     * Top image assets by traffic.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun topImages(): TopImages = topImages.getRequired("topImages")

    /**
     * Top image transformation strings by traffic.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun topImageTransforms(): TopImageTransforms =
        topImageTransforms.getRequired("topImageTransforms")

    /**
     * Top non-image, non-video assets by traffic.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun topOtherAssets(): TopOtherAssets = topOtherAssets.getRequired("topOtherAssets")

    /**
     * Top HTTP referrers by traffic.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun topReferrers(): TopReferrers = topReferrers.getRequired("topReferrers")

    /**
     * Top user agents by traffic.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun topUserAgents(): TopUserAgents = topUserAgents.getRequired("topUserAgents")

    /**
     * Top video assets by traffic.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun topVideos(): TopVideos = topVideos.getRequired("topVideos")

    /**
     * Top video transformation strings by traffic.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun topVideoTransforms(): TopVideoTransforms =
        topVideoTransforms.getRequired("topVideoTransforms")

    /**
     * CDN traffic grouped by configured URL endpoint. Traffic that does not match any named URL
     * endpoint pattern is grouped under `Default`.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun urlEndpoints(): UrlEndpoints = urlEndpoints.getRequired("urlEndpoints")

    /**
     * Raw observed video transcode output duration, in seconds, grouped by resolution and codec.
     * These are raw seconds, not billable Video Processing Units (VPU). For billable VPU totals,
     * use the `/v1/accounts/usage` endpoint.
     *
     * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun videoProcessing(): List<VideoProcessing> = videoProcessing.getRequired("videoProcessing")

    /**
     * Returns the raw JSON value of [bandwidthBytes].
     *
     * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("bandwidthBytes")
    @ExcludeMissing
    fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

    /**
     * Returns the raw JSON value of [browser].
     *
     * Unlike [browser], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("browser") @ExcludeMissing fun _browser(): JsonField<Browser> = browser

    /**
     * Returns the raw JSON value of [cache].
     *
     * Unlike [cache], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cache") @ExcludeMissing fun _cache(): JsonField<Cache> = cache

    /**
     * Returns the raw JSON value of [country].
     *
     * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<Country> = country

    /**
     * Returns the raw JSON value of [device].
     *
     * Unlike [device], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("device") @ExcludeMissing fun _device(): JsonField<Device> = device

    /**
     * Returns the raw JSON value of [endDate].
     *
     * Unlike [endDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("endDate") @ExcludeMissing fun _endDate(): JsonField<LocalDate> = endDate

    /**
     * Returns the raw JSON value of [errorReasons].
     *
     * Unlike [errorReasons], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("errorReasons")
    @ExcludeMissing
    fun _errorReasons(): JsonField<List<ErrorReason>> = errorReasons

    /**
     * Returns the raw JSON value of [extensions].
     *
     * Unlike [extensions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("extensions")
    @ExcludeMissing
    fun _extensions(): JsonField<List<Extension>> = extensions

    /**
     * Returns the raw JSON value of [format].
     *
     * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<Format> = format

    /**
     * Returns the raw JSON value of [generatedAt].
     *
     * Unlike [generatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("generatedAt")
    @ExcludeMissing
    fun _generatedAt(): JsonField<OffsetDateTime> = generatedAt

    /**
     * Returns the raw JSON value of [requestCount].
     *
     * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("requestCount")
    @ExcludeMissing
    fun _requestCount(): JsonField<Double> = requestCount

    /**
     * Returns the raw JSON value of [startDate].
     *
     * Unlike [startDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("startDate") @ExcludeMissing fun _startDate(): JsonField<LocalDate> = startDate

    /**
     * Returns the raw JSON value of [statusCodes].
     *
     * Unlike [statusCodes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("statusCodes")
    @ExcludeMissing
    fun _statusCodes(): JsonField<List<StatusCode>> = statusCodes

    /**
     * Returns the raw JSON value of [top404Assets].
     *
     * Unlike [top404Assets], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("top404Assets")
    @ExcludeMissing
    fun _top404Assets(): JsonField<List<Top404Asset>> = top404Assets

    /**
     * Returns the raw JSON value of [topImages].
     *
     * Unlike [topImages], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("topImages") @ExcludeMissing fun _topImages(): JsonField<TopImages> = topImages

    /**
     * Returns the raw JSON value of [topImageTransforms].
     *
     * Unlike [topImageTransforms], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("topImageTransforms")
    @ExcludeMissing
    fun _topImageTransforms(): JsonField<TopImageTransforms> = topImageTransforms

    /**
     * Returns the raw JSON value of [topOtherAssets].
     *
     * Unlike [topOtherAssets], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("topOtherAssets")
    @ExcludeMissing
    fun _topOtherAssets(): JsonField<TopOtherAssets> = topOtherAssets

    /**
     * Returns the raw JSON value of [topReferrers].
     *
     * Unlike [topReferrers], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("topReferrers")
    @ExcludeMissing
    fun _topReferrers(): JsonField<TopReferrers> = topReferrers

    /**
     * Returns the raw JSON value of [topUserAgents].
     *
     * Unlike [topUserAgents], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("topUserAgents")
    @ExcludeMissing
    fun _topUserAgents(): JsonField<TopUserAgents> = topUserAgents

    /**
     * Returns the raw JSON value of [topVideos].
     *
     * Unlike [topVideos], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("topVideos") @ExcludeMissing fun _topVideos(): JsonField<TopVideos> = topVideos

    /**
     * Returns the raw JSON value of [topVideoTransforms].
     *
     * Unlike [topVideoTransforms], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("topVideoTransforms")
    @ExcludeMissing
    fun _topVideoTransforms(): JsonField<TopVideoTransforms> = topVideoTransforms

    /**
     * Returns the raw JSON value of [urlEndpoints].
     *
     * Unlike [urlEndpoints], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("urlEndpoints")
    @ExcludeMissing
    fun _urlEndpoints(): JsonField<UrlEndpoints> = urlEndpoints

    /**
     * Returns the raw JSON value of [videoProcessing].
     *
     * Unlike [videoProcessing], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("videoProcessing")
    @ExcludeMissing
    fun _videoProcessing(): JsonField<List<VideoProcessing>> = videoProcessing

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UsageAnalyticsResponse].
         *
         * The following fields are required:
         * ```java
         * .bandwidthBytes()
         * .browser()
         * .cache()
         * .country()
         * .device()
         * .endDate()
         * .errorReasons()
         * .extensions()
         * .format()
         * .generatedAt()
         * .requestCount()
         * .startDate()
         * .statusCodes()
         * .top404Assets()
         * .topImages()
         * .topImageTransforms()
         * .topOtherAssets()
         * .topReferrers()
         * .topUserAgents()
         * .topVideos()
         * .topVideoTransforms()
         * .urlEndpoints()
         * .videoProcessing()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UsageAnalyticsResponse]. */
    class Builder internal constructor() {

        private var bandwidthBytes: JsonField<Double>? = null
        private var browser: JsonField<Browser>? = null
        private var cache: JsonField<Cache>? = null
        private var country: JsonField<Country>? = null
        private var device: JsonField<Device>? = null
        private var endDate: JsonField<LocalDate>? = null
        private var errorReasons: JsonField<MutableList<ErrorReason>>? = null
        private var extensions: JsonField<MutableList<Extension>>? = null
        private var format: JsonField<Format>? = null
        private var generatedAt: JsonField<OffsetDateTime>? = null
        private var requestCount: JsonField<Double>? = null
        private var startDate: JsonField<LocalDate>? = null
        private var statusCodes: JsonField<MutableList<StatusCode>>? = null
        private var top404Assets: JsonField<MutableList<Top404Asset>>? = null
        private var topImages: JsonField<TopImages>? = null
        private var topImageTransforms: JsonField<TopImageTransforms>? = null
        private var topOtherAssets: JsonField<TopOtherAssets>? = null
        private var topReferrers: JsonField<TopReferrers>? = null
        private var topUserAgents: JsonField<TopUserAgents>? = null
        private var topVideos: JsonField<TopVideos>? = null
        private var topVideoTransforms: JsonField<TopVideoTransforms>? = null
        private var urlEndpoints: JsonField<UrlEndpoints>? = null
        private var videoProcessing: JsonField<MutableList<VideoProcessing>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(usageAnalyticsResponse: UsageAnalyticsResponse) = apply {
            bandwidthBytes = usageAnalyticsResponse.bandwidthBytes
            browser = usageAnalyticsResponse.browser
            cache = usageAnalyticsResponse.cache
            country = usageAnalyticsResponse.country
            device = usageAnalyticsResponse.device
            endDate = usageAnalyticsResponse.endDate
            errorReasons = usageAnalyticsResponse.errorReasons.map { it.toMutableList() }
            extensions = usageAnalyticsResponse.extensions.map { it.toMutableList() }
            format = usageAnalyticsResponse.format
            generatedAt = usageAnalyticsResponse.generatedAt
            requestCount = usageAnalyticsResponse.requestCount
            startDate = usageAnalyticsResponse.startDate
            statusCodes = usageAnalyticsResponse.statusCodes.map { it.toMutableList() }
            top404Assets = usageAnalyticsResponse.top404Assets.map { it.toMutableList() }
            topImages = usageAnalyticsResponse.topImages
            topImageTransforms = usageAnalyticsResponse.topImageTransforms
            topOtherAssets = usageAnalyticsResponse.topOtherAssets
            topReferrers = usageAnalyticsResponse.topReferrers
            topUserAgents = usageAnalyticsResponse.topUserAgents
            topVideos = usageAnalyticsResponse.topVideos
            topVideoTransforms = usageAnalyticsResponse.topVideoTransforms
            urlEndpoints = usageAnalyticsResponse.urlEndpoints
            videoProcessing = usageAnalyticsResponse.videoProcessing.map { it.toMutableList() }
            additionalProperties = usageAnalyticsResponse.additionalProperties.toMutableMap()
        }

        /** Total bandwidth, in bytes, utilized during the specified date range. */
        fun bandwidthBytes(bandwidthBytes: Double) = bandwidthBytes(JsonField.of(bandwidthBytes))

        /**
         * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
            this.bandwidthBytes = bandwidthBytes
        }

        /** CDN traffic grouped by browser. */
        fun browser(browser: Browser) = browser(JsonField.of(browser))

        /**
         * Sets [Builder.browser] to an arbitrary JSON value.
         *
         * You should usually call [Builder.browser] with a well-typed [Browser] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun browser(browser: JsonField<Browser>) = apply { this.browser = browser }

        /** CDN cache hit, miss and error counts for the date range. */
        fun cache(cache: Cache) = cache(JsonField.of(cache))

        /**
         * Sets [Builder.cache] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cache] with a well-typed [Cache] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cache(cache: JsonField<Cache>) = apply { this.cache = cache }

        /** CDN traffic grouped by country. */
        fun country(country: Country) = country(JsonField.of(country))

        /**
         * Sets [Builder.country] to an arbitrary JSON value.
         *
         * You should usually call [Builder.country] with a well-typed [Country] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun country(country: JsonField<Country>) = apply { this.country = country }

        /**
         * CDN traffic grouped by device and operating system (e.g. `Desktop - Apple Mac`,
         * `Smartphone - Apple iPhone`).
         */
        fun device(device: Device) = device(JsonField.of(device))

        /**
         * Sets [Builder.device] to an arbitrary JSON value.
         *
         * You should usually call [Builder.device] with a well-typed [Device] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun device(device: JsonField<Device>) = apply { this.device = device }

        /** End date of the computed analytics data. */
        fun endDate(endDate: LocalDate) = endDate(JsonField.of(endDate))

        /**
         * Sets [Builder.endDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.endDate] with a well-typed [LocalDate] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun endDate(endDate: JsonField<LocalDate>) = apply { this.endDate = endDate }

        /**
         * Request count grouped by origin error reason. This covers failed origin fetches, such as
         * an asset not found at origin or an origin timeout. It is not the HTTP status code
         * returned to the client, see `statusCodes` for that.
         */
        fun errorReasons(errorReasons: List<ErrorReason>) = errorReasons(JsonField.of(errorReasons))

        /**
         * Sets [Builder.errorReasons] to an arbitrary JSON value.
         *
         * You should usually call [Builder.errorReasons] with a well-typed `List<ErrorReason>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun errorReasons(errorReasons: JsonField<List<ErrorReason>>) = apply {
            this.errorReasons = errorReasons.map { it.toMutableList() }
        }

        /**
         * Adds a single [ErrorReason] to [errorReasons].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addErrorReason(errorReason: ErrorReason) = apply {
            errorReasons =
                (errorReasons ?: JsonField.of(mutableListOf())).also {
                    checkKnown("errorReasons", it).add(errorReason)
                }
        }

        /**
         * Raw per-extension operation counts for the date range. These are raw operation counts,
         * not billable extension units. For billable usage, use the `/v1/accounts/usage` endpoint.
         */
        fun extensions(extensions: List<Extension>) = extensions(JsonField.of(extensions))

        /**
         * Sets [Builder.extensions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.extensions] with a well-typed `List<Extension>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun extensions(extensions: JsonField<List<Extension>>) = apply {
            this.extensions = extensions.map { it.toMutableList() }
        }

        /**
         * Adds a single [Extension] to [extensions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addExtension(extension: Extension) = apply {
            extensions =
                (extensions ?: JsonField.of(mutableListOf())).also {
                    checkKnown("extensions", it).add(extension)
                }
        }

        /** CDN traffic grouped by response `Content-Type`. */
        fun format(format: Format) = format(JsonField.of(format))

        /**
         * Sets [Builder.format] to an arbitrary JSON value.
         *
         * You should usually call [Builder.format] with a well-typed [Format] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun format(format: JsonField<Format>) = apply { this.format = format }

        /**
         * Date and time when the analytics data was computed. Use this to gauge how fresh the
         * returned data is. The date and time is in ISO8601 format.
         */
        fun generatedAt(generatedAt: OffsetDateTime) = generatedAt(JsonField.of(generatedAt))

        /**
         * Sets [Builder.generatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.generatedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun generatedAt(generatedAt: JsonField<OffsetDateTime>) = apply {
            this.generatedAt = generatedAt
        }

        /** Total number of requests made during the specified date range. */
        fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

        /**
         * Sets [Builder.requestCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requestCount] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun requestCount(requestCount: JsonField<Double>) = apply {
            this.requestCount = requestCount
        }

        /** Start date of the computed analytics data. */
        fun startDate(startDate: LocalDate) = startDate(JsonField.of(startDate))

        /**
         * Sets [Builder.startDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.startDate] with a well-typed [LocalDate] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun startDate(startDate: JsonField<LocalDate>) = apply { this.startDate = startDate }

        /** Request count grouped by HTTP status code. */
        fun statusCodes(statusCodes: List<StatusCode>) = statusCodes(JsonField.of(statusCodes))

        /**
         * Sets [Builder.statusCodes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.statusCodes] with a well-typed `List<StatusCode>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun statusCodes(statusCodes: JsonField<List<StatusCode>>) = apply {
            this.statusCodes = statusCodes.map { it.toMutableList() }
        }

        /**
         * Adds a single [StatusCode] to [statusCodes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addStatusCode(statusCode: StatusCode) = apply {
            statusCodes =
                (statusCodes ?: JsonField.of(mutableListOf())).also {
                    checkKnown("statusCodes", it).add(statusCode)
                }
        }

        /** Top URLs that returned a 404 response. */
        fun top404Assets(top404Assets: List<Top404Asset>) = top404Assets(JsonField.of(top404Assets))

        /**
         * Sets [Builder.top404Assets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.top404Assets] with a well-typed `List<Top404Asset>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun top404Assets(top404Assets: JsonField<List<Top404Asset>>) = apply {
            this.top404Assets = top404Assets.map { it.toMutableList() }
        }

        /**
         * Adds a single [Top404Asset] to [top404Assets].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTop404Asset(top404Asset: Top404Asset) = apply {
            top404Assets =
                (top404Assets ?: JsonField.of(mutableListOf())).also {
                    checkKnown("top404Assets", it).add(top404Asset)
                }
        }

        /** Top image assets by traffic. */
        fun topImages(topImages: TopImages) = topImages(JsonField.of(topImages))

        /**
         * Sets [Builder.topImages] to an arbitrary JSON value.
         *
         * You should usually call [Builder.topImages] with a well-typed [TopImages] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun topImages(topImages: JsonField<TopImages>) = apply { this.topImages = topImages }

        /** Top image transformation strings by traffic. */
        fun topImageTransforms(topImageTransforms: TopImageTransforms) =
            topImageTransforms(JsonField.of(topImageTransforms))

        /**
         * Sets [Builder.topImageTransforms] to an arbitrary JSON value.
         *
         * You should usually call [Builder.topImageTransforms] with a well-typed
         * [TopImageTransforms] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun topImageTransforms(topImageTransforms: JsonField<TopImageTransforms>) = apply {
            this.topImageTransforms = topImageTransforms
        }

        /** Top non-image, non-video assets by traffic. */
        fun topOtherAssets(topOtherAssets: TopOtherAssets) =
            topOtherAssets(JsonField.of(topOtherAssets))

        /**
         * Sets [Builder.topOtherAssets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.topOtherAssets] with a well-typed [TopOtherAssets] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun topOtherAssets(topOtherAssets: JsonField<TopOtherAssets>) = apply {
            this.topOtherAssets = topOtherAssets
        }

        /** Top HTTP referrers by traffic. */
        fun topReferrers(topReferrers: TopReferrers) = topReferrers(JsonField.of(topReferrers))

        /**
         * Sets [Builder.topReferrers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.topReferrers] with a well-typed [TopReferrers] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun topReferrers(topReferrers: JsonField<TopReferrers>) = apply {
            this.topReferrers = topReferrers
        }

        /** Top user agents by traffic. */
        fun topUserAgents(topUserAgents: TopUserAgents) = topUserAgents(JsonField.of(topUserAgents))

        /**
         * Sets [Builder.topUserAgents] to an arbitrary JSON value.
         *
         * You should usually call [Builder.topUserAgents] with a well-typed [TopUserAgents] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun topUserAgents(topUserAgents: JsonField<TopUserAgents>) = apply {
            this.topUserAgents = topUserAgents
        }

        /** Top video assets by traffic. */
        fun topVideos(topVideos: TopVideos) = topVideos(JsonField.of(topVideos))

        /**
         * Sets [Builder.topVideos] to an arbitrary JSON value.
         *
         * You should usually call [Builder.topVideos] with a well-typed [TopVideos] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun topVideos(topVideos: JsonField<TopVideos>) = apply { this.topVideos = topVideos }

        /** Top video transformation strings by traffic. */
        fun topVideoTransforms(topVideoTransforms: TopVideoTransforms) =
            topVideoTransforms(JsonField.of(topVideoTransforms))

        /**
         * Sets [Builder.topVideoTransforms] to an arbitrary JSON value.
         *
         * You should usually call [Builder.topVideoTransforms] with a well-typed
         * [TopVideoTransforms] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun topVideoTransforms(topVideoTransforms: JsonField<TopVideoTransforms>) = apply {
            this.topVideoTransforms = topVideoTransforms
        }

        /**
         * CDN traffic grouped by configured URL endpoint. Traffic that does not match any named URL
         * endpoint pattern is grouped under `Default`.
         */
        fun urlEndpoints(urlEndpoints: UrlEndpoints) = urlEndpoints(JsonField.of(urlEndpoints))

        /**
         * Sets [Builder.urlEndpoints] to an arbitrary JSON value.
         *
         * You should usually call [Builder.urlEndpoints] with a well-typed [UrlEndpoints] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun urlEndpoints(urlEndpoints: JsonField<UrlEndpoints>) = apply {
            this.urlEndpoints = urlEndpoints
        }

        /**
         * Raw observed video transcode output duration, in seconds, grouped by resolution and
         * codec. These are raw seconds, not billable Video Processing Units (VPU). For billable VPU
         * totals, use the `/v1/accounts/usage` endpoint.
         */
        fun videoProcessing(videoProcessing: List<VideoProcessing>) =
            videoProcessing(JsonField.of(videoProcessing))

        /**
         * Sets [Builder.videoProcessing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.videoProcessing] with a well-typed
         * `List<VideoProcessing>` value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun videoProcessing(videoProcessing: JsonField<List<VideoProcessing>>) = apply {
            this.videoProcessing = videoProcessing.map { it.toMutableList() }
        }

        /**
         * Adds a single [VideoProcessing] to [Builder.videoProcessing].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addVideoProcessing(videoProcessing: VideoProcessing) = apply {
            this.videoProcessing =
                (this.videoProcessing ?: JsonField.of(mutableListOf())).also {
                    checkKnown("videoProcessing", it).add(videoProcessing)
                }
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [UsageAnalyticsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .bandwidthBytes()
         * .browser()
         * .cache()
         * .country()
         * .device()
         * .endDate()
         * .errorReasons()
         * .extensions()
         * .format()
         * .generatedAt()
         * .requestCount()
         * .startDate()
         * .statusCodes()
         * .top404Assets()
         * .topImages()
         * .topImageTransforms()
         * .topOtherAssets()
         * .topReferrers()
         * .topUserAgents()
         * .topVideos()
         * .topVideoTransforms()
         * .urlEndpoints()
         * .videoProcessing()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UsageAnalyticsResponse =
            UsageAnalyticsResponse(
                checkRequired("bandwidthBytes", bandwidthBytes),
                checkRequired("browser", browser),
                checkRequired("cache", cache),
                checkRequired("country", country),
                checkRequired("device", device),
                checkRequired("endDate", endDate),
                checkRequired("errorReasons", errorReasons).map { it.toImmutable() },
                checkRequired("extensions", extensions).map { it.toImmutable() },
                checkRequired("format", format),
                checkRequired("generatedAt", generatedAt),
                checkRequired("requestCount", requestCount),
                checkRequired("startDate", startDate),
                checkRequired("statusCodes", statusCodes).map { it.toImmutable() },
                checkRequired("top404Assets", top404Assets).map { it.toImmutable() },
                checkRequired("topImages", topImages),
                checkRequired("topImageTransforms", topImageTransforms),
                checkRequired("topOtherAssets", topOtherAssets),
                checkRequired("topReferrers", topReferrers),
                checkRequired("topUserAgents", topUserAgents),
                checkRequired("topVideos", topVideos),
                checkRequired("topVideoTransforms", topVideoTransforms),
                checkRequired("urlEndpoints", urlEndpoints),
                checkRequired("videoProcessing", videoProcessing).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): UsageAnalyticsResponse = apply {
        if (validated) {
            return@apply
        }

        bandwidthBytes()
        browser().validate()
        cache().validate()
        country().validate()
        device().validate()
        endDate()
        errorReasons().forEach { it.validate() }
        extensions().forEach { it.validate() }
        format().validate()
        generatedAt()
        requestCount()
        startDate()
        statusCodes().forEach { it.validate() }
        top404Assets().forEach { it.validate() }
        topImages().validate()
        topImageTransforms().validate()
        topOtherAssets().validate()
        topReferrers().validate()
        topUserAgents().validate()
        topVideos().validate()
        topVideoTransforms().validate()
        urlEndpoints().validate()
        videoProcessing().forEach { it.validate() }
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: ImageKitInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
            (browser.asKnown().getOrNull()?.validity() ?: 0) +
            (cache.asKnown().getOrNull()?.validity() ?: 0) +
            (country.asKnown().getOrNull()?.validity() ?: 0) +
            (device.asKnown().getOrNull()?.validity() ?: 0) +
            (if (endDate.asKnown().isPresent) 1 else 0) +
            (errorReasons.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (extensions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (format.asKnown().getOrNull()?.validity() ?: 0) +
            (if (generatedAt.asKnown().isPresent) 1 else 0) +
            (if (requestCount.asKnown().isPresent) 1 else 0) +
            (if (startDate.asKnown().isPresent) 1 else 0) +
            (statusCodes.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (top404Assets.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (topImages.asKnown().getOrNull()?.validity() ?: 0) +
            (topImageTransforms.asKnown().getOrNull()?.validity() ?: 0) +
            (topOtherAssets.asKnown().getOrNull()?.validity() ?: 0) +
            (topReferrers.asKnown().getOrNull()?.validity() ?: 0) +
            (topUserAgents.asKnown().getOrNull()?.validity() ?: 0) +
            (topVideos.asKnown().getOrNull()?.validity() ?: 0) +
            (topVideoTransforms.asKnown().getOrNull()?.validity() ?: 0) +
            (urlEndpoints.asKnown().getOrNull()?.validity() ?: 0) +
            (videoProcessing.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /** CDN traffic grouped by browser. */
    class Browser
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val byBandwidth: JsonField<List<ByBandwidth>>,
        private val byRequests: JsonField<List<ByRequest>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("byBandwidth")
            @ExcludeMissing
            byBandwidth: JsonField<List<ByBandwidth>> = JsonMissing.of(),
            @JsonProperty("byRequests")
            @ExcludeMissing
            byRequests: JsonField<List<ByRequest>> = JsonMissing.of(),
        ) : this(byBandwidth, byRequests, mutableMapOf())

        /**
         * Top browsers sorted by bandwidth utilized.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byBandwidth(): List<ByBandwidth> = byBandwidth.getRequired("byBandwidth")

        /**
         * Top browsers sorted by request count.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byRequests(): List<ByRequest> = byRequests.getRequired("byRequests")

        /**
         * Returns the raw JSON value of [byBandwidth].
         *
         * Unlike [byBandwidth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byBandwidth")
        @ExcludeMissing
        fun _byBandwidth(): JsonField<List<ByBandwidth>> = byBandwidth

        /**
         * Returns the raw JSON value of [byRequests].
         *
         * Unlike [byRequests], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byRequests")
        @ExcludeMissing
        fun _byRequests(): JsonField<List<ByRequest>> = byRequests

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Browser].
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Browser]. */
        class Builder internal constructor() {

            private var byBandwidth: JsonField<MutableList<ByBandwidth>>? = null
            private var byRequests: JsonField<MutableList<ByRequest>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(browser: Browser) = apply {
                byBandwidth = browser.byBandwidth.map { it.toMutableList() }
                byRequests = browser.byRequests.map { it.toMutableList() }
                additionalProperties = browser.additionalProperties.toMutableMap()
            }

            /** Top browsers sorted by bandwidth utilized. */
            fun byBandwidth(byBandwidth: List<ByBandwidth>) = byBandwidth(JsonField.of(byBandwidth))

            /**
             * Sets [Builder.byBandwidth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byBandwidth] with a well-typed `List<ByBandwidth>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byBandwidth(byBandwidth: JsonField<List<ByBandwidth>>) = apply {
                this.byBandwidth = byBandwidth.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByBandwidth] to [Builder.byBandwidth].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByBandwidth(byBandwidth: ByBandwidth) = apply {
                this.byBandwidth =
                    (this.byBandwidth ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byBandwidth", it).add(byBandwidth)
                    }
            }

            /** Top browsers sorted by request count. */
            fun byRequests(byRequests: List<ByRequest>) = byRequests(JsonField.of(byRequests))

            /**
             * Sets [Builder.byRequests] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byRequests] with a well-typed `List<ByRequest>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byRequests(byRequests: JsonField<List<ByRequest>>) = apply {
                this.byRequests = byRequests.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByRequest] to [byRequests].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByRequest(byRequest: ByRequest) = apply {
                byRequests =
                    (byRequests ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byRequests", it).add(byRequest)
                    }
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Browser].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Browser =
                Browser(
                    checkRequired("byBandwidth", byBandwidth).map { it.toImmutable() },
                    checkRequired("byRequests", byRequests).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Browser = apply {
            if (validated) {
                return@apply
            }

            byBandwidth().forEach { it.validate() }
            byRequests().forEach { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (byBandwidth.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (byRequests.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class ByBandwidth
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * Browser name (e.g. `Chrome`).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByBandwidth].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByBandwidth]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byBandwidth: ByBandwidth) = apply {
                    bandwidthBytes = byBandwidth.bandwidthBytes
                    requestCount = byBandwidth.requestCount
                    name = byBandwidth.name
                    additionalProperties = byBandwidth.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** Browser name (e.g. `Chrome`). */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByBandwidth].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByBandwidth =
                    ByBandwidth(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByBandwidth = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByBandwidth &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByBandwidth{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        class ByRequest
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * Browser name (e.g. `Chrome`).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByRequest].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByRequest]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byRequest: ByRequest) = apply {
                    bandwidthBytes = byRequest.bandwidthBytes
                    requestCount = byRequest.requestCount
                    name = byRequest.name
                    additionalProperties = byRequest.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** Browser name (e.g. `Chrome`). */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByRequest].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByRequest =
                    ByRequest(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByRequest = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByRequest &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByRequest{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Browser &&
                byBandwidth == other.byBandwidth &&
                byRequests == other.byRequests &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(byBandwidth, byRequests, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Browser{byBandwidth=$byBandwidth, byRequests=$byRequests, additionalProperties=$additionalProperties}"
    }

    /** CDN cache hit, miss and error counts for the date range. */
    class Cache
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val errorCount: JsonField<Double>,
        private val hitCount: JsonField<Double>,
        private val missCount: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("errorCount")
            @ExcludeMissing
            errorCount: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("hitCount")
            @ExcludeMissing
            hitCount: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("missCount")
            @ExcludeMissing
            missCount: JsonField<Double> = JsonMissing.of(),
        ) : this(errorCount, hitCount, missCount, mutableMapOf())

        /**
         * Number of requests where the CDN encountered a cache error or exceeded capacity while
         * serving the response.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun errorCount(): Double = errorCount.getRequired("errorCount")

        /**
         * Number of requests served from cache, including full hits and revalidated hits.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun hitCount(): Double = hitCount.getRequired("hitCount")

        /**
         * Number of requests that were not found in cache and had to be fetched from origin.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun missCount(): Double = missCount.getRequired("missCount")

        /**
         * Returns the raw JSON value of [errorCount].
         *
         * Unlike [errorCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("errorCount")
        @ExcludeMissing
        fun _errorCount(): JsonField<Double> = errorCount

        /**
         * Returns the raw JSON value of [hitCount].
         *
         * Unlike [hitCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("hitCount") @ExcludeMissing fun _hitCount(): JsonField<Double> = hitCount

        /**
         * Returns the raw JSON value of [missCount].
         *
         * Unlike [missCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("missCount") @ExcludeMissing fun _missCount(): JsonField<Double> = missCount

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Cache].
             *
             * The following fields are required:
             * ```java
             * .errorCount()
             * .hitCount()
             * .missCount()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Cache]. */
        class Builder internal constructor() {

            private var errorCount: JsonField<Double>? = null
            private var hitCount: JsonField<Double>? = null
            private var missCount: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(cache: Cache) = apply {
                errorCount = cache.errorCount
                hitCount = cache.hitCount
                missCount = cache.missCount
                additionalProperties = cache.additionalProperties.toMutableMap()
            }

            /**
             * Number of requests where the CDN encountered a cache error or exceeded capacity while
             * serving the response.
             */
            fun errorCount(errorCount: Double) = errorCount(JsonField.of(errorCount))

            /**
             * Sets [Builder.errorCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.errorCount] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun errorCount(errorCount: JsonField<Double>) = apply { this.errorCount = errorCount }

            /** Number of requests served from cache, including full hits and revalidated hits. */
            fun hitCount(hitCount: Double) = hitCount(JsonField.of(hitCount))

            /**
             * Sets [Builder.hitCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hitCount] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hitCount(hitCount: JsonField<Double>) = apply { this.hitCount = hitCount }

            /**
             * Number of requests that were not found in cache and had to be fetched from origin.
             */
            fun missCount(missCount: Double) = missCount(JsonField.of(missCount))

            /**
             * Sets [Builder.missCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.missCount] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun missCount(missCount: JsonField<Double>) = apply { this.missCount = missCount }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Cache].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .errorCount()
             * .hitCount()
             * .missCount()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Cache =
                Cache(
                    checkRequired("errorCount", errorCount),
                    checkRequired("hitCount", hitCount),
                    checkRequired("missCount", missCount),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Cache = apply {
            if (validated) {
                return@apply
            }

            errorCount()
            hitCount()
            missCount()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (errorCount.asKnown().isPresent) 1 else 0) +
                (if (hitCount.asKnown().isPresent) 1 else 0) +
                (if (missCount.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Cache &&
                errorCount == other.errorCount &&
                hitCount == other.hitCount &&
                missCount == other.missCount &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(errorCount, hitCount, missCount, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Cache{errorCount=$errorCount, hitCount=$hitCount, missCount=$missCount, additionalProperties=$additionalProperties}"
    }

    /** CDN traffic grouped by country. */
    class Country
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val byBandwidth: JsonField<List<ByBandwidth>>,
        private val byRequests: JsonField<List<ByRequest>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("byBandwidth")
            @ExcludeMissing
            byBandwidth: JsonField<List<ByBandwidth>> = JsonMissing.of(),
            @JsonProperty("byRequests")
            @ExcludeMissing
            byRequests: JsonField<List<ByRequest>> = JsonMissing.of(),
        ) : this(byBandwidth, byRequests, mutableMapOf())

        /**
         * Top requesting countries sorted by total bandwidth utilized.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byBandwidth(): List<ByBandwidth> = byBandwidth.getRequired("byBandwidth")

        /**
         * Top requesting countries sorted by request count.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byRequests(): List<ByRequest> = byRequests.getRequired("byRequests")

        /**
         * Returns the raw JSON value of [byBandwidth].
         *
         * Unlike [byBandwidth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byBandwidth")
        @ExcludeMissing
        fun _byBandwidth(): JsonField<List<ByBandwidth>> = byBandwidth

        /**
         * Returns the raw JSON value of [byRequests].
         *
         * Unlike [byRequests], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byRequests")
        @ExcludeMissing
        fun _byRequests(): JsonField<List<ByRequest>> = byRequests

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Country].
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Country]. */
        class Builder internal constructor() {

            private var byBandwidth: JsonField<MutableList<ByBandwidth>>? = null
            private var byRequests: JsonField<MutableList<ByRequest>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(country: Country) = apply {
                byBandwidth = country.byBandwidth.map { it.toMutableList() }
                byRequests = country.byRequests.map { it.toMutableList() }
                additionalProperties = country.additionalProperties.toMutableMap()
            }

            /** Top requesting countries sorted by total bandwidth utilized. */
            fun byBandwidth(byBandwidth: List<ByBandwidth>) = byBandwidth(JsonField.of(byBandwidth))

            /**
             * Sets [Builder.byBandwidth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byBandwidth] with a well-typed `List<ByBandwidth>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byBandwidth(byBandwidth: JsonField<List<ByBandwidth>>) = apply {
                this.byBandwidth = byBandwidth.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByBandwidth] to [Builder.byBandwidth].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByBandwidth(byBandwidth: ByBandwidth) = apply {
                this.byBandwidth =
                    (this.byBandwidth ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byBandwidth", it).add(byBandwidth)
                    }
            }

            /** Top requesting countries sorted by request count. */
            fun byRequests(byRequests: List<ByRequest>) = byRequests(JsonField.of(byRequests))

            /**
             * Sets [Builder.byRequests] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byRequests] with a well-typed `List<ByRequest>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byRequests(byRequests: JsonField<List<ByRequest>>) = apply {
                this.byRequests = byRequests.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByRequest] to [byRequests].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByRequest(byRequest: ByRequest) = apply {
                byRequests =
                    (byRequests ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byRequests", it).add(byRequest)
                    }
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Country].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Country =
                Country(
                    checkRequired("byBandwidth", byBandwidth).map { it.toImmutable() },
                    checkRequired("byRequests", byRequests).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Country = apply {
            if (validated) {
                return@apply
            }

            byBandwidth().forEach { it.validate() }
            byRequests().forEach { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (byBandwidth.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (byRequests.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class ByBandwidth
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val code: JsonField<String>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("code") @ExcludeMissing code: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, code, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * ISO country code.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun code(): String = code.getRequired("code")

            /**
             * Country name.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [code].
             *
             * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByBandwidth].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .code()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByBandwidth]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var code: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byBandwidth: ByBandwidth) = apply {
                    bandwidthBytes = byBandwidth.bandwidthBytes
                    requestCount = byBandwidth.requestCount
                    code = byBandwidth.code
                    name = byBandwidth.name
                    additionalProperties = byBandwidth.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** ISO country code. */
                fun code(code: String) = code(JsonField.of(code))

                /**
                 * Sets [Builder.code] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.code] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun code(code: JsonField<String>) = apply { this.code = code }

                /** Country name. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByBandwidth].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .code()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByBandwidth =
                    ByBandwidth(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("code", code),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByBandwidth = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                code()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (code.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByBandwidth &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    code == other.code &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, code, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByBandwidth{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, code=$code, name=$name, additionalProperties=$additionalProperties}"
        }

        class ByRequest
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val code: JsonField<String>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("code") @ExcludeMissing code: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, code, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * ISO country code.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun code(): String = code.getRequired("code")

            /**
             * Country name.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [code].
             *
             * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByRequest].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .code()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByRequest]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var code: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byRequest: ByRequest) = apply {
                    bandwidthBytes = byRequest.bandwidthBytes
                    requestCount = byRequest.requestCount
                    code = byRequest.code
                    name = byRequest.name
                    additionalProperties = byRequest.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** ISO country code. */
                fun code(code: String) = code(JsonField.of(code))

                /**
                 * Sets [Builder.code] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.code] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun code(code: JsonField<String>) = apply { this.code = code }

                /** Country name. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByRequest].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .code()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByRequest =
                    ByRequest(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("code", code),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByRequest = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                code()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (code.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByRequest &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    code == other.code &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, code, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByRequest{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, code=$code, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Country &&
                byBandwidth == other.byBandwidth &&
                byRequests == other.byRequests &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(byBandwidth, byRequests, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Country{byBandwidth=$byBandwidth, byRequests=$byRequests, additionalProperties=$additionalProperties}"
    }

    /**
     * CDN traffic grouped by device and operating system (e.g. `Desktop - Apple Mac`, `Smartphone -
     * Apple iPhone`).
     */
    class Device
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val byBandwidth: JsonField<List<ByBandwidth>>,
        private val byRequests: JsonField<List<ByRequest>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("byBandwidth")
            @ExcludeMissing
            byBandwidth: JsonField<List<ByBandwidth>> = JsonMissing.of(),
            @JsonProperty("byRequests")
            @ExcludeMissing
            byRequests: JsonField<List<ByRequest>> = JsonMissing.of(),
        ) : this(byBandwidth, byRequests, mutableMapOf())

        /**
         * Top device/OS combinations sorted by bandwidth utilized.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byBandwidth(): List<ByBandwidth> = byBandwidth.getRequired("byBandwidth")

        /**
         * Top device/OS combinations sorted by request count.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byRequests(): List<ByRequest> = byRequests.getRequired("byRequests")

        /**
         * Returns the raw JSON value of [byBandwidth].
         *
         * Unlike [byBandwidth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byBandwidth")
        @ExcludeMissing
        fun _byBandwidth(): JsonField<List<ByBandwidth>> = byBandwidth

        /**
         * Returns the raw JSON value of [byRequests].
         *
         * Unlike [byRequests], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byRequests")
        @ExcludeMissing
        fun _byRequests(): JsonField<List<ByRequest>> = byRequests

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Device].
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Device]. */
        class Builder internal constructor() {

            private var byBandwidth: JsonField<MutableList<ByBandwidth>>? = null
            private var byRequests: JsonField<MutableList<ByRequest>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(device: Device) = apply {
                byBandwidth = device.byBandwidth.map { it.toMutableList() }
                byRequests = device.byRequests.map { it.toMutableList() }
                additionalProperties = device.additionalProperties.toMutableMap()
            }

            /** Top device/OS combinations sorted by bandwidth utilized. */
            fun byBandwidth(byBandwidth: List<ByBandwidth>) = byBandwidth(JsonField.of(byBandwidth))

            /**
             * Sets [Builder.byBandwidth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byBandwidth] with a well-typed `List<ByBandwidth>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byBandwidth(byBandwidth: JsonField<List<ByBandwidth>>) = apply {
                this.byBandwidth = byBandwidth.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByBandwidth] to [Builder.byBandwidth].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByBandwidth(byBandwidth: ByBandwidth) = apply {
                this.byBandwidth =
                    (this.byBandwidth ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byBandwidth", it).add(byBandwidth)
                    }
            }

            /** Top device/OS combinations sorted by request count. */
            fun byRequests(byRequests: List<ByRequest>) = byRequests(JsonField.of(byRequests))

            /**
             * Sets [Builder.byRequests] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byRequests] with a well-typed `List<ByRequest>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byRequests(byRequests: JsonField<List<ByRequest>>) = apply {
                this.byRequests = byRequests.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByRequest] to [byRequests].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByRequest(byRequest: ByRequest) = apply {
                byRequests =
                    (byRequests ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byRequests", it).add(byRequest)
                    }
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Device].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Device =
                Device(
                    checkRequired("byBandwidth", byBandwidth).map { it.toImmutable() },
                    checkRequired("byRequests", byRequests).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Device = apply {
            if (validated) {
                return@apply
            }

            byBandwidth().forEach { it.validate() }
            byRequests().forEach { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (byBandwidth.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (byRequests.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class ByBandwidth
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * Device category combined with operating system or vendor (e.g. `Desktop - Windows
             * PC`).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByBandwidth].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByBandwidth]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byBandwidth: ByBandwidth) = apply {
                    bandwidthBytes = byBandwidth.bandwidthBytes
                    requestCount = byBandwidth.requestCount
                    name = byBandwidth.name
                    additionalProperties = byBandwidth.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /**
                 * Device category combined with operating system or vendor (e.g. `Desktop - Windows
                 * PC`).
                 */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByBandwidth].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByBandwidth =
                    ByBandwidth(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByBandwidth = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByBandwidth &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByBandwidth{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        class ByRequest
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * Device category combined with operating system or vendor (e.g. `Desktop - Windows
             * PC`).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByRequest].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByRequest]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byRequest: ByRequest) = apply {
                    bandwidthBytes = byRequest.bandwidthBytes
                    requestCount = byRequest.requestCount
                    name = byRequest.name
                    additionalProperties = byRequest.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /**
                 * Device category combined with operating system or vendor (e.g. `Desktop - Windows
                 * PC`).
                 */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByRequest].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByRequest =
                    ByRequest(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByRequest = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByRequest &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByRequest{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Device &&
                byBandwidth == other.byBandwidth &&
                byRequests == other.byRequests &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(byBandwidth, byRequests, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Device{byBandwidth=$byBandwidth, byRequests=$byRequests, additionalProperties=$additionalProperties}"
    }

    class ErrorReason
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val name: JsonField<String>,
        private val requestCount: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("requestCount")
            @ExcludeMissing
            requestCount: JsonField<Double> = JsonMissing.of(),
        ) : this(name, requestCount, mutableMapOf())

        /**
         * Description of the error reason.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Number of requests that failed with this error reason.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun requestCount(): Double = requestCount.getRequired("requestCount")

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [requestCount].
         *
         * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("requestCount")
        @ExcludeMissing
        fun _requestCount(): JsonField<Double> = requestCount

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ErrorReason].
             *
             * The following fields are required:
             * ```java
             * .name()
             * .requestCount()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ErrorReason]. */
        class Builder internal constructor() {

            private var name: JsonField<String>? = null
            private var requestCount: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(errorReason: ErrorReason) = apply {
                name = errorReason.name
                requestCount = errorReason.requestCount
                additionalProperties = errorReason.additionalProperties.toMutableMap()
            }

            /** Description of the error reason. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Number of requests that failed with this error reason. */
            fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

            /**
             * Sets [Builder.requestCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requestCount] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun requestCount(requestCount: JsonField<Double>) = apply {
                this.requestCount = requestCount
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [ErrorReason].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .name()
             * .requestCount()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ErrorReason =
                ErrorReason(
                    checkRequired("name", name),
                    checkRequired("requestCount", requestCount),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): ErrorReason = apply {
            if (validated) {
                return@apply
            }

            name()
            requestCount()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (name.asKnown().isPresent) 1 else 0) +
                (if (requestCount.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ErrorReason &&
                name == other.name &&
                requestCount == other.requestCount &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(name, requestCount, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ErrorReason{name=$name, requestCount=$requestCount, additionalProperties=$additionalProperties}"
    }

    class Extension
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val name: JsonField<String>,
        private val operationCount: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("operationCount")
            @ExcludeMissing
            operationCount: JsonField<Double> = JsonMissing.of(),
        ) : this(name, operationCount, mutableMapOf())

        /**
         * Extension identifier.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Number of times this extension ran during the date range.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun operationCount(): Double = operationCount.getRequired("operationCount")

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [operationCount].
         *
         * Unlike [operationCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("operationCount")
        @ExcludeMissing
        fun _operationCount(): JsonField<Double> = operationCount

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Extension].
             *
             * The following fields are required:
             * ```java
             * .name()
             * .operationCount()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Extension]. */
        class Builder internal constructor() {

            private var name: JsonField<String>? = null
            private var operationCount: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(extension: Extension) = apply {
                name = extension.name
                operationCount = extension.operationCount
                additionalProperties = extension.additionalProperties.toMutableMap()
            }

            /** Extension identifier. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Number of times this extension ran during the date range. */
            fun operationCount(operationCount: Double) =
                operationCount(JsonField.of(operationCount))

            /**
             * Sets [Builder.operationCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.operationCount] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun operationCount(operationCount: JsonField<Double>) = apply {
                this.operationCount = operationCount
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Extension].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .name()
             * .operationCount()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Extension =
                Extension(
                    checkRequired("name", name),
                    checkRequired("operationCount", operationCount),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Extension = apply {
            if (validated) {
                return@apply
            }

            name()
            operationCount()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (name.asKnown().isPresent) 1 else 0) +
                (if (operationCount.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Extension &&
                name == other.name &&
                operationCount == other.operationCount &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(name, operationCount, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Extension{name=$name, operationCount=$operationCount, additionalProperties=$additionalProperties}"
    }

    /** CDN traffic grouped by response `Content-Type`. */
    class Format
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val byBandwidth: JsonField<List<ByBandwidth>>,
        private val byRequests: JsonField<List<ByRequest>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("byBandwidth")
            @ExcludeMissing
            byBandwidth: JsonField<List<ByBandwidth>> = JsonMissing.of(),
            @JsonProperty("byRequests")
            @ExcludeMissing
            byRequests: JsonField<List<ByRequest>> = JsonMissing.of(),
        ) : this(byBandwidth, byRequests, mutableMapOf())

        /**
         * Top content types sorted by bandwidth utilized.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byBandwidth(): List<ByBandwidth> = byBandwidth.getRequired("byBandwidth")

        /**
         * Top content types sorted by request count.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byRequests(): List<ByRequest> = byRequests.getRequired("byRequests")

        /**
         * Returns the raw JSON value of [byBandwidth].
         *
         * Unlike [byBandwidth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byBandwidth")
        @ExcludeMissing
        fun _byBandwidth(): JsonField<List<ByBandwidth>> = byBandwidth

        /**
         * Returns the raw JSON value of [byRequests].
         *
         * Unlike [byRequests], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byRequests")
        @ExcludeMissing
        fun _byRequests(): JsonField<List<ByRequest>> = byRequests

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Format].
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Format]. */
        class Builder internal constructor() {

            private var byBandwidth: JsonField<MutableList<ByBandwidth>>? = null
            private var byRequests: JsonField<MutableList<ByRequest>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(format: Format) = apply {
                byBandwidth = format.byBandwidth.map { it.toMutableList() }
                byRequests = format.byRequests.map { it.toMutableList() }
                additionalProperties = format.additionalProperties.toMutableMap()
            }

            /** Top content types sorted by bandwidth utilized. */
            fun byBandwidth(byBandwidth: List<ByBandwidth>) = byBandwidth(JsonField.of(byBandwidth))

            /**
             * Sets [Builder.byBandwidth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byBandwidth] with a well-typed `List<ByBandwidth>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byBandwidth(byBandwidth: JsonField<List<ByBandwidth>>) = apply {
                this.byBandwidth = byBandwidth.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByBandwidth] to [Builder.byBandwidth].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByBandwidth(byBandwidth: ByBandwidth) = apply {
                this.byBandwidth =
                    (this.byBandwidth ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byBandwidth", it).add(byBandwidth)
                    }
            }

            /** Top content types sorted by request count. */
            fun byRequests(byRequests: List<ByRequest>) = byRequests(JsonField.of(byRequests))

            /**
             * Sets [Builder.byRequests] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byRequests] with a well-typed `List<ByRequest>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byRequests(byRequests: JsonField<List<ByRequest>>) = apply {
                this.byRequests = byRequests.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByRequest] to [byRequests].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByRequest(byRequest: ByRequest) = apply {
                byRequests =
                    (byRequests ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byRequests", it).add(byRequest)
                    }
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Format].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Format =
                Format(
                    checkRequired("byBandwidth", byBandwidth).map { it.toImmutable() },
                    checkRequired("byRequests", byRequests).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Format = apply {
            if (validated) {
                return@apply
            }

            byBandwidth().forEach { it.validate() }
            byRequests().forEach { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (byBandwidth.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (byRequests.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class ByBandwidth
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * MIME type (e.g. `image/webp`).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByBandwidth].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByBandwidth]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byBandwidth: ByBandwidth) = apply {
                    bandwidthBytes = byBandwidth.bandwidthBytes
                    requestCount = byBandwidth.requestCount
                    name = byBandwidth.name
                    additionalProperties = byBandwidth.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** MIME type (e.g. `image/webp`). */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByBandwidth].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByBandwidth =
                    ByBandwidth(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByBandwidth = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByBandwidth &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByBandwidth{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        class ByRequest
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * MIME type (e.g. `image/webp`).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByRequest].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByRequest]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byRequest: ByRequest) = apply {
                    bandwidthBytes = byRequest.bandwidthBytes
                    requestCount = byRequest.requestCount
                    name = byRequest.name
                    additionalProperties = byRequest.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** MIME type (e.g. `image/webp`). */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByRequest].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByRequest =
                    ByRequest(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByRequest = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByRequest &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByRequest{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Format &&
                byBandwidth == other.byBandwidth &&
                byRequests == other.byRequests &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(byBandwidth, byRequests, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Format{byBandwidth=$byBandwidth, byRequests=$byRequests, additionalProperties=$additionalProperties}"
    }

    class StatusCode
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val name: JsonField<String>,
        private val requestCount: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("requestCount")
            @ExcludeMissing
            requestCount: JsonField<Double> = JsonMissing.of(),
        ) : this(name, requestCount, mutableMapOf())

        /**
         * HTTP status code.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Number of requests that received this status code.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun requestCount(): Double = requestCount.getRequired("requestCount")

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [requestCount].
         *
         * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("requestCount")
        @ExcludeMissing
        fun _requestCount(): JsonField<Double> = requestCount

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [StatusCode].
             *
             * The following fields are required:
             * ```java
             * .name()
             * .requestCount()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [StatusCode]. */
        class Builder internal constructor() {

            private var name: JsonField<String>? = null
            private var requestCount: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(statusCode: StatusCode) = apply {
                name = statusCode.name
                requestCount = statusCode.requestCount
                additionalProperties = statusCode.additionalProperties.toMutableMap()
            }

            /** HTTP status code. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Number of requests that received this status code. */
            fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

            /**
             * Sets [Builder.requestCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requestCount] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun requestCount(requestCount: JsonField<Double>) = apply {
                this.requestCount = requestCount
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [StatusCode].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .name()
             * .requestCount()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): StatusCode =
                StatusCode(
                    checkRequired("name", name),
                    checkRequired("requestCount", requestCount),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): StatusCode = apply {
            if (validated) {
                return@apply
            }

            name()
            requestCount()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (name.asKnown().isPresent) 1 else 0) +
                (if (requestCount.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is StatusCode &&
                name == other.name &&
                requestCount == other.requestCount &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(name, requestCount, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "StatusCode{name=$name, requestCount=$requestCount, additionalProperties=$additionalProperties}"
    }

    class Top404Asset
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val name: JsonField<String>,
        private val requestCount: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("requestCount")
            @ExcludeMissing
            requestCount: JsonField<Double> = JsonMissing.of(),
        ) : this(name, requestCount, mutableMapOf())

        /**
         * URL that returned a 404 response.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Number of requests to this URL that returned a 404 response.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun requestCount(): Double = requestCount.getRequired("requestCount")

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [requestCount].
         *
         * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("requestCount")
        @ExcludeMissing
        fun _requestCount(): JsonField<Double> = requestCount

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Top404Asset].
             *
             * The following fields are required:
             * ```java
             * .name()
             * .requestCount()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Top404Asset]. */
        class Builder internal constructor() {

            private var name: JsonField<String>? = null
            private var requestCount: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(top404Asset: Top404Asset) = apply {
                name = top404Asset.name
                requestCount = top404Asset.requestCount
                additionalProperties = top404Asset.additionalProperties.toMutableMap()
            }

            /** URL that returned a 404 response. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Number of requests to this URL that returned a 404 response. */
            fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

            /**
             * Sets [Builder.requestCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requestCount] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun requestCount(requestCount: JsonField<Double>) = apply {
                this.requestCount = requestCount
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Top404Asset].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .name()
             * .requestCount()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Top404Asset =
                Top404Asset(
                    checkRequired("name", name),
                    checkRequired("requestCount", requestCount),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Top404Asset = apply {
            if (validated) {
                return@apply
            }

            name()
            requestCount()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (name.asKnown().isPresent) 1 else 0) +
                (if (requestCount.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Top404Asset &&
                name == other.name &&
                requestCount == other.requestCount &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(name, requestCount, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Top404Asset{name=$name, requestCount=$requestCount, additionalProperties=$additionalProperties}"
    }

    /** Top image assets by traffic. */
    class TopImages
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val byBandwidth: JsonField<List<ByBandwidth>>,
        private val byRequests: JsonField<List<ByRequest>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("byBandwidth")
            @ExcludeMissing
            byBandwidth: JsonField<List<ByBandwidth>> = JsonMissing.of(),
            @JsonProperty("byRequests")
            @ExcludeMissing
            byRequests: JsonField<List<ByRequest>> = JsonMissing.of(),
        ) : this(byBandwidth, byRequests, mutableMapOf())

        /**
         * Top image assets sorted by bandwidth utilized.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byBandwidth(): List<ByBandwidth> = byBandwidth.getRequired("byBandwidth")

        /**
         * Top image assets sorted by request count.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byRequests(): List<ByRequest> = byRequests.getRequired("byRequests")

        /**
         * Returns the raw JSON value of [byBandwidth].
         *
         * Unlike [byBandwidth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byBandwidth")
        @ExcludeMissing
        fun _byBandwidth(): JsonField<List<ByBandwidth>> = byBandwidth

        /**
         * Returns the raw JSON value of [byRequests].
         *
         * Unlike [byRequests], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byRequests")
        @ExcludeMissing
        fun _byRequests(): JsonField<List<ByRequest>> = byRequests

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [TopImages].
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TopImages]. */
        class Builder internal constructor() {

            private var byBandwidth: JsonField<MutableList<ByBandwidth>>? = null
            private var byRequests: JsonField<MutableList<ByRequest>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(topImages: TopImages) = apply {
                byBandwidth = topImages.byBandwidth.map { it.toMutableList() }
                byRequests = topImages.byRequests.map { it.toMutableList() }
                additionalProperties = topImages.additionalProperties.toMutableMap()
            }

            /** Top image assets sorted by bandwidth utilized. */
            fun byBandwidth(byBandwidth: List<ByBandwidth>) = byBandwidth(JsonField.of(byBandwidth))

            /**
             * Sets [Builder.byBandwidth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byBandwidth] with a well-typed `List<ByBandwidth>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byBandwidth(byBandwidth: JsonField<List<ByBandwidth>>) = apply {
                this.byBandwidth = byBandwidth.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByBandwidth] to [Builder.byBandwidth].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByBandwidth(byBandwidth: ByBandwidth) = apply {
                this.byBandwidth =
                    (this.byBandwidth ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byBandwidth", it).add(byBandwidth)
                    }
            }

            /** Top image assets sorted by request count. */
            fun byRequests(byRequests: List<ByRequest>) = byRequests(JsonField.of(byRequests))

            /**
             * Sets [Builder.byRequests] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byRequests] with a well-typed `List<ByRequest>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byRequests(byRequests: JsonField<List<ByRequest>>) = apply {
                this.byRequests = byRequests.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByRequest] to [byRequests].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByRequest(byRequest: ByRequest) = apply {
                byRequests =
                    (byRequests ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byRequests", it).add(byRequest)
                    }
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [TopImages].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): TopImages =
                TopImages(
                    checkRequired("byBandwidth", byBandwidth).map { it.toImmutable() },
                    checkRequired("byRequests", byRequests).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): TopImages = apply {
            if (validated) {
                return@apply
            }

            byBandwidth().forEach { it.validate() }
            byRequests().forEach { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (byBandwidth.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (byRequests.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class ByBandwidth
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * URL of the image asset.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByBandwidth].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByBandwidth]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byBandwidth: ByBandwidth) = apply {
                    bandwidthBytes = byBandwidth.bandwidthBytes
                    requestCount = byBandwidth.requestCount
                    name = byBandwidth.name
                    additionalProperties = byBandwidth.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** URL of the image asset. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByBandwidth].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByBandwidth =
                    ByBandwidth(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByBandwidth = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByBandwidth &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByBandwidth{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        class ByRequest
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * URL of the image asset.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByRequest].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByRequest]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byRequest: ByRequest) = apply {
                    bandwidthBytes = byRequest.bandwidthBytes
                    requestCount = byRequest.requestCount
                    name = byRequest.name
                    additionalProperties = byRequest.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** URL of the image asset. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByRequest].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByRequest =
                    ByRequest(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByRequest = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByRequest &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByRequest{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TopImages &&
                byBandwidth == other.byBandwidth &&
                byRequests == other.byRequests &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(byBandwidth, byRequests, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TopImages{byBandwidth=$byBandwidth, byRequests=$byRequests, additionalProperties=$additionalProperties}"
    }

    /** Top image transformation strings by traffic. */
    class TopImageTransforms
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val byBandwidth: JsonField<List<ByBandwidth>>,
        private val byRequests: JsonField<List<ByRequest>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("byBandwidth")
            @ExcludeMissing
            byBandwidth: JsonField<List<ByBandwidth>> = JsonMissing.of(),
            @JsonProperty("byRequests")
            @ExcludeMissing
            byRequests: JsonField<List<ByRequest>> = JsonMissing.of(),
        ) : this(byBandwidth, byRequests, mutableMapOf())

        /**
         * Top image transformation strings sorted by bandwidth utilized.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byBandwidth(): List<ByBandwidth> = byBandwidth.getRequired("byBandwidth")

        /**
         * Top image transformation strings sorted by request count.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byRequests(): List<ByRequest> = byRequests.getRequired("byRequests")

        /**
         * Returns the raw JSON value of [byBandwidth].
         *
         * Unlike [byBandwidth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byBandwidth")
        @ExcludeMissing
        fun _byBandwidth(): JsonField<List<ByBandwidth>> = byBandwidth

        /**
         * Returns the raw JSON value of [byRequests].
         *
         * Unlike [byRequests], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byRequests")
        @ExcludeMissing
        fun _byRequests(): JsonField<List<ByRequest>> = byRequests

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [TopImageTransforms].
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TopImageTransforms]. */
        class Builder internal constructor() {

            private var byBandwidth: JsonField<MutableList<ByBandwidth>>? = null
            private var byRequests: JsonField<MutableList<ByRequest>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(topImageTransforms: TopImageTransforms) = apply {
                byBandwidth = topImageTransforms.byBandwidth.map { it.toMutableList() }
                byRequests = topImageTransforms.byRequests.map { it.toMutableList() }
                additionalProperties = topImageTransforms.additionalProperties.toMutableMap()
            }

            /** Top image transformation strings sorted by bandwidth utilized. */
            fun byBandwidth(byBandwidth: List<ByBandwidth>) = byBandwidth(JsonField.of(byBandwidth))

            /**
             * Sets [Builder.byBandwidth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byBandwidth] with a well-typed `List<ByBandwidth>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byBandwidth(byBandwidth: JsonField<List<ByBandwidth>>) = apply {
                this.byBandwidth = byBandwidth.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByBandwidth] to [Builder.byBandwidth].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByBandwidth(byBandwidth: ByBandwidth) = apply {
                this.byBandwidth =
                    (this.byBandwidth ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byBandwidth", it).add(byBandwidth)
                    }
            }

            /** Top image transformation strings sorted by request count. */
            fun byRequests(byRequests: List<ByRequest>) = byRequests(JsonField.of(byRequests))

            /**
             * Sets [Builder.byRequests] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byRequests] with a well-typed `List<ByRequest>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byRequests(byRequests: JsonField<List<ByRequest>>) = apply {
                this.byRequests = byRequests.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByRequest] to [byRequests].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByRequest(byRequest: ByRequest) = apply {
                byRequests =
                    (byRequests ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byRequests", it).add(byRequest)
                    }
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [TopImageTransforms].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): TopImageTransforms =
                TopImageTransforms(
                    checkRequired("byBandwidth", byBandwidth).map { it.toImmutable() },
                    checkRequired("byRequests", byRequests).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): TopImageTransforms = apply {
            if (validated) {
                return@apply
            }

            byBandwidth().forEach { it.validate() }
            byRequests().forEach { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (byBandwidth.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (byRequests.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class ByBandwidth
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * Image transformation string (e.g. `tr:w-400,h-400`).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByBandwidth].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByBandwidth]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byBandwidth: ByBandwidth) = apply {
                    bandwidthBytes = byBandwidth.bandwidthBytes
                    requestCount = byBandwidth.requestCount
                    name = byBandwidth.name
                    additionalProperties = byBandwidth.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** Image transformation string (e.g. `tr:w-400,h-400`). */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByBandwidth].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByBandwidth =
                    ByBandwidth(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByBandwidth = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByBandwidth &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByBandwidth{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        class ByRequest
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * Image transformation string (e.g. `tr:w-400,h-400`).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByRequest].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByRequest]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byRequest: ByRequest) = apply {
                    bandwidthBytes = byRequest.bandwidthBytes
                    requestCount = byRequest.requestCount
                    name = byRequest.name
                    additionalProperties = byRequest.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** Image transformation string (e.g. `tr:w-400,h-400`). */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByRequest].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByRequest =
                    ByRequest(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByRequest = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByRequest &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByRequest{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TopImageTransforms &&
                byBandwidth == other.byBandwidth &&
                byRequests == other.byRequests &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(byBandwidth, byRequests, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TopImageTransforms{byBandwidth=$byBandwidth, byRequests=$byRequests, additionalProperties=$additionalProperties}"
    }

    /** Top non-image, non-video assets by traffic. */
    class TopOtherAssets
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val byBandwidth: JsonField<List<ByBandwidth>>,
        private val byRequests: JsonField<List<ByRequest>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("byBandwidth")
            @ExcludeMissing
            byBandwidth: JsonField<List<ByBandwidth>> = JsonMissing.of(),
            @JsonProperty("byRequests")
            @ExcludeMissing
            byRequests: JsonField<List<ByRequest>> = JsonMissing.of(),
        ) : this(byBandwidth, byRequests, mutableMapOf())

        /**
         * Top non-image, non-video assets sorted by bandwidth utilized.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byBandwidth(): List<ByBandwidth> = byBandwidth.getRequired("byBandwidth")

        /**
         * Top non-image, non-video assets sorted by request count.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byRequests(): List<ByRequest> = byRequests.getRequired("byRequests")

        /**
         * Returns the raw JSON value of [byBandwidth].
         *
         * Unlike [byBandwidth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byBandwidth")
        @ExcludeMissing
        fun _byBandwidth(): JsonField<List<ByBandwidth>> = byBandwidth

        /**
         * Returns the raw JSON value of [byRequests].
         *
         * Unlike [byRequests], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byRequests")
        @ExcludeMissing
        fun _byRequests(): JsonField<List<ByRequest>> = byRequests

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [TopOtherAssets].
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TopOtherAssets]. */
        class Builder internal constructor() {

            private var byBandwidth: JsonField<MutableList<ByBandwidth>>? = null
            private var byRequests: JsonField<MutableList<ByRequest>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(topOtherAssets: TopOtherAssets) = apply {
                byBandwidth = topOtherAssets.byBandwidth.map { it.toMutableList() }
                byRequests = topOtherAssets.byRequests.map { it.toMutableList() }
                additionalProperties = topOtherAssets.additionalProperties.toMutableMap()
            }

            /** Top non-image, non-video assets sorted by bandwidth utilized. */
            fun byBandwidth(byBandwidth: List<ByBandwidth>) = byBandwidth(JsonField.of(byBandwidth))

            /**
             * Sets [Builder.byBandwidth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byBandwidth] with a well-typed `List<ByBandwidth>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byBandwidth(byBandwidth: JsonField<List<ByBandwidth>>) = apply {
                this.byBandwidth = byBandwidth.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByBandwidth] to [Builder.byBandwidth].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByBandwidth(byBandwidth: ByBandwidth) = apply {
                this.byBandwidth =
                    (this.byBandwidth ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byBandwidth", it).add(byBandwidth)
                    }
            }

            /** Top non-image, non-video assets sorted by request count. */
            fun byRequests(byRequests: List<ByRequest>) = byRequests(JsonField.of(byRequests))

            /**
             * Sets [Builder.byRequests] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byRequests] with a well-typed `List<ByRequest>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byRequests(byRequests: JsonField<List<ByRequest>>) = apply {
                this.byRequests = byRequests.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByRequest] to [byRequests].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByRequest(byRequest: ByRequest) = apply {
                byRequests =
                    (byRequests ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byRequests", it).add(byRequest)
                    }
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [TopOtherAssets].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): TopOtherAssets =
                TopOtherAssets(
                    checkRequired("byBandwidth", byBandwidth).map { it.toImmutable() },
                    checkRequired("byRequests", byRequests).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): TopOtherAssets = apply {
            if (validated) {
                return@apply
            }

            byBandwidth().forEach { it.validate() }
            byRequests().forEach { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (byBandwidth.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (byRequests.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class ByBandwidth
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * URL of the non-image, non-video asset.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByBandwidth].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByBandwidth]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byBandwidth: ByBandwidth) = apply {
                    bandwidthBytes = byBandwidth.bandwidthBytes
                    requestCount = byBandwidth.requestCount
                    name = byBandwidth.name
                    additionalProperties = byBandwidth.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** URL of the non-image, non-video asset. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByBandwidth].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByBandwidth =
                    ByBandwidth(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByBandwidth = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByBandwidth &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByBandwidth{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        class ByRequest
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * URL of the non-image, non-video asset.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByRequest].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByRequest]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byRequest: ByRequest) = apply {
                    bandwidthBytes = byRequest.bandwidthBytes
                    requestCount = byRequest.requestCount
                    name = byRequest.name
                    additionalProperties = byRequest.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** URL of the non-image, non-video asset. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByRequest].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByRequest =
                    ByRequest(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByRequest = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByRequest &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByRequest{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TopOtherAssets &&
                byBandwidth == other.byBandwidth &&
                byRequests == other.byRequests &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(byBandwidth, byRequests, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TopOtherAssets{byBandwidth=$byBandwidth, byRequests=$byRequests, additionalProperties=$additionalProperties}"
    }

    /** Top HTTP referrers by traffic. */
    class TopReferrers
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val byBandwidth: JsonField<List<ByBandwidth>>,
        private val byRequests: JsonField<List<ByRequest>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("byBandwidth")
            @ExcludeMissing
            byBandwidth: JsonField<List<ByBandwidth>> = JsonMissing.of(),
            @JsonProperty("byRequests")
            @ExcludeMissing
            byRequests: JsonField<List<ByRequest>> = JsonMissing.of(),
        ) : this(byBandwidth, byRequests, mutableMapOf())

        /**
         * Top HTTP referrers sorted by bandwidth utilized.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byBandwidth(): List<ByBandwidth> = byBandwidth.getRequired("byBandwidth")

        /**
         * Top HTTP referrers sorted by request count.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byRequests(): List<ByRequest> = byRequests.getRequired("byRequests")

        /**
         * Returns the raw JSON value of [byBandwidth].
         *
         * Unlike [byBandwidth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byBandwidth")
        @ExcludeMissing
        fun _byBandwidth(): JsonField<List<ByBandwidth>> = byBandwidth

        /**
         * Returns the raw JSON value of [byRequests].
         *
         * Unlike [byRequests], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byRequests")
        @ExcludeMissing
        fun _byRequests(): JsonField<List<ByRequest>> = byRequests

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [TopReferrers].
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TopReferrers]. */
        class Builder internal constructor() {

            private var byBandwidth: JsonField<MutableList<ByBandwidth>>? = null
            private var byRequests: JsonField<MutableList<ByRequest>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(topReferrers: TopReferrers) = apply {
                byBandwidth = topReferrers.byBandwidth.map { it.toMutableList() }
                byRequests = topReferrers.byRequests.map { it.toMutableList() }
                additionalProperties = topReferrers.additionalProperties.toMutableMap()
            }

            /** Top HTTP referrers sorted by bandwidth utilized. */
            fun byBandwidth(byBandwidth: List<ByBandwidth>) = byBandwidth(JsonField.of(byBandwidth))

            /**
             * Sets [Builder.byBandwidth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byBandwidth] with a well-typed `List<ByBandwidth>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byBandwidth(byBandwidth: JsonField<List<ByBandwidth>>) = apply {
                this.byBandwidth = byBandwidth.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByBandwidth] to [Builder.byBandwidth].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByBandwidth(byBandwidth: ByBandwidth) = apply {
                this.byBandwidth =
                    (this.byBandwidth ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byBandwidth", it).add(byBandwidth)
                    }
            }

            /** Top HTTP referrers sorted by request count. */
            fun byRequests(byRequests: List<ByRequest>) = byRequests(JsonField.of(byRequests))

            /**
             * Sets [Builder.byRequests] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byRequests] with a well-typed `List<ByRequest>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byRequests(byRequests: JsonField<List<ByRequest>>) = apply {
                this.byRequests = byRequests.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByRequest] to [byRequests].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByRequest(byRequest: ByRequest) = apply {
                byRequests =
                    (byRequests ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byRequests", it).add(byRequest)
                    }
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [TopReferrers].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): TopReferrers =
                TopReferrers(
                    checkRequired("byBandwidth", byBandwidth).map { it.toImmutable() },
                    checkRequired("byRequests", byRequests).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): TopReferrers = apply {
            if (validated) {
                return@apply
            }

            byBandwidth().forEach { it.validate() }
            byRequests().forEach { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (byBandwidth.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (byRequests.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class ByBandwidth
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * Referrer URL.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByBandwidth].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByBandwidth]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byBandwidth: ByBandwidth) = apply {
                    bandwidthBytes = byBandwidth.bandwidthBytes
                    requestCount = byBandwidth.requestCount
                    name = byBandwidth.name
                    additionalProperties = byBandwidth.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** Referrer URL. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByBandwidth].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByBandwidth =
                    ByBandwidth(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByBandwidth = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByBandwidth &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByBandwidth{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        class ByRequest
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * Referrer URL.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByRequest].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByRequest]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byRequest: ByRequest) = apply {
                    bandwidthBytes = byRequest.bandwidthBytes
                    requestCount = byRequest.requestCount
                    name = byRequest.name
                    additionalProperties = byRequest.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** Referrer URL. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByRequest].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByRequest =
                    ByRequest(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByRequest = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByRequest &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByRequest{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TopReferrers &&
                byBandwidth == other.byBandwidth &&
                byRequests == other.byRequests &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(byBandwidth, byRequests, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TopReferrers{byBandwidth=$byBandwidth, byRequests=$byRequests, additionalProperties=$additionalProperties}"
    }

    /** Top user agents by traffic. */
    class TopUserAgents
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val byBandwidth: JsonField<List<ByBandwidth>>,
        private val byRequests: JsonField<List<ByRequest>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("byBandwidth")
            @ExcludeMissing
            byBandwidth: JsonField<List<ByBandwidth>> = JsonMissing.of(),
            @JsonProperty("byRequests")
            @ExcludeMissing
            byRequests: JsonField<List<ByRequest>> = JsonMissing.of(),
        ) : this(byBandwidth, byRequests, mutableMapOf())

        /**
         * Top user agents sorted by bandwidth utilized.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byBandwidth(): List<ByBandwidth> = byBandwidth.getRequired("byBandwidth")

        /**
         * Top user agents sorted by request count.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byRequests(): List<ByRequest> = byRequests.getRequired("byRequests")

        /**
         * Returns the raw JSON value of [byBandwidth].
         *
         * Unlike [byBandwidth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byBandwidth")
        @ExcludeMissing
        fun _byBandwidth(): JsonField<List<ByBandwidth>> = byBandwidth

        /**
         * Returns the raw JSON value of [byRequests].
         *
         * Unlike [byRequests], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byRequests")
        @ExcludeMissing
        fun _byRequests(): JsonField<List<ByRequest>> = byRequests

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [TopUserAgents].
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TopUserAgents]. */
        class Builder internal constructor() {

            private var byBandwidth: JsonField<MutableList<ByBandwidth>>? = null
            private var byRequests: JsonField<MutableList<ByRequest>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(topUserAgents: TopUserAgents) = apply {
                byBandwidth = topUserAgents.byBandwidth.map { it.toMutableList() }
                byRequests = topUserAgents.byRequests.map { it.toMutableList() }
                additionalProperties = topUserAgents.additionalProperties.toMutableMap()
            }

            /** Top user agents sorted by bandwidth utilized. */
            fun byBandwidth(byBandwidth: List<ByBandwidth>) = byBandwidth(JsonField.of(byBandwidth))

            /**
             * Sets [Builder.byBandwidth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byBandwidth] with a well-typed `List<ByBandwidth>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byBandwidth(byBandwidth: JsonField<List<ByBandwidth>>) = apply {
                this.byBandwidth = byBandwidth.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByBandwidth] to [Builder.byBandwidth].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByBandwidth(byBandwidth: ByBandwidth) = apply {
                this.byBandwidth =
                    (this.byBandwidth ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byBandwidth", it).add(byBandwidth)
                    }
            }

            /** Top user agents sorted by request count. */
            fun byRequests(byRequests: List<ByRequest>) = byRequests(JsonField.of(byRequests))

            /**
             * Sets [Builder.byRequests] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byRequests] with a well-typed `List<ByRequest>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byRequests(byRequests: JsonField<List<ByRequest>>) = apply {
                this.byRequests = byRequests.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByRequest] to [byRequests].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByRequest(byRequest: ByRequest) = apply {
                byRequests =
                    (byRequests ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byRequests", it).add(byRequest)
                    }
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [TopUserAgents].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): TopUserAgents =
                TopUserAgents(
                    checkRequired("byBandwidth", byBandwidth).map { it.toImmutable() },
                    checkRequired("byRequests", byRequests).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): TopUserAgents = apply {
            if (validated) {
                return@apply
            }

            byBandwidth().forEach { it.validate() }
            byRequests().forEach { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (byBandwidth.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (byRequests.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class ByBandwidth
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * User agent string.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByBandwidth].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByBandwidth]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byBandwidth: ByBandwidth) = apply {
                    bandwidthBytes = byBandwidth.bandwidthBytes
                    requestCount = byBandwidth.requestCount
                    name = byBandwidth.name
                    additionalProperties = byBandwidth.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** User agent string. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByBandwidth].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByBandwidth =
                    ByBandwidth(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByBandwidth = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByBandwidth &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByBandwidth{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        class ByRequest
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * User agent string.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByRequest].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByRequest]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byRequest: ByRequest) = apply {
                    bandwidthBytes = byRequest.bandwidthBytes
                    requestCount = byRequest.requestCount
                    name = byRequest.name
                    additionalProperties = byRequest.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** User agent string. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByRequest].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByRequest =
                    ByRequest(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByRequest = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByRequest &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByRequest{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TopUserAgents &&
                byBandwidth == other.byBandwidth &&
                byRequests == other.byRequests &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(byBandwidth, byRequests, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TopUserAgents{byBandwidth=$byBandwidth, byRequests=$byRequests, additionalProperties=$additionalProperties}"
    }

    /** Top video assets by traffic. */
    class TopVideos
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val byBandwidth: JsonField<List<ByBandwidth>>,
        private val byRequests: JsonField<List<ByRequest>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("byBandwidth")
            @ExcludeMissing
            byBandwidth: JsonField<List<ByBandwidth>> = JsonMissing.of(),
            @JsonProperty("byRequests")
            @ExcludeMissing
            byRequests: JsonField<List<ByRequest>> = JsonMissing.of(),
        ) : this(byBandwidth, byRequests, mutableMapOf())

        /**
         * Top video assets sorted by bandwidth utilized.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byBandwidth(): List<ByBandwidth> = byBandwidth.getRequired("byBandwidth")

        /**
         * Top video assets sorted by request count.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byRequests(): List<ByRequest> = byRequests.getRequired("byRequests")

        /**
         * Returns the raw JSON value of [byBandwidth].
         *
         * Unlike [byBandwidth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byBandwidth")
        @ExcludeMissing
        fun _byBandwidth(): JsonField<List<ByBandwidth>> = byBandwidth

        /**
         * Returns the raw JSON value of [byRequests].
         *
         * Unlike [byRequests], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byRequests")
        @ExcludeMissing
        fun _byRequests(): JsonField<List<ByRequest>> = byRequests

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [TopVideos].
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TopVideos]. */
        class Builder internal constructor() {

            private var byBandwidth: JsonField<MutableList<ByBandwidth>>? = null
            private var byRequests: JsonField<MutableList<ByRequest>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(topVideos: TopVideos) = apply {
                byBandwidth = topVideos.byBandwidth.map { it.toMutableList() }
                byRequests = topVideos.byRequests.map { it.toMutableList() }
                additionalProperties = topVideos.additionalProperties.toMutableMap()
            }

            /** Top video assets sorted by bandwidth utilized. */
            fun byBandwidth(byBandwidth: List<ByBandwidth>) = byBandwidth(JsonField.of(byBandwidth))

            /**
             * Sets [Builder.byBandwidth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byBandwidth] with a well-typed `List<ByBandwidth>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byBandwidth(byBandwidth: JsonField<List<ByBandwidth>>) = apply {
                this.byBandwidth = byBandwidth.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByBandwidth] to [Builder.byBandwidth].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByBandwidth(byBandwidth: ByBandwidth) = apply {
                this.byBandwidth =
                    (this.byBandwidth ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byBandwidth", it).add(byBandwidth)
                    }
            }

            /** Top video assets sorted by request count. */
            fun byRequests(byRequests: List<ByRequest>) = byRequests(JsonField.of(byRequests))

            /**
             * Sets [Builder.byRequests] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byRequests] with a well-typed `List<ByRequest>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byRequests(byRequests: JsonField<List<ByRequest>>) = apply {
                this.byRequests = byRequests.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByRequest] to [byRequests].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByRequest(byRequest: ByRequest) = apply {
                byRequests =
                    (byRequests ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byRequests", it).add(byRequest)
                    }
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [TopVideos].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): TopVideos =
                TopVideos(
                    checkRequired("byBandwidth", byBandwidth).map { it.toImmutable() },
                    checkRequired("byRequests", byRequests).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): TopVideos = apply {
            if (validated) {
                return@apply
            }

            byBandwidth().forEach { it.validate() }
            byRequests().forEach { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (byBandwidth.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (byRequests.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class ByBandwidth
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * URL of the video asset.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByBandwidth].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByBandwidth]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byBandwidth: ByBandwidth) = apply {
                    bandwidthBytes = byBandwidth.bandwidthBytes
                    requestCount = byBandwidth.requestCount
                    name = byBandwidth.name
                    additionalProperties = byBandwidth.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** URL of the video asset. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByBandwidth].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByBandwidth =
                    ByBandwidth(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByBandwidth = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByBandwidth &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByBandwidth{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        class ByRequest
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * Full URL of the video asset (e.g. `https://ik.imagekit.io/demo/clip.mp4`).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByRequest].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByRequest]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byRequest: ByRequest) = apply {
                    bandwidthBytes = byRequest.bandwidthBytes
                    requestCount = byRequest.requestCount
                    name = byRequest.name
                    additionalProperties = byRequest.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** Full URL of the video asset (e.g. `https://ik.imagekit.io/demo/clip.mp4`). */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByRequest].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByRequest =
                    ByRequest(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByRequest = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByRequest &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByRequest{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TopVideos &&
                byBandwidth == other.byBandwidth &&
                byRequests == other.byRequests &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(byBandwidth, byRequests, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TopVideos{byBandwidth=$byBandwidth, byRequests=$byRequests, additionalProperties=$additionalProperties}"
    }

    /** Top video transformation strings by traffic. */
    class TopVideoTransforms
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val byBandwidth: JsonField<List<ByBandwidth>>,
        private val byRequests: JsonField<List<ByRequest>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("byBandwidth")
            @ExcludeMissing
            byBandwidth: JsonField<List<ByBandwidth>> = JsonMissing.of(),
            @JsonProperty("byRequests")
            @ExcludeMissing
            byRequests: JsonField<List<ByRequest>> = JsonMissing.of(),
        ) : this(byBandwidth, byRequests, mutableMapOf())

        /**
         * Top video transformation strings sorted by bandwidth utilized.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byBandwidth(): List<ByBandwidth> = byBandwidth.getRequired("byBandwidth")

        /**
         * Top video transformation strings sorted by request count.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byRequests(): List<ByRequest> = byRequests.getRequired("byRequests")

        /**
         * Returns the raw JSON value of [byBandwidth].
         *
         * Unlike [byBandwidth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byBandwidth")
        @ExcludeMissing
        fun _byBandwidth(): JsonField<List<ByBandwidth>> = byBandwidth

        /**
         * Returns the raw JSON value of [byRequests].
         *
         * Unlike [byRequests], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byRequests")
        @ExcludeMissing
        fun _byRequests(): JsonField<List<ByRequest>> = byRequests

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [TopVideoTransforms].
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TopVideoTransforms]. */
        class Builder internal constructor() {

            private var byBandwidth: JsonField<MutableList<ByBandwidth>>? = null
            private var byRequests: JsonField<MutableList<ByRequest>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(topVideoTransforms: TopVideoTransforms) = apply {
                byBandwidth = topVideoTransforms.byBandwidth.map { it.toMutableList() }
                byRequests = topVideoTransforms.byRequests.map { it.toMutableList() }
                additionalProperties = topVideoTransforms.additionalProperties.toMutableMap()
            }

            /** Top video transformation strings sorted by bandwidth utilized. */
            fun byBandwidth(byBandwidth: List<ByBandwidth>) = byBandwidth(JsonField.of(byBandwidth))

            /**
             * Sets [Builder.byBandwidth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byBandwidth] with a well-typed `List<ByBandwidth>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byBandwidth(byBandwidth: JsonField<List<ByBandwidth>>) = apply {
                this.byBandwidth = byBandwidth.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByBandwidth] to [Builder.byBandwidth].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByBandwidth(byBandwidth: ByBandwidth) = apply {
                this.byBandwidth =
                    (this.byBandwidth ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byBandwidth", it).add(byBandwidth)
                    }
            }

            /** Top video transformation strings sorted by request count. */
            fun byRequests(byRequests: List<ByRequest>) = byRequests(JsonField.of(byRequests))

            /**
             * Sets [Builder.byRequests] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byRequests] with a well-typed `List<ByRequest>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byRequests(byRequests: JsonField<List<ByRequest>>) = apply {
                this.byRequests = byRequests.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByRequest] to [byRequests].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByRequest(byRequest: ByRequest) = apply {
                byRequests =
                    (byRequests ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byRequests", it).add(byRequest)
                    }
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [TopVideoTransforms].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): TopVideoTransforms =
                TopVideoTransforms(
                    checkRequired("byBandwidth", byBandwidth).map { it.toImmutable() },
                    checkRequired("byRequests", byRequests).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): TopVideoTransforms = apply {
            if (validated) {
                return@apply
            }

            byBandwidth().forEach { it.validate() }
            byRequests().forEach { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (byBandwidth.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (byRequests.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class ByBandwidth
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * Video transformation string (e.g. `tr:h-720,f-mp4`).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByBandwidth].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByBandwidth]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byBandwidth: ByBandwidth) = apply {
                    bandwidthBytes = byBandwidth.bandwidthBytes
                    requestCount = byBandwidth.requestCount
                    name = byBandwidth.name
                    additionalProperties = byBandwidth.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** Video transformation string (e.g. `tr:h-720,f-mp4`). */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByBandwidth].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByBandwidth =
                    ByBandwidth(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByBandwidth = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByBandwidth &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByBandwidth{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        class ByRequest
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * Video transformation string (e.g. `tr:h-720,f-mp4`).
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByRequest].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByRequest]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byRequest: ByRequest) = apply {
                    bandwidthBytes = byRequest.bandwidthBytes
                    requestCount = byRequest.requestCount
                    name = byRequest.name
                    additionalProperties = byRequest.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /** Video transformation string (e.g. `tr:h-720,f-mp4`). */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByRequest].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByRequest =
                    ByRequest(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByRequest = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByRequest &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByRequest{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TopVideoTransforms &&
                byBandwidth == other.byBandwidth &&
                byRequests == other.byRequests &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(byBandwidth, byRequests, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TopVideoTransforms{byBandwidth=$byBandwidth, byRequests=$byRequests, additionalProperties=$additionalProperties}"
    }

    /**
     * CDN traffic grouped by configured URL endpoint. Traffic that does not match any named URL
     * endpoint pattern is grouped under `Default`.
     */
    class UrlEndpoints
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val byBandwidth: JsonField<List<ByBandwidth>>,
        private val byRequests: JsonField<List<ByRequest>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("byBandwidth")
            @ExcludeMissing
            byBandwidth: JsonField<List<ByBandwidth>> = JsonMissing.of(),
            @JsonProperty("byRequests")
            @ExcludeMissing
            byRequests: JsonField<List<ByRequest>> = JsonMissing.of(),
        ) : this(byBandwidth, byRequests, mutableMapOf())

        /**
         * Top URL endpoints sorted by bandwidth utilized.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byBandwidth(): List<ByBandwidth> = byBandwidth.getRequired("byBandwidth")

        /**
         * Top URL endpoints sorted by request count.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun byRequests(): List<ByRequest> = byRequests.getRequired("byRequests")

        /**
         * Returns the raw JSON value of [byBandwidth].
         *
         * Unlike [byBandwidth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byBandwidth")
        @ExcludeMissing
        fun _byBandwidth(): JsonField<List<ByBandwidth>> = byBandwidth

        /**
         * Returns the raw JSON value of [byRequests].
         *
         * Unlike [byRequests], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("byRequests")
        @ExcludeMissing
        fun _byRequests(): JsonField<List<ByRequest>> = byRequests

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [UrlEndpoints].
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UrlEndpoints]. */
        class Builder internal constructor() {

            private var byBandwidth: JsonField<MutableList<ByBandwidth>>? = null
            private var byRequests: JsonField<MutableList<ByRequest>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(urlEndpoints: UrlEndpoints) = apply {
                byBandwidth = urlEndpoints.byBandwidth.map { it.toMutableList() }
                byRequests = urlEndpoints.byRequests.map { it.toMutableList() }
                additionalProperties = urlEndpoints.additionalProperties.toMutableMap()
            }

            /** Top URL endpoints sorted by bandwidth utilized. */
            fun byBandwidth(byBandwidth: List<ByBandwidth>) = byBandwidth(JsonField.of(byBandwidth))

            /**
             * Sets [Builder.byBandwidth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byBandwidth] with a well-typed `List<ByBandwidth>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byBandwidth(byBandwidth: JsonField<List<ByBandwidth>>) = apply {
                this.byBandwidth = byBandwidth.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByBandwidth] to [Builder.byBandwidth].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByBandwidth(byBandwidth: ByBandwidth) = apply {
                this.byBandwidth =
                    (this.byBandwidth ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byBandwidth", it).add(byBandwidth)
                    }
            }

            /** Top URL endpoints sorted by request count. */
            fun byRequests(byRequests: List<ByRequest>) = byRequests(JsonField.of(byRequests))

            /**
             * Sets [Builder.byRequests] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byRequests] with a well-typed `List<ByRequest>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun byRequests(byRequests: JsonField<List<ByRequest>>) = apply {
                this.byRequests = byRequests.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByRequest] to [byRequests].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByRequest(byRequest: ByRequest) = apply {
                byRequests =
                    (byRequests ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byRequests", it).add(byRequest)
                    }
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [UrlEndpoints].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .byBandwidth()
             * .byRequests()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): UrlEndpoints =
                UrlEndpoints(
                    checkRequired("byBandwidth", byBandwidth).map { it.toImmutable() },
                    checkRequired("byRequests", byRequests).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): UrlEndpoints = apply {
            if (validated) {
                return@apply
            }

            byBandwidth().forEach { it.validate() }
            byRequests().forEach { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (byBandwidth.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (byRequests.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class ByBandwidth
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * URL endpoint name, or `Default` for traffic that does not match a named endpoint.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByBandwidth].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByBandwidth]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byBandwidth: ByBandwidth) = apply {
                    bandwidthBytes = byBandwidth.bandwidthBytes
                    requestCount = byBandwidth.requestCount
                    name = byBandwidth.name
                    additionalProperties = byBandwidth.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /**
                 * URL endpoint name, or `Default` for traffic that does not match a named endpoint.
                 */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByBandwidth].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByBandwidth =
                    ByBandwidth(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByBandwidth = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByBandwidth &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByBandwidth{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        class ByRequest
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bandwidthBytes: JsonField<Double>,
            private val requestCount: JsonField<Double>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bandwidthBytes")
                @ExcludeMissing
                bandwidthBytes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("requestCount")
                @ExcludeMissing
                requestCount: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(bandwidthBytes, requestCount, name, mutableMapOf())

            fun toRequestBandwidthEntry(): RequestBandwidthEntry =
                RequestBandwidthEntry.builder()
                    .bandwidthBytes(bandwidthBytes)
                    .requestCount(requestCount)
                    .build()

            /**
             * Total bandwidth used in bytes.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun bandwidthBytes(): Double = bandwidthBytes.getRequired("bandwidthBytes")

            /**
             * Number of requests.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requestCount(): Double = requestCount.getRequired("requestCount")

            /**
             * URL endpoint name, or `Default` for traffic that does not match a named endpoint.
             *
             * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Returns the raw JSON value of [bandwidthBytes].
             *
             * Unlike [bandwidthBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("bandwidthBytes")
            @ExcludeMissing
            fun _bandwidthBytes(): JsonField<Double> = bandwidthBytes

            /**
             * Returns the raw JSON value of [requestCount].
             *
             * Unlike [requestCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requestCount")
            @ExcludeMissing
            fun _requestCount(): JsonField<Double> = requestCount

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ByRequest].
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByRequest]. */
            class Builder internal constructor() {

                private var bandwidthBytes: JsonField<Double>? = null
                private var requestCount: JsonField<Double>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byRequest: ByRequest) = apply {
                    bandwidthBytes = byRequest.bandwidthBytes
                    requestCount = byRequest.requestCount
                    name = byRequest.name
                    additionalProperties = byRequest.additionalProperties.toMutableMap()
                }

                /** Total bandwidth used in bytes. */
                fun bandwidthBytes(bandwidthBytes: Double) =
                    bandwidthBytes(JsonField.of(bandwidthBytes))

                /**
                 * Sets [Builder.bandwidthBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bandwidthBytes] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun bandwidthBytes(bandwidthBytes: JsonField<Double>) = apply {
                    this.bandwidthBytes = bandwidthBytes
                }

                /** Number of requests. */
                fun requestCount(requestCount: Double) = requestCount(JsonField.of(requestCount))

                /**
                 * Sets [Builder.requestCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestCount(requestCount: JsonField<Double>) = apply {
                    this.requestCount = requestCount
                }

                /**
                 * URL endpoint name, or `Default` for traffic that does not match a named endpoint.
                 */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByRequest].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bandwidthBytes()
                 * .requestCount()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ByRequest =
                    ByRequest(
                        checkRequired("bandwidthBytes", bandwidthBytes),
                        checkRequired("requestCount", requestCount),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws ImageKitInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): ByRequest = apply {
                if (validated) {
                    return@apply
                }

                bandwidthBytes()
                requestCount()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ImageKitInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (bandwidthBytes.asKnown().isPresent) 1 else 0) +
                    (if (requestCount.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByRequest &&
                    bandwidthBytes == other.bandwidthBytes &&
                    requestCount == other.requestCount &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(bandwidthBytes, requestCount, name, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByRequest{bandwidthBytes=$bandwidthBytes, requestCount=$requestCount, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is UrlEndpoints &&
                byBandwidth == other.byBandwidth &&
                byRequests == other.byRequests &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(byBandwidth, byRequests, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UrlEndpoints{byBandwidth=$byBandwidth, byRequests=$byRequests, additionalProperties=$additionalProperties}"
    }

    class VideoProcessing
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val codec: JsonField<String>,
        private val durationSeconds: JsonField<Double>,
        private val resolution: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("codec") @ExcludeMissing codec: JsonField<String> = JsonMissing.of(),
            @JsonProperty("durationSeconds")
            @ExcludeMissing
            durationSeconds: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("resolution")
            @ExcludeMissing
            resolution: JsonField<String> = JsonMissing.of(),
        ) : this(codec, durationSeconds, resolution, mutableMapOf())

        /**
         * Video codec used for the output (e.g. `h264`, `av1`).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun codec(): String = codec.getRequired("codec")

        /**
         * Total output duration, in seconds, for this resolution and codec combination.
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun durationSeconds(): Double = durationSeconds.getRequired("durationSeconds")

        /**
         * Output resolution tier (e.g. `SD`, `HD`, `4K`).
         *
         * @throws ImageKitInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun resolution(): String = resolution.getRequired("resolution")

        /**
         * Returns the raw JSON value of [codec].
         *
         * Unlike [codec], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("codec") @ExcludeMissing fun _codec(): JsonField<String> = codec

        /**
         * Returns the raw JSON value of [durationSeconds].
         *
         * Unlike [durationSeconds], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("durationSeconds")
        @ExcludeMissing
        fun _durationSeconds(): JsonField<Double> = durationSeconds

        /**
         * Returns the raw JSON value of [resolution].
         *
         * Unlike [resolution], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("resolution")
        @ExcludeMissing
        fun _resolution(): JsonField<String> = resolution

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [VideoProcessing].
             *
             * The following fields are required:
             * ```java
             * .codec()
             * .durationSeconds()
             * .resolution()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [VideoProcessing]. */
        class Builder internal constructor() {

            private var codec: JsonField<String>? = null
            private var durationSeconds: JsonField<Double>? = null
            private var resolution: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(videoProcessing: VideoProcessing) = apply {
                codec = videoProcessing.codec
                durationSeconds = videoProcessing.durationSeconds
                resolution = videoProcessing.resolution
                additionalProperties = videoProcessing.additionalProperties.toMutableMap()
            }

            /** Video codec used for the output (e.g. `h264`, `av1`). */
            fun codec(codec: String) = codec(JsonField.of(codec))

            /**
             * Sets [Builder.codec] to an arbitrary JSON value.
             *
             * You should usually call [Builder.codec] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun codec(codec: JsonField<String>) = apply { this.codec = codec }

            /** Total output duration, in seconds, for this resolution and codec combination. */
            fun durationSeconds(durationSeconds: Double) =
                durationSeconds(JsonField.of(durationSeconds))

            /**
             * Sets [Builder.durationSeconds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.durationSeconds] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun durationSeconds(durationSeconds: JsonField<Double>) = apply {
                this.durationSeconds = durationSeconds
            }

            /** Output resolution tier (e.g. `SD`, `HD`, `4K`). */
            fun resolution(resolution: String) = resolution(JsonField.of(resolution))

            /**
             * Sets [Builder.resolution] to an arbitrary JSON value.
             *
             * You should usually call [Builder.resolution] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun resolution(resolution: JsonField<String>) = apply { this.resolution = resolution }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [VideoProcessing].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .codec()
             * .durationSeconds()
             * .resolution()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): VideoProcessing =
                VideoProcessing(
                    checkRequired("codec", codec),
                    checkRequired("durationSeconds", durationSeconds),
                    checkRequired("resolution", resolution),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws ImageKitInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): VideoProcessing = apply {
            if (validated) {
                return@apply
            }

            codec()
            durationSeconds()
            resolution()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ImageKitInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (codec.asKnown().isPresent) 1 else 0) +
                (if (durationSeconds.asKnown().isPresent) 1 else 0) +
                (if (resolution.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is VideoProcessing &&
                codec == other.codec &&
                durationSeconds == other.durationSeconds &&
                resolution == other.resolution &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(codec, durationSeconds, resolution, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "VideoProcessing{codec=$codec, durationSeconds=$durationSeconds, resolution=$resolution, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UsageAnalyticsResponse &&
            bandwidthBytes == other.bandwidthBytes &&
            browser == other.browser &&
            cache == other.cache &&
            country == other.country &&
            device == other.device &&
            endDate == other.endDate &&
            errorReasons == other.errorReasons &&
            extensions == other.extensions &&
            format == other.format &&
            generatedAt == other.generatedAt &&
            requestCount == other.requestCount &&
            startDate == other.startDate &&
            statusCodes == other.statusCodes &&
            top404Assets == other.top404Assets &&
            topImages == other.topImages &&
            topImageTransforms == other.topImageTransforms &&
            topOtherAssets == other.topOtherAssets &&
            topReferrers == other.topReferrers &&
            topUserAgents == other.topUserAgents &&
            topVideos == other.topVideos &&
            topVideoTransforms == other.topVideoTransforms &&
            urlEndpoints == other.urlEndpoints &&
            videoProcessing == other.videoProcessing &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            bandwidthBytes,
            browser,
            cache,
            country,
            device,
            endDate,
            errorReasons,
            extensions,
            format,
            generatedAt,
            requestCount,
            startDate,
            statusCodes,
            top404Assets,
            topImages,
            topImageTransforms,
            topOtherAssets,
            topReferrers,
            topUserAgents,
            topVideos,
            topVideoTransforms,
            urlEndpoints,
            videoProcessing,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UsageAnalyticsResponse{bandwidthBytes=$bandwidthBytes, browser=$browser, cache=$cache, country=$country, device=$device, endDate=$endDate, errorReasons=$errorReasons, extensions=$extensions, format=$format, generatedAt=$generatedAt, requestCount=$requestCount, startDate=$startDate, statusCodes=$statusCodes, top404Assets=$top404Assets, topImages=$topImages, topImageTransforms=$topImageTransforms, topOtherAssets=$topOtherAssets, topReferrers=$topReferrers, topUserAgents=$topUserAgents, topVideos=$topVideos, topVideoTransforms=$topVideoTransforms, urlEndpoints=$urlEndpoints, videoProcessing=$videoProcessing, additionalProperties=$additionalProperties}"
}
