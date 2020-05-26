package com.hucs.helpdesk.config.security;

import com.hucs.helpdesk.config.jwt.JwtAuthenticationEntryPoint;
import com.hucs.helpdesk.config.jwt.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//import com.hucs.security.jwt.JwtAuthenticationEntryPoint;
//import com.hucs.security.jwt.JwtAuthenticationTokenFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private Environment env;

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
		return new JwtAuthenticationTokenFilter();
	}

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers(
                        HttpMethod.GET,
                        "/",
						"/*.js",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css","/**/*.js",
						"/assets/*.*"
                ).permitAll()
				//.antMatchers("/rest/**").permitAll()//TODO: remover depois da impl segur
				.antMatchers("/fontawesome*").permitAll()
                .antMatchers("/rest/auth/**").permitAll()
				.antMatchers("/rest/refresh/**").permitAll()
				.antMatchers("/rest/usuario/cadastrar").permitAll()
				.antMatchers("/h2/**").permitAll()
                .anyRequest().authenticated();

        httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        // habilita frames para consuta h2 local
		//List<Object> profile = Arrays.asList(env.getActiveProfiles());
		//if (profile.get(0).equals("dev")) {
		if (true) {
			httpSecurity.headers().frameOptions().disable().cacheControl();
		} else {
			httpSecurity.headers().cacheControl();
		}

    }

/*	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("usuario")
				.password("123456")
				.roles("USUARIO");
	}*/


}
