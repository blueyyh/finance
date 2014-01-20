package com.eisenmann.finance.bean;

import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.eisenmann.finance.bo.EisenmannFinanceBo;
import com.eisenmann.finance.model.AMailSendItem;
import com.eisenmann.finance.model.CashInAdvance;


@Component
@RequestScoped
public class CashInAdvanceListBean {
	
	@Autowired	
	private EisenmannFinanceBo eisenmannFinanceBo;
	
	private List<CashInAdvance> modelList;
	
	private CashInAdvance selectedCashInAdvance;
	
	private AMailSendItem mailItem = new AMailSendItem();
	
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
					"Cell Changed", "Old Value: " + oldValue + ", New Value:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
			int rowInx = event.getRowIndex();
			
			CashInAdvance cia = modelList.get(rowInx);
			
			eisenmannFinanceBo.mergeCashInAdvance(cia);
		}
	}

	public void sendMail(ActionEvent actionEvent) {
		
		RequestContext context = RequestContext.getCurrentInstance();  
		if(selectedCashInAdvance != null) 
			System.out.println("chnName: " + selectedCashInAdvance.getChnName());
		else
			System.out.println("selectedCashInAdvance is null");

//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("employeeName must be jack yang. just a test!"));

		  JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();  
	        // 设定mail server  
	        senderImpl.setHost("smtp.163.com");  
	  
	        // 建立邮件消息  
	        SimpleMailMessage mailMessage = new SimpleMailMessage();  
	        // 设置收件人，寄件人 用数组发送多个邮件  
	         String[] array = new String[] {"blueyhd@126.com","jack.yang@lombardrisk.com"};  
	         mailMessage.setTo(array);  
	        //mailMessage.setTo("");  
	        mailMessage.setFrom("bluesra@163.com");  
	        mailMessage.setSubject(" 测试简单文本邮件发送！ ");  
	        mailMessage.setText(" 测试我的简单邮件发送机制！！ ");  

	        senderImpl.setUsername("bluesra");
	        senderImpl.setPassword("Focus0562");  
	  
	        Properties prop = new Properties();  
	        prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确  
	        prop.put("mail.smtp.timeout", "25000");  
	        senderImpl.setJavaMailProperties(prop);  
	        // 发送邮件  
	         
	        senderImpl.send(mailMessage);
	        System.out.println(" 邮件发送成功.. ");  
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("邮件发送成功.."));
	}
	

	
	public void updateMailContent() {
		if(selectedCashInAdvance != null) 
		{
			mailItem.setSendTo(selectedCashInAdvance.getMailAddress());
			mailItem.setSubject("You have to pay");
			mailItem.setContent("Hi " + selectedCashInAdvance.getEmpName() + "\n You have to pay for balance");
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

	public CashInAdvance getSelectedCashInAdvance() {
		return selectedCashInAdvance;
	}

	public void setSelectedCashInAdvance(CashInAdvance selectedCashInAdvance) {
		this.selectedCashInAdvance = selectedCashInAdvance;
	}

	public AMailSendItem getMailItem() {
		return mailItem;
	}

	public void setMailItem(AMailSendItem mailItem) {
		this.mailItem = mailItem;
	}


}
