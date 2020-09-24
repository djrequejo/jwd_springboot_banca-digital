package com.mitocode.javaweb.banca_digital.usuario.infraestructure.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.javaweb.banca_digital.usuario.domain.Usuario;

@SpringBootTest
@ContextConfiguration
@Transactional
public class JpaUsuarioRepositoryTest {

	private static final Logger log = LoggerFactory.getLogger(JpaUsuarioRepositoryTest.class);

	@Autowired
	private JpaUsuarioRepository jpaUsuarioRepository;
	
	@Test
	public void obtenerUsuarioPorId() {
		Optional<Usuario> oUsuario = jpaUsuarioRepository.getById(10);
		
		if (oUsuario.isPresent()) {
			log.info(oUsuario.get().toString());
		}
		
		assertNotNull(oUsuario.get());
	}
	
}
