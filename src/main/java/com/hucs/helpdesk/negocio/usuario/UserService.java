package com.hucs.helpdesk.negocio.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUsuarioRepository repository;

    public Usuario findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public void createOrUpdate(Usuario admin) {
        repository.save(admin);
    }
}
