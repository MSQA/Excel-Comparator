package com.yodes.excel.web.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yodes.excel.api.model.Report;
import com.yodes.excel.api.model.dao.FileRepository;
import com.yodes.excel.api.model.dao.ReportRepository;
import com.yodes.excel.api.service.ComparatorService;
import com.yodes.excel.web.model.CommonsMultipartFiles;

/**
 * Handles requests for the compare page and the root page TODO add welcome page for root page
 */
@RequestMapping({
		"compare", ""
})
@Controller
public class CompareController implements InitializingBean {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CompareController.class);

	private File compareFolder = new File("C:/filestore/compare/");

	@Autowired
	private ComparatorService comparatorService;

	@Autowired
	private ReportRepository reportRepository;

	@Autowired
	private FileRepository fileRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String compare(Model model) {
		logger.info("Compare controller get request");
		return "compare";
	}

	@RequestMapping(method = RequestMethod.POST)
	public void compare(CommonsMultipartFiles compare, HttpServletResponse response) throws IOException {
		logger.info(compare.getNewFile().getOriginalFilename());
		logger.info(compare.getOriginalFile().getOriginalFilename());
		String reportId = UUID.randomUUID().toString();

		CommonsMultipartFile originalFile = compare.getOriginalFile();
		String originalFileId = fileRepository.save(originalFile.getInputStream(), originalFile.getName());

		CommonsMultipartFile newFile = compare.getNewFile();
		String newFileId = fileRepository.save(newFile.getInputStream(), newFile.getName());

		Report report = saveReport(reportId, originalFileId, newFileId);

		comparatorService.compareReports(report);
		response.sendRedirect("results");
	}

	private Report saveReport(String reportId, String originalFileId, String newFileId) {
		Report report = new Report();
		report.setId(reportId);
		Date currentDate = Calendar.getInstance().getTime();
		report.setDateAdded(DateFormat.getDateInstance().format(currentDate));

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			report.setUserName(auth.getName());
		}
		reportRepository.save(report);
		return report;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(reportRepository);
		if (!compareFolder.exists()) {
			compareFolder.mkdirs();
			logger.info("Creating location to store results C:/filestore/compare/");
		}
	}
}
