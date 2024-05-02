package com.esig.bank.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.esig.bank.model.Vencimento;

public class Vencimentos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public Vencimentos() {
		
	}
	
	public Vencimentos(EntityManager em) {
		this.em = em;
	}
	
	public List<Vencimento> gelAll() {
		TypedQuery<Vencimento> query = em.createQuery("FROM vencimentos", Vencimento.class);
		return query.getResultList();
	}

	public List<Vencimento> search(Long id, String descricao) {
		String queryString = "FROM vencimentos WHERE (:id is null or id = :id) "
				+ "AND (:descricao is null or UPPER(nome) like UPPER(:descricao) ) ";

		TypedQuery<Vencimento> query = em.createQuery(queryString, Vencimento.class);
		query.setParameter("id", id);
		query.setParameter("nome", "%" + descricao + "%");
		return query.getResultList();
	}

	public Vencimento getById(Long id) {
		return em.find(Vencimento.class, id);
	}

	public Vencimento salvar(Vencimento vencimento) {
		return em.merge(vencimento);
	}

	public void deletar(Vencimento vencimento) {
		vencimento = getById(vencimento.getId());
		em.remove(vencimento);
	}

}
