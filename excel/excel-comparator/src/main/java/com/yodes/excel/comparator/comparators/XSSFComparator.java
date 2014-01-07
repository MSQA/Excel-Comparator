package com.yodes.excel.comparator.comparators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.POIXMLException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import com.yodes.excel.api.model.ComparatorResult;
import com.yodes.excel.comparator.util.ComparatorUtils;
import com.yodes.excel.comparator.util.FileUtil;

/**
 * Comparator to detect and compare XSSF spreadsheets
 * 
 * @author Stephen Dillon
 */
@Service
public class XSSFComparator implements Comparator {

	private static final Logger logger = Logger.getLogger(XSSFComparator.class);

	private static final boolean debugEnabled = logger.isDebugEnabled();

	@Override
	public boolean isComparator(File origional, File current) {
		try {
			FileUtil.getXSSFWorkbook(origional);
			FileUtil.getXSSFWorkbook(current);
		} catch (POIXMLException pme) {
			return Boolean.FALSE;
		} catch (IOException e) {
			throw new RuntimeException("IOException checking if this is the correct comparator", e);
		}
		return Boolean.TRUE;
	}

	@Override
	public void compare(File origional, File current, ComparatorResult comparitorResult) {
		try {
			compare(FileUtil.getXSSFWorkbook(origional), FileUtil.getXSSFWorkbook(current), comparitorResult);
		} catch (Exception e) {
			throw new RuntimeException("Error comparing excel reports", e);
		}
	}

	protected ComparatorResult compare(XSSFWorkbook origional, XSSFWorkbook current, ComparatorResult comparitorResult)
			throws Exception {
		if (debugEnabled) {
			logger.debug("Starting comparision of workbooks");
		}
		int numOfSheets = origional.getNumberOfSheets();
		int currentNumOfSheets = current.getNumberOfSheets();
		List<String> sheetNames = new ArrayList<String>();
		for (int position = 0; position < numOfSheets; position++) {
			logger.debug("Found sheet : " + origional.getSheetName(position));
			sheetNames.add(origional.getSheetName(position));
		}
		List<String> currentSheetNames = new ArrayList<String>();
		for (int position = 0; position < currentNumOfSheets; position++) {
			currentSheetNames.add(current.getSheetName(position));
		}
		for (String origionalSheet : sheetNames) {
			if (!currentSheetNames.contains(origionalSheet)) {
				logger.info("Detected missing sheet : " + origionalSheet);
				comparitorResult.addMissingSheet(origionalSheet);
			}
		}
		for (String origionalSheet : currentSheetNames) {
			if (!sheetNames.contains(origionalSheet)) {
				logger.info("Detected extra sheet : " + origionalSheet);
				comparitorResult.addExtraSheet(origionalSheet);
			}
		}

		for (String sheetName : currentSheetNames) {
			if (sheetNames.contains(sheetName)) {
				compareSheets(comparitorResult, origional.getSheet(sheetName), current.getSheet(sheetName));
			}
		}
		return comparitorResult;
	}

	private void compareSheets(ComparatorResult comparitorResult, XSSFSheet origional, XSSFSheet current) {
		if (debugEnabled) {
			logger.debug("Comparing sheets named : " + origional.getSheetName());
		}
		for (int i = 0; i < origional.getLastRowNum(); i++) {
			compareRow(comparitorResult, origional.getRow(i), current.getRow(i));
		}
		if (origional.getPhysicalNumberOfRows() > 0) {
			compareRow(comparitorResult, origional.getRow(0), current.getRow(0));
		}
	}

	protected void compareRow(ComparatorResult comparitorResult, XSSFRow origionalRow, XSSFRow currentRow) {
		if (origionalRow != null && currentRow != null) {
			if (origionalRow.getLastCellNum() != -1) {
				for (int j = 0; j < origionalRow.getLastCellNum(); j++) {
					if (origionalRow.getCell(j) != null && currentRow.getCell(j) != null) {
						try {
							String orgionalString = origionalRow.getCell(j).getStringCellValue();
							String currentString = currentRow.getCell(j).getStringCellValue();
							if (debugEnabled) {
								logger.debug("Comparing cells " + orgionalString + " : " + currentString);
							}
							if (!orgionalString.equals(currentString)) {
								comparitorResult.addConflictingRows(ComparatorUtils.convertToExcelRow(origionalRow),
										ComparatorUtils.convertToExcelRow(currentRow));
							}
						} catch (Exception e) {
							logger.error("Exception reading cell value from sheet", e);
						}
					}
				}
			}
		}
	}

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE + 1;
	}

}
