package com.cts.plant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reorderrules")
public class ReorderRules {
	
	@Id
	@Column(name = "partid")
	private Integer partId;
	
	@Column(name= "demandid")
	private Integer demandId;
	
	@Column(name= "minquantity")
	private Integer minQuantity;
	
	@Column(name= "maxquantity")
	private Integer maxQuantity;
	
	@Column(name= "reorderfrequency")
	private Integer reorderFrequency;
	
	public ReorderRules() {
		super();
	}
	
	public ReorderRules(Integer partId, Integer demandId, Integer minQuantity, Integer maxQuantity, Integer reorderFrequency) {
		super();
		this.partId = partId;
		this.demandId = demandId;
		this.minQuantity = minQuantity;
		this.maxQuantity = maxQuantity;
		this.reorderFrequency = reorderFrequency;
	}

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public Integer getDemandId() {
		return demandId;
	}

	public void setDemandId(Integer demandId) {
		this.demandId = demandId;
	}

	public Integer getMinQuantity() {
		return minQuantity;
	}

	public void setMinQuantity(Integer minQuantity) {
		this.minQuantity = minQuantity;
	}

	public Integer getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(Integer maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public Integer getReorderFrequency() {
		return reorderFrequency;
	}

	public void setReorderFrequency(Integer reorderFrequency) {
		this.reorderFrequency = reorderFrequency;
	}

	
	

}
