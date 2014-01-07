package com.yodes.excel.comparator.comparators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import com.yodes.excel.api.model.ComparatorResult;
import com.yodes.excel.comparator.util.ComparatorUtils;
import com.yodes.excel.comparator.util.FileUtil;

/**
 * Comparator to detect and compare HSSF spreadsheets
 * 
 * @author Stephen Dillon
 */
@Service
public class HSSFComparator implements Comparator {

	private static final Logger logger = Logger.getLogger(HSSFComparator.class);

	private static final boolean debugEnabled = logger.isDebugEnabled();

	@Override
	public boolean isComparator(File origional, File current) {
		try {
			FileUtil.getHSSFWorkbook(origional);
			FileUtil.getHSSFWorkbook(current);
		} catch (OfficeXmlFileException ox) {
			return Boolean.FALSE;
		} catch (IOException e) {
			throw new RuntimeException("IOException checking if this is the correct comparator", e);
		}
		return Boolean.TRUE;
	}

	@Override
	public void compare(File origional, File current, ComparatorResult comparitorResult) {
		try {
			compare(FileUtil.getHSSFWorkbook(origional), FileUtil.getHSSFWorkbook(current), comparitorResult);
		} catch (Exception e) {
			throw new RuntimeException("Error comparing excel reports", e);
		}
	}

	protected ComparatorResult compare(HSSFWorkbook origional, HSSFWorkbook current, ComparatorResult comparitorResult)
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

	private void compareSheets(ComparatorResult comparitorResult, HSSFSheet origional, HSSFSheet current) {
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

	protected void compareRow(ComparatorResult comparitorResult, HSSFRow origionalRow, HSSFRow currentRow) {
		if (origionalRow != null && currentRow != null) {
			if (origionalRow.getLastCellNum() != -1) {
				for (int j = 0; j < origionalRow.getLastCellNum(); j++) {
					if (origionalRow.getCell(j) != null && currentRow.getCell(j) != null) {
						try {
							HSSFRichTextString orgionalString = origionalRow.getCell(j).getRichStringCellValue();
							HSSFRichTextString currentString = currentRow.getCell(j).getRichStringCellValue();
							if (debugEnabled) {
								logger.debug("Comparing cells " + orgionalString.getString() + " : "
										+ currentString.getString());
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
		return Ordered.LOWEST_PRECEDENCE;
	}

}
