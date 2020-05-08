package com.gwrocha.vancol.controllers.dto;

import java.io.Serializable;

import com.gwrocha.vancol.models.Runner;
import com.gwrocha.vancol.models.Running;
import com.gwrocha.vancol.models.Subscription;

import lombok.Data;

@Data
public class SubscriptionResponse  implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private RunnerResponse runner;
	
	private RunningResponse running;
	
	private String status;
	
	public SubscriptionResponse(Subscription subscription) {
		this.id = subscription.getId();
		this.status = subscription.getStatus().name();
	}

	public SubscriptionResponse(Runner runner, Subscription subscription) {
		this(subscription);
		this.runner = new RunnerResponse(runner);
		this.running = null;
	}

	public SubscriptionResponse(Running running, Subscription subscription) {
		this(subscription);
		this.running = new RunningResponse(running);
		this.runner = null;
	}
	
	
	
}
