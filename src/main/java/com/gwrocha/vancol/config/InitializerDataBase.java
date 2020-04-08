package com.gwrocha.vancol.config;

import static com.gwrocha.vancol.models.enums.Gender.FEMALE;
import static com.gwrocha.vancol.models.enums.Gender.MALE;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.gwrocha.vancol.models.Runner;
import com.gwrocha.vancol.models.Running;
import com.gwrocha.vancol.models.Subscription;
import com.gwrocha.vancol.repositories.RunnerRepository;
import com.gwrocha.vancol.repositories.RunningRepository;
import com.gwrocha.vancol.repositories.SubscriptionRepository;

import lombok.var;

@Component
public class InitializerDataBase {
	
	@Autowired
	private RunningRepository runningRepo;
	
	@Autowired
	private RunnerRepository runnerRepo;
	
	@Autowired
	private SubscriptionRepository subRepo;
	
	@PostConstruct
	@Transactional
	public void init(){
		insertCorridas();
		insertCorredores();
		insertInscritos();
	}


	private void insertInscritos() {
		
		if(subRepo.count() > 0) return;
		
		Sort sort = Sort.by("birthDate");
		List<Runner> all = runnerRepo.findAll(sort);
		all = all.subList(0, 4);
		all.forEach(runner ->{
			Subscription sub =new Subscription();
			sub.setRunner(runner);
			sub.setRunning(runningSaoSilvestre);
			subRepo.save(sub);
		});
		
		
		sort = Sort.by("firstName");
		all = runnerRepo.findAll(sort);
		all = all.subList(0, 5);
		all.forEach(runner ->{
			Subscription sub =new Subscription();
			sub.setRunner(runner);
			sub.setRunning(runningDesafio42k);
			subRepo.save(sub);
		});
		
		
		
	}


	private void insertCorredores() {

		if(runnerRepo.count() > 0) return;
		
		var runner = new Runner();
		runner.setFirstName("Raul");
		runner.setLastName("Lopes");
		runner.setBirthDate(LocalDate.of(1972, 11, 5));
		runner.setGender(MALE);
		runnerRepo.save(runner);
		
		runner = new Runner();
		runner.setFirstName("Gleydson");
		runner.setLastName("Rocha");
		runner.setBirthDate(LocalDate.of(1991, 12, 20));
		runner.setGender(MALE);
		runnerRepo.save(runner);

		runner = new Runner();
		runner.setFirstName("Roberto");
		runner.setLastName("Silva");
		runner.setBirthDate(LocalDate.of(2000, 1, 2));
		runner.setGender(MALE);
		runnerRepo.save(runner);

		runner = new Runner();
		runner.setFirstName("Pedro");
		runner.setLastName("Sousa");
		runner.setBirthDate(LocalDate.of(1987, 10, 5));
		runner.setGender(MALE);
		runnerRepo.save(runner);

		runner = new Runner();
		runner.setFirstName("Vera");
		runner.setLastName("Cruz");
		runner.setBirthDate(LocalDate.of(1999, 2, 14));
		runner.setGender(FEMALE);
		runnerRepo.save(runner);

		runner = new Runner();
		runner.setFirstName("Josy");
		runner.setLastName("Amaral");
		runner.setBirthDate(LocalDate.of(1980, 6, 27));
		runner.setGender(FEMALE);
		runnerRepo.save(runner);

		runner = new Runner();
		runner.setFirstName("Tiago");
		runner.setLastName("Padilha");
		runner.setBirthDate(LocalDate.of(1990, 9, 18));
		runner.setGender(MALE);
		runnerRepo.save(runner);
		
	}


	private void insertCorridas() {
		
		if(runningRepo.count() > 0) return;
		
		runningSaoSilvestre = new Running();
		runningSaoSilvestre.setName("São Silvestre");
		runningSaoSilvestre.setDate(LocalDate.of(2020, 12, 31));
		runningSaoSilvestre.setTime(LocalTime.of(6, 0));
		runningSaoSilvestre.setDistance(21D);
		runningRepo.save(runningSaoSilvestre);
		
		runningDesafio42k = new Running();
		runningDesafio42k.setName("Desafio 42k de Nazária");
		runningDesafio42k.setDate(LocalDate.of(2021, 5, 1));
		runningDesafio42k.setTime(LocalTime.of(7, 0));
		runningDesafio42k.setDistance(10.5D);
		runningRepo.save(runningDesafio42k);
		
	}

	Running runningSaoSilvestre = null;
	Running runningDesafio42k = null;

}
