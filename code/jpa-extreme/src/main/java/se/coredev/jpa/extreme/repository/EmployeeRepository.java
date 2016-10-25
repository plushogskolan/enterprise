package se.coredev.jpa.extreme.repository;

import java.util.List;

import se.coredev.jpa.extreme.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee>{

	List<Employee> getAll();
	Employee getByNumber(String number);
	
}
