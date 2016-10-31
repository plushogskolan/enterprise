package se.coredev.sdj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.coredev.sdj.model.Employee;
import se.coredev.sdj.repository.EmployeeRepository;

@Service
public final class EmployeeService {

	@Autowired
	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee createEmployee(String firstName, String lastName) {
		return employeeRepository.save(new Employee(firstName, lastName));
	}

}
