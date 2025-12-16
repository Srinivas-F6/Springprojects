package spring.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.security.model.Employee;
import spring.security.service.EmpService;

@RestController
public class EmployeeController {
   
	public EmpService service;
	
	public EmployeeController(EmpService service) {
		this.service = service;
	}
	
	
	@PostMapping("/post/data")
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp) {
		boolean add = service.addEmployee(emp);
		if(add) {
			return ResponseEntity.ok(emp);
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Already Exists");
	}
	
	@GetMapping("/get/employees")
	public ResponseEntity<?> getEmployees(){
		Optional<List<Employee>> data = service.getEmployees();
	    if(data.isPresent()) {
	    	return ResponseEntity.ok(data.get());
	    }
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data Not found");
	}
}
