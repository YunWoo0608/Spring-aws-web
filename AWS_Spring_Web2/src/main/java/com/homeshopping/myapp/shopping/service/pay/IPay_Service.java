package com.homeshopping.myapp.shopping.service.pay;

import java.util.List;

import com.homeshopping.myapp.shopping.model.pay.Pay_VO;

public interface IPay_Service {

	//결제 생성
	public void newPay(int cust_no, int pro_no, Pay_VO pay_vo);
	//결제 삭제
	public void delPay(int pay_no);
	//특정 결제 정보 조회
	public List<Pay_VO> showPayList(int cNO);
}
