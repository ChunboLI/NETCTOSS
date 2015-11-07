package com.tarena.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tarena.crm.dao.impl.HouseDaoImpl;
import com.tarena.crm.entity.House;
import com.tarena.crm.service.HouseService;

public class HouseServiceImpl implements HouseService{
	HouseDaoImpl housedao = new HouseDaoImpl();
	
	@Override
	public List<House> findAll() throws Exception {
		List<House> lists = new ArrayList<House>();
		lists = housedao.findAll();
		return lists;
	}

	@Override
	public List<House> findByType(Integer type) throws Exception {
		List<House> lists = new ArrayList<House>();
		lists = housedao.findByType(type);
		return lists;
	}

	@Override
	public House add(House entity) throws Exception {
		return housedao.add(entity);
	}

	@Override
	public boolean modify(House entity) throws Exception {
		return housedao.modify(entity);
	}

	@Override
	public boolean delete(long id) throws Exception {
		return housedao.delete(id);
	}

	@Override
	public House findById(long id) throws Exception {
		return housedao.findById(id);
	}

}
