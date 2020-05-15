package com.gwrocha.vancol.controllers.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.gwrocha.vancol.models.enums.Gender;

import lombok.Data;

@Data
public class RunnerForm implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@Past
	@NotNull
	private LocalDate birthDate;
	
	@NotNull
	private Gender gender;
	
}
