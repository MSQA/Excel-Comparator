package com.yodes.excel.web.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Compare {
	private CommonsMultipartFile originalFile;
	private CommonsMultipartFile newFile;

	/**
	 * @param originalFile
	 *            the originalFile to set
	 */
	public void setOriginalFile(CommonsMultipartFile originalFile) {
		this.originalFile = originalFile;
	}

	/**
	 * @return the originalFile
	 */
	public CommonsMultipartFile getOriginalFile() {
		return originalFile;
	}

	/**
	 * @param newFile
	 *            the newFile to set
	 */
	public void setNewFile(CommonsMultipartFile newFile) {
		this.newFile = newFile;
	}

	/**
	 * @return the newFile
	 */
	public CommonsMultipartFile getNewFile() {
		return newFile;
	}
}
