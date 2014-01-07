package com.yodes.excel.comparator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.yodes.excel.api.model.ComparatorResult;
import com.yodes.excel.comparator.comparators.Comparator;

public class ComparatorServiceImplTest {

	private ComparatorServiceImpl comparator;

	private Comparator mockComparator;

	@Before
	public void setup() {
		List<Comparator> comparitors = new ArrayList<Comparator>();
		mockComparator = EasyMock.createMock(Comparator.class);
		comparitors.add(mockComparator);
		comparator = new ComparatorServiceImpl(comparitors);
	}

	@Test
	public void testComparing() {
		File origional = new File("target/test-classes/2003_origional.xls");
		File updated = new File("target/test-classes/2003_updated.xls");

		EasyMock.expect(mockComparator.isComparator(origional, updated)).andReturn(Boolean.TRUE);

		mockComparator.compare(EasyMock.anyObject(File.class), EasyMock.anyObject(File.class),
				EasyMock.anyObject(ComparatorResult.class));

		EasyMock.expectLastCall();
		EasyMock.replay(mockComparator);
		ComparatorResult result = comparator.compareReports(origional, updated);
		EasyMock.verify(mockComparator);
		TestCase.assertTrue(result.isCompared());
	}

	@Test
	public void testNoValidComparator() {
		File origional = new File("target/test-classes/2003_origional.xls");
		File updated = new File("target/test-classes/2003_updated.xls");
		EasyMock.expect(mockComparator.isComparator(origional, updated)).andReturn(Boolean.FALSE);
		EasyMock.replay(mockComparator);
		ComparatorResult result = comparator.compareReports(origional, updated);
		EasyMock.verify(mockComparator);
		TestCase.assertFalse(result.isCompared());
	}

	@Test
	public void testAutowiring() throws Exception {
		comparator.afterPropertiesSet();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAutowiringNull() throws Exception {
		comparator = new ComparatorServiceImpl(null);
		comparator.afterPropertiesSet();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAutowiringEmpty() throws Exception {
		comparator = new ComparatorServiceImpl(new ArrayList<Comparator>());
		comparator.afterPropertiesSet();
	}

}
