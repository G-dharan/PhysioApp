package com.giri.physioApp.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.giri.physioApp.dtos.CreatePatientRequestDto;
import com.giri.physioApp.dtos.CreateUserResponseDto;
import com.giri.physioApp.exceptions.ResourceAlreadyExistsException;
import com.giri.physioApp.models.PatientProfile;
import com.giri.physioApp.models.User;
import com.giri.physioApp.repositories.PatientProfileRepo;

@Service
public class PatienServiceImplementation implements IPatientService {

	private PatientProfileRepo patientProfileRepo;
	private UserService userService;
	
	public PatienServiceImplementation(PatientProfileRepo patientProfileRepo, UserService userService) {
		this.patientProfileRepo = patientProfileRepo;
		this.userService = userService;
	}
	
	@Override
	public CreateUserResponseDto createPatient(CreatePatientRequestDto createPatientRequestDto) {
		
		//check whether user exists
		User inputUser = createPatientRequestDto.toUser();
		User user = inputUser;
		Optional<User> searchedUser = userService.findUserByNameAndPhone(inputUser.getName(), inputUser.getPhone());
		if(searchedUser.isPresent()) {
			//check whether patient exists
			Optional<PatientProfile> searchedPatientProfile = patientProfileRepo.findByUser(searchedUser.get());
			if(searchedPatientProfile.isPresent()) {
				throw new ResourceAlreadyExistsException("Patient with name " + inputUser.getName() + " and phone " + inputUser.getPhone() + " already exists");
			} else {
				//assign the existing user to create the patient profile
				user = searchedUser.get();
			}
		} 
		else {
			//create user if doesn't exist
			user = userService.createUserEntity(createPatientRequestDto.getName(), createPatientRequestDto.getPhone(), createPatientRequestDto.getAddress());
		}
		PatientProfile patientProfile = createPatientRequestDto.toPatientProfile(user);
		PatientProfile savedpatientProfile = patientProfileRepo.save(patientProfile);
		return CreateUserResponseDto.from(savedpatientProfile.getUser());
	}
}
