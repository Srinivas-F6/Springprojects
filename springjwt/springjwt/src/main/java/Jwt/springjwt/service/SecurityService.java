package Jwt.springjwt.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Jwt.springjwt.model.UserPrinciple;
import Jwt.springjwt.model.Viewer;
import Jwt.springjwt.repository.ViewerRepository;

@Service
public class SecurityService implements UserDetailsService {

    private final ViewerRepository repository;

    public SecurityService(ViewerRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Viewer> view = repository.findByEmail(username);
        if (view.isPresent()) {
            return new UserPrinciple(view.get());
        }
        throw new UsernameNotFoundException("User Not Found with email: " + username);
    }
}
