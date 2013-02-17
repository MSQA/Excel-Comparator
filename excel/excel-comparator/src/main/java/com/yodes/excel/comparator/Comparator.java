package com.yodes.excel.comparator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.yodes.excel.comparator.model.ComparatorResult;

public interface Comparator {
	ComparatorResult compare(HSSFWorkbook origionalWorkBook, HSSFWorkbook currentWorkBook, ComparatorResult comparitorResult) throws Exception;
}
