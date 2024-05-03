package com.esig.bank.enums;

public enum TipoCargo {
	ESTAGIARIO(1), TECNICO(2), ANALISTA(3), COORDENADOR(4), GERENTE(5);

	private Integer value;

	TipoCargo(Integer value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
