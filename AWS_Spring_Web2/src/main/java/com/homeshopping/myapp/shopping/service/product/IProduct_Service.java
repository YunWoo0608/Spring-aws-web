package com.homeshopping.myapp.shopping.service.product;

import java.sql.SQLException;
import java.util.List;

import com.homeshopping.myapp.shopping.model.product.Product_VO;

public interface IProduct_Service {

	//상품 리스트 가져오기
	public List<Product_VO> getAllList();
	//특정 상품 조회
	public Product_VO getProInfo(int no);
	
	//특정 상품의 재고 개수 조절
	public void updateStock(int pr_no, int adjnum) throws SQLException;
}
