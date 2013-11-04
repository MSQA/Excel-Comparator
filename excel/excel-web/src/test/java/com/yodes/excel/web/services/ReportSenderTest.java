package com.yodes.excel.web.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yodes.excel.model.Report;
import com.yodes.excel.web.service.ReportSender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ReportSenderTest {

	@Autowired
	private ReportSender reportSender;

	@Test
	public void testSendReport() {
		Report report = new Report();
		report.setId("Test Id 1");
		report.setIdLastValidated("Last validated Id");
		report.setStatusLastRun(false);
		report.setUserName("Test User Jim");
		report.setZipLocation("90210");
		report.setZipName("Test Zip Name");
		reportSender.sendReport(report);
	}

}
