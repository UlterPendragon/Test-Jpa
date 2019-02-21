package banque_pack;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


public class Main {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Banque bnpParibas = new Banque();
		bnpParibas.setNom("BNP paribas");
		
		Set<Client> listclient = new HashSet<Client>();
		Client clientjack = new Client();
		clientjack.setNom("Gylenhall");
		clientjack.setPrenom("Jack");
		clientjack.setBanque(bnpParibas);
		clientjack.setDateNaissance(LocalDate.of(1987, 04, 17));
		listclient.add(clientjack);
		
		Adresse adressejack = new Adresse();
		adressejack.setNumero(5);
		adressejack.setRue("rue de la Vilette");
		adressejack.setCodePostal(69003);
		adressejack.setVille("Lyon");
		clientjack.setAdresse(adressejack);
		
		Set<Compte> listcompte = new HashSet<Compte>();
		Compte comptejack = new Compte();
		comptejack.setNumero("02548745235");
		comptejack.setSolde(150987.25);
		listcompte.add(comptejack);
		clientjack.setComptes(listcompte);
		
		Set<Operation> listoperation = new HashSet<Operation>();
		Operation opecompte = new Operation();
		opecompte.setMontant(1980.20);
		opecompte.setMotif("virement du salaire");
		opecompte.setCompte(bnpParibas);
		opecompte.setDate(LocalDateTime.now());
		comptejack.setOperations(listoperation);
				
		bnpParibas.setClients(listclient);
	
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		em.persist(bnpParibas);
		em.persist(clientjack);
		em.persist(comptejack);
		em.persist(opecompte);
		
		transaction.commit();
	    
	   
	    Client blibli = (Client) em.find(Client.class, 2);
	    Banque bloblo = (Banque) em.find(Banque.class, 1);
	    
	    System.out.println("client " + blibli.getPrenom() + " " + blibli.getNom() + " banque " + bloblo.getNom());
	    
	    
	    
	    LivretA livreta = new LivretA();
	    livreta.setTaux(2.6);
	    livreta.setClients(listclient);
	    livreta.setSolde(2564.05);
	    livreta.setOperations(listoperation);
	    livreta.setNumero("055005");
	    
	    AssuranceVie assurvie = new AssuranceVie();
	    assurvie.setTaux(3.6);
	    assurvie.setDateFin(LocalDate.of(2055, 11, 25));
	    assurvie.setClients(listclient);
	    assurvie.setNumero("025487456");
	    assurvie.setSolde(520000.02);
	    assurvie.setOperations(listoperation);
	   
	    
	    
	    Virement virement = new Virement();
	    virement.setBeneficiaire("Jean-Charles de la villardière");
	    virement.setCompte(bnpParibas);
	    virement.setDate(LocalDateTime.of(2019, 02, 22, 17, 21));
	    virement.setMontant(5000);
	    virement.setMotif("parce que c'est cool");
	  
	   	    
	    transaction.begin();
		
	    em.persist(livreta);
		em.persist(assurvie);
		em.persist(virement);

		
		transaction.commit();
		
		AssuranceVie blublu = (AssuranceVie) em.find(AssuranceVie.class, 6);
	    LivretA  blybly = (LivretA ) em.find(LivretA .class, 5);
	    Virement bloublou = (Virement) em.find(Virement.class, 7);
	    
	    System.out.println("Assurance Vie n°: " + blublu.getNumero() + " dont le solde est de " + blublu.getSolde() + " euros " + " Livret A dont le taux est de : " 
	    + blybly.getTaux() + " le beneficiaire du virement est : " + bloublou.getBeneficiaire());
	    
	    
		
	}

}
