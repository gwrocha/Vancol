package com.gwrocha.vancol.exceptions;

import org.springframework.validation.FieldError;

import lombok.Getter;
import lombok.Setter;

public class ValidationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private FieldError fieldError;
	
	public ValidationException(String object, String field, String mensagem) {
		super(mensagem);
		this.fieldError = new FieldError(object, field, mensagem);
	}

	public ValidationException(String mensagem) {
		super(mensagem);
		this.fieldError = null;
	}
	
}
