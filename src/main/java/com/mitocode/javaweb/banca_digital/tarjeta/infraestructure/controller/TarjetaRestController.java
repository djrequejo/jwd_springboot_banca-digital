package com.mitocode.javaweb.banca_digital.tarjeta.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.javaweb.banca_digital.tarjeta.application.create.TarjetaCreateService;
import com.mitocode.javaweb.banca_digital.tarjeta.application.delete.TarjetaDeleteService;
import com.mitocode.javaweb.banca_digital.tarjeta.application.finder.TarjetaFinderService;
import com.mitocode.javaweb.banca_digital.tarjeta.application.update.TarjetaUpdateService;
import com.mitocode.javaweb.banca_digital.tarjeta.domain.Tarjeta;
import com.mitocode.javaweb.banca_digital.tarjeta.domain.TarjetaUpdateException;

@RestController
@RequestMapping("/api/v1/tarjetas")
public class TarjetaRestController {

	@Autowired
	private TarjetaFinderService tarjetaFinderService;
	
	@Autowired
	private TarjetaCreateService tarjetaCreateService;
	
	@Autowired
	private TarjetaUpdateService tarjetaUpdateService;
	
	@Autowired
	private TarjetaDeleteService tarjetaDeleteService;
	
	@GetMapping
	public List<Tarjeta> listarTarjetas() {
		Optional<List<Tarjeta>> oTarjetas = tarjetaFinderService.listarTarjetas();
		
		return oTarjetas.get();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarjeta> listarTarjeta(@PathVariable Integer id) {
		Optional<Tarjeta> tarjeta = tarjetaFinderService.obtenerTarjeta(id);
		
		if(tarjeta.isPresent()) {
			return ResponseEntity.ok(tarjeta.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Tarjeta> crearTarjeta(@RequestBody Tarjeta tarjeta) {
		return ResponseEntity.ok(tarjetaCreateService.registrarTarjeta(tarjeta).get());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Tarjeta> actualizarTarjeta(@PathVariable("id") Integer id, @RequestBody Tarjeta tarjeta) {
		tarjeta.setId(id);
		try {
			return ResponseEntity.ok(tarjetaUpdateService.actualizarTarjeta(tarjeta).get());
		} catch (TarjetaUpdateException e) {
			return new ResponseEntity<Tarjeta>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
		if(tarjetaFinderService.obtenerTarjeta(id).isPresent()) {
			tarjetaDeleteService.eliminarTarjeta(id);
			return ResponseEntity.ok("Se eliminó");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
