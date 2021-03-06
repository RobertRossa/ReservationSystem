package com.example.reservationsystem.room;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer roomNumber;

    public Room(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Room() {
    }

}
