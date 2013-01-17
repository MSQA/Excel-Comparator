package com.yodes.excel.comparitor;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.yodes.excel.comparitor.model.ComparitorResult;

public interface Comparitor {
	ComparitorResult compare(HSSFWorkbook origionalWorkBook, HSSFWorkbook currentWorkBook, ComparitorResult comparitorResult) throws Exception;
}
