package com.project.fabricateapp.dto;

public class Supplier {

	private int supplierId;

	private String name;

	private String email;

	private String phone;

	private String location;

	private int feedback;

	public Supplier() {
		super();
	}

	public Supplier(int supplierId, int feedback) {
		super();
		this.supplierId = supplierId;
		this.feedback = feedback;
	}

	public Supplier(String name, String email, String phone, String location, int feedback) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.location = location;
		this.feedback = feedback;
	}
	
	

	public Supplier(int supplierId, String name, String email, String phone, String location, int feedback) {
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
