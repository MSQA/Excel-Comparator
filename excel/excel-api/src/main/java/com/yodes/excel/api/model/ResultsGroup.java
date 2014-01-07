package com.yodes.excel.api.model;

import java.util.LinkedList;
import java.util.List;

public class ResultsGroup {

	private List<Result> results = new LinkedList<Result>();

	private String formattedDate;

	private boolean result;

	private String label;

	/**
	 * @return the results
	 */
	public List<Result> getResults() {
		return results;
	}

	/**
	 * @param results
	 *            the results to set
	 */
	public void setResults(List<Result> results) {
		this.results = results;
	}

	/**
	 * @return the formattedDate
	 */
	public String getFormattedDate() {
		return formattedDate;
	}

	/**
	 * @param formattedDate
	 *            the formattedDate to set
	 */
	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}

	/**
	 * @return the result
	 */
	public boolean isResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(boolean result) {
		this.result = result;
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

}
