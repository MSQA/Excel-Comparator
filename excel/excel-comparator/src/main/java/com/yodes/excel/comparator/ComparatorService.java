package com.yodes.excel.comparator;

import java.io.File;

import com.yodes.excel.model.ComparatorResult;

/**
 * Service to compare two excel files and return a {@link ComparatorResult}
 */
public interface ComparatorService {

	/**
	 * Method to compare two excel reports. Searches for a comparator that can handle these files and returns the
	 * {@link ComparitorResult} with attribute compared set to true. If no comparator is found comparitorResult will be
	 * set to false
	 * 
	 * @param origional
	 *            file to act as basis
	 * @param current
	 *            file to identify changes in
	 * @return ComparitorResult show differences between files
	 */
	public ComparatorResult compareReports(File origional, File current);

}
