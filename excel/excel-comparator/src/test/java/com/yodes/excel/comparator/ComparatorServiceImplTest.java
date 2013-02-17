package com.yodes.excel.comparator;

import java.io.File;

import junit.framework.TestCase;

import org.junit.Test;

import com.yodes.excel.comparator.ComparatorServiceImpl;
import com.yodes.excel.comparator.model.ComparatorResult;

public class ComparatorServiceImplTest {

	ComparatorServiceImpl cs = new ComparatorServiceImpl();

	@Test
	public void testCompare() throws Exception {
		File origional = new File("target/test-classes/2003_original.xls");
		File current = new File("target/test-classes/2003_updated.xls");
		ComparatorResult cr = cs.compareReports(origional, current);
		TestCase.assertTrue(cr.isDifferenceDetected());
		TestCase.assertEquals(0, cr.getExtraSheet().size());
		TestCase.assertEquals(1, cr.getMissingSheet().size());
		TestCase.assertEquals("ESX Servers", cr.getMissingSheet().get(0));
	}

	@Test
	public void testCompareEqual() throws Exception {
		File origional = new File("target/test-classes/2003_original.xls");
		File current = new File("target/test-classes/2003_original.xls");
		ComparatorResult cr = cs.compareReports(origional, current);
		TestCase.assertFalse(cr.isDifferenceDetected());
	}
}
