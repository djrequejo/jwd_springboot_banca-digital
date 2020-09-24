package com.mitocode.javaweb.banca_digital.usuario.infraestructure.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mitocode.javaweb.banca_digital.usuario.domain.Usuario;
import com.mitocode.javaweb.banca_digital.usuario.domain.UsuarioRepository;

@Repository
public class JpaUsuarioRepository implements UsuarioRepository {

	@Autowired
	private JpaUsuarioCrudRepository crudRepository;
	
//	@Autowired
	private UsuarioEntityMapper mapper;
	
	@Override
	public Optional<Usuario> save(Usuario usuario) {
		return null;
	}

	@Override
	public Optional<Usuario> getById(Integer id) {
		Optional<UsuarioEntity> entity = crudRepository.findById(id);
		return entity.map(usuarioEntty -> mapper.toUsuario(usuarioEntty));
	}

	@Override
	public Optional<Usuario> getByIdCliente(Integer idCliente) {
		return null;
	}

	@Override
	public Optional<Usuario> getByIdAndClave(Integer idCliente, String clave) {
		return null;
	}

}
