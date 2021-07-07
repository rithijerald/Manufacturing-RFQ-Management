package com.cognizant.rfq.supplierModule.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="supplierpart")
public class SupplierPart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="partid")
	private int partId;
	
	@Column(name="partname")
	private String partName;
	
	public SupplierPart(String partName) {
		super();
		this.partName=partName;
	}
	
	
	public SupplierPart(int partId, String partName) {
		super();
		this.partId = partId;
		this.partName = partName;
	}
	
	public SupplierPart() {
		super();
	}


	
	
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public int getPartId() {
		return partId;
	}
	public void setPartId(int partId) {
		this.partId = partId;
	}
	
	
}
