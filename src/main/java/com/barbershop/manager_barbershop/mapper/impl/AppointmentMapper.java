package com.barbershop.manager_barbershop.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.barbershop.manager_barbershop.DTO.Appointment;
import com.barbershop.manager_barbershop.DTO.CustomerDTO;
import com.barbershop.manager_barbershop.entity.AppointmentEntity;
import com.barbershop.manager_barbershop.mapper.rowMapper;

public class AppointmentMapper implements rowMapper<AppointmentEntity, Appointment>{

	@Override
	public List<Appointment> mapper(List<AppointmentEntity> results) {
		List<Appointment> result = results.stream().map(calendar -> {
			Appointment appointment = new Appointment(calendar.getCustomer().getTenKh(), calendar.getCustomer().getSdt(), calendar.getNgayDat(), calendar.getGioDat());
			appointment.setId(calendar.getId());
			return appointment;
		}).collect(Collectors.toList());
		return result;
	}

}
