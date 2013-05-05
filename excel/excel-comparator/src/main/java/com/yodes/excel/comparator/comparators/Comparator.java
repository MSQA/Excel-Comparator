package com.yodes.excel.comparator.comparators;

import java.io.File;

import com.yodes.excel.model.ComparatorResult;

public interface Comparator {

	/**
	 * Test to check if this comparator can compare these sheets
	 * 
	 * @param origional
	 *            sheet to use as base
	 * @param current
	 *            sheet to detect changes in
	 * @return boolean if this comparator can compare these files
	 * @throws Exception
	 */
	boolean isComparator(File origional, File current) throws Exception;

	/**
	 * @param origional
	 *            sheet to use as base
	 * @param current
	 *            sheet to detect changes in
	 * @param comparitorResult
	 *            listing all differences (hopefully...)
	 * @throws Exception
	 */
	void compare(File origional, File current, ComparatorResult comparitorResult) throws Exception;
}
