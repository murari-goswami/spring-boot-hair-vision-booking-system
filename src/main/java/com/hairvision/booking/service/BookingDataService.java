package com.hairvision.booking.service;

import com.hairvision.booking.model.Booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BookingDataService {

    public static List<Booking> readBookingFromCsv(String fileName) {
        List<Booking> bookings = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Booking booking = createBooking(attributes);
                bookings.add(booking);
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    public static Booking createBooking(String[] metadata) {
        String CustomerName = metadata[0];
        String CustomerEmail = metadata[1];
        String BookingDateTime = metadata[2];
        String HairCutType = metadata[3];
        String CreateTimestamp = metadata[4];

        // create and return book of this metadata
        return new Booking(CustomerName, CustomerEmail, BookingDateTime, HairCutType, CreateTimestamp);
    }
}
