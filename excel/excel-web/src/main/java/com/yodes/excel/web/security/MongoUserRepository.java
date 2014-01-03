package com.yodes.excel.web.security;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yodes.excel.web.security.MongoUser;


public interface MongoUserRepository extends CrudRepository<MongoUser, String> {

	/**
	 * Returns specific MongoUser that matches the MongoUserName
	 * 
	 * @return {@link MongoUser} found MongoUser that matches MongoUserName
	 */
	MongoUser findByUsername(String username);

	/**
	 * Returns all instances of the type.
	 * 
	 * @return all entities
	 */
	List<MongoUser> findAll();

}
