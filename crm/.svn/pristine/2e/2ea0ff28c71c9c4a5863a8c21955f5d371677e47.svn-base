package com.tarena.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tarena.crm.dao.impl.NoticeDaoImpl;
import com.tarena.crm.entity.Notice;
import com.tarena.crm.service.NoticeService;

public class NoticeServiceImpl implements NoticeService{
	NoticeDaoImpl noticedao = new NoticeDaoImpl();
	
	@Override
	public List<Notice> findAll() throws Exception {
		List<Notice> lists = new ArrayList<Notice>();
		lists = noticedao.findAll();
		return lists;
	}

	@Override
	public List<Notice> findByTheme(Notice entity) throws Exception {
		List<Notice> lists = new ArrayList<Notice>();
		lists = noticedao.findByTheme(entity.getTheme());
		return lists;
	}

	@Override
	public Notice add(Notice entity) throws Exception {
		Notice notice = noticedao.add(entity); 
		return notice;
	}

}
