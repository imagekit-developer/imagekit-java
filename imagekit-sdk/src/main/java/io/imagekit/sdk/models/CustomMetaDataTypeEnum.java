package io.imagekit.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum CustomMetaDataTypeEnum {
    @SerializedName("Text")
    TEXT,
    @SerializedName("Textarea")
    TEXTAREA,
    @SerializedName("Number")
    Number,
    @SerializedName("Date")
    DATE,
    @SerializedName("Boolean")
    BOOLEAN,
    @SerializedName("SingleSelect")
    SINGLE_SELECT,
    @SerializedName("MultiSelect Date")
    MULTISELECT_DATE;

}
