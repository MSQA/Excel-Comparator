package com.yodes.excel.comparitor.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;

public class ComparitorResult {

	private boolean differenceDetected;

	private String firstFileName;

	private String secondFileName;

	private List<String> missingSheet = new ArrayList<String>();

	private List<String> extraSheet = new ArrayList<String>();

	private List<ExcelRow> missingRows = new LinkedList<ExcelRow>();

	private List<ExcelRow> extraRows = new LinkedList<ExcelRow>();

	private List<ExcelRow> conflictingRows = new LinkedList<ExcelRow>();

	public void addMissingSheet(String sheetName) {
		missingSheet.add(sheetName);
		differenceDetected = Boolean.TRUE;
	}

	public void addExtraSheet(String sheetName) {
		extraSheet.add(sheetName);
		differenceDetected = Boolean.TRUE;
	}

	public void addMissingRow(HSSFRow missingRow) {
		missingRows.add(convertToExcelRow(missingRow));
		differenceDetected = Boolean.TRUE;
	}

	public void addExtraRow(HSSFRow extraRow) {
		extraRows.add(convertToExcelRow(extraRow));
		differenceDetected = Boolean.TRUE;
	}

	public void addConflictingRows(HSSFRow origional, HSSFRow current) {
		conflictingRows.add(convertToExcelRow(origional));
		conflictingRows.add(convertToExcelRow(current));
	}

	private ExcelRow convertToExcelRow(HSSFRow row) {
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

	/**
	 * @param missingSheet
	 *            the missingSheet to set
	 */
	public void setMissingSheet(List<String> missingSheet) {
		this.missingSheet = missingSheet;
	}

	/**
	 * @return the missingSheet
	 */
	public List<String> getMissingSheet() {
		return missingSheet;
	}

	/**
	 * @param extraSheet
	 *            the extraSheet to set
	 */
	public void setExtraSheet(List<String> extraSheet) {
		this.extraSheet = extraSheet;
	}

	/**
	 * @return the extraSheet
	 */
	public List<String> getExtraSheet() {
		return extraSheet;
	}

	/**
	 * @param missingRows
	 *            the missingRows to set
	 */
	public void setMissingRows(List<ExcelRow> missingRows) {
		this.missingRows = missingRows;
	}

	/**
	 * @return the missingRows
	 */
	public List<ExcelRow> getMissingRows() {
		return missingRows;
	}

	/**
	 * @param extraRows
	 *            the extraRows to set
	 */
	public void setExtraRows(List<ExcelRow> extraRows) {
		this.extraRows = extraRows;
	}

	/**
	 * @return the extraRows
	 */
	public List<ExcelRow> getExtraRows() {
		return extraRows;
	}

	/**
	 * @param conflictingRows
	 *            the conflictingRows to set
	 */
	public void setConflictingRows(List<ExcelRow> conflictingRows) {
		this.conflictingRows = conflictingRows;
	}

	/**
	 * @return the conflictingRows
	 */
	public List<ExcelRow> getConflictingRows() {
		return conflictingRows;
	}

	/**
	 * @return the firstFileName
	 */
	public String getFirstFileName() {
		return firstFileName;
	}

	/**
	 * @param firstFileName
	 *            the firstFileName to set
	 */
	public void setFirstFileName(String firstFileName) {
		this.firstFileName = firstFileName;
	}

	/**
	 * @return the secondFileName
	 */
	public String getSecondFileName() {
		return secondFileName;
	}

	/**
	 * @param secondFileName
	 *            the secondFileName to set
	 */
	public void setSecondFileName(String secondFileName) {
		this.secondFileName = secondFileName;
	}

	public boolean isDifferenceDetected() {
		return differenceDetected;
	}

	public void setDifferenceDetected(boolean differenceDetected) {
		this.differenceDetected = differenceDetected;
	}
}
