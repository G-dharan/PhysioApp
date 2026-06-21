package com.giri.physioApp.dtos;

import com.giri.physioApp.models.Exercise;
import com.giri.physioApp.models.PatientExercise;
import com.giri.physioApp.models.PatientExerciseStatus;
import com.giri.physioApp.models.PatientProfile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
public class PatientExerciseAssignmentRequestDto {
	@NonNull
	long patientId;
	
	@NonNull
	private Long exerciseId;
	private String startDate;
	private String endDate;
	
	public PatientExercise toPatientExercise(Exercise dbExercise, PatientProfile dbPatient) {
		// TODO Auto-generated method stub
		PatientExercise patientExercise = PatientExercise.builder().patientProfile(dbPatient).exercise(dbExercise)
				.startDate(startDate).endDate(endDate).status(PatientExerciseStatus.ASSIGNED).build();
		return patientExercise;
	}
	
	

}

