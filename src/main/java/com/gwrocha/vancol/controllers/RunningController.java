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

import com.gwrocha.vancol.controllers.dto.RunningForm;
import com.gwrocha.vancol.controllers.dto.SubscriptionResponse;
import com.gwrocha.vancol.exceptions.ObjectNotFoundException;
import com.gwrocha.vancol.models.Running;
import com.gwrocha.vancol.services.RunningService;
import com.gwrocha.vancol.services.SubscriptionService;

import lombok.val;

@RestController
@RequestMapping("/runnings")
public class RunningController{

	@Autowired
	private SubscriptionService subscriptionService;

	@Autowired
	private RunningService runningService;
	
	@GetMapping
	public ResponseEntity<List<Running>> getAll(){
		val all = runningService.findAll();
		return ResponseEntity.ok(all);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Running> getOne(@PathVariable("id") Long id){
		val optional = runningService.findById(id);
		return optional.map(ResponseEntity::ok)
			.orElseThrow(() -> new ObjectNotFoundException(Running.class, id));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id){
		runningService.deleteById(id);
	}
	
	@PostMapping
	public ResponseEntity<Running> save(@RequestBody @Valid RunningForm runningForm) {
		Running running = new ModelMapper().map(runningForm, Running.class);
		Running runningSaved = runningService.save(running);
		return ResponseEntity.ok(runningSaved);
	}

	@PutMapping
	public ResponseEntity<Running> update(@RequestBody @Valid RunningForm runningForm) {
		Running running = new ModelMapper().map(runningForm, Running.class);
		Running runningUpdated = runningService.update(running);
		return ResponseEntity.ok(runningUpdated);
	}
	
	@GetMapping
	@RequestMapping("/{running_id}/subscriptions")
	public ResponseEntity<Set<SubscriptionResponse>> getAll(@PathVariable("running_id") Long id){
		val allSubscriptions = subscriptionService.findAllByRunningId(id);
		Set<SubscriptionResponse> subscriptionsResponse = allSubscriptions.stream()
			.map(sub -> new SubscriptionResponse(sub.getRunner(), sub))
			.collect(toSet());
		return ResponseEntity.ok(subscriptionsResponse);
	}

}
