package com.olive.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_upi_errorcode")
public class UPIErrorCode implements Serializable {

	private static final long serialVersionUID = 2788646884199821792L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "description", length = 255)
	private String description;

	@Column(name = "UPIRC", length=5)
	private String upirc;
	
	@Column(name="api", length=70)
    private String api;
    
    @Column(name="created_by", length=70)
	private String created_by;
	
	@Column(name="created_date")
	private Date created_date;
	
	@Column(name="updated_by", length=70)
	private String modified_by;
	
	@Column(name="updated_date")
	private Date modified_date;
	
}
