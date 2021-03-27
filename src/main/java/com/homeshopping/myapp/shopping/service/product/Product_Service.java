package com.homeshopping.myapp.shopping.service.product;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeshopping.myapp.shopping.dao.product.IProduct_Repo;
import com.homeshopping.myapp.shopping.model.product.Product_VO;

@Service
public class Product_Service implements IProduct_Service{

	@Autowired
	IProduct_Repo pro_repo;

	@Override
	public List<Product_VO> getAllList() {
		// TODO Auto-generated method stub
		
		return pro_repo.getproList();
	}

	@Override
	public Product_VO getProInfo(int no) {
		// TODO Auto-generated method stub
		return pro_repo.getproInfo_NO(no);
	}

	@Override
	public void updateStock(int pr_no, int adjnum) throws SQLException {
		// TODO Auto-generated method stub
		pro_repo.updateStock(pr_no, adjnum);
	}
	

}
