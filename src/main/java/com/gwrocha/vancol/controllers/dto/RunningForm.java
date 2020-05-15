package com.gwrocha.vancol.controllers.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.gwrocha.vancol.models.enums.StatusRunnig;

import lombok.Data;

@Data
public class RunningForm implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank		
	private String name;
	
	private String description;
	
	private LocalDate date;
	
	private LocalTime time;
	
	@Positive
	private Double distance;
	
	private Boolean needPayment;
	
	@Positive
	private BigDecimal valueSubscription;
	
	private StatusRunnig status;
	
	
}
