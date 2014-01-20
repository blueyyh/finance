package com.eisenmann.finance.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eisenmann.finance.bo.EisenmannFinanceBo;
import com.eisenmann.finance.model.CashInAdvance;


@Component
@RequestScoped
public class CashInAdvanceListBean {
	
	@Autowired	
	private EisenmannFinanceBo eisenmannFinanceBo;
	
	private List<CashInAdvance> modelList;
	
	public CashInAdvanceListBean() {
		populateCashInAdvList();
	}
	
	@PostConstruct
	public void init() {
		modelList = eisenmannFinanceBo.getAllCashInAdvance();
	}
	
	public void reload() {
		modelList = eisenmannFinanceBo.getAllCashInAdvance();
	}
	
	private void populateCashInAdvList() {
		
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Cell Changed", "Old: " + oldValue + ", New:" + newValue + "rowid: +" + event.getRowIndex());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public EisenmannFinanceBo getEisenmannFinanceBo() {
		return eisenmannFinanceBo;
	}

	public void setEisenmannFinanceBo(EisenmannFinanceBo eisenmannFinanceBo) {
		this.eisenmannFinanceBo = eisenmannFinanceBo;
	}

	public List<CashInAdvance> getModelList() {
		return modelList;
	}

	public void setModelList(List<CashInAdvance> modelList) {
		this.modelList = modelList;
	}


}
