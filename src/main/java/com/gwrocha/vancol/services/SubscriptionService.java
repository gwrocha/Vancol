package com.gwrocha.vancol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwrocha.vancol.exceptions.ObjectNotFoundException;
import com.gwrocha.vancol.models.Runner;
import com.gwrocha.vancol.models.Running;
import com.gwrocha.vancol.models.Subscription;
import com.gwrocha.vancol.models.enums.StatusSubscription;
import com.gwrocha.vancol.repositories.SubscriptionRepository;

@Service
public class SubscriptionService extends CrudService<Subscription>{

	@Autowired
	private RunnerService runnerService;
	
	@Autowired
	private RunningService runningService;
	
	private SubscriptionRepository subscriptionRepository;
	
	@Autowired
	public SubscriptionService(SubscriptionRepository subscriptionRepository) {
		super(subscriptionRepository);
		this.subscriptionRepository = subscriptionRepository;
	}

	public List<Subscription> findAllByRunningId(Long id) {
		if(runningService.notExists(id))
			throw new ObjectNotFoundException(Running.class, id);
		
		return subscriptionRepository.findByRunning_Id(id);
	}

	public List<Subscription> findAllByRunnerId(Long id) {
		if(runnerService.notExists(id))
			throw new ObjectNotFoundException(Runner.class, id);
		
		return subscriptionRepository.findByRunner_Id(id);
	}

	public Subscription createNew(Long runnerId, Long runningId) {
		Runner runner = runnerService.findById(runnerId)
				.orElseThrow(() -> new ObjectNotFoundException(Runner.class, runnerId));
		Running running = runningService.findById(runningId)
				.orElseThrow(() -> new ObjectNotFoundException(Running.class, runnerId));
		
		Subscription subscription = new Subscription();
		subscription.setRunner(runner);
		subscription.setRunning(running);
		subscription.setStatus(StatusSubscription.OK);
		return save(subscription);
	}
	
}
