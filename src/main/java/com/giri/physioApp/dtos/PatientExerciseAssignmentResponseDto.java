package com.giri.physioApp.dtos;

import java.util.Date;

import com.giri.physioApp.models.PatientExercise;
import com.giri.physioApp.models.PatientExerciseStatus;

import lombok.Builder;

@Builder
public class PatientExerciseAssignmentResponseDto {
	
	private Date assignedAt;
	private PatientExerciseStatus status;
	private String startDate;
	private String endDate;
	
	public static PatientExerciseAssignmentResponseDto from(PatientExercise savedPatientExercise) {
		// TODO Auto-generated method stub
		return PatientExerciseAssignmentResponseDto.builder().assignedAt(savedPatientExercise.getLastModifiedAt())
				.status(savedPatientExercise.getStatus())
				.startDate(savedPatientExercise.getStartDate())
				.endDate(savedPatientExercise.getEndDate())
				.build();
	}

}
