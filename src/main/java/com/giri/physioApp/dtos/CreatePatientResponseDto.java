package com.giri.physioApp.dtos;

import com.giri.physioApp.models.User;

import lombok.Builder;

@Builder
public class CreatePatientResponseDto {
	
	private String publicId;
	private String createdDate;

}
