package com.cts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RFQ {
    @Id
    @Column(name = "RFQID")
	private int rfqId;
    @Column(name ="PARTID")
	private int partId;
    @Column(name ="QUANTITY")
	private int quantity;
    @Column(name ="PartName")
	private int partName;
    @Column(name ="SPECIFICATION")
	private String Specification;
    @Column(name ="TIMETOSUPPLY")
	private int timetoSupply;
    
    public RFQ() {
    	super();
    }
	public int getRfqId() {
		return rfqId;
	}
	public void setRfqId(int rfqId) {
		this.rfqId = rfqId;
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
	public int getPartName() {
		return partName;
	}
	public void setPartName(int partName) {
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
	@Override
	public String toString() {
		return "RFQ [rfqId=" + rfqId + ", partId=" + partId + ", quantity=" + quantity + ", partName=" + partName
				+ ", Specification=" + Specification + ", timetoSupply=" + timetoSupply + "]";
	}
	
	


}
