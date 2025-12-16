package Jwt.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Jwt.springjwt.model.Viewer;

@Repository
public interface ViewerRepository extends JpaRepository<Viewer, Integer> {
	boolean existsByEmail(String email);
    Optional<Viewer> findByEmail(String email);
}
