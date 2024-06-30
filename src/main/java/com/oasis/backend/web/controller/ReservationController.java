package com.oasis.backend.web.controller;

import com.oasis.backend.domain.Reservation;
import com.oasis.backend.domain.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> findAll()
    {
        return new ResponseEntity<>(reservationService.getAllReservations(), HttpStatus.OK);
    }

    @GetMapping("/id/{reservationId}")
    public ResponseEntity<Reservation> getReservation(@PathVariable("reservationId") int reservationId)
    {
        return reservationService.getReservationById(reservationId)
                .map(reservation -> new ResponseEntity<>(reservation,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Reservation> save(@RequestBody Reservation reservation)
    {
        return new ResponseEntity<>(reservationService.saveReservation(reservation),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{reservationId}")
    public ResponseEntity delete(@PathVariable("reservationId") int reservationId)
    {
        if (reservationService.deleteReservationById(reservationId))
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
