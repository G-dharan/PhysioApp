package com.giri.physioApp.services;

import org.springframework.stereotype.Service;

import com.giri.physioApp.dtos.PatientExerciseAssignmentRequestDto;
import com.giri.physioApp.dtos.PatientExerciseAssignmentResponseDto;

@Service
public interface ExerciseAssignmentService {

	PatientExerciseAssignmentResponseDto updatePatientExercise(PatientExerciseAssignmentRequestDto assignmentRequestDto);
	PatientExerciseAssignmentResponseDto addExerciseToPatient(PatientExerciseAssignmentRequestDto assignmentRequestDto);
	
	

}
