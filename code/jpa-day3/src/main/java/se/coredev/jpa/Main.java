package se.coredev.jpa;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class Main {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("PersistenceUnit");

	public static void main(String[] args) {

		EntityManager manager = FACTORY.createEntityManager();
		try {
			manager.getTransaction().begin();
			
			Project project1 = new Project("UI project");
			Project project2 = new Project("Backend project");
			Collection<Project> projects = Arrays.asList(project1, project2);
			
			ParkingSpot parkingSpot1 = new ParkingSpot("A-54");
			ParkingSpot parkingSpot2 = new ParkingSpot("A-55");
			Department department = new Department("Dev");
			Employee employee1 = new Employee("Luke", "Skywalker", "1001", department, parkingSpot1, projects);
			Employee employee2 = new Employee("Leia", "Skywalker", "2002", department, parkingSpot2, projects);
			
			manager.persist(project1);
			manager.persist(project2);
			manager.persist(parkingSpot1);
			manager.persist(parkingSpot2);
			manager.persist(department);
			manager.persist(employee1);
			manager.persist(employee2);
			
			manager.getTransaction().commit();
			
		}
		finally {
			manager.close();
		}
	}

}
