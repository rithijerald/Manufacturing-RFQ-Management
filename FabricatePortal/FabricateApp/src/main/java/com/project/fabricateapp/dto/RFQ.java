package com.project.fabricateapp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class RFQ {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rfqid")
	private int rfqId;

	

	@Column(name = "partid")
	private int partId;

	private int quantity;
	
	@Column(name = "partname")
	private String partName;
	
	@Column(name = "timetosupply")
	private int timetoSupply;
	
	private String Specification;
	
	

	public RFQ() {
		super();
	}

	
	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

	public String getPartName() {
		return partName;
	}


	public void setPartName(String partName) {
		this.partName = partName;
	}


	public String getSpecification() {
		return Specification;
	}

	public void setSpecification(String specification) {
		Specification = specification;
	}
	public int getRfqId() {
		return rfqId;
	}


	public void setRfqId(int rfqId) {
		this.rfqId = rfqId;
	}

	public int getTimetoSupply() {
		return timetoSupply;
	}

	public void setTimetoSupply(int timetoSupply) {
		this.timetoSupply = timetoSupply;
	}
}
