package com.yodes.excel.comparator;

import java.io.File;

import com.yodes.excel.model.ComparatorResult;

/**
 * Service to compare two excel files and return a {@link ComparatorResult}
 */
public interface ComparatorService {

	/**
	 * @param origional
	 *            file to act as basis
	 * @param current
	 *            file to identify changes in
	 * @return ComparitorResult show differences between files
	 * @throws Exception
	 */
	public ComparatorResult compareReports(File origional, File current) throws Exception;

}
