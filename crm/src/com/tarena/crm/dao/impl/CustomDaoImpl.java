package com.tarena.crm.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.crm.entity.Custom;
import com.tarena.crm.entity.Customcare;
import com.tarena.crm.entity.Customstatus;
import com.tarena.db.DBUtils;


public class CustomDaoImpl extends BaseDaoImpl<Custom>{

	@Override
	public Custom add(Custom entity) throws Exception {
		Connection conn =null;
		PreparedStatement prep = null;
		try {
			conn = DBUtils.getConnection();
			prep = conn.prepareStatement("insert into Custom (name,job,gender,birthday,qq,weibo,msn,creator,status,source,type,email,mobliePhone,phone,address,company,modifier,remarks,createDate,belongTo)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			prep.setString(1, entity.getName());
			prep.setString(2, entity.getJob());
			prep.setInt(3, entity.getGender());
			prep.setDate(4, new java.sql.Date(entity.getBirthday().getTime()));
			prep.setString(5, entity.getQq());
			prep.setString(6, entity.getWeibo());
			prep.setString(7, entity.getMsn());
			prep.setLong(8, entity.getCreator());
			prep.setInt(9, entity.getStatus());
			prep.setInt(10, entity.getSource());
			prep.setInt(11, entity.getType());
			prep.setString(12, entity.getEmail());
			prep.setString(13, entity.getMobliePhone());
			prep.setString(14, entity.getPhone());
			prep.setString(15, entity.getAddress());
			prep.setString(16, entity.getCompany());
			prep.setInt(17, entity.getModifier());
			prep.setString(18, entity.getRemarks());
			prep.setDate(19, new java.sql.Date(entity.getCreateDate().getTime()));
			prep.setLong(20, entity.getBelongTo());
			
			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DBUtils.closeConnection(conn);
			
		}
		return entity;
	}

	@Override
	public boolean delete(long id) throws Exception {
		Connection conn =null;
		PreparedStatement prep = null;
		try {
			conn = DBUtils.getConnection();
			prep = conn.prepareStatement("delete from Custom where id=?");
			prep.setLong(1, id);
			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DBUtils.closeConnection(conn);
			
		}
		return true;
	}

	@Override
	public boolean modify(Custom entity) throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBUtils.getConnection();
			prep = conn.prepareStatement("update Custom set name=?,job=?,gender=?,birthday=?,qq=?,weibo=?,msn=?,creator=?,status=?,source=?,type=?,email=?,mobliePhone=?,phone=?,address=?,company=?,modifier=?,remarks=?,createDate=?,belongTo=? where id=?");
			prep.setString(1, entity.getName());
			prep.setString(2, entity.getJob());
			prep.setInt(3, entity.getGender());
			prep.setDate(4, new java.sql.Date(entity.getBirthday().getTime()));
			prep.setString(5, entity.getQq());
			prep.setString(6, entity.getWeibo());
			prep.setString(7, entity.getMsn());
			prep.setLong(8, entity.getCreator());
			prep.setInt(9, entity.getStatus());
			prep.setInt(10, entity.getSource());
			prep.setInt(11, entity.getType());
			prep.setString(12, entity.getEmail());
			prep.setString(13, entity.getMobliePhone());
			prep.setString(14, entity.getPhone());
			prep.setString(15, entity.getAddress());
			prep.setString(16, entity.getCompany());
			prep.setInt(17, entity.getModifier());
			prep.setString(18, entity.getRemarks());
			prep.setDate(19, new java.sql.Date(entity.getCreateDate().getTime()));
			prep.setLong(20, entity.getBelongTo());
			prep.setLong(21, entity.getId());
			prep.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DBUtils.closeConnection(conn);
			
		}
		return true;
	}
	
	public boolean modify(long belongto,long id) throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBUtils.getConnection();
			prep = conn.prepareStatement("update Custom set belongTo=? where id=?");
			prep.setLong(1, belongto);
			prep.setLong(2, id);
			prep.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DBUtils.closeConnection(conn);
			
		}
		return true;
	}
	
	
	@Override
	public Custom findById(long id) throws Exception {
		Custom c = new Custom();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			prep = conn.prepareStatement("select * from custom where id=?");
			prep.setLong(1, id);
			rs = prep.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				String job = rs.getString("job");
				int gender = rs.getInt("gender");
				Date birthday = rs.getDate("birthday");
				String qq = rs.getString("qq");
				String weibo = rs.getString("weibo");
				String msn = rs.getString("msn");
				long creator = rs.getLong("creator");
				int status = rs.getInt("status");
				int source = rs.getInt("source");
				int type = rs.getInt("type");
				String email = rs.getString("email");
				String mobliePhone = rs.getString("mobliePhone");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String company = rs.getString("company");
				int modifier = rs.getInt("modifier");
				String remarks = rs.getString("remarks");
				Date createDate = rs.getDate("createDate");
				long belongTo = rs.getLong("belongTo");
				c.setId((long)id);
				c.setName(name);
				c.setJob(job);
				c.setGender(gender);
				c.setBirthday(birthday);
				c.setQq(qq);
				c.setWeibo(weibo);
				c.setMsn(msn);
				c.setCreator(creator);
				c.setStatus(status);
				c.setSource(source);
				c.setType(type);
				c.setEmail(email);
				c.setMobliePhone(mobliePhone);
				c.setPhone(phone);
				c.setAddress(address);
				c.setCompany(company);
				c.setModifier(modifier);
				c.setRemarks(remarks);
				c.setCreateDate(createDate);
				c.setBelongTo(belongTo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DBUtils.closeConnection(conn);
			
		}
		return c;
	}

	@Override
	public List<Custom> findByName(String name) throws Exception {
		List<Custom> list = new ArrayList<Custom>();

		Custom c = new Custom();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			prep = conn.prepareStatement("select * from Custom where name =?");
			prep.setString(1, name);
			rs = prep.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				String job = rs.getString("job");
				int gender = rs.getInt("gender");
				Date birthday = rs.getDate("birthday");
				String qq = rs.getString("qq");
				String weibo = rs.getString("weibo");
				String msn = rs.getString("msn");
				long creator = rs.getLong("creator");
				int status = rs.getInt("status");
				int source = rs.getInt("source");
				int type = rs.getInt("type");
				String email = rs.getString("email");
				String mobliePhone = rs.getString("mobliePhone");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String company = rs.getString("company");
				int modifier = rs.getInt("modifier");
				String remarks = rs.getString("remarks");
				Date createDate = rs.getDate("createDate");
				long belongTo = rs.getLong("belongTo");
				c.setId((long)id);
				c.setName(name);
				c.setJob(job);
				c.setGender(gender);
				c.setBirthday(birthday);
				c.setQq(qq);
				c.setWeibo(weibo);
				c.setMsn(msn);
				c.setCreator(creator);
				c.setStatus(status);
				c.setSource(source);
				c.setType(type);
				c.setEmail(email);
				c.setMobliePhone(mobliePhone);
				c.setPhone(phone);
				c.setAddress(address);
				c.setCompany(company);
				c.setModifier(modifier);
				c.setRemarks(remarks);
				c.setCreateDate(createDate);
				c.setBelongTo(belongTo);
				list.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DBUtils.closeConnection(conn);
			
		}
		return list;
	}

	@Override
	public List<Custom> findAll() throws Exception {
		List<Custom> custom = new ArrayList<Custom>();
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
				int gender = rs.getInt("gender");
				Date birthday = rs.getDate("birthday");
				String qq = rs.getString("qq");
				String weibo = rs.getString("weibo");
				String msn = rs.getString("msn");
				long creator = rs.getLong("creator");
				int status = rs.getInt("status");
				int source = rs.getInt("source");
				int type = rs.getInt("type");
				String email = rs.getString("email");
				String mobliePhone = rs.getString("mobliePhone");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String company = rs.getString("company");
				int modifier = rs.getInt("modifier");
				String remarks = rs.getString("remarks");
				Date createDate = rs.getDate("createDate");
				long belongTo = rs.getLong("belongTo");
				Custom c = new Custom();
				c.setId((long)id);
				c.setName(name);
				c.setJob(job);
				c.setGender(gender);
				c.setBirthday(birthday);
				c.setQq(qq);
				c.setWeibo(weibo);
				c.setMsn(msn);
				c.setCreator(creator);
				c.setStatus(status);
				c.setSource(source);
				c.setType(type);
				c.setEmail(email);
				c.setMobliePhone(mobliePhone);
				c.setPhone(phone);
				c.setAddress(address);
				c.setCompany(company);
				c.setModifier(modifier);
				c.setRemarks(remarks);
				c.setCreateDate(createDate);
				c.setBelongTo(belongTo);
				custom.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DBUtils.closeConnection(conn);
			
		}
		return custom;
	}

}
