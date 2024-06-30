package com.oasis.backend.persistence.mapper;

import com.oasis.backend.domain.Reservation;
import com.oasis.backend.persistence.entity.Reserva;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mappings({
            @Mapping(source = "idReservas" ,target = "reservationId"),
            @Mapping(source = "fechaInicio" ,target = "startDate"),
            @Mapping(source = "fechaFin" ,target = "endDate"),
            @Mapping(source = "precioTotal" ,target = "totalPrice"),
            @Mapping(source = "estado" ,target = "state"),
            @Mapping(source = "confirmacion" ,target = "confirmation"),
            @Mapping(source = "usuarioId" ,target = "userId"),
            @Mapping(source = "habitacionId" ,target = "roomId"),
    })
    Reservation toReservation(Reserva reserva);
    List<Reservation> toReservations(List<Reserva> reservations);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "usuario" ,ignore = true),
            @Mapping(target = "habitacion" ,ignore = true),
            @Mapping(target = "pagos" ,ignore = true),
            @Mapping(target = "reservasConServiciosAdicionals" ,ignore = true),
    })
    Reserva toReserva(Reservation reservation);
}
