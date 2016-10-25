package se.coredev.jpa.extreme;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.coredev.jpa.extreme.model.Employee;
import se.coredev.jpa.extreme.model.User;
import se.coredev.jpa.extreme.repository.EmployeeRepository;
import se.coredev.jpa.extreme.repository.JpaEmployeeRepository;
import se.coredev.jpa.extreme.repository.JpaUserRepository;
import se.coredev.jpa.extreme.repository.UserRepository;

public final class Main {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("PersistenceUnit");
	
	public static void main(String[] args) {
		EmployeeRepository employeeRepository = new JpaEmployeeRepository(FACTORY);
		
		employeeRepository.saveOrUpdate(new Employee("Luke", "Skywalker", "1001"));
		employeeRepository.saveOrUpdate(new Employee("Leia", "Skywalker", "2002"));
		employeeRepository.getAll().forEach(e -> System.out.println(e.getNumber()));

		UserRepository userRepository = new JpaUserRepository(FACTORY);
		userRepository.saveOrUpdate(new User("masteranca"));
		
	}
}
