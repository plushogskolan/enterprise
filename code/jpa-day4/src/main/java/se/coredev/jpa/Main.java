package se.coredev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public final class Main {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("PersistenceUnit");
	
	
	public static void main1(String[] args) {

		Employee employee = new Employee("Luke", "Skywalker", "1001");
		ParkingSpot parkingSpot = new ParkingSpot("A-54");
		employee.setParkingSpot(parkingSpot);

		persist(employee, parkingSpot);

		employee = find(1L, Employee.class);

		remove(employee);

		System.out.printf("%s, %s, %s\n", employee.getEmployeeNumber(), employee.getFirstName(), employee.getLastName());
		System.out.println("----------------- Done --------------");
	}
	
	public static void main2(String[] args) {
		Employee employee1 = new Employee("Luke", "Skywalker", "1001");
		Employee employee2 = new Employee("Leia", "Skywalker", "2002");
		
		persist(employee1, employee2);
		
		EntityManager manager = FACTORY.createEntityManager();
		Employee employee = manager.createNamedQuery("Employee.GetByEmployeeNumber", Employee.class)
								   .setParameter("employeeNumber", "1001")
								   .getSingleResult();
		
		System.out.printf("%s, %s, %s\n", employee.getEmployeeNumber(), employee.getFirstName(), employee.getLastName());
	}
	
	public static void main(String[] args) {
		
		Employee employee = new Employee("Luke", "Skywalker",  "1001");
		employee.addNote(1, "Note 1");
		employee.addNote(2, "Note 2");
		employee.addNote(3, "Note 3");
		
		persist(employee);
	}

	private static void remove(Employee employee) {
		EntityManager manager = FACTORY.createEntityManager();
		try {
			manager.getTransaction().begin();
			employee = manager.find(Employee.class, employee.getId());
			manager.remove(employee.getParkingSpot());
			employee.setParkingSpot(null);
			manager.getTransaction().commit();
		}
		finally {
			manager.close();
		}
	}

	private static <T> T find(Long id, Class<T> entityClass) {
		EntityManager manager = FACTORY.createEntityManager();
		return manager.find(entityClass, id);
	}

	private static void persist(Object... entities) {

		EntityManager manager = FACTORY.createEntityManager();

		try {
			manager.getTransaction().begin();
			for (Object entity : entities) {
				manager.persist(entity);
			}
			manager.getTransaction().commit();
		}
		finally {
			manager.close();
		}
	}
}
