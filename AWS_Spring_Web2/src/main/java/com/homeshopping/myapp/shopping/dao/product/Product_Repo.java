package com.homeshopping.myapp.shopping.dao.product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.homeshopping.myapp.shopping.model.product.Product_VO;

@Repository
public class Product_Repo implements IProduct_Repo {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class ProMapper implements org.springframework.jdbc.core.RowMapper<Product_VO>{
		
		public Product_VO mapRow(ResultSet rs, int count) throws SQLException{
			Product_VO pro = new Product_VO();
			pro.setPr_no(rs.getInt("PR_NO"));
			pro.setPr_name(rs.getString("PR_NAME"));
			pro.setPr_type(rs.getString("PR_TYPE"));
			pro.setPr_stock_num(rs.getInt("PR_STOCK_NUM"));
			pro.setPr_price(rs.getInt("PR_PRICE"));
			pro.setPr_count(rs.getInt("PR_COUNT"));
			
			return pro;
		}
	}
	
	
	@Override
	public List<Product_VO> getproList() {
		// TODO Auto-generated method stub
		String sql = "select * from product";
		
		return jdbcTemplate.query(sql, new ProMapper());
	}

	@Override
	public Product_VO getproInfo_NO(int no) {
		// TODO Auto-generated method stub
		String sql = "select * from product where PR_NO=?";
		
		return jdbcTemplate.queryForObject(sql, new ProMapper(),no);
	}

	@Override
	public void insert_proInfo(Product_VO vo) {
		// TODO Auto-generated method stub
		String sql = "insert into (PR_NAME, PR_PRICE, PR_STOCK_NUM, PR_COUNT, PR_TYPE) "
			+ "values (?,?,?,?,?)";
		
		jdbcTemplate.update(sql,
				vo.getPr_name(),
				vo.getPr_price(),
				vo.getPr_stock_num(),
				vo.getPr_count(),
				vo.getPr_type());
	}

	@Override
	public void delete_proInfo(int no) {
		// TODO Auto-generated method stub
		String sql = "delete from product where PR_NO=?";
		
		jdbcTemplate.update(sql,no);
		
	}

	@Override
	public void updateStock(int pr_no, int adjnum) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "update product set PR_STOCK_NUM=? where PR_NO=?";
		int res = 0;
		PreparedStatement  stmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
		stmt.setInt(1,adjnum);
		stmt.setInt(2,pr_no);
		res = stmt.executeUpdate();
		//성공
		if(res > 0) {
			//jdbcTemplate.getDataSource().getConnection().commit();
		}else{ //실패
			System.out.println("updateStock 에러");
		}	
	}

}
