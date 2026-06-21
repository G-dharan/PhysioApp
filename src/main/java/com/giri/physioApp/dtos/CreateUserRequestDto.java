package com.giri.physioApp.dtos;

import com.giri.physioApp.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateUserRequestDto {
	
	private String name;
	private String address;
	private long phone;
	
	public User toUser() {		
		return User.builder().name(name).Address(address).phone(phone).build();
	}

	public static User toUser(String name, long phone, String address) {
		// TODO Auto-generated method stub
		return User.builder().name(name).Address(address).phone(phone).build();
	}
}
