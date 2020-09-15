package com.mitocode.javaweb.banca_digital.tarjeta.application.finder;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mitocode.javaweb.banca_digital.tarjeta.domain.Tarjeta;
import com.mitocode.javaweb.banca_digital.tarjeta.domain.TarjetaRepository;

@Service
public class TarjetaFinderService {

	private TarjetaRepository tarjetaRepository;

	public TarjetaFinderService(TarjetaRepository tarjetaRepository) {
		this.tarjetaRepository = tarjetaRepository;
	}
	
	public Optional<List<Tarjeta>> listarTarjetas(Integer idCliente) {
		return tarjetaRepository.findByIdCliente(idCliente);
	}
	
}
