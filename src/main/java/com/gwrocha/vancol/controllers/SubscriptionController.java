package com.gwrocha.vancol.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gwrocha.vancol.controllers.dto.SubscriptionForm;
import com.gwrocha.vancol.models.Runner;
import com.gwrocha.vancol.models.Running;
import com.gwrocha.vancol.models.Subscription;
import com.gwrocha.vancol.models.enums.StatusSubscription;
import com.gwrocha.vancol.repositories.RunnerRepository;
import com.gwrocha.vancol.repositories.RunningRepository;
import com.gwrocha.vancol.repositories.SubscriptionRepository;

import lombok.val;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

	@Autowired
	private SubscriptionRepository subscriptionRepo;
	
	@Autowired
	private RunnerRepository runnerRepo;
	
	@Autowired
	private RunningRepository runningRep;
	

	@GetMapping("/{id}")
	public ResponseEntity<Subscription> getOne(@PathVariable("id") Long id){
		val optional = subscriptionRepo.findById(id);
		return optional
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Subscription> save(@RequestBody SubscriptionForm subscriptionForm){
		
		Optional<Runner> runnerOp = runnerRepo.findById(subscriptionForm.getRunnerId());
		Optional<Running> runningOp = runningRep.findById(subscriptionForm.getRunningId());
		
		if(!runnerOp.isPresent() || !runningOp.isPresent())
			return ResponseEntity.notFound().build();
		
		Subscription subscription = new Subscription();
		subscription.setRunner(runnerOp.get());
		subscription.setRunning(runningOp.get());
		subscription.setStatus(StatusSubscription.OK);
		Subscription subscriptionSaved = subscriptionRepo.save(subscription);
		
		return ResponseEntity.ok(subscriptionSaved);
	}
	
}
