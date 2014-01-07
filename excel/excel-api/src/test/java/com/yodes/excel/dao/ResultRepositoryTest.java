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

import com.yodes.excel.api.model.ComparatorResult;
import com.yodes.excel.api.model.EnumType;
import com.yodes.excel.api.model.ExcelRow;
import com.yodes.excel.api.model.Result;
import com.yodes.excel.api.model.dao.ResultRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:test-dao-context.xml"
})
public class ResultRepositoryTest {

	@Autowired
	private ResultRepository resultRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Before
	public void setup() {
		mongoTemplate.dropCollection(Result.class);
	}

	@Test
	public void testResultsDaoConstruction() {
		TestCase.assertNotNull(resultRepository);
	}

	@Test
	public void testAddResult() {
		Result result = createResult();
		resultRepository.save(result);
		List<Result> results = resultRepository.findAll();
		TestCase.assertEquals(1, results.size());
		Result dbResult = results.get(0);
		TestCase.assertEquals(result.getDate(), dbResult.getDate());
		TestCase.assertEquals(result.getHtmlReportLocation(), dbResult.getHtmlReportLocation());
		TestCase.assertEquals(result.getHtmlResult(), dbResult.getHtmlResult());
		TestCase.assertEquals(result.getLabel(), dbResult.getLabel());
		TestCase.assertNotNull(result.getCompareResult());
	}

	@Test
	public void testCreateResult() {
		Result result = createResult();
		resultRepository.save(result);
		List<Result> results = resultRepository.findAll();
		TestCase.assertEquals(1, results.size());
		TestCase.assertNotNull(result.getId());
		TestCase.assertEquals(result.getId(), results.get(0).getId());
		Result retreivedResult = results.get(0);
		TestCase.assertEquals(retreivedResult.getId(), result.getId());
		TestCase.assertEquals(retreivedResult.getRsrReportLocation(), result.getRsrReportLocation());
	}

	@Test
	public void testDelete() {
		Result result = createResult();
		Result result2 = createResult();
		result2.setRsrReportLocation("location 2");
		resultRepository.save(result);
		resultRepository.save(result2);
		resultRepository.delete(result.getId());
		TestCase.assertEquals(1, resultRepository.findAll().size());
		TestCase.assertEquals("location 2", resultRepository.findOne(result2.getId()).getRsrReportLocation());
	}

	@Test
	public void testFindByLabel() {
		Result result1 = createResult();
		Result result2 = createResult();
		result2.setLabel("label2");
		Result result3 = createResult();
		resultRepository.save(result1);
		resultRepository.save(result2);
		resultRepository.save(result3);
		List<Result> results = resultRepository.findByLabel("label1");
		TestCase.assertEquals(2, results.size());

	}

	private Result createResult() {
		Result result = new Result();
		result.setDate("date1");
		result.setHtmlIdToCompareTo(1);
		result.setHtmlReportLocation("html1");
		result.setHtmlResult("htmlresult1");
		result.setLabel("label1");
		result.setName("name1");
		result.setResultStatus(Boolean.TRUE);
		result.setRsrIdToCompareTo(2);
		result.setRsrReportLocation("rsrlocation");
		result.setRunType(EnumType.COMPARE);
		ComparatorResult compareResult = new ComparatorResult();
		compareResult.setDifferenceDetected(Boolean.TRUE);
		compareResult.getConflictingRows().add(new ExcelRow());
		compareResult.getConflictingRows().add(new ExcelRow());
		result.setCompareResult(compareResult);
		return result;
	}
}
