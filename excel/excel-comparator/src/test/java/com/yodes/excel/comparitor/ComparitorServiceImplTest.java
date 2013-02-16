package com.yodes.excel.comparitor;

import java.io.File;

import junit.framework.TestCase;

import org.junit.Test;

import com.yodes.excel.comparitor.ComparitorServiceImpl;
import com.yodes.excel.comparitor.model.ComparitorResult;

public class ComparitorServiceImplTest {

	ComparitorServiceImpl cs = new ComparitorServiceImpl();

	@Test
	public void testCompare() throws Exception {
		File origional = new File("target/test-classes/2003_original.xls");
		File current = new File("target/test-classes/2003_updated.xls");
		ComparitorResult cr = cs.compareReports(origional, current);
		TestCase.assertTrue(cr.isDifferenceDetected());
		TestCase.assertEquals(0, cr.getExtraSheet().size());
		TestCase.assertEquals(1, cr.getMissingSheet().size());
		TestCase.assertEquals("ESX Servers", cr.getMissingSheet().get(0));
	}

	@Test
	public void testCompareEqual() throws Exception {
		File origional = new File("target/test-classes/2003_original.xls");
		File current = new File("target/test-classes/2003_original.xls");
		ComparitorResult cr = cs.compareReports(origional, current);
		TestCase.assertFalse(cr.isDifferenceDetected());
	}
}
