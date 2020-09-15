package com.mitocode.javaweb.banca_digital.tarjeta.application.finder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.mitocode.javaweb.banca_digital.tarjeta.domain.Tarjeta;

@SpringBootTest
@ContextConfiguration
public class TarjetaFinderServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(TarjetaFinderServiceTest.class);
	
	@Autowired
	private TarjetaFinderService tarjetaFinderService;
	
	@Test
	public void listarTarjetas() {
		Integer idCliente = 1;
		
		Optional<List<Tarjeta>> lista = tarjetaFinderService.listarTarjetas(idCliente);
		
		lista.ifPresent(tarjetas -> tarjetas.forEach(tarjeta -> log.info(tarjeta.toString())));
		
		assertNotNull(lista.get());
	}
}
