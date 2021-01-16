package com.hairvision.booking.controller;

import com.hairvision.booking.model.Booking;
import com.hairvision.booking.model.Customer;
import com.hairvision.booking.service.BookingDataService;
import com.hairvision.booking.service.CustomerDataService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/admin/")
public class AdminController {

    @GetMapping(path = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getCustomer() {
        String customerDataFile = "customer-data.csv";
        return CustomerDataService.readCustomerFromCsv(customerDataFile);
    }

    @GetMapping(path = "/bookings", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Booking> getBookings() {
        String customerBookingFile = "customer-booking.csv";
        return BookingDataService.readBookingFromCsv(customerBookingFile);
    }
}
