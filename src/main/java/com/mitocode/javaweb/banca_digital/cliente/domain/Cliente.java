package com.mitocode.javaweb.banca_digital.cliente.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
public class Cliente {
	
	private Integer id;
	
	@NonNull
	private String nombres;
	
	@NonNull
	private String documento;
	
	@NonNull
	private LocalDate fechaNacimiento;
	

}
