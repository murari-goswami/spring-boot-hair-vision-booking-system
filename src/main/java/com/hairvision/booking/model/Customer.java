package com.hairvision.booking.model;


import lombok.*;

@Data
@AllArgsConstructor
@ToString
public class Customer {

    String name;
    String email;
    String password;
    String phoneNumber;
    String address;

}
