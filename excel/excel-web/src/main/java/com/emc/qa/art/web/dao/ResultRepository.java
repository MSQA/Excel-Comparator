package com.emc.qa.art.web.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.emc.qa.art.web.model.Result;

public interface ResultRepository extends CrudRepository<Result, String> {

	/**
	 * Returns all instances of the type.
	 * 
	 * @return all entities
	 */
	List<Result> findAll();

	/**
	 * Returns all instances which match the label.
	 * 
	 * @return all entities
	 */
	List<Result> findByLabel(String label);

}
