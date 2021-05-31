package com.example.reservationsystem.reservation;

import com.example.reservationsystem.room.Room;
import com.example.reservationsystem.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "reservation_id")
    private int id;
    private LocalDate date;
    private String status;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User userId;
    private int clientPhoneNumber;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room roomId;
}
