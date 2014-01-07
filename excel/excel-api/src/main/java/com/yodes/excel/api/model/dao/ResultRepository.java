package com.yodes.excel.api.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yodes.excel.api.model.Result;

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
