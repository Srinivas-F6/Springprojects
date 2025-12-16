package com.example.registrationForm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.registrationForm.model.Registration;


@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long> {

	Optional<Registration> findByEmail(String email);

}
