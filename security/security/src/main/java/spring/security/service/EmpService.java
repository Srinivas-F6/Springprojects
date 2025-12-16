package spring.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import spring.security.model.Employee;
import spring.security.repository.EmployeeRepository;

@Service
public class EmpService {
	
	public EmployeeRepository repo;
	
	public EmpService(EmployeeRepository repo) {
		this.repo = repo;
	}
	
	public boolean addEmployee(Employee emp) {
		if(repo.existsByemail(emp.getEmail()) && repo.existsByphnNum(emp.getPhnNum())) {
			return false;
		}
		emp.setPassword(new BCryptPasswordEncoder().encode(emp.getPassword()));
		repo.save(emp);
		return true;
	}
	
	
	public Optional<List<Employee>> getEmployees(){
		List<Employee> employees = repo.findAll();
		return employees.isEmpty() ? Optional.empty() : Optional.of(employees);
	}
}
