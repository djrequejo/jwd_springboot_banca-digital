package com.mitocode.javaweb.banca_digital.tarjeta.domain;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.mitocode.javaweb.banca_digital.cliente.domain.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Tarjeta {

	@NonNull
	private Integer id;

	@NonNull
	private Integer idCliente;

	@NonNull
	@NotBlank(message = "Registre un número de tarjeta")
	@Size(min = 19, max = 19, message = "La tarjeta debe tener 19 caracteres")
	private String numeroTarjeta;

	@NonNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Debe registrar una fechad de vencimiento")
	@FutureOrPresent(message = "Fecha debe ser mayor o igual a la fecha actual")
	private LocalDate fechaVencimiento;

	@NonNull
	@NotNull(message = "Debe seleccionar un estado")
	private TarjetaEstadoEnum estado;

	private Cliente cliente;
}
