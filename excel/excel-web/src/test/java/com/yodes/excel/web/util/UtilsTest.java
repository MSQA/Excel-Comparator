package com.yodes.excel.web.util;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testGetCsvServerIdList() {
		List<Integer> ints = new LinkedList<Integer>();
		ints.add(51234);
		ints.add(21235);
		String intsString = Utils.getCsvServerIdList(ints);
		TestCase.assertEquals("51234, 21235", intsString);
	}

	@Test
	public void testGetCsvListIntFromString() {
		List<Integer> ints = Utils.getCsvListIntFromString("51234, 21235");
		TestCase.assertTrue(ints.contains(51234));
		TestCase.assertTrue(ints.contains(21235));
	}

}
