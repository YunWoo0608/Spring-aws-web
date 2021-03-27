package com.homeshopping.myapp.shopping.model.login;

/*해당 VO 객체는 login 시 넘오는 form 값 처리를 위해서 쓴다.*/
public class Login_VO {
	private String sID;
	private String sPW;
	public String getsID() {
		return sID;
	}
	public void setsID(String sID) {
		this.sID = sID;
	}
	public String getsPW() {
		return sPW;
	}
	public void setsPW(String sPW) {
		this.sPW = sPW;
	}
	@Override
	public String toString() {
		return "login_VO [sID=" + sID + ", sPW=" + sPW + "]";
	}
	
	
	
}
