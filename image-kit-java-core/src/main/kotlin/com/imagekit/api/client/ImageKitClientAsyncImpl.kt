// File generated from our OpenAPI spec by Stainless.

package com.imagekit.api.client

import com.imagekit.api.core.ClientOptions
import com.imagekit.api.core.getPackageVersion
import com.imagekit.api.services.async.AccountServiceAsync
import com.imagekit.api.services.async.AccountServiceAsyncImpl
import com.imagekit.api.services.async.BulkJobServiceAsync
import com.imagekit.api.services.async.BulkJobServiceAsyncImpl
import com.imagekit.api.services.async.CustomMetadataFieldServiceAsync
import com.imagekit.api.services.async.CustomMetadataFieldServiceAsyncImpl
import com.imagekit.api.services.async.FileServiceAsync
import com.imagekit.api.services.async.FileServiceAsyncImpl
import com.imagekit.api.services.async.FolderServiceAsync
import com.imagekit.api.services.async.FolderServiceAsyncImpl
import java.util.function.Consumer

class ImageKitClientAsyncImpl(private val clientOptions: ClientOptions) : ImageKitClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: ImageKitClient by lazy { ImageKitClientImpl(clientOptions) }

    private val withRawResponse: ImageKitClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val customMetadataFields: CustomMetadataFieldServiceAsync by lazy {
        CustomMetadataFieldServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val files: FileServiceAsync by lazy { FileServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val folder: FolderServiceAsync by lazy {
        FolderServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val bulkJobs: BulkJobServiceAsync by lazy {
        BulkJobServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val accounts: AccountServiceAsync by lazy {
        AccountServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): ImageKitClient = sync

    override fun withRawResponse(): ImageKitClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ImageKitClientAsync =
        ImageKitClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun customMetadataFields(): CustomMetadataFieldServiceAsync = customMetadataFields

    override fun files(): FileServiceAsync = files

    override fun folder(): FolderServiceAsync = folder

    override fun bulkJobs(): BulkJobServiceAsync = bulkJobs

    override fun accounts(): AccountServiceAsync = accounts

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ImageKitClientAsync.WithRawResponse {

        private val customMetadataFields: CustomMetadataFieldServiceAsync.WithRawResponse by lazy {
            CustomMetadataFieldServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val files: FileServiceAsync.WithRawResponse by lazy {
            FileServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val folder: FolderServiceAsync.WithRawResponse by lazy {
            FolderServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val bulkJobs: BulkJobServiceAsync.WithRawResponse by lazy {
            BulkJobServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val accounts: AccountServiceAsync.WithRawResponse by lazy {
            AccountServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ImageKitClientAsync.WithRawResponse =
            ImageKitClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun customMetadataFields(): CustomMetadataFieldServiceAsync.WithRawResponse =
            customMetadataFields

        override fun files(): FileServiceAsync.WithRawResponse = files

        override fun folder(): FolderServiceAsync.WithRawResponse = folder

        override fun bulkJobs(): BulkJobServiceAsync.WithRawResponse = bulkJobs

        override fun accounts(): AccountServiceAsync.WithRawResponse = accounts
    }
}
