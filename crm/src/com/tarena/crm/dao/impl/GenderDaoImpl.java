package com.tarena.crm.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import com.tarena.crm.dao.BaseDao;
import com.tarena.crm.entity.Gender;

public class GenderDaoImpl extends com.tarena.db.BaseDao<Gender> implements BaseDao<Gender> {

	@Override
	public Gender add(Gender entity) throws Exception {
		update("insert into Gender (id,gender) values(?,?)",entity.getId(),entity.getGender());
		return findById(getMaxId("Gender"));
	}

	@Override
	public boolean modify(Gender entity) throws Exception {
		update("update Gender set id=?,gender=?",entity.getId(),entity.getGender());
		return true;
	}
	@Override
	public List<Gender> findAll() throws Exception {
		return queryEntity("select *from Gender ",null);
	}

	@Override
	public boolean delete(long id) throws Exception {
		update("delete from Gender where id=?",id);
		return true;
	}

	@Override
	public Gender findById(long id) throws Exception {
		return queryEntity("select *from Gender where id=?",id).get(0);
	}

	@Override
	public Gender toEntity(ResultSet rs) throws Exception {
		Gender gender=new Gender();
		gender.setGender(rs.getString("gender"));
		gender.setId(rs.getInt("id"));
		return gender;
	}

	@Override
	public List<Gender> findByName(String name) throws Exception {
		return queryEntity("select * from Gender where name=?",name);
	}
}
