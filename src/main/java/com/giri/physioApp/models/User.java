package com.giri.physioApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@Data
@Table(uniqueConstraints = {
		@UniqueConstraint(name = "uq_user_entity", columnNames = {"name, phone"}),
		@UniqueConstraint(name = "uq_user_entity_public_id", columnNames = "publicId")
		}
)
public class User extends BaseModel {

	private String name;
	private String publicId;
	private long phone;
	private String Address;
	private String email;
	private Role role;


}
