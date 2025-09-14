package com.thetestingacademy.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.thetestingacademy.pojos.requestPOJO.Auth;
import com.thetestingacademy.pojos.requestPOJO.Booking;
import com.thetestingacademy.pojos.requestPOJO.Bookingdates;
import com.thetestingacademy.pojos.requestPOJO.LoginRequest;
import com.thetestingacademy.pojos.responsePOJO.BookingResponse;
import com.thetestingacademy.pojos.responsePOJO.InvalidTokenResponse;
import com.thetestingacademy.pojos.responsePOJO.LoginResponse;
import com.thetestingacademy.pojos.responsePOJO.TokenResponse;

public class PayloadManager {
    Gson gson;
    Faker faker;

    //Convert the Java object into the JSON String to send as a payload
    //Serialization
    public String createPayloadBookingAsJsonString(){
        Booking booking = new Booking();
        booking.setFirstname("Aditya");
        booking.setLastname("Verma");
        booking.setTotalprice(1234);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        gson = new Gson();
        String jsonStringBooking=gson.toJson(booking);
        return jsonStringBooking;
    }

    public String fullUpdatePayloadAsJsonString(){
        Booking booking = new Booking();
        booking.setFirstname("Av");
        booking.setLastname("singh");
        booking.setTotalprice(342);
        booking.setDepositpaid(false);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2025-02-01");
        bookingdates.setCheckout("2025-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Lunch");

        System.out.println(booking);

        gson = new Gson();
        String fullUpdatePayloadJson=gson.toJson(booking);
        return fullUpdatePayloadJson;

    }

    //Convert JSON String to Java Object to verify the response body
    //DeSerialization
    public BookingResponse getResponseFromJSON(String responseString){
        gson = new Gson();
        BookingResponse bookingResponse=gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;
    }

    public Booking bookingResponseJava(String responseString){
        gson = new Gson();
        Booking booking = gson.fromJson(responseString, Booking.class);
        return booking;
    }

    public String createBookingPayloadFakerJson(){

        faker = new Faker();
        Booking booking = new Booking();
        booking.setFirstname(faker.name().firstName());
        booking.setLastname(faker.name().lastName());
        booking.setTotalprice(faker.random().nextInt(1,1000));
        booking.setDepositpaid(faker.random().nextBoolean());

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        gson = new Gson();
        String jsonStringBooking=gson.toJson(booking);
        return jsonStringBooking;
    }

    // Java Object -> JSON
    public String setAuthPayload(){
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");

        gson = new Gson();
        String jsonPayloadString=gson.toJson(auth);
        System.out.println(jsonPayloadString);
        return jsonPayloadString;
    }

    //Convert JSON String to Java Object to verify the response body
    //DeSerialization
    public String getTokenResponse(String tokenResponse){
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponse1.getToken();
    }

    public String getInvalidTokenResponse(String invalidTokenResponse){
        gson = new Gson();
        InvalidTokenResponse invalidTokenResponse1 = gson.fromJson(invalidTokenResponse, InvalidTokenResponse.class);
        return invalidTokenResponse1.getReason();
    }

    //Serialization
    public String setLoginPayload(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("foxov16779@aravites.com");
        loginRequest.setPassword("Adi@06031998");
        loginRequest.setRemember(true);
        loginRequest.setRecaptchaResponseField("");

        gson = new Gson();
        String jsonPayloadString=gson.toJson(loginRequest);
        System.out.println(jsonPayloadString);
        return jsonPayloadString;
    }

    //De-serialization
    public LoginResponse getLoginResponse(String loginResponseEx){
        gson = new Gson();
        LoginResponse loginResponse = gson.fromJson(loginResponseEx, LoginResponse.class);
        return loginResponse;
    }
}
