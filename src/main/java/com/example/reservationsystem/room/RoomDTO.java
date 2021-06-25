package com.example.reservationsystem.room;

public class RoomDTO {
    private Integer roomNumber;
    private Boolean available;

    public RoomDTO(Integer roomNumber, Boolean available) {
        this.roomNumber = roomNumber;
        this.available = available;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
