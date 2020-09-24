package com.mitocode.javaweb.banca_digital.usuario.infraestructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface JpaUsuarioCrudRepository extends CrudRepository<UsuarioEntity, Integer> {

	Optional<UsuarioEntity> findByIdCliente(Integer idCliente);
	
	Optional<UsuarioEntity> findByIdClienteAndClave(Integer idCliente, String clave);
	
	@Query("SELECT u FROM UsuarioEntity u WHERE u.idCliente = ?1 and u.clave like ?2")
	Optional<UsuarioEntity> findByCampoPersonalizado(Integer idCliente, String clave);

}
