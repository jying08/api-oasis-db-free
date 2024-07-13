package com.oasis.backend.persistence;

import com.oasis.backend.domain.Room;
import com.oasis.backend.domain.repository.RoomRepository;
import com.oasis.backend.persistence.crud.HabitacionCrudRepository;
import com.oasis.backend.persistence.entity.Habitacion;
import com.oasis.backend.persistence.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class HabitacionRepository implements RoomRepository {

    @Autowired
    private HabitacionCrudRepository habitacionCrudRepository;

    @Autowired
    private RoomMapper mapper;

    @Override
    public List<Room> getAllRoom() {
        List<Habitacion> habitaciones = (List<Habitacion>) habitacionCrudRepository.findAll();
        return mapper.toRooms(habitaciones);
    }

    @Override
    public Optional<Room> getRoomById(int roomId) {
        return habitacionCrudRepository.findById(roomId).map(habitacion ->mapper.toRoom(habitacion));
    }

    @Override
    public Room saveRoom(Room room) {
        Habitacion habitacion = mapper.toHabitacion(room);

        return mapper.toRoom(habitacionCrudRepository.save(habitacion));
    }

    @Override
    public void deleteRoomById(int roomId) {
        habitacionCrudRepository.deleteById(roomId);

    }

    @Override
    public List<Room> findHabitacionesDisponibles(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        List<Habitacion> habitaciones = habitacionCrudRepository.findHabitacionesDisponibles(fechaInicio,fechaFin);
        return mapper.toRooms(habitaciones);
    }
}
