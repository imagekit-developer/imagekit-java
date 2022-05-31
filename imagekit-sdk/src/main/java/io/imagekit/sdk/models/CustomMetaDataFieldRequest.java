package io.imagekit.sdk.models;


public class CustomMetaDataFieldRequest {
    private String name;
    private String label;
    private CustomMetaDataFieldSchemaObject schema = new CustomMetaDataFieldSchemaObject();

    public CustomMetaDataFieldRequest() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "CustomMetaDataFieldRequest{" +
                "name=" + name +
                ", label=" + label +
                ", schema=" + schema +
                '}';
    }
}
