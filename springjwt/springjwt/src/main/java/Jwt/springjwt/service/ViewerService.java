package Jwt.springjwt.service;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Jwt.springjwt.model.Viewer;
import Jwt.springjwt.repository.ViewerRepository;

@Service
public class ViewerService {
    private JwtService jwtService;
    private final ViewerRepository repository;
    private final PasswordEncoder passwordEncoder;
    
    private  AuthenticationManager authManager;
    
    
    public ViewerService(ViewerRepository repository, PasswordEncoder passwordEncoder,JwtService jwtService,AuthenticationManager authManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authManager = authManager;
    }

    public boolean registerViewer(Viewer viewer) {
        if (repository.existsByEmail(viewer.getEmail())) {
            return false;
        }

        viewer.setPassword(passwordEncoder.encode(viewer.getPassword()));
        repository.save(viewer);
        return true;
    }

    public Optional<Viewer> getViewerDetails(String email) {
        return repository.findByEmail(email);
    }

	public String verifyLogin(Viewer viewer) {
	    Authentication auth  = authManager.authenticate(new UsernamePasswordAuthenticationToken(viewer.getEmail(),viewer.getPassword()));
	    if(auth.isAuthenticated()) {
	    	return jwtService.generateToken(viewer.getEmail());
	    }
	    return "false";
	}
}








