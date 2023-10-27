package com.barbershop.manager_barbershop.DAO;

import java.util.Date;
import java.util.List;

import javax.swing.JTextField;

import com.barbershop.manager_barbershop.DTO.BillDTO;
import com.barbershop.manager_barbershop.entity.BillEntity;

public interface IBillDao {
	long saveEntity(BillEntity bill);

	List<BillDTO> findAllByCreateDate(String date);

	void updateBill( Long idBill, double phiDichVu);

	List<BillDTO> findByCustomerSdt(int sdt);

	void remove(Long idBill);
}
