package com.giri.physioApp.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.giri.physioApp.dtos.PatientExerciseAssignmentRequestDto;
import com.giri.physioApp.dtos.PatientExerciseAssignmentResponseDto;
import com.giri.physioApp.services.ExerciseAssignmentService;


@RestController
public class ExerciseAssignmentController {
	
	private ExerciseAssignmentService exerciseAssignmentService;
	
	public ExerciseAssignmentController(ExerciseAssignmentService exerciseAssignmentService) {
		this.exerciseAssignmentService = exerciseAssignmentService;
	}

	@PostMapping("/assignExercise")
	public PatientExerciseAssignmentResponseDto patientExerciseAssignment(@RequestBody PatientExerciseAssignmentRequestDto assignmentRequestDto) {
		PatientExerciseAssignmentResponseDto patientExerciseAssignmentResponseDto = exerciseAssignmentService.addExerciseToPatient(assignmentRequestDto);
		return patientExerciseAssignmentResponseDto;
	}
	
//	@deleteMapping("/unassignExercise")
//	public PatientExerciseUnAssignmentResponseDto PatientExerciseUnAssignment(@RequestBody PatientExerciseUnAssignmentRequestDto assignmentRequestDto) {
//		PatientExerciseUnAssignmentResponseDto PatientExerciseUnAssignmentResponseDto = exerciseAssignmentService.addExerciseToPatient(assignmentRequestDto);
//		return PatientExerciseUnAssignmentResponseDto;
//	}
}
