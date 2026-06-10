package com.giri.physioApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giri.physioApp.models.PatientExercise;

import lombok.NonNull;

public interface PatientExerciseRepo extends JpaRepository<PatientExercise, Long>{

	PatientExercise findByPatientProfileIdAndExerciseId(@NonNull Long exerciseId, @NonNull Long patientProfileId);

}
