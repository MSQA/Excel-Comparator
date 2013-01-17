/**
 * This code is copyright (c) 2012 EMC Corporation
 */
package com.yodes.excel.comparitor;

import java.io.File;

import com.yodes.excel.comparitor.model.ComparitorResult;

/**
 * Service to compare two excel files and return a {@link ComparitorResult}
 */
public interface ComparitorService {

	/**
	 * @param origional
	 *            file to act as basis
	 * @param current
	 *            file to identify changes in
	 * @return ComparitorResult show differences between files
	 * @throws Exception
	 */
	public ComparitorResult compareRsrReport(File origional, File current) throws Exception;

}
