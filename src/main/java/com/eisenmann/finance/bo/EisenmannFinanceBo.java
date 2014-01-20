package com.eisenmann.finance.bo;

import java.util.List;

import com.eisenmann.finance.bean.CashInAdvInfo;
import com.eisenmann.finance.model.CashInAdvance;

public interface EisenmannFinanceBo {
	public void saveCashInAdvance(CashInAdvance ciaInfo);
	
	public List<CashInAdvance> getAllCashInAdvance();
	
	public void mergeCashInAdvance(CashInAdvance cia);
}
