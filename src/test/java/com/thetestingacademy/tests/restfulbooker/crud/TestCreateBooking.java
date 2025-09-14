package com.thetestingacademy.tests.restfulbooker.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.pojos.responsePOJO.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateBooking extends BaseTest {

    @Test(groups= "reg", priority=1)
    @Owner("Aditya Verma")
    @Description("TC#1- Verify that the Booking can be created")
    public void testCreateBookingPOST_Positive(){

        //Setup method will run first then make a request - Part 1
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
       response = RestAssured.given(requestSpecification)
               .when().body(payloadManager.createPayloadBookingAsJsonString()).log().all()
               .post();

       //Extracting the response - Part 2
        BookingResponse bookingResponse = payloadManager.getResponseFromJSON(response.asString());

        //Validation and verification via the AssertJ, TestNG - Part 3
        assertActions.verifyResonseStatusCode(response,200);

        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(), "Aditya");


    }

    @Test(groups = "reg", priority = 2)
    @Owner("Aditya Verma")
    @Description("TC#2- Verify that the booking id cannot be created when payload is null")
    public void testCreateBookingPOST_Negative(){

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response=RestAssured.given(requestSpecification)
                .when().body("{ }").log().all()
                .post();
        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(500);
    }

    @Test(groups= "reg", priority = 3)
    @Owner("Aditya Verma")
    @Description("TC#3 - Verify that booking can be created by sending random payload")
    public void testCreateBookingPOST_Random(){
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
       response = RestAssured.given(requestSpecification)
               .when().body(payloadManager.createBookingPayloadFakerJson()).log().all()
               .post();
       validatableResponse=response.then().log().all();
       validatableResponse.statusCode(200);

       BookingResponse bookingResponse = payloadManager.getResponseFromJSON(response.asString());

       assertActions.verifyResonseStatusCode(response, 200);
       assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
      // assertActions.verifyTrue(bookingResponse.getBooking().getDepositpaid());
    }
}
