package com.gwrocha.vancol.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;

import com.gwrocha.vancol.models.enums.StatusRunnig;

import lombok.Data;

@Data
@Entity
public class Running extends BasicModel {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String description;
	
	private LocalDate date;
	
	private LocalTime time;
	
	private Double distance;
	
	private Boolean needPayment;
	
	private BigDecimal valueSubscription;
	
	private StatusRunnig status;
	
	
}
