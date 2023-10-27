package com.barbershop.manager_barbershop.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment")
public class AppointmentEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	@Column
	private String ngayDat;
	@Column
	private String gioDat;
	@Column
	private boolean expired;
	@ManyToOne
	private CustomerEntity customer;
	
	
	public AppointmentEntity() {
	
	}
	public AppointmentEntity(String ngayDat, String gioDat, boolean expired) {
		super();
		this.ngayDat = ngayDat;
		this.gioDat = gioDat;
		this.expired = expired;
	}
	
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(String ngayDat) {
		this.ngayDat = ngayDat;
	}
	public String getGioDat() {
		return gioDat;
	}
	public void setGioDat(String gioDat) {
		this.gioDat = gioDat;
	}
	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	
	
}
