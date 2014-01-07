package com.yodes.excel.web.util;

import java.util.Comparator;

import com.yodes.excel.api.model.Result;

public class ResultsComparitor implements Comparator<Result> {

	@Override
	public int compare(Result results1, Result results2) {
		if (results1 == null) {
			return -1;
		}
		if (results2 == null) {
			return 1;
		}
		if (results1.getName() == null) {
			return -1;
		}
		if (results2.getName() == null) {
			return 1;
		}
		return results1.getName().compareTo(results2.getName());
	}
}
