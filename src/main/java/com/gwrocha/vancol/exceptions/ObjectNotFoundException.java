package com.gwrocha.vancol.exceptions;

import static java.lang.String.format;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException() {
		super("Object not foud.");
	}
	
	public ObjectNotFoundException(String clazz, Long id) {
		super(format("%s not found with id %d.", clazz, id));
	}
	
	public ObjectNotFoundException(Class<?> clazz, Long id) {
		this(clazz.getSimpleName(), id);
	}
	
}
