package com.barbershop.manager_barbershop.DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.barbershop.manager_barbershop.entity.BillEntity;

public class CustomerDTO {
	private Long id;
	private String maKH;
	private String tenKh;
	private int sdt;
	private List<BillEntity> bills;
	private String role;
	
	
	
	

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", maKH=" + maKH + ", tenKh=" + tenKh + ", sdt=" + sdt + ", bills=" + bills
				+ ", role=" + role + "]";
	}
	
	public CustomerDTO(Long id, String maKH, String tenKh, List<BillEntity> bills) {
		
		this.id = id;
		this.maKH = maKH;
		this.tenKh = tenKh;
		this.bills = bills;
	}
	
	public CustomerDTO(String maKH, String tenKh, int sdt, List<BillEntity> bills) {
		
		this.maKH = maKH;
		this.tenKh = tenKh;
		this.sdt = sdt;
		this.bills = bills;
	}

	public CustomerDTO(Long id, String maKH, String tenKh, int sdt, String role) {
		
		this.id = id;
		this.maKH = maKH;
		this.tenKh = tenKh;
		this.sdt = sdt;
		this.role = role;
	}

	public CustomerDTO(Long id, String maKH, String tenKh, int sdt, List<BillEntity> bills, String role) {
	
		this.id = id;
		this.maKH = maKH;
		this.tenKh = tenKh;
		this.sdt = sdt;
		this.bills = bills;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaKH() {
		return maKH;
	}

	

	public List<BillEntity> getBills() {
		return bills;
	}

	public void setBills(List<BillEntity> bills) {
		this.bills = bills;
	}

	public String getTenKh() {
		return tenKh;
	}

	public void setTenKh(String tenKh) {
		this.tenKh = tenKh;
	}

	
	
}
