package com.mitocode.javaweb.banca_digital.cliente.infraestructure.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.mitocode.javaweb.banca_digital.cliente.domain.Cliente;

@Mapper
public interface ClienteMapper {

	@Select("SELECT * FROM cliente")
	public Collection<Cliente> findAll();
	
	@Insert("INSERT INTO cliente(nombres, documento, fecha_nacimiento) VALUES ( #{nombres}, #{documento}, #{fechaNacimiento})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public Integer insert(Cliente cliente);
	
}
