package com.esig.bank.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.esig.bank.model.CargoVencimentos;

public class CargoVencimentosRepo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public CargoVencimentosRepo() {

	}

	public CargoVencimentosRepo(EntityManager em) {
		this.em = em;
	}

	public List<com.esig.bank.model.CargoVencimentos> gelAll() {
		TypedQuery<CargoVencimentos> query = em.createQuery("FROM cargo_vencimentos", CargoVencimentos.class);
		return query.getResultList();
	}

	public List<CargoVencimentos> search(Long id) {
		String queryString = "FROM cargo_vencimentos WHERE (:id is null or id = :id)";

		TypedQuery<CargoVencimentos> query = em.createQuery(queryString, CargoVencimentos.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

	public CargoVencimentos getById(Long id) {
		return em.find(CargoVencimentos.class, id);
	}

	public CargoVencimentos salvar(CargoVencimentos cargoVencimentos) {
		return em.merge(cargoVencimentos);
	}

	public void deletar(CargoVencimentos cargoVencimentos) {
		cargoVencimentos = getById(cargoVencimentos.getId());
		em.remove(cargoVencimentos);
	}

}
