package com.CodeFuryy.Utility;

import com.CodeFuryy.Service.CustomerService;
import com.CodeFuryy.Service.CustomerServiceInterface;

public class ServiceFactory {

	public static CustomerServiceInterface createObject(String string){
		
		CustomerServiceInterface c=null;
		if(string.equals("CustomerServiceObject"))
		{
			c= new CustomerService();
		}
		return c;
	}

}
