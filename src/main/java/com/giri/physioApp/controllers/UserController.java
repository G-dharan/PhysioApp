package com.giri.physioApp.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giri.physioApp.dtos.CreatePatientRequestDto;
import com.giri.physioApp.dtos.CreateUserRequestDto;
import com.giri.physioApp.dtos.CreateUserResponseDto;
import com.giri.physioApp.services.IPatientService;
import com.giri.physioApp.services.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private IUserService userService;
	private IPatientService patientService;
	
	public UserController(IUserService userService, IPatientService patientService) {
		this.userService = userService;
		this.patientService = patientService;
	}

	@PostMapping("/createUser")
	public CreateUserResponseDto createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
		CreateUserResponseDto createUserResponseDto = userService.createUser(createUserRequestDto);
		return createUserResponseDto;
		
	}
	
	@PostMapping("/createPatient")
	public CreateUserResponseDto createPatient(@RequestBody CreatePatientRequestDto createPatientRequestDto) {
		CreateUserResponseDto createUserResponseDto = patientService.createPatient(createPatientRequestDto);
		return createUserResponseDto;
		
	}
	
}
