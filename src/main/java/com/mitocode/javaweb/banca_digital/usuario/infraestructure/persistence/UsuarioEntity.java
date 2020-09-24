package com.mitocode.javaweb.banca_digital.usuario.infraestructure.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mitocode.javaweb.banca_digital.cliente.infraestructure.persistence.ClienteEntity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "cliente")
@Entity
@Table(name = "usuario")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private Integer idUsuario;

	@Column(name = "id_cliente")
	private Integer idCliente;

	@Column
	private String clave;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente", referencedColumnName = "id", insertable = false, updatable = false)
	private ClienteEntity cliente;

}
