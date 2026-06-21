package com.giri.physioApp.services;

import java.util.Optional;

import com.giri.physioApp.dtos.CreatePatientRequestDto;
import com.giri.physioApp.dtos.CreatePatientResponseDto;
import com.giri.physioApp.dtos.CreateUserRequestDto;
import com.giri.physioApp.dtos.CreateUserResponseDto;
import com.giri.physioApp.models.User;

public interface IUserService {

	public CreateUserResponseDto createUser(CreateUserRequestDto createUserRequestDto);
	
	public Optional<User> findUserByNameAndPhone(String name, long phone);

}
