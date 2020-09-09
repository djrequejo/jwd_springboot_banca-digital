package com.mitocode.javaweb.banca_digital.cliente.application;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.javaweb.banca_digital.cliente.domain.Cliente;
import com.mitocode.javaweb.banca_digital.cliente.infraestructure.mapper.ClienteMapper;

@Service
public class ClienteService implements IClienteService {
	
	@Autowired
	private ClienteMapper clienteMapper;

	@Override
	public Collection<Cliente> obtenerClientes() {
		return clienteMapper.findAll();
	}

	@Override
	public Cliente registrarCliente(Cliente cliente) {
		int rows = clienteMapper.insert(cliente);
		
		if(rows < 1) {
			// lanzar exception
		}
		
		return cliente;
	}

}
