package se.coredev.maven.lab;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class Main {

	private static final EntityManagerFactory FACTORY = 
			Persistence.createEntityManagerFactory("PersistenceUnit");
	
	public static void main(String[] args) {
		
		Employee employee = new Employee("Luke", "Skywalker");
		System.out.println(employee);
		
		EntityManager manager = FACTORY.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(employee);
		manager.getTransaction().commit();
		
		System.out.println(employee);

		manager = FACTORY.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(employee);
		manager.getTransaction().commit();
		
	}
	
}
