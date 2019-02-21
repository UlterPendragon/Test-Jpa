package banque_pack;

import java.util.Set;

import javax.persistence.*;


//indique que la classe doit être  gérée par JPA
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "numero", nullable = false) //associer le champs numero de compte à une colonne de la table
	private String numero;	
	@Column(name = "solde", nullable = false) //associer le champs solde de compte à une colonne de la table
	private double solde;	

	@OneToMany(mappedBy="compte")
	private Set<Operation> operations; // référence vers les operations

	@ManyToMany(mappedBy="comptes")
	private Set<Client> clients;

	// constructeur
	
		public Compte() {
			
		}
		
		
	// getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
}
