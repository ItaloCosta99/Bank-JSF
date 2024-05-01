package com.esig.bank.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.esig.bank.model.Cargo;

public class Cargos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public Cargos() {

	}

	public Cargos(EntityManager em) {
		this.em = em;
	}

	public List<Cargo> gelAll() {
		TypedQuery<Cargo> query = em.createQuery("FROM cargo", Cargo.class);
		return query.getResultList();
	}

	public List<Cargo> search(Long id, String nome) {
		String queryString = "FROM Cargo WHERE (:id is null or id = :id) "
				+ "AND (:nome is null or UPPER(nome) like UPPER(:nome) ) ";

		TypedQuery<Cargo> query = em.createQuery(queryString, Cargo.class);
		query.setParameter("id", id);
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}

	public Cargo getById(Long id) {
		return em.find(Cargo.class, id);
	}

	public Cargo salvar(Cargo cargo) {
		return em.merge(cargo);
	}

	public void deletar(Cargo cargo) {
		cargo = getById(cargo.getId());
		em.remove(cargo);
	}

}
