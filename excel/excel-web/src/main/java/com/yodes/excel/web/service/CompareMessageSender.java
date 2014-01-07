package com.yodes.excel.web.service;

import com.yodes.excel.api.model.message.CompareMessage;

/**
 * Interface for a service to send a message to compare reports
 */
public interface CompareMessageSender {

	/**
	 * Send a message to compare two files and save the results
	 * 
	 * @param message
	 *            Item to send to the message queue
	 */
	void sendCompareMessage(CompareMessage message);

}
