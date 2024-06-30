package com.oasis.backend.persistence.crud;

import com.oasis.backend.persistence.entity.Reserva;
import org.springframework.data.repository.CrudRepository;

public interface ReservasCrudRepository extends CrudRepository<Reserva,Integer> {
}
