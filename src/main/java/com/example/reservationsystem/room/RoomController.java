package com.example.reservationsystem.room;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/room")
    public List<RoomDTO> findRoomByDates(LocalDate startDate, LocalDate endDate) {
        //request param
        // hard data
        // jak jest - nie ma
        return List.of(new RoomDTO(1, true));
    }

    @GetMapping("/room-by-number")
    public ResponseEntity<RoomDTO> findRoomByNumber(@RequestParam("room-number") Integer roomNumber) {
        if (roomNumber == 1) {
            RoomDTO roomDTO = new RoomDTO(1,true);
            return ResponseEntity.ok(roomDTO);
        }
        return ResponseEntity.notFound().build();
    }

}
