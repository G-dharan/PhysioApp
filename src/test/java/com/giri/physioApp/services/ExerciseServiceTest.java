package com.giri.physioApp.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.giri.physioApp.dtos.AddExerciseRequestDto;
import com.giri.physioApp.dtos.AddExerciseResponseDto;
import com.giri.physioApp.models.Exercise;
import com.giri.physioApp.models.MediaType;
import com.giri.physioApp.repositories.ExerciseRepository;

@ExtendWith(MockitoExtension.class)
public class ExerciseServiceTest {

	
	@Mock
	ExerciseRepository repo;
	
	ExerciseServiceImplementation exerciseService;
	
	@BeforeEach
	void instantiatServiceClass() {
		exerciseService = new ExerciseServiceImplementation(repo);
	}
	
	
	@Test
	public void successfullAddingOfExercise() {
		
		
		AddExerciseRequestDto requestDto = AddExerciseRequestDto.builder().name("squat").difficulty("medium").mediaType(MediaType.VIDEO).mediaUrl("").build();
		Exercise ex = Exercise.builder().name("squat").difficulty("medium").mediaType(MediaType.VIDEO).mediaUrl("").build();
		
		given(repo.save(any(Exercise.class))).willReturn(ex);
		
		AddExerciseResponseDto responseDto = exerciseService.addExercise(requestDto);
		
		assertThat(responseDto.getName()).isEqualTo("squat");
		assertThat(responseDto.getDifficulty()).isEqualTo("medium");
		
		
	}
	
//	duplicateEntry() 
	
	
	
	
	
	
	
	
	

}
