package com.thetestingacademy.tests.restfulbooker.e2e_integration;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.pojos.requestPOJO.Booking;
import com.thetestingacademy.pojos.responsePOJO.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TestIntegrationFlow1 extends BaseTest {


    //Create booking, Create token
    //Verify that booking using GET
    //Update booking
    //Delete booking

    @Test(groups = "qa", priority = 1)
    @Owner("Aditya")
    @Description("TC#INT1- Step 1 - Verify that the booking can be created")
    public void testCreateBooking(ITestContext iTestContext){
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response=RestAssured.given(requestSpecification).when().body(payloadManager.createPayloadBookingAsJsonString()).post();
        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);
        BookingResponse bookingResponse =payloadManager.getResponseFromJSON(response.asString());
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(), "Aditya");

        Integer bookingid=bookingResponse.getBookingid();
        iTestContext.setAttribute("bookingid", bookingid);

    }

    @Test(groups = "qa", priority=2)
    @Owner("Aditya")
    @Description("TC#INT2- Step 2 - Verify the booking by id")
    public void testVerifyBookingId(ITestContext iTestContext){
        System.out.println(iTestContext.getAttribute("bookingid"));
        Integer bookingid= (Integer) iTestContext.getAttribute("bookingid");
        String basePathGET=APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        requestSpecification.basePath(basePathGET);
        response=RestAssured.given(requestSpecification).when().get();
        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);

       Booking booking=payloadManager.bookingResponseJava(response.asString());
       assertActions.verifyStringKeyNotNull(booking.getFirstname());


    }

    @Test(groups="qa", priority=3)
    @Owner("Aditya")
    @Description("TC#INT3- Step 3 - Verify update booking by bookingid")
    public void testUpdateBookingById(ITestContext iTestContext){
       Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
       String token=getToken();
       iTestContext.setAttribute("token", token);

       String basePathPUTPATCH=APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
       requestSpecification.basePath(basePathPUTPATCH);
       response=RestAssured.given(requestSpecification).cookie("token", token).when().body(payloadManager.fullUpdatePayloadAsJsonString()).put();
       validatableResponse=response.then().log().all();
       validatableResponse.statusCode(200);

      Booking booking= payloadManager.bookingResponseJava(response.asString());
      assertActions.verifyStringKeyNotNull(booking.getFirstname());
      assertActions.verifyStringKey(booking.getLastname(), "singh");


    }

    @Test(groups="qa", priority=4)
    @Owner("Aditya")
    @Description("TC#INT4- Step 4 - Verify delete booking by bookingid")
    public void testDeleteBookingById(ITestContext iTestContext){
       Integer bookingid= (Integer) iTestContext.getAttribute("bookingid");
       String token = (String) iTestContext.getAttribute("token");

       String basePathDELETE = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
       requestSpecification.basePath(basePathDELETE);
       response=RestAssured.given(requestSpecification).cookie("token", token).when().delete();
       validatableResponse=response.then().log().all();
       validatableResponse.statusCode(201);

    }
}
