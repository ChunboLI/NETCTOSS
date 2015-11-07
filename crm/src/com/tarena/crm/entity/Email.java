package com.tarena.crm.entity;

import java.util.Date;

/**
 * Email entity. @author MyEclipse Persistence Tools
 */

public class Email implements java.io.Serializable {

	// Fields

	private Long id;
	private Long sender;
	private Long receiver;
	private String theme;
	private String content;
	private Date time;
	private Boolean status;

	// Constructors

	/** default constructor */
	public Email() {
	}

	/** full constructor */
	public Email(Long sender, Long receiver, String theme, String content,
			Date time, Boolean status) {
		this.sender = sender;
		this.receiver = receiver;
		this.theme = theme;
		this.content = content;
		this.time = time;
		this.status = status;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSender() {
		return this.sender;
	}

	public void setSender(Long sender) {
		this.sender = sender;
	}

	public Long getReceiver() {
		return this.receiver;
	}

	public void setReceiver(Long receiver) {
		this.receiver = receiver;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}