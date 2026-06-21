package com.giri.physioApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giri.physioApp.models.PatientProfile;
import com.giri.physioApp.models.User;

public interface PatientProfileRepo extends JpaRepository<PatientProfile, Long> {
	

	Optional<PatientProfile> findByUser(User user);

}
