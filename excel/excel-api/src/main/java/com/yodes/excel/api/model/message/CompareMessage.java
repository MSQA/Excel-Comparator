package com.yodes.excel.api.model.message;

import java.io.Serializable;

/**
 * A class to represent a message to trigger the comparison of two report
 */
public class CompareMessage implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A unique label used to identify the current report
	 */
	private String reportId;

	/**
	 * The base file to compare the updated file against
	 */
	private String baseFileId;

	/**
	 * The updated file to check for modifications against the base file
	 */
	private String updatedFileId;

	/**
	 * @return the reportId
	 */
	public String getReportId() {
		return reportId;
	}

	/**
	 * @param reportId
	 *            the reportId to set
	 */
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	/**
	 * @return the baseFileId
	 */
	public String getBaseFileId() {
		return baseFileId;
	}

	/**
	 * @param baseFileId
	 *            the baseFileId to set
	 */
	public void setBaseFileId(String baseFileId) {
		this.baseFileId = baseFileId;
	}

	/**
	 * @return the updatedFileId
	 */
	public String getUpdatedFileId() {
		return updatedFileId;
	}

	/**
	 * @param updatedFileId
	 *            the updatedFileId to set
	 */
	public void setUpdatedFileId(String updatedFileId) {
		this.updatedFileId = updatedFileId;
	}

}
