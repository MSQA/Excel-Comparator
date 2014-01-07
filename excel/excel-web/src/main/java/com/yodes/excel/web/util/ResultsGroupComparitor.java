package com.yodes.excel.web.util;

import java.util.Comparator;
import java.util.Date;

import com.yodes.excel.api.model.ResultsGroup;

public class ResultsGroupComparitor implements Comparator<ResultsGroup> {

	@Override
	public int compare(ResultsGroup rg1, ResultsGroup rg2) {
		if (rg1 == null) {
			return -1;
		}
		if (rg2 == null) {
			return 1;
		}
		if (rg1.getFormattedDate() == null) {
			return -1;
		}
		if (rg2.getFormattedDate() == null) {
			return 1;
		}
		Date rg1Date = DateHelper.getDate(rg1.getFormattedDate());
		Date rg2Date = DateHelper.getDate(rg2.getFormattedDate());
		return rg2Date.compareTo(rg1Date);
	}
}
