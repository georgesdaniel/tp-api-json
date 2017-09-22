package dev.biblio.services;

import java.util.List;

import dev.biblio.entity.Auteur;

public interface CrudAuteurInterface {
	// Liste des auteurs
	public List<Auteur> lister();

	// Detail d'un auteur avec id
	public Auteur findById(int id);

	// Mise à jour des auteurs
	void mettreAJour(Auteur auteur);

	void Sauvegarde(Auteur auteur1);

	void Suppression(Auteur auteur1);

}
