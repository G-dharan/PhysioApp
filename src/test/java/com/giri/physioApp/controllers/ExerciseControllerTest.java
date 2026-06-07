package com.giri.physioApp.controllers;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import com.giri.physioApp.dtos.AddExerciseRequestDto;
import com.giri.physioApp.dtos.AddExerciseResponseDto;
import com.giri.physioApp.services.ExerciseService;
import com.giri.physioApp.models.MediaType;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

@WebMvcTest(ExerciseController.class)
public class ExerciseControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockitoBean
	private ExerciseService exerciseService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void completeReq() throws JacksonException, Exception {
		
		AddExerciseRequestDto request = AddExerciseRequestDto.builder().
				  name("bicep curls").
				  mediaUrl("www.google.com").
				  mediaType(MediaType.VIDEO).
				  difficulty("medium").
				  build();
		
		AddExerciseResponseDto response = AddExerciseResponseDto.builder().
				  name("bicep curls").
				  mediaUrl("www.google.com").
				  mediaType(MediaType.VIDEO).
				  difficulty("medium").
				  build();
		
		 given(exerciseService.addExercise(any(AddExerciseRequestDto.class))).willReturn(response);
		 
		 mockMvc.perform(post("/exercise").contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
		 .andExpect(status().isCreated())
		 .andExpect(jsonPath("$.name").value("bicep curls"))
		 .andExpect(jsonPath("$.mediaUrl").value("www.google.com"))
		 .andExpect(jsonPath("$.mediaType").value("VIDEO"))
		 .andExpect(jsonPath("$.difficulty").value("medium"));
		 
		verify(exerciseService).addExercise(any(AddExerciseRequestDto.class));
	}
	
	@Test
	public void incompleteReq() throws JacksonException, Exception {
		AddExerciseRequestDto addExerciseRequestDto = AddExerciseRequestDto.builder().name("chest press").build();
		AddExerciseResponseDto addExerciseResponseDto = AddExerciseResponseDto.builder().name("chest press").difficulty(null).build();
		
		given(exerciseService.addExercise(any(AddExerciseRequestDto.class))).willReturn(addExerciseResponseDto);
		
		mockMvc.perform(post("/exercise").contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(addExerciseRequestDto)))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.name").value("chest press"))
		.andExpect(jsonPath("$.difficulty").doesNotExist());
		
		verify(exerciseService).addExercise(any(AddExerciseRequestDto.class));

	}
	
	@Test
	public void successOnValidInput() throws JacksonException, Exception {
		
		AddExerciseRequestDto request = AddExerciseRequestDto.builder().
				  name("bicep curls").
				  mediaUrl("www.google.com").
				  mediaType(MediaType.VIDEO).
				  difficulty("medium").
				  build();
		
		AddExerciseResponseDto response = AddExerciseResponseDto.builder().
				  name("bicep curls").
				  mediaUrl("www.google.com").
				  mediaType(MediaType.VIDEO).
				  difficulty("medium").
				  build();
		
		 given(exerciseService.addExercise(any(AddExerciseRequestDto.class))).willReturn(response);
		 
		 mockMvc.perform(post("/exercise").contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
		 .andExpect(status().isCreated())
		 .andExpect(jsonPath("$.name").value("bicep curls"))
		 .andExpect(jsonPath("$.mediaUrl").value("www.google.com"))
		 .andExpect(jsonPath("$.mediaType").value("VIDEO"))
		 .andExpect(jsonPath("$.difficulty").value("medium"));
		 
		verify(exerciseService).addExercise(any(AddExerciseRequestDto.class));
	}
;
}
