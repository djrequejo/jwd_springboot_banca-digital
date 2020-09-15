package com.mitocode.javaweb.banca_digital.cliente.application.finder;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mitocode.javaweb.banca_digital.cliente.domain.Cliente;
import com.mitocode.javaweb.banca_digital.cliente.domain.ClienteNotFoundException;
import com.mitocode.javaweb.banca_digital.cliente.domain.ClienteRepository;

@Service
public class ClienteFinderService {

	private ClienteRepository clienteRepository;

	public ClienteFinderService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Collection<Cliente> obtenerClientes() {
		return clienteRepository.getAll();
	}

	public Optional<Cliente> consultarPorDocumento(String documento) throws ClienteNotFoundException {
		return Optional.ofNullable(
				clienteRepository.getByDocumento(documento).orElseThrow(ClienteNotFoundException::new));
	}

}
