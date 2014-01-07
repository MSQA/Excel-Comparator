package com.yodes.excel.web.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import com.yodes.excel.api.model.message.CompareMessage;
import com.yodes.excel.web.Setup;
import com.yodes.excel.web.service.CompareMessageSender;

public class CompareMessageSenderTest extends Setup {

	@Autowired
	private CompareMessageSender sender;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Test
	public void testSendReport() {
		CompareMessage message = new CompareMessage();
		sender.sendCompareMessage(message);
		// TODO find a method to test the message contents
	}

}
