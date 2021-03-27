package com.homeshopping.myapp.shopping.service.pay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeshopping.myapp.shopping.dao.pay.IPay_Repo;
import com.homeshopping.myapp.shopping.model.pay.Pay_VO;

@Service
public class Pay_Service implements IPay_Service{

	@Autowired
	IPay_Repo pay_repo;
	
	@Override
	public void newPay(int cust_no, int pro_no, Pay_VO pay_vo) {
		// TODO Auto-generated method stub
		pay_repo.insertPayInfo(cust_no, pro_no, pay_vo);
	}

	@Override
	public void delPay(int pay_no) {
		// TODO Auto-generated method stub
		pay_repo.deletePayInfo(pay_no);
		
	}

	@Override
	public List<Pay_VO> showPayList(int cNO) {
		// TODO Auto-generated method stub
		return pay_repo.getPayList_cNO(cNO);
	}

}
