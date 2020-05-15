package com.gwrocha.vancol.controllers.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gwrocha.vancol.exceptions.ObjectNotFoundException;
import com.gwrocha.vancol.exceptions.ValidationException;

@ControllerAdvice
public class ErrorsHandler {

	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ObjectNotFoundException.class)
	public Error onObjectNotFound(ObjectNotFoundException exception) {
		return new Error(exception.getMessage());
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Error onMethodArgumentNotValidException(HttpMessageNotReadableException exception) {
		return new Error(exception.getLocalizedMessage());
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidationException.class)
	public Error onMethodArgumentNotValidException(ValidationException exception) {
		if(exception.getFieldError() == null)
			return new Error(exception.getMessage());
		else
			return Error.parseError(exception.getFieldError());
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<Error> onMethodArgumentNotValid(MethodArgumentNotValidException exception) {
		return exception.getBindingResult().getFieldErrors().stream()
			.map(err -> new Error(err.getField(), err.getDefaultMessage()))
			.collect(Collectors.toList());
	}
	
}
