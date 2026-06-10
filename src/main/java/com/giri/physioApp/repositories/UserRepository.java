package com.giri.physioApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.giri.physioApp.models.PatientProfile;
import com.giri.physioApp.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select p from PatientProfile p where p.user.id = :userId")
	Optional<PatientProfile> findByPatienProfileId(Long userId);
	

}
