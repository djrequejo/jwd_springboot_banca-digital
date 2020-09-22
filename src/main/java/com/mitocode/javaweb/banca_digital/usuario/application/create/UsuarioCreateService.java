package com.mitocode.javaweb.banca_digital.usuario.application.create;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mitocode.javaweb.banca_digital.usuario.domain.Usuario;
import com.mitocode.javaweb.banca_digital.usuario.domain.UsuarioRepository;

@Service
public class UsuarioCreateService {

	private UsuarioRepository usuarioRepository;

	public UsuarioCreateService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Optional<Usuario> crearUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
