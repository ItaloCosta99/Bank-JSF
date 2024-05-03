
package com.esig.bank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;

import com.esig.bank.dto.PessoaSalarioConsolidadoDTO;

public class SchemaGeneration {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EsigBank");

		EntityManager em = emf.createEntityManager();

		/*
		 * Query query = em.createNativeQuery(
		 * "SELECT p.id AS pessoa_id, p.nome AS nome_pessoa, c.nome AS nome_cargo, " +
		 * "SUM(CASE WHEN v.tipo = 'CREDITO' THEN v.valor ELSE -v.valor END) AS salario "
		 * + "FROM Pessoa p, CargoVencimentos cv " + "JOIN cv.cargoId c " +
		 * "JOIN cv.vencimentoId v " + "WHERE p.cargo_id = c.id " +
		 * "GROUP BY p.id, p.nome, c.nome " + "ORDER BY p.id ",
		 * "PessoaSalarioConsolidadoDTO");
		 */

		Query query = em.createNativeQuery(
				"SELECT pessoa.id AS pessoa_id, pessoa.nome AS nome_pessoa, cargo.nome AS nome_cargo, "
						+ "SUM(CASE WHEN vencimentos.tipo = 'CREDITO' THEN vencimentos.valor ELSE -vencimentos.valor END) AS salario FROM pessoa "
						+ "JOIN cargo_vencimentos ON pessoa.cargo_id = cargo_vencimentos.cargo_id "
						+ "JOIN cargo ON cargo_vencimentos.cargo_id = cargo.id "
						+ "JOIN vencimentos ON cargo_vencimentos.vencimento_id = vencimentos.id "
						+ "GROUP BY pessoa.id, pessoa.nome, cargo.nome ORDER BY pessoa.id", "PessoaSalarioConsolidadoDTO");

		List<PessoaSalarioConsolidadoDTO> list = query.getResultList();

		for (PessoaSalarioConsolidadoDTO p : list) {
			System.out.println(p);
		}

		em.close();
		emf.close();

	}
}
