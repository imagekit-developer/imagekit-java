package io.imagekit.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum CustomMetaDataTypeEnum {
    @SerializedName("Text")
    TEXT("Text"),
    @SerializedName("Textarea")
    TEXTAREA("Textarea"),
    @SerializedName("Number")
    NUMBER("Number"),
    @SerializedName("Date")
    DATE("Date"),
    @SerializedName("Boolean")
    BOOLEAN("Boolean"),
    @SerializedName("SingleSelect")
    SINGLE_SELECT("SingleSelect"),
    @SerializedName("MultiSelect Date")
    MULTISELECT_DATE("MultiSelect Date");

    private String type;

    private CustomMetaDataTypeEnum(String s) {
        type = s;
    }

    public String getCustomMetaDataTypeEnum() {
        return type;
    }

    }
