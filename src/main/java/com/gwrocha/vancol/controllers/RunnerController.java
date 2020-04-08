package com.gwrocha.vancol.controllers;

import static java.util.stream.Collectors.toSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gwrocha.vancol.controllers.dto.SubscriptionResponse;
import com.gwrocha.vancol.models.Runner;
import com.gwrocha.vancol.repositories.RunnerRepository;
import com.gwrocha.vancol.repositories.SubscriptionRepository;

import lombok.val;

@RestController
@RequestMapping("/runners")
public class RunnerController extends BasicController<Runner>{

	@Autowired
	private SubscriptionRepository subRepository;
	
	@Autowired
	public RunnerController(RunnerRepository runnerRepo) {
		super(runnerRepo);
	}

	@GetMapping
	@RequestMapping("/{runner_id}/subscriptions")
	public ResponseEntity<Set<SubscriptionResponse>> getAll(@PathVariable("runner_id") Long id){
		val allSubscriptions = subRepository.findByRunner_Id(id);
		Set<SubscriptionResponse> subscriptionsResponse = allSubscriptions.stream()
			.map(sub -> new SubscriptionResponse(sub.getRunning(), sub))
			.collect(toSet());
		return ResponseEntity.ok(subscriptionsResponse);
	}
}
