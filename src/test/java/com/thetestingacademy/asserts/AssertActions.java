package com.thetestingacademy.asserts;

import io.restassured.response.Response;

import static org.testng.AssertJUnit.assertEquals;
import static org.assertj.core.api.Assertions.*;

public class AssertActions {

    public void verifyResponseBody(String actual, String expected, String description){
        assertEquals(actual,expected,description);
    }

    public void verifyResponseBody(int actual, int expected) {
        assertEquals(actual, expected);
    }

    public void verifyResonseStatusCode(Response response, int expected){
        assertEquals(response.getStatusCode(),expected);
    }

    public void verifyStringKey(String keyExpect, String KeyActual){
        //Assertj
        assertThat(keyExpect).isNotNull();
        assertThat(keyExpect).isNotBlank();
        assertThat(keyExpect).isEqualTo(KeyActual);
    }

    public void verifyStringKeyNotNull(String keyExpect){
        assertThat(keyExpect).isNotNull();
    }

    public void verifyStringKeyNotNull(Integer keyExpect){
        assertThat(keyExpect).isNotNull();
    }

    public void verifyTrue(boolean keyExpect){
        assertThat(keyExpect);
    }

}
