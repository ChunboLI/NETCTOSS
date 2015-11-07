package com.tarena.crm.entity;

/**
 * House entity. @author MyEclipse Persistence Tools
 */

public class House implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer type;
	private long emp;
	public long getEmp() {
		return emp;
	}

	public void setEmp(long emp) {
		this.emp = emp;
	}

	private String address;
	private Double price;
	private String environment;

	// Constructors

	/** default constructor */
	public House() {
	}

	/** minimal constructor */
	public House(Integer type, String address, Double price) {
		this.type = type;
		this.address = address;
		this.price = price;
	}

	/** full constructor */
	public House(Integer type, String address, Double price, String environment) {
		this.type = type;
		this.address = address;
		this.price = price;
		this.environment = environment;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getEnvironment() {
		return this.environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

}