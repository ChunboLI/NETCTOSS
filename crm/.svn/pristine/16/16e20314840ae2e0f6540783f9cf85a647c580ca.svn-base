package com.tarena.crm.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.tarena.crm.entity.Custom;
import com.tarena.crm.entity.Customcare;
import com.tarena.crm.entity.CustomcareInfo;
import com.tarena.crm.entity.Emp;
import com.tarena.db.DBUtils;

public class CustomCareInfoDaoImpl {
	
	public List<CustomcareInfo> findAll() throws Exception {
		List<CustomcareInfo> customcare = new ArrayList<CustomcareInfo>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			conn = DBUtils.getConnection();
			prep = conn.prepareStatement("select * from CustomCare");
			rs = prep.executeQuery();
			while(rs.next()){
				
				long id = rs.getLong("id");
				Custom c = new CustomDaoImpl().findById(rs.getInt("custom"));
				String customName = c.getName();
				String theme = rs.getString("theme");
				String way = rs.getString("way");
				String time = sdf.format(new Date(rs.getTimestamp("time").getTime()));
				String nextTime = sdf.format(new Date(rs.getTimestamp("nextTime").getTime()));
				String remarks = rs.getString("remarks");
				Emp emp = new EmpDaoImpl().findById(rs.getInt("emp"));
				String empName = emp.getName();
				
				CustomcareInfo ccf = new CustomcareInfo();
				ccf.setId(id);
				ccf.setCustomName(customName);
				ccf.setTheme(theme);
				ccf.setWay(way);
				ccf.setTime(time);
				ccf.setNextTime(nextTime);
				ccf.setRemarks(remarks);
				ccf.setEmpName(empName);
				customcare.add(ccf);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DBUtils.closeConnection(conn);
			
		}
		return customcare;
	}

	public CustomcareInfo findById(long id) throws Exception {
		CustomcareInfo ccf = new CustomcareInfo();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			conn = DBUtils.getConnection();
			prep = conn.prepareStatement("select * from CustomCare where id =?");
			prep.setLong(1, id);
			rs = prep.executeQuery();
			while(rs.next()){
				Custom c = new CustomDaoImpl().findById(rs.getInt("custom"));
				String customName = c.getName();
				String theme = rs.getString("theme");
				String way = rs.getString("way");
				String time = sdf.format(new Date(rs.getTimestamp("time").getTime()));
				String nextTime = sdf.format(new Date(rs.getTimestamp("nextTime").getTime()));
				String remarks = rs.getString("remarks");
				Emp emp = new EmpDaoImpl().findById(rs.getInt("emp"));
				String empName = emp.getName();
			
				ccf.setId(id);
				ccf.setCustomName(customName);
				ccf.setTheme(theme);
				ccf.setWay(way);
				ccf.setTime(time);
				ccf.setNextTime(nextTime);
				ccf.setRemarks(remarks);
				ccf.setEmpName(empName);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DBUtils.closeConnection(conn);
			
		}
		return ccf;
	}
}
