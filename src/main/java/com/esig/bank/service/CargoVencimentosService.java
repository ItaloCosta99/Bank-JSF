package com.esig.bank.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.esig.bank.dto.PesquisaCargoVencimentosDTO;
import com.esig.bank.model.CargoVencimentos;
import com.esig.bank.repository.CargoVencimentosRepo;
import com.esig.bank.util.Transacional;

public class CargoVencimentosService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CargoVencimentosRepo cargoVencimentos;

	@Transacional
	public List<CargoVencimentos> getAll() {
		return cargoVencimentos.gelAll();
	}

	@Transacional
	public CargoVencimentos getById(Long id) {
		return cargoVencimentos.getById(id);
	}

	@Transacional
	public void salvar(CargoVencimentos cargoVencimento) {
		cargoVencimentos.salvar(cargoVencimento);
	}

	@Transacional
	public void deletar(CargoVencimentos cargoVencimento) {
		cargoVencimentos.deletar(cargoVencimento);
	}
	
	@Transacional
	public List<CargoVencimentos> pesquisar(PesquisaCargoVencimentosDTO dto) {
		return cargoVencimentos.search(dto.getId());
	}

}
