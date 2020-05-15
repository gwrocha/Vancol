package com.gwrocha.vancol.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gwrocha.vancol.controllers.dto.SubscriptionForm;
import com.gwrocha.vancol.models.Subscription;
import com.gwrocha.vancol.services.SubscriptionService;

import lombok.val;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

	@Autowired
	private SubscriptionService subscriptionService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Subscription> getOne(@PathVariable("id") Long id){
		val optional = subscriptionService.findById(id);
		return optional
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Subscription> save(@RequestBody @Valid SubscriptionForm subscriptionForm){
		
		Long runnerId = subscriptionForm.getRunnerId();
		Long runningId = subscriptionForm.getRunningId();
		Subscription subscription = subscriptionService.createNew(runnerId, runningId);
		
		return ResponseEntity. ok(subscription);
	}
	
}
