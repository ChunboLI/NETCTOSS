package com.tarena.crm.service.impl;

import java.util.List;

import com.tarena.crm.dao.impl.EmpDaoImpl;
import com.tarena.crm.entity.Emp;
import com.tarena.crm.service.BaseService;

public class EmpServiceImpl implements BaseService<Emp>{
	private EmpDaoImpl ed = new EmpDaoImpl();

	@Override
	public List<Emp> findAll() throws Exception {
		return ed.findAll();
	}

	@Override
	public Emp add(Emp entity) throws Exception {
		return ed.add(entity);
	}

	@Override
	public Boolean delete(long id) throws Exception {
		return ed.delete(id);
	}

	@Override
	public Boolean modify(Emp entity) throws Exception {
		return ed.modify(entity);
	}

	@Override
	public Emp findById(long id) throws Exception {
		return ed.findById(id);
	}

	@Override
	public List<Emp> findByName(String name) throws Exception {
		return ed.findByName(name);
	}



}
