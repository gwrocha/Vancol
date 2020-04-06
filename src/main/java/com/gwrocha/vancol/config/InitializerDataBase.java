package com.gwrocha.vancol.config;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gwrocha.vancol.models.Runner;
import com.gwrocha.vancol.models.Running;
import com.gwrocha.vancol.repositories.RunnerRepository;
import com.gwrocha.vancol.repositories.RunningRepository;

import lombok.var;

@Component
public class InitializerDataBase {
	
	@Autowired
	private RunningRepository runningRepo;
	
	@Autowired
	private RunnerRepository runnerRepo;

	
	@PostConstruct
	@Transactional
	public void init(){
		insertCorridas();
		insertCorredores();
	}


	private void insertCorredores() {

		if(runnerRepo.count() > 0) return;
		
		var runner = new Runner();
		runner.setFirstName("Raul");
		runner.setLastName("Lopes");
		runner.setBirthDate(LocalDate.of(1972, 11, 5));
		runnerRepo.save(runner);
		
		runner = new Runner();
		runner.setFirstName("Gleydson");
		runner.setLastName("Rocha");
		runner.setBirthDate(LocalDate.of(1991, 12, 20));
		runnerRepo.save(runner);

		runner = new Runner();
		runner.setFirstName("Roberto");
		runner.setLastName("Silva");
		runner.setBirthDate(LocalDate.of(2000, 1, 2));
		runnerRepo.save(runner);

		runner = new Runner();
		runner.setFirstName("Pedro");
		runner.setLastName("Sousa");
		runner.setBirthDate(LocalDate.of(1987, 10, 5));
		runnerRepo.save(runner);

		runner = new Runner();
		runner.setFirstName("Vera");
		runner.setLastName("Cruz");
		runner.setBirthDate(LocalDate.of(1999, 2, 14));
		runnerRepo.save(runner);

		runner = new Runner();
		runner.setFirstName("Josy");
		runner.setLastName("Amaral");
		runner.setBirthDate(LocalDate.of(1980, 6, 27));
		runnerRepo.save(runner);

		runner = new Runner();
		runner.setFirstName("Tiago");
		runner.setLastName("Padilha");
		runner.setBirthDate(LocalDate.of(1990, 9, 18));
		runnerRepo.save(runner);
		
	}


	private void insertCorridas() {
		
		if(runningRepo.count() > 0) return;
		
		var running = new Running();
		running.setName("São Silvestre");
		running.setDate(LocalDate.of(2020, 12, 31));
		running.setTime(LocalTime.of(6, 0));
		running.setDistance(21D);
		runningRepo.save(running);
		
		running = new Running();
		running.setName("Desafio 42k de Nazária");
		running.setDate(LocalDate.of(2021, 5, 1));
		running.setTime(LocalTime.of(7, 0));
		running.setDistance(10.5D);
		runningRepo.save(running);
		
	}

}
