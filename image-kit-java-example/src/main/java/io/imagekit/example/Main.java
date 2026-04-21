package io.imagekit.example;

import io.imagekit.client.ImageKitClient;
import io.imagekit.client.okhttp.ImageKitOkHttpClient;
import io.imagekit.models.ExtensionItem;
import io.imagekit.models.ExtensionItem.AiTasks.Task.YesNo;
import io.imagekit.models.ExtensionItem.AiTasks.Task.YesNo.OnNo;
import io.imagekit.models.ExtensionItem.AiTasks.Task.YesNo.OnYes;
import io.imagekit.models.files.FileUploadParams;
import io.imagekit.models.files.FileUploadResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        // Initialize the client using the IMAGEKIT_PRIVATE_KEY environment variable
        ImageKitClient client = ImageKitOkHttpClient.builder().fromEnv().build();

        // Resolve the sample image bundled in src/main/resources/test.png
        Path filePath;
        if (args.length > 0) {
            filePath = Paths.get(args[0]);
        } else {
            filePath = Paths.get(Main.class.getResource("/test.png").toURI());
        }
        System.out.println("Using file: " + filePath);
        System.out.println();

        // --- Example 1: Upload using Path ---
        System.out.println("=== Upload using Path ===");
        FileUploadParams pathParams = FileUploadParams.builder()
                .fileName("path-upload.jpg")
                .file(filePath)
                .folder("/java-sdk-testing")
                .build();
        FileUploadResponse pathResponse = client.files().upload(pathParams);
        System.out.println("Uploaded: " + pathResponse.name());
        System.out.println("URL: " + pathResponse.url());
        System.out.println("File ID: " + pathResponse.fileId());
        System.out.println();

        // --- Example 2: Upload using InputStream ---
        System.out.println("=== Upload using InputStream ===");
        InputStream imageStream = Main.class.getResourceAsStream("/test.png");
        FileUploadParams streamParams = FileUploadParams.builder()
                .fileName("stream-upload.jpg")
                .file(imageStream)
                .folder("/java-sdk-testing")
                .build();
        FileUploadResponse streamResponse = client.files().upload(streamParams);
        System.out.println("Uploaded: " + streamResponse.name());
        System.out.println("URL: " + streamResponse.url());
        System.out.println("File ID: " + streamResponse.fileId());
        System.out.println();

        // --- Example 3: Upload using byte[] ---
        System.out.println("=== Upload using byte[] ===");
        byte[] fileBytes = Files.readAllBytes(filePath);
        FileUploadParams bytesParams = FileUploadParams.builder()
                .fileName("bytes-upload.jpg")
                .file(fileBytes)
                .folder("/java-sdk-testing")
                .build();
        FileUploadResponse bytesResponse = client.files().upload(bytesParams);
        System.out.println("Uploaded: " + bytesResponse.name());
        System.out.println("URL: " + bytesResponse.url());
        System.out.println("File ID: " + bytesResponse.fileId());
        System.out.println();

        // --- Example 4: Upload with tags and folder ---
        System.out.println("=== Upload with tags and folder ===");
        FileUploadParams taggedParams = FileUploadParams.builder()
                .fileName("tagged-upload.jpg")
                .file(filePath)
                .folder("/java-sdk-testing")
                .addTag("example")
                .addTag("java-sdk")
                .useUniqueFileName(false)
                .build();
        FileUploadResponse taggedResponse = client.files().upload(taggedParams);
        System.out.println("Uploaded: " + taggedResponse.name());
        System.out.println("URL: " + taggedResponse.url());
        System.out.println("File ID: " + taggedResponse.fileId());
        System.out.println("Tags: " + taggedResponse.tags());

        System.out.println();

        // --- Example 5: Upload with AI tasks extension ---
        System.out.println("=== Upload with AI tasks extension ===");
        FileUploadParams aiParams = FileUploadParams.builder()
                .fileName("ai-task-upload.png")
                .file(filePath)
                .folder("/java-sdk-testing")
                .addExtension(ExtensionItem.AiTasks.builder()
                        .addTask(YesNo.builder()
                                .instruction("Does this image contain a person?")
                                .onYes(OnYes.builder().addAddTag("has-person").build())
                                .onNo(OnNo.builder().addAddTag("no-person").build())
                                .build())
                        .addSelectTagsTask("What objects are visible in this image?")
                        .build())
                .addTag("ai-processed")
                .build();
        FileUploadResponse aiResponse = client.files().upload(aiParams);
        System.out.println("Uploaded: " + aiResponse.name());
        System.out.println("URL: " + aiResponse.url());
        System.out.println("File ID: " + aiResponse.fileId());
        System.out.println("Extensions: " + aiResponse.extensionStatus());

        System.out.println();
        System.out.println("All uploads completed successfully!");
    }
}
