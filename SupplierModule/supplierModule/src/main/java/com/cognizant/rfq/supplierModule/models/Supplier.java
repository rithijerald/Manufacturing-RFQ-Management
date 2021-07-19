package com.cognizant.rfq.supplierModule.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplierid")
	private int supplierId;

	@NotBlank(message = "Supplier name is required")
	private String name;

	@Email(message="Please enter valid email")
	@NotBlank(message="Email is required")
	private String email;

	@NotBlank(message="Phone No. is required")
	@Pattern(regexp="^[789][0-9]{9}",message="Mobile number should be 10 digits and starting with 7/8/9")
	private String phone;

	@NotBlank(message="location is required")
	private String location;
	
	@Min(value=1,message="value must be in range 1-10")
	@Max(value=10,message="value must be in range 1-10")
	@NotNull(message="feedback is required")
	private int feedback;

	public Supplier() {
		super();
	}

	public Supplier(int supplierId, int feedback) {
		super();
		this.supplierId = supplierId;
		this.feedback = feedback;
	}

	public Supplier(String name, String email, String phone, String location, int feedback) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.location = location;
		this.feedback = feedback;
	}
	
	

	public Supplier(int supplierId, String name, String email, String phone, String location, int feedback) {
		super();
		this.supplierId = supplierId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.location = location;
		this.feedback = feedback;
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

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getFeedback() {
		return feedback;
	}

	public void setFeedback(int feedback) {
		this.feedback = feedback;
	}

}
