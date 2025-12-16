package spring.security.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.security.model.Employee;


@Repository
public interface UserRepository extends JpaRepository<Employee, Integer>{
	
	Optional<Employee> findByName(String username);
   
}
