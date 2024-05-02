package com.esig.bank.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.esig.bank.dto.PesquisaCargoDTO;
import com.esig.bank.model.Cargo;
import com.esig.bank.repository.Cargos;
import com.esig.bank.util.Transacional;

public class CargoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Cargos cargos;

	@Transacional
	public List<Cargo> getAll() {
		return cargos.gelAll();
	}

	@Transacional
	public Cargo getById(Long id) {
		return cargos.getById(id);
	}

	@Transacional
	public void salvar(Cargo cargo) {
		cargos.salvar(cargo);
	}

	@Transacional
	public void deletar(Cargo cargo) {
		cargos.deletar(cargo);
	}

	@Transacional
	public List<Cargo> pesquisar(PesquisaCargoDTO dto) {
		return cargos.search(dto.getId(), dto.getNome());
	}

}
