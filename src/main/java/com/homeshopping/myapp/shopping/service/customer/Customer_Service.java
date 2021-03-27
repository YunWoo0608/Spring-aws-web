package com.homeshopping.myapp.shopping.service.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeshopping.myapp.shopping.dao.customer.ICustomer_Repo;
import com.homeshopping.myapp.shopping.model.customer.Customer_VO;

@Service
public class Customer_Service implements ICustomer_Service {

	@Autowired
	ICustomer_Repo cust_repo;
	
	@Override
	public List<Customer_VO> getAllList() {
		// TODO Auto-generated method stub
		return cust_repo.getCustInfo_List();
	}

	@Override
	public Customer_VO getCustInfo(String id) {
		// TODO Auto-generated method stub
		return cust_repo.getCustInfo_ID(id);
	}

}
