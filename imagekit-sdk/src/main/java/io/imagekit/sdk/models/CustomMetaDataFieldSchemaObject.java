package io.imagekit.sdk.models;


import java.util.List;

public class CustomMetaDataFieldSchemaObject {
    private CustomMetaDataTypeEnum type;
    private List<String> selectOptions;
    private String defaultValue;
    private Boolean isValueRequired;
    private Integer minValue;
    private Integer maxValue;
    private Integer minLength;
    private Integer maxLength;

    public CustomMetaDataFieldSchemaObject() {

    }

    public CustomMetaDataFieldSchemaObject(CustomMetaDataTypeEnum type, boolean isValueRequired, int minValue, int maxValue) {
        this.type = type;
        this.isValueRequired = isValueRequired;
        this.minValue = minValue;
        this.maxValue = maxValue;
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

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public String toString() {return "{" +
            "type=" + '"' + type + '"' +
            ", selectOptions=" + '"' + selectOptions + '"' +
            ", defaultValue=" + '"' + defaultValue + '"' +
            ", isValueRequired=" + isValueRequired +
            ", minValue=" + minValue +
           ", maxValue=" + maxValue +
            ", minLength=" + minLength +
            ", maxLength=" + maxLength +
        '}';
    }
}
