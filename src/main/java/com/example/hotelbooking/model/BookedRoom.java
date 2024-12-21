package com.example.hotelbooking.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @Column(name = "check_in_Date")
    private LocalDate checkInDate;

    @Column(name = "check_out_Date")
    private LocalDate checkOutDate;

    @Column(name = "guest_full_name")
    private String guestFullname;

    @Column(name = "guest_email")
    private String guestEmail;

    @Column(name = "phone_number")
    private String guestPhoneNumber;

    @Column(name = "children")
    private int numOfChildren;

    @Column(name = "adults")
    private int numOfAdult;

    @Column(name = "total_guest")
    private int totalNumOfGuests;

    @Column(name = "Confirmation_code")
    private String bookingConfirmationCode;

    @Column(name = "room_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Room room;


    public void calculateTotalNumOfGuests() {
        this.totalNumOfGuests = this.numOfChildren + this.numOfAdult;
    }

    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
        calculateTotalNumOfGuests();
    }

    public void setNumOfAdult(int numOfAdult) {
        this.numOfAdult = numOfAdult;
        calculateTotalNumOfGuests();
    }

    public BookedRoom(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }

}
