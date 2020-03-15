package io.imagekit.sdk.models;

import okhttp3.RequestBody;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class FileUpdateRequestTest {
    @Test
    public void constructor_test() {
        FileUpdateRequest SUT=new FileUpdateRequest("file_id");
        assertEquals("file_id",SUT.getFileId());
    }

    @Test
    public void test_getter_setter_methods() {
        List<String> tags=mock(List.class);
        FileUpdateRequest SUT=new FileUpdateRequest("file_id");
        SUT.setCustomCoordinates("0,0,10,20");
        SUT.setFileId("file_id1");
        SUT.setTags(tags);

        assertEquals("0,0,10,20",SUT.getCustomCoordinates());
        assertEquals("file_id1",SUT.getFileId());
        assertEquals(tags,SUT.getTags());
    }

//    @Test
//    public void prepareRequest_expectSuccess() {
//        FileUpdateRequest SUT=new FileUpdateRequest("file_id");
//        SUT.setCustomCoordinates("0,0,10,20");
//        RequestBody requestBody = SUT.prepareRequest();
//        assertNotNull(requestBody);
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void prepareRequest_with_null_file_id_expectRuntime_exception() {
//        FileUpdateRequest SUT=new FileUpdateRequest(null);
//        SUT.setCustomCoordinates("0,0,10,20");
//        RequestBody requestBody = SUT.prepareRequest();
//        assertNotNull(requestBody);
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void prepareRequest_with_empty_file_id_expectRuntime_exception() {
//        FileUpdateRequest SUT=new FileUpdateRequest("");
//        SUT.setCustomCoordinates("0,0,10,20");
//        RequestBody requestBody = SUT.prepareRequest();
//        assertNotNull(requestBody);
//    }

}