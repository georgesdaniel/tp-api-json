package dev.biblio.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "AUTEUR")
public class Auteur {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Expose
	@Column(name = "NOM")
	private String nom;

	@Expose
	@Column(name = "PRENOM")
	private String prenom;
	
	@Expose
	@Column(name = "LANGUE")
	private String langue;
	
	@Expose
	@OneToMany(mappedBy = "auteur")
	private Set<Livre> livres;

	public Auteur() {

	}

	public Auteur(Integer id, String nom, String prenom, String langue, Set<Livre> livres) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.langue = langue;
		this.livres = livres;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

}
