package com.barbershop.manager_barbershop.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	@Column
	private String userName;
	@Column
	private String password;
	
	@Column
	private String tenKh;
	@Column
	private Integer sdt;
	@Column
	private String maKH;
	@Column
	private String role;
	@OneToMany(fetch = FetchType.EAGER)
	private List<AppointmentEntity> appointments = new ArrayList<>();
	@OneToMany(fetch = FetchType.EAGER)
	private List<BillEntity> bills = new ArrayList<>();
	public CustomerEntity() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTenKh() {
		return tenKh;
	}
	public void setTenKh(String tenKh) {
		this.tenKh = tenKh;
	}
	public Integer getSdt() {
		return sdt;
	}
	public void setSdt(Integer sdt) {
		this.sdt = sdt;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public List<AppointmentEntity> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<AppointmentEntity> appointments) {
		this.appointments = appointments;
	}
	public List<BillEntity> getBills() {
		return bills;
	}
	public void setBills(List<BillEntity> bills) {
		this.bills = bills;
	}
	public CustomerEntity(String userName, String password, String tenKh, Integer sdt, String maKH, String role) {
		this.userName = userName;
		this.password = password;
		this.tenKh = tenKh;
		this.sdt = sdt;
		this.maKH = maKH;
		this.role = role;
	}
	
	
}
