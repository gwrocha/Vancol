package com.gwrocha.vancol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwrocha.vancol.models.Running;
import com.gwrocha.vancol.models.enums.StatusRunnig;
import com.gwrocha.vancol.repositories.RunningRepository;
import com.gwrocha.vancol.services.validations.RunnigValidations;

@Service
public class RunningService extends CrudService<Running>{

	@Autowired
	private RunnigValidations runnigValidations;
	
	@Autowired
	public RunningService(RunningRepository runningRepository) {
		super(runningRepository);
	}
	
	@Override
	public Running save(Running entity) {
		runnigValidations.validDate(entity);
		StatusRunnig status = runnigValidations.isCompleted(entity) ? StatusRunnig.OPEN : StatusRunnig.CREATED;
		entity.setStatus(status);
		return super.save(entity);
	}
	
}
