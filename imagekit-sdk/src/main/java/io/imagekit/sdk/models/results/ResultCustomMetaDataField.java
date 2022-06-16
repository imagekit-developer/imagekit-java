package io.imagekit.sdk.models.results;

import io.imagekit.sdk.models.CustomMetaDataFieldSchemaObject;
import io.imagekit.sdk.models.ResponseMetaData;

public class ResultCustomMetaDataField {
    private String id;
    private String name;
    private String label;
    private CustomMetaDataFieldSchemaObject schema = new CustomMetaDataFieldSchemaObject();
    private ResponseMetaData responseMetaData = new ResponseMetaData();

    public ResultCustomMetaDataField() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public ResponseMetaData getResponseMetaData() {
        return responseMetaData;
    }

    public void setResponseMetaData(ResponseMetaData responseMetaData) {
        this.responseMetaData = responseMetaData;
    }

    @Override
    public String toString() {
        return "ResultCustomMetaDataField{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", label='" + label + '\'' +
                ", schema=" + schema +
                ", responseMetaData=" + responseMetaData +
                '}';
    }
}
