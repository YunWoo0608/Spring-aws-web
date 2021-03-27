package com.homeshopping.myapp.shopping.dao.customer;

import java.util.List;

import com.homeshopping.myapp.shopping.model.customer.Customer_VO;

public interface ICustomer_Repo {

	//조회
	//전체 회원 수 
	public int getALLCustCount();
	//ID 로 조회 (단일 객체가져오기)
	public Customer_VO getCustInfo_ID(String id);
	//모든 회원 정보List로 가져오기
	List<Customer_VO> getCustInfo_List();
	
	//판별 
	public Boolean check_Cust(String id);
	//삽입
	public void instertCustInfo(Customer_VO vo);
	//변경 
	//삭제 (회원 ID로 삭제)
	public void deleteCustInfo(String id);
	
}
