package io.imagekit.sdk.tasks;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CalculationTest {
    Calculation SUT;

    @Before
    public void setUp() throws Exception {
        SUT=new Calculation();
    }

    @Test(expected = RuntimeException.class)
    public void nullPrivateKey_getAuthenticatedParams_throwException() {
        Calculation.getAuthenticatedParams(UUID.randomUUID().toString(), Calendar.getInstance().getTimeInMillis(),null);
    }

    @Test
    public void privateKeyProvided_getAuthenticatedParams_with_static_input_ExpectedData() {
        String token="your_token";
        String privateKey="private_key_test";
        long expire=1582269249;
        Map<String, String> authenticatedParams = Calculation.getAuthenticatedParams(token, expire, privateKey);
        assertEquals(token,authenticatedParams.get("token"));
        assertEquals(String.valueOf(expire),authenticatedParams.get("expire"));
        assertEquals("e71bcd6031016b060d349d212e23e85c791decdd",authenticatedParams.get("signature"));
    }

    @Test
    public void privateKeyProvided_getAuthenticatedParams_ExpectedData() {
        String token=UUID.randomUUID().toString();
        String privateKey="my_private_key";
        long expire=Calendar.getInstance().getTimeInMillis();
        Map<String, String> authenticatedParams = Calculation.getAuthenticatedParams(token, expire, privateKey);
        assertThat(authenticatedParams.get("token"),is(token));
        assertEquals(String.valueOf(expire),authenticatedParams.get("expire"));
        assertNotNull(authenticatedParams.get("signature"));
    }

    @Test
    public void expireNotProvided_getAuthenticatedParams_ExpectedData() {
        String token=UUID.randomUUID().toString();
        String privateKey="my_private_key";
        Map<String, String> authenticatedParams = Calculation.getAuthenticatedParams(token,0, privateKey);
        assertThat(authenticatedParams.get("token"),is(token));
        assertNotNull(authenticatedParams.get("expire"));
        assertNotNull(authenticatedParams.get("signature"));
    }

    @Test
    public void sameImage_getHammingDistance_expectedSuccessWith() {
        int hammingDistance = Calculation.getHammingDistance("f06830ca9f1e3e90", "f06830ca9f1e3e90");
        assertEquals(0,hammingDistance);
    }

    @Test
    public void similarImage_getHammingDistance_expectedSuccessWith() {
        int hammingDistance = Calculation.getHammingDistance("2d5ad3936d2e015b", "2d6ed293db36a4fb");
        assertEquals(17,hammingDistance);
    }

    @Test
    public void dissimilarImage_getHammingDistance_expectedSuccessWith() {
        int hammingDistance = Calculation.getHammingDistance("a4a65595ac94518b", "7838873e791f8400");
        assertEquals(37,hammingDistance);
    }

    @Test(expected = RuntimeException.class)
    public void invalidHash_getHammingDistance_throwException() {
        int hammingDistance = Calculation.getHammingDistance("a4a65595ac94518Z", "7838873e791f8400");
    }

    @Test(expected = RuntimeException.class)
    public void differentLength_getHammingDistance_throwException() {
        int hammingDistance = Calculation.getHammingDistance("a4a65595ac94518b3", "7838873e791f8400");
    }

    @Test
    public void correctHex_isValidHex_trueExpected() {
        boolean result=Calculation.isValidHex("a4a65595ac94518b");
        assertTrue(result);
    }

    @Test
    public void incorrectHex_isValidHex_falseExpected() {
        boolean result=Calculation.isValidHex("a4a65595ac94518T");
        assertFalse(result);
    }

    @After
    public void tearDown() throws Exception {
        SUT=null;
    }
}