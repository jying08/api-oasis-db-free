package com.oasis.backend.domain.service;

import com.oasis.backend.domain.Room;
import com.oasis.backend.domain.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRoom()
    {
        return roomRepository.getAllRoom();
    }

    public Optional<Room> getRoomById(int roomId)
    {
        return roomRepository.getRoomById(roomId);
    }

    public Room saveRoom(Room room)
    {
        return roomRepository.saveRoom(room);
    }

    public boolean deleteRoomById(int roomId)
    {
        return getRoomById(roomId).map(room -> {
            roomRepository.deleteRoomById(roomId);
            return true;
        }).orElse(false);
    }
    public List<Room> findHabitacionesDisponibles(LocalDateTime fechaInicio, LocalDateTime fechaFin)
    {
        return roomRepository.findHabitacionesDisponibles(fechaInicio,fechaFin);
    }

}
