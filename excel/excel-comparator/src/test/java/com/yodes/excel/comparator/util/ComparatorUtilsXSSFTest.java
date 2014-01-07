package com.yodes.excel.comparator.util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.junit.Test;
import org.springframework.util.Assert;

import com.yodes.excel.api.model.ExcelRow;

public class ComparatorUtilsXSSFTest {

	@Test
	public void testConvertToExcelRowNullXssf() {
		XSSFRow nullRowXssf = null;
		Assert.notNull(ComparatorUtils.convertToExcelRow(nullRowXssf));
	}

	@Test
	public void testConvertToExcelCellNull() {
		XSSFCell nullcell = null;
		ExcelRow excelRow = new ExcelRow();
		ComparatorUtils.convertXSSFCell(excelRow, nullcell);
	}
}
