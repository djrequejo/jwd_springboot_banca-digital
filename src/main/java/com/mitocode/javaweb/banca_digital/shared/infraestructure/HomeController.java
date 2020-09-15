package com.mitocode.javaweb.banca_digital.shared.infraestructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/welcome")
	@ResponseBody
	public String welcome() {
		return "Hola Coders";
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping(value = { "/login", "", "/" })
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String validarClave(@RequestParam String documento, @RequestParam String password, 
			ModelMap modelMap) {
		boolean result = false;
		
		log.info("documento:" + documento);
		log.info("password:" + password);
		
		if(result) {
			return "home";
		} else {
			modelMap.addAttribute("message", "Usuario incorrecto");
			return "login";
		}
	}
}

