package com.giri.physioApp.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.giri.physioApp.dtos.ErrorDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ExerciseNotFoundException.class)
	public ErrorDto handleExerciseNotFound(ExerciseNotFoundException ex) {
		return ErrorDto.builder().message(ex.getMessage()).build();
	}
	
}
