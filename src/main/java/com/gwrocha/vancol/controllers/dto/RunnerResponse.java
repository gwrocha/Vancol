package com.gwrocha.vancol.controllers.dto;

import java.io.Serializable;

import com.gwrocha.vancol.models.Runner;

import lombok.Data;

@Data
public class RunnerResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String fullName;
	
	public RunnerResponse(Runner runner) {
		this.id = runner.getId();
		this.fullName = runner.getFirstName() + " " + runner.getLastName();
	}
	
}
