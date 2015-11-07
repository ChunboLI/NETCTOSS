package com.tarena.crm.service.impl;

import java.util.List;

import com.tarena.crm.dao.impl.CustomSourceDaoImpl;
import com.tarena.crm.entity.Customsource;

public class CustomSourceServiceImpl extends BaseServiceImpl<Customsource>{
	private CustomSourceDaoImpl csd = new CustomSourceDaoImpl();
	@Override
	public List<Customsource> findAll() throws Exception {
		return csd.findAll();
	}

	@Override
	public Customsource add(Customsource entity) throws Exception {
		return csd.add(entity);
	}

	@Override
	public Boolean delete(long id) throws Exception {
		return csd.delete(id);
	}

	@Override
	public Boolean modify(Customsource entity) throws Exception {
		return csd.modify(entity);
	}

	@Override
	public Customsource findById(long id) throws Exception {
		return csd.findById(id);
	}

	@Override
	public List<Customsource> findByName(String name) throws Exception {
		return csd.findByName(name);
	}

	
}
