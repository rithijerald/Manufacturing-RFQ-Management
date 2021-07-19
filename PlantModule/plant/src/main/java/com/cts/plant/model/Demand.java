package com.cts.plant.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="demand")
public class Demand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "demandid")
	private Integer demandId;

	@Column(name = "partid")
	private Integer partId;

	@Column(name = "demandcount")
	private Integer demandCount;

	@Column(name = "demandraiseddate")
	private Date demandRaisedDate;

	public Demand(Integer demandId, Integer partId, Integer demandCount, Date demandRaisedDate) {
		super();
		this.demandId = demandId;
		this.partId = partId;
		this.demandCount = demandCount;
		this.demandRaisedDate = demandRaisedDate;
	}

	public Demand() {
		super();
	}

	public Integer getDemandId() {
		return demandId;
	}

	public void setDemandId(Integer demandId) {
		this.demandId = demandId;
	}

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public Integer getDemandCount() {
		return demandCount;
	}

	public void setDemandCount(Integer demandCount) {
		this.demandCount = demandCount;
	}

	public Date getDemandRaisedDate() {
		return demandRaisedDate;
	}

	public void setDemandRaisedDate(Date demandRaisedDate) {
		this.demandRaisedDate = demandRaisedDate;
	}

}
