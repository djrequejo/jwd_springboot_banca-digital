package com.mitocode.javaweb.banca_digital.tarjeta.infraestructure.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mitocode.javaweb.banca_digital.cliente.domain.Cliente;
import com.mitocode.javaweb.banca_digital.shared.domain.SessionKeys;
import com.mitocode.javaweb.banca_digital.tarjeta.application.create.TarjetaCreateService;
import com.mitocode.javaweb.banca_digital.tarjeta.application.delete.TarjetaDeleteService;
import com.mitocode.javaweb.banca_digital.tarjeta.application.finder.TarjetaFinderService;
import com.mitocode.javaweb.banca_digital.tarjeta.application.update.TarjetaUpdateService;
import com.mitocode.javaweb.banca_digital.tarjeta.domain.Tarjeta;
import com.mitocode.javaweb.banca_digital.tarjeta.domain.TarjetaUpdateException;

import lombok.AllArgsConstructor;
import lombok.Data;

@Controller
@RequestMapping("/tarjetas")
public class TarjetaWebController {
	
	private static final Logger log = LoggerFactory.getLogger(TarjetaWebController.class);
	
	@Autowired
	private TarjetaCreateService tarjetaCreateService;
	
	@Autowired
	private TarjetaUpdateService tarjetaUpdateService;
	
	@Autowired
	private TarjetaDeleteService tarjetaDeleteService;
	
	@Autowired
	private TarjetaFinderService tarjetaFinderService;
	
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
	public String registrarTarjeta(
			@ModelAttribute("tarjetaNueva")
			@Valid
			Tarjeta tarjeta, 
			BindingResult binding,
			ModelMap model, 
			HttpSession session) {
		String resultPage = "";
		
		
		if(binding.hasErrors()) {
			resultPage = "tarjetas/tarjeta-nuevo";
			model.put("message", "Revise los campos ingresados");
		} else {
			Cliente cliente = (Cliente) session.getAttribute(SessionKeys.CLIENTE_LOGIN.getValue());
//			tarjeta.setCliente(cliente);
			tarjeta.setIdCliente(cliente.getId());
			
			Optional<Tarjeta> oTarjeta = tarjetaCreateService.registrarTarjeta(tarjeta);
			
			if(oTarjeta.isPresent()) {
				log.info(oTarjeta.get().toString());
				
				resultPage = "redirect:/resumen";
			} else {
				model.put("message", "No se pudo registrar");
				resultPage = "tarjetas/tarjeta-nuevo";
			}
		}
		
		return resultPage;
	}
	
	@GetMapping("/editar/{id}")
	public String editarTarjeta(@PathVariable("id") Integer idTarjeta, ModelMap model) {
		Optional<Tarjeta> oTarjeta = tarjetaFinderService.obtenerTarjeta(idTarjeta);
		
		oTarjeta.ifPresent(card -> model.put("tarjetaEditar", card));
		oTarjeta.ifPresent(card -> log.info(card.toString()));
		
		return "tarjetas/tarjeta-editar";
		
	}
	
	@PostMapping("/editar/{id}")
	public String actualizarTarjeta(
			@ModelAttribute("tarjetaEditar")
			@Valid
			Tarjeta tarjeta, 
			BindingResult binding,
			ModelMap model) {
		String resultPage = "";
		
		if(binding.hasErrors()) {
			resultPage = "tarjetas/tarjeta-editar";
			model.put("message", "Revise los campos ingresados");
		} else {
			Optional<Tarjeta> oTarjeta;
			
			try {
				oTarjeta = tarjetaUpdateService.actualizarTarjeta(tarjeta);
				
				if(oTarjeta.isPresent()) {
					log.info(oTarjeta.get().toString());
					
					resultPage = "redirect:/resumen";
				}
			} catch (TarjetaUpdateException e) {
				model.put("message", "No se pudo registrar");
				resultPage = "tarjetas/tarjeta-nuevo";
			}
		}
		
		return resultPage;
	}
	
	@PostMapping("/eliminar/{id}")
	@ResponseBody
	public ResponseEntity<EliminarResponse> eliminarTarjeta(@PathVariable("id") Integer idTarjeta, ModelMap model) {
		boolean resultado = tarjetaDeleteService.eliminarTarjeta(idTarjeta);
		ResponseEntity<EliminarResponse> response = null;
		
		if(resultado) {
			response = new ResponseEntity<>(new EliminarResponse("Se eliminó correctamente"), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(new EliminarResponse("No se elminó"), HttpStatus.EXPECTATION_FAILED);
		}
		
		return response;
	}
	
	@Data
	@AllArgsConstructor
	class EliminarResponse {
		private String message;
	}
}
