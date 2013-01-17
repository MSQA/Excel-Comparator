package com.emc.qa.art.web.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.emc.qa.art.web.model.Report;

public interface ReportRepository extends CrudRepository<Report, String> {

	/**
	 * Returns all instances of the type.
	 * 
	 * @return all entities
	 */
	List<Report> findAll();

}
