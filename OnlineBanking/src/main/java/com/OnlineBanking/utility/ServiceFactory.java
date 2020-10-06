package com.OnlineBanking.utility;
import com.OnlineBanking.service.*;
public class ServiceFactory {
private ServiceFactory() {
	
}
public static BankServiceInterface createObject(String nn) {
	BankServiceInterface is=null;
	if(nn.equals("admin service")) {
		is=new BankService();
	}
	return is;
}
}
