package dev.biblio.services;

import java.util.List;

import dev.biblio.entity.Auteur;




public interface CrudAuteurInterface {
	
	List<Auteur> lister();
	void mettreAJour(Auteur auteur);

}
