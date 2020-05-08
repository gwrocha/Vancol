package com.gwrocha.vancol.controllers.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SubscriptionForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long runnerId;
	
	private Long runningId;
	
}
