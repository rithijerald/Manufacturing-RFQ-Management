package com.cognizant.rfq.supplierModule.models;

public class SupplierFeedback {

	private Integer id;
	private Integer feedback;
	
	public SupplierFeedback() {
		super();
	}
	
	public SupplierFeedback(Integer id,Integer feedback) {
		super();
		this.id=id;
		this.feedback=feedback;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFeedback() {
		return feedback;
	}

	public void setFeedback(Integer feedback) {
		this.feedback = feedback;
	}
	
	
}
