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

	public Auteur findById(int id) {
		List<Auteur> aut1 = new ArrayList<Auteur>();
		TypedQuery<Auteur> query = entityManager.createQuery("from Auteur WHERE id=:pid", Auteur.class);
		query.setParameter("pid", id);
		aut1 = query.getResultList();
		if (!aut1.isEmpty()) {
			return aut1.get(0);
		}
		return null;
	}

	public void mettreAJour(Auteur auteur) {
		entityManager.getTransaction().begin();
		Auteur auteur1 = entityManager.find(Auteur.class, auteur.getId());
		auteur1.setNom(auteur.getNom());
		auteur1.setPrenom(auteur.getPrenom());
		auteur1.setLivres(auteur.getLivres());
		auteur1.setLangue(auteur.getLangue());
		entityManager.persist(auteur);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	public void Sauvegarde(Auteur auteur1) {
		entityManager.getTransaction().begin();
		entityManager.persist(auteur1);
		entityManager.getTransaction().commit();

	}

	public void Suppression(Auteur auteur1) {
		entityManager.getTransaction().begin();
		entityManager.remove(auteur1);
		entityManager.getTransaction().commit();

	}

}
