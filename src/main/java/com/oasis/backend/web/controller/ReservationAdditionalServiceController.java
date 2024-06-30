package com.oasis.backend.web.controller;

import com.oasis.backend.domain.ReservationAdditionalService;
import com.oasis.backend.domain.service.ReservationAdditionalServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservationAS")
public class ReservationAdditionalServiceController {

    @Autowired
    private ReservationAdditionalServicesService reservationAdditionalServicesService;

    @GetMapping("/all")
    public ResponseEntity<List<ReservationAdditionalService>> getAll()
    {
        return new ResponseEntity<>(reservationAdditionalServicesService.getAllReservationAdditionalServices(), HttpStatus.OK);
    }

    @GetMapping("/id/{reservationASId}")
    public ResponseEntity<ReservationAdditionalService> getReservationAS(@PathVariable("reservationASId") int id)
    {
        return reservationAdditionalServicesService.getByIdReservationAdditionalService(id)
                .map(reservationAdditionalService -> new ResponseEntity<>(reservationAdditionalService,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<ReservationAdditionalService> save(ReservationAdditionalService reservationAdditionalService)
    {
        return new ResponseEntity<>(reservationAdditionalServicesService.saveReservationAdditionalService(reservationAdditionalService),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int reservationASId)
    {
        if (reservationAdditionalServicesService.deleteReservationAdditionalServiceById(reservationASId))
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
