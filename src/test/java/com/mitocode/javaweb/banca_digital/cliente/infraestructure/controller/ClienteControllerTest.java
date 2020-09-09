package com.mitocode.javaweb.banca_digital.cliente.infraestructure.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Collection;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.mitocode.javaweb.banca_digital.cliente.domain.Cliente;

@SpringBootTest
@ContextConfiguration
public class ClienteControllerTest {
	
	private static final Logger log = LoggerFactory.getLogger(ClienteControllerTest.class);

	@Autowired
	private ClienteController clienteController;

	@Test
	@Disabled
	public void validarSumaDeEnteros() {
		int a = 5;
		int b = 8;
		int resultado = 14;
		
		assertEquals(resultado, a + b);
	}
	
	@Test
	@DisplayName("Validar que se obtenga una lista de clientes")
	public void obtenerListaDeClientes() {
		Collection<Cliente> lista = clienteController.listarClientes();
		
		lista.forEach(cliente -> log.debug(cliente.toString()));
		
		assertEquals(false, lista.isEmpty());
		
	}
	
}
