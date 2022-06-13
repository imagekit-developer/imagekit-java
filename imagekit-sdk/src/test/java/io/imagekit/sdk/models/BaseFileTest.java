package io.imagekit.sdk.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class BaseFileTest {
    private BaseFile SUT;

    @Before
    public void setUp() throws Exception {
        SUT=new BaseFile();
    }

    @Test
    public void constructor_test() {
        List<String> tags=mock(List.class);
        SUT=new BaseFile("fileId", "name", "url", "thumbnail", 10, 10, 20, "filePath", tags,true, "0,0,10,20", "image", new JsonArray(), new JsonObject(), new JsonObject(), new JsonObject(), new JsonObject(), "file", "image/jpeg", false, new Date(), new Date());
        assertNotNull(SUT);
    }

    @Test
    public void test_getter_setter() {
        List<String> tags=mock(List.class);
//        SUT=new BaseFile("fileId", "name", "url", "thumbnail", 10, 10, 20, "filePath", tags,true, "0,0,10,20", "fileType");
        SUT.setFileId("fileId");
        SUT.setName("name");
        SUT.setUrl("url");
        SUT.setThumbnail("thumbnail");
        SUT.setHeight(10);
        SUT.setWidth(20);
        SUT.setSize(30);
        SUT.setFilePath("filePath");
        SUT.setTags(tags);
        SUT.setPrivateFile(true);
        SUT.setCustomCoordinates("0,0,10,20");
        SUT.setFileType("image");
        assertEquals("fileId",SUT.getFileId());
        assertEquals("name",SUT.getName());
        assertEquals("url",SUT.getUrl());
        assertEquals("thumbnail",SUT.getThumbnail());
        assertEquals(10,SUT.getHeight());
        assertEquals(20,SUT.getWidth());
        assertEquals(30,SUT.getSize());
        assertEquals("filePath",SUT.getFilePath());
        assertEquals(tags,SUT.getTags());
        assertEquals(true,SUT.isPrivateFile());
        assertEquals("0,0,10,20",SUT.getCustomCoordinates());
        assertEquals("image",SUT.getFileType());
    }
}