package com.yodes.excel.comparator;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yodes.excel.api.service.ComparatorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:excel-comparator-applicationContext.xml"
})
public class ComparatorServiceExcel2003IT {
	
	// TODO update these tests

	@Autowired
	ComparatorService cs;

	// @Test
	// public void testCompare() throws Exception {
	// File origional = new File("target/test-classes/2003_original.xls");
	// File current = new File("target/test-classes/2003_updated.xls");
	// ComparatorResult cr = cs.compareReports(origional, current);
	// TestCase.assertTrue(cr.isDifferenceDetected());
	// TestCase.assertEquals(0, cr.getExtraSheet().size());
	// TestCase.assertEquals(0, cr.getMissingSheet().size());
	// TestCase.assertEquals("test file", cr.getConflictingRows().get(0).getCells().get(0));
	// }
	//
	// @Test
	// public void testCompareEqual() throws Exception {
	// File origional = new File("target/test-classes/2003_original.xls");
	// File current = new File("target/test-classes/2003_original.xls");
	// ComparatorResult cr = cs.compareReports(origional, current);
	// TestCase.assertFalse(cr.isDifferenceDetected());
	// }
}
