package com.model;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Part {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "PARTID")
	private Integer partId;
	
	@Column(name = "PARTDESCRIPTION")
	private String partDescription;
	
	@Column(name = "PARTSPECIFICATION")
	private String partSpecification;
	
	@Column(name = "STOCKINHAND")
	private Integer stockInHand;
	
	public Part() {
		super();
	}
	
	public Part(Integer partId, String partDescription, String partSpecification, Integer stockInHand) {
		super();
		this.partId = partId;
		this.partDescription = partDescription;
		this.partSpecification=partSpecification;
		this.stockInHand=stockInHand;
	}

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public String getPartSpecification() {
		return partSpecification;
	}

	public void setPartSpecification(String partSpecification) {
		this.partSpecification = partSpecification;
	}

	public Integer getStockInHand() {
		return stockInHand;
	}

	public void setStockInHand(Integer stockInHand) {
		this.stockInHand = stockInHand;
	}
	
	

	
}
