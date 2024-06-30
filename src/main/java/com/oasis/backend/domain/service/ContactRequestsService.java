package com.oasis.backend.domain.service;


import com.oasis.backend.domain.ContactRequests;
import com.oasis.backend.domain.repository.ContactRequestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactRequestsService {

    @Autowired
    private ContactRequestsRepository contactRequestsRepository;

    public List<ContactRequests> getAllContactRequests() {
        return contactRequestsRepository.getAllContactRequests();
    }

    public Optional<ContactRequests> getContactRequestById(int contactRequestId) {
        return contactRequestsRepository.getContactRequestById(contactRequestId);
    }

    public ContactRequests saveContactRequests(ContactRequests contactRequests) {
        return contactRequestsRepository.saveContactRequests(contactRequests);
    }

    public boolean deleteContactRequestById(int contactRequestId) {
        return getContactRequestById(contactRequestId).map(contact -> {
            contactRequestsRepository.deleteContactRequestById(contactRequestId);
            return true;
        }).orElse(false);
    }
}
