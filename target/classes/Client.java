package main.java;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//indique que la classe doit être  gérée par JPA
@Entity

//désigne la table à mapper
@Table(name = "client")

public class Client {

	@OneToMany(mappedBy="client")
	private List<Emprunt> emprunts;
	
	

	@Id
	private Integer id;
	@Column(name = "NOM", nullable = false) //associer le champs nom à une colonne de la table
	private String nom;
	@Column(name = "PRENOM", nullable = false)   // associer le champs prenom à une colonne de la table
	private String prenom;
	
	
	public Client() {
		
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
	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

}
