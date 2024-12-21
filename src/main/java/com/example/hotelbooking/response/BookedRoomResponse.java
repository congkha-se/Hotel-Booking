package com.example.hotelbooking.response;

import com.example.hotelbooking.model.Room;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookedRoomResponse {

    private Long bookingId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String guestFullname;
    private String guestEmail;
    private String guestPhoneNumber;
    private int numOfChildren;
    private int numOfAdult;
    private int totalNumOfGuests;
    private String bookingConfirmationCode;
    private Room room;

    public BookedRoomResponse(Long bookingId, LocalDate checkInDate, LocalDate checkOutDate, String bookingConfirmationCode) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingConfirmationCode = bookingConfirmationCode;
    }

}
