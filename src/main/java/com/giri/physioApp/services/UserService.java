package com.giri.physioApp.services;

import org.springframework.stereotype.Service;

import com.giri.physioApp.dtos.CreatePatientRequestDto;
import com.giri.physioApp.dtos.CreateUserRequestDto;
import com.giri.physioApp.dtos.CreateUserResponseDto;
import com.giri.physioApp.models.User;
import com.giri.physioApp.repositories.UserRepository;

@Service
public class UserService implements IUserService {
	
	private UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public CreateUserResponseDto createUser(CreateUserRequestDto createUserRequestDto) {
		User inputUser = createUserRequestDto.toUser();
		User createdUser = userRepo.save(inputUser);
		return CreateUserResponseDto.from(createdUser);
	}
	

	@Override
	public CreateUserResponseDto createPatient(CreatePatientRequestDto createPatientRequestDto) {
		// TODO Auto-generated method stub
		User inputUser = createPatientRequestDto.toUser();
		createPatientRequestDto.toPatientProfile(inputUser);
		User createdUser = userRepo.save(inputUser);
		return CreateUserResponseDto.from(createdUser);
	}
}
