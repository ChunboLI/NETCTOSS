package com.tarena.crm.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import com.tarena.crm.dao.BaseDao;
import com.tarena.crm.entity.Housetype;

public class HouseTypeDaoImpl extends com.tarena.db.BaseDao<Housetype> implements BaseDao<Housetype> {

	@Override
	public Housetype add(Housetype entity) throws Exception {
		update("insert into HouseType(type)values(?)",entity.getType());
		return findById(getMaxId("HouseType"));
	}

	@Override
	public boolean delete(long id) throws Exception {
		update("delete from HouseType where id=?",id);
		return true;
	}

	@Override
	public boolean modify(Housetype entity) throws Exception {
		update("update HouseType set type=? where id=?",entity.getType(),entity.getId());
		return true;
	}

	public Housetype findByType(String type) throws Exception {
		return queryEntity("select * from Housetype where type=?",type).get(0);
	}

	@Override
	public List<Housetype> findByName(String name) throws Exception {
		return queryEntity("select * from HouseType where name=?",name);
	}

	@Override
	public List<Housetype> findAll() throws Exception {
		return queryEntity("select * from HouseType",null);
	}

	@Override
	public Housetype toEntity(ResultSet rs) throws Exception {
		Housetype ht=new Housetype();
		ht.setId(rs.getInt("id"));
		ht.setType(rs.getString("type"));
		return ht;
	}

	@Override
	public Housetype findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
