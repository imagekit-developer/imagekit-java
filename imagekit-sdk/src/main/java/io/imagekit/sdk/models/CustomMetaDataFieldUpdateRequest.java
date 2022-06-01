package io.imagekit.sdk.models;

public class CustomMetaDataFieldUpdateRequest {
    private String id;
    private CustomMetaDataFieldSchemaObject schema = new CustomMetaDataFieldSchemaObject();

    public CustomMetaDataFieldUpdateRequest() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomMetaDataFieldSchemaObject getSchema() {
        return schema;
    }

    public void setSchema(CustomMetaDataFieldSchemaObject schema) {
        this.schema = schema;
    }

    @Override
    public String toString() {
        return "CustomMetaDataFieldRequest{" +
                "id=" + '"' + id + '"' +
                ", schema=" + schema +
                '}';
    }
}
