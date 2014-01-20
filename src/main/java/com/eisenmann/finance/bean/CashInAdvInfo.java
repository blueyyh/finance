package com.eisenmann.finance.bean;

import java.util.Date;

public class CashInAdvInfo {
	private String chnName;
	
	private String empName;
	
	private Double balance;
	
	private String remark1;
	
	private String vouchNo;
	
	private Date date;
	
	private String remark2;
	
	private String mailAddress;

	public String getChnName() {
		return chnName;
	}

	public void setChnName(String chnName) {
		this.chnName = chnName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getVouchNo() {
		return vouchNo;
	}

	public void setVouchNo(String vouchNo) {
		this.vouchNo = vouchNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	
	
}
