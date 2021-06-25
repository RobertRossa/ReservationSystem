package com.example.reservationsystem.reservation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.time.LocalDate;

//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ReservationDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private String clientPhoneNumber;
    private String email;
    private Integer roomNumber;


    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }




}
