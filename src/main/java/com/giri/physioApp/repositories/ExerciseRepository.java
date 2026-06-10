package com.giri.physioApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giri.physioApp.models.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{

	Exercise save(Exercise exercise);

	Optional<Exercise> getByName(String name);

}
