package com.yodes.excel.web.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.yodes.excel.web.controller.CompareController;

public class Utils {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CompareController.class);

	public static String getCsvServerIdList(List<Integer> integers) {
		logger.warn("generating csv");
		StringBuilder sb = new StringBuilder();
		if (integers != null) {
			for (Integer integer : integers) {
				if (integer != null) {
					sb.append(integer + ", ");
				}
			}
			if (sb.length() > 1) {
				sb.replace(sb.length() - 2, sb.length(), "");
			}
		}
		return sb.toString();
	}

	public static List<Integer> getCsvListIntFromString(String listOfInts) {
		logger.warn("retreiving csv");
		List<Integer> intsList = new ArrayList<Integer>();
		if (listOfInts != null && !listOfInts.isEmpty()) {
			String[] ints = listOfInts.split(", ");
			for (String intValue : ints) {
				intsList.add(Integer.parseInt(intValue));
			}
		}
		return intsList;
	}

}
