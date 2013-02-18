package com.yodes.excel.comparator;

import java.io.File;

import junit.framework.TestCase;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yodes.excel.comparator.model.ComparatorResult;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:excel-comparator-applicationContext.xml"
})
@Ignore
public class Excel2007IT {

	@Autowired
	ComparatorService cs;

	@Test
	public void testCompare() throws Exception {
		File origional = new File("target/test-classes/2007_original.xlsx");
		File current = new File("target/test-classes/2007_updated.xlsx");
		ComparatorResult cr = cs.compareReports(origional, current);
		TestCase.assertTrue(cr.isDifferenceDetected());
		TestCase.assertEquals(0, cr.getExtraSheet().size());
		TestCase.assertEquals(1, cr.getMissingSheet().size());
		TestCase.assertEquals("ESX Servers", cr.getMissingSheet().get(0));
	}

	@Test
	public void testCompareEqual() throws Exception {
		File origional = new File("target/test-classes/2007_original.xlsx");
		File current = new File("target/test-classes/2007_original.xlsx");
		ComparatorResult cr = cs.compareReports(origional, current);
		TestCase.assertFalse(cr.isDifferenceDetected());
	}
}
