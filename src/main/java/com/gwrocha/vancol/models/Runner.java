package com.gwrocha.vancol.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.gwrocha.vancol.models.enums.Gender;

import lombok.Data;

@Data
@Entity
public class Runner implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotNull 
	private LocalDate birthDate;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
}
