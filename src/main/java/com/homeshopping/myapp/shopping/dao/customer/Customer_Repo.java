package com.homeshopping.myapp.shopping.dao.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.homeshopping.myapp.shopping.model.customer.Customer_VO;

@Repository
public class Customer_Repo implements ICustomer_Repo {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class CustMapper implements org.springframework.jdbc.core.RowMapper<Customer_VO>{

		public Customer_VO mapRow(ResultSet rs, int count) throws SQLException {
		
			Customer_VO cust = new Customer_VO();
			cust.setC_no(rs.getInt("C_NO"));
			cust.setC_id(rs.getString("C_ID"));
			cust.setC_pw(rs.getString("C_PW"));
			cust.setC_name(rs.getString("C_NAME"));
			cust.setC_phone(rs.getString("C_PHONE"));
			cust.setC_date(rs.getDate("C_DATE"));
			cust.setC_email(rs.getString("C_EMAIL"));
			cust.setC_pw(rs.getString("C_ADD"));
			
			return cust;			
		}
	}
	
	@Override
	public int getALLCustCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from customer";
		
		return (int)jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public Customer_VO getCustInfo_ID(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from customer where C_ID=?";
		return jdbcTemplate.queryForObject(sql,new CustMapper(),id);
	}

	@Override
	public List<Customer_VO> getCustInfo_List() {
		// TODO Auto-generated method stub
		String sql = "select * from customer";
		
		return jdbcTemplate.query(sql, new CustMapper());
	}

	@Override
	public void instertCustInfo(Customer_VO vo) {
		// TODO Auto-generated method stub
		String sql = "insert into customer (C_ID, C_PW, C_NAME,"
				+ " C_EMAIL, C_PHONE, C_ADD"
				+ " values(?,?,?,?,?,?)";
		
		jdbcTemplate.update(sql, 
				vo.getC_id(),
				vo.getC_pw(),
				vo.getC_name(),
				vo.getC_email(),
				vo.getC_phone(),
				vo.getC_add());
	}

	@Override
	public void deleteCustInfo(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from customer where C_ID=?";
		
		jdbcTemplate.update(sql,id);
	}

	@Override
	public Boolean check_Cust(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from customer where C_ID=?";
		try {
			if(jdbcTemplate.queryForObject(sql,new CustMapper(),id) != null) {
				return true;
			}	
		}catch(EmptyResultDataAccessException e) {
				
		}
		return false;	
	
	}

}
