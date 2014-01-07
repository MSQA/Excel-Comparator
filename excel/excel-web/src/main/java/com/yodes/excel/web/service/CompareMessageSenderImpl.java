package com.yodes.excel.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.yodes.excel.api.model.message.CompareMessage;

/**
 * Implementation of the {@link CompareMessageSender} interface that used the {@link JmsTemplate} to send messages
 */
@Service
public class CompareMessageSenderImpl implements CompareMessageSender {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public void sendCompareMessage(CompareMessage message) {
		jmsTemplate.convertAndSend(message);
	}

}
