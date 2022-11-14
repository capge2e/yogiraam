package com.abc.insurance.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.abc.insurance.entity.HomeInsurance;
import com.abc.insurance.entity.HomePolicies;
import com.abc.insurance.repository.HomeInsuranceRepository;
import com.abc.insurance.sort.SortingBasedOnPremiumHighToLow;




@Service
public class HomeInsuranceServiceImpl implements HomeInsuranceService {
	@Autowired
	HomeInsuranceRepository homeInsuranceRepository;

	
	
	
	@Override
	public HomeInsurance getInsuranceById(int id) {
		return homeInsuranceRepository.getReferenceById(id);
	}

	@Override
	@Transactional
	public HomeInsurance addHomeInsurance(HomeInsurance homeInsurance)throws Exception {
		
		HomeInsurance savedHomeInsurance =  homeInsuranceRepository.save(homeInsurance);  // Note :  save() is already implemented by Spring Data JPA
		if(savedHomeInsurance != null)
		{
			return savedHomeInsurance;
		}
		else return null;
	}

	@Override
	public List<HomeInsurance> getAllHomeInsurance() throws Exception {

		List<HomeInsurance> allInsurance = homeInsuranceRepository.findAll(); // Note : same as save
		return allInsurance;
	}

	@Override
	public HomeInsurance getHomeInsuranceBySumInsured(int sumInsured) throws Exception {
		return  homeInsuranceRepository.getHomeInsuranceBySumInsured(sumInsured);
	}

	@Override
	public List<HomeInsurance> getHomeInsuranceByPremium(int premium) throws Exception {
	
		return homeInsuranceRepository.getHomeInsuranceByPremium(premium);
	}

	@Override
	public HomeInsurance updateHomeInsurance(HomeInsurance homeInsurance) throws Exception{
		return homeInsuranceRepository.save(homeInsurance);
	}

	@Override
	public HomeInsurance getHomeInsuranceByInsuranceName(String insuranceName) throws Exception {
       HomeInsurance outPut =  homeInsuranceRepository.getHomeInsuranceByInsuranceName(insuranceName);
		
		if(outPut == null)
		{
			throw new EntityNotFoundException(outPut+" not listed in the database");
		}
		else
		{
			return outPut;
		}
	}

	

	@Override
	public List<HomeInsurance> findHomeInsuranceWithSorting(String field) throws Exception {
		
		return homeInsuranceRepository.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	

	

	@Override
	public void delete(int hId) throws Exception {
		homeInsuranceRepository.deleteById(hId);
		
	}

	@Override
	public List<HomeInsurance> sortingBasedOnPremium() throws Exception {
		List<HomeInsurance> list=homeInsuranceRepository.findAll();
		List<HomeInsurance> homeInsurances=new ArrayList<>();
		Collections.sort(list,new SortingBasedOnPremiumHighToLow());
		return list;
	}

	



	

	

}//end of class
