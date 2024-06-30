package com.oasis.backend.persistence.crud;

import com.oasis.backend.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario,Integer> {

    List<Usuario> findAllByEmail(String email);


}
