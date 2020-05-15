package com.gwrocha.vancol.exceptions;

import static java.lang.String.format;

public class VancolException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public VancolException(String mensagem, Object ... params) {
		super(format(mensagem, params));
	}

}
