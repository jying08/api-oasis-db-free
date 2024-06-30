package com.oasis.backend.domain.repository;

import com.oasis.backend.domain.Pay;

import java.util.List;
import java.util.Optional;

public interface PayRepository {
    List<Pay> getAllPays();
    Optional<Pay> getPayById(int payId);
    Pay savePay(Pay pay);
    void deletePay(int payId);
}
