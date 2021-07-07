package com.model;

import javax.persistence.Entity;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="PLANT_REORDER_DETAILS")
public class PlantReorderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REORDERID")
	private Integer reorderId;
	
	@Column(name= "PARTID")
	private Integer partId;
	
	@Column(name= "REORDERSTATUS")
	private String reorderStatus;
	
	@Column(name= "REORDERDATE")
	private Date reorderDate;
	
	public PlantReorderDetails(Integer reorderId, Integer partId, String reorderStatus, Date reorderDate) {
		super();
		this.reorderId = reorderId;
		this.partId = partId;
		this.reorderStatus = reorderStatus;
		this.reorderDate = reorderDate;
	}

	public Integer getReorderId() {
		return reorderId;
	}

	public void setReorderId(Integer reorderId) {
		this.reorderId = reorderId;
	}

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public String getReorderStatus() {
		return reorderStatus;
	}

	public void setReorderStatus(String reorderStatus) {
		this.reorderStatus = reorderStatus;
	}

	public Date getReorderDate() {
		return reorderDate;
	}

	public void setReorderDate(Date reorderDate) {
		this.reorderDate = reorderDate;
	}
	
	

}
