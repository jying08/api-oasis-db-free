package com.oasis.backend.domain.repository;

import com.oasis.backend.domain.AdditionalService;

import java.util.List;
import java.util.Optional;

public interface AdicionalServiceRepository {
    List<AdditionalService> getAllAdditionalServices();
    Optional<AdditionalService> getAdditionalServiceById(int id);
    AdditionalService saveAdditionalService(AdditionalService additionalService);
    void deleteAdditionalService(int additionalServiceId);
}
