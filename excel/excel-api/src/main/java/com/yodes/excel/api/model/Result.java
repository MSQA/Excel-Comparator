package com.yodes.excel.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Result {

	@Id
	private String id;

	private String label;

	private String name;

	private Integer serverId;

	private String ssrReportLocation;

	private String rsrReportLocation;

	private String htmlReportLocation;

	private String ssrResult;

	private String rsrResult;

	private String htmlResult;

	private Boolean resultStatus;

	private String date;

	private Integer ssrIdToCompareTo;

	private Integer rsrIdToCompareTo;

	private Integer htmlIdToCompareTo;

	private EnumType runType;

	private ComparatorResult compareResult;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id : " + id + " ,");
		sb.append("label : " + label + " ,");
		sb.append("name : " + name + " ,");
		sb.append("serverId : " + serverId + " ,");
		sb.append("ssrReportLocation : " + ssrReportLocation + " ,");
		sb.append("rsrReportLocation : " + rsrReportLocation + " ,");
		sb.append("htmlReportLocation : " + htmlReportLocation + " ,");
		sb.append("ssrResult : " + ssrResult + " ,");
		sb.append("rsrResult : " + rsrResult + " ,");
		sb.append("htmlResult : " + htmlResult + " ,");
		sb.append("resultStatus : " + resultStatus + " ,");
		sb.append("date : " + date + " ,");
		sb.append("ssrIdToCompareTo : " + ssrIdToCompareTo + " ,");
		sb.append("rsrIdToCompareTo : " + rsrIdToCompareTo + " ,");
		sb.append("htmlIdToCompareTo : " + htmlIdToCompareTo + " ,");
		sb.append("runType : " + runType);
		return sb.toString();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the serverId
	 */
	public Integer getServerId() {
		return serverId;
	}

	/**
	 * @param serverId
	 *            the serverId to set
	 */
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}

	/**
	 * @return the ssrReportLocation
	 */
	public String getSsrReportLocation() {
		return ssrReportLocation;
	}

	/**
	 * @param ssrReportLocation
	 *            the ssrReportLocation to set
	 */
	public void setSsrReportLocation(String ssrReportLocation) {
		this.ssrReportLocation = ssrReportLocation;
	}

	/**
	 * @return the rsrReportLocation
	 */
	public String getRsrReportLocation() {
		return rsrReportLocation;
	}

	/**
	 * @param rsrReportLocation
	 *            the rsrReportLocation to set
	 */
	public void setRsrReportLocation(String rsrReportLocation) {
		this.rsrReportLocation = rsrReportLocation;
	}

	/**
	 * @return the htmlReportLocation
	 */
	public String getHtmlReportLocation() {
		return htmlReportLocation;
	}

	/**
	 * @param htmlReportLocation
	 *            the htmlReportLocation to set
	 */
	public void setHtmlReportLocation(String htmlReportLocation) {
		this.htmlReportLocation = htmlReportLocation;
	}

	/**
	 * @return the ssrResult
	 */
	public String getSsrResult() {
		return ssrResult;
	}

	/**
	 * @param ssrResult
	 *            the ssrResult to set
	 */
	public void setSsrResult(String ssrResult) {
		this.ssrResult = ssrResult;
	}

	/**
	 * @return the rsrResult
	 */
	public String getRsrResult() {
		return rsrResult;
	}

	/**
	 * @param rsrResult
	 *            the rsrResult to set
	 */
	public void setRsrResult(String rsrResult) {
		this.rsrResult = rsrResult;
	}

	/**
	 * @return the htmlResult
	 */
	public String getHtmlResult() {
		return htmlResult;
	}

	/**
	 * @param htmlResult
	 *            the htmlResult to set
	 */
	public void setHtmlResult(String htmlResult) {
		this.htmlResult = htmlResult;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the ssrIdToCompareTo
	 */
	public Integer getSsrIdToCompareTo() {
		return ssrIdToCompareTo;
	}

	/**
	 * @param ssrIdToCompareTo
	 *            the ssrIdToCompareTo to set
	 */
	public void setSsrIdToCompareTo(Integer ssrIdToCompareTo) {
		this.ssrIdToCompareTo = ssrIdToCompareTo;
	}

	/**
	 * @return the rsrIdToCompareTo
	 */
	public Integer getRsrIdToCompareTo() {
		return rsrIdToCompareTo;
	}

	/**
	 * @param rsrIdToCompareTo
	 *            the rsrIdToCompareTo to set
	 */
	public void setRsrIdToCompareTo(Integer rsrIdToCompareTo) {
		this.rsrIdToCompareTo = rsrIdToCompareTo;
	}

	/**
	 * @return the htmlIdToCompareTo
	 */
	public Integer getHtmlIdToCompareTo() {
		return htmlIdToCompareTo;
	}

	/**
	 * @param htmlIdToCompareTo
	 *            the htmlIdToCompareTo to set
	 */
	public void setHtmlIdToCompareTo(Integer htmlIdToCompareTo) {
		this.htmlIdToCompareTo = htmlIdToCompareTo;
	}

	/**
	 * @return the resultStatus
	 */
	public Boolean getResultStatus() {
		return resultStatus;
	}

	/**
	 * @param resultStatus
	 *            the resultStatus to set
	 */
	public void setResultStatus(Boolean resultStatus) {
		this.resultStatus = resultStatus;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the runType
	 */
	public EnumType getRunType() {
		return runType;
	}

	/**
	 * @param runType
	 *            the runType to set
	 */
	public void setRunType(EnumType runType) {
		this.runType = runType;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the compareResult
	 */
	public ComparatorResult getCompareResult() {
		return compareResult;
	}

	/**
	 * @param compareResult
	 *            the compareResult to set
	 */
	public void setCompareResult(ComparatorResult compareResult) {
		this.compareResult = compareResult;
	}

}
