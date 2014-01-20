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
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
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
					"Cell Changed", "Old Value: " + oldValue + ", New Value:"
							+ newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			int rowInx = event.getRowIndex();

			CashInAdvance cia = modelList.get(rowInx);

			eisenmannFinanceBo.mergeCashInAdvance(cia);
		}
	}

	public void sendMail(ActionEvent actionEvent) {

		RequestContext context = RequestContext.getCurrentInstance();
		if (selectedCashInAdvance != null) {
			System.out
					.println("chnName: " + selectedCashInAdvance.getChnName());

			JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

			senderImpl.setHost("smtp.163.com");
			MimeMessage mime = senderImpl.createMimeMessage();
			MimeMessageHelper helper;
			try {
				helper = new MimeMessageHelper(mime, false, "utf-8");
				helper.setFrom("bluesra@163.com");
				helper.setTo(mailItem.getSendTo());
				if(mailItem.getSendCc() != null && !"".equals(mailItem.getSendCc()))
						helper.setCc(mailItem.getSendCc());
				helper.setSubject(mailItem.getSubject());
				helper.setText(mailItem.getContent());
			} catch (MessagingException me) {
				me.printStackTrace();
			}
			//
			// SimpleMailMessage mailMessage = new SimpleMailMessage();
			//
			// String[] array = new String[]
			// {"blueyhd@126.com","jack.yang@lombardrisk.com"};
			// mailMessage.setTo(array);
			// mailMessage.setFrom("bluesra@163.com");
			// mailMessage.setSubject(mailItem.getSubject());
			// mailMessage.setText(mailItem.getContent());

			senderImpl.setUsername("bluesra");
			senderImpl.setPassword("Focus0562");

			Properties prop = new Properties();
			prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
			prop.put("mail.smtp.timeout", "25000");
			senderImpl.setJavaMailProperties(prop);
			// 发送邮件

			senderImpl.send(mime);
			System.out.println(" 邮件发送成功.. ");
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("邮件发送成功.."));
		}
	}

	public void updateMailContent() {
		if (selectedCashInAdvance != null) {
			mailItem.setSendTo(selectedCashInAdvance.getMailAddress());
			mailItem.setSubject("You have to pay");
			mailItem.setContent("Hi " + selectedCashInAdvance.getEmpName()
					+ "\n\n Could please pay for the balance A.S.A.P. \n\n Thanks,\nMike");
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
