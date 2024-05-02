package com.esig.bank.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.esig.bank.dto.PesquisaPessoaDTO;
import com.esig.bank.model.Pessoa;
import com.esig.bank.repository.Pessoas;
import com.esig.bank.util.Transacional;

public class PessoaService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Pessoas pessoas;

	@Transacional
	public List<Pessoa> getAll() {
		return pessoas.gelAll();
	}

	@Transacional
	public Pessoa getById(Long id) {
		return pessoas.getById(id);
	}

	@Transacional
	public void salvar(Pessoa pessoa) {
		pessoas.salvar(pessoa);
	}

	@Transacional
	public void deletar(Pessoa pessoa) {
		pessoas.deletar(pessoa);
	}

	@Transacional
	public List<Pessoa> pesquisar(PesquisaPessoaDTO dto) {
		return pessoas.search(dto.getId(), dto.getNome());
	}

}
