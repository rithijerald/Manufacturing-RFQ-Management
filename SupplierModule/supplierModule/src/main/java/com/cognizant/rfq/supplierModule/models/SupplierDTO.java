package com.cognizant.rfq.supplierModule.models;

public class SupplierDTO {

	private int supplierId;

	private String name;

	private String email;

	private String phone;

	private String location;

	private int feedback;

	public SupplierDTO() {
		super();
	}

	public SupplierDTO(int supplierId, int feedback) {
		super();
		this.supplierId = supplierId;
		this.feedback = feedback;
	}

	public SupplierDTO(String name, String email, String phone, String location, int feedback) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.location = location;
		this.feedback = feedback;
	}
	
	

	public SupplierDTO(int supplierId, String name, String email, String phone, String location, int feedback) {
		super();
		this.supplierId = supplierId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.location = location;
		this.feedback = feedback;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getFeedback() {
		return feedback;
	}

	public void setFeedback(int feedback) {
		this.feedback = feedback;
	}

}
