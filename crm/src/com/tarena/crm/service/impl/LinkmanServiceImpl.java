package com.tarena.crm.service.impl;

import java.util.List;

import com.tarena.crm.dao.impl.LinkmanDaoImpl;
import com.tarena.crm.entity.Linkman;

public class LinkmanServiceImpl extends BaseServiceImpl<Linkman>{
	private LinkmanDaoImpl ld = new LinkmanDaoImpl();
	@Override
	public List<Linkman> findAll() throws Exception {
		return ld.findAll();
	}

	@Override
	public Linkman add(Linkman entity) throws Exception {
		return ld.add(entity);
	}

	@Override
	public Boolean delete(long id) throws Exception {
		return ld.delete(id);
	}

	@Override
	public Boolean modify(Linkman entity) throws Exception {
		return ld.modify(entity);
	}

	@Override
	public Linkman findById(long id) throws Exception {
		return ld.findById(id);
	}

	@Override
	public List<Linkman> findByName(String name) throws Exception {
		return ld.findByName(name);
	}

}
