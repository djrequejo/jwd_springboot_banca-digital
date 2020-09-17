package com.mitocode.javaweb.banca_digital.usuario.infraestructure.persistence;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mitocode.javaweb.banca_digital.cliente.domain.Cliente;
import com.mitocode.javaweb.banca_digital.usuario.domain.Usuario;

@Mapper
public interface MyBatisUsuarioMapper {

	@Select("SELECT * FROM usuario WHERE id_cliente = #{id}")
	@Results({
			@Result(property = "cliente", column = "id_cliente", javaType = Cliente.class, one = @One(select = "com.mitocode.javaweb.banca_digital.cliente.infraestructure.persistence.MyBatisClienteMapper.findById")) })
	public Usuario findById(Integer id);

	@Select("SELECT * FROM usuario WHERE id_cliente = #{idCliente}")
	public Usuario findByIdCliente(Integer idCliente);
	
	@Select("SELECT * FROM usuario WHERE id_cliente = #{id} and clave = #{clave}")
	public Usuario findByIdAndClave(Integer id, String clave);
}
