package com.yodes.excel.comparator.comparators;

import java.io.File;

import org.springframework.core.PriorityOrdered;

import com.yodes.excel.api.model.ComparatorResult;

public interface Comparator extends PriorityOrdered {

	/**
	 * Test to check if this comparator can compare these sheets
	 * 
	 * @param origional
	 *            sheet to use as base
	 * @param current
	 *            sheet to detect changes in
	 * @return boolean if this comparator can compare these files
	 */
	boolean isComparator(File origional, File current);

	/**
	 * @param origional
	 *            sheet to use as base
	 * @param current
	 *            sheet to detect changes in
	 * @param comparitorResult
	 *            listing all differences (hopefully...)
	 */
	void compare(File origional, File current, ComparatorResult comparitorResult);
}
