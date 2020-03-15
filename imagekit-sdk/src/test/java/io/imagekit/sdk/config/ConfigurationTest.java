package io.imagekit.sdk.config;

import org.junit.Test;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ConfigurationTest {

    Configuration SUT;

    @Test
    public void configFileExit_validate_successExpected() throws IOException {
        SUT=new Configuration();
        SUT.setPrivateKey("privateKey");
        SUT.setPublicKey("publicKey");
        SUT.setUrlEndpoint("endPoint");

        boolean result=SUT.validate();
        assertTrue(result);
    }

    @Test(expected = RuntimeException.class)
    public void configNotExit_validate_errorExpected() throws IOException {
        SUT=new Configuration();
        SUT.setPrivateKey("privateKey");
        SUT.setUrlEndpoint("endPoint");

        boolean result=SUT.validate();
        assertTrue(result);
    }

    @Test
    public void config_getter_setter_successExpected() throws IOException {
        String privateKey="privateKey";
        String publicKey="publicKey";
        String endPoint="endPoint";
        SUT=new Configuration(publicKey,privateKey,endPoint);
        assertThat(privateKey,is(SUT.getPrivateKey()));
        assertThat(publicKey,is(SUT.getPublicKey()));
        assertThat(endPoint,is(SUT.getUrlEndpoint()));
    }
}