package com.cognizant.rfq.supplierModule.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="supplierid",nullable = false, unique = true)
	private int supplierId;
	
	private String name;
	
	private String location;
	
	private int feedback;
	
	public Supplier() {
		
	}
	
	public Supplier(int supplierId, String name, String location, int feedback) {
		super();
		this.supplierId=supplierId;
		this.name = name;
		this.location = location;
		this.feedback = feedback;
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
