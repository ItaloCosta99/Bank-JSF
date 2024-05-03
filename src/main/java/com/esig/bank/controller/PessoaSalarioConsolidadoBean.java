package com.esig.bank.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.esig.bank.enums.TipoCargo;
import com.esig.bank.model.Pessoa;
import com.esig.bank.repository.Pessoas;
import com.esig.bank.service.PessoaService;

@Named(value = "pscBean")
@ViewScoped
public class PessoaSalarioConsolidadoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Pessoas pessoas;

	@Inject
	private PessoaService pessoaService;

	private List<?> pscList;

	private String termoPesquisa;

	private Pessoa pessoa;

	@PostConstruct
	public void init() {
		pscList = pessoas.getSalarioConsolidado();
	}

	public void prepararNovaPessoa() {
		pessoa = new Pessoa();
	}

	public void salvar() {
		pessoaService.salvar(pessoa);

		if (jaHouvePesquisa()) {
			pesquisar();
		}
	}

	private boolean jaHouvePesquisa() {
		return termoPesquisa != null && !"".equals(termoPesquisa);
	}

	public void pesquisar() {
		pscList = pessoas.searchPessoaNome(termoPesquisa);
	}

	public Pessoas getPessoas() {
		return pessoas;
	}

	public List<?> getPscList() {
		return pscList;
	}

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}

	public TipoCargo[] getTiposCargo() {
		return TipoCargo.values();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

}
