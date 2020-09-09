package com.mitocode.javaweb.banca_digital.cliente.infraestructure.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mitocode.javaweb.banca_digital.cliente.application.IClienteService;
import com.mitocode.javaweb.banca_digital.cliente.domain.Cliente;

@Controller
public class ClienteController {

	@Autowired
	private IClienteService clienteListarService;
	
	public Collection<Cliente> listarClientes() {
		return clienteListarService.obtenerClientes();
	}
}
