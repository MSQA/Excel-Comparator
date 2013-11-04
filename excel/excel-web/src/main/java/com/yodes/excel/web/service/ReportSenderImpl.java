package com.yodes.excel.web.service;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.yodes.excel.model.Report;

@Service("reportSender")
public class ReportSenderImpl implements ReportSender {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendReport(final Report report) {
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				MapMessage mapMessage = session.createMapMessage();
				mapMessage.setString("reportId", report.getId());
				return mapMessage;
			}
		});
	}

}
