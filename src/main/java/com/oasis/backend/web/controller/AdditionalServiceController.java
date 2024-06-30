package com.oasis.backend.web.controller;


import com.oasis.backend.domain.AdditionalService;
import com.oasis.backend.domain.service.AdditionalsServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/additional")
public class AdditionalServiceController {

    @Autowired
    private AdditionalsServicesService additionalsServicesService;

    @GetMapping("/all")
    public ResponseEntity<List<AdditionalService>> getAll()
    {
        return new ResponseEntity<>(additionalsServicesService.getAllAdditionalServices(), HttpStatus.OK);
    }

    @GetMapping("/id/{additonalId}")
    public ResponseEntity<AdditionalService> getAdditionalService( @PathVariable("additonalId") int id)
    {
        return additionalsServicesService.getAdditionalServiceById(id)
                .map(additionalService -> new ResponseEntity<>(additionalService,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<AdditionalService> save(@RequestBody AdditionalService additionalService)
    {
        return new ResponseEntity<>(additionalsServicesService.saveAdditionalService(additionalService),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int id)
    {
        if (additionalsServicesService.deleteContactRequestById(id))
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
