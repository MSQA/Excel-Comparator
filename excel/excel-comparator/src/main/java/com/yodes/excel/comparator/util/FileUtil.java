package com.yodes.excel.comparator.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileUtil {

	/**
	 * Create a workbook from the excelFile
	 * 
	 * @param outFile
	 *            The excel output
	 */
	public static HSSFWorkbook getHSSFWorkbook(File outFile) throws IOException {
		// create and input stream
		FileInputStream input = new FileInputStream(outFile);
		// Create a POIFSFileSystem object
		POIFSFileSystem fileSystem = new POIFSFileSystem(input);
		// Create a workbook using the File System
		return new HSSFWorkbook(fileSystem);
	}

	/**
	 * Create a workbook from the excelFile
	 * 
	 * @param outFile
	 *            The excel output
	 */
	public static XSSFWorkbook getXSSFWorkbook(File outFile) throws IOException {
		// create and input stream
		FileInputStream input = new FileInputStream(outFile);

		// Create a workbook using the File System
		return new XSSFWorkbook(input);
	}
}
