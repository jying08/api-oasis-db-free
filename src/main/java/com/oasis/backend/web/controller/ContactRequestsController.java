package com.oasis.backend.web.controller;


import com.oasis.backend.domain.ContactRequests;
import com.oasis.backend.domain.service.ContactRequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/contact")
public class ContactRequestsController {

    @Autowired
    private ContactRequestsService contactRequestsService;

    @GetMapping("/all")
    public ResponseEntity<List<ContactRequests>> getAll()
    {
        return new ResponseEntity<>(contactRequestsService.getAllContactRequests(), HttpStatus.OK);
    }

    @GetMapping("/id/{contactId}")
    public ResponseEntity<ContactRequests> getContact(@PathVariable("contactId") int contacId)
    {
        return contactRequestsService.getContactRequestById(contacId)
                .map(contact -> new ResponseEntity<>(contact,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<ContactRequests> save(@RequestBody ContactRequests contactRequests)
    {
        return new ResponseEntity<>(contactRequestsService.saveContactRequests(contactRequests),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int contactId)
    {
        if (contactRequestsService.deleteContactRequestById(contactId))
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
