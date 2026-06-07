package com.giri.physioApp.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.giri.physioApp.dtos.PatientExerciseAssignmentRequestDto;
import com.giri.physioApp.dtos.PatientExerciseAssignmentResponseDto;
import com.giri.physioApp.models.Exercise;
import com.giri.physioApp.models.PatientExercise;
import com.giri.physioApp.models.User;
import com.giri.physioApp.repositories.ExerciseRepo;
import com.giri.physioApp.repositories.PatientExerciseRepo;
import com.giri.physioApp.repositories.UserRepo;

@Service
public class ExerciseAssignmentServiceImpl implements ExerciseAssignmentService{
	
	private PatientExerciseRepo patientExerciseRepo;
	private ExerciseRepo exerciseRepo;
	private UserRepo userRepo;
	
	public ExerciseAssignmentServiceImpl(PatientExerciseRepo patientExerciseRepo) {
		this.patientExerciseRepo = patientExerciseRepo;
	}

	@Override
	public PatientExerciseAssignmentResponseDto addExerciseToPatient(PatientExerciseAssignmentRequestDto assignmentRequestDto) {
		PatientExercise patientExercise= assignmentRequestDto.toPatientExercise();
		PatientExercise savedPatientExercise = patientExerciseRepo.save(patientExercise);
		return PatientExerciseAssignmentResponseDto.from(savedPatientExercise);
	}
	
	@Override
	public PatientExerciseAssignmentResponseDto updatePatientExercise(
			PatientExerciseAssignmentRequestDto assignmentRequestDto) {
		PatientExercise patientExercise= patientExerciseRepo.findByPatientIdAndExerciseId(
				assignmentRequestDto.getExerciseId(),
				assignmentRequestDto.getPatientId()
				);
		
		
		return null;
	}
	
	

}
