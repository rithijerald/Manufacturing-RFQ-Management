package com.model;

public class Plant {
	private int Part_ID;
	private String Part_Name;
	private String Description;
	private String Specification;
	private String Stock;
	
	public int getPart_ID() {
		return Part_ID;
	}
	public void setPart_ID(int part_ID) {
		Part_ID = part_ID;
	}
	public String getPart_Name() {
		return Part_Name;
	}
	public void setPart_Name(String part_Name) {
		Part_Name = part_Name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getSpecification() {
		return Specification;
	}
	public void setSpecification(String specification) {
		Specification = specification;
	}
	public String getStock() {
		return Stock;
	}
	public void setStock(String stock) {
		Stock = stock;
	}
	@Override
	public String toString() {
		return "plantpojo [Part_ID=" + Part_ID + ", Part_Name=" + Part_Name + ", Description=" + Description
				+ ", Specification=" + Specification + ", Stock=" + Stock + "]";
	}
	
}