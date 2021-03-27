package com.homeshopping.myapp.shopping.dao.pay;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.homeshopping.myapp.shopping.model.pay.Pay_VO;

@Repository
public class Pay_Repo implements IPay_Repo{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class PayMapper implements org.springframework.jdbc.core.RowMapper<Pay_VO>{
		
		public Pay_VO mapRow(ResultSet rs, int count) throws SQLException {
			Pay_VO pay = new Pay_VO();
			
			pay.setPay_no(rs.getInt("PAY_NO"));
			pay.setC_no(rs.getInt("C_NO"));
			pay.setPr_no(rs.getInt("PR_NO"));
			pay.setPay_date(rs.getDate("PAY_DATE"));
			pay.setPay_paidamount(rs.getString("PAY_PAIDAMOUNT"));
			pay.setPay_applynum(rs.getString("PAY_APPLYNUM"));
			pay.setPay_impuid(rs.getString("PAY_IMPUID"));
			pay.setPay_merchant(rs.getString("PAY_MERCHANT"));
			pay.setPay_price(rs.getInt("PAY_PRICE"));
			return pay;
		}
	}
	@Override
	public List<Pay_VO> getPayInfo_List() {
		// TODO Auto-generated method stub
		String sql = "select * from pay";
		
		return jdbcTemplate.query(sql, new PayMapper());
	}

	@Override
	public List<Pay_VO> getPayList_cNO(int cNO) {
		// TODO Auto-generated method stub
		String sql = "select * from pay where C_NO=?";
		
		return jdbcTemplate.query(sql, new PayMapper(), cNO);
	}

	@Override
	public void insertPayInfo(int cust_no,  int pro_no, Pay_VO pay_vo) {
		// TODO Auto-generated method stub
		String sql = "insert into pay (PR_NO, C_NO, PAY_PRICE, "
		+"PAY_IMPUID, PAY_MERCHANT, PAY_PAIDAMOUNT, PAY_APPLYNUM) "
				+ "values (?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(sql,
				cust_no,
				pro_no,
				pay_vo.getPay_price(),
				pay_vo.getPay_impuid(),
				pay_vo.getPay_merchant(),
				pay_vo.getPay_paidamount(),
				pay_vo.getPay_applynum());
    }

	@Override
	public void deletePayInfo(int pay_no) {
		// TODO Auto-generated method stub
		String sql = "delete from pay where PAY_NO=?";
		
		jdbcTemplate.update(sql, pay_no);
		
	}

}
