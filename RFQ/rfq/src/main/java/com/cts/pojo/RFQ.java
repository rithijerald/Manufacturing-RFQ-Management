package com.cts.pojo;

public class RFQ {
 
	private int RFQ_ID;
	private int Demand_ID;
	private int Quantity;
	private String Part_Details;
	private String Specification;
	private String Expected_Supply_Date;
	
	
	public int getRFQ_ID() {
		return RFQ_ID;
	}
	public void setRFQ_ID(int rFQ_ID) {
		RFQ_ID = rFQ_ID;
	}
	public int getDemand_ID() {
		return Demand_ID;
	}
	public void setDemand_ID(int demand_ID) {
		Demand_ID = demand_ID;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getPart_Details() {
		return Part_Details;
	}
	public void setPart_Details(String part_Details) {
		Part_Details = part_Details;
	}
	public String getSpecification() {
		return Specification;
	}
	public void setSpecification(String specification) {
		Specification = specification;
	}
	public String getExpected_Supply_Date() {
		return Expected_Supply_Date;
	}
	public void setExpected_Supply_Date(String expected_Supply_Date) {
		Expected_Supply_Date = expected_Supply_Date;
	}
	@Override
	public String toString() {
		return "rfqpojo [RFQ_ID=" + RFQ_ID + ", Demand_ID=" + Demand_ID + ", Quantity=" + Quantity + ", Part_Details="
				+ Part_Details + ", Specification=" + Specification + ", Expected_Supply_Date=" + Expected_Supply_Date
				+ "]";
	}
	
	
}
