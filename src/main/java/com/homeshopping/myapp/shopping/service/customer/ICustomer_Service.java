package com.homeshopping.myapp.shopping.service.customer;

import java.util.List;

import com.homeshopping.myapp.shopping.model.customer.Customer_VO;

public interface ICustomer_Service {
	
	//모든 고객 정보 리스트
	public List<Customer_VO> getAllList();
	//고객 정보 가져오기
	public Customer_VO getCustInfo(String id);
	
}
