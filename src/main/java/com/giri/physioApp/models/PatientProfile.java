package com.giri.physioApp.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
public class PatientProfile extends BaseModel{
	
	@OneToOne
	@JoinColumn(name = "user_id",  referencedColumnName = "id")
	private User user;
	//version controlled
	private String summary;
	private String diagnosis;
	private String reports;
	private Date dateOfBirth;
	@OneToMany(mappedBy = "patientProfile")
	private List<PatientExercise> patientExercises;

}
