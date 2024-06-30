package com.oasis.backend.persistence.mapper;


import com.oasis.backend.domain.ReservationAdditionalService;
import com.oasis.backend.persistence.entity.ReservasServicioAdicional;
import com.oasis.backend.persistence.entity.ReservasServicioAdicionalPK;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ReservationMapper.class})
public interface ReservationAdditionalServiceMapper {



    @Mappings({
            @Mapping(source = "id.idReserva" ,target = "reservationId"),
            @Mapping(source = "fecha", target = "date"),
    })
    ReservationAdditionalService toReservationAdditionalService(ReservasServicioAdicional reservasServicioAdicional);
    List<ReservationAdditionalService> toReservationAdditionalServices(List<ReservasServicioAdicional> reservasServicioAdicionales);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id.idServicioAdicional", ignore = true),
            @Mapping(target = "reserva", ignore = true),
            @Mapping(target = "servicioAdicionales", ignore = true),
    })
    ReservasServicioAdicional toReservasServicioAdicional(ReservationAdditionalService reservationAdditionalService);

    default ReservasServicioAdicional fromReservationAdditionalService(ReservationAdditionalService reservationAdditionalService) {
        if (reservationAdditionalService == null) {
            return null;
        }

        ReservasServicioAdicionalPK pk = new ReservasServicioAdicionalPK();
        pk.setIdReserva(reservationAdditionalService.getReservationId());

        ReservasServicioAdicional entity = new ReservasServicioAdicional();
        entity.setId(pk);
        entity.setFecha(reservationAdditionalService.getDate());

        return entity;
    }



}
