package com.cf.openAccountService;

import java.util.List;

import com.cf.entity.CustomerDetails;

public interface ServiceInterface {
	public List<CustomerDetails> displayCustomer();
	public int checkPhone(CustomerDetails c);
	

}
