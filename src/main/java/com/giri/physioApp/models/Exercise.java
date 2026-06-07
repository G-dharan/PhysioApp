package com.giri.physioApp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
public class Exercise extends BaseModel{

	private String name;
	private String mediaUrl;
	
	@Column(nullable=false)
	private MediaType mediaType;
	private String difficulty;  // to be enum
	
	
	
}
