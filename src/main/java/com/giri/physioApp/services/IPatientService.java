package com.giri.physioApp.services;

import com.giri.physioApp.dtos.CreatePatientRequestDto;
import com.giri.physioApp.dtos.CreateUserResponseDto;

public interface IPatientService {


	public CreateUserResponseDto createPatient(CreatePatientRequestDto createPatientRequestDto);
}
