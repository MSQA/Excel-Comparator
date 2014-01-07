package com.yodes.excel.comparator.util;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import com.yodes.excel.api.model.ExcelRow;
import com.yodes.excel.comparator.comparators.HSSFComparator;

public class ComparatorUtils {

	private static final Logger logger = Logger.getLogger(HSSFComparator.class);

	/**
	 * Method to convert a {@link HSSFRow} to a {@link ExcelRow}
	 * 
	 * @param row
	 *            to convert
	 * @return {@link ExcelRow} converted row
	 */
	public static ExcelRow convertToExcelRow(HSSFRow row) {
		ExcelRow excelRow = new ExcelRow();
		if (row != null) {
			if (row.getLastCellNum() != -1) {
				for (int j = 0; j < row.getLastCellNum(); j++) {
					convertHSSFCell(excelRow, row.getCell(j));
				}
			}
		}
		return excelRow;
	}

	protected static void convertHSSFCell(ExcelRow excelRow, HSSFCell cell) {
		try {
			if (cell != null) {
				HSSFRichTextString orgionalString = cell.getRichStringCellValue();
				excelRow.getCells().add(orgionalString.toString());
			} else {
				excelRow.getCells().add(" ");
			}
		} catch (Exception e) {
			logger.warn("Error reading cell string value : " + e.getMessage());
		}
	}

	/**
	 * Method to convert a {@link XSSFRow} to a {@link ExcelRow}
	 * 
	 * @param row
	 *            to convert
	 * @return {@link ExcelRow} converted row
	 */
	public static ExcelRow convertToExcelRow(XSSFRow row) {
		ExcelRow excelRow = new ExcelRow();
		if (row != null) {
			if (row.getLastCellNum() != -1) {
				for (int j = 0; j < row.getLastCellNum(); j++) {
					convertXSSFCell(excelRow, row.getCell(j));
				}
			}
		}
		return excelRow;
	}

	protected static void convertXSSFCell(ExcelRow excelRow, XSSFCell cell) {
		try {
			if (cell != null) {
				excelRow.getCells().add(cell.getStringCellValue());
			} else {
				excelRow.getCells().add(" ");
			}
		} catch (Exception e) {
			logger.warn("Error reading cell string value : " + e.getMessage());
		}
	}
}
