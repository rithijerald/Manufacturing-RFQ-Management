package com.cognizant.rfq.supplierModule.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class SuppliersList {

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private List<Supplier> supplierList;
	
	public SuppliersList() {
		super();
	}
	
	public SuppliersList(List<Supplier> supplierList) {
		super();
		this.supplierList = supplierList;
	}

	public List<Supplier> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(List<Supplier> supplierList) {
		this.supplierList = supplierList;
	}
	
	
}
