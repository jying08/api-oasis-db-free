package com.oasis.backend.persistence;

import com.oasis.backend.domain.User;
import com.oasis.backend.domain.repository.UserRepository;
import com.oasis.backend.persistence.crud.UsuarioCrudRepository;
import com.oasis.backend.persistence.entity.Usuario;
import com.oasis.backend.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {
    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper mapper;


    @Override
    public List<User> getAll() {
        List<Usuario> usuarios =(List<Usuario>) usuarioCrudRepository.findAll();
        return mapper.toUsers(usuarios);
    }

    @Override
    public Optional<List<User>> getByEmail(String emailId) {
        List<Usuario> usuarios=usuarioCrudRepository.findAllByEmail(emailId);
        return Optional.of(mapper.toUsers(usuarios));
    }

    @Override
    public Optional<User> getUser(int userId) {

        return usuarioCrudRepository.findById(userId).map(usuario ->mapper.toUser(usuario));
    }

    @Override
    public User save(User user) {
        Usuario usuario=mapper.toUsuario(user);
        return mapper.toUser(usuarioCrudRepository.save(usuario));
    }

    @Override
    public void delete(int userId) {
        usuarioCrudRepository.deleteById(userId);
    }
}
