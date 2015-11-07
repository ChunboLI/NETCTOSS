package com.tarena.crm.service.impl;

import java.util.List;

import com.tarena.crm.dao.impl.CustomDaoImpl;
import com.tarena.crm.entity.Custom;

public class CustomServiceImpl extends BaseServiceImpl<Custom>{
	private CustomDaoImpl cd = new CustomDaoImpl();
	@Override
	public List<Custom> findAll() throws Exception {
		return cd.findAll();
	}

	@Override
	public Custom add(Custom entity) throws Exception {
		return cd.add(entity);
	}

	@Override
	public Boolean delete(long id) throws Exception {
		return cd.delete(id);
	}

	@Override
	public Boolean modify(Custom entity) throws Exception {
		return cd.modify(entity);
	}

	@Override
	public Custom findById(long id) throws Exception {
		return cd.findById(id);
	}

	@Override
	public List<Custom> findByName(String name) throws Exception {
		return cd.findByName(name);
	}

}
