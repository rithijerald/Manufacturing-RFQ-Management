package com.project.fabricateapp.dto;

import org.springframework.stereotype.Component;



@Component
public class SupplierAndParts {
	private Supplierxd supplier;
	private Supplierpart supplierpart;

	public Supplierpart getSupplierpart() {
		return supplierpart;
	}

	public void setSupplierpart(Supplierpart supplierpart) {
		this.supplierpart = supplierpart;
	}

	public SupplierAndParts(Supplierxd supplier, Supplierpart supplierpart) {
		super();
		this.supplier = supplier;
		this.supplierpart = supplierpart;
	}

	public SupplierAndParts() {
		super();
	}

	public Supplierxd getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplierxd supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "SupplierAndParts [supplier=" + supplier + ", supplierpart=" + supplierpart + "]";
	}

}
