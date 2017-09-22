package dev.biblio.services;

import java.util.List;

import dev.biblio.entity.Auteur;
import dev.biblio.entity.Livre;

public interface CrudLivresInterface {
	public List<Livre> lister();
	public Livre findById(int id);
	
}
