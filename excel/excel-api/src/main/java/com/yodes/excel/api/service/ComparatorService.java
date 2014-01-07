package com.yodes.excel.api.service;

import com.yodes.excel.api.model.ComparatorResult;
import com.yodes.excel.api.model.Report;

/**
 * Service to compare two excel files and return a {@link ComparatorResult}
 */
public interface ComparatorService {

	/**
	 * Method to compare two excel reports. Searches for a comparator that can handle these files and returns the
	 * {@link ComparatorResult} with attribute compared set to true. If no comparator is found comparitorResult will be
	 * set to false
	 * 
	 * @param report
	 *            report to compare excel files
	 * @return ComparitorResult show differences between files
	 */
	public void compareReports(Report report);

}
