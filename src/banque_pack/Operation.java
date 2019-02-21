package banque_pack;

import java.time.*;
import javax.persistence.*;

//indique que la classe doit être  gérée par JPA
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name = "date", nullable = false) //associer le champs nom à une colonne de la table
	private LocalDateTime date;
	@Column(name = "montant", nullable = false)   // associer le champs montant de l'opération à une colonne de la table
	private double montant;
	@Column(name ="motif") // associer le champs motif d'opération sur compte à une colonne de la table
	private String motif;

	@ManyToOne
	@JoinColumn(name="id_compte")
	private Banque compte;
	
	
	// constructeur
	
	public Operation() {
		
	}	
	
	// getters and setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Banque getCompte() {
		return compte;
	}

	public void setCompte(Banque compte) {
		this.compte = compte;
	} 




}
