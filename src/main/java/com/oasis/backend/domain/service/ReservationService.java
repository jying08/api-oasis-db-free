package com.oasis.backend.domain.service;

import com.oasis.backend.domain.Reservation;
import com.oasis.backend.domain.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations()
    {
        return reservationRepository.getAllReservations();
    }

    public Optional<Reservation> getReservationById(int id)
    {
        return reservationRepository.getReservationById(id);
    }

    public Reservation saveReservation(Reservation reservation)
    {
        return reservationRepository.saveReservation(reservation);
    }

    public boolean deleteReservationById(int id)
    {
        return getReservationById(id).map(reservation -> {
            reservationRepository.deleteReservationById(id);
            return true;
        }).orElse(false);
    }


}
