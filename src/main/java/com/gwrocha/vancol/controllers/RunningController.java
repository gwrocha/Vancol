package com.gwrocha.vancol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gwrocha.vancol.models.Running;
import com.gwrocha.vancol.repositories.RunningRepository;

@RestController
@RequestMapping("/runnings")
public class RunningController extends BasicController<Running>{

	@Autowired
	public RunningController(RunningRepository runningRepo) {
		super(runningRepo);
	}

}
