package banque_pack;

import javax.persistence.Column;
import javax.persistence.Entity;

//indique que la classe doit �tre  g�r�e par JPA
@Entity
public class Virement extends Operation {

	@Column(name = "beneficiaire") //associer le champs beneficaire du virement � une colonne de la table
	private String beneficiaire;
	
	
	//getters and setters

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}	
	
	
	
}
