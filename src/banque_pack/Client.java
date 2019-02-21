package banque_pack;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

//indique que la classe doit être  gérée par JPA
@Entity
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name = "Nom", nullable = false) //associer le champs nom à une colonne de la table
	private String nom;
	@Column(name = "Prenom", nullable = false)   // associer le champs prenom à une colonne de la table
	private String prenom;
	@Column(name ="dateNaissance") // associer le champs date de naissance à une colonne de la table
	private LocalDate dateNaissance;

	@ManyToOne
	@JoinColumn(name="id_banque")
	private Banque banque; 

	@ManyToMany
	@JoinTable(name="clientTocompte", 
	joinColumns= @JoinColumn(name="ID_client", referencedColumnName="id"),
	inverseJoinColumns= @JoinColumn(name="ID_compte", referencedColumnName="id"))
	private Set<Compte> comptes;

	@Embedded										
	private Adresse adresse;

	// constructeur
	
	public Client() {
		
	}	
	
	// getters and setters
	
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

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
}
