package com.mitocode.javaweb.banca_digital.tarjeta.application.update;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mitocode.javaweb.banca_digital.tarjeta.domain.Tarjeta;
import com.mitocode.javaweb.banca_digital.tarjeta.domain.TarjetaRepository;
import com.mitocode.javaweb.banca_digital.tarjeta.domain.TarjetaUpdateException;

@Service
public class TarjetaUpdateService {

	private TarjetaRepository tarjetaRepository;

	public TarjetaUpdateService(TarjetaRepository tarjetaRepository) {
		this.tarjetaRepository = tarjetaRepository;
	}
	
	public Optional<Tarjeta> actualizarTarjeta(Tarjeta tarjeta) throws TarjetaUpdateException {
		return Optional.ofNullable(tarjetaRepository.updateAll(tarjeta).orElseThrow(TarjetaUpdateException::new));
	}

}
