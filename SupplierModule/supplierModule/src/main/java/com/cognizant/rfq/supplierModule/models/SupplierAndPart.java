package com.cognizant.rfq.supplierModule.models;

public class SupplierAndPart {
	
	private Integer id;
	private Integer partId;
	private String name;
	private String email;
	private String phone;
	private String location;
	private Integer feedback;
	private String partName;
	private Integer quantity;
	private Integer timeToSupply;
	
	public SupplierAndPart() {
		super();
	}

	public SupplierAndPart(Integer partId, String name, String email, String phone, String location, Integer feedback,
			String partName, Integer quantity, Integer timeToSupply) {
		super();
		this.partId = partId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.location = location;
		this.feedback = feedback;
		this.partName = partName;
		this.quantity = quantity;
		this.timeToSupply = timeToSupply;
	}

	public SupplierAndPart(Integer id, Integer partId, String name, String email, String phone, String location,
			Integer feedback, String partName, Integer quantity, Integer timeToSupply) {
		super();
		this.id = id;
		this.partId = partId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.location = location;
		this.feedback = feedback;
		this.partName = partName;
		this.quantity = quantity;
		this.timeToSupply = timeToSupply;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getFeedback() {
		return feedback;
	}

	public void setFeedback(Integer feedback) {
		this.feedback = feedback;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getTimeToSupply() {
		return timeToSupply;
	}

	public void setTimeToSupply(Integer timeToSupply) {
		this.timeToSupply = timeToSupply;
	}
	
	

}
