package com.gwrocha.vancol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwrocha.vancol.models.Running;
import com.gwrocha.vancol.repositories.RunningRepository;

@Service
public class RunningService extends CrudService<Running>{

	@Autowired
	public RunningService(RunningRepository runningRepository) {
		super(runningRepository);
	}
	
	
}
