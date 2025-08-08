package com.olive.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "tbl_upi_number_details")
public class UpiNumberDetails implements Serializable {
	public static final String DEREGISTER = "DEREGISTER";

	public static final String ACTIVE = "ACTIVE";
	public static final String INACTIVE = "INACTIVE";

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;

	@Column(name = "UPI_NUMBER", length = 25, unique = true)
	public String upiNumber;

	@Column(name = "CUSTOMERID", length = 15)
	public String customerid;

	@Column(name = "VPA", length = 100)
	public String vpa;

	@Column(name = "STATUS", length = 10)
	public String status;

	@Column(name = "APP", length = 100)
	public String app;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE")
	public Date createdDate;

	@Column(name = "UPDATED_DATE")
	public Date updatedDate;

	@Column(name = "DEREGISTER_DATE")
	public Date deregisterDate;

	@Column(name = "UPI_NUM_TYPE")
	public String upiNumType;

	@Column(name = "AGGREGATOR_ID", length = 25)
	public String aggregator_id;

	@Column(name = "MERCHAT_ID", length = 25)
	public String merchat_id;

	@Column(name = "handlerid", length = 2)
	public long handlerId = 1;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUpiNumber() {
		return upiNumber;
	}

	public void setUpiNumber(String upiNumber) {
		this.upiNumber = upiNumber;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getVpa() {
		return vpa;
	}

	public void setVpa(String vpa) {
		this.vpa = vpa;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getDeregisterDate() {
		return deregisterDate;
	}

	public void setDeregisterDate(Date deregisterDate) {
		this.deregisterDate = deregisterDate;
	}

	public String getUpiNumType() {
		return upiNumType;
	}

	public void setUpiNumType(String upiNumType) {
		this.upiNumType = upiNumType;
	}

	public String getAggregator_id() {
		return aggregator_id;
	}

	public void setAggregator_id(String aggregator_id) {
		this.aggregator_id = aggregator_id;
	}

	public String getMerchat_id() {
		return merchat_id;
	}

	public void setMerchat_id(String merchat_id) {
		this.merchat_id = merchat_id;
	}

	public long getHandlerId() {
		return handlerId;
	}

	public void setHandlerId(long handlerId) {
		this.handlerId = handlerId;
	}

}