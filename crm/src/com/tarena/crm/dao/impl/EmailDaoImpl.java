package com.tarena.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tarena.crm.dao.BaseDao;
import com.tarena.crm.entity.Email;
import com.tarena.db.DBUtils;

public class EmailDaoImpl extends com.tarena.db.BaseDao<Email> implements
		BaseDao<Email> {

	@Override
	public Email add(Email entity) throws Exception {
		//
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBUtils.getConnection();
			prep = conn
					.prepareStatement("insert into Email (sender,receiver,theme,content,time,status)values(?,?,?,?,?,?)");
			prep.setLong(1, entity.getSender());
			prep.setLong(2, entity.getReceiver());
			prep.setString(3, entity.getTheme());
			prep.setString(4, entity.getContent());
			prep.setTimestamp(5, new Timestamp(entity.getTime().getTime()));
			prep.setBoolean(6, entity.getStatus());
			if (prep.executeUpdate() > 0)
				return entity;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.closeConnection(conn);
		}
		return null;
	}

	@Override
	public boolean delete(long id) throws Exception {
		update("delete from Email where id=?", id);
		return true;
	}

	@Override
	public boolean modify(Email entity) throws Exception {
		update("update Email set sender=?,receiver=?,theme=?,content=?,time=?,status=? where id=?",
				entity.getSender(), entity.getReceiver(), entity.getTheme(),
				entity.getContent(), entity.getTime(), entity.getStatus(),
				entity.getId());
		return true;
	}

	public boolean modifyById(boolean status, long id) throws Exception {
		update("update Email set status=? where id=?", status, id);
		return true;
	}

	@Override
	public Email findById(long id) throws Exception {
		return queryEntity("select * from Email where id=?", id).get(0);

	}

	@Override
	public List<Email> findByName(String name) throws Exception {
		return queryEntity("select * from Email where receiver=?", name);

	}

	@Override
	public List<Email> findAll() throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		List<Email> emails = null;
		try {
			conn = DBUtils.getConnection();
			prep = conn.prepareStatement("select * from email");
			ResultSet rs = prep.executeQuery();
			emails = new ArrayList<Email>();
			Email e = new Email();
			while (rs.next()) {
				e.setId(rs.getLong("id"));
				e.setSender(rs.getLong("sender"));
				e.setReceiver(rs.getLong("receiver"));
				e.setTheme(rs.getString("theme"));
				e.setContent(rs.getString("content"));
				e.setTime(rs.getTimestamp("time"));
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				String time = sdf.format(rs.getTimestamp("time"));
				System.out.println(time);
				e.setStatus(rs.getBoolean("status"));
				emails.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.closeConnection(conn);

		}
		return emails;
	}

	public List<Email> findIn(long receiver, boolean status, String arg1,
			String arg2) throws Exception {

		 return queryEntity("select * from (select * from Email where receiver=? and status =?) t where "+arg1+" like ?",receiver,status,"%"+arg2+"%");
//		return queryEntity("select * from (select * from Email where receiver="
//				+ receiver + " and status =" + status + ")as t where " + arg1
//				+ " like '" + arg2 + "'");

	}

	public List<Email> findOut(long sender, boolean status, String arg1, String arg2)
			throws Exception {

		 return queryEntity("select * from (select * from Email where sender=? and status =?) t where "+arg1+" like ?",sender,status,"%"+arg2+"%");
		

	}

	public List<Email> findByReceiver(long receiver, boolean status)
			throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		List<Email> emails = null;
		try {
			conn = DBUtils.getConnection();
			prep = conn
					.prepareStatement("select * from Email where receiver=? and status=?");
			prep.setLong(1, receiver);
			prep.setBoolean(2, status);
			ResultSet rs = prep.executeQuery();
			emails = new ArrayList<Email>();
			Email e;
			while (rs.next()) {
				e = new Email();
				e.setId(rs.getLong("id"));
				e.setSender(rs.getLong("sender"));
				e.setReceiver(rs.getLong("receiver"));
				e.setTheme(rs.getString("theme"));
				e.setContent(rs.getString("content"));
				e.setTime(rs.getTimestamp("time"));
				e.setStatus(rs.getBoolean("status"));
				emails.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.closeConnection(conn);

		}
		return emails;
	}

	public List<Email> findByReceiver(long receiver, long sender, boolean status)
			throws Exception {
		return queryEntity(
				"select * from Email where receiver=? and status=? and sender=?",
				receiver, status, sender);

	}

	public List<Email> findBySender(long sender, boolean status)
			throws Exception {
		return queryEntity("select * from Email where sender=? and status=?",
				sender, status);

	}

	public List<Email> findBySender(long sender, long receiver, boolean status)
			throws Exception {
		return queryEntity(
				"select * from Email where sender=? and status=? and receiver=?",
				sender, status, receiver);

	}

	public List<Email> findByTheme(long receiver, long sender, boolean status)
			throws Exception {
		return queryEntity(
				"select * from Email where receiver=? and status=? and sender=?",
				receiver, status, sender);

	}

	@Override
	public Email toEntity(ResultSet rs) throws Exception {
		Email c = new Email();
		long id = rs.getLong("id");
		long sender = rs.getLong("sender");
		long receiver = rs.getLong("receiver");
		String theme = rs.getString("theme");
		String content = rs.getString("content");
		Date time = new Date(rs.getTimestamp("time").getTime());
		boolean status = rs.getBoolean("status");
		c.setId(id);
		c.setSender(sender);
		c.setReceiver(receiver);
		c.setTheme(theme);
		c.setContent(content);
		c.setTime(time);
		c.setStatus(status);
		return c;
	}

	public static void main(String[] args) {
		try {
			EmailDaoImpl dao = new EmailDaoImpl();
			List<Email> list = dao.findBySender(6, 5, true);
			String theme = "theme";
			String theme2 = "反反复复";
			List<Email> list2 = dao.findIn(1, true, "theme", "a");
			System.out.println(list2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
