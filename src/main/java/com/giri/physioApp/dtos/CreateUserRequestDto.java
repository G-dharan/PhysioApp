package com.giri.physioApp.dtos;

import com.giri.physioApp.models.User;

import lombok.Builder;

@Builder
public class CreateUserRequestDto {
	
	private String name;
	private String address;
	private long phone;
	
	public User toUser() {		
		return User.builder().name(name).Address(address).phone(phone).build();
	}
}
