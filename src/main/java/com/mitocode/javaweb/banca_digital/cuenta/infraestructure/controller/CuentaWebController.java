package com.mitocode.javaweb.banca_digital.cuenta.infraestructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cuentas")
public class CuentaWebController {

	@ModelAttribute("modulo")
	public String modulo() {
		return "cuentas";
	}
	
	@GetMapping(value = { "", "/" })
	public String home() {
		return "cuentas/cuentas";
	}
}
