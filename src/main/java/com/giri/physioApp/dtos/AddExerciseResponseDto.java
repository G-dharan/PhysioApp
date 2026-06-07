package com.giri.physioApp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.giri.physioApp.models.Exercise;
import com.giri.physioApp.models.MediaType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddExerciseResponseDto {
	
	private String name;
	private String mediaUrl;
	private MediaType mediaType;
	private String difficulty;
	
	
	public static AddExerciseResponseDto fromExercise(Exercise savedExercise) {
		// TODO Auto-generated method stub		
		AddExerciseResponseDto addExerciseResponseDto = AddExerciseResponseDto.builder().
				name(savedExercise.getName()).
				difficulty(savedExercise.getDifficulty()).
				mediaType(savedExercise.getMediaType()).
				mediaUrl(savedExercise.getMediaUrl()).
				build();
		return addExerciseResponseDto;
	} 
	
	

}
