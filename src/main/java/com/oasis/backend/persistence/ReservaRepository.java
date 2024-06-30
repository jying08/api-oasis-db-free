package com.oasis.backend.persistence;

import com.oasis.backend.domain.Reservation;
import com.oasis.backend.domain.repository.ReservationRepository;
import com.oasis.backend.persistence.crud.ReservasCrudRepository;
import com.oasis.backend.persistence.entity.Reserva;
import com.oasis.backend.persistence.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservaRepository implements ReservationRepository {

    @Autowired
    private ReservasCrudRepository reservasCrudRepository;

    @Autowired
    private ReservationMapper mapper;

    @Override
    public List<Reservation> getAllReservations() {
        List<Reserva> reservas=(List<Reserva>) reservasCrudRepository.findAll();
        return mapper.toReservations(reservas);
    }

    @Override
    public Optional<Reservation> getReservationById(int reservationId) {
        return reservasCrudRepository.findById(reservationId).map(reserva -> mapper.toReservation(reserva));
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        Reserva reserva=mapper.toReserva(reservation);
        return mapper.toReservation(reservasCrudRepository.save(reserva));
    }

    @Override
    public void deleteReservationById(int id) {
        reservasCrudRepository.deleteById(id);
    }
}
