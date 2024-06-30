package com.oasis.backend.persistence;

import com.oasis.backend.domain.ContactRequests;
import com.oasis.backend.domain.repository.ContactRequestsRepository;
import com.oasis.backend.persistence.crud.SolicitudContactosCrudRepository;
import com.oasis.backend.persistence.entity.SolicitudContactos;
import com.oasis.backend.persistence.mapper.ContactRequestsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SolicitudContactosRepository implements ContactRequestsRepository {

    @Autowired
    private SolicitudContactosCrudRepository solicitudContactosCrudRepository;

    @Autowired
    private ContactRequestsMapper mapper;


    @Override
    public List<ContactRequests> getAllContactRequests() {
        List<SolicitudContactos> solicitudContactos=(List<SolicitudContactos>) solicitudContactosCrudRepository.findAll();
        return mapper.toContactsRequests(solicitudContactos);
    }

    @Override
    public Optional<ContactRequests> getContactRequestById(int contactRequestId) {
        return solicitudContactosCrudRepository.findById(contactRequestId).map(contact->mapper.toContactRequests(contact));
    }

    @Override
    public ContactRequests saveContactRequests(ContactRequests contactRequests) {
        SolicitudContactos solicitudContactos=mapper.toSolicitudContactos(contactRequests);

        return mapper.toContactRequests(solicitudContactosCrudRepository.save(solicitudContactos));
    }

    @Override
    public void deleteContactRequestById(int contactRequestId) {
        solicitudContactosCrudRepository.deleteById(contactRequestId);
    }
}
