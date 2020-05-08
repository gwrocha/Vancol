package com.gwrocha.vancol.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.gwrocha.vancol.models.enums.StatusSubscription;

import lombok.Data;

@Data
@Entity
public class Subscription implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long Id;
	
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
