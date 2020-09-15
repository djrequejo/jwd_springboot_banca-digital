package com.mitocode.javaweb.banca_digital.tarjeta.infraestructure.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mitocode.javaweb.banca_digital.cliente.domain.Cliente;
import com.mitocode.javaweb.banca_digital.tarjeta.domain.Tarjeta;

@Mapper
public interface MyBatisTarjetaMapper {

	@Select("SELECT * FROM tarjeta WHERE id_cliente = #{idCliente}")
	@Results({ @Result(property = "numeroTarjeta", column = "numero_tarjeta") })
	public List<Tarjeta> findByIdCliente(Integer idCliente);

	@Select("SELECT * FROM tarjeta WHERE id = #{id}")
	@Results({
			@Result(
				property = "cliente", 
				column = "id_cliente", 
				javaType = Cliente.class, 
				one = @One(select = "com.mitocode.javaweb.banca_digital.cliente.infraestructure.persistence.MyBatisClienteMapper.findById")) })
	public Tarjeta findById(Integer id);

}
