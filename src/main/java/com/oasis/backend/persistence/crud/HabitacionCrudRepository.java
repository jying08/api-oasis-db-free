package com.oasis.backend.persistence.crud;

import com.oasis.backend.persistence.entity.Habitacion;
import org.springframework.data.repository.CrudRepository;

public interface HabitacionCrudRepository extends CrudRepository<Habitacion,Integer> {
}
