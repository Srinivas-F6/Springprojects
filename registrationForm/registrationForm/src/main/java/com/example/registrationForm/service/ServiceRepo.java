package com.example.registrationForm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registrationForm.model.Registration;
import com.example.registrationForm.repository.RegistrationRepository;

@Service
public class ServiceRepo {
	
	private RegistrationRepository repository;
	@Autowired
	
	public ServiceRepo(RegistrationRepository repository) {
		this.repository = repository;
	}
   
	public Registration postForm(Registration r) {
		return repository.save(r);
	}
	
	
	public Registration logIn(String email, String password) {
		  Optional<Registration> val = repository.findByEmail(email);
		  password = password.trim();
		  if(val.isPresent()) {
			  Registration user = val.get();
			  if(user.getPassword().equals(password)) {
				  return user;
			  }
			  else {
				  throw new RuntimeException("Enter the Correct Password");
			  }
		  }
		  else {
			  throw new RuntimeException("Email not found");
		  }
	}
	
}
