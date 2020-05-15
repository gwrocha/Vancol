package com.gwrocha.vancol.services.validations;

import static java.lang.Boolean.TRUE;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.gwrocha.vancol.exceptions.ValidationException;
import com.gwrocha.vancol.models.Running;

@Component
public class RunnigValidations {

	public boolean isCompleted(Running running) {
		
		boolean completed = true;
		completed &= !StringUtils.isEmpty(running.getDescription());
		completed &= running.getDate() != null;
		completed &= running.getTime() != null;
		completed &= running.getDistance() != null;
		completed &= running.getNeedPayment() != null;
		
		if(completed && running.getNeedPayment().equals(TRUE))
			completed &= running.getValueSubscription() != null;
		
		return completed;
	}

	public void validDate(Running running) {
		if(running.getDate() != null && !running.getDate().isAfter(LocalDate.now()))
			throw new ValidationException("Running", "date", "must be atter current date.");
		
	}

	
	
}
