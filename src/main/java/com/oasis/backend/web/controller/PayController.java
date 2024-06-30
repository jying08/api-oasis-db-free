package com.oasis.backend.web.controller;


import com.oasis.backend.domain.Pay;
import com.oasis.backend.domain.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private PayService payService;

    @GetMapping("/all")
    public ResponseEntity<List<Pay>> getAll()
    {
        return new ResponseEntity<>(payService.getAllPays(), HttpStatus.OK);
    }

    @GetMapping("/id/{payId}")
    public ResponseEntity<Pay> getPay(@PathVariable("payId") int payId)
    {
        return payService.getPayById(payId)
                .map(pay -> new ResponseEntity<>(pay,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Pay> save(@RequestBody Pay pay)
    {
        return new ResponseEntity<>(payService.savePay(pay),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int payId)
    {
        if (payService.deletePay(payId))
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
