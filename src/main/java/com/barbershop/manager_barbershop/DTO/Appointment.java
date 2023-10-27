package com.barbershop.manager_barbershop.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
	private Long id;
	private String maLH;
	private String tenKh;
	private int sdt;
	private String ngayDat;
	private String gioDat;

	
	public Appointment(String maLH, String tenKh, int sdt, String ngayDat, String gioDat) {
		super();
		this.maLH = maLH;
		this.tenKh = tenKh;
		this.sdt = sdt;
		this.ngayDat = ngayDat;
		this.gioDat = gioDat;
	}

	public Appointment(String tenKh, int sdt, String ngayDat, String gioDat) {
		this.tenKh = tenKh;
		this.sdt = sdt;
		this.ngayDat = ngayDat;
		this.gioDat = gioDat;
	}

	public void setNgayDat(String ngayDat) {
		this.ngayDat = ngayDat;
	}

	public void setGioDat(String gioDat) {
		this.gioDat = gioDat;
	}

	public String getTenKh() {
		return tenKh;
	}

	public int getSdt() {
		return sdt;
	}

	public void setTenKh(String tenKh) {
		this.tenKh = tenKh;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public Appointment(String tenKh, int sdt) {
		this.tenKh = tenKh;
		this.sdt = sdt;
	}

	public String getMaLH() {
		return maLH;
	}

	public void setMaLH(String maLH) {
		this.maLH = maLH;
	}
	
	public String getNgayDat() {
		return ngayDat;
	}

	public String getGioDat() {
		return gioDat;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LichHen{" + "maLH=" + maLH + ", tenKh=" + tenKh + ", sdt=" + sdt + ", ngayDat=" + ngayDat + ", gioDat="
				+ gioDat + '}';
	}

}
