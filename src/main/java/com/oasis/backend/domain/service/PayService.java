package com.oasis.backend.domain.service;

import com.oasis.backend.domain.Pay;
import com.oasis.backend.domain.repository.PayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayService {

    @Autowired
    private PayRepository payRepository;

    public List<Pay> getAllPays()
    {
        return payRepository.getAllPays();
    }

    public Optional<Pay> getPayById(int payId)
    {
        return payRepository.getPayById(payId);
    }
    public Pay savePay(Pay pay)
    {
        return payRepository.savePay(pay);
    }

    public boolean deletePay(int payId)
    {
        return getPayById(payId).map(pay -> {
            payRepository.deletePay(payId);
            return true;
        }).orElse(false);
    }
}
