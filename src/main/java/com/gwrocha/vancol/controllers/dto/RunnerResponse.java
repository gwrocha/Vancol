package com.gwrocha.vancol.controllers.dto;

import com.gwrocha.vancol.models.Runner;

import lombok.Data;

@Data
public class RunnerResponse {

	private Long id;
	
	private String fullName;
	
	public RunnerResponse(Runner runner) {
		this.id = runner.getId();
		this.fullName = runner.getFirstName() + " " + runner.getLastName();
	}
	
}
