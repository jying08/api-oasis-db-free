package com.oasis.backend.domain.service;

import com.oasis.backend.domain.User;
import com.oasis.backend.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository usuarioRepository;

    public List<User> getAll(){
        return usuarioRepository.getAll();
    }

    public Optional<List<User>> getByEmail(String emailId){
        return usuarioRepository.getByEmail(emailId);
    }

    public Optional<User> getUser(int userId){
        return usuarioRepository.getUser(userId);
    }

    public User save(User user){
        return usuarioRepository.save(user);
    }

    public boolean delete(int userId){
        return getUser(userId).map(user -> {
            usuarioRepository.delete(userId);
            return true;
        }).orElse(false);
    }

}
