package io.imagekit.sdk.models;

import com.google.gson.annotations.SerializedName;

public enum CustomMetaDataTypeEnum {
    @SerializedName("Text")
    Text,
    @SerializedName("Textarea")
    Textarea,
    @SerializedName("Number")
    Number,
    @SerializedName("Date")
    Date,
    @SerializedName("Boolean")
    Boolean,
    @SerializedName("SingleSelect")
    SingleSelect,
    @SerializedName("MultiSelect")
    MultiSelect;

}
