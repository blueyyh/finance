package com.eisenmann.finance.model;

import static javax.persistence.GenerationType.AUTO;






import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "CASH_IN_ADVANCE")
public class CashInAdvance {
	private Long id;
	
	private String chnName;
	
	private String empName;
	
	private Double balance;
	
	private String remark1;
	
	private String vouchNo;
	
	private Date date;
	
	private String remark2;
	
	private String mailAddress;

	@Id
	@GeneratedValue(strategy = AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="chnName")
	public String getChnName() {
		return chnName;
	}

	public void setChnName(String chnName) {
		this.chnName = chnName;
	}

	@Column(name="empName")
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Column(name="balance")
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Column(name="remark1")
	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	@Column(name="vouchNo")
	public String getVouchNo() {
		return vouchNo;
	}

	public void setVouchNo(String vouchNo) {
		this.vouchNo = vouchNo;
	}

	@Column(name="dateTerm")
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name="remark2")
	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	@Column(name="mailAddress")
	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	
	
}
