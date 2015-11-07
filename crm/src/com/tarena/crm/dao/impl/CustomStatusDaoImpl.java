package com.tarena.crm.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import com.tarena.crm.dao.BaseDao;
import com.tarena.crm.entity.Customstatus;

public class CustomStatusDaoImpl extends com.tarena.db.BaseDao<Customstatus> implements BaseDao<Customstatus>{

	@Override
	public Customstatus add(Customstatus entity) throws Exception {
		update("insert into Customstatus (status,described)values(?,?)", entity.getStatus(),entity.getDescribed());
		return findById(getMaxId("Customstatus"));
	}

	@Override
	public boolean delete(long id) throws Exception {
		update("delete from Customstatus where id=?", id);
		return true;
	}

	@Override
	public boolean modify(Customstatus entity) throws Exception {
		update("updateCustomstatus set status=?,described=? where id=?", entity.getStatus(),entity.getDescribed(),entity.getId());
		return true;
	}

	@Override
	public Customstatus findById(long id) throws Exception {
		return queryEntity("select * from Customstatus where id=?",id).get(0);
	}

	@Override
	public List<Customstatus> findByName(String name) throws Exception {
		throw new Exception ("该方法不可用");

	}

	@Override
	public List<Customstatus> findAll() throws Exception {
		return queryEntity("select * from Customstatus where 1=?",1);
	}

	@Override
	public Customstatus toEntity(ResultSet rs) throws Exception {
		Customstatus c = new Customstatus();
		long id = rs.getLong("id");
		String status = rs.getString("status");
		String describe = rs.getString("described");
		c.setId(id);
		c.setStatus(status);
		c.setDescribed(describe);
		return c;
	}
	/*
	public static void main(String[] args) {
		Customstatus c = new Customstatus();
		c.setDescribe("dsd");
		c.setStatus("ds");
		CustomStatusDaoImpl cc = new CustomStatusDaoImpl();
		try {
			System.out.println(cc.add(c));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
}
