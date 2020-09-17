package com.mitocode.javaweb.banca_digital.resumen.infraestructure.cotroller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mitocode.javaweb.banca_digital.cliente.application.finder.ClienteFinderService;
import com.mitocode.javaweb.banca_digital.cliente.domain.Cliente;
import com.mitocode.javaweb.banca_digital.shared.domain.SessionKeys;

@Controller
@RequestMapping("/resumen")
public class ResumenWebController {

	private static final Logger log = LoggerFactory.getLogger(ResumenWebController.class);

	@Autowired
	private ClienteFinderService clienteFinderService;
	
	@ModelAttribute("modulo")
	public String modulo() {
		return "resumen";
	}
	
	@GetMapping(value = { "", "/" })
	public String home(HttpSession session, ModelMap model) {
		Cliente clienteSesion = (Cliente) session.getAttribute(SessionKeys.CLIENTE_LOGIN.getValue());
		
		log.debug(clienteSesion.toString());
		
		clienteFinderService.consultarPorId(clienteSesion.getId())
					.ifPresent(cli -> model.addAttribute("cliente", cli));
		
		return "resumen/resumen";
	}
}
