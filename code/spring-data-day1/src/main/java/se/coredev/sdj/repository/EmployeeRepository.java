package se.coredev.sdj.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import se.coredev.sdj.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	// firstName
	List<Employee> findByFirstName(String firstName);

	List<Employee> findByFirstNameContaining(String value);

	List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

	Long countByLastName(String lastName);

	@Transactional
	List<Employee> removeByLastName(String lastName);

}
