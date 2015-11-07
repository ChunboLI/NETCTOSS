package com.tarena.crm.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import com.tarena.crm.dao.BaseDao;
import com.tarena.crm.entity.Customtype;
import com.tarena.crm.entity.Department;

public class DepartmentDaoImpl extends com.tarena.db.BaseDao<Department> implements BaseDao<Department>{

	@Override
	public Department add(Department entity) throws Exception {
		update("insert into Department (name,description)values(?,?)", entity.getName(),entity.getDescription());
		return findById(getMaxId("Department"));
	}

	@Override
	public boolean delete(long id) throws Exception {
		update("delete from Department where id=?", id);
		return true;
	}

	@Override
	public boolean modify(Department entity) throws Exception {
		update("update Department set name=?,description=? where id=?", entity.getName(),entity.getDescription(),entity.getId());
		return true;
	}

	@Override
	public Department findById(long id) throws Exception {
		return queryEntity("select * from Department where id=?",id).get(0);

	}

	@Override
	public List<Department> findByName(String name) throws Exception {
		return queryEntity("select * from Department where name=?",name);
	}

	@Override
	public List<Department> findAll() throws Exception {
		return queryEntity("select * from Department where 1=?",1);

	}

	@Override
	public Department toEntity(ResultSet rs) throws Exception {
		Department c = new Department();
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String description = rs.getString("description");
		c.setId(id);
		c.setName(name);
		c.setDescription(description);
		return c;
	}

}
