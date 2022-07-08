package io.imagekit.sdk.models;

public class CustomMetaDataFieldSchemaObject {
	private CustomMetaDataTypeEnum type;
	private Object selectOptions;
	private Object defaultValue;
	private Boolean isValueRequired;
	private Object minValue;
	private Object maxValue;
	private Integer minLength;
	private Integer maxLength;

	public CustomMetaDataFieldSchemaObject() {

	}

	public CustomMetaDataTypeEnum getType() {
		return type;
	}

	public void setType(CustomMetaDataTypeEnum type) {
		this.type = type;
	}

	public Object getSelectOptions() {
		return selectOptions;
	}

	public void setSelectOptions(Object selectOptions) {
		this.selectOptions = selectOptions;
	}

	public Object getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
	}

	public Boolean getValueRequired() {
		return isValueRequired;
	}

	public void setValueRequired(Boolean valueRequired) {
		isValueRequired = valueRequired;
	}

	public Object getMinValue() {
		return minValue;
	}

	public void setMinValue(Object minValue) {
		this.minValue = minValue;
	}

	public Object getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Object maxValue) {
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
	public String toString() {
		return "CustomMetaDataFieldSchemaObject{" +
				"type=" + type +
				", selectOptions=" + selectOptions +
				", defaultValue=" + defaultValue +
				", isValueRequired=" + isValueRequired +
				", minValue=" + minValue +
				", maxValue=" + maxValue +
				", minLength=" + minLength +
				", maxLength=" + maxLength +
				'}';
	}
}
