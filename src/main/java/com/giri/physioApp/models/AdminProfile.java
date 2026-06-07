package com.giri.physioApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
public class AdminProfile extends BaseModel
{
	
	@OneToOne
	@JoinColumn(name ="id")
	private User user;
}
