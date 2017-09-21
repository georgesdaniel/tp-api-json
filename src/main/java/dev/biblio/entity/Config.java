package dev.biblio.entity;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class Config {

	private static EntityManager entityManager;
	
	private Config() {	
	}
	
	public static EntityManager getInstance() {
		if(entityManager == null) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotheque");
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}

}
