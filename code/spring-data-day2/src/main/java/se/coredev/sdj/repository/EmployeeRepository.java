package se.coredev.sdj.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import se.coredev.sdj.model.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

	Slice<Employee> findByLastNameContains(String lastName, Pageable pageable);
	
	@Query("select e from #{#entityName} e where e.number = :number")
	List<Employee> byNumber(@Param("number") String xyz);
	
}
