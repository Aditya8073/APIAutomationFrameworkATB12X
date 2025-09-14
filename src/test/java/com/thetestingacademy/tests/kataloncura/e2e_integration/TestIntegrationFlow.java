package com.thetestingacademy.tests.kataloncura.e2e_integration;

import com.thetestingacademy.base.KatalonBaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestIntegrationFlow extends KatalonBaseTest {

    @Test(groups = "qa", priority = 1)
    @Owner("Aditya")
    @Description("TC#INT1- Step 1 - Verify that the user is able to login")
    public void testKatalonLoginPage(){
        requestSpecification.basePath(APIConstants.KATALON_Login_URL);
        response= RestAssured.given(requestSpecification).redirects().follow(false)
                .formParam("username","John Doe").formParam("password", "ThisIsNotAPassword").when()
                .post();
        validatableResponse=response.then().log().all();
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " +response.getBody().asString());
        validatableResponse.statusCode(302);
    }

    @Test(groups = "qa", priority = 2)
    @Owner("Aditya")
    @Description("TC#INT1- Step 1 - Verify that user is able to make appointment")
    public void testKatalonMakeAppointment(){
        String formBody="facility=Seoul CURA Healthcare Center&hospital_readmission=Yes&programs=Medicaid&visit_date=25/09/2024&comment=dasdasda";

        requestSpecification.basePath(APIConstants.KATALON_Login_URL);
        response=RestAssured.given(requestSpecification).when().body(formBody).post();
        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(302);
    }


}
