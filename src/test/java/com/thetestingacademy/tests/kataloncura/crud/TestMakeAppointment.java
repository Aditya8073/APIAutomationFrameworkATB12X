package com.thetestingacademy.tests.kataloncura.crud;

import com.thetestingacademy.base.KatalonBaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestMakeAppointment extends KatalonBaseTest {

    @Test(groups = "reg", priority = 1)
    @Description("TC#1 - veirfy if user is able to make appointmentMake Appointment")
    @Owner("Aditya Verma")
    public void testMakeAppointmentPost(){

        String formBody="facility=Seoul CURA Healthcare Center&hospital_readmission=Yes&programs=Medicaid&visit_date=25/09/2024&comment=dasdasda";

        requestSpecification.basePath(APIConstants.KATALON_Login_URL);
        response=RestAssured.given(requestSpecification).when().body(formBody).post();
        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(302);
    }
}
