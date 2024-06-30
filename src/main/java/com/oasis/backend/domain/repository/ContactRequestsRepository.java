package com.oasis.backend.domain.repository;

import com.oasis.backend.domain.ContactRequests;

import java.util.List;
import java.util.Optional;

public interface ContactRequestsRepository {
    List<ContactRequests> getAllContactRequests();
    Optional<ContactRequests> getContactRequestById(int contactRequestId);
    ContactRequests saveContactRequests(ContactRequests contactRequests);
    void deleteContactRequestById(int contactRequestId);
}
