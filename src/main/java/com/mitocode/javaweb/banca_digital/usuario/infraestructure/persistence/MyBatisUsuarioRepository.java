package com.mitocode.javaweb.banca_digital.usuario.infraestructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mitocode.javaweb.banca_digital.usuario.domain.Usuario;
import com.mitocode.javaweb.banca_digital.usuario.domain.UsuarioRepository;

@Repository
public class MyBatisUsuarioRepository implements UsuarioRepository {

	public MyBatisUsuarioMapper usuarioMapper;
	
	public MyBatisUsuarioRepository(MyBatisUsuarioMapper usuarioMapper) {
		this.usuarioMapper = usuarioMapper;
	}

	@Override
	public Optional<Usuario> getById(Integer id) {
		return Optional.ofNullable(usuarioMapper.findById(id));
	}

	@Override
	public Optional<Usuario> getByIdCliente(Integer idCliente) {
		return Optional.ofNullable(usuarioMapper.findByIdCliente(idCliente));
	}

	@Override
	public Optional<Usuario> getByIdAndClave(Integer id, String clave) {
		return Optional.ofNullable(usuarioMapper.findByIdAndClave(id, clave));
	}

	@Override
	public Optional<Usuario> save(Usuario usuario) {
		int row = usuarioMapper.insert(usuario);
		return row == 0 ? Optional.empty() : Optional.of(usuario);
	}

}
