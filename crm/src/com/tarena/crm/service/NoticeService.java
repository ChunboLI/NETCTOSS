package com.tarena.crm.service;

import java.util.List;

import com.tarena.crm.entity.Notice;

public interface NoticeService {
	//查询所有公告
	public List<Notice> findAll() throws Exception;
	//根据公告主题查询公告
	public List<Notice> findByTheme(Notice entity) throws Exception;
	//添加公告
	public Notice add(Notice entity) throws Exception;
}
