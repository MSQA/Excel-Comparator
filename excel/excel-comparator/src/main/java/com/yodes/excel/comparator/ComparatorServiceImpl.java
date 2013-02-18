/**
 * This code is copyright (c) 2012 EMC Corporation
 */
package com.yodes.excel.comparator;

import java.io.File;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yodes.excel.comparator.model.ComparatorResult;
import com.yodes.excel.comparator.util.FileUtil;

/**
 * ELA Remediation Report Service
 */
@Service
public class ComparatorServiceImpl implements ComparatorService {

	@Autowired
	private Comparator rc;

	public ComparatorResult compareReports(File origional, File current) throws Exception {
		ComparatorResult comparitorResult = new ComparatorResult();
		HSSFWorkbook origionalWorkBook = FileUtil.getHSSFWorkbook(origional);
		HSSFWorkbook currentWorkBook = FileUtil.getHSSFWorkbook(current);
		comparitorResult.setFirstFileName(origional.getName());
		comparitorResult.setSecondFileName(current.getName());
		return rc.compare(origionalWorkBook, currentWorkBook, comparitorResult);
	}
}
