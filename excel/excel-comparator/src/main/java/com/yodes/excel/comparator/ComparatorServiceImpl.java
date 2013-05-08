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
 * Service to compare excel files. Auto-wired of classes that implement {@link Comparator}
 */
@Service
public class ComparatorServiceImpl implements ComparatorService, InitializingBean {

	private List<Comparator> comparators;

	@Autowired
	public ComparatorServiceImpl(List<Comparator> comparators) {
		this.comparators = comparators;
	}

	public ComparatorResult compareReports(File origional, File current) {
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
		comparitorResult.setCompared(compared);
		return comparitorResult;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notEmpty(comparators, "Autowiring of comparators is empty");
	}

}
