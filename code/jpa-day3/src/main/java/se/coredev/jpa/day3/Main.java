package se.coredev.jpa.day3;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("PersistenceUnit");

	public static void main(String[] args) {

		EntityManager manager = FACTORY.createEntityManager();
		Role role;
		try {
			role = manager.createQuery("SELECT r FROM Role r JOIN FETCH r.users WHERE r.name = 'admin'", Role.class).getSingleResult();
		}
		finally {
			manager.close();
		}
		role.getUsers().forEach(u -> System.out.println(u.getUsername()));
		
//		try {
//			manager = FACTORY.createEntityManager();
//			manager.getTransaction().begin();
//			user = manager.merge(user);
//
//			Metadata metadata = new Metadata("meta");
//			user.setMetadata(metadata);
//
//			manager.persist(metadata);
//			manager.getTransaction().commit();
//		}
//		finally {
//			manager.close();
//		}

	}

}







