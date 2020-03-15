package io.imagekit.sdk.tasks;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueryMakerTest {

    QueryMaker SUT;

    @Before
    public void setUp() throws Exception {
        SUT=new QueryMaker();
    }

    @Test
    public void prepareQueary_returnQueryString() {
        SUT.put("public=allow");
        SUT.put("user=guest");
        String param = SUT.get();
        assertEquals("public=allow&user=guest",param);
    }

    @Test
    public void withoutEntry_prepareQueary() {
        String param = SUT.get();
        assertNull(param);
    }
}