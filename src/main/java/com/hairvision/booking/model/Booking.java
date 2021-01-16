package com.hairvision.booking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Booking {
    String CustomerName;
    String CustomerEmail;
    String BookingDateTime;
    String HairCutType;
    String CreateTimestamp;
}