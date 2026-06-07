package com.giri.physioApp.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Data
@NoArgsConstructor
@Entity
public class PatientExercise extends BaseModel{
	
	private long patientId;
	private long exerciseId;
	private String startDate;
	private String endDate;
	private PatientExerciseStatus status;

}
