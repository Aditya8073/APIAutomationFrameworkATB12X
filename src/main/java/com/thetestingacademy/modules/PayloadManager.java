package com.thetestingacademy.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.thetestingacademy.pojos.requestPOJO.Booking;
import com.thetestingacademy.pojos.requestPOJO.Bookingdates;
import com.thetestingacademy.pojos.responsePOJO.BookingResponse;

public class PayloadManager {
    Gson gson;
    Faker faker;

    //Convert the Java object into the JSON String to send as a payload
    //Serialization
    public String createPayloadBookingAsString(){
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

    //Convert JSON String to Java Object to verify the response body
    //DeSerialization
    public BookingResponse getResponseFromJSON(String responseString){
        gson = new Gson();
        BookingResponse bookingResponse=gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;

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
}
