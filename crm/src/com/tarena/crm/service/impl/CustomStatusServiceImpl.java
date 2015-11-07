package com.tarena.crm.service.impl;

import java.util.List;

import com.tarena.crm.dao.impl.CustomStatusDaoImpl;
import com.tarena.crm.entity.Customstatus;


public class CustomStatusServiceImpl  extends BaseServiceImpl<Customstatus>{
	private CustomStatusDaoImpl csd = new CustomStatusDaoImpl();
	@Override
	public List<Customstatus> findAll() throws Exception {
		return csd.findAll();
	}

	@Override
	public Customstatus add(Customstatus entity) throws Exception {
		return csd.add(entity);
	}

	@Override
	public Boolean delete(long id) throws Exception {
		return csd.delete(id);
	}

	@Override
	public Boolean modify(Customstatus entity) throws Exception {
		return csd.modify(entity);
	}

	@Override
	public Customstatus findById(long id) throws Exception {
		return (Customstatus)csd.findById(id);
	}

	@Override
	public List<Customstatus> findByName(String name) throws Exception {
		return csd.findByName(name);
	}

}
