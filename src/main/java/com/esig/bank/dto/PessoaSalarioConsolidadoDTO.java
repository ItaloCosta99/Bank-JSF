package com.esig.bank.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PessoaSalarioConsolidadoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long pessoa_id;

	private String nome_pessoa;

	private String nome_cargo;

	private BigDecimal salario;

	public PessoaSalarioConsolidadoDTO(Long id, String nomePessoa, String nomeCargo, BigDecimal salario) {
		super();
		this.pessoa_id = id;
		this.nome_pessoa = nomePessoa;
		this.nome_cargo = nomeCargo;
		this.salario = salario;
	}

	public Long getId() {
		return pessoa_id;
	}

	public String getNomePessoa() {
		return nome_pessoa;
	}

	public String getNomeCargo() {
		return nome_cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	@Override
	public String toString() {
		return "PessoaSalarioConsolidadoDTO [id=" + pessoa_id + ", nomePessoa=" + nome_pessoa + ", nomeCargo=" + nome_cargo
				+ ", salario=" + salario + "]";
	}

}
