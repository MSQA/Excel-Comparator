package com.emc.qa.art.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.emc.qa.art.web.dao.ResultRepository;
import com.emc.qa.art.web.model.Compare;
import com.emc.qa.art.web.model.EnumType;
import com.emc.qa.art.web.model.Result;
import com.emc.qa.art.web.util.DateHelper;
import com.yodes.excel.comparitor.ComparitorService;
import com.yodes.excel.comparitor.model.ComparitorResult;

/**
 * Handles requests for the compare page
 */
@RequestMapping("compare")
@Controller
public class CompareController implements InitializingBean {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CompareController.class);

	private File compareFolder = new File("C:/filestore/compare/");

	@Autowired
	private ComparitorService comparitorService;

	@Autowired
	private ResultsController resultsController;

	@Autowired
	private ResultRepository resultRepository;

	public CompareController() {
		compareFolder.mkdirs();
		logger.debug("Contructing compare controller and C:/filestore/compare/");
	}

	@RequestMapping(method = RequestMethod.GET)
	public void compare(Model model) {
		logger.info("Compare controller get request");
	}

	@RequestMapping(method = RequestMethod.POST)
	public String compare(Compare compare, Model model) {
		logger.info(compare.getNewFile().getOriginalFilename());
		logger.info(compare.getOriginalFile().getOriginalFilename());
		try {
			String resultUUID = UUID.randomUUID().toString();
			File origionalFile = getFileFromCommonsMultipartFile(compare.getOriginalFile(), resultUUID);
			File currentFile = getFileFromCommonsMultipartFile(compare.getNewFile(), resultUUID);
			ComparitorResult compareResult = comparitorService.compareRsrReport(origionalFile, currentFile);
			saveResult(compareResult, origionalFile.getName(), resultUUID);
			logger.info("Is error found in compare =  " + compareResult.isDifferenceDetected() + " with label : " + resultUUID);
			resultsController.populateModelWithResults(model, resultUUID);
			return "results";
		} catch (Exception e) {
			logger.error("Error running services", e);
		}
		return "compare";
	}

	protected File getFileFromCommonsMultipartFile(CommonsMultipartFile fileStream, String label) throws IllegalStateException, IOException {
		File folder = new File(compareFolder, label);
		folder.mkdirs();
		File origionalFile = new File(folder, fileStream.getOriginalFilename());
		fileStream.transferTo(origionalFile);
		return origionalFile;
	}

	protected void saveResult(ComparitorResult compareResult, String name, String label) {
		Result result = new Result();
		result.setResultStatus(!compareResult.isDifferenceDetected());
		result.setRunType(EnumType.COMPARE);
		result.setName(name);
		result.setDate(DateHelper.getDate());
		result.setLabel(label);
		result.setCompareResult(compareResult);
		resultRepository.save(result);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(resultRepository);
	}
}
