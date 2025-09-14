package com.thetestingacademy.tests.restfulbooker.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestHealthCheck extends BaseTest {

    @Test(groups = "reg", priority = 1)
    @Owner("Aditya")
    @Description("TC#3 - Verify Health Check")
    public void testHealthCheck(){
        requestSpecification.basePath(APIConstants.PING_URL);
        response=RestAssured.given(requestSpecification).when().get();
        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(201);

        assertActions.verifyTrue(response.asString().contains("Created"));
        assertActions.verifyStringKey(response.asString(), "Created");

    }
}
