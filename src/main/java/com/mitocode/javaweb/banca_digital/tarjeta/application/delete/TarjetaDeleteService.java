package com.mitocode.javaweb.banca_digital.tarjeta.application.delete;

import org.springframework.stereotype.Service;

import com.mitocode.javaweb.banca_digital.tarjeta.domain.TarjetaRepository;

@Service
public class TarjetaDeleteService {

	private TarjetaRepository tarjetaRepository;

	public TarjetaDeleteService(TarjetaRepository tarjetaRepository) {
		this.tarjetaRepository = tarjetaRepository;
	}

	public boolean eliminarTarjeta(Integer idTarjeta) {
		return tarjetaRepository.delete(idTarjeta);
	}

}
