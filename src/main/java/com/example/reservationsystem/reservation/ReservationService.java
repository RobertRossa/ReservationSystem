package com.example.reservationsystem.reservation;

import com.example.reservationsystem.authentication.AuthenticationFacade;
import com.example.reservationsystem.room.Room;
import com.example.reservationsystem.room.RoomRepository;
import com.example.reservationsystem.user.User;
import com.example.reservationsystem.user.UserDTO;
import com.example.reservationsystem.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;
    private UserRepository userRepository;
    private RoomRepository roomRepository;
    private AuthenticationFacade authenticationFacade;

    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }

    public List<ReservationDTO> getAllReservations() {
        return reservationRepository
                .findAll()
                .stream()
                .map(this::convertToReservationDTO)
                .collect(Collectors.toList());
    }


    private ReservationDTO convertToReservationDTO(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setStartDate(reservation.getStartDate());
        reservationDTO.setEndDate(reservation.getEndDate());
        reservationDTO.setClientPhoneNumber(reservation.getClientPhoneNumber());
        return reservationDTO;
    }
    private Reservation convertReservationDTOtoReservation(ReservationDTO reservationDTO) {
        Reservation newReservation = new Reservation();
        newReservation.setStartDate(reservationDTO.getStartDate());
        newReservation.setEndDate(reservationDTO.getEndDate());
        newReservation.setClientPhoneNumber(reservationDTO.getClientPhoneNumber());
        Room room = roomRepository.findRoomByRoomNumber(reservationDTO.getRoomNumber());
        newReservation.setRoom(room);
        //pokoj
        // client
        return newReservation;
    }

    private User logInUserData() {
        String loginUsername = authenticationFacade.getAuthentication().getName();
        return userRepository.findByEmail(loginUsername);
    }

    public void addReservation(ReservationDTO reservationDTO) {

        Room room = roomRepository.findRoomByRoomNumber(reservationDTO.getRoomNumber());
        if (room == null) {
            throw new IllegalArgumentException("pokoj o numerze " + reservationDTO.getRoomNumber() + " nie istnieje");
        }

        User user = userRepository.findByEmail(reservationDTO.getEmail());
        if (user == null) {
            throw new IllegalArgumentException("user o podanym email " + reservationDTO.getEmail() + " nie istnieje");
        }
        // rozszeryc resDTO o pole boolean, ktore daje info - create user "chcę utworzyć konto" - checkbox
        // if user = null -> if -> reservationDTO
        Reservation reservation = new Reservation();
        reservation.setStartDate(reservationDTO.getStartDate());
        reservation.setEndDate(reservationDTO.getEndDate());
        reservation.setStatus("payed");
        reservation.setClientPhoneNumber(reservationDTO.getClientPhoneNumber());

        reservation.setRoom(room);

        reservation.setUser(user);

        reservationRepository.save(reservation);
    }

    public void deleteReservation(Integer id) {
        getReservationById(id);
        reservationRepository.deleteById(id);
    }


    public void updateReservation(Integer id, ReservationDTO reservationDTO) {
        Reservation uptadatedReservation = getReservationById(id);
        uptadatedReservation.setStartDate(reservationDTO.getStartDate());
        uptadatedReservation.setEndDate(reservationDTO.getEndDate());

        Room room = roomRepository.findRoomByRoomNumber(reservationDTO.getRoomNumber());
        uptadatedReservation.setRoom(room);


        reservationRepository.save(uptadatedReservation);
    }

    private Reservation getReservationById(Integer id) {
        return reservationRepository.getById(id);
    }


}
