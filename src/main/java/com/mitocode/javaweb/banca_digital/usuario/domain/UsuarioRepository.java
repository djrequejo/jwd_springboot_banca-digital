package com.mitocode.javaweb.banca_digital.usuario.domain;

import java.util.Optional;

public interface UsuarioRepository {

	public Optional<Usuario> getById(Integer id);
	
	public Optional<Usuario> getByIdCliente(Integer idCliente);

	public Optional<Usuario> getByIdAndClave(Integer idCliente, String clave);

}
