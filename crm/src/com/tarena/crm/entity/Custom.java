package com.tarena.crm.entity;

import java.util.Date;

/**
 * Custom entity. @author MyEclipse Persistence Tools
 */

public class Custom implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String job;
	private Integer gender;
	private Date birthday;
	private String qq;
	private String weibo;
	private String msn;
	private Long creator;
	private Integer status;
	private Integer source;
	private Integer type;
	private String email;
	private String mobliePhone;
	private String phone;
	private String address;
	private String company;
	private Integer modifier;
	private String remarks;
	private Date createDate;
	private Long belongTo;

	// Constructors

	/** default constructor */
	public Custom() {
	}

	/** minimal constructor */
	public Custom(String name, String job, Integer gender, String qq,
			Long creator, Integer status, Integer source, Integer type,
			String email, String mobliePhone, String company, Date createDate) {
		this.name = name;
		this.job = job;
		this.gender = gender;
		this.qq = qq;
		this.creator = creator;
		this.status = status;
		this.source = source;
		this.type = type;
		this.email = email;
		this.mobliePhone = mobliePhone;
		this.company = company;
		this.createDate = createDate;
	}

	/** full constructor */
	public Custom(String name, String job, Integer gender, Date birthday,
			String qq, String weibo, String msn, Long creator, Integer status,
			Integer source, Integer type, String email, String mobliePhone,
			String phone, String address, String company, Integer modifier,
			String remarks, Date createDate, Long belongTo) {
		this.name = name;
		this.job = job;
		this.gender = gender;
		this.birthday = birthday;
		this.qq = qq;
		this.weibo = weibo;
		this.msn = msn;
		this.creator = creator;
		this.status = status;
		this.source = source;
		this.type = type;
		this.email = email;
		this.mobliePhone = mobliePhone;
		this.phone = phone;
		this.address = address;
		this.company = company;
		this.modifier = modifier;
		this.remarks = remarks;
		this.createDate = createDate;
		this.belongTo = belongTo;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeibo() {
		return this.weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getMsn() {
		return this.msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public Long getCreator() {
		return this.creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSource() {
		return this.source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobliePhone() {
		return this.mobliePhone;
	}

	public void setMobliePhone(String mobliePhone) {
		this.mobliePhone = mobliePhone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getModifier() {
		return this.modifier;
	}

	public void setModifier(Integer modifier) {
		this.modifier = modifier;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getBelongTo() {
		return this.belongTo;
	}

	public void setBelongTo(Long belongTo) {
		this.belongTo = belongTo;
	}

}