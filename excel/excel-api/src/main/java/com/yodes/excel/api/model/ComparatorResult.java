package com.yodes.excel.api.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO javadoc
 */
public class ComparatorResult {

	private boolean compared;

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

	public void addMissingRow(ExcelRow missingRow) {
		missingRows.add(missingRow);
		differenceDetected = Boolean.TRUE;
	}

	public void addExtraRow(ExcelRow extraRow) {
		extraRows.add(extraRow);
		differenceDetected = Boolean.TRUE;
	}

	public void addConflictingRows(ExcelRow origional, ExcelRow current) {
		differenceDetected = Boolean.TRUE;
		conflictingRows.add(origional);
		conflictingRows.add(current);
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

	public boolean isCompared() {
		return compared;
	}

	public void setCompared(boolean compared) {
		this.compared = compared;
	}
}
