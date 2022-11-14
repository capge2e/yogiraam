package com.abc.insurance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InsuranceClient {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int clientId;  // should be same as Aruna class structure 
	private String clientName;

}
