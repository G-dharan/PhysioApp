package com.giri.physioApp.dtos;

import com.giri.physioApp.models.PatientExercise;
import com.giri.physioApp.models.PatientExerciseStatus;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class PatientExerciseAssignmentRequestDto {
	@NonNull
	long patientId;
	
	@NonNull
	private Long exerciseId;
	private String startDate;
	private String endDate;
	
	public PatientExercise toPatientExercise() {
		// TODO Auto-generated method stub
		PatientExercise patientExercise = PatientExercise.builder().patientId(this.patientId).exerciseId(this.exerciseId)
				.startDate(startDate).endDate(endDate).status(PatientExerciseStatus.ASSIGNED).build();
		return patientExercise;
	}
	
	

}
