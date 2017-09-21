package dev.biblio.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "LIVRE")
public class Livre {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Expose
	@Column(name="TITRE")
	private String titre;
	
	@Expose
	@Column(name="DATE")
	private Date datepublication;
	
	@Expose
	@Column(name="descript")
	private String description;
	
	@Expose
	@Column(name="CATEGORIE")
	private String categorie;
	
	@ManyToOne
	private Auteur auteur;
	
	@Expose
	@Column(name="NBEXEMPLAIRES")
	private Integer nbexemplaires;
	
	@Expose
	@Column(name="NBEXEMPLAIRESDISPO")
	private Integer nbexmplairesdispo;

	public Livre() {

	}


	public Livre(Integer id, String titre, Date datepublication, String description, String categorie, Auteur auteur,
			Integer nbexemplaires, Integer nbexmplairesdispo) {
		super();
		this.id = id;
		this.titre = titre;
		this.datepublication = datepublication;
		this.description = description;
		this.categorie = categorie;
		this.auteur = auteur;
		this.nbexemplaires = nbexemplaires;
		this.nbexmplairesdispo = nbexmplairesdispo;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDatepublication() {
		return datepublication;
	}

	public void setDatepublication(Date datepublication) {
		this.datepublication = datepublication;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}



	public Auteur getAuteur() {
		return auteur;
	}



	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}



	public Integer getNbexemplaires() {
		return nbexemplaires;
	}

	public void setNbexemplaires(Integer nbexemplaires) {
		this.nbexemplaires = nbexemplaires;
	}

	public Integer getNbexmplairesdispo() {
		return nbexmplairesdispo;
	}

	public void setNbexmplairesdispo(Integer nbexmplairesdispo) {
		this.nbexmplairesdispo = nbexmplairesdispo;
	}

}
