package com.tarena.crm.entity;

import java.util.Date;

/**
 * Relrecord entity. @author MyEclipse Persistence Tools
 */

public class Relrecord implements java.io.Serializable {

	// Fields

	private Long id;
	private Long custom;
	private Date time;
	private Date nextTime;
	private String type;
	private Long emp;
	private String theme;
	private String remarks;

	// Constructors

	/** default constructor */
	public Relrecord() {
	}

	/** minimal constructor */
	public Relrecord(Long custom, Date time, Date nextTime, String type,
			Long emp, String theme) {
		this.custom = custom;
		this.time = time;
		this.nextTime = nextTime;
		this.type = type;
		this.emp = emp;
		this.theme = theme;
	}

	/** full constructor */
	public Relrecord(Long custom, Date time, Date nextTime, String type,
			Long emp, String theme, String remarks) {
		this.custom = custom;
		this.time = time;
		this.nextTime = nextTime;
		this.type = type;
		this.emp = emp;
		this.theme = theme;
		this.remarks = remarks;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustom() {
		return this.custom;
	}

	public void setCustom(Long custom) {
		this.custom = custom;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getNextTime() {
		return this.nextTime;
	}

	public void setNextTime(Date nextTime) {
		this.nextTime = nextTime;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getEmp() {
		return this.emp;
	}

	public void setEmp(Long emp) {
		this.emp = emp;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}