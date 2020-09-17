package com.mitocode.javaweb.banca_digital.cliente.infraestructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mitocode.javaweb.banca_digital.cliente.domain.Cliente;
import com.mitocode.javaweb.banca_digital.cliente.domain.ClienteRepository;

@Repository
public class MyBatisClienteRepository implements ClienteRepository {

	private MyBatisClienteMapper clienteMapper;
	
	public MyBatisClienteRepository(MyBatisClienteMapper clienteMapper) {
		this.clienteMapper = clienteMapper;
	}

	@Override
	public List<Cliente> getAll() {
		return clienteMapper.findAll();
	}

	@Override
	public Optional<Cliente> getById(Integer id) {
		return Optional.ofNullable(clienteMapper.findById(id));
	}

	@Override
	public Optional<Cliente> getByDocumento(String documento) {
		return Optional.ofNullable(clienteMapper.findByDocumento(documento));
	}

	@Override
	public Cliente save(Cliente cliente) {
		int row = clienteMapper.insert(cliente);
		return row == 0 ? null : cliente;
	}

	@Override
	public boolean delete(Integer id) {
		int row = clienteMapper.delete(id);
		return row == 0 ? false : true;
	}

	@Override
	public Optional<Cliente> updateAll(Cliente cliente) {
		int row = clienteMapper.update(cliente);
		return row == 0 ? Optional.empty() : Optional.of(cliente);
	}
}
