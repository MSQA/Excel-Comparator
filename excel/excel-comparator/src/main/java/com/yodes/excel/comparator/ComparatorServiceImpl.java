package com.yodes.excel.comparator;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.yodes.excel.comparator.comparators.Comparator;
import com.yodes.excel.model.ComparatorResult;

/**
 * Service to compare files. Currently supported formats listed below
 * <p>
 * <ul>
 * <li>HSSF Spreadsheets (excel 2003)</li>
 * <li>XSSF Spreadsheets (excel 2007)</li>
 * </ul>
 */
@Service
public class ComparatorServiceImpl implements ComparatorService, InitializingBean {

	@Autowired
	private List<Comparator> comparators;

	public ComparatorResult compareReports(File origional, File current) throws Exception {
		ComparatorResult comparitorResult = new ComparatorResult();
		comparitorResult.setFirstFileName(origional.getName());
		comparitorResult.setSecondFileName(current.getName());
		boolean compared = Boolean.FALSE;
		for (Comparator comparator : comparators) {
			if (!compared && comparator.isComparator(origional, current)) {
				comparator.compare(origional, current, comparitorResult);
				compared = Boolean.TRUE;
			}
		}
		return comparitorResult;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notEmpty(comparators, "Autowiring of comparators is empty");
	}

}
