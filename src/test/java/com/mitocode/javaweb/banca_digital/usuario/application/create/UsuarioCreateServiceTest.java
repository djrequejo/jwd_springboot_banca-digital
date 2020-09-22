package com.mitocode.javaweb.banca_digital.usuario.application.create;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.javaweb.banca_digital.usuario.domain.Usuario;

@SpringBootTest
@ContextConfiguration
@Transactional
public class UsuarioCreateServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioCreateServiceTest.class);
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioCreateService usuarioCreateService;
	
	@Test
	@Commit
	public void crearUsuario() {
		Usuario usuario = new Usuario(1, passwordEncoder.encode("1111"));
		
		Optional<Usuario> oUsuario =  usuarioCreateService.crearUsuario(usuario);
		
		oUsuario.ifPresent(user -> log.info(user.toString()));
		
		assertNotNull(oUsuario.get());
	}
}
