package banque_pack;

import java.util.Set;

import javax.persistence.*;

//indique que la classe doit être  gérée par JPA
@Entity
public class Banque {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "nom", nullable = false) //associer le champs nom à une colonne de la table
	private String nom;

	@OneToMany(mappedBy="banque")
	private Set<Client> clients; // référence vers les clients
		
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

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
}
