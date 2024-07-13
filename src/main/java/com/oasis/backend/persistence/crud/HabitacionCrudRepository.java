package com.oasis.backend.persistence.crud;

import com.oasis.backend.persistence.entity.Habitacion;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface HabitacionCrudRepository extends CrudRepository<Habitacion,Integer> {

    @Query("SELECT h FROM Habitacion h WHERE NOT EXISTS (SELECT r FROM Reserva r WHERE r.habitacionId = h.idHabitacion AND (r.fechaInicio <= :fechaFin AND r.fechaFin >= :fechaInicio))")
    List<Habitacion> findHabitacionesDisponibles(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);
}
