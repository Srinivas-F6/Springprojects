package Jwt.springjwt.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Jwt.springjwt.model.Viewer;
import Jwt.springjwt.service.ViewerService;

@RestController
public class ViewerController {
	
	private ViewerService service;
	public ViewerController(ViewerService service) {
		this.service = service;
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerViewer(@RequestBody Viewer viewer) {
		 boolean added = service.registerViewer(viewer);
		 if(added) {
			 return ResponseEntity.ok(viewer);
		 }
		 return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Already Registered");
	}
    
	@PostMapping("/login")
	public String login(@RequestBody Viewer viewer) {
		return service.verifyLogin(viewer);
	}
	
	
	@GetMapping("/getViewer/{email}")
	public ResponseEntity<?> getViewerDetails(@PathVariable String email){
		Optional<Viewer> view = service.getViewerDetails(email);
		if(view.isPresent()) {
			return ResponseEntity.ok(view.get());
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Mail Not found");
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello, how are you";
	}
}
