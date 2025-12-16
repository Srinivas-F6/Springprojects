package spring.security.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import spring.security.model.Employee;


public class UsersPrinciple implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8234081966513371973L;
	private final Employee employee;

    public UsersPrinciple(Employee employee) {
        this.employee = employee;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Assuming Employee has a field: private String role;
        return Collections.singleton(new SimpleGrantedAuthority(employee.getRole()));
    }

    @Override
    public String getPassword() {
        return employee.getPassword();  // return encoded password
    }

    @Override
    public String getUsername() {
        return employee.getName();  // login using name as username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // you can modify if needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // can change if Employee has locked status
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // can change if needed
    }

    @Override
    public boolean isEnabled() {
        return true; // can connect to "isActive" field in Employee
    }
}
