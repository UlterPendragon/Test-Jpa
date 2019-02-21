package banque_pack;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

//indique que la classe doit être  gérée par JPA
@Entity
public class AssuranceVie extends Compte {
	
	@Column(name = "taux") //associer le champs taux du livretA à une colonne de la table
	private double taux;	
	
	@Column(name = "dateFin") //associer le champs dateFin de l'assurance vie à une colonne de la table
	private LocalDate dateFin;

	
	//getters and setters
	
	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}	

}
