package com.mitocode.javaweb.banca_digital.cliente.domain;

import java.time.LocalDate;
import java.util.List;

import com.mitocode.javaweb.banca_digital.tarjeta.domain.Tarjeta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
public class Cliente {
	
	@NonNull
	private Integer id;
	
	@NonNull
	private String nombres;
	
	@NonNull
	private String documento;
	
	@NonNull
	private LocalDate fechaNacimiento;
	
	private List<Tarjeta> tarjetas;

	public Cliente(String nombres, String documento, LocalDate fechaNacimiento) {
		this.nombres = nombres;
		this.documento = documento;
		this.fechaNacimiento = fechaNacimiento;
	}

}
