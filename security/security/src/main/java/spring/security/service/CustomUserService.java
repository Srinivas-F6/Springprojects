package spring.security.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.security.model.Employee;
import spring.security.repository.UserRepository;


@Service
public class CustomUserService implements UserDetailsService{
   private final UserRepository repo;
   
   public CustomUserService(UserRepository repo) {
	   this.repo = repo;
   }
   
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
	   
	   Optional<Employee> details = repo.findByName(username);
	   
	   if(details.isEmpty()) {
		   throw new UsernameNotFoundException("User not found with name: " + username);
	   }
	   return new UsersPrinciple(details.get());
	   
	   
   }
}
