package com.hairvision.booking.controller;

import com.hairvision.booking.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hairvision.booking.service.CustomerDataService.readCustomerFromCsv;

@Slf4j
@RestController
@RequestMapping(path = "/login")
public class LogInController {

    @PostMapping(path = "/")
    public boolean validateCustomer(@RequestParam String email, String password) {
        boolean status = false;
        String customerDataFile = "customer-data.csv";
        List<Customer> customers = readCustomerFromCsv(customerDataFile);
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                log.info("Registered customer " + email + " successfully logged in.");
                status = true;
            }
        }
        return status;
    }
}
