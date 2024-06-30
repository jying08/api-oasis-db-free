package com.oasis.backend.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Reservation {
    private int reservationId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int totalPrice;
    private String state;
    private Boolean confirmation;

    private int userId;
    private int roomId;

    private User user;
    private Room room;
    private List<Pay> payments;
    private List<ReservationAdditionalService> reservationAdditionalServices;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Pay> getPayments() {
        return payments;
    }

    public void setPayments(List<Pay> payments) {
        this.payments = payments;
    }

    public List<ReservationAdditionalService> getReservationAdditionalServices() {
        return reservationAdditionalServices;
    }

    public void setReservationAdditionalServices(List<ReservationAdditionalService> reservationAdditionalServices) {
        this.reservationAdditionalServices = reservationAdditionalServices;
    }
}
