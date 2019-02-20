package main.java;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;


//indique que la classe doit être  gérée par JPA
@Entity

//désigne la table à mapper
@Table(name = "emprunt")


public class Emprunt {

	@Id
	private Integer id;

	@Column(name = "DATE_DEBUT", nullable = false) //associer le champs date debut à une colonne de la table
	private LocalDateTime date_debut;

	@Column(name = "DATE_FIN", nullable = false)   // associer le champs date fin à une colonne de la table
	private LocalDateTime  date_fin;

	@Column(name = "DELAI", nullable = false)   // associer le champs delai à une colonne de la table
	private Integer delai;

	@ManyToOne					// relation ManyToOne avec client qui remplace ID_CLIENT
	@JoinColumn(name = "id_client")   
	private Client client;

	@ManyToMany					// relation ManytoMany avec Livre en passant Emprunt > Compo < Livre
	@JoinTable(name="compo", 
	joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="id"),
	inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="id"))
	private List<Livre> livres;

	
	public Emprunt() {
		
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public List<Livre> getLivres() {
		return livres;
	}


	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDateTime getDate_debut() {
		return date_debut;
	}


	public void setDate_debut(LocalDateTime date_debut) {
		this.date_debut = date_debut;
	}


	public LocalDateTime getDate_fin() {
		return date_fin;
	}


	public void setDate_fin(LocalDateTime date_fin) {
		this.date_fin = date_fin;
	}


	public Integer getDelai() {
		return delai;
	}


	public void setDelai(Integer delai) {
		this.delai = delai;
	}
}

