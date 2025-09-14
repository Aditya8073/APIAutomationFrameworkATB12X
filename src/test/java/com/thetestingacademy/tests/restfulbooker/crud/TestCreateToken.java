package com.thetestingacademy.tests.restfulbooker.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TestCreateToken extends BaseTest {

    @Test(groups= "reg", priority = 1)
    @Description("TC#1 - Create Token and verify")
    @Owner("Aditya Verma")

    public void testTokenPOST(){

        requestSpecification.basePath(APIConstants.AUTH_URL);
        response=RestAssured.given(requestSpecification)
                .when()
                .body(payloadManager.setAuthPayload()).log().all()
                .post();

        // Extraction ( JSON String response to Java Object)
        String token=payloadManager.getTokenResponse(response.asString());
        System.out.println(token);

        // Validation of the request.
        assertActions.verifyStringKeyNotNull(token);
    }

    @Test(groups= "reg", priority = 2)
    @Description("TC#2 - Create Invalid Token and verify")
    @Owner("Aditya Verma")
    public void testInvalidTokenPOST(){

        requestSpecification.basePath(APIConstants.AUTH_URL);
            response=RestAssured.given(requestSpecification)
                    .when().body("{}").post();

            String invalidReason=payloadManager.getInvalidTokenResponse(response.asString());
        System.out.println(invalidReason);

        assertActions.verifyStringKeyNotNull(invalidReason);
        assertActions.verifyStringKey(invalidReason, "Bad credentials");
        }

}
