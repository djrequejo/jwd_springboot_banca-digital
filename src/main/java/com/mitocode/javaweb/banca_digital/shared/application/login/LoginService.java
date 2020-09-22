package com.mitocode.javaweb.banca_digital.shared.application.login;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mitocode.javaweb.banca_digital.cliente.domain.Cliente;
import com.mitocode.javaweb.banca_digital.cliente.domain.ClienteRepository;
import com.mitocode.javaweb.banca_digital.shared.domain.BadCredentialsEception;
import com.mitocode.javaweb.banca_digital.shared.domain.UserNotFoundException;
import com.mitocode.javaweb.banca_digital.usuario.domain.Usuario;
import com.mitocode.javaweb.banca_digital.usuario.domain.UsuarioRepository;

@Service
public class LoginService {

	private UsuarioRepository usuarioRepository;

	private ClienteRepository clienteRepository;

	public LoginService(UsuarioRepository usuarioRepository, ClienteRepository clienteRepository) {
		this.usuarioRepository = usuarioRepository;
		this.clienteRepository = clienteRepository;
	}
	
	public Usuario validarUsuario(String usuario) throws UserNotFoundException {
		Usuario usuarioLogin = null;

		Optional<Cliente> oCliente = clienteRepository.getByDocumento(usuario);

		if (oCliente.isPresent()) {
			usuarioLogin = usuarioRepository.getByIdCliente(oCliente.get().getId()).get();
			usuarioLogin.setCliente(oCliente.get());
		} else {
			throw new UserNotFoundException();
		}

		return usuarioLogin;
	}


	public Usuario validarUsuarioClave(String usuario, String clave)
			throws UserNotFoundException, BadCredentialsEception {
		Usuario usuarioLogin = null;

		Optional<Cliente> oCliente = clienteRepository.getByDocumento(usuario);

		if (oCliente.isPresent()) {
			usuarioLogin = usuarioRepository.getByIdAndClave(oCliente.get().getId(), clave)
					.orElseThrow(BadCredentialsEception::new);
			usuarioLogin.setCliente(oCliente.get());
		} else {
			throw new UserNotFoundException();
		}

		return usuarioLogin;
	}

}
