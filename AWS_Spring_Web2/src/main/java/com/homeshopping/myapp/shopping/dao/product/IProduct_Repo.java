package com.homeshopping.myapp.shopping.dao.product;

import java.sql.SQLException;
import java.util.List;

import com.homeshopping.myapp.shopping.model.product.Product_VO;

public interface IProduct_Repo {

	//조회
	//1. 전체 상품 리스트
	public List<Product_VO> getproList();
	//2. 특정 상품 정보 (상품 번호)
	public Product_VO getproInfo_NO(int no);
	//삽입
	public void insert_proInfo(Product_VO vo);
	//수정
	//1. 특정 제품의 재고 개수 조절
	public void updateStock(int pr_no, int adjnum) throws SQLException;
	//삭제 (상품 번호)
	public void delete_proInfo(int no);
	
}
