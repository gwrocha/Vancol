package com.gwrocha.vancol.controllers;

import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gwrocha.vancol.controllers.dto.RunnerForm;
import com.gwrocha.vancol.controllers.dto.SubscriptionResponse;
import com.gwrocha.vancol.exceptions.ObjectNotFoundException;
import com.gwrocha.vancol.models.Runner;
import com.gwrocha.vancol.services.RunnerService;
import com.gwrocha.vancol.services.SubscriptionService;

import lombok.val;

@RestController
@RequestMapping("/runners")
public class RunnerController{

	@Autowired
	private SubscriptionService subscriptionService;
	
	@Autowired
	private RunnerService runnerService;
	
	@GetMapping
	public ResponseEntity<List<Runner>> getAll(){
		val all = runnerService.findAll();
		return ResponseEntity.ok(all);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Runner> getOne(@PathVariable("id") Long id){
		val optional = runnerService.findById(id);
		return optional.map(ResponseEntity::ok)
				.orElseThrow(() -> new ObjectNotFoundException(Runner.class, id));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id){
		runnerService.deleteById(id);
	}
	
	@PostMapping
	public ResponseEntity<Runner> save(@RequestBody @Valid RunnerForm runnerForm) {
		Runner runner = new ModelMapper().map(runnerForm, Runner.class);
		Runner runnerSaved = runnerService.save(runner);
		return ResponseEntity.ok(runnerSaved);
	}

	@PutMapping
	public ResponseEntity<Runner> update(@RequestBody @Valid RunnerForm runnerForm) {
		Runner runner = new ModelMapper().map(runnerForm, Runner.class);
		Runner runnerUpdated = runnerService.update(runner);
		return ResponseEntity.ok(runnerUpdated);
	}

	@GetMapping
	@RequestMapping("/{runner_id}/subscriptions")
	public ResponseEntity<Set<SubscriptionResponse>> getAll(@PathVariable("runner_id") Long id){
		val allSubscriptions = subscriptionService.findAllByRunnerId(id);
		Set<SubscriptionResponse> subscriptionsResponse = allSubscriptions.stream()
			.map(sub -> new SubscriptionResponse(sub.getRunning(), sub))
			.collect(toSet());
		return ResponseEntity.ok(subscriptionsResponse);
	}
}
