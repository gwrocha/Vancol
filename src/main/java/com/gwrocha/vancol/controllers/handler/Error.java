package com.gwrocha.vancol.controllers.handler;

import java.io.Serializable;

import lombok.Data;

@Data
public class Error implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String field;

	private final String message;

	public Error(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}

	public Error(String message) {
		super();
		this.message = message;
		this.field = null;
	}

	
}
