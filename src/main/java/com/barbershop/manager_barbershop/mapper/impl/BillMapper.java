package com.barbershop.manager_barbershop.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.barbershop.manager_barbershop.DTO.BillDTO;
import com.barbershop.manager_barbershop.DTO.CustomerDTO;
import com.barbershop.manager_barbershop.entity.BillEntity;
import com.barbershop.manager_barbershop.mapper.rowMapper;

public class BillMapper implements rowMapper<BillEntity, BillDTO>{

	@Override
	public List<BillDTO> mapper(List<BillEntity> results) {
		List<BillDTO> bills = results.stream().map(bill -> {
			
			CustomerDTO customerDTO = new CustomerDTO(bill.getCustomers().getId(), bill.getCustomers().getMaKH(), bill.getCustomers().getTenKh(), bill.getCustomers().getSdt(), bill.getCustomers().getRole());
			String dichVu = bill.getServices().stream().map(service -> service.getTenDv() + " ").collect(Collectors.joining());
			return new BillDTO(bill.getId(), dichVu, bill.getTotal(), customerDTO, bill.getCreatedDate());
		}).collect(Collectors.toList());
		return bills;
	}

}
