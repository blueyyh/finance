package com.eisenmann.finance.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eisenmann.finance.bean.CashInAdvInfo;
import com.eisenmann.finance.bo.EisenmannFinanceBo;
import com.eisenmann.finance.dao.CashInAdvanceDao;
import com.eisenmann.finance.model.CashInAdvance;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class EisenmannFinanceBoImpl implements EisenmannFinanceBo {
	
	@Autowired
	private CashInAdvanceDao cashInAdvanceDao;
	
	public void saveCashInAdvance(CashInAdvInfo ciaInfo) {
		CashInAdvance model = new CashInAdvance();
		model.setBalance(ciaInfo.getBalance());
		model.setChnName(ciaInfo.getChnName());
		
		model.setDate(new java.sql.Date(ciaInfo.getDate().getTime()));
		model.setEmpName(ciaInfo.getEmpName());
		model.setMailAddress(ciaInfo.getMailAddress());
		model.setRemark1(ciaInfo.getRemark1());
		model.setRemark2(ciaInfo.getRemark2());
		model.setVouchNo(ciaInfo.getVouchNo());
		cashInAdvanceDao.addCashInAdvance(model);
	}
	
	public List<CashInAdvance> getAllCashInAdvance() {
		return cashInAdvanceDao.getAllCashInAdvance();
	}
}
