package com.tarena.crm.service.impl;

import com.tarena.crm.dao.impl.EmpDaoImpl;
import com.tarena.crm.entity.Emp;
import com.tarena.crm.service.UserService;

public class UserServiceImpl implements UserService {
	private EmpDaoImpl edi=new EmpDaoImpl();

	@Override
	public String login(String username) throws Exception {
		return edi.findByAccount(username);
	}

}
