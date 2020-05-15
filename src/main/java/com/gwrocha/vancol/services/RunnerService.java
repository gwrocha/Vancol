package com.gwrocha.vancol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwrocha.vancol.models.Runner;
import com.gwrocha.vancol.repositories.RunnerRepository;

@Service
public class RunnerService extends CrudService<Runner>{

	@Autowired
	public RunnerService(RunnerRepository runnerRepository) {
		super(runnerRepository);
	}
	
	
}
