package com.eisenmann.finance.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eisenmann.finance.bo.EisenmannFinanceBo;

@ManagedBean
@Component
@RequestScoped
public class CashInAdvanceBean {

	@Autowired	
	private EisenmannFinanceBo eisenmannFinanceBo;

	private CashInAdvInfo ciaItem = new CashInAdvInfo();
	

	
	public CashInAdvanceBean() {
		
	}
	
	public List<String> completeArea1(String query) {
		List<String> results = new ArrayList<String>();

		if (query.equals("PrimeFaces")) {
			results.add("PrimeFaces Rocks!!!");
			results.add("PrimeFaces has 100+ components.");
			results.add("PrimeFaces is lightweight.");
			results.add("PrimeFaces is easy to use.");
			results.add("PrimeFaces is developed with passion!");
		} else {
			for (int i = 0; i < 10; i++) {
				results.add(query + i);
			}
		}

		return results;
	}

	public List<String> completeArea2(String query) {
		List<String> results = new ArrayList<String>();

		if (query.equals("PrimeFaces")) {
			results.add("PrimeFaces Rocks!!!");
			results.add("PrimeFaces has 100+ components.");
			results.add("PrimeFaces is lightweight.");
			results.add("PrimeFaces is easy to use.");
			results.add("PrimeFaces is developed with passion!");
		} else {
			for (int i = 0; i < 10; i++) {
				results.add(query + i);
			}
		}

		return results;
	}

	public String save(String target) {
		eisenmannFinanceBo.saveCashInAdvance(ciaItem);
		return target + "?faces-redirect=true&";
	}

	public CashInAdvInfo getCiaItem() {
		return ciaItem;
	}

	public void setCiaItem(CashInAdvInfo ciaItem) {
		this.ciaItem = ciaItem;
	}

	public EisenmannFinanceBo getEisenmannFinanceBo() {
		return eisenmannFinanceBo;
	}

	public void setEisenmannFinanceBo(EisenmannFinanceBo eisenmannFinanceBo) {
		this.eisenmannFinanceBo = eisenmannFinanceBo;
	}



	
}
