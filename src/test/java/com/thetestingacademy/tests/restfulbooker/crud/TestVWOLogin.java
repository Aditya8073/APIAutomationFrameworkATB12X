package com.thetestingacademy.tests.restfulbooker.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.pojos.responsePOJO.LoginResponse;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestVWOLogin extends BaseTest {

    @Test
    public void testVWOLoginPOST(){

        // Setup will be first and making the request - Part - 1
        requestSpecification.baseUri(APIConstants.APP_VWO_URL);
        response=RestAssured.given(requestSpecification).when().body(payloadManager.setLoginPayload()).post();
        System.out.println(response);
        validatableResponse=response.then().log().all();
        response.getStatusCode();

        //Extraction Part - 2
        LoginResponse loginResponse=payloadManager.getLoginResponse(response.asString());

        // Validation and verification via the AssertJ, TestNG Part -
        assertActions.verifyResonseStatusCode(response,200);
        System.out.println(loginResponse.getAccountId());
        assertActions.verifyStringKeyNotNull(loginResponse.getEmail());
        assertActions.verifyStringKeyNotNull(loginResponse.getId());
        assertActions.verifyStringKey(loginResponse.getName(), "Aditya Verma");
    }
}
