package com.barbershop.manager_barbershop.DTO;

public class BillDTO {
	private long id;
	private String dichVu;
	private double total;
	private CustomerDTO customer;
	private String createdDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDichVu() {
		return dichVu;
	}

	public void setDichVu(String dichVu) {
		this.dichVu = dichVu;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public BillDTO(long id, String dichVu, double total, CustomerDTO customer, String createdDate) {
		
		this.id = id;
		this.dichVu = dichVu;
		this.total = total;
		this.customer = customer;
		this.createdDate = createdDate;
	}
	
}
