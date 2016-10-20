package se.coredev.maven.lab;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class Main {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("PersistenceUnit");

	public static void main(String[] args) {
		
		EntityManager manager = FACTORY.createEntityManager();
		
		List<Employee> employees = manager.createQuery("select e from Employee e where e.username = :username", Employee.class)
										  .setParameter("username", "lusk")
										  .getResultList();
		employees.forEach(System.out::println);
		
		
//		Computer computer = new Computer("MacBook Pro");
//		Employee employee1 = new Employee("Leia", "Skywalker", "lesk", new Address("street", "postal", "zip"), computer);
//		Employee employee2 = new Employee("Luke", "Skywalker", "lusk", new Address("street", "postal", "zip"), computer);

//		manager.getTransaction().begin();
//		manager.persist(employee1);
//		manager.persist(employee2);
//		manager.persist(computer);
//		manager.getTransaction().commit();
//		Computer computer = null;
//		try {
//			computer = manager.find(Computer.class, 3L);
//		} finally {
//			manager.close();
//		}
//		
//		System.out.println("Type:" + computer.getType());
//		System.out.println("Number of users:" + computer.getEmployees().size());
	}

}









