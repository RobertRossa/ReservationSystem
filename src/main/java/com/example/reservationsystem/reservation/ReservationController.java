package com.example.reservationsystem.reservation;

import com.example.reservationsystem.room.Room;
import com.example.reservationsystem.room.RoomRepository;
import com.example.reservationsystem.user.User;
import com.example.reservationsystem.userRole.UserRole;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/all")
    public List<ReservationDTO> getAllReservation() {
        return reservationService.getAllReservations();
    }

    @PostMapping("/add")
    public void addReservation(@RequestBody ReservationDTO reservationDTO) {

        reservationService.addReservation(reservationDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable Integer id) {
        reservationService.deleteReservation(id);
    }

    @PutMapping("update/{id}")
    public void updateReservation(@RequestBody ReservationDTO reservationDTO, @PathVariable Integer id) {
        reservationService.updateReservation(id, reservationDTO);
    }

}
