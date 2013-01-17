/**
 * This code is copyright (c) 2012 EMC Corporation
 */
package com.yodes.excel.comparitor;

import java.io.File;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.yodes.excel.comparitor.model.ComparitorResult;
import com.yodes.excel.comparitor.util.FileUtil;

/**
 * ELA Remediation Report Service
 */
public class ComparitorServiceImpl implements ComparitorService {

	BasicComparitor rc = new BasicComparitor();

	public ComparitorResult compareRsrReport(File origional, File current) throws Exception {
		ComparitorResult comparitorResult = new ComparitorResult();
		HSSFWorkbook origionalWorkBook = FileUtil.getHSSFWorkbook(origional);
		HSSFWorkbook currentWorkBook = FileUtil.getHSSFWorkbook(current);
		comparitorResult.setFirstFileName(origional.getName());
		comparitorResult.setSecondFileName(current.getName());
		return rc.compare(origionalWorkBook, currentWorkBook, comparitorResult);
	}
}
