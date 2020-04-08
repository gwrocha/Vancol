package com.gwrocha.vancol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gwrocha.vancol.models.Subscription;
import com.gwrocha.vancol.repositories.SubscriptionRepository;

import lombok.val;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

	@Autowired
	private SubscriptionRepository repository;
	

	@GetMapping("/{id}")
	public ResponseEntity<Subscription> getOne(@PathVariable("id") Long id){
		val optional = repository.findById(id);
		return optional
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}
	
}
