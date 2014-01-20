package com.eisenmann.finance.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eisenmann.finance.dao.CashInAdvanceDao;
import com.eisenmann.finance.model.CashInAdvance;

@Transactional
@Repository
public class CashInAdvanceDaoImpl implements CashInAdvanceDao {
	private SessionFactory sessionFactory;
	private static final String SYSTEMEVENTS_FOR_USERNAME = "SELECT r FROM SystemEvents r WHERE r.userName = :username order by r.deviceReportedTime desc";
	
	@Autowired
	public CashInAdvanceDaoImpl(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}	
	
	public void addCashInAdvance(CashInAdvance ca) {
		currentSession().save(ca);
	}

	public void mergeCashInAdvance(CashInAdvance ca) {
		currentSession().merge(ca);
	}
	
	
	public void updateCashInAdvance(CashInAdvance ca) {
		currentSession().update(ca);
	}	
	
	@SuppressWarnings("unchecked")
	public List<CashInAdvance> getAllCashInAdvance() {
		Query query = currentSession().createQuery("from CashInAdvance r");
		return (List<CashInAdvance>)query.list();
	}
}
