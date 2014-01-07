package com.yodes.excel.comparator.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.junit.Test;
import org.springframework.util.Assert;

import com.yodes.excel.api.model.ExcelRow;

public class ComparatorUtilsHSSFTest {

	@Test
	public void testConvertToExcelRowNull() {
		HSSFRow nullRow = null;
		Assert.notNull(ComparatorUtils.convertToExcelRow(nullRow));
	}

	@Test
	public void testConvertToExcelCellNull() {
		HSSFCell nullcell = null;
		ExcelRow excelRow = new ExcelRow();
		ComparatorUtils.convertHSSFCell(excelRow, nullcell);
	}

}
