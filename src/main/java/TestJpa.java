package main.java;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class TestJpa {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = entityManagerFactory.createEntityManager();

		// extraction d'un livre en fonction de son id
		Livre h = em.find(Livre.class, 1);

		// extraction d'un emprunt en fonction de son id
		Emprunt emp = em.find(Emprunt.class, 1);

		// extration d'un emprunt en fonction de son id
		Client cli = em.find(Client.class, 1);	


		if (h != null){
			// vérification	
			System.out.println("id numéro " + h.getId());
		}
		Query query = em.createQuery("SELECT h from Livre h where h.titre ='Germinal'");
		Livre h1 = (Livre) query.getResultList().get(0);

		if (h != null){
			// vérification
			System.out.println("id " + h.getId() + " correspond au titre " + h.getTitre() + " de l'auteur " + h.getAuteur());
		}


		TypedQuery<Emprunt> reqemplivre = em.createQuery("select e from Emprunt e where e.id = 2", Emprunt.class);
		List<Emprunt> resultreqemplivre = reqemplivre.getResultList();
		for(Emprunt f : resultreqemplivre){
			List<Livre> bibliotheque = f.getLivres();
			for(Livre l : bibliotheque)
		System.out.println("l'auteur est " + l.getAuteur() + " et le titre : " + l.getTitre());	
		}
		

		TypedQuery<Client> empruntsdunclient = em.createQuery("select a from Client a where a.id ='1'", Client.class);
		Client resultemprunstdunclient = empruntsdunclient.getSingleResult();
			for(Emprunt f : resultemprunstdunclient.getEmprunts()){
				for(Livre l : f.getLivres()){
					System.out.println(resultemprunstdunclient.getNom() + " a " + resultemprunstdunclient.getEmprunts().size() + " emprunts dont " + l.getTitre() + " de " + l.getAuteur()) ;
					}
				}
		
		
		
	}
}

