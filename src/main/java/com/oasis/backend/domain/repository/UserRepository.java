package com.oasis.backend.domain.repository;

import com.oasis.backend.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAll();
    Optional<List<User>> getByEmail(String emailId);
    Optional<User> getUser(int userId);
    User save(User user);
    void delete(int userId);
}
