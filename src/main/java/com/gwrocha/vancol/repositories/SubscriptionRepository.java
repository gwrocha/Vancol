package com.gwrocha.vancol.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gwrocha.vancol.models.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

	public List<Subscription> findByRunning_Id(Long id);

	public List<Subscription> findByRunner_Id(Long id);
	
}
