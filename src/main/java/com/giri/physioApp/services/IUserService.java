package com.giri.physioApp.services;

import com.giri.physioApp.dtos.CreatePatientRequestDto;
import com.giri.physioApp.dtos.CreatePatientResponseDto;
import com.giri.physioApp.dtos.CreateUserRequestDto;
import com.giri.physioApp.dtos.CreateUserResponseDto;

public interface IUserService {

	public CreateUserResponseDto createUser(CreateUserRequestDto createUserRequestDto);

	public CreateUserResponseDto createPatient(CreatePatientRequestDto createPatientRequestDto);
}
