package com.mitocode.javaweb.banca_digital.cliente.infraestructure.persistence;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mitocode.javaweb.banca_digital.tarjeta.infraestructure.persistence.TarjetaEntity;
import com.mitocode.javaweb.banca_digital.usuario.infraestructure.persistence.UsuarioEntity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"usuario", "tarjetas"})
@Entity
@Table(name = "cliente")
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private Integer idCliente;

	@Column
	private String nombres;

	@Column
	private String documento;

	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	@OneToOne(mappedBy = "cliente", fetch = FetchType.LAZY)
	private UsuarioEntity usuario;

	@OneToMany(mappedBy = "cliente")
	private List<TarjetaEntity> tarjetas;
	
}
