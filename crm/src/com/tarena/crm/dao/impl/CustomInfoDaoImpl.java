package com.tarena.crm.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.crm.entity.Custom;
import com.tarena.crm.entity.CustomInfo;
import com.tarena.crm.entity.Customsource;
import com.tarena.crm.entity.Customstatus;
import com.tarena.crm.entity.Customtype;
import com.tarena.crm.entity.Emp;
import com.tarena.db.DBUtils;

public class CustomInfoDaoImpl {
	
	public List<CustomInfo> findAll() throws Exception {
		List<CustomInfo> cilist = new ArrayList<CustomInfo>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			prep = conn.prepareStatement("select * from Custom");
			rs = prep.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				String name = rs.getString("name");
				String job = rs.getString("job");
				String gender = rs.getInt("gender")==0?"男":"女";
				String qq = rs.getString("qq");
				Customstatus cst = new CustomStatusDaoImpl().findById(rs.getInt("status"));
				String status = cst.getStatus();			
				Customsource cso = new CustomSourceDaoImpl().findById(rs.getInt("source"));
				String source = cso.getSource();
				Customtype ct = new CustomTypeDaoImpl().findById(rs.getInt("type"));
				String type = ct.getType();
				String email = rs.getString("email");
				String mobliePhone = rs.getString("mobliePhone");
				String company = rs.getString("company");
				String remarks = rs.getString("remarks");
				Emp emp = new EmpDaoImpl().findById(rs.getLong("belongTo"));
				String empName = emp.getName();
				
				
				CustomInfo c = new CustomInfo();
				c.setId(id);
				c.setCustomName(name);
				c.setJob(job);
				c.setGender(gender);
				c.setQq(qq);
				c.setStatus(status);
				c.setSource(source);
				c.setType(type);
				c.setEmail(email);
				c.setMobliePhone(mobliePhone);
				c.setCompany(company);
				c.setRemarks(remarks);
				c.setEmpName(empName);
				cilist.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DBUtils.closeConnection(conn);
			
		}
		return cilist;
	}
		
		
	
}
