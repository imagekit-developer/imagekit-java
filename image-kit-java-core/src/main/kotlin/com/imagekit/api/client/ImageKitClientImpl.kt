// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.client

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.getPackageVersion
import com.imagekit.api.services.blocking.AccountService
import com.imagekit.api.services.blocking.AccountServiceImpl
import com.imagekit.api.services.blocking.BulkJobService
import com.imagekit.api.services.blocking.BulkJobServiceImpl
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

    private val folder: FolderService by lazy { FolderServiceImpl(clientOptionsWithUserAgent) }

    private val bulkJobs: BulkJobService by lazy { BulkJobServiceImpl(clientOptionsWithUserAgent) }

    private val accounts: AccountService by lazy { AccountServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): ImageKitClientAsync = async

    override fun withRawResponse(): ImageKitClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ImageKitClient =
        ImageKitClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun customMetadataFields(): CustomMetadataFieldService = customMetadataFields

    override fun files(): FileService = files

    override fun folder(): FolderService = folder

    override fun bulkJobs(): BulkJobService = bulkJobs

    override fun accounts(): AccountService = accounts

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ImageKitClient.WithRawResponse {

        private val customMetadataFields: CustomMetadataFieldService.WithRawResponse by lazy {
            CustomMetadataFieldServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val files: FileService.WithRawResponse by lazy {
            FileServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val folder: FolderService.WithRawResponse by lazy {
            FolderServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val bulkJobs: BulkJobService.WithRawResponse by lazy {
            BulkJobServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val accounts: AccountService.WithRawResponse by lazy {
            AccountServiceImpl.WithRawResponseImpl(clientOptions)
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

        override fun folder(): FolderService.WithRawResponse = folder

        override fun bulkJobs(): BulkJobService.WithRawResponse = bulkJobs

        override fun accounts(): AccountService.WithRawResponse = accounts
    }
}
