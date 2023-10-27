package com.barbershop.manager_barbershop.DAO;

import com.barbershop.manager_barbershop.entity.AppointmentEntity;
import com.barbershop.manager_barbershop.entity.CustomerEntity;

public interface ICustomerDAO {
	Long saveEntity(CustomerEntity object);

	CustomerEntity findById(Long id);

	CustomerEntity findByUserName(String userName);

	int count();
}
