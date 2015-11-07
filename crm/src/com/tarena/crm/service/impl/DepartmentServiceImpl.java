package com.tarena.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tarena.crm.dao.impl.DepartmentDaoImpl;
import com.tarena.crm.entity.Department;
import com.tarena.crm.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{
	DepartmentDaoImpl depart = new DepartmentDaoImpl();
	
	@Override
	public List<Department> findAll() throws Exception {
		List<Department> lists = new ArrayList<Department>();
		lists = depart.findAll();
		return lists;
	}

	@Override
	public List<Department> findByName(Department department) throws Exception {
		List<Department> lists = new ArrayList<Department>();
		lists = depart.findByName(department.getName());
		return lists;
	}

}
