package com.barbershop.manager_barbershop.DAO;

import java.util.List;

import javax.swing.JComboBox;

import com.barbershop.manager_barbershop.DTO.Appointment;
import com.barbershop.manager_barbershop.entity.AppointmentEntity;

public interface IAppointmentDAO {
	Long saveEntity(AppointmentEntity object);
	List<Appointment> findAll(String date);
	List<Appointment> findByNgayDat(String date);
	void removeById(Long idSelected);
	boolean isExits(String hoTen, int sdt, String ngay);
	List<Appointment> findByCustomerIdAndNgayDat(Long id, String ngayDat);
	
	void updateDayAndTime(Long id, String ngayDat, String gioDat, String ngaySua, String gioSua);
	long countByNgayDatAndGioDat(String ngayDat, String gioDat);
}
