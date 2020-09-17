package com.mitocode.javaweb.banca_digital.operacion.infraestrucutre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/operaciones")
public class OperacionWebController {

	@ModelAttribute("modulo")
	public String modulo() {
		return "operaciones";
	}
	
	@GetMapping(value = { "", "/" })
	public String home() {
		return "operaciones/operaciones";
	}
}
