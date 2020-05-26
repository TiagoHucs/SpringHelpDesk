package com.hucs.helpdesk.negocio.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository repository;


    @Autowired
    private PasswordEncoder encoder;

    public Usuario findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public void createOrUpdate(Usuario admin) {
        repository.save(admin);
    }

    public void cadastrar(Usuario usuario){
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        repository.save(usuario);
    }
}
