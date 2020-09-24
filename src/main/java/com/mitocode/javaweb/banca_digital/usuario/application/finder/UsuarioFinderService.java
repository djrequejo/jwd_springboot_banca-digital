package com.mitocode.javaweb.banca_digital.usuario.application.finder;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mitocode.javaweb.banca_digital.usuario.domain.Usuario;
import com.mitocode.javaweb.banca_digital.usuario.domain.UsuarioRepository;

@Service
public class UsuarioFinderService {

	private UsuarioRepository usuarioRepository;

	public UsuarioFinderService(
			@Qualifier("myBatisUsuarioRepository")
			UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Optional<Usuario> obtenerUsuario(Integer id) {
		return usuarioRepository.getById(id);
	}

	public boolean validarClave(Usuario usuario) {
		return usuarioRepository.getByIdAndClave(usuario.getId(), usuario.getClave())
				.map(user -> true).orElse(false);
	}

}
