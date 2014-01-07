package com.yodes.excel.web.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodes.excel.api.model.EnumType;
import com.yodes.excel.api.model.Result;
import com.yodes.excel.api.model.ResultsGroup;
import com.yodes.excel.api.model.dao.ResultRepository;
import com.yodes.excel.web.util.ResultsComparitor;
import com.yodes.excel.web.util.ResultsGroupComparitor;

/**
 * Handles requests for the results page
 */
@Controller
public class ResultsController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ResultsController.class);

	@Autowired
	private ResultRepository resultRepository;

	public ResultsController() {
		logger.info("initialising results controller");
	}

	@RequestMapping(value = "results", method = RequestMethod.GET)
	public void getResults(Model model) {
		logger.info("Results controller get request");
		populateModelWithResults(model, null);
	}

	@RequestMapping(value = "/results/{label}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	List<Result> runResult(@PathVariable String label, Model data) {
		logger.info("Ajax request for label : " + label);
		return resultRepository.findByLabel(label);
	}

	public void populateModelWithResults(Model model, String displayUUID) {
		List<Result> results = resultRepository.findAll();
		List<ResultsGroup> resultsGroup = sortReports(results);
		List<ResultsGroup> nightly = nightlyReports(resultsGroup);
		List<ResultsGroup> onDemand = onDemandReports(resultsGroup);
		List<ResultsGroup> onCompare = onCompareReports(resultsGroup);
		logger.info("resultsDao returned " + results.size() + " results");
		model.addAttribute("nightly", nightly);
		model.addAttribute("onDemand", onDemand);
		model.addAttribute("onCompare", onCompare);
		if (displayUUID == null || displayUUID.isEmpty()) {
			model.addAttribute("showUUID", displayUUID);
		}
	}

	protected List<ResultsGroup> nightlyReports(List<ResultsGroup> rgs) {
		List<ResultsGroup> returning = new LinkedList<ResultsGroup>();
		for (ResultsGroup rg : rgs) {
			if (EnumType.NIGHTLY.equals(rg.getResults().get(0).getRunType())) {
				returning.add(rg);
			}
		}
		return returning;
	}

	protected List<ResultsGroup> onDemandReports(List<ResultsGroup> rgs) {
		List<ResultsGroup> returning = new LinkedList<ResultsGroup>();
		for (ResultsGroup rg : rgs) {
			if (EnumType.ONDEMAND.equals(rg.getResults().get(0).getRunType())) {
				returning.add(rg);
			}
		}
		return returning;
	}

	protected List<ResultsGroup> onCompareReports(List<ResultsGroup> rgs) {
		List<ResultsGroup> returning = new LinkedList<ResultsGroup>();
		for (ResultsGroup rg : rgs) {
			if (EnumType.COMPARE.equals(rg.getResults().get(0).getRunType())) {
				returning.add(rg);
			}
		}
		return returning;
	}

	protected List<ResultsGroup> sortReports(List<Result> results) {
		Map<String, ResultsGroup> resultsGroupList = new HashMap<String, ResultsGroup>();
		for (Result result : results) {
			String label = result.getLabel();
			ResultsGroup rg = resultsGroupList.get(label);
			if (rg == null) {
				rg = new ResultsGroup();
				rg.setLabel(label);
				rg.setResult(Boolean.TRUE);
				resultsGroupList.put(label, rg);
				rg.setFormattedDate(result.getDate());
			}
			rg.getResults().add(result);
			if (!result.getResultStatus()) {
				rg.setResult(Boolean.FALSE);
			}
		}
		List<ResultsGroup> resultsGroups = new ArrayList<ResultsGroup>();
		for (ResultsGroup resultsGroup : resultsGroupList.values()) {
			Collections.sort(resultsGroup.getResults(), new ResultsComparitor());
			resultsGroups.add(resultsGroup);
		}
		Collections.sort(resultsGroups, new ResultsGroupComparitor());
		return resultsGroups;
	}

}
