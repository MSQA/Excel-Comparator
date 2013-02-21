package com.yodes.excel.comparator.util;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.XSSFRow;

import com.yodes.excel.comparator.model.ExcelRow;

public class ComparatorUtils {

	public static ExcelRow convertToExcelRow(HSSFRow row) {
		ExcelRow excelRow = new ExcelRow();
		if (row != null) {
			if (row.getLastCellNum() != -1) {
				for (int j = 0; j < row.getLastCellNum(); j++) {
					try {
						if (row.getCell(j) != null) {
							HSSFRichTextString orgionalString = row.getCell(j).getRichStringCellValue();
							excelRow.getCells().add(orgionalString.toString());
						} else {
							excelRow.getCells().add(" ");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return excelRow;
	}

	public static ExcelRow convertToExcelRow(XSSFRow row) {
		ExcelRow excelRow = new ExcelRow();
		if (row != null) {
			if (row.getLastCellNum() != -1) {
				for (int j = 0; j < row.getLastCellNum(); j++) {
					try {
						if (row.getCell(j) != null) {
							excelRow.getCells().add(row.getCell(j).getStringCellValue());
						} else {
							excelRow.getCells().add(" ");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return excelRow;
	}
}
