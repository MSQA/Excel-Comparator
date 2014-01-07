package com.yodes.excel.api.model;

import java.util.LinkedList;
import java.util.List;

public class ExcelRow {

	private List<String> cells = new LinkedList<String>();

	/**
	 * @return the cells
	 */
	public List<String> getCells() {
		return cells;
	}

	/**
	 * @param cells
	 *            the cells to set
	 */
	public void setCells(List<String> cells) {
		this.cells = cells;
	}

}
