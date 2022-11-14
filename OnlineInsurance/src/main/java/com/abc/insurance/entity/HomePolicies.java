package com.abc.insurance.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HomePolicies")
public class HomePolicies {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int homePolicyId;  // home insurance is the saperate code 
	private int homePolicyNo;
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "InsuranceClient")
	//private InsuranceClient insuranceClient;
	
	@NotNull(message = "client Name cannot be Null")
	private String clientName; // have to shared from Aruna 
	private String dateOfPurchase;
	private String dateOfExpire;
	private String isClaimed;
	private String claimDate;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "homeInsurancce")
	private HomeInsurance homeInsurance;

	public HomePolicies(int homePolicyNo, String clientName, String dateOfPurchase, String dateOfExpire,
			String isClaimed, String claimDate) {
		super();
		this.homePolicyNo = homePolicyNo;
		this.clientName = clientName;
		this.dateOfPurchase = dateOfPurchase;
		this.dateOfExpire = dateOfExpire;
		this.isClaimed = isClaimed;
		this.claimDate = claimDate;
	}

//end of constructor

}// end of class
