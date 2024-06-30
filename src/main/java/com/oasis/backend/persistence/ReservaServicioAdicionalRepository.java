package com.oasis.backend.persistence;


import com.oasis.backend.domain.ReservationAdditionalService;
import com.oasis.backend.domain.repository.ReservationAditionalServiceRepository;
import com.oasis.backend.persistence.crud.ReservasServicioAdicionalCrudRepository;
import com.oasis.backend.persistence.entity.ReservasServicioAdicional;
import com.oasis.backend.persistence.mapper.ReservationAdditionalServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservaServicioAdicionalRepository implements ReservationAditionalServiceRepository {

    @Autowired
    private ReservasServicioAdicionalCrudRepository reservasServicioAdicionalCrudRepository;

    @Autowired
    private ReservationAdditionalServiceMapper mapper;

    @Override
    public List<ReservationAdditionalService> getAllReservationAdditionalServices() {
        List<ReservasServicioAdicional> reservasServicioAdicionals= (List<ReservasServicioAdicional>) reservasServicioAdicionalCrudRepository.findAll();
        return mapper.toReservationAdditionalServices(reservasServicioAdicionals);
    }

    @Override
    public Optional<ReservationAdditionalService> getByIdReservationAdditionalService(int reservationAdditionalServiceId) {
        return reservasServicioAdicionalCrudRepository.findById(reservationAdditionalServiceId).map(reservasServicioAdicional -> mapper.toReservationAdditionalService(reservasServicioAdicional));
    }

    @Override
    public ReservationAdditionalService saveReservationAdditionalService(ReservationAdditionalService reservationAdditionalService) {
        ReservasServicioAdicional reservasServicioAdicional= mapper.toReservasServicioAdicional(reservationAdditionalService);
        return mapper.toReservationAdditionalService(reservasServicioAdicionalCrudRepository.save(reservasServicioAdicional));
    }

    @Override
    public void deleteReservationAdditionalServiceById(int reservationAdditionalServiceId) {
        reservasServicioAdicionalCrudRepository.deleteById(reservationAdditionalServiceId);

    }
}
