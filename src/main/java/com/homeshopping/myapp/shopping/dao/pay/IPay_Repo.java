package com.homeshopping.myapp.shopping.dao.pay;

import java.util.List;

import com.homeshopping.myapp.shopping.model.pay.Pay_VO;

public interface IPay_Repo {

	//조회
	//1) 모두 조회 
	public List<Pay_VO> getPayInfo_List();
	//2) 특정 결제 정보 조회 ( 회원 ID로 조회 )
	public List<Pay_VO> getPayList_cNO(int cNO);
	//삽입(생성)
	public void insertPayInfo(int cust_no,  int pro_no, Pay_VO pay_vo);
	//수정
	
	//삭제 (결제 번호)
	public void deletePayInfo(int pay_no);
}
