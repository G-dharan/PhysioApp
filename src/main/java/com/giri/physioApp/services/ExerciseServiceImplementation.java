package com.giri.physioApp.services;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.giri.physioApp.dtos.AddExerciseRequestDto;
import com.giri.physioApp.dtos.AddExerciseResponseDto;
import com.giri.physioApp.exceptions.ExerciseNotFoundException;
import com.giri.physioApp.models.Exercise;
import com.giri.physioApp.repositories.ExerciseRepository;

@Service
@Primary
public class ExerciseServiceImplementation implements ExerciseService{
	
	private ExerciseRepository exerciseRepo;
	
	public ExerciseServiceImplementation(ExerciseRepository exerciseRepo) {
		this.exerciseRepo = exerciseRepo;
	}

	public AddExerciseResponseDto addExercise(AddExerciseRequestDto addExerciseRequestDto) {
		Exercise exercise = addExerciseRequestDto.toExercise();
		Exercise savedExercise = exerciseRepo.save(exercise);
		AddExerciseResponseDto addExerciseResponseDto = AddExerciseResponseDto.fromExercise(savedExercise);
		return addExerciseResponseDto;
	}

	@Override
	public AddExerciseResponseDto getExercise(String exerciseName) throws ExerciseNotFoundException {
		Optional<Exercise> optionalExercise = exerciseRepo.getByName(exerciseName);
		
		if( optionalExercise.isEmpty()) {
			throw new ExerciseNotFoundException("Exercise " + exerciseName + " not found");
		}
		Exercise exFromDb = optionalExercise.get();
		AddExerciseResponseDto addExerciseResponseDto = AddExerciseResponseDto.fromExercise(exFromDb);
		return addExerciseResponseDto;
	}
	
	
	
}
