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
public class AddExerciseRequestDto {
	
	private String name;
	private String mediaUrl;
	private MediaType mediaType;
	private String difficulty; 
	
	public Exercise toExercise() {
		Exercise exercise = Exercise.builder().
				difficulty(difficulty).mediaType(mediaType).mediaUrl(mediaUrl).build();
		return exercise;
	}

}
