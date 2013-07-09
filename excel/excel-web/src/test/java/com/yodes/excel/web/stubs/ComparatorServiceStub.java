package com.yodes.excel.web.stubs;

import java.io.File;

import org.springframework.stereotype.Service;

import com.yodes.excel.comparator.ComparatorService;
import com.yodes.excel.model.ComparatorResult;

@Service
public class ComparatorServiceStub implements ComparatorService {

	@Override
	public ComparatorResult compareReports(File arg0, File arg1) {
		return null;
	}

}
