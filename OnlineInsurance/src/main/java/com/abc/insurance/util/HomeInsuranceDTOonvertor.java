package com.abc.insurance.util;

import org.springframework.stereotype.Component;

import com.abc.insurance.dto.InsuranceReponseDTO;
import com.abc.insurance.entity.HomeInsurance;

@Component
public class HomeInsuranceDTOonvertor {

	public InsuranceReponseDTO convertToDTO(HomeInsurance hi)
	{
		return new InsuranceReponseDTO(hi.getHId(), hi.getInsuranceName());
	}
}
