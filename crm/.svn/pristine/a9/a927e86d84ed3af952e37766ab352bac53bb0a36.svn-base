package com.tarena.crm.service.impl;

import java.util.List;

import com.tarena.crm.dao.BaseDao;
import com.tarena.crm.dao.impl.CustomTypeDaoImpl;
import com.tarena.crm.entity.Customtype;

public class CustomTypeServiceImpl extends BaseServiceImpl<Customtype>{
	private CustomTypeDaoImpl ctd = new CustomTypeDaoImpl();
	
	@Override
	public List<Customtype> findAll() throws Exception {	
		return ctd.findAll();
	}

	@Override
	public Customtype add(Customtype entity) throws Exception {
		return ctd.add(entity);
	}

	@Override
	public Boolean delete(long id) throws Exception {
		return ctd.delete(id);
	}

	@Override
	public Boolean modify(Customtype entity) throws Exception {
		return ctd.modify(entity);
	}

	@Override
	public Customtype findById(long id) throws Exception {
		return (Customtype)ctd.findById(id);
	}

	@Override
	public List<Customtype> findByName(String name) throws Exception {
		return ctd.findByName(name);
	}

	
}
