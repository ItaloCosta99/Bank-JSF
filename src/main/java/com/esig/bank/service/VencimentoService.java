package com.esig.bank.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.esig.bank.dto.PesquisaVencimentoDTO;
import com.esig.bank.model.Vencimento;
import com.esig.bank.repository.Vencimentos;
import com.esig.bank.util.Transacional;

public class VencimentoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Vencimentos vencimentos;

	@Transacional
	public List<Vencimento> getAll() {
		return vencimentos.gelAll();
	}

	@Transacional
	public Vencimento getById(Long id) {
		return vencimentos.getById(id);
	}

	@Transacional
	public void salvar(Vencimento vencimento) {
		vencimentos.salvar(vencimento);
	}

	@Transacional
	public void deletar(Vencimento vencimento) {
		vencimentos.deletar(vencimento);
	}
	
	@Transacional
	public List<Vencimento> pesquisar(PesquisaVencimentoDTO dto) {
		return vencimentos.search(dto.getId(), dto.getDescricao());
	}

}
