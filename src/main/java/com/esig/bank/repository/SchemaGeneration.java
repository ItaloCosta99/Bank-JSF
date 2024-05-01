
package com.esig.bank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esig.bank.model.Pessoa;

public class SchemaGeneration {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EsigBank");
		
		EntityManager em = emf.createEntityManager();

		List<Pessoa> list = em.createQuery("FROM pessoa", Pessoa.class).getResultList();

		System.out.println(list);

		em.close();
		emf.close();

	}
}
