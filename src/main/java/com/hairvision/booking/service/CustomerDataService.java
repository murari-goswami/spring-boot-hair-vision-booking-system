package com.hairvision.booking.service;

import com.hairvision.booking.model.Customer;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CustomerDataService {

    public static List<Customer> readCustomerFromCsv(String fileName) {
        List<Customer> customers = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Customer customer = createCustomer(attributes);
                customers.add(customer);
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }

    public static Customer createCustomer(String[] metadata) {
        String name = metadata[0];
        String email = metadata[1];
        String password = metadata[2];
        String phoneNumber = metadata[3];
        String address = metadata[4];

        // create and return book of this metadata
        return new Customer(name, email, password, phoneNumber, address);
    }

}
