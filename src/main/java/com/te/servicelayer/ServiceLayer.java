package com.te.servicelayer;

import java.util.List;

import com.te.dtolayer.Customer;
import com.te.dtolayer.MiniStatement;


public interface ServiceLayer {

	public boolean addService(Customer customer);
	
	public boolean loginService(int userId,String password);
	
	public boolean deposit(String userName,long accountNumber,long mobileNo,double amount);
	
	public boolean withdraw(String userName,long accountNumber,String mobileNo,double amount);

	public List<MiniStatement> getStatement( long accountNumber);

}
