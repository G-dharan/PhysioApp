package com.giri.physioApp.dtos;

import java.util.Date;

import com.giri.physioApp.models.PatientProfile;
import com.giri.physioApp.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePatientRequestDto {
	
	private String name;
	private String address;
	private long phone;
	private String summary;
	private String diagnosis;
	private String reports;
	private Date dateOfBirth;
	
	public User toUser() {		
		return User.builder().name(name).Address(address).phone(phone).build();
	}
	
	public PatientProfile toPatientProfile(User user) {		
		return PatientProfile.builder().user(user).summary(summary).diagnosis(diagnosis).reports(reports).build();
	}
}
