package com.te.daolayer;

import com.te.dtolayer.Customer;
import com.te.dtolayer.MiniStatement;

import java.util.*;

public interface BankingDAO {

	public boolean registerDao(Customer customer);
	
	public boolean loginDao(int userId,String password);
	
	public boolean deposit(String userName,long accountNo,long mobileNo,double amount);
	
    public boolean withdraw(String userName,long accountNo,String mobile,double amount);

    public List<MiniStatement> getStatement(long accountNo);
}

