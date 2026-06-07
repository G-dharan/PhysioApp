package com.giri.physioApp.services;

import com.giri.physioApp.dtos.AddExerciseRequestDto;
import com.giri.physioApp.dtos.AddExerciseResponseDto;
import com.giri.physioApp.exceptions.ExerciseNotFoundException;

public interface ExerciseService {
	
	public AddExerciseResponseDto addExercise(AddExerciseRequestDto addExerciseRequestDto);

	public AddExerciseResponseDto getExercise(String name) throws ExerciseNotFoundException;

}
