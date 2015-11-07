package com.tarena.crm.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import com.tarena.crm.entity.Linkman;
import com.tarena.crm.dao.BaseDao;

public class LinkmanDaoImpl extends com.tarena.db.BaseDao<Linkman> implements BaseDao<Linkman> {

	@Override
	public Linkman add(Linkman entity) throws Exception {
		update("insert into Linkman (cumstom,name, gender,job,mobiePhone,relationship)values(?,?,?,?,?,?)",
				entity.getCustom(),entity.getName(),entity.getGender(),entity.getJob(),entity.getMobilePhone(),entity.getRelationship());
		return findById(getMaxId("Linkman"));
	}

	@Override
	public boolean delete(long id) throws Exception {
		update("delete from Linkman where id=?",id);
		return true;
	}

	@Override
	public boolean modify(Linkman entity) throws Exception {
	   update("update Linkman set cumstom=?,name=?, gender=?,job=?,mobiePhone=?,relationship=?" +
				"where id=?",entity.getCustom(),entity.getName(),entity.getGender(),entity.getJob(),entity.getMobilePhone(),entity.getRelationship(),entity.getId());
	   return true;
	}

	@Override
	public Linkman findById(long id) throws Exception {
		return queryEntity("select *from Linkman where id=?",id).get(0);
	}

	@Override
	public List<Linkman> findByName(String name) throws Exception {
		return queryEntity("select *from Linkman where name=?",name);
	}

	@Override
	public List<Linkman> findAll() throws Exception {
		return queryEntity("select * from Linkman",null);
	}

	@Override
	public Linkman toEntity(ResultSet rs) throws Exception {
			Linkman lm=new Linkman();
			lm.setId(rs.getLong("id"));
			lm.setCustom(rs.getLong("cumstom"));
			lm.setName(rs.getString("name"));
			lm.setGender(rs.getLong("gender"));
			lm.setJob(rs.getString("job"));
			lm.setMobilePhone(rs.getString("mobiePhone"));
			lm.setRelationship(rs.getString("relationship"));
			return lm;
	}

}
