package com.oasis.backend.persistence;


import com.oasis.backend.domain.AdditionalService;
import com.oasis.backend.domain.repository.AdicionalServiceRepository;
import com.oasis.backend.persistence.crud.ServicioAdicionalesCrudRepository;
import com.oasis.backend.persistence.entity.ServicioAdicionales;
import com.oasis.backend.persistence.mapper.AdditionalServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ServiciosAdicionalRepository implements AdicionalServiceRepository {

    @Autowired
    public ServicioAdicionalesCrudRepository servicioAdicionalesCrudRepository;

    @Autowired
    public AdditionalServiceMapper mapper;

    @Override
    public List<AdditionalService> getAllAdditionalServices() {

        List<ServicioAdicionales> servicioAdicionales= (List<ServicioAdicionales>) servicioAdicionalesCrudRepository.findAll();
        return mapper.toAdditionalServices(servicioAdicionales);
    }

    @Override
    public Optional<AdditionalService> getAdditionalServiceById(int additionalServiceId) {
        return servicioAdicionalesCrudRepository.findById(additionalServiceId).map(servicioAdicionales -> mapper.toAdditionalService(servicioAdicionales));
    }

    @Override
    public AdditionalService saveAdditionalService(AdditionalService additionalService) {
        ServicioAdicionales servicioAdicionales = mapper.toServicioAdicionales(additionalService);
        return mapper.toAdditionalService(servicioAdicionalesCrudRepository.save(servicioAdicionales));
    }

    @Override
    public void deleteAdditionalService(int additionalServiceId) {
        servicioAdicionalesCrudRepository.deleteById(additionalServiceId);
    }
}
