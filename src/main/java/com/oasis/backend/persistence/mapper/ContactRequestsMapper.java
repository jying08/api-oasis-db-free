package com.oasis.backend.persistence.mapper;


import com.oasis.backend.domain.ContactRequests;
import com.oasis.backend.persistence.entity.SolicitudContactos;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactRequestsMapper {

    @Mappings({
            @Mapping(source = "idSolicitudes", target = "requestsId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "mensaje", target = "message"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "estado", target = "state"),
    })
    ContactRequests toContactRequests(SolicitudContactos solicitudContactos);
    List<ContactRequests> toContactsRequests(List<SolicitudContactos> solicitudContactos);

    @InheritInverseConfiguration
    SolicitudContactos toSolicitudContactos(ContactRequests contactRequests);

}
