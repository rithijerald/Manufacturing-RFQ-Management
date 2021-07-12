package com.cognizant.rfq.supplierModule.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplierpart")
public class SupplierPart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "partid")
	private int partId;

	@Column(name = "supplierid")
	private int supplierId;

	@Column(name = "partname")
	private String partName;

	private int quantity;

	@Column(name = "timeperiod")
	private int timePeriod;

	public SupplierPart() {
		super();
	}

	public SupplierPart(int partId, int supplierId, String partName, int quantity, int timePeriod) {
		super();
		this.partId = partId;
		this.supplierId = supplierId;
		this.partName = partName;
		this.quantity = quantity;
		this.timePeriod = timePeriod;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(int timePeriod) {
		this.timePeriod = timePeriod;
	}

}
