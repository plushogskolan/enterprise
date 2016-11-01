package se.coredev.sdj;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import se.coredev.sdj.model.Address;
import se.coredev.sdj.model.Employee;
import se.coredev.sdj.repository.EmployeeRepository;
import se.coredev.sdj.service.EmployeeService;

public final class Main {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.scan("se.coredev.sdj");
			context.refresh();
			
//			Employee employee1 = new Employee("Luke", "Skywalker", "1001", new Address("street1", "postal1", "zip1"));
//			Employee employee2 = new Employee("Leia", "Skywalker", "1001", new Address("street2", "postal2", "zip2"));
//			
//			EmployeeService  service = context.getBean(EmployeeService.class);
//			service.addEmployee(employee1);
//			service.addEmployee(employee2);
			
			// Paging
			EmployeeRepository repository = context.getBean(EmployeeRepository.class);
			Page<Employee> result = repository.findAll(new PageRequest(0, 5));
			result.forEach(System.out::println);
			
		}

	}

}
