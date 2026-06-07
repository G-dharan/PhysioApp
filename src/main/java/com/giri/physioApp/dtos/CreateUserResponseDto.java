package com.giri.physioApp.dtos;

import java.util.Date;

import com.giri.physioApp.models.User;

import lombok.Builder;

@Builder
public class CreateUserResponseDto {
	
	private String publicId;
	private Date createdDate;
	
	public static CreateUserResponseDto from(User createdUser) {
		// TODO Auto-generated method stub
		return CreateUserResponseDto.builder().createdDate(createdUser.getCreatedAt()).publicId(createdUser.getPublicId()).build();
	}

}
