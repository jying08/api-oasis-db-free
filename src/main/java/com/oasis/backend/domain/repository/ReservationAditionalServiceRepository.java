package com.oasis.backend.domain.repository;

import com.oasis.backend.domain.ReservationAdditionalService;

import java.util.List;
import java.util.Optional;

public interface ReservationAditionalServiceRepository {
    List<ReservationAdditionalService> getAllReservationAdditionalServices();
    Optional<ReservationAdditionalService> getByIdReservationAdditionalService(int reservationAdditionalServiceId);
    ReservationAdditionalService saveReservationAdditionalService(ReservationAdditionalService reservationAdditionalService);
    void deleteReservationAdditionalServiceById(int reservationAdditionalServiceId);

}
