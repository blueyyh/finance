package com.eisenmann.finance.dao;

import java.util.List;

import com.eisenmann.finance.model.CashInAdvance;

public interface CashInAdvanceDao {

	public void addCashInAdvance(CashInAdvance ca);

	public void updateCashInAdvance(CashInAdvance ca);

	public List<CashInAdvance> getAllCashInAdvance();
}
