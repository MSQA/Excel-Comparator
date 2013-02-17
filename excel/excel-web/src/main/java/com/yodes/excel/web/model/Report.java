package com.yodes.excel.web.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Document
public class Report {

	@Id
	private String id;

	private String userName;

	private String dateAdded;

	private String zipLocation;

	private String zipName;

	private String idLastValidated;

	private boolean statusLastRun;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id : " + id + " ,");
		sb.append("userName : " + userName + " ,");
		sb.append("dateAdded : " + dateAdded + " ,");
		sb.append("zipLocation : " + zipLocation + " ,");
		sb.append("zipName : " + zipName + " ,");
		sb.append("idLastValidated : " + idLastValidated + " ,");
		sb.append("statusLastRun : " + statusLastRun + " ,");
		return sb.toString();
	}

	@Transient
	private CommonsMultipartFile grabFile;

	/**
	 * @param grabFile
	 *            the grabFile to set
	 */
	public void setGrabFile(CommonsMultipartFile grabFile) {
		this.grabFile = grabFile;
	}

	/**
	 * @return the grabFile
	 */
	public CommonsMultipartFile getGrabFile() {
		return grabFile;
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

	/**
	 * @return the zipLocation
	 */
	public String getZipLocation() {
		return zipLocation;
	}

	/**
	 * @param zipLocation
	 *            the zipLocation to set
	 */
	public void setZipLocation(String zipLocation) {
		this.zipLocation = zipLocation;
	}

	/**
	 * @return the idLastValidated
	 */
	public String getIdLastValidated() {
		return idLastValidated;
	}

	/**
	 * @param idLastValidated
	 *            the idLastValidated to set
	 */
	public void setIdLastValidated(String idLastValidated) {
		this.idLastValidated = idLastValidated;
	}

	/**
	 * @return the zipName
	 */
	public String getZipName() {
		return zipName;
	}

	/**
	 * @param zipName
	 *            the zipName to set
	 */
	public void setZipName(String zipName) {
		this.zipName = zipName;
	}

	/**
	 * @return the statusLastRun
	 */
	public boolean getStatusLastRun() {
		return statusLastRun;
	}

	/**
	 * @param statusLastRun
	 *            the statusLastRun to set
	 */
	public void setStatusLastRun(boolean statusLastRun) {
		this.statusLastRun = statusLastRun;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
