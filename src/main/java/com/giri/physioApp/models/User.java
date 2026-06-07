package com.giri.physioApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
public class User extends BaseModel {

	private String name;
	private String publicId;
	private long phone;
	private String Address;
	private Role role;
	
	@OneToOne(mappedBy="user")
	private PatientProfile patientProfile;
	
	@OneToOne(mappedBy = "user")
	private AdminProfile adminProfile;


}
