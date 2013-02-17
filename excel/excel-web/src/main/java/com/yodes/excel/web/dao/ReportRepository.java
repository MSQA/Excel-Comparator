package com.yodes.excel.web.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yodes.excel.web.model.Report;

public interface ReportRepository extends CrudRepository<Report, String> {

	/**
	 * Returns all instances of the type.
	 * 
	 * @return all entities
	 */
	List<Report> findAll();

}
