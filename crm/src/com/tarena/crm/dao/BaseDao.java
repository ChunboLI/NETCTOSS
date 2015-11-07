package com.tarena.crm.dao;

import java.util.List;

public interface BaseDao<T> {
	public T add(T entity) throws Exception;
	public boolean delete(long id) throws Exception;
	public boolean modify(T entity) throws Exception;
	public T findById(long id) throws Exception;
	public List<T> findByName(String name) throws Exception;
	public List<T> findAll() throws Exception;
}
