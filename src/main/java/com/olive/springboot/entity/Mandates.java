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

@Entity
@Table(name="tbl_mandates")
@Data
public class Mandates implements Serializable{
	private static final long serialVersionUID = 15467646757656858L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public String payerMobile;
	public String payeeMobile;
	public String mandateType;
	public String initiatedBy;
	@Column(unique=true) 
	public String umn;
	public String revokeable;
	public String shareToPayee;
	@Column(unique=true) 
	public String txnid;
	public String validity_start;
	public String validity_end;
	public String amount;
	public String amountRule;
	public String recurrencePattern;
	public String rule_value;
	public String rule_type;
	public String credType;
	public String payerVpa;
	public String payeeVpa;
	@Column(length=50)
	public String payerType;
	@Column(length=50)
	public String payeeType;
	@Column(length=50)
	public String payeeCode;
	@Column(length=50)
	public String payerCode;
	
	public Date createdDate;
	public Date updatedDate;
	public String dgtSign;
	@Column(length=50)
	public String payerAccountNumber;
	@Column(length=50)
	public String payeeAccountNumber;
	@Column(length=20)
	public String payerIfsc;
	@Column(length=20)
	public String payeeIfsc;
	public String payerAccountName;
	public String payeeAccountName;
	public String payerAccountType;
	public String payeeAccountType;
	public String payerStatus;
	public String payeeStatus;
	public String remitterStatus;
	public String remitterStatus_sch;
	public String mandateName;
	public String remarks;
	public String recurrenceRuleType;
	public String recurrenceRuleValue;
	@Column(length=50)
	public String upiRc;
	@Column(length=50)
	public String subRc;
	public String payerName;
	public String payeeName;
	@Column(length=5)
	public String merchantflag;
	public String rrn;
	public boolean mandateExecute=false;
	@Column(length=5)
	public String blockFund;
	public String payerChannel;
	public String payeeChannel;
	public long payerHandlerId=0; 
	public long payeeHandlerId=0;
	@Column(length=5)
	public String initMode;
//	public String payeerInitMode;
	@Column(length=5)
	public String purposeCode;
//	public String payeerPurpose;
	@Column(length=50)
	public String orgTxnid;
	@Column(length=150)
	public String refurl;
	@Column(length=50)
	public String refid;
	
	public Date executedDate;
	@Column(length=50)
	public String executedAmount;
	@Column(length=50)
	public String executedTxnid;
	@Column(length=50)
	public String executedRrn;
	@Column(length=10)
	public String remittorMandateExecute;
	
	public String gmtDate;
	
	public String reexst;
	public String reexsch;
	public String msgid;
	public String leinId;
	
	public boolean ispreapproved = false;
	
	public String serverIp;
	public String remitterRc;
	
	// reureence pattern changes
	public String payerSeqNum;
	public String payeeSeqNum;
	public String remitterSeqNum;
	public String pause_start;
	public String pause_end;

	// upi-voucher
	@Column(name = "voucher_uuid", length = 100)
	public String voucherUuid;

	@Column(name = "voucher_mcc_list", length = 1000)
	public String voucherMccList;

	@Column(name = "is_whitelisted_mccs", length = 50)
	public String isWhitelistedMccs;

	@Column(name = "tiny_id")
	public String tinyId;
	

	
}
