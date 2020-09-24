package com.mitocode.javaweb.banca_digital.usuario.infraestructure.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ContextConfiguration
@Transactional
public class JpaUsuarioCrudRepositoryTest {
	
	private static final Logger log = LoggerFactory.getLogger(JpaUsuarioCrudRepositoryTest.class);

	@Autowired
	private JpaUsuarioCrudRepository crudRepository;
	
	@Test
	public void consultarUsuarios() {
		List<UsuarioEntity> entities = (List<UsuarioEntity>) crudRepository.findAll();
		
		entities.forEach(usuario -> {
			log.info(usuario.toString());
			log.info(usuario.getCliente().toString());
			log.info(usuario.getCliente().getTarjetas().toString());
			log.info("======");
		});
		
		assertNotNull(entities);
	}
	
	@Test
	public void consultarUsuarioPorIdCliente() {
		Optional<UsuarioEntity> oUsuario = crudRepository.findByIdCliente(1);
		
		oUsuario.ifPresent(usuario -> {
			log.info(usuario.toString());
			log.info(usuario.getCliente().toString());
			log.info(usuario.getCliente().getTarjetas().toString());
		});
		
		assertNotNull(oUsuario);
	}
	
	@Test
	public void consultarUsuarioPorQuery() {
		Optional<UsuarioEntity> oUsuario = crudRepository.findByCampoPersonalizado(13, "11%");
		
		oUsuario.ifPresent(usuario -> {
			log.info(usuario.toString());
			log.info(usuario.getCliente().toString());
			log.info(usuario.getCliente().getTarjetas().toString());
		});
		
		assertNotNull(oUsuario.get());
	}
	
}

