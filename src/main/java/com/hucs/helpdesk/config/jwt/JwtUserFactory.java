package com.hucs.helpdesk.config.jwt;

import java.util.ArrayList;
import java.util.List;

import com.hucs.helpdesk.negocio.usuario.EProfile;
import com.hucs.helpdesk.negocio.usuario.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class JwtUserFactory {
	 private JwtUserFactory() {
	    }

	    public static JwtUser create(Usuario user) {
	        return new JwtUser(
	                user.getId(),
	                user.getEmail(),
	                user.getPassword(),
	                mapToGrantedAuthorities(user.getProfile())
	        );
	    }

	    private static List<GrantedAuthority> mapToGrantedAuthorities(EProfile profileEnum) {
	    		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 
	    		authorities.add(new SimpleGrantedAuthority(profileEnum.toString())); 
	    		return   authorities ;
	    }
}
