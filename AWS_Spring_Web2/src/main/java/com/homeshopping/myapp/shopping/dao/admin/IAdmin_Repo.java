package com.homeshopping.myapp.shopping.dao.admin;

import java.util.List;

import com.homeshopping.myapp.shopping.model.admin.Admin_VO;

public interface IAdmin_Repo {


	//조회
	//전체 관리자 수 
	public int getALLAdminCount();
	//ID 로 조회 (단일 객체가져오기)
	public Admin_VO getAdminInfo_ID(String id);
	//모든 회원 정보List로 가져오기
	List<Admin_VO> getAdminInfo_List();
	
	//판별 
	public Boolean check_Admin(String id);
	
	//삽입
	public void instertAdminInfo(Admin_VO vo);
	//변경 
	//삭제 (회원 ID로 삭제)
	public void deleteAdminnfo(String id);
}
