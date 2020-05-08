package com.gwrocha.vancol.controllers;

import static java.util.stream.Collectors.toSet;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gwrocha.vancol.controllers.dto.SubscriptionResponse;
import com.gwrocha.vancol.models.Running;
import com.gwrocha.vancol.repositories.RunningRepository;
import com.gwrocha.vancol.repositories.SubscriptionRepository;

import lombok.val;

@RestController
@RequestMapping("/runnings")
public class RunningController extends BasicController<Running>{

	@Autowired
	private SubscriptionRepository subRepository;
	
	private RunningRepository runningRepo;
	
	@Autowired
	public RunningController(RunningRepository runningRepo) {
		super(runningRepo);
		this.runningRepo = runningRepo;
	}
	
	@GetMapping
	@RequestMapping("/{running_id}/subscriptions")
	public ResponseEntity<Set<SubscriptionResponse>> getAll(@PathVariable("running_id") Long id){
		val allSubscriptions = subRepository.findByRunning_Id(id);
		Set<SubscriptionResponse> subscriptionsResponse = allSubscriptions.stream()
			.map(sub -> new SubscriptionResponse(sub.getRunner(), sub))
			.collect(toSet());
		return ResponseEntity.ok(subscriptionsResponse);
	}
	
	@PostMapping
	public ResponseEntity<Running> save(@RequestBody Running running) {
		Running runningSaved = runningRepo.save(running);
		return ResponseEntity.ok(runningSaved);
	}

	@PutMapping
	public ResponseEntity<Running> update(@RequestBody Running running) {
		boolean present = Optional.ofNullable(running)
			.map(Running::getId)
			.map(runningRepo::findById)
			.map(op -> op.orElse(null))
			.isPresent();
		
		if(!present)
			return ResponseEntity.notFound().build();
		
		Running runningUpdated = runningRepo.save(running);
		return ResponseEntity.ok(runningUpdated);
	}

}
