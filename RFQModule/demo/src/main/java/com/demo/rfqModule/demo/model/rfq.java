
package com.demo.rfqModule.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rfq")
public class rfq {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "RFQID")
	private int rfq;

	@Column(name = "PARTID")
	private int partId;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name = "PARTNAME")
	private String partName;
	
	@Column(name = "TIMETOSUPPLY")
	private int timetoSupply;
	
	@Column(name = "SPECIFICATION")
	private String Specification;
	
	

	public rfq() {
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

	public int getTimetoSupply() {
		return timetoSupply;
	}

	public void setTimetoSupply(int timetoSupply) {
		this.timetoSupply = timetoSupply;
	}

}
