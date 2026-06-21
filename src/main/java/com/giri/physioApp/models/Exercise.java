package com.giri.physioApp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(name = "uq_exercise_name", columnNames = "name")})
public class Exercise extends BaseModel{

	
	private String name;
	private String mediaUrl;
	
	@Column(nullable=false)
	private MediaType mediaType;
	private String difficulty;  // to be enum
	
	
	
}
