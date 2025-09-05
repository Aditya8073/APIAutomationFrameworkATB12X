package com.thetestingacademy.pojos.responsePOJO;

import com.thetestingacademy.pojos.requestPOJO.Booking;

import java.util.LinkedHashMap;
import java.util.Map;

//Booking response
//{
//        "bookingid": 1,
//        "booking": {
//        "firstname": "Jim",
//        "lastname": "Brown",
//        "totalprice": 111,
//        "depositpaid": true,
//        "bookingdates": {
//        "checkin": "2018-01-01",
//        "checkout": "2019-01-01"
//        },
//        "additionalneeds": "Breakfast"
//        }
//        }

public class BookingResponse {

    private Integer bookingid;
    private Booking booking;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}