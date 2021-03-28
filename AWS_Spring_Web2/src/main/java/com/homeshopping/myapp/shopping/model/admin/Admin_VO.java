package com.homeshopping.myapp.shopping.model.admin;

import java.sql.Date;
import java.sql.Timestamp;

/*A_NO		int NOT NULL auto_increment,
A_ID		varchar(30) NOT NULL,
A_PW		varchar(50) NOT NULL,
A_LAST_ACC	DATETIME DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(A_NO)
*/
public class Admin_VO {
	
	private int a_no;
	private String a_id;
	private String a_pw;
	private Date l_last_acc;
	public int getA_no() {
		return a_no;
	}
	public void setA_no(int a_no) {
		this.a_no = a_no;
	}
	public String getA_pw() {
		return a_pw;
	}
	public void setA_pw(String a_pw) {
		this.a_pw = a_pw;
	}
	public Date getL_last_acc() {
		return l_last_acc;
	}
	public void setL_last_acc(Date l_last_acc) {
		this.l_last_acc = l_last_acc;
	}
	
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	@Override
	public String toString() {
		return "Admin_VO [a_no=" + a_no + ", a_pw=" + a_pw + ", l_last_acc=" + l_last_acc + "]";
	}

	
}
