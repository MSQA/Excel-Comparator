package com.yodes.excel.comparator;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yodes.excel.comparator.model.ComparatorResult;

@Service
public class BasicComparator implements Comparator {

	private static final Logger logger = LoggerFactory.getLogger(BasicComparator.class);

	public ComparatorResult compare(HSSFWorkbook origional, HSSFWorkbook current, ComparatorResult comparitorResult) throws Exception {
		if (logger.isDebugEnabled()) {
			// TODO: create aspect for this
			logger.debug("Starting comparision of workbooks");
		}
		int numOfSheets = origional.getNumberOfSheets();
		int currentNumOfSheets = current.getNumberOfSheets();
		List<String> sheetNames = new ArrayList<String>();
		for (int position = 0; position < numOfSheets; position++) {
			sheetNames.add(origional.getSheetName(position));
		}
		List<String> currentSheetNames = new ArrayList<String>();
		for (int position = 0; position < currentNumOfSheets; position++) {
			currentSheetNames.add(current.getSheetName(position));
		}
		for (String origionalSheet : sheetNames) {
			if (!currentSheetNames.contains(origionalSheet)) {
				comparitorResult.addMissingSheet(origionalSheet);
			}
		}
		for (String origionalSheet : currentSheetNames) {
			if (!sheetNames.contains(origionalSheet)) {
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
		for (int i = 0; i < origional.getLastRowNum(); i++) {
			HSSFRow origionalRow = origional.getRow(i);
			HSSFRow currentRow = current.getRow(i);
			if (origionalRow != null && currentRow != null) {
				if (origionalRow.getLastCellNum() != -1) {
					for (int j = 0; j < origionalRow.getLastCellNum(); j++) {
						if (origionalRow.getCell(j) != null && currentRow.getCell(j) != null) {
							try {
								HSSFRichTextString orgionalString = origionalRow.getCell(j).getRichStringCellValue();
								HSSFRichTextString currentString = currentRow.getCell(j).getRichStringCellValue();
								if (!orgionalString.equals(currentString)) {
									comparitorResult.addConflictingRows(origionalRow, currentRow);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

}
