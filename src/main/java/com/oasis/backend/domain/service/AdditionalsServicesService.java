package com.oasis.backend.domain.service;


import com.oasis.backend.domain.AdditionalService;
import com.oasis.backend.domain.repository.AdicionalServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdditionalsServicesService {

    @Autowired
    private AdicionalServiceRepository adicionalServiceRepository;

    public List<AdditionalService> getAllAdditionalServices()
    {
        return adicionalServiceRepository.getAllAdditionalServices();
    }

    public Optional<AdditionalService> getAdditionalServiceById(int additionalServiceId)
    {
        return adicionalServiceRepository.getAdditionalServiceById(additionalServiceId);
    }

    public AdditionalService saveAdditionalService(AdditionalService additionalService)
    {
        return adicionalServiceRepository.saveAdditionalService(additionalService);
    }

    public boolean deleteContactRequestById(int additionalServiceId)
    {
        return getAdditionalServiceById(additionalServiceId).map(additionalService -> {
            adicionalServiceRepository.deleteAdditionalService(additionalServiceId);
            return true;
        }).orElse(false);
    }

}
