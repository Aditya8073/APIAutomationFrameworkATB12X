package com.thetestingacademy.tests.kataloncura.crud;

import com.thetestingacademy.base.KatalonBaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestLoginPage extends KatalonBaseTest {

    @Test(groups="reg", priority = 1)
    @Description("Tc#1 - Verifying the login by providing the valid username and password")
    @Owner("Aditya Verma")
    public void testLoginPagePOST(){
        requestSpecification.basePath(APIConstants.KATALON_Login_URL);
        response=RestAssured.given(requestSpecification).redirects().follow(false)
                .formParam("username","John Doe").formParam("password", "ThisIsNotAPassword").when()
                .post();
        validatableResponse=response.then().log().all();
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " +response.getBody().asString());
        validatableResponse.statusCode(302);
    }
}
