package com.oasis.backend.persistence.mapper;

import com.oasis.backend.domain.User;
import com.oasis.backend.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "idUsuario" ,target = "userid"),
            @Mapping(source = "nombre" ,target = "name"),
            @Mapping(source = "email" ,target = "email"),
            @Mapping(source = "password" ,target = "password"),
            @Mapping(source = "fechaRegistro" ,target = "registrationdate"),
    })
    User toUser(Usuario usuario);
    List<User> toUsers(List<Usuario> usuarios);

    @InheritInverseConfiguration
    @Mapping(target = "reservas", ignore = true)
    Usuario toUsuario(User user);


}
