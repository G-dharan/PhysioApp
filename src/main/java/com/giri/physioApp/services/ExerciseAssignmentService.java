package com.giri.physioApp.services;


import com.giri.physioApp.dtos.PatientExerciseAssignmentRequestDto;
import com.giri.physioApp.dtos.PatientExerciseAssignmentResponseDto;


public interface ExerciseAssignmentService {

	PatientExerciseAssignmentResponseDto updatePatientExercise(PatientExerciseAssignmentRequestDto assignmentRequestDto);
	PatientExerciseAssignmentResponseDto addExerciseToPatient(PatientExerciseAssignmentRequestDto assignmentRequestDto);
	
	

}
