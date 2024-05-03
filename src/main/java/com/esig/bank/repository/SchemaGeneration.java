
package com.esig.bank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.esig.bank.dto.PessoaSalarioConsolidadoDTO;

public class SchemaGeneration {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EsigBank");

		EntityManager em = emf.createEntityManager();

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
