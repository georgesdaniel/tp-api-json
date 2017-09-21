package dev.biblio.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dev.biblio.entity.Auteur;
import dev.biblio.entity.Config;




public class CrudAuteur implements CrudAuteurInterface {
	
	EntityManager entityManager = Config.getInstance();

	public List<Auteur> lister() {
		List<Auteur> listauteur = new ArrayList<Auteur>();
		TypedQuery<Auteur> query = entityManager.createQuery("from Auteur", Auteur.class);
		listauteur = query.getResultList();
	return listauteur;

	}

	public void mettreAJour(Auteur auteur) {
		
		entityManager.merge(auteur);
	}
	
	
	

	
}
