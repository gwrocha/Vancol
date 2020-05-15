package com.gwrocha.vancol.controllers.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
public class SubscriptionForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Positive
	private Long runnerId;
	
	@NotNull
	@Positive
	private Long runningId;
	
}
