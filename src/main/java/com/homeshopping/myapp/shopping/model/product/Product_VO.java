package com.homeshopping.myapp.shopping.model.product;

/*PR_NO		int NOT NULL auto_increment,
PR_TYPE		VARCHAR(20) NOT NULL,
PR_NAME		varchar(100) NOT NULL,
PR_PRICE	int NOT NULL,
PR_STOCK_NUM int DEFAULT 0,
PR_COUNT	int DEFAULT 0 ,
M_NO		int DEFAULT 0,
D_CODE		int,
*/
public class Product_VO {

	private int pr_no;
	private String pr_type;
	private String pr_name;
	private int pr_price;
	private int pr_stock_num;
	private int pr_count;
	public int getPr_no() {
		return pr_no;
	}
	public void setPr_no(int pr_no) {
		this.pr_no = pr_no;
	}
	public String getPr_type() {
		return pr_type;
	}
	public void setPr_type(String pr_type) {
		this.pr_type = pr_type;
	}
	public String getPr_name() {
		return pr_name;
	}
	public void setPr_name(String pr_name) {
		this.pr_name = pr_name;
	}
	public int getPr_price() {
		return pr_price;
	}
	public void setPr_price(int pr_price) {
		this.pr_price = pr_price;
	}
	public int getPr_stock_num() {
		return pr_stock_num;
	}
	public void setPr_stock_num(int pr_stock_num) {
		this.pr_stock_num = pr_stock_num;
	}
	public int getPr_count() {
		return pr_count;
	}
	public void setPr_count(int pr_count) {
		this.pr_count = pr_count;
	}
	@Override
	public String toString() {
		return "Product_VO [pr_no=" + pr_no + ", pr_type=" + pr_type + ", pr_name=" + pr_name + ", pr_price=" + pr_price
				+ ", pr_stock_num=" + pr_stock_num + ", pr_count=" + pr_count + "]";
	}
	
}
