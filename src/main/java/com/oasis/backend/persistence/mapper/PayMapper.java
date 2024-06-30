package com.oasis.backend.persistence.mapper;

import com.oasis.backend.domain.Pay;
import com.oasis.backend.persistence.entity.Pago;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PayMapper {


    @Mappings({
            @Mapping(source = "idPagos" ,target = "payId"),
            @Mapping(source = "fechaPago" ,target = "paymentDate"),
            @Mapping(source = "monto" ,target = "amount"),
            @Mapping(source = "metodoPago" ,target = "paymentMethod"),
            @Mapping(source = "reservaId" ,target = "reservationId"),
    })
    Pay toPay(Pago pago);
    List<Pay> toPayList(List<Pago> pagos);

    @InheritInverseConfiguration
    @Mapping(target = "reserva", ignore = true)
    Pago toPago(Pay pay);



}
