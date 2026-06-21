package com.giri.physioApp.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.giri.physioApp.dtos.CreateUserRequestDto;
import com.giri.physioApp.dtos.CreateUserResponseDto;
import com.giri.physioApp.models.Role;
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
		userRepo.findByNameAndPhone(createUserRequestDto.getName(), createUserRequestDto.getPhone()).ifPresent(user -> {
			throw new RuntimeException("User with name " + user.getName() + " and phone " + user.getPhone() + " already exists");
		});
		User dbUser = userRepo.save(inputUser);
		return CreateUserResponseDto.from(dbUser);
	}
	
	public User createUserEntity(String name, long phone, String Address) {
		User inputUser = CreateUserRequestDto.toUser(name, phone, Address);
		return userRepo.save(inputUser);
	}

	public Optional<User> findUserByNameAndPhone(String name, long phone) {
		// TODO Auto-generated method stub
		return userRepo.findByNameAndPhone(name, phone);
	}
	


}
