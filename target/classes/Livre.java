package main.java;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// indique que la classe doit �tre  g�r�e par JPA
@Entity

// d�signe la table � mapper
@Table(name = "livre")

public class Livre {
	@Id
	private Integer id;
	@Column(name = "titre")  //associer le champs titre � une colonne de la table
	private String titre;
	@Column(name = "auteur") //associer le champs auteur � une colonne de la table
	private String auteur;
	
	@ManyToMany(mappedBy="livres")   // lien ManyToMany avec emprunt en passant par compo 
	private List<Emprunt> emprunts;  // tel que livre
	
	public Livre() {
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

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	
}
