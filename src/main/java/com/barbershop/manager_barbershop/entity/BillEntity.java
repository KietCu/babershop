package com.barbershop.manager_barbershop.entity;

import java.util.Date;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bill")
public class BillEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "bill_service", joinColumns = @JoinColumn(name = "bill_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
	private List<ServiceEntity> services;
	@ManyToOne
	private CustomerEntity customers;
	@Column
	private String createdDate;
	@Column
	private double total;
	
	public BillEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ServiceEntity> getServices() {
		return services;
	}

	public void setServices(List<ServiceEntity> services) {
		this.services = services;
	}

	

	public CustomerEntity getCustomers() {
		return customers;
	}

	public void setCustomers(CustomerEntity customers) {
		this.customers = customers;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public BillEntity(List<ServiceEntity> services, CustomerEntity customers, String createdDate, double total) {
		super();
		this.services = services;
		this.customers = customers;
		this.createdDate = createdDate;
		this.total = total;
	}

	

}
