package com.mitocode.javaweb.banca_digital.cliente.application;

import java.util.Collection;

import com.mitocode.javaweb.banca_digital.cliente.domain.Cliente;

public interface IClienteService {

	public Collection<Cliente> obtenerClientes();
	
	public Cliente registrarCliente(Cliente cliente);
	
}
