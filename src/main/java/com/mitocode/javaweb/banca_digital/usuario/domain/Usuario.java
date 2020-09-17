package com.mitocode.javaweb.banca_digital.usuario.domain;

import com.mitocode.javaweb.banca_digital.cliente.domain.Cliente;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
public class Usuario {

	@NonNull
	private Integer id;

	@NonNull
	private Integer idCliente;

	@NonNull
//	@ToString.Exclude
	private String clave;

	private Cliente cliente;

	public Usuario(@NonNull Integer idCliente, @NonNull String clave) {
		super();
		this.idCliente = idCliente;
		this.clave = clave;
	}

}
