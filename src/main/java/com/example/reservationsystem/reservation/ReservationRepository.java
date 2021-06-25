package com.example.reservationsystem.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
