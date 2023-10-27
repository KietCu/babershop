package com.barbershop.manager_barbershop.DTO;

public class ServiceDTO {
	private long id;
	private String tenDv;
	private double cost;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTenDv() {
		return tenDv;
	}
	public void setTenDv(String tenDv) {
		this.tenDv = tenDv;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public ServiceDTO(long id, String tenDv, double cost) {
		super();
		this.id = id;
		this.tenDv = tenDv;
		this.cost = cost;
	}
	
}
