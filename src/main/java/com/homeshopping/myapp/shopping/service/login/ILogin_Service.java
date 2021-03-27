package com.homeshopping.myapp.shopping.service.login;

public interface ILogin_Service {

	//로그인 서비스 
	//해당 사용자가 관리자인가 회원인가
	String Check_User(String UserID);
	
}
