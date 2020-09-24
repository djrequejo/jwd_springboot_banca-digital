package com.mitocode.javaweb.banca_digital.shared.infraestructure.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.mitocode.javaweb.banca_digital.cliente.application.finder.ClienteFinderService;
import com.mitocode.javaweb.banca_digital.cliente.domain.Cliente;
import com.mitocode.javaweb.banca_digital.cliente.domain.ClienteNotFoundException;
import com.mitocode.javaweb.banca_digital.shared.domain.SessionKeys;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Autowired
	private ClienteFinderService clienteFinderService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String username = ((User) authentication.getPrincipal()).getUsername();
		String defaultPage = "/error";
		
		Optional<Cliente> oCliente;
		try {
			oCliente = clienteFinderService.consultarPorDocumento(username);
			if(oCliente.isPresent()) {
				request.getSession().setAttribute(SessionKeys.CLIENTE_LOGIN.getValue(), oCliente.get());
				defaultPage = "/home";
			}
		} catch (ClienteNotFoundException e) {
			
		}
		
		new DefaultRedirectStrategy().sendRedirect(request, response, defaultPage);
		
		
	}

}
