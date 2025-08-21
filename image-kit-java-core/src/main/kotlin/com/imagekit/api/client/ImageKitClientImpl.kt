// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.client

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.getPackageVersion
import com.imagekit.api.services.blocking.AccountService
import com.imagekit.api.services.blocking.AccountServiceImpl
import com.imagekit.api.services.blocking.AssetService
import com.imagekit.api.services.blocking.AssetServiceImpl
import com.imagekit.api.services.blocking.BetaService
import com.imagekit.api.services.blocking.BetaServiceImpl
import com.imagekit.api.services.blocking.CacheService
import com.imagekit.api.services.blocking.CacheServiceImpl
import com.imagekit.api.services.blocking.CustomMetadataFieldService
import com.imagekit.api.services.blocking.CustomMetadataFieldServiceImpl
import com.imagekit.api.services.blocking.FileService
import com.imagekit.api.services.blocking.FileServiceImpl
import com.imagekit.api.services.blocking.FolderService
import com.imagekit.api.services.blocking.FolderServiceImpl
import java.util.function.Consumer

class ImageKitClientImpl(private val clientOptions: ClientOptions) : ImageKitClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: ImageKitClientAsync by lazy { ImageKitClientAsyncImpl(clientOptions) }

    private val withRawResponse: ImageKitClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val customMetadataFields: CustomMetadataFieldService by lazy {
        CustomMetadataFieldServiceImpl(clientOptionsWithUserAgent)
    }

    private val files: FileService by lazy { FileServiceImpl(clientOptionsWithUserAgent) }

    private val assets: AssetService by lazy { AssetServiceImpl(clientOptionsWithUserAgent) }

    private val cache: CacheService by lazy { CacheServiceImpl(clientOptionsWithUserAgent) }

    private val folders: FolderService by lazy { FolderServiceImpl(clientOptionsWithUserAgent) }

    private val accounts: AccountService by lazy { AccountServiceImpl(clientOptionsWithUserAgent) }

    private val beta: BetaService by lazy { BetaServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): ImageKitClientAsync = async

    override fun withRawResponse(): ImageKitClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ImageKitClient =
        ImageKitClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun customMetadataFields(): CustomMetadataFieldService = customMetadataFields

    override fun files(): FileService = files

    override fun assets(): AssetService = assets

    override fun cache(): CacheService = cache

    override fun folders(): FolderService = folders

    override fun accounts(): AccountService = accounts

    override fun beta(): BetaService = beta

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ImageKitClient.WithRawResponse {

        private val customMetadataFields: CustomMetadataFieldService.WithRawResponse by lazy {
            CustomMetadataFieldServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val files: FileService.WithRawResponse by lazy {
            FileServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val assets: AssetService.WithRawResponse by lazy {
            AssetServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val cache: CacheService.WithRawResponse by lazy {
            CacheServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val folders: FolderService.WithRawResponse by lazy {
            FolderServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val accounts: AccountService.WithRawResponse by lazy {
            AccountServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val beta: BetaService.WithRawResponse by lazy {
            BetaServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ImageKitClient.WithRawResponse =
            ImageKitClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun customMetadataFields(): CustomMetadataFieldService.WithRawResponse =
            customMetadataFields

        override fun files(): FileService.WithRawResponse = files

        override fun assets(): AssetService.WithRawResponse = assets

        override fun cache(): CacheService.WithRawResponse = cache

        override fun folders(): FolderService.WithRawResponse = folders

        override fun accounts(): AccountService.WithRawResponse = accounts

        override fun beta(): BetaService.WithRawResponse = beta
    }
}
