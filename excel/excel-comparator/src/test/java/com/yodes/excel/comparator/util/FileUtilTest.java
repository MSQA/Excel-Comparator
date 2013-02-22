package com.yodes.excel.comparator.util;

import java.io.File;
import java.io.IOException;

import org.apache.poi.POIXMLException;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.junit.Test;
import org.springframework.util.Assert;

public class FileUtilTest {

	private File hssfFile = new File("target/test-classes/2003_original.xls");

	private File xssfFile = new File("target/test-classes/2007_original.xlsx");

	@Test
	public void testValidHSSFFile() throws IOException {
		Assert.notNull(FileUtil.getHSSFWorkbook(hssfFile));
	}

	@Test(expected = OfficeXmlFileException.class)
	public void testInValidHSSFFile() throws IOException {
		Assert.notNull(FileUtil.getHSSFWorkbook(xssfFile));
	}

	@Test
	public void testValidXSSFFile() throws IOException {
		Assert.notNull(FileUtil.getXSSFWorkbook(xssfFile));
	}

	@Test(expected = POIXMLException.class)
	public void testInValidXSSFFile() throws IOException {
		Assert.notNull(FileUtil.getXSSFWorkbook(hssfFile));
	}

}
