package checkrepublist.group;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
