package com.yodes.excel.web.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.LoggerFactory;

import com.yodes.excel.web.controller.CompareController;

public class DateHelper {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CompareController.class);

	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public static String getDate() {
		return dateFormat.format(Calendar.getInstance().getTime());
	}

	public static Date getDate(String date) {
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			logger.error("Error parsing date", e);
			return Calendar.getInstance().getTime();
		}
	}
}
