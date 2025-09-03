package com.thetestingacademy.tests.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationSample {

    //Create booking, Create token
    //Verify that booking using GET
    //Update booking
    //Delete booking

    @Test(groups = "qa", priority = 1)
    @Owner("Aditya")
    @Description("TC#INT1- Step 1 - Verify that the booking can be created")
    public void testCreateBooking(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority=2)
    @Owner("Aditya")
    @Description("TC#INT2- Step 2 - Verify the booking by id")
    public void testVerifyBookingId(){
        Assert.assertTrue(true);
    }

    @Test(groups="qa", priority=3)
    @Owner("Aditya")
    @Description("TC#INT3- Step 3 - Verify update booking by id")
    public void testUpdateBookingById(){
        Assert.assertTrue(true);
    }

    @Test(groups="qa", priority=4)
    @Owner("Aditya")
    @Description("TC#INT4- Step 4 - Verify delete booking by id")
    public void testDeleteBookingById(){
        Assert.assertTrue(true);
    }

}
