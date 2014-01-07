package com.yodes.excel.dao;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yodes.excel.api.model.Report;
import com.yodes.excel.api.model.dao.ReportRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:test-dao-context.xml"
})
public class ReportRepositoryTest {

	@Autowired
	private ReportRepository reportRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Before
	public void setup() {
		mongoTemplate.dropCollection(Report.class);
	}

	@Test
	public void testreportRepositoryConstruction() {
		TestCase.assertNotNull(reportRepository);
	}

	@Test
	public void testAddReport() {
		Report report = createReport();
		reportRepository.save(report);
		List<Report> reports = reportRepository.findAll();
		TestCase.assertEquals(1, reports.size());
		Report dbReport = reports.get(0);
		TestCase.assertEquals(report.getDateAdded(), dbReport.getDateAdded());
		TestCase.assertEquals(report.getUserName(), dbReport.getUserName());
	}

	@Test
	public void testCreateReport() {
		Report report = createReport();
		reportRepository.save(report);
		List<Report> reports = reportRepository.findAll();
		TestCase.assertEquals(1, reports.size());
		TestCase.assertNotNull(report.getId());
		TestCase.assertEquals(report.getId(), reports.get(0).getId());
		Report retreivedReport = reports.get(0);
		TestCase.assertEquals(retreivedReport.getId(), report.getId());
	}

	@Test
	public void testDelete() {
		Report report = createReport();
		Report report2 = createReport();
		reportRepository.save(report);
		reportRepository.save(report2);
		reportRepository.delete(report.getId());
		TestCase.assertEquals(1, reportRepository.findAll().size());
	}

	private Report createReport() {
		Report report = new Report();
		report.setDateAdded("date1");
		report.setUserName("yoda");
		return report;
	}

}
