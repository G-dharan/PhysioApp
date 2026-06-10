package com.giri.physioApp.exceptions;

public class PatientNotFoundException extends RuntimeException {
	
	public PatientNotFoundException(String message) {
		super(message);
	}

}
