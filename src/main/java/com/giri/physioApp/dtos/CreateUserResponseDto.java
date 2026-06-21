package com.giri.physioApp.dtos;

import java.util.Date;

import com.giri.physioApp.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponseDto {
	
	private String publicId;
	private Date createdDate;
	
	public static CreateUserResponseDto from(User createdUser) {
		// TODO Auto-generated method stub
		return CreateUserResponseDto.builder().createdDate(createdUser.getCreatedAt()).publicId(createdUser.getPublicId()).build();
	}

}
