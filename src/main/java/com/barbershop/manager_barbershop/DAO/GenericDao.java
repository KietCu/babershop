package com.barbershop.manager_barbershop.DAO;

import java.util.List;

import com.barbershop.manager_barbershop.mapper.rowMapper;



public interface GenericDao<T,K> {
	List<K> query(String sql,rowMapper<T,K> rowmap, Object ...para);
	Long save(T object);
	void update(T object);
	int countTheItem(String sql,Object ... para);
}
