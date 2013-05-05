package com.yodes.excel.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yodes.excel.model.Report;

public interface ReportRepository extends CrudRepository<Report, String> {

	/**
	 * Returns all instances of the type.
	 * 
	 * @return all entities
	 */
	List<Report> findAll();

}
