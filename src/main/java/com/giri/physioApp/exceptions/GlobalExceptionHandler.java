package com.giri.physioApp.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.giri.physioApp.dtos.ErrorDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ExerciseNotFoundException.class)
	public ResponseEntity<ErrorDto> handleExerciseNotFound(ExerciseNotFoundException ex) {
		return ResponseEntity.status(404).body(ErrorDto.builder().message(ex.getMessage()).build());
	}
	
//	@ExceptionHandler(DataIntegrityViolationException.class)
//	public ResponseEntity<ErrorDto> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
//		return ResponseEntity.status(500).body(ErrorDto.builder().message(ex.getMessage()).build());
//	}
	
	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<ErrorDto> handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex) {
		return ResponseEntity.status(400).body(ErrorDto.builder().message(ex.getMessage()).build());
	}	
}
