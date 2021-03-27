package com.homeshopping.myapp.shopping.dao.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.homeshopping.myapp.shopping.model.admin.Admin_VO;

@Repository
public class Admin_Repo implements IAdmin_Repo{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class AdminMapper implements org.springframework.jdbc.core.RowMapper<Admin_VO>{

		public Admin_VO mapRow(ResultSet rs, int count) throws SQLException {
		
			Admin_VO admin = new Admin_VO();
			admin.setA_no(rs.getInt("A_NO"));
			admin.setA_id(rs.getString("A_ID"));
			admin.setA_pw(rs.getString("A_PW"));
			admin.setL_last_acc(rs.getDate("A_LAST_ACC"));
			
			return admin;			
		}
	}
	
	@Override
	public int getALLAdminCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from admin";
		
		return (int)jdbcTemplate.queryForObject(sql, Integer.class);

	}

	@Override
	public Admin_VO getAdminInfo_ID(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from admin where A_ID=?";
		return jdbcTemplate.queryForObject(sql,new AdminMapper(),id);

	}

	@Override
	public List<Admin_VO> getAdminInfo_List() {
		// TODO Auto-generated method stub
		String sql = "select * from admin";
		
		return jdbcTemplate.query(sql, new AdminMapper());
	}

	@Override
	public void instertAdminInfo(Admin_VO vo) {
		// TODO Auto-generated method stub
		String sql = "insert into admin (A_ID, A_PW, A_LAST_ACC)"
				+" values(?,?)";
		
		jdbcTemplate.update(sql,
				vo.getA_id(),
				vo.getA_pw());
	}

	@Override
	public void deleteAdminnfo(String id) {
		// TODO Auto-generated method stub
		String sql = "delte from admin where A_ID=?";
		
		jdbcTemplate.update(sql, id);
		
	}

	@Override
	public Boolean check_Admin(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from admin where A_ID=?";
		try {
			if(jdbcTemplate.queryForObject(sql,new AdminMapper(),id) != null) {
				return true;
			}	
		}catch (EmptyResultDataAccessException e) {
			
		}
				
		return false;

	}
	
}
