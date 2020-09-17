package com.mitocode.javaweb.banca_digital.tarjeta.domain;

public enum TarjetaEstadoEnum {

	ACTIVA("Activa"), BLOQUEADO("Bloqueado"), POR_ENDOSAR("Por endosar"), INACTIVA("Inactiva");

	private String label;

	private TarjetaEstadoEnum(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
