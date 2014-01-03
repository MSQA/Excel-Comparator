package com.yodes.excel.web.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Class to hold references to the uploaded file input streams
 */
public class CommonsMultipartFiles {

	/**
	 * Original file to be used as the base for comparison
	 */
	private CommonsMultipartFile originalFile;

	/**
	 * Updated file to detect changes within
	 */
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
