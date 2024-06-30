package com.oasis.backend.domain;

import java.time.LocalDateTime;
import java.util.List;

public class User {
    private int userid;
    private String name;
    private String email;
    private String password;
    private LocalDateTime registrationdate;

    private List<Reservation> reservations;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(LocalDateTime registrationdate) {
        this.registrationdate = registrationdate;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
