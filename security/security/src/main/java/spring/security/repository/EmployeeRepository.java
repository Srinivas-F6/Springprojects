package spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.security.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	boolean existsByemail(String email);
	
	boolean existsByphnNum(String phnNum);

}


