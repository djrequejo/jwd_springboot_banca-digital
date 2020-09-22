package com.mitocode.javaweb.banca_digital.tarjeta.application.create;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mitocode.javaweb.banca_digital.tarjeta.domain.Tarjeta;
import com.mitocode.javaweb.banca_digital.tarjeta.domain.TarjetaRepository;

@Service
public class TarjetaCreateService {

	private TarjetaRepository tarjetaRepository;
	
	public TarjetaCreateService(TarjetaRepository tarjetaRepository) {
		this.tarjetaRepository = tarjetaRepository;
	}

	public Optional<Tarjeta> registrarTarjeta(Tarjeta tarjeta) {
		
		// buscar tarjetas activas
		// si existe inhabilitarlas
		// registrar tarjeta nueva
		
		return Optional.ofNullable(tarjetaRepository.save(tarjeta));
	}
	
	
}
