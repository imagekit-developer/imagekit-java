# ImageKit Java SDK

[![Java CI](https://github.com/imagekit-developer/imagekit-java/workflows/Java%20CI/badge.svg)](https://github.com/imagekit-developer/imagekit-java)
[![Release](https://jitpack.io/v/com.github.imagekit-developer/imagekit-java.svg)](https://jitpack.io/#com.github.imagekit-developer/imagekit-java)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Twitter Follow](https://img.shields.io/twitter/follow/imagekitio?label=Follow&style=social)](https://twitter.com/ImagekitIo)

Java SDK for [ImageKit.io](https://imagekit.io/) that implements the new APIs and interface for performing different file
operations.

ImageKit is a complete image optimization and transformation solution that comes with and
[image CDN](https://imagekit.io/features/imagekit-infrastructure) and media storage. It can be integrated with your
existing infrastructure - storage like AWS s3, web servers, your CDN, and custom domain names, allowing you to deliver
optimize images in minutes with minimal code changes.

Table of contents -
 * [Installation](#installation)
 * [Initialization](#initialization)
 * [Usage](#usage)
 * [Versioning](#versioning)
 * [URL generation](#url-generation)
 * [File upload](#file-upload)
 * [File management](#file-management)
 * [Utility functions](#utility-functions)
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
Step 2. Add the dependency on project's `build.gradle`:
```
dependencies {
        implementation 'com.github.imagekit-developer:imagekit-java:1.0.3'
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
Step 2. Add the dependency in POM file:
```
<dependency>
    <groupId>com.github.imagekit-developer</groupId>
    <artifactId>imagekit-java</artifactId>
    <version>1.0.3</version>
</dependency>
```

## Initialization

Step 1. Create a `config.properties` file inside `src/main/resources` of your project. And put essential values of keys [UrlEndpoint, PrivateKey, PublicKey], no need to use quote(`'` or `"`) in values.

```editorconfig
# Put essential values of keys [UrlEndpoint, PrivateKey, PublicKey]
UrlEndpoint=<-YOUR-ENDPOINT-URL-HERE->
PrivateKey=<-YOUR-PRIVATE-KEY-HERE->
PublicKey=<-YOUR-PUBLIC-KEY-HERE->
```
Step 2. Then you need to initialize ImageKit with that configuration.

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

## Usage
You can use this Java SDK for 3 different kinds of methods - URL generation, file upload, and file management.
The usage of the SDK has been explained below.

## Versioning
This document presents a list of changes that break existing functionality of previous versions. We try our best to minimize these disruptions, but sometimes they are unavoidable and they will be in major versions.
### Breaking History:

### Title
- Result object raw and getMap() properties:

**What changed**
- raw and getMap() has been deprecated.

**Who is affected?**
- This affects any development that uses the raw or getMap() from response object of APIs that is Result object.

**How should I update my code?**
- If you still need to use raw and getMap(), write it with using it with result's internal property such as result.getResponseMetaData().getRaw(). 
 
### Title
- Result object message and isSuccessful boolean properties:

**What changed**
- message and isSuccessful has been replaced with custom exceptions according to response code.

**Who is affected?**
- This affects any development that uses the message or isSuccessful from response object of APIs that is Result object.

**How should I update my code?**
- If you still need to use message it will be there in custom exception and could be raised isSuccessful properties in your own code from status code which is coming in the response or custom exception.


## URL generation

**1. Using image path and URL-endpoint**

This method allows you to create a URL using the path where the image exists and the URL-endpoint you want to use to access the image. You can refer to the documentation
[here](https://docs.imagekit.io/integration/url-endpoints) to read more about URL endpoints
in ImageKit and the section about [image origins](https://docs.imagekit.io/integration/configure-origin) to understand
about paths with different kinds of origins.

```java
Map<String, String> queryParam=new HashMap<>();
queryParam.put("v","123");

List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
Map<String, String> scale=new HashMap<>();
scale.put("height","600");
scale.put("width","400");
transformation.add(scale);
    
Map<String, Object> options=new HashMap();
options.put("urlEndpoint","https://ik.imagekit.io/your_imagekit_id/");
options.put("path","/default-image.jpg");
options.put("transformation", transformation);

String url = ImageKit.getInstance().getUrl(options);
```
The result in a URL like
```
https://ik.imagekit.io/your_imagekit_id/tr:w-400,h-600/default-image.jpg?v=123&ik-sdk-version=java-1.0.3
```

**2. Using full image URL**
This method allows you to add transformation parameters to an existing complete URL that is already mapped to ImageKit
using the `src` parameter. This method should be used if you have the complete image URL mapped to ImageKit stored in your
database.

```java
List<Map<String, String>> transformation=new ArrayList<Map<String, String>>();
Map<String, String> scale=new HashMap<>();
scale.put("height","600");
scale.put("width","400");
transformation.add(scale);

Map<String, Object> options=new HashMap();
options.put("src","https://ik.imagekit.io/your_imagekit_id/default-image.jpg");
options.put("transformation", transformation);

String url = ImageKit.getInstance().getUrl(options);
```

The results in a URL like

```
https://ik.imagekit.io/your_imagekit_id/default-image.jpg?tr=w-400,h-600&ik-sdk-version=java-1.0.3
```

The ```.getUrl()``` method accepts the following parameters

| Option                  | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| :---------------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| urlEndpoint            | Optional. `(Type: String)` The base URL to be appended before the path of the image. If not specified, the URL Endpoint specified at the time of SDK initialization is used. For example, https://ik.imagekit.io/your_imagekit_id/                                                                                                                                                                                                                                                                                                                                             |
| path                    | Conditional. `(Type: String)` This is the path at which the image exists. For example, `/path/to/image.jpg`. Either the `path` or `src` parameter needs to be specified for URL generation.                                                                                                                                                                                                                                                                                                                                                                                                |
| src                     | Conditional. `(Type: String)` This is the complete URL of an image already mapped to ImageKit. For example, `https://ik.imagekit.io/your_imagekit_id/endpoint/path/to/image.jpg`. Either the `path` or `src` parameter needs to be specified for URL generation.                                                                                                                                                                                                                                                                                                                           |
| transformation          | Optional. `(Type: List<Map<String,String>>)` An array of objects specifying the transformation to be applied in the URL. The transformation name and the value should be specified as a key-value pair in the object. Different steps of a [chained transformation](https://docs.imagekit.io/features/image-transformations/chained-transformations) can be specified as different objects of the array. The complete list of supported transformations in the SDK and some examples of using them are given later. If you use a transformation name that is not specified in the SDK, it gets applied as it is in the URL. |
| transformationPosition | Optional. `(Type: String)` Default value is `path` that places the transformation string as a path parameter in the URL. It can also be specified as `query` which adds the transformation string as the query parameter `tr` in the URL. If you use the `src` parameter to create the URL, then the transformation string is always added as a query parameter.                                                                                                                                                                                                                                 |
| queryParameters        | Optional. `(Type: Map<String, String>)` These are the other query parameters that you want to add to the final URL. These can be any query parameters and not necessarily related to ImageKit. Especially useful if you want to add some versioning parameter to your URLs.                                                                                                                                                                                                                                                                                                                           |
| signed                  | Optional. `(Type: Boolean)` Default is `false`. If set to `true`, the SDK generates a signed image URL adding the image signature to the image URL. This can only be used if you are creating the URL with the `url_endpoint` and `path` parameters, and not with the `src` parameter.                                                                                                                                                                                                                                                                                            |
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
https://ik.imagekit.io/your_imagekit_id/default-image.jpg?tr=h-300&w-400:rt-90&ik-sdk-version=java-1.0.3
```

**2. Sharpening and contrast transforms and a progressive JPG image**

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
https://ik.imagekit.io/your_imagekit_id/default-image.jpg?tr=f-jpg&pr-true&e-sharpen&e-contrast-1&ik-sdk-version=java-1.0.3
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
https://ik.imagekit.io/your_imagekit_id/tr:h-600,w-400/default-image.jpg?ik-t=1567358667&ik-s=f2c7cdacbe7707b71a83d49cf1c6110e3d701054&ik-sdk-version=java-1.0.3
```

**List of transformations**

The complete list of transformations supported and their usage in ImageKit can be found [here](https://docs.imagekit.io/features/image-transformations/resize-crop-and-other-transformations).
The SDK gives a name to each transformation parameter, making the code simpler, making the code more straightforward and readable.
If a transformation is supported in ImageKit, but a name for it cannot be found in the table below, then use the
transformation code from ImageKit docs as the name when using in the ```url``` function.


| Supported Transformation Name | Translates to parameter |
| ----------------------------- | ----------------------- |
| height                        | h                       |
| width                         | w                       |
| aspect_ratio                  | ar                      |
| quality                       | q                       |
| crop                          | c                       |
| crop_mode                     | cm                      |
| x                             | x                       |
| y                             | y                       |
| focus                         | fo                      |
| format                        | f                       |
| radius                        | r                       |
| background                    | bg                      |
| border                        | bo                      |
| rotation                      | rt                      |
| blur                          | bl                      |
| named                         | n                       |
| overlay_image                 | oi                      |
| overlay_x                     | ox                      |
| overlay_y                     | oy                      |
| overlay_focus                 | ofo                     |
| overlay_height                | oh                      |
| overlay_width                 | ow                      |
| overlay_text                  | ot                      |
| overlay_text_font_size        | ots                     |
| overlay_text_font_family      | otf                     |
| overlay_text_color            | otc                     |
| overlay_alpha                 | oa                      |
| overlay_text_typography       | ott                     |
| overlay_background            | obg                     |
| overlay_image_trim            | oit                     |
| progressive                   | pr                      |
| lossless                      | lo                      |
| trim                          | t                       |
| metadata                      | md                      |
| color_profile                 | cp                      |
| default_image                 | di                      |
| dpr                           | dpr                     |
| effect_sharpen                | e-sharpen               |
| effect_usm                    | e-usm                   |
| effect_contrast               | e-contrast              |
| effect_gray                   | e-grayscale             |
| original                      | orig                    |


## File Upload

The SDK provides a simple interface using the `.upload()` method to upload files to the ImageKit Media library. It
accepts an object of `FileCreateRequest` class that contains all the parameters supported by the [ImageKit Upload API](https://docs.imagekit.io/api-reference/upload-file-api/server-side-file-upload).

The constructor `FileCreateRequest` class requires `file` as (URL/Base64/Byte Array) and `file_name` if `file` is byte array then it's require another parameter named `mediaType` to upload a file. The method returns object of `Result` class. It contains method `isSuccessful()` (return boolean), `getMessage()` for error message and other file parameter responsed by server.
ImageKit upload API using the same parameter name as specified in the upload API documentation. For example, to
specify tags for a file at the time of upload use the tags parameter as specified in the
[documentation here](https://docs.imagekit.io/api-reference/upload-file-api/server-side-file-upload)

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

If the upload is successful, `getMessage()` will be `None`, and the result will be an object of `Result` class that contains the same all the parameters received from ImageKit's servers and `isSuccessful()` will return true.

If the upload fails, `getMessage()` will contain the same error message received from ImageKit's servers and `isSuccessful()` will return false.


## File Management

The SDK provides a simple interface for all the [media APIs mentioned here](https://docs.imagekit.io/api-reference/media-api)
to manage your files. This also returns `error` and `result`, the error will be `None` if API succeeds.

**1. List & Search Files**

Accepts an object specifying the parameters to be used to list and search files. All parameters specified
in the [documentation here](https://docs.imagekit.io/api-reference/media-api/list-and-search-files) can be passed as-is with the
correct values to get the results.

```java
ResultList resultList=ImageKit.getInstance().getFileList(10,10);
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

**3. Get File Metadata**

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

**4. Update File Details**

It updates the file properties as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/update-file-details).
The argument to the `updateDetail()` method is the object of `FileUpdateRequest` class, and the constructor will take the file ID and then set the parameters to be updated.

```java
String fileId="your-file-id";
FileUpdateRequest fileUpdateRequest =new FileUpdateRequest(fileId);
fileUpdateRequest.setTags(List.of("Software","Developer","Engineer"));
fileUpdateRequest.setCustomCoordinates("10,10,40,40");
Result result=ImageKit.getInstance().updateFileDetail(fileUpdateRequest);
System.out.println("======FINAL RESULT=======");
System.out.println(result);
System.out.println("Raw Response:");
System.out.println(result.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(result.getResponseMetaData().getMap());
```
**5. Delete File**

Delete a file as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/delete-file). The method accepts the file ID of the file that has to be
deleted.

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
**6. Delete files (bulk)**

Delete multiple files as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/delete-files-bulk). The method accepts multiple file ID of the file that has to be
deleted.

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

**7. Purge Cache**

Programmatically issue a cache clear request as per the [API documentation here](https://docs.imagekit.io/api-reference/media-api/purge-cache).
Accepts the full URL of the file for which the cache has to be cleared.
```java
ResultCache result=ImageKit.getInstance().purgeCache("https://ik.imagekit.io/imagekit-id/default-image.jpg");
System.out.println("======FINAL RESULT=======");
System.out.println(result);
System.out.println("Raw Response:");
System.out.println(result.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(result.getResponseMetaData().getMap());
```

**8. Purge Cache Status**

Get the purge cache request status using the request ID returned when a purge cache request gets submitted as pet the
[API documentation here](https://docs.imagekit.io/api-reference/media-api/purge-cache-status)

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

**9. Add tags**

Add tags using the FileIds and tags which we want to add in request as per the
[API documentation here](https://docs.imagekit.io/api-reference/media-api/add-tags-bulk)

```java
List<String> fileIds = new ArrayList<>();
fileIds.add("FileId");
List<String> tags = new ArrayList<>();
tags.add("tag-to-add-1");
tags.add("tag-to-add-2");
ResultTags resultTags=ImageKit.getInstance().manageTags(new TagsRequest(fileIds, tags), "addTags");
System.out.println("======FINAL RESULT=======");
System.out.println(resultTags);
System.out.println("Raw Response:");
System.out.println(resultTags.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultTags.getResponseMetaData().getMap());
```

**10. Remove tags**

Removed tags using the FileIds and tags which we want to remove from request as per the
[API documentation here](https://docs.imagekit.io/api-reference/media-api/remove-tags-bulk)

```java
List<String> fileIds = new ArrayList<>();
fileIds.add("FileId");
List<String> tags = new ArrayList<>();
tags.add("tag-to-remove-1");
tags.add("tag-to-remove-2");
ResultTags resultTags=ImageKit.getInstance().manageTags(new TagsRequest(fileIds, tags), "removeTags");
System.out.println("======FINAL RESULT=======");
System.out.println(resultTags);
System.out.println("Raw Response:");
System.out.println(resultTags.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultTags.getResponseMetaData().getMap());
```

**11. Remove AI tags**

Removed AITags using the FileIds and AITags which we want to remove from request as per the
[API documentation here](https://docs.imagekit.io/api-reference/media-api/remove-aitags-bulk)

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

**12. Get CustomMetaDataFields**

fetches the metadata as per the
[API documentation here](https://docs.imagekit.io/api-reference/custom-metadata-fields-api/get-custom-metadata-field)

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

**13. Create CustomMetaDataFields**

It creates the CustomMetaDataFields as per the
[API documentation here](https://docs.imagekit.io/api-reference/custom-metadata-fields-api/create-custom-metadata-field).
The argument to the `createCustomMetaDataFields()` method is the object of `CustomMetaDataFieldCreateRequest` class.

```java
CustomMetaDataFieldSchemaObject schemaObject = new CustomMetaDataFieldSchemaObject();
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

**14. Delete CustomMetaDataFields**

It deletes the CustomMetaDataFields as per the
[API documentation here](https://docs.imagekit.io/api-reference/custom-metadata-fields-api/delete-custom-metadata-field).
The argument to the `deleteCustomMetaDataField()` method accepts the id of customMetaDataField which we want to be deleted.

```java
ResultNoContent resultNoContent=ImageKit.getInstance().deleteCustomMetaDataField("id");
System.out.println("======FINAL RESULT=======");
System.out.println(resultNoContent);
System.out.println("Raw Response:");
System.out.println(resultNoContent.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultNoContent.getResponseMetaData().getMap());
```

**15. Edit CustomMetaDataFields**

It edits the CustomMetaDataFields as per the
[API documentation here](https://docs.imagekit.io/api-reference/custom-metadata-fields-api/update-custom-metadata-field).
The argument to the `updateCustomMetaDataFields()` method is the object of `CustomMetaDataFieldUpdateRequest` class.

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

**16. Delete FileVersion**

It deletes the FileVersion as per the
[API documentation here](https://docs.imagekit.io/api-reference/media-api/delete-file-version).
The argument to the `deleteFileVersion()` method accepts the id of file and versionID to delete particular version of the file except current version which we want to be deleted.

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

**17. Copy file**

It Copies the File as per the
[API documentation here](https://docs.imagekit.io/api-reference/media-api/copy-file).
The argument to the `copyFile()` method accepts the sourceFilePath and destinationPath that where we want to be copied it.

```java
CopyFileRequest copyFileRequest = new CopyFileRequest();
copyFileRequest.setSourceFilePath("/w2_image.png");
copyFileRequest.setDestinationPath("/Gallery/");
copyFileRequest.setIncludeVersions(true);
ResultNoContent resultNoContent = ImageKit.getInstance().copyFile(copyFileRequest);
System.out.println("======FINAL RESULT=======");
System.out.println(resultNoContent);
System.out.println("Raw Response:");
System.out.println(resultNoContent.getResponseMetaData().getRaw());
System.out.println("Map Response:");
System.out.println(resultNoContent.getResponseMetaData().getMap());
```

**18. Move file**

It Moves the File as per the
[API documentation here](https://docs.imagekit.io/api-reference/media-api/move-file).
The argument to the `moveFile()` method accepts the sourceFilePath and destinationPath that where we want to be moved it.

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

**19. Rename file**

It Renames the File as per the
[API documentation here](https://docs.imagekit.io/api-reference/media-api/rename-file).
The argument to the `renameFile()` method accepts the filePath for which you wants to rename and newFileName that with which you want to renamed it with purgeCache boolean.

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

**20. Create Folder**

It Creates the Folder as per the
[API documentation here](https://docs.imagekit.io/api-reference/media-api/create-folder).
The argument to the `createFolder()` method accepts the folderName and parentFolderPath.

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

**21. Delete Folder**

It Deletes the Folder as per the
[API documentation here](https://docs.imagekit.io/api-reference/media-api/delete-folder).
The argument to the `deleteFolder()` method accepts the folderPath for which the folder has to be deleted.

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

**22. Copy Folder**

It Copies the Folder as per the
[API documentation here](https://docs.imagekit.io/api-reference/media-api/copy-folder).
The argument to the `copyFolder()` method accepts the sourceFolderPath, destinationPath and includeVersions for which the folder has to be copied.

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

**23. Move Folder**

It Moves the Folder as per the
[API documentation here](https://docs.imagekit.io/api-reference/media-api/move-folder).
The argument to the `moveFolder()` method accepts the sourceFolderPath, destinationPath for which the folder has to be moved.

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

**24. Get Bulk Job Status**

It Gets the Job status as per the
[API documentation here](https://docs.imagekit.io/api-reference/media-api/copy-move-folder-status).
The argument to the `getBulkJobStatus()` method accepts the jobId for which job has to be get or Fetched the status.

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

**25. Get File Versions**

It Gets the File versions as per the
[API documentation here](https://docs.imagekit.io/api-reference/media-api/get-file-versions).
The argument to the `getFileVersions()` method accepts the fileId for which file has to be get or Fetched the versions.

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

**26. Get File Version details**

It Gets the File version details as per the
[API documentation here](https://docs.imagekit.io/api-reference/media-api/get-file-version-details).
The argument to the `getFileVersionDetails()` method accepts the fileId and versionId for which file has to be get or Fetched with particular version.

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
UrlEndpoint=<-YOUR-ENDPOINT-URL-HERE->
PrivateKey=<-YOUR-PRIVATE-KEY-HERE->
PublicKey=<-YOUR-PUBLIC-KEY-HERE->
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

## Support
For any feedback or to report any issues or general implementation support, please reach out to [support@imagekit.io]()


## Links

* [Documentation](https://docs.imagekit.io/)
* [Main Website](https://imagekit.io/)


## License
Released under the MIT license.
