package com.homeshopping.myapp.shopping.model.product;

/*해당 VO 객체는 product_detail 의 form 값을 받기 위해서 사용*/
public class Product_Detail_VO {
	private int count;
	private int pr_no;

	
	public int getPr_no() {
		return pr_no;
	}

	public void setPr_no(int pr_no) {
		this.pr_no = pr_no;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Product_Detail_VO [count=" + count + ", pr_no=" + pr_no + "]";
	}


	
}
