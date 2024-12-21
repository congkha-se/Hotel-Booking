package com.example.hotelbooking.response;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;

@NoArgsConstructor

public class RoomResponse {
    private long id;
    private String roomType;
    private BigDecimal price;
    private boolean isBooked;
    private String photo;
    private List<RoomResponse> bookings;

    public RoomResponse(long id, String roomType, BigDecimal price) {
        this.id = id;
        this.roomType = roomType;
        this.price = price;
    }

    public RoomResponse(long id, String roomType, BigDecimal price, boolean isBooked, byte[] photo, List<RoomResponse> bookings) {
        this.id = id;
        this.roomType = roomType;
        this.price = price;
        this.isBooked = isBooked;
        this.photo = photo != null ? Base64.getEncoder().encodeToString(photo) : null;
        this.bookings = bookings;

    }


}
