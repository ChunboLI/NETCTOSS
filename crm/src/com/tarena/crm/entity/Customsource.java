package com.tarena.crm.entity;

/**
 * Customsource entity. @author MyEclipse Persistence Tools
 */

public class Customsource implements java.io.Serializable {

	// Fields

	private Long id;
	private String source;

	// Constructors

	/** default constructor */
	public Customsource() {
	}

	/** full constructor */
	public Customsource(String source) {
		this.source = source;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}