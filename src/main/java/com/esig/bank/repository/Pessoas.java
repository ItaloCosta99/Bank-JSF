package com.esig.bank.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.esig.bank.model.Pessoa;

public class Pessoas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public Pessoas() {

	}

	public Pessoas(EntityManager em) {
		this.em = em;
	}

	public List<Pessoa> gelAll() {
		TypedQuery<Pessoa> query = em.createQuery("FROM pessoa", Pessoa.class);
		return query.getResultList();
	}

	public List<Pessoa> search(Long id, String nome) {
		String queryString = "FROM Colaborador WHERE (:id is null or id = :id) "
				+ "AND (:nome is null or UPPER(nome) like UPPER(:nome) ) ";

		TypedQuery<Pessoa> query = em.createQuery(queryString, Pessoa.class);
		query.setParameter("id", id);
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}
	
	public Pessoa getById(Long id) {
		return em.find(Pessoa.class, id);
	}
	
	public Pessoa salvar(Pessoa pessoa) {
		return em.merge(pessoa);
	}
	
	public void deletar(Pessoa pessoa) {
		pessoa = getById(pessoa.getId());
		em.remove(pessoa);
	}

}
