package com.mitocode.javaweb.banca_digital.tarjeta.domain;

import java.time.LocalDate;

import com.mitocode.javaweb.banca_digital.cliente.domain.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Tarjeta {

	@NonNull
	private Integer id;
	
	@NonNull
	private Integer idCliente;
	
	@NonNull
	private String numeroTarjeta;
	
	@NonNull
	private LocalDate fechaVencimiento;
	
	@NonNull
	private TarjetaEstadoEnum estado;
	
	private Cliente cliente;
}
