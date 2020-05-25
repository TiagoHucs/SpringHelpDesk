package com.hucs.helpdesk.config.jwt;

import com.hucs.helpdesk.negocio.usuario.UserService;
import com.hucs.helpdesk.negocio.usuario.Usuario;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Usuario usuario = userService.findByEmail(email);
        if(usuario == null){
            throw new UsernameNotFoundException(String.format("Nenhum usuario com email '%s'",email));
        } else {
            return JwtUserFactory.create(usuario);
        }
    }

}
