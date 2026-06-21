package com.giri.physioApp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giri.physioApp.dtos.AddExerciseRequestDto;
import com.giri.physioApp.dtos.AddExerciseResponseDto;
import com.giri.physioApp.dtos.PatientExerciseAssignmentRequestDto;
import com.giri.physioApp.dtos.PatientExerciseAssignmentResponseDto;
import com.giri.physioApp.exceptions.ExerciseNotFoundException;
import com.giri.physioApp.services.ExerciseAssignmentService;
import com.giri.physioApp.services.ExerciseService;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
	
	private ExerciseService exerciseService;

	public ExerciseController(ExerciseService exerciseService, ExerciseAssignmentService exerciseAssignmentService) {
		this.exerciseService = exerciseService;
	}

	@PostMapping
	public ResponseEntity<AddExerciseResponseDto> addExercise(@RequestBody AddExerciseRequestDto addExerciseRequestDto) {
		AddExerciseResponseDto addExerciseResponseDto = exerciseService.addExercise(addExerciseRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(addExerciseResponseDto);
	}

	@GetMapping("/{name}")
	// using pathvariable enables sharing of the url to the user directly
	public ResponseEntity<AddExerciseResponseDto> getExercise(@PathVariable("name") String name) throws ExerciseNotFoundException {
		AddExerciseResponseDto addExerciseResponseDto = exerciseService.getExercise(name);
		return ResponseEntity.status(HttpStatus.CREATED).body(addExerciseResponseDto);
	}



}
