package com.hairvision.booking.controller;


import com.hairvision.booking.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.hairvision.booking.service.CustomerDataService.readCustomerFromCsv;

@Slf4j
@RestController
@RequestMapping(path = "/signup")
public class SignUpController {


    @PostMapping(path="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> createNewCustomer(@RequestBody Customer customer) {
        String customerDataFile = "customer-data.csv";
        String retStatus = null;
        List<Customer> customers = readCustomerFromCsv(customerDataFile);
        for (Customer singleCustomerRec : customers) {
            if (singleCustomerRec.getEmail().equals(customer.getEmail())) {
                retStatus = customer.getEmail() + " is already registered !!!";
                log.info(retStatus);
                return Collections.singletonMap("response", retStatus);
            }
        }

        writeData(customerDataFile, customer);

        return Collections.singletonMap("response", retStatus);
    }

    // write data call internally
    private void writeData(String fileName, Customer customer) {

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(new File(fileName), true))) {
            String userRow = customer.getName()+ ',' + customer.getEmail() + ',' + customer.getPassword()+ ','
                    + customer.getPhoneNumber() + ',' + customer.getAddress();
            writer.write(userRow + System.getProperty("line.separator"));

            log.info("Done!");

        } catch (Exception exp) {
            log.info("Could Not Save The Record!");
        }
    }
}
