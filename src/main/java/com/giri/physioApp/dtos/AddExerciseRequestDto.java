package com.giri.physioApp.dtos;

import com.giri.physioApp.models.Exercise;
import com.giri.physioApp.models.MediaType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddExerciseRequestDto {
	
	private String name;
	private MediaType mediaType;
	private String mediaUrl;
	private String difficulty; 
	
	public Exercise toExercise() {
		Exercise exercise = Exercise.builder().name(name).
				difficulty(difficulty).mediaType(mediaType).mediaUrl(mediaUrl).build();
		return exercise;
	}

}
