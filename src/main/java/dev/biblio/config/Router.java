package dev.biblio.config;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import dev.biblio.entity.Auteur;
import dev.biblio.entity.Config;
import dev.biblio.entity.Livre;


public class Router {
	  
	
	public void initialiserDonnees() {
		EntityManager entityManager = Config.getInstance();
		
	   		
		Auteur auteur1 = new Auteur();
		auteur1.setNom("delpeche");
		auteur1.setPrenom("valery");
		auteur1.setLangue("français");
		auteur1.setLivres(null);
		
		Auteur auteur2 = new Auteur();
		auteur2.setNom("Rivard");
		auteur2.setPrenom("John");
		auteur2.setLangue("Anglais");
		auteur2.setLivres(null);
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(auteur1);
		entityManager.persist(auteur2);
		entityManager.getTransaction().commit();
		
		
		
		Livre livre1 = new Livre();
		livre1.setCategorie("roman");
		livre1.setTitre("la vie est belle 2");
		livre1.setNbexemplaires(13);
		livre1.setDescription("livre de passion");
		livre1.setNbexmplairesdispo(10);
		livre1.setDatepublication(Date.valueOf("1981-05-11"));
		livre1.setAuteur(auteur1);
		
		
		Livre livre2 = new Livre();
		livre2.setCategorie("roman");
		livre2.setTitre("America");
		livre2.setNbexemplaires(13);
		livre2.setDescription("Story of America");
		livre2.setNbexmplairesdispo(9);
		livre2.setDatepublication(Date.valueOf("2000-06-20"));
		livre2.setAuteur(auteur2);
		
		Set<Livre> set1 = new HashSet<Livre>();
		set1.add(livre1);

		Set<Livre> set2 = new HashSet<Livre>();
		set2.add(livre2);
		
		entityManager.getTransaction().begin();
		auteur1.setLivres(set1);
		auteur2.setLivres(set2);
		entityManager.persist(livre1);
		entityManager.persist(livre2);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
		
					
}
	

