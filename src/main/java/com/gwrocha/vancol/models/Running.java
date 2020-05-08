package com.gwrocha.vancol.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.gwrocha.vancol.models.enums.StatusRunnig;

import lombok.Data;

@Data
@Entity
public class Running implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String description;
	
	private LocalDate date;
	
	private LocalTime time;
	
	private Double distance;
	
	private Boolean needPayment;
	
	private BigDecimal valueSubscription;
	
	private StatusRunnig status;
	
	
}
