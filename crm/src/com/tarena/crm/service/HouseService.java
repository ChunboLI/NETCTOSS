package com.tarena.crm.service;

import java.util.List;

import com.tarena.crm.entity.House;

public interface HouseService {
	//查找所有房屋信息
	public List<House> findAll() throws Exception;
	//根据房屋类型查询房屋信息
	public List<House> findByType(Integer type) throws Exception;
	//添加房屋信息
	public House add(House entity) throws Exception;
	//修改房屋信息
	public boolean modify(House entity) throws Exception;
	//删除房屋信息
	public boolean delete(long id) throws Exception; 
	
	public House findById(long id) throws Exception;
}

