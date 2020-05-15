package com.gwrocha.vancol.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import com.gwrocha.vancol.models.enums.StatusSubscription;

import lombok.Data;

@Data
@Entity
public class Subscription extends BasicModel {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Running running;
	
	@ManyToOne
	private Runner runner;
	
	@Enumerated(EnumType.STRING)
	private StatusSubscription status;
	
	public Subscription(){
		status = StatusSubscription.OK;
	}
	
}
