package com.mitocode.javaweb.banca_digital.cliente.infraestructure.persistence;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mitocode.javaweb.banca_digital.cliente.domain.Cliente;

@Mapper
public interface MyBatisClienteMapper {

	@Select("SELECT * FROM cliente")
	public List<Cliente> findAll();
	
	@Insert("INSERT INTO cliente(nombres, documento, fecha_nacimiento) VALUES ( #{nombres}, #{documento}, #{fechaNacimiento})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public Integer insert(Cliente cliente);
	
	@Delete("DELETE FROM cliente WHERE id = #{idCliente}")
	public int delete(@Param("idCliente") Integer id);
	
	@Update("UPDATE cliente SET nombres = #{nombres}, documento = #{documento}, fecha_nacimiento = #{fechaNacimiento} WHERE id = #{id}")
	public int update(Cliente cliente);
	
	@Select("SELECT * FROM cliente WHERE id = #{id}")
	@Results({
		@Result(
			property = "tarjetas", 
			column = "id", 
			javaType = List.class,
			many = @Many(select = "com.mitocode.javaweb.banca_digital.tarjeta.infraestructure.persistence.MyBatisTarjetaMapper.findByIdCliente"))
	})
	public Cliente findById(Integer id);
	
	@Select("SELECT * FROM cliente WHERE documento = #{documento}")
	@Results({
		@Result(
			property = "tarjetas", 
			column = "id", 
			javaType = List.class,
			many = @Many(select = "com.mitocode.javaweb.banca_digital.tarjeta.infraestructure.persistence.MyBatisTarjetaMapper.findByIdCliente"))
	})
	public Cliente findByDocumento(String documento);
	
}
