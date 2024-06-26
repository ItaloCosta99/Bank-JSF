package com.esig.bank.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

	private EntityManagerFactory emf;

	public EntityManagerProducer() {
		this.emf = Persistence.createEntityManagerFactory("EsigBank");
	}

	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return this.emf.createEntityManager();
	}

	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}
