package com.oasis.backend.domain.service;

import com.oasis.backend.domain.ReservationAdditionalService;
import com.oasis.backend.domain.repository.ReservationAditionalServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationAdditionalServicesService {

    @Autowired
    private ReservationAditionalServiceRepository reservationAditionalServiceRepository;

    public List<ReservationAdditionalService> getAllReservationAdditionalServices()
    {
        return reservationAditionalServiceRepository.getAllReservationAdditionalServices();
    }

    public Optional<ReservationAdditionalService> getByIdReservationAdditionalService(int reservationAdditionalServiceId)
    {
        return reservationAditionalServiceRepository.getByIdReservationAdditionalService(reservationAdditionalServiceId);
    }

    public ReservationAdditionalService saveReservationAdditionalService(ReservationAdditionalService reservationAdditionalService)
    {
     return reservationAditionalServiceRepository.saveReservationAdditionalService(reservationAdditionalService);
    }

    public boolean deleteReservationAdditionalServiceById(int id)
    {
        return getByIdReservationAdditionalService(id).map(reservaA -> {
            reservationAditionalServiceRepository.deleteReservationAdditionalServiceById(id);
            return true;
        }).orElse(false);
    }

}
