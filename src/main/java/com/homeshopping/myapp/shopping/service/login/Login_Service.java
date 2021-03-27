package com.homeshopping.myapp.shopping.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeshopping.myapp.shopping.dao.admin.IAdmin_Repo;
import com.homeshopping.myapp.shopping.dao.customer.ICustomer_Repo;

@Service
public class Login_Service implements ILogin_Service{

	
	  @Autowired 
	  ICustomer_Repo cust_repo;
	  
	  @Autowired 
	  IAdmin_Repo admin_repo;
	  
	  @Override
	  public String Check_User(String UserID) { // TODO Auto-generated method stub 
		  // 고객인지 관리자인지 
		  if(cust_repo.check_Cust(UserID) != false) { 
			  return  "cust"; 
			  }else if(admin_repo.check_Admin(UserID) != false){ 
				  return "admin"; 
			  }
	  
		  return null; 
	  } 

}
