package io.imagekit.sdk.utils;

import io.imagekit.sdk.config.Configuration;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class UtilsTest {

    @Test
    public void empty_listToString_returnTrue() {
        List<String> list=new ArrayList<>();
        String data=Utils.listToString(list);
        assertNotNull(data);
    }

    @Test
    public void withElements_listToString_returnTrue() {
        List<String> list=new ArrayList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");
        String data=Utils.listToString(list);
        assertThat("Element 1,Element 2,Element 3",is(data));
    }

    @Test
    public void withNullElements_listToString_returnTrue() {
        List<String> list=new ArrayList<>();
        list.add("Element 1");
        list.add(null);
        list.add("Element 2");
        String data=Utils.listToString(list);
        assertEquals("Element 1,Element 2",data);
    }

    @Test
    public void withNullElements_listToString_returnFalse() {
        List<String> list=new ArrayList<>();
        list.add("Element 1");
        list.add(null);
        list.add("Element 2");
        String data=Utils.listToString(list);
        assertNotEquals("Element 1,null,Element 2",data);
    }

    @Test
    public void validFile_fileToBase64_expectedTrue() {
        URL imageURL = UtilsTest.class.getClassLoader().getResource("sample1.jpg");
        File file=new File(imageURL.getPath());
        String base64 = Utils.fileToBase64(file);
        assertNotNull(base64);
    }

    @Test(expected = Exception.class)
    public void noFile_fileToBase64_expectedTrue() {
        File file=mock(File.class);
        String base64 = Utils.fileToBase64(file);
        assertNull(base64);
    }

    @Test
    public void validFile_fileToBytes_expectedTrue() {
        URL imageURL = UtilsTest.class.getClassLoader().getResource("sample1.jpg");
        File file=new File(imageURL.getPath());
        byte[] bytes = Utils.fileToBytes(file);
        assertNotNull(bytes);
    }

    @Test(expected = Exception.class)
    public void noFile_fileToBytes_expectedTrue() {
        File file=mock(File.class);
        byte[] bytes = Utils.fileToBytes(file);
        assertNull(bytes);
    }

    @Test
    public void test_getSystemConfig_expectedSuccess() throws IOException {
        Configuration config=Utils.getSystemConfig(UtilsTest.class);
        assertNotNull(config);
    }

    @Test
    public void validImageURL_isReadableImage_expectedTrue() {
        URL imageURL = UtilsTest.class.getClassLoader().getResource("sample1.jpg");
        assertTrue(Utils.isReadableImage(imageURL));
    }

    @Test
    public void validImageByteArray_isReadableImage_expectedTrue() {
        URL imageURL = UtilsTest.class.getClassLoader().getResource("sample1.jpg");
        File file=new File(imageURL.getPath());
        byte[] bytes = Utils.fileToBytes(file);
        assertTrue(Utils.isReadableImage(bytes));
    }

    @Test
    public void validImageBase64_isReadableImage_expectedTrue() {
        URL imageURL = UtilsTest.class.getClassLoader().getResource("sample1.jpg");
        File file=new File(imageURL.getPath());
        String base64 = Utils.fileToBase64(file);
        assertTrue(Utils.isReadableImage(base64));
    }
}