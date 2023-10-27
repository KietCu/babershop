package com.barbershop.manager_barbershop.mapper;

import java.util.List;

public interface rowMapper<T, K> {
	 List<K> mapper(List<T> results);
}
