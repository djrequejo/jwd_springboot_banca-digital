package com.mitocode.javaweb.banca_digital.cliente.domain;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {

	public List<Cliente> getAll();

	public Optional<Cliente> getById(Integer id);

	public Optional<Cliente> getByDocumento(String documento);

	public Cliente save(Cliente cliente);

	public boolean delete(Integer id);

	public Optional<Cliente> updateAll(Cliente cliente);

}
