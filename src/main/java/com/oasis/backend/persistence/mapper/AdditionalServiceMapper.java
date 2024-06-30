package com.oasis.backend.persistence.mapper;


import com.oasis.backend.domain.AdditionalService;
import com.oasis.backend.persistence.entity.ServicioAdicionales;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdditionalServiceMapper {


    @Mappings(value = {
            @Mapping(source = "idServicio" ,target = "additionalServiceId"),
            @Mapping(source = "descripcion" ,target = "description"),
            @Mapping(source = "precio" ,target = "price"),
    })
    AdditionalService toAdditionalService(ServicioAdicionales servicioAdicionales);
    List<AdditionalService> toAdditionalServices(List<ServicioAdicionales> servicioAdicionales);

    @InheritInverseConfiguration
    @Mapping(target = "reservasConServicioAdicional", ignore = true)
    ServicioAdicionales toServicioAdicionales(AdditionalService additionalService);
}
