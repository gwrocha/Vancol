package com.gwrocha.vancol.controllers.handler;

import java.io.Serializable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.validation.FieldError;

import lombok.Data;

@Data
public class Error implements Serializable {

	private static final long serialVersionUID = 1L;

	private String object;
	
	private String field;
	
	private String message;

	public Error(String object, String field, String message) {
		this.object = object;
		this.field = formatField(field);
		this.message = message;
	}
	
	public Error(String field, String message) {
		this(null, field, message);
	}
	
	public Error(String message) {
		this(null, message);
	}

	public static Error parseError(FieldError fieldError) {
		return new Error(fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
	}
	
	private String formatField(String field) {
		
		if(field == null) return null;
		
		String[] fieldSplit = field.split("(?=\\p{Upper})");
		return Stream.of(fieldSplit)
			.map(String::toLowerCase)
			.collect(Collectors.joining("_"));
	}
	
}
