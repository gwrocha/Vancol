package com.gwrocha.vancol.controllers.dto;

import com.gwrocha.vancol.models.Running;

import lombok.Data;

@Data
public class RunningResponse {

	private Long id;
	
	private String name;
	
	public RunningResponse(Running running) {
		this.id = running.getId();
		this.name = running.getName();
	}
	
}
