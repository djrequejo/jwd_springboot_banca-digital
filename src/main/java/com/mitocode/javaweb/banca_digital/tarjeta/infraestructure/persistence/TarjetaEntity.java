package com.mitocode.javaweb.banca_digital.tarjeta.infraestructure.persistence;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mitocode.javaweb.banca_digital.cliente.infraestructure.persistence.ClienteEntity;
import com.mitocode.javaweb.banca_digital.tarjeta.domain.TarjetaEstadoEnum;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "cliente")
@Entity
@Table(name = "tarjeta")
public class TarjetaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private Integer idTarjeta;

	@Column(name = "id_cliente")
	private Integer idCliente;

	@Column(name = "numero_tarjeta", unique = true)
	private String numeroTarjeta;

	@Column(name = "fecha_vencimiento")
	private LocalDate fechaVencimiento;

	@Enumerated(EnumType.STRING)
	private TarjetaEstadoEnum estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name =  "id_cliente", referencedColumnName = "id", insertable = false, updatable = false)
	private ClienteEntity cliente;
}
