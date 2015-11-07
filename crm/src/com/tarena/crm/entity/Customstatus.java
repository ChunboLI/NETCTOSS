package com.tarena.crm.entity;

/**
 * Customstatus entity. @author MyEclipse Persistence Tools
 */

public class Customstatus implements java.io.Serializable {

	// Fields

	private Long id;
	private String status;
	private String described;

	// Constructors

	/** default constructor */
	public Customstatus() {
	}

	/** full constructor */
	public Customstatus(String status) {
		this.status = status;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescribed() {
		return described;
	}

	public void setDescribed(String described) {
		this.described = described;
	}

}