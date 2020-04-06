package com.gwrocha.vancol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gwrocha.vancol.models.Runner;
import com.gwrocha.vancol.repositories.RunnerRepository;

@RestController
@RequestMapping("/runners")
public class RunnerController extends BasicController<Runner>{

	@Autowired
	public RunnerController(RunnerRepository runnerRepo) {
		super(runnerRepo);
	}

}
