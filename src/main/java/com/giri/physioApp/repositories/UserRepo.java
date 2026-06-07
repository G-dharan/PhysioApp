package com.giri.physioApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giri.physioApp.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
	

}
