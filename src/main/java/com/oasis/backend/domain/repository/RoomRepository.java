package com.oasis.backend.domain.repository;

import com.oasis.backend.domain.Room;

import java.util.List;
import java.util.Optional;

public interface RoomRepository {
    List<Room> getAllRoom();
    Optional<Room> getRoomById(int roomId);
    Room saveRoom(Room room);
    void deleteRoomById(int roomId);
}
