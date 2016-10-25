package se.coredev.jpa.extreme.repository;

import java.util.List;
import static java.util.function.Function.identity;
import javax.persistence.EntityManagerFactory;

import se.coredev.jpa.extreme.model.Employee;

public final class JpaEmployeeRepository extends AbstractJpaRepository<Employee> implements EmployeeRepository {

	public JpaEmployeeRepository(EntityManagerFactory factory) {
		super(factory, Employee.class);
	}

	@Override
	public List<Employee> getAll() {
		return query("Employee.GetAll", identity());
	}

	@Override
	public Employee getByNumber(String number) {
		return querySingle("Employee.GetByEmployeeNumber", query -> query.setParameter("number", number));
	}

}
