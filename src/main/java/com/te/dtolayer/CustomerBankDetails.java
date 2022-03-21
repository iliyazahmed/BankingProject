package com.te.dtolayer;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "s2", initialValue = 624861636, allocationSize = 1000)
public class CustomerBankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="s2")
	@Column(name="account_number")
	private long accountNumber;
	@Column(name="ifsc_code")
	private String ifscCode;
	@Column(name="branch_name")
	private String branchName;
	@Column(name="available_balance")
	private double availableBalance;
	@Column(name="Date")
	private LocalDate date;
    @Column(name="Deposit")
	private double deposit;
    @Column(name="Withdraw")
	private double withdraw;
    
   //@OneToMany(cascade =CascadeType.ALL,targetEntity = Customer.class)
    //@Column(name="customer_id")
    private Customer customer;

	public CustomerBankDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerBankDetails(long accountNumber, String ifscCode, String branchName, double availableBalance,
			LocalDate date, double deposit, double withdraw, Customer customer) {
		super();
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.branchName = branchName;
		this.availableBalance = availableBalance;
		this.date = date;
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.customer = customer;
	}
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
    
	
}
