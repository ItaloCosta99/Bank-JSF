package com.esig.bank.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.esig.bank.repository.Pessoas;

@Named(value = "pscBean")
@ViewScoped
public class PessoaSalarioConsolidadoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Pessoas pessoas;

	private List<?> pscList;

	@PostConstruct
	public void init() {
		pscList = pessoas.getSalarioConsolidado();
	}

	public Pessoas getPessoas() {
		return pessoas;
	}

	public List<?> getPscList() {
		return pscList;
	}

}
