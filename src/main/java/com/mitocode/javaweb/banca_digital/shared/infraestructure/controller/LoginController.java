package com.mitocode.javaweb.banca_digital.shared.infraestructure.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mitocode.javaweb.banca_digital.shared.application.login.LoginService;
import com.mitocode.javaweb.banca_digital.shared.domain.BadCredentialsEception;
import com.mitocode.javaweb.banca_digital.shared.domain.SessionKeys;
import com.mitocode.javaweb.banca_digital.shared.domain.UserNotFoundException;
import com.mitocode.javaweb.banca_digital.usuario.domain.Usuario;

@Controller
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;

	@GetMapping("/welcome")
	@ResponseBody
	public String welcome() {
		return "Hola Coders";
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping(value = { "/login", "", "/" })
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String validarClave(@RequestParam String documento, @RequestParam String password, 
			ModelMap modelMap, HttpSession session) {
		log.info("documento:" + documento);
		log.info("password:" + password);
		
		Usuario usuario;
		String resultPage = "";
		try {
			usuario = loginService.validarUsuarioClave(documento, password);
			
			log.debug(usuario.toString());
			
			session.setAttribute(SessionKeys.CLIENTE_LOGIN.getValue(), usuario.getCliente());
			
			resultPage = "home";
		} catch (UserNotFoundException | BadCredentialsEception e) {
			log.debug(e.toString());
			
			modelMap.addAttribute("message", "Usuario no existe o clave incorrecta");
			resultPage = "login";
		}
		
		return resultPage;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute(SessionKeys.CLIENTE_LOGIN.getValue());
		
		return "login";
	}
}

