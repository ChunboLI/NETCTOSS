package com.tarena.crm.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import com.tarena.crm.dao.BaseDao;
import com.tarena.crm.entity.Customstatus;
import com.tarena.crm.entity.Customtype;

public class CustomTypeDaoImpl extends com.tarena.db.BaseDao<Customtype> implements BaseDao<Customtype>{

	@Override
	public Customtype add(Customtype entity) throws Exception {
		update("insert into Customtype (type)values(?)", entity.getType());
		return findById(getMaxId("Customtype"));
	}

	@Override
	public boolean delete(long id) throws Exception {
		update("delete from Customtype where id=?", id);
		return true;
	}

	@Override
	public boolean modify(Customtype entity) throws Exception {
		update("update Customtype set name=? where id =?", entity.getType(),entity.getId());
		return true;
	}

	@Override
	public Customtype findById(long id) throws Exception {
		return queryEntity("select * from Customtype where id=?",id).get(0);
	}

	@Override
	public List<Customtype> findByName(String name) throws Exception {
		return queryEntity("select * from Customtype where name=?",name);

	}

	@Override
	public List<Customtype> findAll() throws Exception {
		return queryEntity("select * from Customtype where 1=?",1);

	}

	@Override
	public Customtype toEntity(ResultSet rs) throws Exception {
		Customtype c = new Customtype();
		long id = rs.getLong("id");
		String type = rs.getString("type");
		c.setId(id);
		c.setType(type);
		return c;
	}



	

}
