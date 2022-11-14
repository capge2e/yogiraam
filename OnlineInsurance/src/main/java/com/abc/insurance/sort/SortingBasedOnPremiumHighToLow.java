package com.abc.insurance.sort;

import java.util.Comparator;

import com.abc.insurance.entity.HomeInsurance;

public class SortingBasedOnPremiumHighToLow   implements Comparator<HomeInsurance>{

	@Override
	public int compare(HomeInsurance o1, HomeInsurance o2) {
		
		return o2.getPremium()-o1.getPremium();
	}

	
}
