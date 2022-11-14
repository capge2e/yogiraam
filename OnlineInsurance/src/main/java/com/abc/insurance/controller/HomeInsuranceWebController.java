package com.abc.insurance.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.insurance.dto.DefaultResponseDTO;
import com.abc.insurance.dto.ErrorDTO;
import com.abc.insurance.dto.InsuranceReponseDTO;
import com.abc.insurance.dto.MyDTO;
import com.abc.insurance.entity.HomeInsurance;
import com.abc.insurance.entity.HomePolicies;
import com.abc.insurance.service.HomeInsuranceService;
import com.abc.insurance.service.HomePoliciesService;
import com.abc.insurance.util.HomeInsuranceDTOonvertor;
import com.abc.insurance.util.HomePoliciesDTOConvertor;



@RestController
@RequestMapping("/safeInsurance/admin/homeInsurance")
public class HomeInsuranceWebController {
	@Autowired
	HomeInsuranceService homeInsuranceService;
	
	@Autowired
	HomePoliciesService homePoliciesService;
	@Autowired
	HomePoliciesDTOConvertor dtoConvertor;
	
	@Autowired
	HomeInsuranceDTOonvertor hiDTOConvertot;
	
	public  HomeInsuranceWebController() {
		System.out.println("\n\n\n====>> Inside Constructor "+this);
	}
	
	
	
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());
	
		
	@PostMapping("/addinsurance")  // ....../localhost:8009/safeInsurance/admin/homeInsurance/addinsurance?clientName=Ananya
	public ResponseEntity<MyDTO> doHomeInsuranceThings(@RequestBody @Valid HomeInsurance homeInsurance)throws Exception
	{
		System.out.println("\n\n--->> Inside controller HI  :- "+homeInsurance);
		HomeInsurance  savedInsurance = homeInsuranceService.addHomeInsurance(homeInsurance);
		InsuranceReponseDTO respDTO  = hiDTOConvertot.convertToDTO(savedInsurance);
		return new ResponseEntity<MyDTO>(respDTO, HttpStatus.OK);
		
	
	
		
	
	}// end post to add Home Insurance 
	
	
	@GetMapping("/viewHomeInsurance")//....localhost:8009/safeInsurance/admin/homeInsurance/viewHomeInsurance
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
	@GetMapping("/sumInsured/{sumInsured}")//....localhost:8009/safeInsurance/admin/homeInsurance/sumInsured/1000000
	public HomeInsurance getHomeInsuranceBySumInsured(@PathVariable int sumInsured)throws Exception
	{
		
		return homeInsuranceService.getHomeInsuranceBySumInsured(sumInsured);
		
	}
	
	@GetMapping("/premium/{premium}")//.........localhost:8009/safeInsurance/admin/homeInsurance/premium/7000 
	public List<HomeInsurance> getHomeInsuranceByPremiumamount(@PathVariable  int premium) throws Exception
	{
		
		return  homeInsuranceService.getHomeInsuranceByPremium(premium);
		
	}
	
	
    @GetMapping("/insuranceName/{name}")//..localhost:8009/safeInsurance/admin/homeInsurance/insuranceName/
    public HomeInsurance getHomeInsuranceByInsuranceName(@PathVariable String insuranceName) throws Exception
    {
    	return homeInsuranceService.getHomeInsuranceByInsuranceName(insuranceName);
    }
    @PutMapping("/update")//.........localhost:8009/safeInsurance/admin/homeInsurance/update
	public HomeInsurance updateHomeInsurance(@RequestBody HomeInsurance homeInsurance)throws Exception
	{
		
		return homeInsuranceService.updateHomeInsurance(homeInsurance);
		
		
	}
    @DeleteMapping("/delete/{hId}")//.....localhost:8009/safeInsurance/admin/homeInsurance/delete/5..cannot do bcoz of foreign key
    public String deleteInsurance(@PathVariable int hId) 
    {
    	try {
			homeInsuranceService.delete(hId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	mylogs.info("Deleted Insurance=" +hId+"Data");
		return "Deleted Id="+hId+"Data";
    	
    }
    @GetMapping("/{field}")//..localhost:8009/safeInsurance/admin/homeInsurance/premium
    public List<HomeInsurance> getHomeInsuranceWithSort(@PathVariable String field) throws Exception
    {
    	List<HomeInsurance> allHomeInsurance=homeInsuranceService.findHomeInsuranceWithSorting(field);
    	return allHomeInsurance;
    }
   @GetMapping("/sort/premium")
   public List<HomeInsurance> getBySorting() throws Exception
	    {
	    	List<HomeInsurance> allHomeInsurance=homeInsuranceService.sortingBasedOnPremium();
	    	return allHomeInsurance;
	    }
   
    
    
}//end of class

