package com.example.registrationForm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.registrationForm.model.LogIn;
import com.example.registrationForm.model.Registration;
import com.example.registrationForm.service.ServiceRepo;

@RestController
@CrossOrigin("*")
public class RegistrationController {
   private ServiceRepo service;
   @Autowired
   public RegistrationController(ServiceRepo service) {
	  this.service = service;  
   }
	   
   @PostMapping("/post/form")
   public ResponseEntity<?> postForm(@RequestBody Registration r){
	   Registration val = service.postForm(r);
	   return ResponseEntity.status(HttpStatus.CREATED).body(val);
   }
   
   @PostMapping("/login")	
   public ResponseEntity<?> logIn(@RequestBody LogIn login){
	   try {
		   Registration value = service.logIn(login.getEmail(),login.getPassword());
		   return ResponseEntity.ok(value);  
	   }
	   catch(Exception e) {
		   return ResponseEntity.badRequest().body(e.getMessage());
	   }
	   
   }
}
