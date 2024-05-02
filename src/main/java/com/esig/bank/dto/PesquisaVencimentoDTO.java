package com.esig.bank.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.esig.bank.enums.TipoVencimento;

public class PesquisaVencimentoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;

	private String descricao;

	private BigDecimal valor;

	private TipoVencimento tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoVencimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoVencimento tipo) {
		this.tipo = tipo;
	}

}
