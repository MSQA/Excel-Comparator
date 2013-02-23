package com.yodes.excel.comparator.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Utility method to create stubs for testing
 * 
 * @author Stephen Dillon
 */
public class StubHSSF {

	private static final String testSheetName = "testSheet";

	public static HSSFWorkbook getWorkbook() {
		return new HSSFWorkbook();
	}

	public static HSSFSheet getSheet(String sheetname) {
		HSSFWorkbook workbook = getWorkbook();
		workbook.createSheet(sheetname);
		return workbook.getSheet(sheetname);
	}

	public static HSSFRow getRow() {
		HSSFSheet sheet = getSheet(testSheetName);
		return sheet.createRow(0);
	}

	public static HSSFCell getcell(int column) {
		HSSFRow sheet = getRow();
		return sheet.createCell(column);
	}

}
