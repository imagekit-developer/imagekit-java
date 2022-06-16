package io.imagekit.sdk;

import io.imagekit.sdk.config.Configuration;
import io.imagekit.sdk.models.*;
import io.imagekit.sdk.models.results.*;
import io.imagekit.sdk.tasks.Calculation;
import io.imagekit.sdk.tasks.RestClient;
import io.imagekit.sdk.tasks.UrlGen;

import java.util.List;
import java.util.Map;

public final class ImageKit {
    private static ImageKit imageKit;
    private Configuration configuration;
    private RestClient restClient;
    private ImageKit(){
        configuration=new Configuration();
    }

    /**
     * getInstance() method will return single instance all over the application
     * @return object ImageKit
     */
    public static synchronized ImageKit getInstance(){
        if (imageKit==null) {
            imageKit = new ImageKit();
            imageKit.restClient =new RestClient(imageKit);
        }
        return imageKit;
    }

    /**
     * setRestClient(RestClient restClient) it takes object of RestClient class
     * @param restClient to set restClient
     */
    void setRestClient(RestClient restClient){
        this.restClient = restClient;
    }

    /**
     * setConfig(Configuration config)
     * @param config will save new configuration
     */
    public void setConfig(Configuration config){
        this.configuration=config;
    }

    /**
     * getConfig()
     * @return it will return current configuration
     */
    public Configuration getConfig() {
        return configuration;
    }

    /**
     *
     * @param options is a HashMap of Objects it can contains following keys -
     *                ["path","src","urlEndpoint","transformation",
     *                "transformationPosition","queryParameters",
     *                "signed","expireSeconds"]
     *                where transformation is an List of HashMap, signed is boolean and expireSeconds is integer.
     * @return String new generated url
     */

    public String getUrl(Map<String, Object> options){
        return UrlGen.getUrl(options);
    }


    /**
     *
     * @param fileCreateRequest is a object which contains file and other parameters
     * @return object of Result class
     */
    public Result upload(FileCreateRequest fileCreateRequest){
        return restClient.upload(fileCreateRequest);
    }

    /**
     *
     * @param fileUpdateRequest is a object which contains parameters and fileId
     * @return object of Result class
     */
    public Result updateFileDetail(FileUpdateRequest fileUpdateRequest){
        return restClient.updateDetail(fileUpdateRequest);
    }


    /**
     *
     * @param options is an map it may contain keys [
     *                "path", "fileType", "tags", "includeFolder", "name", "limit", "skip"]
     * @return ResultList class that contains list of BaseFile
     */
    public ResultList getFileList(Map<String, String> options){
        return restClient.getFileList(options);
    }

    /**
     *
     * @param fileId is a unique file id
     * @return Result class
     */
    public Result getFileDetail(String fileId){
        return restClient.getFileDetail(fileId);
    }

    /**
     *
     * @param fileId is a unique file id
     * @return ResultMetaData class
     */
    public ResultMetaData getFileMetadata(String fileId){
        return restClient.getFileMetaData(fileId);
    }

    /**
     *
     * @param url is a remote image url
     * @return ResultMetaData class
     */
    public ResultMetaData getRemoteFileMetadata(String url){
        return restClient.getRemoteFileMetaData(url);
    }

    /**
     *
     * @param fileId is a unique file id
     * @return Result class
     */
    public Result deleteFile(String fileId){
        return restClient.deleteFile(fileId);
    }

    /**
     *
     * @param fileIds is a  list of unique file id
     * @return Result class
     */
    public ResultFileDelete bulkDeleteFiles(List<String> fileIds){
        return restClient.bulkDeleteFiles(fileIds);
    }

    /**
     *
     * @param url is image url
     * @return ResultCache class
     */
    public ResultCache purgeCache(String url){
        return restClient.purgeCache(url);
    }

    /**
     *
     * @param requestId is cache request id
     * @return ResultCacheStatus class
     */
    public ResultCacheStatus getPurgeCacheStatus(String requestId){
        return restClient.getPurgeCacheStatus(requestId);
    }

    /**
     *
     * @return a map that contains token, expire and signature
     */
    public Map<String, String> getAuthenticationParameters(){
        return Calculation.getAuthenticatedParams(null,0,configuration.getPrivateKey());
    }

    /**
     *
     * @param token take as a argument
     * @return a map that contains token, expire and signature
     */
    public Map<String, String> getAuthenticationParameters(String token){
        return Calculation.getAuthenticatedParams(token,0,configuration.getPrivateKey());
    }

    /**
     *
     * @param token take as first argument
     * @param expire is a Timestamp in milliseconds take as second argument
     * @return a map that contains token, expire and signature
     */
    public Map<String, String> getAuthenticationParameters(String token, long expire){
        return Calculation.getAuthenticatedParams(token,expire,configuration.getPrivateKey());
    }

    /**
     * firstHex and secondHex must have equal length
     * @param firstHex take Hex as a String argument
     * @param secondHex take Hex as a String argument
     * @return it's distance
     */
    public int pHashDistance(String firstHex, String secondHex){
        return Calculation.getHammingDistance(firstHex,secondHex);
    }

    /**
     *
     * @param tagsRequest is a object which contains fileIds and tags as a parameters
     * @return ArrayList of String
     */
    public ResultTags addTags(TagsRequest tagsRequest){
        return restClient.manageTags(tagsRequest, "addTags");
    }

    /**
     *
     * @param aiTagsRequest is a object which contains fileIds and tags as a parameters
     * @return ArrayList of String
     */
    public ResultTags removeAITags(AITagsRequest aiTagsRequest){
        return restClient.removeAITags(aiTagsRequest);
    }

    /**
     *
     * @param tagsRequest is a object which contains fileIds and tags as a parameters
     * @return ArrayList of String
     */
    public ResultTags removeTags(TagsRequest tagsRequest){
        return restClient.manageTags(tagsRequest, "removeTags");
    }

    /**
     *
     * @return a CustomMetaDataResultList that contains CustomMetaDataField's name, label, schema
     */
    public ResultCustomMetaDataFieldList getCustomMetaDataFields(boolean includeDeleted) {
        return restClient.getCustomMetaDataFields(includeDeleted);
    }

    /**
     *
     * @param customMetaDataFieldCreateRequest that contains CustomMetaDataField's name, label, schema with type, minLength, maxLength
     * @return ResultCustomMetaData with ResultCustomMetaDataField
     */
    public ResultCustomMetaDataField createCustomMetaDataFields(CustomMetaDataFieldCreateRequest customMetaDataFieldCreateRequest) {
        return restClient.createCustomMetaDataFields(customMetaDataFieldCreateRequest);
    }

    /**
     *
     * @param id is a id of customMetaDataFields
     * @return Result class
     */
    public ResultNoContent deleteCustomMetaDataField(String id){
        return restClient.deleteCustomMetaDataField(id);
    }

    /**
     *
     * @param customMetaDataFieldUpdateRequest that contains CustomMetaDataField's id, schema with type, minLength, maxLength
     * @return Result class
     */
    public ResultCustomMetaDataField updateCustomMetaDataFields(CustomMetaDataFieldUpdateRequest customMetaDataFieldUpdateRequest) {
        return restClient.updateCustomMetaDataFields(customMetaDataFieldUpdateRequest);
    }

    /**
     *
     * @param deleteFileVersionRequest class
     * @return Result class
     */
    public ResultNoContent deleteFileVersion(DeleteFileVersionRequest deleteFileVersionRequest) {
        return restClient.deleteFileVersion(deleteFileVersionRequest);
    }

    /**
     *
     * @param copyFileRequest class
     * @return Result class
     */
    public ResultNoContent copyFile(CopyFileRequest copyFileRequest) {
        return restClient.copyFile(copyFileRequest);
    }

    /**
     *
     * @param moveFileRequest class
     * @return Result class
     */
    public ResultNoContent moveFile(MoveFileRequest moveFileRequest) {
        return restClient.moveFile(moveFileRequest);
    }

    /**
     *
     * @param renameFileRequest class
     * @return Result class
     */
    public ResultRenameFile renameFile(RenameFileRequest renameFileRequest) {
        return restClient.renameFile(renameFileRequest);
    }

    /**
     *
     * @param createFolderRequest which contains folderPath that is full path to the folder you want to delete
     * @return Result class
     */
    public ResultEmptyBlock createFolder(CreateFolderRequest createFolderRequest) {
        return restClient.createFolder(createFolderRequest);
    }

    /**
     *
     * @param deleteFolderRequest which contains folderPath that is full path to the folder you want to delete
     * @return Result class
     */
    public ResultNoContent deleteFolder(DeleteFolderRequest deleteFolderRequest) {
        return restClient.deleteFolder(deleteFolderRequest);
    }

    /**
     *
     * @param copyFolderRequest that contains sourceFolderPath, destinationPath, includeVersions
     * @return Result class
     */
    public ResultOfFolderActions copyFolder(CopyFolderRequest copyFolderRequest) {
        return restClient.copyFolder(copyFolderRequest);
    }

    /**
     *
     * @param moveFolderRequest that contains sourceFolderPath, destinationPath
     * @return Result class
     */
    public ResultOfFolderActions moveFolder(MoveFolderRequest moveFolderRequest) {
        return restClient.moveFolder(moveFolderRequest);
    }

    /**
     *
     * @param jobId
     * @return a Result class
     */
    public ResultBulkJobStatus getBulkJobStatus(String jobId) {
        return restClient.getBulkJobStatus(jobId);
    }

    /**
     *
     * @param fileId
     * @return a Result class
     */
    public ResultFileVersions getFileVersions(String fileId) {
        return restClient.getFileVersions(fileId);
    }

    /**
     *
     * @param fileId & versionId
     * @return a Result class
     */
    public ResultFileVersionDetails getFileVersionDetails(String fileId, String versionId) {
        return restClient.getFileVersionDetails(fileId, versionId);
    }
}
