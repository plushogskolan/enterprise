package se.coredev.sdj;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.coredev.sdj.repository.EmployeeRepository;

public final class Main {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.scan("se.coredev.sdj");
			context.refresh();

//			EmployeeService employeeService = context.getBean(EmployeeService.class);
//			Employee employee = employeeService.createEmployee("Darth", "Vader");
//			System.out.println(employee);
			
			EmployeeRepository repository = context.getBean(EmployeeRepository.class);
//			repository.findByFirstNameAndLastName("Yoda", "Jones").forEach(System.out::println);
//			repository.findByFirstNameContaining("A").forEach(System.out::println);
//			System.out.println("Count: " + repository.countByLastName("Jones"));
			repository.removeByLastName("Jones").forEach(System.out::println);
			
			
			// Employee employee = repository.save(new Employee("Luke",
			// "Skywalker"));
			// System.out.println(employee);
			// employee.setLastName("Walker");
			//
			// employee = repository.save(employee);
			// System.out.println(employee);

			// System.out.println("Number of employees:" + repository.count());

		}
	}
}
