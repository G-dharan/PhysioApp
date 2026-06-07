package com.giri.physioApp.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giri.physioApp.dtos.CreatePatientRequestDto;
import com.giri.physioApp.dtos.CreatePatientResponseDto;
import com.giri.physioApp.dtos.CreateUserRequestDto;
import com.giri.physioApp.dtos.CreateUserResponseDto;
import com.giri.physioApp.services.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private IUserService userService;
	
	public UserController(IUserService userService) {
		this.userService = userService;
	}

	@PostMapping("/createUser")
	public CreateUserResponseDto createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
		CreateUserResponseDto createUserResponseDto = userService.createUser(createUserRequestDto);
		return createUserResponseDto;
		
	}
	
	@PostMapping("/createPatient")
	public CreateUserResponseDto createPatient(@RequestBody CreatePatientRequestDto createPatientRequestDto) {
		CreateUserResponseDto createUserResponseDto = userService.createPatient(createPatientRequestDto);
		return createUserResponseDto;
		
	}
	
}
