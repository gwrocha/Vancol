package com.gwrocha.vancol.controllers.dto;

import java.io.Serializable;

import com.gwrocha.vancol.models.Running;

import lombok.Data;

@Data
public class RunningResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	public RunningResponse(Running running) {
		this.id = running.getId();
		this.name = running.getName();
	}
	
}
