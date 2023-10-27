package com.barbershop.manager_barbershop.DAO;

import java.util.List;

import com.barbershop.manager_barbershop.DTO.ServiceDTO;
import com.barbershop.manager_barbershop.entity.ServiceEntity;

public interface IServiceDAO {
	long saveEntity(ServiceEntity service);

	List<ServiceDTO> findAll();

	ServiceEntity findByTenDv(String text);
}
