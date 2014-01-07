package com.yodes.excel.api.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class to represent a comparison of two files stored as a document in the database
 */
@Document
public class Report implements Serializable {

	/**
	 * Serial version ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Unique ID of the report
	 */
	@Id
	private String id;

	/**
	 * Username of the user who uploaded the report, null if un-authenticated
	 */
	private String userName;

	/**
	 * Date the report was added
	 */
	private String dateAdded;

	/**
	 * ID of the base file uploaded
	 */
	private String baseFileId;

	/**
	 * ID of the new or updated file to compare with the base report
	 */
	private String newFileId;

	/**
	 * status of the current report ie. queue, running, failed, completed ect
	 */
	private String status;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id : " + id + " ,");
		sb.append("userName : " + userName + " ,");
		sb.append("dateAdded : " + dateAdded + " ,");
		sb.append("baseFileId : " + baseFileId + " ,");
		sb.append("newFileId : " + newFileId + " ,");
		sb.append("status : " + status + " ,");
		return sb.toString();
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the dateAdded
	 */
	public String getDateAdded() {
		return dateAdded;
	}

	/**
	 * @param dateAdded
	 *            the dateAdded to set
	 */
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the newFileId
	 */
	public String getNewFileId() {
		return newFileId;
	}

	/**
	 * @param newFileId
	 *            the newFileId to set
	 */
	public void setNewFileId(String newFileId) {
		this.newFileId = newFileId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
