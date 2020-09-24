package com.mitocode.javaweb.banca_digital.shared.infraestructure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.mitocode.javaweb.banca_digital.shared.domain.SessionKeys;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioSecuritylService usuarioSecuritylService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioSecuritylService).passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/css/**", "/img/**", "/js/**", "/webjars/**").permitAll()
			.antMatchers("/api/**", "/api-docs/**").permitAll()
		.anyRequest().authenticated()
		.and()
			.csrf().disable().headers().frameOptions().disable()
		.and()
			.formLogin()
				.loginPage("/login")
//				.defaultSuccessUrl("/home", true)
				.successHandler(authenticationSuccessHandler)
				.permitAll()
		.and()
			.logout()
				.deleteCookies("JESESSIONID")
				.addLogoutHandler(
						(request, response, authentication) -> {
							request.getSession().removeAttribute(SessionKeys.CLIENTE_LOGIN.getValue());
						})
				.permitAll();
	}
}
