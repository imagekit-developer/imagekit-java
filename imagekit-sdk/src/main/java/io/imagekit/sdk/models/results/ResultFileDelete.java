package io.imagekit.sdk.models.results;

import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.imagekit.sdk.models.ResponseMetaData;

public class ResultFileDelete {
    private boolean isSuccessful;
    private String message;
    private String help;
    private List<String> successfullyDeletedFileIds;
    private List<String> missingFileIds;
    private ResponseMetaData responseMetaData = new ResponseMetaData();

    public ResultFileDelete() {
        successfullyDeletedFileIds=new ArrayList<>();
        missingFileIds=new ArrayList<>();
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public Map<String,Object> getMap(){
        if (null!=responseMetaData.getRaw()) {
            return new Gson().fromJson(responseMetaData.getRaw(), new TypeToken<Map<String, Object>>() {
            }.getType());
        }
        return new HashMap<>();
    }

    public List<String> getSuccessfullyDeletedFileIds() {
        return successfullyDeletedFileIds;
    }

    public void setSuccessfullyDeletedFileIds(List<String> successfullyDeletedFileIds) {
        this.successfullyDeletedFileIds = successfullyDeletedFileIds;
    }

    public List<String> getMissingFileIds() {
        return missingFileIds;
    }

    public void setMissingFileIds(List<String> missingFileIds) {
        this.missingFileIds = missingFileIds;
    }

    public ResponseMetaData getResponseMetaData() {
        return responseMetaData;
    }

    public void setResponseMetaData(ResponseMetaData responseMetaData) {
        this.responseMetaData = responseMetaData;
    }

    @Override
    public String toString() {
        return "ResultFileDelete{" +
                "isSuccessful=" + isSuccessful +
                ", message='" + message + '\'' +
                ", help='" + help + '\'' +
                ", successfullyDeletedFileIds=" + successfullyDeletedFileIds +
                ", missingFileIds=" + missingFileIds +
                '}';
    }
}
