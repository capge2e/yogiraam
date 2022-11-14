package com.abc.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.insurance.entity.HomeInsurance;
import com.abc.insurance.service.HomeInsuranceService;

@RestController
@RequestMapping("/public/insurance")
public class PublicController {
	@Autowired
	HomeInsuranceService homeInsuranceService;
	@GetMapping("/viewHomeInsurance")//....localhost:8009/public/insurance/viewHomeInsurance
	public List<HomeInsurance> viewAllInsurance()
	{

		try {
			List<HomeInsurance>  allExtractedInsurance =homeInsuranceService.getAllHomeInsurance();
			
			return allExtractedInsurance;
			
		} catch (Exception e) {
		
			System.out.println(e);
			
		}
		
		return null;
	}
	@GetMapping("/sumInsured/{sumInsured}")//....localhost:8009/public/insurance/sumInsured/1000000
	public HomeInsurance getHomeInsuranceBySumInsured(@PathVariable int sumInsured)throws Exception
	{
		
		return homeInsuranceService.getHomeInsuranceBySumInsured(sumInsured);
		
	}
	
	@GetMapping("/premium/{premium}")//.........localhost:8009/public/insurance/premium/7000
	public List<HomeInsurance> getHomeInsuranceByPremiumamount(@PathVariable  int premium) throws Exception
	{
		
		return  homeInsuranceService.getHomeInsuranceByPremium(premium);
		
	}
	
	
    @GetMapping("/insuranceName/{name}")//...localhost:8009/safeInsurance/admin/homeInsurance/insuranceName/Fire Insurance  
    public HomeInsurance getHomeInsuranceByInsuranceName(@PathVariable String insuranceName) throws Exception
    {
    	return homeInsuranceService.getHomeInsuranceByInsuranceName(insuranceName);
    }

}
