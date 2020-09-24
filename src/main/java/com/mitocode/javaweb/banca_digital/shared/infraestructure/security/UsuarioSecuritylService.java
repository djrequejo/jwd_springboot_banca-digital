package com.mitocode.javaweb.banca_digital.shared.infraestructure.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mitocode.javaweb.banca_digital.shared.application.login.LoginService;
import com.mitocode.javaweb.banca_digital.shared.domain.UserNotFoundException;
import com.mitocode.javaweb.banca_digital.usuario.domain.Usuario;

@Service
public class UsuarioSecuritylService implements UserDetailsService {
	
	@Autowired
	private LoginService loginService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		
		try {
			Usuario usuario = loginService.validarUsuario(username);
			
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			
			userDetails = new User(usuario.getCliente().getDocumento(), usuario.getClave(), authorities);
		} catch (UserNotFoundException e) {
			
		}

		return userDetails;
	}

}
