package com.te.daolayer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.te.dtolayer.Customer;
import com.te.dtolayer.CustomerBankDetails;
import com.te.dtolayer.MiniStatement;

@Repository
public class BankingDaoImpl implements BankingDAO {

	
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public boolean registerDao(Customer customer) {
		boolean isRegistered = false;
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		isRegistered=true;
		}
		catch(Exception e) {
			entityTransaction.rollback();
			e.printStackTrace();
		}
		return isRegistered;
	}
	@Override
	public boolean loginDao(int userId, String password) {
		EntityManager entityManager = factory.createEntityManager();
		Customer customer = entityManager.find(Customer.class,userId);
		if(customer.getPassword().equals(password)) {
			return true;
		}
		else {
		return false;
		}
	}
	@Override
	public boolean deposit(String userName, long accountNo, long mobileNo, double amount) {
		boolean isDeposited=false;
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		LocalDate localDate =LocalDate.now();
		LocalTime time = LocalTime.now();
		CustomerBankDetails bankDetails = new CustomerBankDetails();
		MiniStatement miniStatement = new MiniStatement();
		Customer customer = entityManager.find(Customer.class, userName);
		CustomerBankDetails customerBankDetails = entityManager.find(CustomerBankDetails.class, accountNo);
		MiniStatement statement =entityManager.find(MiniStatement.class, accountNo);
		try {
		if(mobileNo==customer.getMobileNumber()) {
			customerBankDetails.setAvailableBalance(amount+statement.getDeposit());
			entityTransaction.begin();
			entityManager.persist(customerBankDetails);
			entityTransaction.commit();
			miniStatement.setCurrentBalance(amount+statement.getCurrentBalance());
		    entityTransaction.begin();
		    entityManager.persist(customerBankDetails);
		    entityTransaction.commit();
		    miniStatement.setAccountNumber(customerBankDetails.getAccountNumber());
		    miniStatement.setDate(localDate);
		    miniStatement.setDeposit(amount);
		    miniStatement.setCurrentBalance(customerBankDetails.getAvailableBalance());
		    miniStatement.setTime(time);
		    entityTransaction.begin();
		    entityManager.persist(miniStatement);
		    entityTransaction.commit();
		    entityManager.close();
		    isDeposited=true;
		}
		}
		catch(Exception e) {
			entityTransaction.rollback();
			e.printStackTrace();
		}
		
		return isDeposited;
	}
	@Override
	public boolean withdraw(String userName, long accountNo, String mobile, double amount) {
		EntityManager entityManager =factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		MiniStatement miniStatement =new MiniStatement();
		CustomerBankDetails bankDetails = new CustomerBankDetails();
		boolean isWithdraw = false;
		Customer customer = entityManager.find(Customer.class, userName);
		CustomerBankDetails customerBankDetails = entityManager.find(CustomerBankDetails.class, accountNo);
		MiniStatement miniStatement2 = entityManager.find(MiniStatement.class, accountNo);
		try {
			if(mobile.equals(customer.getMobileNumber())&&amount<=customerBankDetails.getAvailableBalance()) {
				customerBankDetails.setAvailableBalance(bankDetails.getAvailableBalance()-amount);
				entityTransaction.begin();
				entityManager.persist(bankDetails);
				entityTransaction.commit();
				customerBankDetails.setAvailableBalance(customerBankDetails.getAvailableBalance()-amount);
				customerBankDetails.setWithdraw(amount+customerBankDetails.getWithdraw());
				entityTransaction.begin();
				entityManager.persist(miniStatement2);
				entityTransaction.commit();
				entityManager.close();
				isWithdraw=true;
			}
		}
		catch(Exception e) {
			entityTransaction.rollback();
			e.printStackTrace();
		}
		return isWithdraw;
	}
	@Override
	public List<MiniStatement> getStatement(long accountNo) {
		EntityManager entityManager = factory.createEntityManager();
		String query = "from MiniStatement where accountNumber =:id";
        Query query2 = entityManager.createQuery(query);
        query2.setParameter("id",accountNo);
        List resultList = query2.getResultList();
        
		return resultList;
	}
	
	

}
