package com.te.servicelayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.daolayer.BankingDAO;
import com.te.dtolayer.Customer;
import com.te.dtolayer.MiniStatement;

@Service
public class ServiceLayerImpl implements ServiceLayer {

	@Autowired
	private BankingDAO bankingDao;
	@Override
	public boolean addService(Customer customer) {
		
		return bankingDao.registerDao(customer);
	}
	@Override
	public boolean loginService(int userId, String password) {   
		return  bankingDao.loginDao(userId, password);

	}
	@Override
	public boolean deposit(String userName, long accountNumber, long mobileNo, double amount) {
	
		return bankingDao.deposit(userName, accountNumber, mobileNo, amount);
	}
	@Override
	public boolean withdraw(String userName, long accountNumber, String mobileNo, double amount) {
		
		return bankingDao.withdraw(userName, accountNumber, mobileNo, amount);
	}
	@Override
	public List<MiniStatement> getStatement(long accountNumber) {
		
		return bankingDao.getStatement(accountNumber);
	}

}
