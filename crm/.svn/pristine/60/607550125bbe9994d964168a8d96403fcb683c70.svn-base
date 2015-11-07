package com.tarena.crm.service.impl;

import java.util.List;

import com.tarena.crm.dao.impl.RelRecodDaoImpl;
import com.tarena.crm.entity.Relrecord;

public class RelRecordServiceImpl extends BaseServiceImpl<Relrecord>{
	private RelRecodDaoImpl rrd = new RelRecodDaoImpl();
	@Override
	public List<Relrecord> findAll() throws Exception {
		return rrd.findAll();
	}

	@Override
	public Relrecord add(Relrecord entity) throws Exception {
		return rrd.add(entity);
	}

	@Override
	public Boolean delete(long id) throws Exception {
		return rrd.delete(id);
	}

	@Override
	public Boolean modify(Relrecord entity) throws Exception {
		return rrd.modify(entity);
	}

	@Override
	public Relrecord findById(long id) throws Exception {
		return rrd.findById(id);
	}

	@Override
	public List<Relrecord> findByName(String name) throws Exception {
		return rrd.findByName(name);
	}

}
