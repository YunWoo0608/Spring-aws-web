package com.homeshopping.myapp.shopping.model.pay;

import java.sql.Date;

/*PAY_NO 		int NOT NULL auto_increment,
PR_NO	 	int,
C_NO 		int,
T_CODE 		int,
PAY_PRICE 	int,
PAY_DATE	DATETIME DEFAULT CURRENT_TIMESTAMP,
PAY_CANCLE	bool,  
PAY_IMPUID	varchar(50) NOT NULL,
PAY_MERCHANT varchar(50) NOT NULL,
PAY_PAIDAMOUNT varchar(50) NOT NULL,
PAY_APPLYNUM	varchar(50) NOT NULL,
*/
public class Pay_VO {
	
	private int pay_no;
	private int pr_no;
	private int c_no;
	private int pay_price;
	private Date pay_date;
	private String pay_impuid;
	private String pay_merchant;
	private String pay_paidamount;
	private String pay_applynum;
	public int getPay_no() {
		return pay_no;
	}
	public void setPay_no(int pay_no) {
		this.pay_no = pay_no;
	}
	public int getPr_no() {
		return pr_no;
	}
	public void setPr_no(int pr_no) {
		this.pr_no = pr_no;
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public int getPay_price() {
		return pay_price;
	}
	public void setPay_price(int pay_price) {
		this.pay_price = pay_price;
	}
	public Date getPay_date() {
		return pay_date;
	}
	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}
	public String getPay_impuid() {
		return pay_impuid;
	}
	public void setPay_impuid(String pay_impuid) {
		this.pay_impuid = pay_impuid;
	}
	public String getPay_merchant() {
		return pay_merchant;
	}
	public void setPay_merchant(String pay_merchant) {
		this.pay_merchant = pay_merchant;
	}
	public String getPay_paidamount() {
		return pay_paidamount;
	}
	public void setPay_paidamount(String pay_paidamount) {
		this.pay_paidamount = pay_paidamount;
	}
	public String getPay_applynum() {
		return pay_applynum;
	}
	public void setPay_applynum(String pay_applynum) {
		this.pay_applynum = pay_applynum;
	}
	@Override
	public String toString() {
		return "Pay_VO [pay_no=" + pay_no + ", pr_no=" + pr_no + ", c_no=" + c_no + ", pay_price=" + pay_price
				+ ", pay_date=" + pay_date + ", pay_impuid=" + pay_impuid + ", pay_merchant=" + pay_merchant
				+ ", pay_paidamount=" + pay_paidamount + ", pay_applynum=" + pay_applynum + "]";
	}
	

	
}
