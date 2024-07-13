package com.oasis.backend.web.controller;


import com.oasis.backend.domain.Room;
import java.time.LocalDateTime;
import com.oasis.backend.domain.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/all")
    public ResponseEntity<List<Room>> getAllRooms()
    {
        return new ResponseEntity<>(roomService.getAllRoom(), HttpStatus.OK);
    }

    @GetMapping("/id/{roomId}")
    public ResponseEntity<Room> getRoom(@PathVariable("roomId") int roomId)
    {
        return roomService.getRoomById(roomId)
                .map(room -> new ResponseEntity<>(room,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<Room>> findHabitacionesDisponibles(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
                                                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin)
    {
        return new ResponseEntity<>(roomService.findHabitacionesDisponibles(fechaInicio,fechaFin), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Room> save(@RequestBody Room room)
    {
        return new ResponseEntity<>(roomService.saveRoom(room),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{roomId}")
    public ResponseEntity delete(@PathVariable("roomId") int roomId)
    {
       if (roomService.deleteRoomById(roomId))
       {
           return new ResponseEntity<>(HttpStatus.OK);
       }else
       {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }


}
