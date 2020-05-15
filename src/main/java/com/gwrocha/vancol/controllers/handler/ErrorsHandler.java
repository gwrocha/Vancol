package com.gwrocha.vancol.controllers.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gwrocha.vancol.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ErrorsHandler {

	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ObjectNotFoundException.class)
	Error handlerObjectNotFound(ObjectNotFoundException exception) {
		return new Error(exception.getMessage());
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	List<Error> onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		List<Error> error = new ArrayList<Error>();
		for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			error.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
		}
		return error;
	}

}
