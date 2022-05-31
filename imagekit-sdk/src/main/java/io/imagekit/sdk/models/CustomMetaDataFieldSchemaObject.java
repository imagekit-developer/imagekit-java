package io.imagekit.sdk.models;


import java.util.List;

public class CustomMetaDataFieldSchemaObject {
    private CustomMetaDataTypeEnum type;
    private List<String> selectOptions;
    private String defaultValue;
    private boolean isValueRequired;
    private String minValue;
    private String maxValue;
    private int minLength;
    private int maxLength;

    public CustomMetaDataFieldSchemaObject() {
    }

    public CustomMetaDataTypeEnum getType() {
        return type;
    }

    public void setType(CustomMetaDataTypeEnum type) {
        this.type = type;
    }

    public List<String> getSelectOptions() {
        return selectOptions;
    }

    public void setSelectOptions(List<String> selectOptions) {
        this.selectOptions = selectOptions;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isValueRequired() {
        return isValueRequired;
    }

    public void setValueRequired(boolean valueRequired) {
        isValueRequired = valueRequired;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public String toString() {
        System.out.println("type.getCustomMetaDataTypeEnum().toUpperCase(Locale.ROOT):==> "+ type);
        return "{" +
                "type=" + '"' + type + '"' +
                ", selectOptions=" + '"' + selectOptions + '"' +
                ", defaultValue=" + '"' + defaultValue + '"' +
                ", isValueRequired=" + '"' + isValueRequired + '"' +
                ", minValue=" + '"' + minValue + '"' +
                ", maxValue=" + '"' + maxValue + '"' +
                ", minLength=" + '"' + minLength + '"' +
                ", maxLength=" + '"' + maxLength + '"' +
                '}';
    }
}
