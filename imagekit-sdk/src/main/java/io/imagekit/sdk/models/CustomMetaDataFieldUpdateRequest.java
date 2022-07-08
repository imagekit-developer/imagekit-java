package io.imagekit.sdk.models;

public class CustomMetaDataFieldUpdateRequest {
	private String id;
	private String label;
	private CustomMetaDataFieldSchemaObject schema = new CustomMetaDataFieldSchemaObject();

	public CustomMetaDataFieldUpdateRequest() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public CustomMetaDataFieldSchemaObject getSchema() {
		return schema;
	}

	public void setSchema(CustomMetaDataFieldSchemaObject schema) {
		this.schema = schema;
	}

	@Override
	public String toString() {
		return "CustomMetaDataFieldRequest{" + "id=" + '"' + id + '"' + ", label=" + '"' + label + '"' + ", schema="
				+ schema + '}';
	}
}
