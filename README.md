# ImageKit.io Java SDK

<!-- x-release-please-start-version -->

[![Maven Central](https://img.shields.io/maven-central/v/io.imagekit/image-kit-java)](https://central.sonatype.com/artifact/io.imagekit/image-kit-java/0.0.1)
[![javadoc](https://javadoc.io/badge2/io.imagekit/image-kit-java/0.0.1/javadoc.svg)](https://javadoc.io/doc/io.imagekit/image-kit-java/0.0.1)

<!-- x-release-please-end -->

The ImageKit Java SDK is a comprehensive library designed to simplify the integration of ImageKit into your server-side applications. It provides powerful tools for working with the ImageKit REST API, including building and transforming URLs, generating signed URLs for secure content delivery, verifying webhooks, and handling file uploads.

<!-- x-release-please-start-version -->

The REST API documentation can be found on [imagekit.io](https://imagekit.io/docs/api-reference). Javadocs are available on [javadoc.io](https://javadoc.io/doc/io.imagekit/image-kit-java/0.0.1).

<!-- x-release-please-end -->

## Table of Contents

- [Installation](#installation)
- [Requirements](#requirements)
- [Usage](#usage)
- [URL generation](#url-generation)
  - [Basic URL generation](#basic-url-generation)
  - [URL generation with transformations](#url-generation-with-transformations)
  - [URL generation with image overlay](#url-generation-with-image-overlay)
  - [URL generation with text overlay](#url-generation-with-text-overlay)
  - [URL generation with multiple overlays](#url-generation-with-multiple-overlays)
  - [Signed URLs for secure delivery](#signed-urls-for-secure-delivery)
- [Authentication parameters for client-side uploads](#authentication-parameters-for-client-side-uploads)
- [Webhook verification](#webhook-verification)
- [Advanced Usage](#advanced-usage)
  - [Client configuration](#client-configuration)
  - [File uploads](#file-uploads)
  - [Error handling](#error-handling)
  - [Retries](#retries)
  - [Timeouts](#timeouts)
  - [Proxies](#proxies)
  - [Logging](#logging)
- [Semantic versioning](#semantic-versioning)

## Installation

<!-- x-release-please-start-version -->

### Gradle

```kotlin
implementation("io.imagekit:image-kit-java:0.0.1")
```

### Maven

```xml
<dependency>
  <groupId>io.imagekit</groupId>
  <artifactId>image-kit-java</artifactId>
  <version>0.0.1</version>
</dependency>
```

<!-- x-release-please-end -->

## Requirements

This library requires Java 8 or later.

## Usage

```java
import io.imagekit.client.ImageKitClient;
import io.imagekit.client.okhttp.ImageKitOkHttpClient;
import io.imagekit.models.files.FileUploadParams;
import io.imagekit.models.files.FileUploadResponse;
import java.io.ByteArrayInputStream;

// Configures using the `imagekit.imagekitPrivateKey`, `imagekit.imagekitWebhookSecret` and `imagekit.baseUrl` system properties
// Or configures using the `IMAGEKIT_PRIVATE_KEY`, `IMAGEKIT_WEBHOOK_SECRET` and `IMAGE_KIT_BASE_URL` environment variables
ImageKitClient client = ImageKitOkHttpClient.fromEnv();

FileUploadParams params = FileUploadParams.builder()
    .file(new FileInputStream("/path/to/your/image.jpg"))
    .fileName("uploaded-image.jpg")
    .build();
FileUploadResponse response = client.files().upload(params);
System.out.println(response);
```

## URL generation

The ImageKit SDK provides a powerful `client.helper().buildUrl()` method for generating optimized image and video URLs with transformations.

### Basic URL generation

Generate a simple URL without any transformations:

```java
import io.imagekit.client.ImageKitClient;
import io.imagekit.client.okhttp.ImageKitOkHttpClient;
import io.imagekit.models.SrcOptions;

ImageKitClient client = ImageKitOkHttpClient.builder()
    .privateKey("private_key_xxx")
    .build();

String url = client.helper().buildUrl(
    SrcOptions.builder()
        .urlEndpoint("https://ik.imagekit.io/your_imagekit_id")
        .src("/path/to/image.jpg")
        .build()
);
System.out.println(url);
// Result: https://ik.imagekit.io/your_imagekit_id/path/to/image.jpg
```

### URL generation with transformations

Apply common transformations like resizing, quality, and format conversion:

```java
import io.imagekit.models.SrcOptions;
import io.imagekit.models.Transformation;

String url = client.helper().buildUrl(
    SrcOptions.builder()
        .urlEndpoint("https://ik.imagekit.io/your_imagekit_id")
        .src("/path/to/image.jpg")
        .addTransformation(
            Transformation.builder()
                .width(400.0)
                .height(300.0)
                .crop(Transformation.Crop.MAINTAIN_RATIO)
                .quality(80.0)
                .format(Transformation.Format.WEBP)
                .build()
        )
        .build()
);
System.out.println(url);
// Result: https://ik.imagekit.io/your_imagekit_id/path/to/image.jpg?tr=w-400,h-300,c-maintain_ratio,q-80,f-webp
```

### URL generation with image overlay

Add image overlays to your base image:

```java
import io.imagekit.models.ImageOverlay;
import io.imagekit.models.Overlay;
import io.imagekit.models.OverlayPosition;
import io.imagekit.models.SrcOptions;
import io.imagekit.models.Transformation;

String url = client.helper().buildUrl(
    SrcOptions.builder()
        .urlEndpoint("https://ik.imagekit.io/your_imagekit_id")
        .src("/path/to/base-image.jpg")
        .addTransformation(
            Transformation.builder()
                .width(500.0)
                .height(400.0)
                .overlay(Overlay.ofImage(
                    ImageOverlay.builder()
                        .input("/path/to/overlay-logo.png")
                        .position(OverlayPosition.builder()
                            .x(10.0)
                            .y(10.0)
                            .build())
                        .addTransformation(
                            Transformation.builder()
                                .width(100.0)
                                .height(50.0)
                                .build()
                        )
                        .build()
                ))
                .build()
        )
        .build()
);
System.out.println(url);
// Result: URL with image overlay positioned at x:10, y:10
```

### URL generation with text overlay

Add customized text overlays:

```java
import io.imagekit.models.Overlay;
import io.imagekit.models.OverlayPosition;
import io.imagekit.models.SrcOptions;
import io.imagekit.models.TextOverlay;
import io.imagekit.models.TextOverlayTransformation;
import io.imagekit.models.Transformation;

String url = client.helper().buildUrl(
    SrcOptions.builder()
        .urlEndpoint("https://ik.imagekit.io/your_imagekit_id")
        .src("/path/to/base-image.jpg")
        .addTransformation(
            Transformation.builder()
                .width(600.0)
                .height(400.0)
                .overlay(Overlay.ofText(
                    TextOverlay.builder()
                        .text("Sample Text Overlay")
                        .position(OverlayPosition.builder()
                            .x(50.0)
                            .y(50.0)
                            .focus(OverlayPosition.Focus.CENTER)
                            .build())
                        .addTransformation(
                            TextOverlayTransformation.builder()
                                .fontSize(40.0)
                                .fontFamily("Arial")
                                .fontColor("FFFFFF")
                                .build()
                        )
                        .build()
                ))
                .build()
        )
        .build()
);
System.out.println(url);
// Result: URL with white Arial text overlay at center position
```

### URL generation with multiple overlays

Combine multiple overlays for complex compositions:

```java
import io.imagekit.models.ImageOverlay;
import io.imagekit.models.Overlay;
import io.imagekit.models.OverlayPosition;
import io.imagekit.models.SrcOptions;
import io.imagekit.models.TextOverlay;
import io.imagekit.models.TextOverlayTransformation;
import io.imagekit.models.Transformation;
import java.util.Arrays;

String url = client.helper().buildUrl(
    SrcOptions.builder()
        .urlEndpoint("https://ik.imagekit.io/your_imagekit_id")
        .src("/path/to/base-image.jpg")
        .addTransformation(
            // First transformation step: text overlay
            Transformation.builder()
                .width(800.0)
                .height(600.0)
                .overlay(Overlay.ofText(
                    TextOverlay.builder()
                        .text("Header Text")
                        .position(OverlayPosition.builder()
                            .x(20.0)
                            .y(20.0)
                            .build())
                        .addTransformation(
                            TextOverlayTransformation.builder()
                                .fontSize(30.0)
                                .fontColor("000000")
                                .build()
                        )
                        .build()
                ))
                .build()
        )
        .addTransformation(
            // Second transformation step: image watermark overlay
            Transformation.builder()
                .overlay(Overlay.ofImage(
                    ImageOverlay.builder()
                        .input("/watermark.png")
                        .position(OverlayPosition.builder()
                            .focus(OverlayPosition.Focus.BOTTOM_RIGHT)
                            .build())
                        .addTransformation(
                            Transformation.builder()
                                .width(100.0)
                                .opacity(70.0)
                                .build()
                        )
                        .build()
                ))
                .build()
        )
        .build()
);
System.out.println(url);
// Result: URL with text overlay at top-left and semi-transparent watermark at bottom-right
```

### Signed URLs for secure delivery

Generate signed URLs that expire after a specified time for secure content delivery:

```java
import io.imagekit.models.SrcOptions;
import io.imagekit.models.Transformation;

// Generate a signed URL that expires in 1 hour (3600 seconds)
String url = client.helper().buildUrl(
    SrcOptions.builder()
        .urlEndpoint("https://ik.imagekit.io/your_imagekit_id")
        .src("/private/secure-image.jpg")
        .addTransformation(
            Transformation.builder()
                .width(400.0)
                .height(300.0)
                .quality(90.0)
                .build()
        )
        .signed(true)
        .expiresIn(3600.0) // URL expires in 1 hour
        .build()
);
System.out.println(url);
// Result: URL with signature parameters (?ik-t=timestamp&ik-s=signature)

// Generate a signed URL that doesn't expire
String permanentSignedUrl = client.helper().buildUrl(
    SrcOptions.builder()
        .urlEndpoint("https://ik.imagekit.io/your_imagekit_id")
        .src("/private/secure-image.jpg")
        .signed(true)
        // No expiresIn means the URL won't expire
        .build()
);
System.out.println(permanentSignedUrl);
// Result: URL with signature parameter (?ik-s=signature)
```

## Authentication parameters for client-side uploads

Generate authentication parameters for secure client-side file uploads:

```java
import io.imagekit.client.ImageKitClient;
import io.imagekit.client.okhttp.ImageKitOkHttpClient;
import java.util.Map;

ImageKitClient client = ImageKitOkHttpClient.builder()
    .privateKey("private_key_xxx")
    .build();

// Generate authentication parameters with auto-generated token and default expiry
Map<String, Object> authParams = client.helper().getAuthenticationParameters(null, null);
System.out.println(authParams);
// Result: {token=<uuid>, expire=<timestamp>, signature=<hmac-signature>}

// Generate with custom token and expiry
Map<String, Object> customAuthParams = client.helper().getAuthenticationParameters("my-custom-token", 1800L);
System.out.println(customAuthParams);
// Result: {token=my-custom-token, expire=1800, signature=<hmac-signature>}
```

These authentication parameters can be used in client-side upload forms to securely upload files without exposing your private API key.

## Webhook verification

The ImageKit SDK provides utilities to verify webhook signatures for secure event handling. This ensures that webhook requests are actually coming from ImageKit and haven't been tampered with.

For detailed information about webhook setup, signature verification, and handling different webhook events, refer to the [ImageKit webhook documentation](https://imagekit.io/docs/webhooks#verify-webhook-signature).

# Advanced Usage

## Client configuration

Configure the client using system properties or environment variables:

```java
import io.imagekit.client.ImageKitClient;
import io.imagekit.client.okhttp.ImageKitOkHttpClient;

// Configures using the `imagekit.imagekitPrivateKey`, `imagekit.imagekitWebhookSecret` and `imagekit.baseUrl` system properties
// Or configures using the `IMAGEKIT_PRIVATE_KEY`, `IMAGEKIT_WEBHOOK_SECRET` and `IMAGE_KIT_BASE_URL` environment variables
ImageKitClient client = ImageKitOkHttpClient.fromEnv();
```

Or manually:

```java
import io.imagekit.client.ImageKitClient;
import io.imagekit.client.okhttp.ImageKitOkHttpClient;

ImageKitClient client = ImageKitOkHttpClient.builder()
    .privateKey("private_key_xxx")
    .build();
```

Or using a combination of the two approaches:

```java
import io.imagekit.client.ImageKitClient;
import io.imagekit.client.okhttp.ImageKitOkHttpClient;

ImageKitClient client = ImageKitOkHttpClient.builder()
    // Configures using the `imagekit.imagekitPrivateKey`, `imagekit.imagekitWebhookSecret` and `imagekit.baseUrl` system properties
    // Or configures using the `IMAGEKIT_PRIVATE_KEY`, `IMAGEKIT_WEBHOOK_SECRET` and `IMAGE_KIT_BASE_URL` environment variables
    .fromEnv()
    .privateKey("private_key_xxx")
    .build();
```

See this table for the available options:

| Setter          | Environment variable             | Required | Default value               |
| --------------- | -------------------------------- | -------- | --------------------------- |
| `privateKey`    | `IMAGEKIT_PRIVATE_KEY`           | true     | -                           |
| `webhookSecret` | `IMAGEKIT_WEBHOOK_SECRET`        | false    | -                           |
| `baseUrl`       | `IMAGE_KIT_BASE_URL`             | false    | `"https://api.imagekit.io"` |

> [!TIP]
> Don't create more than one client in the same application. Each client has a connection pool and
> thread pools, which are more efficient to share between requests.

### Modifying configuration

To temporarily use a modified client configuration, while reusing the same connection and thread pools, call `withOptions()` on any client or service:

```java
import io.imagekit.client.ImageKitClient;

ImageKitClient clientWithOptions = client.withOptions(optionsBuilder -> {
    optionsBuilder.baseUrl("https://example.com");
    optionsBuilder.maxRetries(42);
});
```

The `withOptions()` method does not affect the original client or service.

## Requests and responses

To send a request to the Image Kit API, build an instance of some `Params` class and pass it to the corresponding client method. When the response is received, it will be deserialized into an instance of a Java class.

For example, `client.files().upload(...)` should be called with an instance of `FileUploadParams`, and it will return an instance of `FileUploadResponse`.

## Immutability

Each class in the SDK has an associated [builder](https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java) or factory method for constructing it.

Each class is [immutable](https://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html) once constructed. If the class has an associated builder, then it has a `toBuilder()` method, which can be used to convert it back to a builder for making a modified copy.

Because each class is immutable, builder modification will _never_ affect already built class instances.

## Asynchronous execution

The default client is synchronous. To switch to asynchronous execution, call the `async()` method:

```java
import io.imagekit.client.ImageKitClient;
import io.imagekit.client.okhttp.ImageKitOkHttpClient;
import io.imagekit.models.files.FileUploadParams;
import io.imagekit.models.files.FileUploadResponse;
import java.io.FileInputStream;
import java.util.concurrent.CompletableFuture;

// Configures using the `imagekit.imagekitPrivateKey`, `imagekit.imagekitWebhookSecret` and `imagekit.baseUrl` system properties
// Or configures using the `IMAGEKIT_PRIVATE_KEY`, `IMAGEKIT_WEBHOOK_SECRET` and `IMAGE_KIT_BASE_URL` environment variables
ImageKitClient client = ImageKitOkHttpClient.fromEnv();

FileUploadParams params = FileUploadParams.builder()
    .file(new FileInputStream("/path/to/your/image.jpg"))
    .fileName("uploaded-image.jpg")
    .build();
CompletableFuture<FileUploadResponse> response = client.async().files().upload(params);
```

Or create an asynchronous client from the beginning:

```java
import io.imagekit.client.ImageKitClientAsync;
import io.imagekit.client.okhttp.ImageKitOkHttpClientAsync;
import io.imagekit.models.files.FileUploadParams;
import io.imagekit.models.files.FileUploadResponse;
import java.io.FileInputStream;
import java.util.concurrent.CompletableFuture;

// Configures using the `imagekit.imagekitPrivateKey`, `imagekit.imagekitWebhookSecret` and `imagekit.baseUrl` system properties
// Or configures using the `IMAGEKIT_PRIVATE_KEY`, `IMAGEKIT_WEBHOOK_SECRET` and `IMAGE_KIT_BASE_URL` environment variables
ImageKitClientAsync client = ImageKitOkHttpClientAsync.fromEnv();

FileUploadParams params = FileUploadParams.builder()
    .file(new FileInputStream("/path/to/your/image.jpg"))
    .fileName("uploaded-image.jpg")
    .build();
CompletableFuture<FileUploadResponse> response = client.files().upload(params);
```

The asynchronous client supports the same options as the synchronous one, except most methods return `CompletableFuture`s.

## File uploads

The SDK defines methods that accept files.

To upload a file, pass a [`Path`](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Path.html):

```java
import io.imagekit.models.files.FileUploadParams;
import io.imagekit.models.files.FileUploadResponse;
import java.nio.file.Paths;

FileUploadParams params = FileUploadParams.builder()
    .fileName("uploaded-image.jpg")
    .file(Paths.get("/path/to/your/image.jpg"))
    .build();
FileUploadResponse response = client.files().upload(params);
```

Or an arbitrary [`InputStream`](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html):

```java
import io.imagekit.models.files.FileUploadParams;
import io.imagekit.models.files.FileUploadResponse;
import java.io.FileInputStream;

FileUploadParams params = FileUploadParams.builder()
    .fileName("uploaded-image.jpg")
    .file(new FileInputStream("/path/to/your/image.jpg"))
    .build();
FileUploadResponse response = client.files().upload(params);
```

Or a `byte[]` array:

```java
import io.imagekit.models.files.FileUploadParams;
import io.imagekit.models.files.FileUploadResponse;

byte[] imageData = /* your binary data */;
FileUploadParams params = FileUploadParams.builder()
    .fileName("binary-upload.jpg")
    .file(imageData)
    .build();
FileUploadResponse response = client.files().upload(params);
```

Note that when passing a non-`Path` its filename is unknown so it will not be included in the request. To manually set a filename, pass a [`MultipartField`](image-kit-java-core/src/main/kotlin/io/imagekit/core/Values.kt):

```java
import io.imagekit.core.MultipartField;
import io.imagekit.models.files.FileUploadParams;
import io.imagekit.models.files.FileUploadResponse;
import java.io.FileInputStream;
import java.io.InputStream;

FileUploadParams params = FileUploadParams.builder()
    .fileName("custom-upload.jpg")
    .file(MultipartField.<InputStream>builder()
        .value(new FileInputStream("/path/to/your/image.jpg"))
        .filename("image.jpg")
        .contentType("image/jpeg")
        .build())
    .build();
FileUploadResponse response = client.files().upload(params);
```

## Raw responses

The SDK defines methods that deserialize responses into instances of Java classes. However, these methods don't provide access to the response headers, status code, or the raw response body.

To access this data, prefix any HTTP method call on a client or service with `withRawResponse()`:

```java
import io.imagekit.core.http.Headers;
import io.imagekit.core.http.HttpResponseFor;
import io.imagekit.models.files.FileUploadParams;
import io.imagekit.models.files.FileUploadResponse;
import java.io.FileInputStream;

FileUploadParams params = FileUploadParams.builder()
    .file(new FileInputStream("/path/to/your/image.jpg"))
    .fileName("uploaded-image.jpg")
    .build();
HttpResponseFor<FileUploadResponse> response = client.files().withRawResponse().upload(params);

int statusCode = response.statusCode();
Headers headers = response.headers();
```

You can still deserialize the response into an instance of a Java class if needed:

```java
import io.imagekit.models.files.FileUploadResponse;

FileUploadResponse parsedResponse = response.parse();
```

## Error handling

The SDK throws custom unchecked exception types:

- [`ImageKitServiceException`](image-kit-java-core/src/main/kotlin/io/imagekit/errors/ImageKitServiceException.kt): Base class for HTTP errors. See this table for which exception subclass is thrown for each HTTP status code:

  | Status | Exception                                                                                                                  |
  | ------ | -------------------------------------------------------------------------------------------------------------------------- |
  | 400    | [`BadRequestException`](image-kit-java-core/src/main/kotlin/io/imagekit/errors/BadRequestException.kt)                     |
  | 401    | [`UnauthorizedException`](image-kit-java-core/src/main/kotlin/io/imagekit/errors/UnauthorizedException.kt)                 |
  | 403    | [`PermissionDeniedException`](image-kit-java-core/src/main/kotlin/io/imagekit/errors/PermissionDeniedException.kt)         |
  | 404    | [`NotFoundException`](image-kit-java-core/src/main/kotlin/io/imagekit/errors/NotFoundException.kt)                         |
  | 422    | [`UnprocessableEntityException`](image-kit-java-core/src/main/kotlin/io/imagekit/errors/UnprocessableEntityException.kt)   |
  | 429    | [`RateLimitException`](image-kit-java-core/src/main/kotlin/io/imagekit/errors/RateLimitException.kt)                       |
  | 5xx    | [`InternalServerException`](image-kit-java-core/src/main/kotlin/io/imagekit/errors/InternalServerException.kt)             |
  | others | [`UnexpectedStatusCodeException`](image-kit-java-core/src/main/kotlin/io/imagekit/errors/UnexpectedStatusCodeException.kt) |

- [`ImageKitIoException`](image-kit-java-core/src/main/kotlin/io/imagekit/errors/ImageKitIoException.kt): I/O networking errors.

- [`ImageKitRetryableException`](image-kit-java-core/src/main/kotlin/io/imagekit/errors/ImageKitRetryableException.kt): Generic error indicating a failure that could be retried by the client.

- [`ImageKitInvalidDataException`](image-kit-java-core/src/main/kotlin/io/imagekit/errors/ImageKitInvalidDataException.kt): Failure to interpret successfully parsed data. For example, when accessing a property that's supposed to be required, but the API unexpectedly omitted it from the response.

- [`ImageKitException`](image-kit-java-core/src/main/kotlin/io/imagekit/errors/ImageKitException.kt): Base class for all exceptions. Most errors will result in one of the previously mentioned ones, but completely generic errors may be thrown using the base class.

## Logging

The SDK uses the standard [OkHttp logging interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor).

Enable logging by setting the `IMAGE_KIT_LOG` environment variable to `info`:

```sh
export IMAGE_KIT_LOG=info
```

Or to `debug` for more verbose logging:

```sh
export IMAGE_KIT_LOG=debug
```

## ProGuard and R8

Although the SDK uses reflection, it is still usable with [ProGuard](https://github.com/Guardsquare/proguard) and [R8](https://developer.android.com/topic/performance/app-optimization/enable-app-optimization) because `image-kit-java-core` is published with a [configuration file](image-kit-java-core/src/main/resources/META-INF/proguard/image-kit-java-core.pro) containing [keep rules](https://www.guardsquare.com/manual/configuration/usage).

ProGuard and R8 should automatically detect and use the published rules, but you can also manually copy the keep rules if necessary.

## Jackson

The SDK depends on [Jackson](https://github.com/FasterXML/jackson) for JSON serialization/deserialization. It is compatible with version 2.13.4 or higher, but depends on version 2.18.2 by default.

The SDK throws an exception if it detects an incompatible Jackson version at runtime (e.g. if the default version was overridden in your Maven or Gradle config).

If the SDK threw an exception, but you're _certain_ the version is compatible, then disable the version check using the `checkJacksonVersionCompatibility` on [`ImageKitOkHttpClient`](image-kit-java-client-okhttp/src/main/kotlin/io/imagekit/client/okhttp/ImageKitOkHttpClient.kt) or [`ImageKitOkHttpClientAsync`](image-kit-java-client-okhttp/src/main/kotlin/io/imagekit/client/okhttp/ImageKitOkHttpClientAsync.kt).

> [!CAUTION]
> We make no guarantee that the SDK works correctly when the Jackson version check is disabled.

Also note that there are bugs in older Jackson versions that can affect the SDK. We don't work around all Jackson bugs ([example](https://github.com/FasterXML/jackson-databind/issues/3240)) and expect users to upgrade Jackson for those instead.

## Network options

### Retries

The SDK automatically retries 2 times by default, with a short exponential backoff between requests.

Only the following error types are retried:

- Connection errors (for example, due to a network connectivity problem)
- 408 Request Timeout
- 409 Conflict
- 429 Rate Limit
- 5xx Internal

The API may also explicitly instruct the SDK to retry or not retry a request.

To set a custom number of retries, configure the client using the `maxRetries` method:

```java
import io.imagekit.client.ImageKitClient;
import io.imagekit.client.okhttp.ImageKitOkHttpClient;

ImageKitClient client = ImageKitOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build();
```

### Timeouts

Requests time out after 1 minute by default.

To set a custom timeout, configure the method call using the `timeout` method:

```java
import io.imagekit.models.files.FileUploadResponse;

FileUploadResponse response = client.files().upload(
  params, RequestOptions.builder().timeout(Duration.ofSeconds(30)).build()
);
```

Or configure the default for all method calls at the client level:

```java
import io.imagekit.client.ImageKitClient;
import io.imagekit.client.okhttp.ImageKitOkHttpClient;
import java.time.Duration;

ImageKitClient client = ImageKitOkHttpClient.builder()
    .fromEnv()
    .timeout(Duration.ofSeconds(30))
    .build();
```

### Proxies

To route requests through a proxy, configure the client using the `proxy` method:

```java
import io.imagekit.client.ImageKitClient;
import io.imagekit.client.okhttp.ImageKitOkHttpClient;
import java.net.InetSocketAddress;
import java.net.Proxy;

ImageKitClient client = ImageKitOkHttpClient.builder()
    .fromEnv()
    .proxy(new Proxy(
      Proxy.Type.HTTP, new InetSocketAddress(
        "https://example.com", 8080
      )
    ))
    .build();
```

### Connection pooling

To customize the underlying OkHttp connection pool, configure the client using the `maxIdleConnections` and `keepAliveDuration` methods:

```java
import io.imagekit.client.ImageKitClient;
import io.imagekit.client.okhttp.ImageKitOkHttpClient;
import java.time.Duration;

ImageKitClient client = ImageKitOkHttpClient.builder()
    .fromEnv()
    // If `maxIdleConnections` is set, then `keepAliveDuration` must be set, and vice versa.
    .maxIdleConnections(10)
    .keepAliveDuration(Duration.ofMinutes(2))
    .build();
```

If both options are unset, OkHttp's default connection pool settings are used.

### HTTPS

> [!NOTE]
> Most applications should not call these methods, and instead use the system defaults. The defaults include
> special optimizations that can be lost if the implementations are modified.

To configure how HTTPS connections are secured, configure the client using the `sslSocketFactory`, `trustManager`, and `hostnameVerifier` methods:

```java
import io.imagekit.client.ImageKitClient;
import io.imagekit.client.okhttp.ImageKitOkHttpClient;

ImageKitClient client = ImageKitOkHttpClient.builder()
    .fromEnv()
    // If `sslSocketFactory` is set, then `trustManager` must be set, and vice versa.
    .sslSocketFactory(yourSSLSocketFactory)
    .trustManager(yourTrustManager)
    .hostnameVerifier(yourHostnameVerifier)
    .build();
```

### Custom HTTP client

The SDK consists of three artifacts:

- `image-kit-java-core`
  - Contains core SDK logic
  - Does not depend on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`ImageKitClient`](image-kit-java-core/src/main/kotlin/io/imagekit/client/ImageKitClient.kt), [`ImageKitClientAsync`](image-kit-java-core/src/main/kotlin/io/imagekit/client/ImageKitClientAsync.kt), [`ImageKitClientImpl`](image-kit-java-core/src/main/kotlin/io/imagekit/client/ImageKitClientImpl.kt), and [`ImageKitClientAsyncImpl`](image-kit-java-core/src/main/kotlin/io/imagekit/client/ImageKitClientAsyncImpl.kt), all of which can work with any HTTP client
- `image-kit-java-client-okhttp`
  - Depends on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`ImageKitOkHttpClient`](image-kit-java-client-okhttp/src/main/kotlin/io/imagekit/client/okhttp/ImageKitOkHttpClient.kt) and [`ImageKitOkHttpClientAsync`](image-kit-java-client-okhttp/src/main/kotlin/io/imagekit/client/okhttp/ImageKitOkHttpClientAsync.kt), which provide a way to construct [`ImageKitClientImpl`](image-kit-java-core/src/main/kotlin/io/imagekit/client/ImageKitClientImpl.kt) and [`ImageKitClientAsyncImpl`](image-kit-java-core/src/main/kotlin/io/imagekit/client/ImageKitClientAsyncImpl.kt), respectively, using OkHttp
- `image-kit-java`
  - Depends on and exposes the APIs of both `image-kit-java-core` and `image-kit-java-client-okhttp`
  - Does not have its own logic

This structure allows replacing the SDK's default HTTP client without pulling in unnecessary dependencies.

#### Customized [`OkHttpClient`](https://square.github.io/okhttp/3.x/okhttp/okhttp3/OkHttpClient.html)

> [!TIP]
> Try the available [network options](#network-options) before replacing the default client.

To use a customized `OkHttpClient`:

1. Replace your [`image-kit-java` dependency](#installation) with `image-kit-java-core`
2. Copy `image-kit-java-client-okhttp`'s [`OkHttpClient`](image-kit-java-client-okhttp/src/main/kotlin/io/imagekit/client/okhttp/OkHttpClient.kt) class into your code and customize it
3. Construct [`ImageKitClientImpl`](image-kit-java-core/src/main/kotlin/io/imagekit/client/ImageKitClientImpl.kt) or [`ImageKitClientAsyncImpl`](image-kit-java-core/src/main/kotlin/io/imagekit/client/ImageKitClientAsyncImpl.kt), similarly to [`ImageKitOkHttpClient`](image-kit-java-client-okhttp/src/main/kotlin/io/imagekit/client/okhttp/ImageKitOkHttpClient.kt) or [`ImageKitOkHttpClientAsync`](image-kit-java-client-okhttp/src/main/kotlin/io/imagekit/client/okhttp/ImageKitOkHttpClientAsync.kt), using your customized client

### Completely custom HTTP client

To use a completely custom HTTP client:

1. Replace your [`image-kit-java` dependency](#installation) with `image-kit-java-core`
2. Write a class that implements the [`HttpClient`](image-kit-java-core/src/main/kotlin/io/imagekit/core/http/HttpClient.kt) interface
3. Construct [`ImageKitClientImpl`](image-kit-java-core/src/main/kotlin/io/imagekit/client/ImageKitClientImpl.kt) or [`ImageKitClientAsyncImpl`](image-kit-java-core/src/main/kotlin/io/imagekit/client/ImageKitClientAsyncImpl.kt), similarly to [`ImageKitOkHttpClient`](image-kit-java-client-okhttp/src/main/kotlin/io/imagekit/client/okhttp/ImageKitOkHttpClient.kt) or [`ImageKitOkHttpClientAsync`](image-kit-java-client-okhttp/src/main/kotlin/io/imagekit/client/okhttp/ImageKitOkHttpClientAsync.kt), using your new client class

## Undocumented API functionality

The SDK is typed for convenient usage of the documented API. However, it also supports working with undocumented or not yet supported parts of the API.

### Parameters

To set undocumented parameters, call the `putAdditionalHeader`, `putAdditionalQueryParam`, or `putAdditionalBodyProperty` methods on any `Params` class:

```java
import io.imagekit.core.JsonValue;
import io.imagekit.models.files.FileUploadParams;

FileUploadParams params = FileUploadParams.builder()
    .putAdditionalHeader("Secret-Header", "42")
    .putAdditionalQueryParam("secret_query_param", "42")
    .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
    .build();
```

These can be accessed on the built object later using the `_additionalHeaders()`, `_additionalQueryParams()`, and `_additionalBodyProperties()` methods.

To set undocumented parameters on _nested_ headers, query params, or body classes, call the `putAdditionalProperty` method on the nested class:

```java
import io.imagekit.core.JsonValue;
import io.imagekit.models.files.FileUploadParams;

FileUploadParams params = FileUploadParams.builder()
    .transformation(FileUploadParams.UploadTransformation.builder()
        .putAdditionalProperty("secretProperty", JsonValue.from("42"))
        .build())
    .build();
```

These properties can be accessed on the nested built object later using the `_additionalProperties()` method.

To set a documented parameter or property to an undocumented or not yet supported _value_, pass a [`JsonValue`](image-kit-java-core/src/main/kotlin/io/imagekit/core/Values.kt) object to its setter:

```java
import io.imagekit.core.JsonValue;
import io.imagekit.models.files.FileUploadParams;

FileUploadParams params = FileUploadParams.builder()
    .file(JsonValue.from(42))
    .fileName("file-name.jpg")
    .build();
```

The most straightforward way to create a [`JsonValue`](image-kit-java-core/src/main/kotlin/io/imagekit/core/Values.kt) is using its `from(...)` method:

```java
import io.imagekit.core.JsonValue;
import java.util.List;
import java.util.Map;

// Create primitive JSON values
JsonValue nullValue = JsonValue.from(null);
JsonValue booleanValue = JsonValue.from(true);
JsonValue numberValue = JsonValue.from(42);
JsonValue stringValue = JsonValue.from("Hello World!");

// Create a JSON array value equivalent to `["Hello", "World"]`
JsonValue arrayValue = JsonValue.from(List.of(
  "Hello", "World"
));

// Create a JSON object value equivalent to `{ "a": 1, "b": 2 }`
JsonValue objectValue = JsonValue.from(Map.of(
  "a", 1,
  "b", 2
));

// Create an arbitrarily nested JSON equivalent to:
// {
//   "a": [1, 2],
//   "b": [3, 4]
// }
JsonValue complexValue = JsonValue.from(Map.of(
  "a", List.of(
    1, 2
  ),
  "b", List.of(
    3, 4
  )
));
```

Normally a `Builder` class's `build` method will throw [`IllegalStateException`](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalStateException.html) if any required parameter or property is unset.

To forcibly omit a required parameter or property, pass [`JsonMissing`](image-kit-java-core/src/main/kotlin/io/imagekit/core/Values.kt):

```java
import io.imagekit.core.JsonMissing;
import io.imagekit.models.files.FileUploadParams;

FileUploadParams params = FileUploadParams.builder()
    .fileName("fileName")
    .file(JsonMissing.of())
    .build();
```

### Response properties

To access undocumented response properties, call the `_additionalProperties()` method:

```java
import io.imagekit.core.JsonValue;
import java.util.Map;

Map<String, JsonValue> additionalProperties = client.files().upload(params)._additionalProperties();
JsonValue secretPropertyValue = additionalProperties.get("secretProperty");

String result = secretPropertyValue.accept(new JsonValue.Visitor<>() {
    @Override
    public String visitNull() {
        return "It's null!";
    }

    @Override
    public String visitBoolean(boolean value) {
        return "It's a boolean!";
    }

    @Override
    public String visitNumber(Number value) {
        return "It's a number!";
    }

    // Other methods include `visitMissing`, `visitString`, `visitArray`, and `visitObject`
    // The default implementation of each unimplemented method delegates to `visitDefault`, which throws by default, but can also be overridden
});
```

To access a property's raw JSON value, which may be undocumented, call its `_` prefixed method:

```java
import io.imagekit.core.JsonField;
import java.io.InputStream;
import java.util.Optional;

JsonField<InputStream> file = client.files().upload(params)._file();

if (file.isMissing()) {
  // The property is absent from the JSON response
} else if (file.isNull()) {
  // The property was set to literal null
} else {
  // Check if value was provided as a string
  // Other methods include `asNumber()`, `asBoolean()`, etc.
  Optional<String> jsonString = file.asString();

  // Try to deserialize into a custom type
  MyClass myObject = file.asUnknown().orElseThrow().convert(MyClass.class);
}
```

### Response validation

In rare cases, the API may return a response that doesn't match the expected type. For example, the SDK may expect a property to contain a `String`, but the API could return something else.

By default, the SDK will not throw an exception in this case. It will throw [`ImageKitInvalidDataException`](image-kit-java-core/src/main/kotlin/io/imagekit/errors/ImageKitInvalidDataException.kt) only if you directly access the property.

If you would prefer to check that the response is completely well-typed upfront, then either call `validate()`:

```java
import io.imagekit.models.files.FileUploadResponse;

FileUploadResponse response = client.files().upload(params).validate();
```

Or configure the method call to validate the response using the `responseValidation` method:

```java
import io.imagekit.models.files.FileUploadResponse;

FileUploadResponse response = client.files().upload(
  params, RequestOptions.builder().responseValidation(true).build()
);
```

Or configure the default for all method calls at the client level:

```java
import io.imagekit.client.ImageKitClient;
import io.imagekit.client.okhttp.ImageKitOkHttpClient;

ImageKitClient client = ImageKitOkHttpClient.builder()
    .fromEnv()
    .responseValidation(true)
    .build();
```

## FAQ

### Why don't you use plain `enum` classes?

Java `enum` classes are not trivially [forwards compatible](https://www.stainless.com/blog/making-java-enums-forwards-compatible). Using them in the SDK could cause runtime exceptions if the API is updated to respond with a new enum value.

### Why do you represent fields using `JsonField<T>` instead of just plain `T`?

Using `JsonField<T>` enables a few features:

- Allowing usage of [undocumented API functionality](#undocumented-api-functionality)
- Lazily [validating the API response against the expected shape](#response-validation)
- Representing absent vs explicitly null values

### Why don't you use [`data` classes](https://kotlinlang.org/docs/data-classes.html)?

It is not [backwards compatible to add new fields to a data class](https://kotlinlang.org/docs/api-guidelines-backward-compatibility.html#avoid-using-data-classes-in-your-api) and we don't want to introduce a breaking change every time we add a field to a class.

### Why don't you use checked exceptions?

Checked exceptions are widely considered a mistake in the Java programming language. In fact, they were omitted from Kotlin for this reason.

Checked exceptions:

- Are verbose to handle
- Encourage error handling at the wrong level of abstraction, where nothing can be done about the error
- Are tedious to propagate due to the [function coloring problem](https://journal.stuffwithstuff.com/2015/02/01/what-color-is-your-function)
- Don't play well with lambdas (also due to the function coloring problem)

## Semantic versioning

This package generally follows [SemVer](https://semver.org/spec/v2.0.0.html) conventions, though certain backwards-incompatible changes may be released as minor versions:

1. Changes to library internals which are technically public but not intended or documented for external use. _(Please open a GitHub issue to let us know if you are relying on such internals.)_
2. Changes that we do not expect to impact the vast majority of users in practice.

We take backwards-compatibility seriously and work hard to ensure you can rely on a smooth upgrade experience.

We are keen for your feedback; please open an [issue](https://www.github.com/imagekit-developer/imagekit-java/issues) with questions, bugs, or suggestions.
