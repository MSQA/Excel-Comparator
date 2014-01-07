package com.yodes.excel.web.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yodes.excel.api.model.Report;
import com.yodes.excel.api.service.ComparatorService;
import com.yodes.excel.web.Setup;

public class MessageProxyTest extends Setup {

	@Autowired
	private ComparatorService comparatorService;

	@Test
	public void getAccount() throws Exception {
		comparatorService.compareReports(new Report());
	}
}
