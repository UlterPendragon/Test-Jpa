package banque_pack;

import javax.persistence.Column;
import javax.persistence.Entity;

//indique que la classe doit être  gérée par JPA
@Entity
public class LivretA extends Compte {

	@Column(name = "taux") //associer le champs taux du livretA à une colonne de la table
	private double taux;

	
	//getters and setters
	
	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}	

}
