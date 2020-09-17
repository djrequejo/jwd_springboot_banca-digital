package com.mitocode.javaweb.banca_digital.tarjeta.infraestructure.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mitocode.javaweb.banca_digital.tarjeta.domain.Tarjeta;

@Controller
@RequestMapping("/tarjetas")
public class TarjetaWebController {
	
	private static final Logger log = LoggerFactory.getLogger(TarjetaWebController.class);
	
	@ModelAttribute("modulo")
	public String modulo() {
		return "tarjetas";
	}

	@GetMapping(value = { "", "/" })
	public String home() {
		return "tarjetas/tarjetas";
	}
	
	@GetMapping("/nuevo")
	public String nuevaTarjeta(ModelMap model) {
		
		model.put("tarjetaNueva", new Tarjeta());
		
		return "tarjetas/tarjeta-nuevo";
	}
	
	@PostMapping("/registrar")
	public String registrarTarjeta(@ModelAttribute("tarjetaNueva") Tarjeta tarjeta, ModelMap model) {
		String resultPage = "";
		
		boolean resultInsert = true;
		
		log.debug(tarjeta.toString());
		
		if(resultInsert) {
			resultPage = "redirect:/resumen";
		} else {
			model.put("message", "No se pudo registrar");
			resultPage = "tarjetas/tarjeta-nuevo";
		}
		
		return resultPage;
	}
}
