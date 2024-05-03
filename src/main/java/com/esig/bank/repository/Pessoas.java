package com.esig.bank.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.esig.bank.dto.PessoaSalarioConsolidadoDTO;
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
		TypedQuery<Pessoa> query = em.createQuery("FROM Pessoa", Pessoa.class);
		return query.getResultList();
	}

	public List<Pessoa> search(Long id, String nome) {
		String queryString = "FROM Pessoa WHERE (:id is null or id = :id) "
				+ "AND (:nome is null or UPPER(nome) like UPPER(:nome) ) ";

		TypedQuery<Pessoa> query = em.createQuery(queryString, Pessoa.class);
		query.setParameter("id", id);
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}

	public List<PessoaSalarioConsolidadoDTO> getSalarioConsolidado() {
		Query query = em.createNativeQuery(
				"SELECT pessoa.id AS pessoa_id, pessoa.nome AS nome_pessoa, cargo.nome AS nome_cargo, "
						+ "SUM(CASE WHEN vencimentos.tipo = 'CREDITO' THEN vencimentos.valor ELSE -vencimentos.valor END) AS salario FROM pessoa "
						+ "JOIN cargo_vencimentos ON pessoa.cargo_id = cargo_vencimentos.cargo_id "
						+ "JOIN cargo ON cargo_vencimentos.cargo_id = cargo.id "
						+ "JOIN vencimentos ON cargo_vencimentos.vencimento_id = vencimentos.id "
						+ "GROUP BY pessoa.id, pessoa.nome, cargo.nome ORDER BY pessoa.id",
				"PessoaSalarioConsolidadoDTO");
		return query.getResultList();
	}

	public List<PessoaSalarioConsolidadoDTO> searchPessoaNome(String nome) {
		Query query = em.createNativeQuery("SELECT * FROM ( "
				+ "SELECT pessoa.id AS pessoa_id, pessoa.nome AS nome_pessoa, cargo.nome AS nome_cargo, "
				+ "SUM(CASE WHEN vencimentos.tipo = 'CREDITO' THEN vencimentos.valor ELSE -vencimentos.valor END) AS salario FROM pessoa "
				+ "JOIN cargo_vencimentos ON pessoa.cargo_id = cargo_vencimentos.cargo_id "
				+ "JOIN cargo ON cargo_vencimentos.cargo_id = cargo.id "
				+ "JOIN vencimentos ON cargo_vencimentos.vencimento_id = vencimentos.id "
				+ "GROUP BY pessoa.id, pessoa.nome, cargo.nome ORDER BY pessoa.id) WHERE (:nome is null or UPPER(nome_pessoa) like UPPER(:nome) )",
				"PessoaSalarioConsolidadoDTO");

		query.setParameter("nome", nome + "%");
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
