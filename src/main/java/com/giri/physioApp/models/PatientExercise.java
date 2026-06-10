package com.giri.physioApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Data
@NoArgsConstructor
@Entity
public class PatientExercise extends BaseModel{
	
	@ManyToOne
	@JoinColumn(name = "patient_profile_Id", referencedColumnName = "id")
	private PatientProfile patientProfile;
	
	@ManyToOne
	@JoinColumn(name = "exercise_id", referencedColumnName = "id")
	private Exercise exercise;
	private String startDate;
	private String endDate;
	private PatientExerciseStatus status;

}
