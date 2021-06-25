package com.example.reservationsystem.room;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findRoomByRoomNumber(Integer roomNumber);

}
