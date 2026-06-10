package com.giri.physioApp.services;

import org.springframework.stereotype.Service;

import com.giri.physioApp.dtos.PatientExerciseAssignmentRequestDto;
import com.giri.physioApp.dtos.PatientExerciseAssignmentResponseDto;
import com.giri.physioApp.exceptions.ExerciseNotFoundException;
import com.giri.physioApp.exceptions.PatientNotFoundException;
import com.giri.physioApp.models.Exercise;
import com.giri.physioApp.models.PatientExercise;
import com.giri.physioApp.models.PatientProfile;
import com.giri.physioApp.repositories.ExerciseRepository;
import com.giri.physioApp.repositories.PatientExerciseRepo;
import com.giri.physioApp.repositories.UserRepository;

@Service
public class ExerciseAssignmentServiceImpl implements ExerciseAssignmentService{
	
	private PatientExerciseRepo patientExerciseRepo;
	private ExerciseRepository exerciseRepo;
	private UserRepository userRepo;
	
	public ExerciseAssignmentServiceImpl(PatientExerciseRepo patientExerciseRepo, ExerciseRepository exerciseRepo, UserRepository userRepo) {
		this.patientExerciseRepo = patientExerciseRepo;
		this.exerciseRepo = exerciseRepo;
		this.userRepo = userRepo;
	}

	@Override
	public PatientExerciseAssignmentResponseDto addExerciseToPatient(PatientExerciseAssignmentRequestDto assignmentRequestDto) {
		Exercise dbExercise = exerciseRepo.findById(assignmentRequestDto.getExerciseId()).orElseThrow(()-> new ExerciseNotFoundException("Exercise of id " + assignmentRequestDto.getExerciseId() + " not found"));
		PatientProfile dbPatient = userRepo.findByPatienProfileId(assignmentRequestDto.getPatientId()).orElseThrow(()-> new PatientNotFoundException("Patient of id " + assignmentRequestDto.getPatientId() + " not found"));
		PatientExercise patientExercise= assignmentRequestDto.toPatientExercise(dbExercise, dbPatient);
		PatientExercise savedPatientExercise = patientExerciseRepo.save(patientExercise);
		return PatientExerciseAssignmentResponseDto.from(savedPatientExercise);
	}
	
	@Override
	public PatientExerciseAssignmentResponseDto updatePatientExercise(
			PatientExerciseAssignmentRequestDto assignmentRequestDto) {
		PatientExercise patientExercise= patientExerciseRepo.findByPatientProfileIdAndExerciseId(
				assignmentRequestDto.getExerciseId(),
				assignmentRequestDto.getPatientId()
				);
		
		
		return null;
	}
	
	

}
