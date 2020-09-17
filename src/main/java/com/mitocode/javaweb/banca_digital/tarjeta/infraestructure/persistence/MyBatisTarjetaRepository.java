package com.mitocode.javaweb.banca_digital.tarjeta.infraestructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mitocode.javaweb.banca_digital.tarjeta.domain.Tarjeta;
import com.mitocode.javaweb.banca_digital.tarjeta.domain.TarjetaRepository;

@Repository
public class MyBatisTarjetaRepository implements TarjetaRepository {
	
	private MyBatisTarjetaMapper tarjetaMapper;
	
	public MyBatisTarjetaRepository(MyBatisTarjetaMapper tarjetaMapper) {
		this.tarjetaMapper = tarjetaMapper;
	}

	@Override
	public Optional<List<Tarjeta>> findByIdCliente(Integer idCliente) {
		return Optional.ofNullable(tarjetaMapper.findByIdCliente(idCliente));
	}

	@Override
	public Optional<Tarjeta> findById(Integer id) {
		return Optional.ofNullable(tarjetaMapper.findById(id));
	}

	@Override
	public Tarjeta save(Tarjeta tarjeta) {
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		return false;
	}

}
