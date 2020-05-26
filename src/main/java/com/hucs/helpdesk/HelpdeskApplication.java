package com.hucs.helpdesk;

import com.hucs.helpdesk.negocio.usuario.EProfile;
import com.hucs.helpdesk.negocio.usuario.IUsuarioRepository;
import com.hucs.helpdesk.negocio.usuario.Usuario;
import com.hucs.helpdesk.negocio.usuario.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class HelpdeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@CrossOrigin
	@RequestMapping("/")
	String index() {
		return "index";
	}

	@Bean
	CommandLineRunner init(IUsuarioRepository userRepository, UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
		return args -> {
			//if("dev".equals(System.getProperty("spring.profiles.active"))){
			if(true){
				initUsers(userRepository,usuarioService, passwordEncoder);
			}
		};
	}

	private void initUsers(IUsuarioRepository userRepository, UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
		Usuario admin = new Usuario();
		admin.setEmail("usuario@gmail.com");
		admin.setPassword(passwordEncoder.encode("123456"));
		admin.setProfile(EProfile.ADMIN);

		Usuario find = userRepository.findByEmail("tiagohucs@gmail.com");
		if (find == null) {
			usuarioService.createOrUpdate(admin);
		}
	}


}
