package com.example.hotelbooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomType;
    private BigDecimal price;
    private boolean isBooked;

    @Lob
    private Blob photo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookedRoom> bookings;


    public Room() {
        this.bookings = new ArrayList<>();
    }

    public static String generateString(){
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public void addBookedRoom(BookedRoom booking) {
        //ktra xem booking có chưa vì một nguời có thể book nhều phòng
        if(this.bookings == null) {
            this.bookings = new ArrayList<>();
        }
        this.bookings.add(booking);
        booking.setRoom(this);
        booking.setRoom(this);
        isBooked = true;
        String bookingCode = generateString();
        booking.setBookingConfirmationCode(bookingCode);


    }



}
