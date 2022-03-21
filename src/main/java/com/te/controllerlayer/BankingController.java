package com.te.controllerlayer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.dtolayer.Customer;
import com.te.servicelayer.ServiceLayer;

@Controller
public class BankingController {
	
	@Autowired
	private ServiceLayer serviceLayer;
	
	@PostMapping("/response")
	public String processRegistration(Customer customer,ModelMap map) {
		if(serviceLayer.addService(customer)) {
			map.addAttribute("message", "Bank Registration is successfull");
			map.addAttribute("customerSaved",customer);
		}
		else {
			map.addAttribute("message","Unable to Register Contact Bank Manager");
		}
		return "CreateResponse";
	}
	
	@GetMapping("/register")
	public String register(Customer customer) {
		return "index";
	}
	
	@GetMapping("/loginpage")
	public String loginPage() {
		return "CustomerLogin";
	}
	
	@PostMapping("/login")
	public String loginCustomer(int customerId,String password,ModelMap map,HttpServletRequest request) {
		HttpSession session = request.getSession();
		boolean customer = serviceLayer.loginService(customerId, password);
		if(customer!=false) {
			session.setAttribute("loggedIn", session);
			map.addAttribute("msg", "Logged in successfully");
		}
		else {
			map.addAttribute("msg","Invalid credentials");
		}
		
		return "loginresponse";
	}
	
	@GetMapping("/deposit")
	public String  deposit(@SessionAttribute(name="s1",required=false) String session){
		/*if(session!=null) {
			return "depositform";
		}
		else {
			return "CustomerLogin";
		}*/
		
		return "depositform";
	}
	@PostMapping("/depositAmount")
	public String deposit(String userName,int accountNo,long mobileNo,double amount,ModelMap map) {
		if(serviceLayer.deposit(userName, accountNo, mobileNo, amount)) {
			map.addAttribute("msg","Your Amount has been Deposit successfully");
			map.addAttribute("amount","Your Amount "+amount+" rupees not added please");
		}
		else {
			map.addAttribute("msg", "Your are invalid Account Holder");
			map.addAttribute("amount", "Your Amount "+amount+" rupees Not Added.Please take your Cash.....");
		}
		
		return "depositmessage";
	}
	@GetMapping(path="/withdraw")
    public String withdraw(@SessionAttribute(name="us",required=false)String session) {
    	if(session!=null) {
    		return "withdraw";
    	}else {
    		return "CustomerLogin";
    	}
    }
    
    @PostMapping(path="/withdrawAmount")
    public String withdrawAmount(String userName,long accountNumber,String mobileNumber,double amount,ModelMap map) {
    	if(serviceLayer.withdraw(userName,accountNumber, mobileNumber, amount)) {
			map.addAttribute("msg", "Take Your Amount....");
			map.addAttribute("amount", "Your Amount "+amount+" rupees withdraw Successfully....");
		}else {
			
			map.addAttribute("msg", " In Sufficient Funds OR You Are Invalid Account Holder Check your details.....");
			map.addAttribute("amount", "Your Amount "+amount+" rupees Not withdraw");
		}
		
    	return"withdrawconfirmation";  
    }

}
