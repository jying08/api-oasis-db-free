package com.oasis.backend.domain.repository;

import com.oasis.backend.domain.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {

    List<Reservation> getAllReservations();
    Optional<Reservation> getReservationById(int id);
    Reservation saveReservation(Reservation reservation);
    void deleteReservationById(int id);
}
