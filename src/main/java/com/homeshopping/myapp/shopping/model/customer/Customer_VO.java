package com.homeshopping.myapp.shopping.model.customer;

import java.sql.Date;
import java.sql.Timestamp;

/*C_NO		int NOT NULL auto_increment,
C_ID		varchar(30) NOT NULL,
C_PW		varchar(50) NOT NULL,
C_NAME		varchar(40) NOT NULL,
C_ADD		varchar(100) NOT NULL,
C_EMAIL		varchar(50) NOT NULL,
C_PHONE		varchar(50) NOT NULL,
C_DATE		DATETIME DEFAULT CURRENT_TIMESTAMP,
C_GRADE		char(10),
*/
public class Customer_VO {

	private int c_no;
	private String c_id;
	private String c_pw;
	private String c_name;
	private String c_add;
	private String c_email;
	private String c_phone;
	private Date c_date;
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_pw() {
		return c_pw;
	}
	public void setC_pw(String c_pw) {
		this.c_pw = c_pw;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_add() {
		return c_add;
	}
	public void setC_add(String c_add) {
		this.c_add = c_add;
	}
	public String getC_email() {
		return c_email;
	}
	public void setC_email(String c_email) {
		this.c_email = c_email;
	}
	public String getC_phone() {
		return c_phone;
	}
	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}
	public Date getC_date() {
		return c_date;
	}
	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}
	@Override
	public String toString() {
		return "Customer_VO [c_no=" + c_no + ", c_id=" + c_id + ", c_pw=" + c_pw + ", c_name=" + c_name + ", c_add="
				+ c_add + ", c_email=" + c_email + ", c_phone=" + c_phone + ", c_date=" + c_date + "]";
	}

	
}
