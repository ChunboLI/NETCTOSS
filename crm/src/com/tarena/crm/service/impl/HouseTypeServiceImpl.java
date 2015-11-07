package com.tarena.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tarena.crm.dao.impl.HouseTypeDaoImpl;
import com.tarena.crm.entity.Housetype;
import com.tarena.crm.service.HouseTypeService;

public class HouseTypeServiceImpl implements HouseTypeService{
	HouseTypeDaoImpl houseTypedao = new HouseTypeDaoImpl();
	
	@Override
	public List<Housetype> findAll() throws Exception {
		List<Housetype> lists = new ArrayList<Housetype>();
		lists = houseTypedao.findAll();
		return lists;
	}

	@Override
	public Housetype findByType(Housetype entity) throws Exception {
		return houseTypedao.findByType(entity.getType());
	}

	@Override
	public Housetype add(Housetype entity) throws Exception {
		Housetype housetype = houseTypedao.add(entity);
		return housetype;
	}

	@Override
	public boolean delete(Housetype entity) throws Exception {
		boolean flag = false;
		flag = houseTypedao.delete(entity.getId());
		return flag;
	}

}
