package com.mitocode.javaweb.banca_digital.cliente.application.create;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.javaweb.banca_digital.cliente.domain.Cliente;

@SpringBootTest
@ContextConfiguration
@Transactional
public class ClienteCreateServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(ClienteCreateServiceTest.class);
	
	@Autowired
	private ClienteCreateService clienteCreateService;
	
	@Test
//	@Commit
	public void registrarCliente() {
		Cliente cliente = new Cliente("José Altamirano", "12398746", LocalDate.of(1995, 1, 23));
		
		Cliente clienteRegistrado = clienteCreateService.registrarCliente(cliente);
		
		log.debug("Cliente Nuevo: " + clienteRegistrado.toString());
		
		assertNotNull(clienteRegistrado.getId());
	}
}
