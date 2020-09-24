package com.mitocode.javaweb.banca_digital.usuario.infraestructure.persistence;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.mitocode.javaweb.banca_digital.usuario.domain.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioEntityMapper {

//	UsuarioEntityMapper INSTANCE = Mappers.getMapper( UsuarioEntityMapper.class );
	
	@Mappings({
		@Mapping(source = "idUsuario", target = "id"),
		@Mapping(source = "idCliente", target = "idCliente"),
		@Mapping(source = "clave", target = "clave"),
		@Mapping(source = "cliente", target = "cliente", ignore = true)
	})
	Usuario toUsuario(UsuarioEntity entity);
	
	@InheritInverseConfiguration
	UsuarioEntity toUsuarioEntity(Usuario usuario);
}
