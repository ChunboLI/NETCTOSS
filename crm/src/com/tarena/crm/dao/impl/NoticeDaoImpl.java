package com.tarena.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.crm.dao.BaseDao;
import com.tarena.crm.entity.Notice;
import com.tarena.db.DBUtils;

public class NoticeDaoImpl extends com.tarena.db.BaseDao<Notice> implements BaseDao<Notice>{

	@Override
	public Notice add(Notice entity) throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtils.getConnection();
			ps=conn.prepareStatement("insert into Notice(emp,theme,content" +
					",time,endTime" +
					")values(?,?,?,?,?)");
			ps.setLong(1,entity.getEmp());
			ps.setString(2,entity.getTheme());
			ps.setString(3, entity.getContent());
			ps.setDate(4, new java.sql.Date(entity.getTime().getTime()));
			ps.setDate(5, new java.sql.Date(entity.getEndTime().getTime()));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection(conn);
		}
		return entity;
	}

	@Override
	public boolean delete(long id) throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtils.getConnection();
			ps=conn.prepareStatement("delete from Notice where id=?");
			ps.setLong(1, id);
			if(ps.executeUpdate()>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection(conn);
		}
		return false;
	}

	@Override
	public boolean modify(Notice entity) throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtils.getConnection();
			ps=conn.prepareStatement("update Notice set emp=?,theme=?,content=?" +
					",time=?,endTime=? where id=?");
			ps.setLong(1,entity.getEmp());
			ps.setString(2,entity.getTheme());
			ps.setString(3, entity.getContent());
			ps.setDate(4, new java.sql.Date(entity.getTime().getTime()));
			ps.setDate(5, new java.sql.Date(entity.getEndTime().getTime()));
			ps.setLong(6, entity.getId());
			if(ps.executeUpdate()>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection(conn);
		}
		return false;
	}

	@Override
	public Notice findById(long id) throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		Notice notice=new Notice();
		try {
			conn=DBUtils.getConnection();
			ps=conn.prepareStatement("select * from Notice where id=?");
			ps.setLong(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				notice.setContent(rs.getString("content"));
				notice.setEmp(rs.getInt("emp"));
				notice.setEndTime(rs.getDate("endtime"));
				notice.setId(rs.getLong("id"));
				notice.setTheme(rs.getString("theme"));
				notice.setTime(rs.getDate("time"));
		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection(conn);
		}
		return notice;
	}

	@Override
	public List<Notice> findByName(String name) throws Exception {
		return null;
	}
	public List<Notice>findByTheme(String theme)throws Exception {
		return queryEntity("select * from Notice where theme=?",theme);
	}


	@Override
	public List<Notice> findAll() throws Exception {
		return queryEntity("select * from Notice",null);
	}

	@Override
	public Notice toEntity(ResultSet rs) throws Exception {
			Notice notice =new Notice();
			notice.setContent(rs.getString("content"));
			notice.setEmp(rs.getInt("emp"));
			notice.setEndTime(rs.getDate("endtime"));
			notice.setId(rs.getLong("id"));
			notice.setTheme(rs.getString("theme"));
			notice.setTime(rs.getDate("time"));
			return notice;
	}

}
