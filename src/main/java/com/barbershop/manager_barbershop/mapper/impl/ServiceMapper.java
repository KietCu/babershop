package com.barbershop.manager_barbershop.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.barbershop.manager_barbershop.DTO.Appointment;
import com.barbershop.manager_barbershop.DTO.ServiceDTO;
import com.barbershop.manager_barbershop.entity.ServiceEntity;
import com.barbershop.manager_barbershop.mapper.rowMapper;

public class ServiceMapper implements rowMapper<ServiceEntity, ServiceDTO>{

	@Override
	public List<ServiceDTO> mapper(List<ServiceEntity> results) {
		System.out.println(results.size());
		System.out.println(results);
		List<ServiceDTO> result = results.stream().map(service -> new ServiceDTO(service.getId(), service.getTenDv(), service.getCost())).collect(Collectors.toList());
		return result;
	}

}
