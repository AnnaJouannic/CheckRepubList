package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPA_test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("checkrepublist");

		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
