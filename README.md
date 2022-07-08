# ImageKit Java SDK

[![Java CI](https://github.com/imagekit-developer/imagekit-java/workflows/Java%20CI/badge.svg)](https://github.com/imagekit-developer/imagekit-java)
[![Release](https://jitpack.io/v/com.github.imagekit-developer/imagekit-java.svg)](https://jitpack.io/#com.github.imagekit-developer/imagekit-java)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Twitter Follow](https://img.shields.io/twitter/follow/imagekitio?label=Follow&style=social)](https://twitter.com/ImagekitIo)
 
Java SDK for [ImageKit.io](https://imagekit.io/) that implements the new APIs and interface for performing different file operations.

ImageKit is complete media storage, optimization, and transformation solution that comes with an [image and video CDN](https://imagekit.io). It can be integrated with your existing infrastructure - storage like AWS S3, web servers, your CDN, and custom domain names, allowing you to deliver optimized images in minutes with minimal code changes.

Table of contents -
 * [Installation](#installation)
 * [Initialization](#initialization)
 * [Usage](#usage)
 * [Versioning](#versioning)
 * [URL generation](#url-generation)
 * [File upload](#file-upload)
 * [File management](#file-management)
 * [Utility functions](#utility-functions)
 * [Handling errors](#handling-errors)
 * [Support](#support)
 * [Links](#links)
 
## Installation

### Requirements

- Java 1.8 or later

### Gradle users
Step 1. Add the JitPack repository to your build file
```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
Step 2. Add the dependency on the project's `build.gradle`:
```
dependencies {
        implementation 'com.github.imagekit-developer:imagekit-java:2.0.0'
}
```
### Maven users
Step 1. Add the JitPack repository to your build file
```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
Step 2. Add the dependency in the POM file:
```
<dependency>
    <groupId>com.github.imagekit-developer</groupId>
    <artifactId>imagekit-java</artifactId>
    <version>2.0.0</version>
</dependency>
```

## Initialization

**Step 1**. Create a `config.properties` file inside `src/main/resources` of your project. And put essential values of keys [UrlEndpoint, PrivateKey, PublicKey], no need to use quote(`'` or `"`) in values. 

 You can get the value of [URL-endpoint](https://imagekit.io/dashboard#url-endpoints) from your ImageKit dashboard. API keys can be obtained from the [developer](https://imagekit.io/dashboard/developer/api-keys) section in your ImageKit dashboard.

```editorconfig
# Put essential values of keys [UrlEndpoint, PrivateKey, PublicKey]
UrlEndpoint=your_public_api_key
PrivateKey=your_private_api_key
PublicKey=https://ik.imagekit.io/imagekit_id/
```

**Step 2**. Then you need to initialize ImageKit with that configuration. 

 ```java
import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.config.Configuration;
import io.imagekit.sdk.utils.Utils;
class App {
    public static void main(String[] args){
        ImageKit imageKit=ImageKit.getInstance();
        Configuration config=Utils.getSystemConfig(App.class);
        imageKit.setConfig(config);
    }
}
```

or

 ```java
import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.config.Configuration;
import io.imagekit.sdk.utils.Utils;
class App {
    public static void main(String[] args) {
        ImageKit imageKit = ImageKit.getInstance();
        Configuration config = new Configuration("your_public_key", "your_private_key", "your_url_endpoint");
        imageKit.setConfig(config);
    }
}
```

## Usage
You can use this Java SDK for 3 different kinds of methods:

* URL generation
* file upload
* file management

The usage of the SDK has been explained below.

## Change log
This document presents a list of changes that break the existing functionality of previous versions. We try our best to minimize these disruptions, but sometimes they are unavoidable and will be in major versions.

### Breaking History:

Changes from 1.0.3 -> 2.0.0 are listed below

1. Result `raw` object and `getMap()` properties:

**What changed**
- `raw` and `getMap()` has been deprecated.

**Who is affected?**
- This affects any development that uses the `raw` or `getMap()` from the response object of APIs and Result object.

**How should I update my code?**
- If you still need to use `raw` and `getMap()`, do this `result.getResponseMetaData().getRaw()`.
 
2. Result object `message` and `isSuccessful` boolean properties:

**What changed**
- `message` and `isSuccessful` have been replaced with custom exceptions according to response code.

**Who is affected?**
- This affects any development that uses the `message` or `isSuccessful` from response object of APIs that is Result object.

**How should I update my code?**
- If you still need to use `message` it will be there in the custom exceptions that could be raised when calling the various API methods. `isSuccessful` can be understood to be `true` if the API method doesn't throw any exception.


## URL generation

**1. Using image path and URL-endpoint**

This method allows you to create an URL to access a file using the relative file path and the ImageKit URL endpoint (`urlEndpoint`). The file can be an image, video, or any other static file supported by ImageKit.

```java
Map<String, String> queryParam=new HashMap<>();
queryParam.put("v","123");

List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
Map<String, String> scale=new HashMap<>();
scale.put("height","600");
scale.put("width","400");
scale.put("raw", "ar-4-3,q-40");
transformation.add(scale);
    
Map<String, Object> options=new HashMap();
options.put("urlEndpoint","https://ik.imagekit.io/your_imagekit_id/");
options.put("path","/default-image.jpg");
options.put("transformation", transformation);

String url = ImageKit.getInstance().getUrl(options);
```
The result in a URL like
```
https://ik.imagekit.io/your_imagekit_id/tr:w-400,h-600/default-image.jpg?v=123
```

**2. Using full image URL**
This method allows you to add transformation parameters to an absolute URL. For example, if you have configured a custom CNAME and have absolute asset URLs in your database or CMS, you will often need this.

```java
List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
Map<String, String> scale=new HashMap<>();
scale.put("height","600");
scale.put("width","400");
scale.put("raw", "ar-4-3,q-40");
transformation.add(scale);

Map<String, Object> options=new HashMap();
options.put("src","https://ik.imagekit.io/your_imagekit_id/default-image.jpg");
options.put("transformation", transformation);

String url = ImageKit.getInstance().getUrl(options);
```

The results in a URL like

```
https://ik.imagekit.io/your_imagekit_id/default-image.jpg?tr=w-400,h-600
```

The ```.getUrl()``` method accepts the following parameters

| Option                  | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| :---------------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| urlEndpoint            | Optional. `(Type: String)` The base URL to be appended before the path of the image. If not specified, the URL Endpoint specified during SDK initialization is used. For example, https://ik.imagekit.io/your_imagekit_id/                                                                                                                                                                                                                                                                                                                                             |
| path                    | Conditional. `(Type: String)` This is the path at which the image exists. For example, `/path/to/image.jpg`. Either the `path` or `src` parameter needs to be specified for URL generation.                                                                                                                                                                                                                                                                                                                                                                                                |
| src                     | Conditional. `(Type: String)` This is the complete URL of an image already mapped to ImageKit. For example, `https://ik.imagekit.io/your_imagekit_id/endpoint/path/to/image.jpg`. Either the `path` or `src` parameter needs to be specified for URL generation.                                                                                                                                                                                                                                                                                                                           |
| transformation          | Optional. `(Type: List<Map<String,String>>)` An array of objects specifying the transformation to be applied in the URL. The transformation name and the value should be specified as a key-value pair in the object. Different steps of a [chained transformation](https://docs.imagekit.io/features/image-transformations/chained-transformations) can be specified as different objects of the array. The complete list of supported transformations in the SDK and some examples of using them are given later. If you use a transformation name that is not specified in the SDK, it gets applied as it is in the URL. |
| transformationPosition | Optional. `(Type: String)` Default value is `path` that places the transformation string as a path parameter in the URL. It can also be specified as `query`, which adds the transformation string as the query parameter `tr` in the URL. If you use the `src` parameter to create the URL, then the transformation string is always added as a query parameter.                                                                                                                                                                                                                                 |
| queryParameters        | Optional. `(Type: Map<String, String>)` These are the other query parameters that you want to add to the final URL. These can be any query parameters and not necessarily related to ImageKit. Especially useful if you want to add some versioning parameters to your URLs.                                                                                                                                                                                                                                                                                                                           |
| signed                  | Optional. `(Type: Boolean)` Default is `false`. If set to `true`, the SDK generates a signed image URL adding the image signature to the image URL. This can only be used if you create the URL with the `url_endpoint` and `path` parameters and not with the `src` parameter.                                                                                                                                                                                                                                                                                            |
| expireSeconds          | Optional. `(Type: Integer)` Meant to be used along with the `signed` parameter to specify the time in seconds from now when the URL should expire. If specified, the URL contains the expiry timestamp in the URL, and the image signature is modified accordingly.                                                                                                                                                                                                                                                                                                                |


## Examples of generating URLs
**1. Chained Transformations as a query parameter**

```java
List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
Map<String, String> scale=new HashMap<>();
scale.put("height","300");
scale.put("width","400");
transformation.add(scale);
Map<String, String> rotate=new HashMap<>();
rotate.put("rotation","90");
transformation.add(rotate);

Map<String, Object> options=new HashMap();
options.put("path","/default-image.jpg");
options.put("transformationPosition","query");
options.put("transformation", transformation);

String url = ImageKit.getInstance().getUrl(options);
```

Sample Result URL -
```
https://ik.imagekit.io/your_imagekit_id/default-image.jpg?tr=h-300&w-400:rt-90
```

**2. Sharpening and contrast transform and a progressive JPG image**

There are some transforms like [Sharpening](https://docs.imagekit.io/features/image-transformations/image-enhancement-and-color-manipulation)
that can be added to the URL with or without any other value. To use such transforms without specifying a value, specify
the value as "-" in the transformation object. Otherwise, specify the value that you want to be
added to this transformation.

```java
List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
Map<String, String> scale=new HashMap<>();
scale.put("format","jpg");
scale.put("progressive","true");
scale.put("effect_sharpen","-");
scale.put("effect_contrast","1");
transformation.add(scale);

Map<String, Object> options=new HashMap();
options.put("path","/default-image.jpg");
options.put("transformation", transformation);
String url = ImageKit.getInstance().getUrl(options);
```

Note that because the `src` parameter was used, the transformation string gets added as a query parameter.

```
https://ik.imagekit.io/your_imagekit_id/default-image.jpg?tr=f-jpg&pr-true&e-sharpen&e-contrast-1
```

**3. Signed URL that expires in 300 seconds with the default URL endpoint and other query parameters**

```java
List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
Map<String, String> scale=new HashMap<>();
scale.put("height","600");
scale.put("width","400");

transformation.add(format);

Map<String, Object> options=new HashMap();
options.put("path","/default-image.jpg");
options.put("signed",true);
options.put("expireSeconds",300);
String url = ImageKit.getInstance().getUrl(options);
```
**Sample Result URL**
```
https://ik.imagekit.io/your_imagekit_id/tr:h-600,w-400/default-image.jpg?ik-t=1567358667&ik-s=f2c7cdacbe7707b71a83d49cf1c6110e3d701054
```

**List of transformations**

See the complete list of [image](https://docs.imagekit.io/features/image-transformations) and [video](https://docs.imagekit.io/features/video-transformation) transformations supported in ImageKit. The SDK gives a name to each transformation parameter e.g. `height` for `h` and `width` for `w` parameter. It makes your code more readable. If the property does not match any of the following supported options, it is added as it is.

If you want to generate transformations in your application and add them to the URL as it is, use the `raw` parameter.

| Supported Transformation Name | Translates to parameter |
|-------------------------------|-------------------------|
| height | h |
| width | w |
| aspectRatio | ar |
| quality | q |
| crop | c |
| cropMode | cm |
| x | x |
| y | y |
| focus | fo |
| format | f |
| radius | r |
| background | bg |
| border | b |
| rotation | rt |
| blur | bl |
| named | n |
| overlayX | ox |
| overlayY | oy |
| overlayFocus | ofo |
| overlayHeight | oh |
| overlayWidth | ow |
| overlayImage | oi |
| overlayImageTrim | oit |
| overlayImageAspectRatio | oiar |
| overlayImageBackground | oibg |
| overlayImageBorder | oib |
| overlayImageDPR | oidpr |
| overlayImageQuality | oiq |
| overlayImageCropping | oic |
| overlayImageFocus | oifo |
| overlayText | ot |
| overlayTextFontSize | ots |
| overlayTextFontFamily | otf |
| overlayTextColor | otc |
| overlayTextTransparency | oa |
| overlayAlpha | oa |
| overlayTextTypography | ott |
| overlayBackground | obg |
| overlayTextEncoded | ote |
| overlayTextWidth | otw |
| overlayTextBackground | otbg |
| overlayTextPadding | otp |
| overlayTextInnerAlignment | otia |
| overlayRadius | or |
| progressive | pr |
| lossless | lo |
| trim | t |
| metadata | md |
| colorProfile | cp |
| defaultImage | di |
| dpr | dpr |
| effectSharpen | e-sharpen |
| effectUSM | e-usm |
| effectContrast | e-contrast |
| effectGray | e-grayscale |
| original | orig |
| raw | `replaced by the parameter value` |


## File Upload

The SDK provides a simple interface using the `.upload()` method to upload files to the ImageKit Media library. It
accepts an object of the `FileCreateRequest` class that contains all the parameters supported by the [ImageKit Upload API](https://docs.imagekit.io/api-reference/upload-file-api/server-side-file-upload).

The constructor `FileCreateRequest` class requires `file` as (URL/Base64/Byte Array) and `file_name`. The method returns object of `Result` in case of successful, or it will throw custom exception in case of failure.

Sample usage

```java
String filePath = "your-local-file-path";
String base64 = Utils.fileToBase64(new File(filePath));
FileCreateRequest fileCreateRequest = new FileCreateRequest(base64, "file_name.jpg");
String customCoordinates = "10,10,20,20";
fileCreateRequest.setCustomCoordinates(customCoordinates);  // optional
List<String> tags = new ArrayList<>();
tags.add("Sample-tag");
tags.add("T-shirt");
fileCreateRequest.setTags(tags); // optional
fileCreateRequest.setFileName("override_file_name.jpg");  // optional
fileCreateRequest.setFolder("sample-folder/nested-folder");  // optional
fileCreateRequest.setPrivateFile(false);  // optional
fileCreateRequest.setUseUniqueFileName(true);  // optional
List<String> responseFields=new ArrayList<>();
responseFields.add("tags");
responseFields.add("customCoordinates");
fileCreateRequest.setResponseFields(responseFields); // optional
JsonObject innerObject1 = new JsonObject();
innerObject1.addProperty("name", "remove-bg");
innerObject1.add("options", optionsInnerObject);
JsonObject innerObject2 = new JsonObject();
innerObject2.addProperty("name", "google-auto-tagging");
innerObject2.addProperty("minConfidence", 10);
innerObject2.addProperty("maxTags", 5);
JsonArray jsonArray = new JsonArray();
jsonArray.add(innerObject1);
jsonArray.add(innerObject2);
fileCreateRequest.setExtensions(jsonArray); // optional
fileCreateRequest.setWebhookUrl("Your webhook url"); // optional
fileCreateRequest.setOverwriteFile(true); // optional
fileCreateRequest.setOverwriteAITags(true); // optional
fileCreateRequest.setOverwriteTags(true); // optional
fileCreateRequest.setOverwriteCustomMetadata(true); // optional
JsonObject jsonObjectCustomMetadata = new JsonObject();
jsonObjectCustomMetadata.addProperty("test1", 10);
fileCreateRequest.setCustomMetadata(jsonObjectCustomMetadata); // optional
Result result = ImageKit.getInstance().upload(fileCreateRequest);
System.out.println("======FINAL RESULT=======");
System.out.println(result);
System.out.println("Raw Response:");
System.out.println(result.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(result.getResponseMetaData().getMap());
```

If the upload is successful, result will be there as an object of `Result` class that contains the same all the parameters received from ImageKit's servers.

If the upload fails, custom exception is thrown and `getMessage()` can be called to get the error message received from ImageKit's servers.


## File Management

The SDK provides a simple interface for all the [media APIs mentioned here](https://docs.imagekit.io/api-reference/media-api) to manage your files. This also returns `error` and `result`, the error will be `None` if API succeeds.

**1. List & Search Files**

Accepts an object of class `GetFileListRequest` specifying the parameters to be used to list and search files. All parameters specified in the [documentation here](https://docs.imagekit.io/api-reference/media-api/list-and-search-files) can be passed via their setter functions to get the results.

```java
String[] tags = new String[3];
tags[0] = "Software";
tags[1] = "Developer";
tags[2] = "Engineer";
GetFileListRequest getFileListRequest = new GetFileListRequest();
getFileListRequest.setType("file");
getFileListRequest.setSort("ASC_CREATED");
getFileListRequest.setPath("/");
getFileListRequest.setSearchQuery("createdAt >= '2d' OR size < '2mb' OR format='png'");
getFileListRequest.setFileType("all");
getFileListRequest.setLimit("4");
getFileListRequest.setSkip("1");
getFileListRequest.setTags(tags);
ResultList resultList = ImageKit.getInstance().getFileList(getFileListRequest);
System.out.println("======FINAL RESULT=======");
System.out.println(resultList);
System.out.println("Raw Response:");
System.out.println(resultList.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultList.getResponseMetaData().getMap());
```

**2. Get File Details**

Accepts the file ID and fetches the details as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/get-file-details)

```java
String fileId="your-file-id";
Result result=ImageKit.getInstance().getFileDetail(fileId);
System.out.println("======FINAL RESULT=======");
System.out.println(result);
System.out.println("Raw Response:");
System.out.println(result.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(result.getResponseMetaData().getMap());
```

**3. Get File Versions**

Accepts the file ID and fetches the details as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/get-file-versions).

```java
String fileId = "62a04834c10d49825c6de9e8";
ResultFileVersions resultFileVersions = ImageKit.getInstance().getFileVersions(fileId);
System.out.println("======FINAL RESULT=======");
System.out.println(resultFileVersions);
System.out.println("Raw Response:");
System.out.println(resultFileVersions.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultFileVersions.getResponseMetaData().getMap());
```

**4. Get File Version details**

Accepts the file ID and version ID and fetches the details as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/get-file-version-details).

```java
String fileId = "62a04834c10d49825c6de9e8";
String versionId = "62a04834c10d49825c6de9e8";
ResultFileVersionDetails resultFileVersionDetails = ImageKit.getInstance().getFileVersionDetails(fileId, versionId);
System.out.println("======FINAL RESULT=======");
System.out.println(resultFileVersionDetails);
System.out.println("Raw Response:");
System.out.println(resultFileVersionDetails.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultFileVersionDetails.getResponseMetaData().getMap());
```

**5. Update File Details**

Accepts an object of class `FileUpdateRequest` specifying the parameters to be used to update file details. All parameters specified in the [documentation here] (https://docs.imagekit.io/api-reference/media-api/update-file-details) can be passed via their setter functions to get the results.

```java
List<String> tags = new ArrayList<>();
tags.add("Software");
tags.add("Developer");
tags.add("Engineer");

List<String> aiTags = new ArrayList<>();
aiTags.add("Plant");
FileUpdateRequest fileUpdateRequest = new FileUpdateRequest("fileId");
fileUpdateRequest.setTags(tags);
fileUpdateRequest.setRemoveAITags(aiTags);
fileUpdateRequest.setWebhookUrl("https://webhook.site/c78d617f-33bc-40d9-9e61-608999721e2e");

JsonObject optionsInnerObject = new JsonObject();
optionsInnerObject.addProperty("add_shadow", true);
optionsInnerObject.addProperty("bg_color", "yellow");
JsonObject innerObject1 = new JsonObject();
innerObject1.addProperty("name", "remove-bg");
innerObject1.add("options", optionsInnerObject);
JsonObject innerObject2 = new JsonObject();
innerObject2.addProperty("name", "google-auto-tagging");
innerObject2.addProperty("minConfidence", 15);
innerObject2.addProperty("maxTags", 20);
JsonArray jsonArray = new JsonArray();
jsonArray.add(innerObject1);
jsonArray.add(innerObject2);

fileUpdateRequest.setExtensions(jsonArray);
fileUpdateRequest.setCustomCoordinates("10,10,40,40");
JsonObject jsonObjectCustomMetadata = new JsonObject();
jsonObjectCustomMetadata.addProperty("test10", 11);
fileUpdateRequest.setCustomMetadata(jsonObjectCustomMetadata);
Result result=ImageKit.getInstance().updateFileDetail(fileUpdateRequest);
System.out.println("======FINAL RESULT=======");
System.out.println(result);
System.out.println("Raw Response:");
System.out.println(result.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(result.getResponseMetaData().getMap());
```

**6. Add tags**

Accepts the file IDs and tags and add tags as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/add-tags-bulk)

```java
List<String> fileIds = new ArrayList<>();
fileIds.add("FileId");
List<String> tags = new ArrayList<>();
tags.add("tag-to-add-1");
tags.add("tag-to-add-2");
ResultTags resultTags=ImageKit.getInstance().addTags(new TagsRequest(fileIds, tags));
System.out.println("======FINAL RESULT=======");
System.out.println(resultTags);
System.out.println("Raw Response:");
System.out.println(resultTags.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultTags.getResponseMetaData().getMap());
```

**7. Remove tags**

Accepts the file IDs and tags to remove tags as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/remove-tags-bulk)

```java
List<String> fileIds = new ArrayList<>();
fileIds.add("FileId");
List<String> tags = new ArrayList<>();
tags.add("tag-to-remove-1");
tags.add("tag-to-remove-2");
ResultTags resultTags=ImageKit.getInstance().removeTags(new TagsRequest(fileIds, tags));
System.out.println("======FINAL RESULT=======");
System.out.println(resultTags);
System.out.println("Raw Response:");
System.out.println(resultTags.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultTags.getResponseMetaData().getMap());
```

**8. Remove AI tags**

Accepts the file IDs and AI tags to remove AI tags as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/remove-aitags-bulk)

```java
List<String> fileIds = new ArrayList<>();
fileIds.add("629f3de17eb0fe4053615450");
List<String> aiTags = new ArrayList<>();
aiTags.add("Rectangle");
AITagsRequest aiTagsRequest =new AITagsRequest();
aiTagsRequest.setFileIds(fileIds);
aiTagsRequest.setAITags(aiTags);
ResultTags resultTags = ImageKit.getInstance().removeAITags(aiTagsRequest);
System.out.println("======FINAL RESULT=======");
System.out.println(resultTags);
System.out.println("Raw Response:");
System.out.println(resultTags.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultTags.getResponseMetaData().getMap());
```

**9. Delete File**

Accepts the file ID and delete a file as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/delete-file).

```java
String fileId="your-file-id";
Result result=ImageKit.getInstance().deleteFile(fileId);
System.out.println("======FINAL RESULT=======");
System.out.println(result);
System.out.println("Raw Response:");
System.out.println(result.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(result.getResponseMetaData().getMap());
```

**10. Delete FileVersion**

Accepts the file ID and version ID (particular version of the file except current version) to delete a FileVersion as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/delete-file-version).

```java
DeleteFileVersionRequest deleteFileVersionRequest = new DeleteFileVersionRequest();
deleteFileVersionRequest.setFileId("629d95278482ba129fd17c97");
deleteFileVersionRequest.setVersionId("629d953ebd24e8ceca911a66");
ResultNoContent resultNoContent = ImageKit.getInstance().deleteFileVersion(deleteFileVersionRequest);
System.out.println("======FINAL RESULT=======");
System.out.println(resultNoContent);
System.out.println("Raw Response:");
System.out.println(resultNoContent.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultNoContent.getResponseMetaData().getMap());
```

**11. Delete files (bulk)**

Accepts the file IDs to delete files as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/delete-files-bulk).

```java
List<String> fileIds = new ArrayList<>();
fileIds.add("your-file-id");
fileIds.add("your-file-id");
fileIds.add("your-file-id");

ResultFileDelete result=ImageKit.getInstance().bulkDeleteFiles(fileIds);
System.out.println("======FINAL RESULT=======");
System.out.println(result);
System.out.println("Raw Response:");
System.out.println(result.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(result.getResponseMetaData().getMap());
```

**12. Copy file**

Accepts the sourceFilePath and destinationPath to copy the File as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/copy-file).

```java
CopyFileRequest copyFileRequest = new CopyFileRequest();
copyFileRequest.setSourceFilePath("/w2_image.png");
copyFileRequest.setDestinationPath("/Gallery/");
copyFileRequest.setIncludeFileVersions(true);
ResultNoContent resultNoContent = ImageKit.getInstance().copyFile(copyFileRequest);
System.out.println("======FINAL RESULT=======");
System.out.println(resultNoContent);
System.out.println("Raw Response:");
System.out.println(resultNoContent.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultNoContent.getResponseMetaData().getMap());
```

**13. Move file**

Accepts the sourceFilePath and destinationPath to move the File as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/move-file).

```java
MoveFileRequest moveFileRequest = new MoveFileRequest();
moveFileRequest.setSourceFilePath("/Gallery/w2_image.png");
moveFileRequest.setDestinationPath("/");
ResultNoContent resultNoContent = ImageKit.getInstance().moveFile(moveFileRequest);
System.out.println("======FINAL RESULT=======");
System.out.println(resultNoContent);
System.out.println("Raw Response:");
System.out.println(resultNoContent.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultNoContent.getResponseMetaData().getMap());
```

**14. Rename file**

Accepts the filePath and newFileName to rename file as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/rename-file).

```java
RenameFileRequest renameFileRequest = new RenameFileRequest();
renameFileRequest.setFilePath("/w2_image.png");
renameFileRequest.setNewFileName("w2_image_s.png");
renameFileRequest.setPurgeCache(true);
ResultRenameFile resultRenameFile = ImageKit.getInstance().renameFile(renameFileRequest);
System.out.println("======FINAL RESULT=======");
System.out.println(resultRenameFile);
System.out.println("Raw Response:");
System.out.println(resultRenameFile.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultRenameFile.getResponseMetaData().getMap());
```

**15. Restore file Version**

Accepts the fileId and versionId to restore file version as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/restore-file-version).

```java
Result result = ImageKit.getInstance().restoreFileVersion("fileId", "versionId");
System.out.println("======FINAL RESULT=======");
System.out.println(result);
System.out.println("Raw Response:");
System.out.println(result.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(result.getResponseMetaData().getMap());
```

**16. Create Folder**

Accepts the folderName and parentFolderPath to cretae folder as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/create-folder).

```java
CreateFolderRequest createFolderRequest = new CreateFolderRequest();
createFolderRequest.setFolderName("test1");
createFolderRequest.setParentFolderPath("/");
ResultEmptyBlock resultEmptyBlock = ImageKit.getInstance().createFolder(createFolderRequest);
System.out.println("======FINAL RESULT=======");
System.out.println(resultEmptyBlock);
System.out.println("Raw Response:");
System.out.println(resultEmptyBlock.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultEmptyBlock.getResponseMetaData().getMap());
```

**17. Delete Folder**

Accepts the folderPath to delete folder as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/delete-folder).

```java
DeleteFolderRequest deleteFolderRequest = new DeleteFolderRequest();
deleteFolderRequest.setFolderPath("/test1");
ResultNoContent resultNoContent = ImageKit.getInstance().deleteFolder(deleteFolderRequest);
System.out.println("======FINAL RESULT=======");
System.out.println(resultNoContent);
System.out.println("Raw Response:");
System.out.println(resultNoContent.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultNoContent.getResponseMetaData().getMap());
```

**18. Copy Folder**

Accepts the sourceFolderPath, destinationPath and includeFileVersions to copy folder as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/copy-folder).

```java
CopyFolderRequest copyFolderRequest = new CopyFolderRequest();
copyFolderRequest.setSourceFolderPath("/Gallery/test");
copyFolderRequest.setDestinationPath("/");
ResultOfFolderActions resultOfFolderActions = ImageKit.getInstance().copyFolder(copyFolderRequest);
System.out.println("======FINAL RESULT=======");
System.out.println(resultOfFolderActions);
System.out.println("Raw Response:");
System.out.println(resultOfFolderActions.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultOfFolderActions.getResponseMetaData().getMap());
```

**19. Move Folder**

Accepts the sourceFolderPath and destinationPath to move folder as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/move-folder).

```java
MoveFolderRequest moveFolderRequest = new MoveFolderRequest();
moveFolderRequest.setSourceFolderPath("/Gallery/test");
moveFolderRequest.setDestinationPath("/");
ResultOfFolderActions resultOfFolderActions = ImageKit.getInstance().moveFolder(moveFolderRequest);
System.out.println("======FINAL RESULT=======");
System.out.println(resultOfFolderActions);
System.out.println("Raw Response:");
System.out.println(resultOfFolderActions.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultOfFolderActions.getResponseMetaData().getMap());
```

**20. Get Bulk Job Status**

Accepts the jobId to get bulk job status as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/copy-move-folder-status).

```java
String jobId = "629f44ac7eb0fe8173622d4b";
ResultBulkJobStatus resultBulkJobStatus = ImageKit.getInstance().getBulkJobStatus(jobId);
System.out.println("======FINAL RESULT=======");
System.out.println(resultBulkJobStatus);
System.out.println("Raw Response:");
System.out.println(resultBulkJobStatus.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultBulkJobStatus.getResponseMetaData().getMap());
```

**21. Purge Cache**

Accepts a full URL of the file for which the cache has to be cleared as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/purge-cache).

```java
ResultCache result=ImageKit.getInstance().purgeCache("https://ik.imagekit.io/imagekit-id/default-image.jpg");
System.out.println("======FINAL RESULT=======");
System.out.println(result);
System.out.println("Raw Response:");
System.out.println(result.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(result.getResponseMetaData().getMap());
```

**22. Purge Cache Status**

Accepts a request ID and fetch purge cache status as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/purge-cache-status)

```java
String requestId="cache-requestId";
ResultCacheStatus result=ImageKit.getInstance().getPurgeCacheStatus(requestId);
System.out.println("======FINAL RESULT=======");
System.out.println(result);
System.out.println("Raw Response:");
System.out.println(result.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(result.getResponseMetaData().getMap());
```

**23. Get File Metadata**

Accepts the file ID and fetches the metadata as per the [API documentation here](https://docs.imagekit.io/api-reference/metadata-api/get-image-metadata-for-uploaded-media-files)

```java
String fileId="your-file-id";
ResultMetaData result=ImageKit.getInstance().getFileMetadata(fileId);
System.out.println("======FINAL RESULT=======");
System.out.println(result);
System.out.println("Raw Response:");
System.out.println(result.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(result.getResponseMetaData().getMap());
```

Another way to get metadata from a remote file URL as per the [API documentation here](https://docs.imagekit.io/api-reference/metadata-api/get-image-metadata-from-remote-url). This file should be accessible over the ImageKit.io URL-endpoint.
```java
String url="Remote File URL";
ResultMetaData result=ImageKit.getInstance().getRemoteFileMetadata(url);
System.out.println("======FINAL RESULT=======");
System.out.println(result);
System.out.println("Raw Response:");
System.out.println(result.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(result.getResponseMetaData().getMap());
```

**24. Create CustomMetaDataFields**

Accepts an object of class `CustomMetaDataFieldCreateRequest` specifying the parameters to be used to create cusomMetaDataFields. All parameters specified in the [documentation here](https://docs.imagekit.io/api-reference/custom-metadata-fields-api/create-custom-metadata-field) can be passed as-is with the correct values to get the results.

Check for the [Allowed Values In The Schema](https://docs.imagekit.io/api-reference/custom-metadata-fields-api/create-custom-metadata-field#allowed-values-in-the-schema-object).

#### Examples:

```java
CustomMetaDataFieldSchemaObject schemaObject = new CustomMetaDataFieldSchemaObject();
schemaObject.setType("Number");
schemaObject.setMinValue(10);
schemaObject.setMaxValue(200);
CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
customMetaDataFieldCreateRequest.setName("Name");
customMetaDataFieldCreateRequest.setLabel("Label");
customMetaDataFieldCreateRequest.setSchema(schemaObject);
ResultCustomMetaDataField resultCustomMetaDataField=ImageKit.getInstance().createCustomMetaDataFields(customMetaDataFieldCreateRequest);
System.out.println("======FINAL RESULT=======");
System.out.println(resultCustomMetaDataField);
System.out.println("Raw Response:");
System.out.println(resultCustomMetaDataField.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultCustomMetaDataField.getResponseMetaData().getMap());
```

- MultiSelect type Exmample:

```java
List<Object> objectList = new ArrayList<>();
objectList.add("small");
objectList.add(30);
objectList.add(40);
objectList.add(true);

List<Object> defaultValueObject = new ArrayList<>();
defaultValueObject.add("small");
defaultValueObject.add(30);
defaultValueObject.add(true);
CustomMetaDataFieldSchemaObject customMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
customMetaDataFieldSchemaObject.setType("MultiSelect");
customMetaDataFieldSchemaObject.setValueRequired(true);                 // optional
customMetaDataFieldSchemaObject.setDefaultValue(defaultValueObject);    // required if isValueRequired set to true
customMetaDataFieldSchemaObject.setSelectOptions(objectList);
CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
customMetaDataFieldCreateRequest.setName("Name-MultiSelect");
customMetaDataFieldCreateRequest.setLabel("Label-MultiSelect");
customMetaDataFieldCreateRequest.setSchema(customMetaDataFieldSchemaObject);

ResultCustomMetaDataField resultCustomMetaDataField = ImageKit.getInstance()
      .createCustomMetaDataFields(customMetaDataFieldCreateRequest);
```

- Date type Exmample:

```java
CustomMetaDataFieldSchemaObject customMetaDataFieldSchemaObject = new CustomMetaDataFieldSchemaObject();
customMetaDataFieldSchemaObject.setType("Date");
customMetaDataFieldSchemaObject.setValueRequired(true);                          // optional
customMetaDataFieldSchemaObject.setDefaultValue("2022-11-30T10:11:10+00:00");    // required if isValueRequired set to true
customMetaDataFieldSchemaObject.setMinValue("2022-11-30T10:11:10+00:00");
customMetaDataFieldSchemaObject.setMaxValue("2022-12-30T10:11:10+00:00");

CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest = new CustomMetaDataFieldCreateRequest();
customMetaDataFieldCreateRequest.setName("Name");
customMetaDataFieldCreateRequest.setLabel("Label");
customMetaDataFieldCreateRequest.setSchema(customMetaDataFieldSchemaObject);

ResultCustomMetaDataField resultCustomMetaDataField = ImageKit.getInstance()
       .createCustomMetaDataFields(customMetaDataFieldCreateRequest);
```


**25. Get CustomMetaDataFields**

Fetches the metadata as per the [API documentation here](https://docs.imagekit.io/api-reference/custom-metadata-fields-api/get-custom-metadata-field)

```java
ResultCustomMetaDataFieldList resultCustomMetaDataFieldList=ImageKit.getInstance().getCustomMetaDataFields(false);
System.out.println("======FINAL RESULT=======");
System.out.println(resultCustomMetaDataFieldList);
System.out.println("Raw Response:");
System.out.println(resultCustomMetaDataFieldList.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultCustomMetaDataFieldList.getResponseMetaData().getList());
System.out.println(resultCustomMetaDataFieldList.getResultCustomMetaDataFields());
```

**26. Edit CustomMetaDataFields**

Accepts an ID of customMetaDataField and object of class `CustomMetaDataFieldUpdateRequest` specifying the parameters to be used to edit cusomMetaDataFields as per the [API documentation here](https://docs.imagekit.io/api-reference/custom-metadata-fields-api/update-custom-metadata-field).

```java
CustomMetaDataFieldSchemaObject schemaObject = new CustomMetaDataFieldSchemaObject();
schemaObject.setMinValue(10);
schemaObject.setMaxValue(200);

CustomMetaDataFieldUpdateRequest customMetaDataFieldUpdateRequest = new CustomMetaDataFieldUpdateRequest();
customMetaDataFieldUpdateRequest.setId("id");
customMetaDataFieldUpdateRequest.setLabel("label");
customMetaDataFieldUpdateRequest.setSchema(schemaObject);
ResultCustomMetaDataField resultCustomMetaDataField=ImageKit.getInstance().updateCustomMetaDataFields(customMetaDataFieldUpdateRequest);
System.out.println("======FINAL RESULT=======");
System.out.println(resultCustomMetaDataField);
System.out.println("Raw Response:");
System.out.println(resultCustomMetaDataField.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultCustomMetaDataField.getResponseMetaData().getMap());
```

**27. Delete CustomMetaDataFields**

Accepts the id to delete the customMetaDataFields as per the [API documentation here](https://docs.imagekit.io/api-reference/custom-metadata-fields-api/delete-custom-metadata-field).

```java
ResultNoContent resultNoContent=ImageKit.getInstance().deleteCustomMetaDataField("id");
System.out.println("======FINAL RESULT=======");
System.out.println(resultNoContent);
System.out.println("Raw Response:");
System.out.println(resultNoContent.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultNoContent.getResponseMetaData().getMap());
```

## Utility functions

We have included the following commonly used utility functions in this package.

**Authentication parameter generation**

In case you are looking to implement client-side file upload, you are going to need a token, expiry timestamp, and a valid signature for that upload. The SDK provides a simple method that you can use in your code to generate these
authentication parameters for you.

<em>Note: The Private API Key should never be exposed in any client-side code. You must always generate these authentications
 parameters on the server-side</em>

authentication

```java
Map<String,String> authenticationParams = ImageKit.getInstance().getAuthenticationParameters(token, expire);
```

Returns Map object of this json
```json
{
    "token": "unique_token",
    "expire": "valid_expiry_timestamp",
    "signature": "generated_signature"
}
```

Both the `token` and `expire` parameters are optional. If not specified, the SDK uses the uuid to generate a random
token and also generates a valid expiry timestamp internally. The value of the token and expire used to generate the
signature are always returned in the response, no matter if they are provided as an input to this method or not.

**Distance calculation between two pHash values**

Perceptual hashing allows you to construct a hash value that uniquely identifies an input image based on the contents
of an image. [imagekit.io metadata API](https://docs.imagekit.io/api-reference/metadata-api) returns the pHash
value of an image in the response. You can use this value to find a duplicate (or similar) images by calculating the distance between the two images.


This SDK exposes phash_distance function to calculate the distance between two pHash value. It accepts two pHash hexadecimal
strings and returns a numeric value indicative of the level of difference between the two images.

```java
int calculateDistance(){
    // fetch metadata of two uploaded image files
    ...
    // extract pHash strings from both: say 'first_hash' and 'second_hash'
    ...
    // calculate the distance between them:

    int distance = ImageKit.getInstance().pHashDistance(first_hash, second_hash);
    return distance;
}
```

**Distance calculation examples**
```java
ImageKit.getInstance().pHashDistance("f06830ca9f1e3e90", "f06830ca9f1e3e90");
// output: 0 (ame image)

ImageKit.getInstance().pHashDistance("2d5ad3936d2e015b", "2d6ed293db36a4fb");
// output: 17 (similar images)

ImageKit.getInstance().pHashDistance("a4a65595ac94518b", "7838873e791f8400");
// output: 37 (dissimilar images)
```

**HTTP response metadata of Internal API**

HTTP response metadata of the internal API call can be accessed using the getResponseMetaData function on the Result (or ResultList, ResultCache etc.) object. Example:

```java
Result result = ImageKit.getInstance().upload(fileCreateRequest);
result.getResponseMetaData().getRaw();
result.getResponseMetaData().getHeaders();
result.getResponseMetaData().getHttpStatusCode();
```

## Sample Code Instruction

**1. First clone this repository to your system using git.**
```shell script
git clone https://github.com/imagekit-developer/imagekit-java.git
```
**2. Open project in your favorite Java IDE that can supports Gradle dependency management or you can use Terminal/Command Prompt.**

**3. Goto `src/main/resources` directory.**

**4. Rename file `config.sample.properties` to `config.properties`.**

**5. Edit `config.properties` and write values of given keys.**
```properties
UrlEndpoint=your_url_endpoint
PrivateKey=your_private_key
PublicKey=your_public_key
```

**5. You will find `App.java` in `src/main/java/io/imagekit/sampleapp/` directory. Edit program as you need, then run `App.java`. If you are using CLI Tool (Terminal/Command Prompt) Then Open Project in CLI and execute using gradle**
```shell
cd imagekit-java
./gradlew run
```
* Run test case:
```shell
./gradlew imagekit-sdk:test
```
* Build ImageKit SDK:
```shell
./gradlew imagekit-sdk:clean
./gradlew imagekit-sdk:build
# You will find jar in "imagekit-sdk/build/libs/" directory.
```

## Handling errors
Catch and respond to invalid data, internal problems, and more.

Imagekit Java SDK raise exceptions for many reasons, such as not found, invalid parameters, authentication errors, and internal server error. We recommend writing code that gracefully handles all possible API exceptions.

#### Example:

```java
try {
  // Use ImageKit's SDK to make requests...
} catch (BadRequestException e) {
  // Missing or Invalid parameters were supplied to Imagekit.io's API
  System.out.println("Status is: " + e.getResponseMetaData().getHttpStatusCode());
  System.out.println("Message is: " + e.getMessage());
  System.out.println("Headers are: " + e.getResponseMetaData().getHeaders());
  System.out.println("Raw body is: " + e.getResponseMetaData().getRaw());
  System.out.println("Mapped body is: " + e.getResponseMetaData().getMap());
} catch (UnauthorizedException e) {
  // No valid API key was provided.
} catch (ForbiddenException e) {
  // Can be for the following reasons: 
  // ImageKit could not authenticate your account with the keys provided.
  // An expired key (public or private) was used with the request.
  // The account is disabled.
  // If you are using the upload API, the total storage limit (or upload limit) is exceeded.
} catch (TooManyRequestsException e) {
  // Too many requests made to the API too quickly
} catch (InternalServerException e) {
  // Something went wrong with ImageKit.io API.
} catch (PartialSuccessException e) {
  // Error cases on partial success.
} catch (NotFoundException e) {
  // If any of the field or parameter is not found in data 
} catch (UnknownException e) {
  // Something else happened, which can be unrelated to imagekit, reason will be indicated in the message field
}
```

## Supporttim
For any feedback or to report any issues or general implementation support, please reach out to [support@imagekit.io]()


## Links

* [Documentation](https://docs.imagekit.io/)
* [Main Website](https://imagekit.io/)


## License
Released under the MIT license.
