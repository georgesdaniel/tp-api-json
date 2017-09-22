package dev.biblio.services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import dev.biblio.entity.Auteur;
import dev.biblio.entity.Config;
import dev.biblio.entity.Livre;

public class CrudLivres implements CrudLivresInterface {

	EntityManager entityManager = Config.getInstance();

	public List<Livre> lister() {
		List<Livre> listlivre = new ArrayList<Livre>();
		TypedQuery<Livre> query = entityManager.createQuery("from Livre", Livre.class);
		listlivre = query.getResultList();
		return listlivre;

	}

	public Livre findById(int id) {
		List<Livre> livre1 = new ArrayList<Livre>();
		TypedQuery<Livre> query = entityManager.createQuery("from Livre WHERE id=:pid", Livre.class);
		query.setParameter("pid", id);
		livre1 = query.getResultList();
		if (!livre1.isEmpty()) {
			return livre1.get(0);
		}
		return null;
	}

}
