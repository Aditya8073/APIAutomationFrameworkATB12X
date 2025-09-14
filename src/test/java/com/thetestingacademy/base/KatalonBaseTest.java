package com.thetestingacademy.base;

import com.thetestingacademy.asserts.AssertActions;
import com.thetestingacademy.endpoints.APIConstants;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class KatalonBaseTest {

    // CommonToAll Testcase
    // Base URL, Content Type - application/x-www-form-urlencoded - common

    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public AssertActions assertActions;

    @BeforeTest
    public void setup(){

//        requestSpecification=RestAssured.given();
//        requestSpecification.baseUri(APIConstants.KATALON_CURA_URL);
//        requestSpecification.contentType("application/x-www-form-urlencoded").log().all();

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.KATALON_CURA_URL)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build().log().all();
    }

    @AfterTest
    public void tearDown(){
        System.out.println("Test finished");
    }


}
